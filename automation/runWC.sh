#/bin/sh

echo "Running wordcount example"

. ./configDefaults.sh

ARGS="$DOP $HDFS_WC $HDFS_WC_OUT"
echo "running wc with args $ARGS"
$STRATOSPHERE_BUILD_HOME"/bin/stratosphere" run -w -j $STRATOSPHERE_BUILD_HOME/examples/stratosphere-scala-examples-*-WordCount.jar -a $ARGS
