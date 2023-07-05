;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 948)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use File)
(use Actor)
(use System)

(local
	[local0 100]
	[local100 100]
	[local200 100]
	[local300 100]
	[local400 190]
	local590 = 1
	local591 = 1
	local592
	local593
)

(procedure (DoFeature obj &tmp event theX theY theTop theLeft theBottom theRight)
	(Print 948 10) ; "Click left mouse button on top left corner"
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(event dispose:)
	)
	(GlobalToLocal event)
	(= theTop (event y:))
	(= theLeft (event x:))
	(Print 948 11) ; "Click left mouse button on bottom right corner"
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(event dispose:)
	)
	(GlobalToLocal event)
	(= theBottom (event y:))
	(= theX (+ (/ (- (= theRight (event x:)) theLeft) 2) theLeft))
	(= theY (+ (/ (- theBottom theTop) 2) theTop))
	(obj
		x: theX
		y: theY
		nsLeft: theLeft
		nsTop: theTop
		nsBottom: theBottom
		nsRight: theRight
	)
	(if local591
		(Graph grDRAW_LINE theTop theLeft theTop theRight 1 15)
		(Graph grDRAW_LINE theBottom theLeft theBottom theRight 1 15)
		(Graph grDRAW_LINE theTop theLeft theBottom theLeft 1 15)
		(Graph grDRAW_LINE theTop theRight theBottom theRight 1 15)
		(Graph grUPDATE_BOX theTop theLeft theBottom theRight 1)
	)
	(event dispose:)
)

(procedure (DoView obj &tmp event)
	(obj
		view: (GetNumber {View?} 0)
		loop: (GetNumber {Loop?} 0)
		cel: (GetNumber {Cel?} 0)
		signal: 16400
		priority: 15
		init:
	)
	(if (obj respondsTo: #illegalBits)
		(obj illegalBits: 0)
	)
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(GlobalToLocal event)
		(obj posn: (event x:) (event y:))
		(Animate (gCast elements:) 0)
		(event dispose:)
	)
	(event dispose:)
)

(procedure (Logit what)
	(File name: @global63 writeString: what close:)
	(DisposeScript 993)
)

(procedure (DoProperties obj)
	(obj
		noun: (GetInput @local100 30 {/noun?})
		shiftClick: (GetVerb @local200 20 {shftClick verb?})
		contClick: (GetVerb @local300 20 {cntrlClick verb?})
		sightAngle: (GetNumber {sight angle?} 90)
		closeRangeDist: (GetNumber {getable dist?} 50)
		longRangeDist: (GetNumber {seeable dist?} 100)
		description: (GetInput @local400 50 {description?})
	)
)

(procedure (GetVerb theString theSize theTitle)
	(GetInput theString theSize theTitle)
	(return
		(cond
			((StrCmp theString {verbLook}) 1)
			((StrCmp theString {verbOpen}) 2)
			((StrCmp theString {verbClose}) 3)
			((StrCmp theString {verbSmell}) 4)
			((StrCmp theString {verbMove}) 5)
			((StrCmp theString {verbEat}) 6)
			((StrCmp theString {verbGet}) 7)
		)
	)
)

(class WriteCode
	(properties)

	(method (doit theObj &tmp [buffer 400] [vlcOrNsStr 40])
		(if (theObj isMemberOf: Feature)
			(Format ; "nsLeft %d    nsTop %d    nsBottom %d    nsRight %d"
				@vlcOrNsStr
				948
				0
				(theObj nsLeft:)
				(theObj nsTop:)
				(theObj nsBottom:)
				(theObj nsRight:)
			)
		else
			(Format @vlcOrNsStr 948 1 (theObj view:) (theObj loop:) (theObj cel:)) ; "view %d    loop %d    cel %d"
		)
		(Format ; "(instance %s of %s   (properties    x %d     y %d     z %d     heading %d     noun '%s'  %s   description "%s"     sightAngle %d     closeRangeDist %d     longRangeDist %d     shiftClick %s     contClick %s   ) )"
			@buffer
			948
			2
			@local0
			(if (== local593 2)
				(PicView name:)
			else
				((theObj superClass:) name:)
			)
			(theObj x:)
			(theObj y:)
			(theObj z:)
			(theObj heading:)
			@local100
			@vlcOrNsStr
			@local400
			(theObj sightAngle:)
			(theObj closeRangeDist:)
			(theObj longRangeDist:)
			@local200
			@local300
		)
		(if local590
			(Print @buffer #font 999 #title {Feature Writer V1.0})
		)
		(Logit @buffer)
		(if (theObj isMemberOf: Feature)
			(theObj dispose:)
		else
			(theObj addToPic:)
		)
	)

	(method (writeList theList)
		(theList eachElementDo: #perform self)
		(CreateObject doit:)
	)
)

(class CreateObject
	(properties)

	(method (doit &tmp [thePath 15] theType theObj)
		(if (not local592)
			(= thePath 0)
			(GetInput @thePath 30 {Enter path and filename})
			(Format @global63 @thePath)
			(Format @local200 948 3) ; "verbLook"
			(Format @local300 948 4) ; "verbGet"
			(switch
				(Print 948 5 #title {Feature Writer V1.0} #button {YES} 1 #button {NO} 2) ; "Outline Features?"
				(1
					(= local591 1)
				)
				(2
					(= local591 0)
				)
			)
			(switch
				(Print 948 6 #title {Feature Writer V1.0} #button {YES} 1 #button {NO} 2) ; "Display code to screen?"
				(1
					(= local590 1)
				)
				(2
					(= local590 0)
				)
			)
			(= local592 1)
		)
		(if
			(not
				(= local593
					(Print ; "Class?"
						948
						7
						#title
						{Feature Writer V1.0}
						#button
						{Feature}
						1
						#button
						{PicView}
						2
						#button
						{View}
						3
						#button
						{Prop}
						4
						#button
						{Actor}
						5
					)
				)
			)
			(return)
		)
		(= theType
			((switch local593
					(1 Feature)
					(2 View)
					(3 View)
					(4 Prop)
					(5 Actor)
				)
				new:
			)
		)
		(GetInput @local0 30 {Name?})
		(StrCpy @local400 @local0)
		(DoProperties theType)
		(if (== local593 1)
			(DoFeature theType)
		else
			(DoView theType)
		)
		(if (Print 948 8 #title {Feature Writer V1.0} #button {YES} 1 #button {NO} 0) ; "Z property"
			(Print 948 9) ; "Please click the mouse on the objects projection onto the ground"
			(while (!= ((= theObj (Event new:)) type:) evMOUSEBUTTON)
				(theObj dispose:)
			)
			(GlobalToLocal theObj)
			(theType z: (- (theObj y:) (theType y:)))
			(theType y: (theObj y:))
			(theObj dispose:)
		)
		(WriteCode doit: theType)
	)
)

