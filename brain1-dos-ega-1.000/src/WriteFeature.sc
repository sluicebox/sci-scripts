;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 948)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Window)
(use File)
(use Actor)
(use System)

(local
	[local0 200]
	[local200 100]
	local300 = { verbWalk   }
	[local301 7] = [{ verbLook   } { verbDo     } { verbUse    } { verbTalk   } { verbHelp   } { gameVerbs  } {}]
	local308 = 1
	local309 = 1
	local310
	local311
	local312 = 90
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(Print 948 11) ; "Click left mouse button on top left corner"
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(GlobalToLocal temp0)
	(= temp3 (temp0 y:))
	(= temp4 (temp0 x:))
	(temp0 dispose:)
	(Print 948 12) ; "Click left mouse button on bottom right corner"
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(GlobalToLocal temp0)
	(= temp5 (temp0 y:))
	(= temp1 (+ (/ (- (= temp6 (temp0 x:)) temp4) 2) temp4))
	(= temp2 (+ (/ (- temp5 temp3) 2) temp3))
	(param1
		x: temp1
		y: temp2
		nsLeft: temp4
		nsTop: temp3
		nsBottom: temp5
		nsRight: temp6
	)
	(if local309
		(Graph grDRAW_LINE temp3 temp4 temp3 temp6 1 15)
		(Graph grDRAW_LINE temp5 temp4 temp5 temp6 1 15)
		(Graph grDRAW_LINE temp3 temp4 temp5 temp4 1 15)
		(Graph grDRAW_LINE temp3 temp6 temp5 temp6 1 15)
		(Graph grUPDATE_BOX temp3 temp4 (+ temp5 1) (+ temp6 1) 1)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1 &tmp temp0)
	(param1
		view: (GetNumber {View?} 0)
		loop: (GetNumber {Loop?} 0)
		cel: (GetNumber {Cel?} 0)
		signal: 16400
		priority: 15
		init:
	)
	(if (param1 respondsTo: #illegalBits)
		(param1 illegalBits: 0)
	)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(GlobalToLocal temp0)
		(param1 posn: (temp0 x:) (temp0 y:))
		(Animate (gCast elements:) 0)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_2 param1)
	(File name: @gSysLogPath writeString: param1 close:)
	(DisposeScript 993)
)

(procedure (localproc_3 param1)
	(param1
		description: (GetInput @local200 40 {description?})
		sightAngle: (= local312 (GetNumber {sight angle?} local312))
		_approachVerbs: (aprchD init: local300)
	)
)

(procedure (localproc_4 param1 &tmp temp0)
	(Print 948 13) ; "Click left mouse button on approach point"
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 dispose:)
	)
	(GlobalToLocal temp0)
	(param1 approachX: (temp0 x:) approachY: (temp0 y:))
	(temp0 dispose:)
)

(instance aprchD of Dialog
	(properties
		text {Approach Verbs}
	)

	(method (init param1 &tmp temp0 temp1)
		(= window gSystemWindow)
		(= nsBottom 0)
		(selectorI text: param1 font: gSmallFont setSize: moveTo: 4 4 state: 1)
		(self add: selectorI setSize:)
		(textI
			text: {Space to select, enter when done.}
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= temp0 (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 temp0)
		(= temp1 (self add: textI setSize: center: open: 4 -1 doit:))
		(self dispose:)
		(if temp1
			(= temp0 0)
			(= temp1 0)
			(while (< temp0 7)
				(if (== (StrAt param1 (* temp0 13)) 62)
					(|= temp1 (<< $0001 temp0))
				)
				(++ temp0)
			)
		)
		(return temp1)
	)
)

(class WriteCode
	(properties)

	(method (doit theObj &tmp [temp0 400] [temp400 40] [temp440 20] [temp460 40])
		(if (theObj isMemberOf: Feature)
			(Format ; "nsTop %d  nsLeft %d  nsBottom %d  nsRight %d"
				@temp400
				948
				0
				(theObj nsTop:)
				(theObj nsLeft:)
				(theObj nsBottom:)
				(theObj nsRight:)
			)
		else
			(Format @temp400 948 1 (theObj view:) (theObj loop:) (theObj cel:)) ; "view %d  loop %d  cel %d"
		)
		(if (theObj z:)
			(Format @temp440 948 2 (theObj z:)) ; "z %d"
		else
			(= temp440 0)
		)
		(if (theObj _approachVerbs:)
			(Format ; "approachX %d   approachY %d   _approachVerbs $%x"
				@temp460
				948
				3
				(theObj approachX:)
				(theObj approachY:)
				(theObj _approachVerbs:)
			)
		else
			(= temp460 0)
		)
		(Format ; "(instance %s of %s  (properties  x %d   y %d  %s %s  description "%s"   sightAngle %d  %s ) )"
			@temp0
			948
			4
			@local0
			(if (== local311 2)
				(PicView name:)
			else
				((theObj superClass:) name:)
			)
			(theObj x:)
			(theObj y:)
			@temp440
			@temp400
			@local200
			(theObj sightAngle:)
			@temp460
		)
		(if local308
			(Print @temp0 #font 999 #title {Feature Writer V1.0})
		)
		(localproc_2 @temp0)
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

	(method (doit &tmp [temp0 15] temp15 temp16 temp17)
		(= temp17 gSystemWindow)
		(= gSystemWindow SysWindow)
		(if (not local310)
			(= temp0 0)
			(Format @temp0 948 5 (gCurRoom curPic:)) ; "%d.fea"
			(if (not (GetInput @temp0 30 {Enter path and filename}))
				(return)
			)
			(Format @gSysLogPath @temp0)
			(switch
				(Print 948 6 #title {Feature Writer V1.0} #button {YES} 1 #button {NO} 2) ; "Outline Features?"
				(0
					(return)
				)
				(1
					(= local309 1)
				)
				(2
					(= local309 0)
				)
			)
			(switch
				(Print 948 7 #title {Feature Writer V1.0} #button {YES} 1 #button {NO} 2) ; "Display code to screen?"
				(0
					(return)
				)
				(1
					(= local308 1)
				)
				(2
					(= local308 0)
				)
			)
			(= local310 1)
		)
		(if
			(not
				(= local311
					(Print ; "Class?"
						948
						8
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
		(= temp15
			((switch local311
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
		(StrCpy @local200 @local0)
		(localproc_3 temp15)
		(if (== local311 1)
			(localproc_0 temp15)
		else
			(localproc_1 temp15)
		)
		(if (temp15 _approachVerbs:)
			(localproc_4 temp15)
		)
		(if (Print 948 9 #title {Feature Writer V1.0} #button {NO} 0 #button {YES} 1) ; "Z property"
			(Print 948 10) ; "Please click the mouse on the objects projection onto the ground"
			(while (!= ((= temp16 (Event new:)) type:) evMOUSEBUTTON)
				(temp16 dispose:)
			)
			(GlobalToLocal temp16)
			(temp15 z: (- (temp16 y:) (temp15 y:)))
			(temp15 y: (temp16 y:))
			(temp16 dispose:)
		)
		(WriteCode doit: temp15)
		(= gSystemWindow temp17)
	)
)

(instance selectorI of DSelector
	(properties
		x 13
		y 7
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if
			(or
				(and (== (event type:) evMOUSEBUTTON) (event claimed:))
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			)
			(if (== (StrAt cursor 0) 62)
				(StrAt cursor 0 32)
			else
				(StrAt cursor 0 62)
			)
			(self draw:)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

