;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 948)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Dialog)
(use Feature)
(use Window)
(use File)
(use Actor)
(use System)

(local
	[local0 50]
	[local50 30]
	[local80 100]
	[local180 100]
	[local280 100]
	local380 = { WALK            }
	[local381 6] = [{ LOOK            } { DO              } { TALK            } { ASK             } { HELP            } {}]
	local387
	local388 = 1
	local389
	local390
	local391
	local392
	local393
)

(procedure (DoProperties obj)
	(obj sightAngle: (GetNumber {sight angle?} 40))
)

(procedure (DoFeature obj &tmp event theX theY theTop theLeft theBottom theRight)
	(Prints {Click left mouse button on top left corner})
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(event dispose:)
	)
	(GlobalToLocal event)
	(= theTop (event y:))
	(= theLeft (event x:))
	(event dispose:)
	(Prints {Click left mouse button on bottom right corner})
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(event dispose:)
	)
	(GlobalToLocal event)
	(= theBottom (event y:))
	(= theRight (event x:))
	(event dispose:)
	(= theX (+ (/ (- theRight theLeft) 2) theLeft))
	(= theY (+ (/ (- theBottom theTop) 2) theTop))
	(obj
		x: theX
		y: theY
		nsLeft: theLeft
		nsTop: theTop
		nsBottom: theBottom
		nsRight: theRight
	)
	(if local388
		(Graph grDRAW_LINE theTop theLeft theTop theRight 1 0)
		(Graph grDRAW_LINE theBottom theLeft theBottom theRight 1 0)
		(Graph grDRAW_LINE theTop theLeft theBottom theLeft 1 0)
		(Graph grDRAW_LINE theTop theRight theBottom theRight 1 0)
		(Graph grUPDATE_BOX theTop theLeft (+ theBottom 1) (+ theRight 1) 1)
	)
)

(procedure (DoView obj &tmp event)
	(obj
		view: (GetNumber {View?} (gCurRoom curPic:))
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

(procedure (DoApproach obj &tmp event eX eY [str 10] ad)
	(if
		(Print
			addText: {Where should the approach point be?}
			addButton: 1 {Select with mouse} 0 20
			addButton: 0 {Default to x, y} 0 34
			init:
		)
		(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
			(event dispose:)
		)
		(GlobalToLocal event)
		(obj approachX: (= eX (event x:)) approachY: (= eY (event y:)))
		(event dispose:)
		(Graph grDRAW_LINE (- eY 1) (- eX 1) (- eY 1) (+ eX 1) 7)
		(Graph grDRAW_LINE eY (- eX 1) eY (+ eX 1) 7)
		(Graph grDRAW_LINE (+ eY 1) (- eX 1) (+ eY 1) (+ eX 1) 7)
		(Graph grDRAW_LINE eY eX eY eX 0)
		(Graph grUPDATE_BOX (- eY 1) (- eX 1) (+ eY 2) (+ eX 2) 1)
	else
		(obj approachX: (obj x:) approachY: (obj y:))
	)
	(= str 0)
	(= ad
		(Print
			addText: {How far away must ego} 0 1
			addText: {be before he tries to approach?} 0 12
			addEdit: @str 5 -50 13
			addButton: 1 {Select with mouse} 0 32
			addButton: 0 {Always approach} 0 45
			init:
		)
	)
	(cond
		(str
			(obj approachDist: (ReadNumber @str))
		)
		((not ad)
			(obj approachDist: 0)
		)
		(else
			(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
				(event dispose:)
			)
			(GlobalToLocal event)
			(= eX (event x:))
			(= eY (event y:))
			(obj
				approachDist: (GetDistance (obj x:) (obj y:) eX eY)
			)
			(event dispose:)
			(Graph grDRAW_LINE (- eY 1) (- eX 1) (- eY 1) (+ eX 1) 28)
			(Graph grDRAW_LINE eY (- eX 1) eY (+ eX 1) 28)
			(Graph grDRAW_LINE (+ eY 1) (- eX 1) (+ eY 1) (+ eX 1) 28)
			(Graph grDRAW_LINE eY eX eY eX 52)
			(Graph grUPDATE_BOX (- eY 1) (- eX 1) (+ eY 2) (+ eX 2) 1)
		)
	)
)

(procedure (DoDoVerb)
	(= local391
		(Print
			addText: {doVerb method?}
			addButton: 1 {YES} 0 12
			addButton: 0 {NO} 50 12
			init:
		)
	)
)

(procedure (Logit what)
	(local393 name: @gSysLogPath writeString: what close:)
)

(class WriteCode
	(properties)

	(method (doit &tmp [temp0 15] temp15 temp16)
		(gGame setCursor: 999)
		(= local392 gSystemWindow)
		(= gSystemWindow wfWin)
		(if (not local389)
			(= temp0 0)
			(Format @temp0 {%d.fea} (gCurRoom curPic:))
			(if (not (GetInput @temp0 30 {Enter path and filename}))
				(return)
			else
				(Format @gSysLogPath @temp0)
				(= local388
					(Print
						addText: {Outline Features?}
						addTitle: {Feature Write V1.0}
						addButton: 1 {YES} 0 12
						addButton: 0 {NO} 50 12
						init:
					)
				)
				(= local387
					(Print
						addText: {Display code to screen? (but not doVerb)}
						addTitle: {Feature Write V1.0}
						addButton: 0 {NO} 0 18
						addButton: 1 {YES} 50 18
						init:
					)
				)
				(= local389 1)
			)
		)
		(if
			(not
				(= local390
					(Print
						addText: {Class?}
						addTitle: {Feature Writer V1.0}
						addButton: Feature {Feature} 0 12
						addButton: View {View} 73 12
						addButton: Prop {Prop} 113 12
						addButton: Actor {Actor} 153 12
						init:
					)
				)
			)
			(return)
		)
		(= temp15 (local390 new:))
		(= local0 0)
		(GetInput @local0 30 {Name?})
		(= local50 0)
		(GetInput @local50 16 {Noun?})
		(DoProperties temp15)
		(if (== local390 Feature)
			(DoFeature temp15)
		else
			(DoView temp15)
		)
		(DoApproach temp15)
		(if
			(Print
				addText: {Z property}
				addTitle: {Feature Writer V1.0}
				addButton: 0 {NO} 0 12
				addButton: 1 {YES} 50 12
				init:
			)
			(Print
				addText: {Click mouse on object's projection}
				addText: {onto the ground} 0 12
				init:
			)
			(while (!= ((= temp16 (Event new:)) type:) evMOUSEBUTTON)
				(temp16 dispose:)
			)
			(GlobalToLocal temp16)
			(temp15 z: (- (temp16 y:) (temp15 y:)))
			(temp15 y: (temp16 y:))
			(temp16 dispose:)
		)
		(DoDoVerb)
		(CreateObject doit: temp15)
		(= gSystemWindow local392)
	)
)

(class CreateObject
	(properties)

	(method (doit param1 &tmp [temp0 400] [temp400 40] [temp440 50] temp490 temp491 [temp492 60] [temp552 40] [temp592 12] temp604 temp605 temp606 [temp607 20] temp627 temp628)
		(if (FileIO fiEXISTS @gSysLogPath)
			(Format @temp492 {The file '%s' already exists} @gSysLogPath)
			(if
				(not
					(= temp491
						(Print
							addText: @temp492
							addButton: 1 {Replace} 0 20
							addButton: 2 {Append} 73 20
							addButton: 0 {Cancel} 133 20
							init:
						)
					)
				)
				(return 0)
			)
		)
		(= temp490 (if (== temp491 1) 2 else 0))
		(if (not ((= local393 (File new:)) name: @gSysLogPath open: temp490))
			(Format @temp0 {Error opening '%s'} @gSysLogPath)
			(Prints @temp0)
			(local393 dispose:)
			(return 0)
		)
		(= temp0 0)
		(if (param1 isMemberOf: Feature)
			(Format
				@temp400
				{ \t\tnsLeft\t\t\t%d\r\n\t\tnsTop\t\t\t\t%d\r\n\t\tnsBottom\t\t\t%d\r\n\t\tnsRight\t\t\t%d\r\n}
				(param1 nsLeft:)
				(param1 nsTop:)
				(param1 nsBottom:)
				(param1 nsRight:)
			)
			(Format @temp592 {..\msg\%d.shm} (gCurRoom curPic:))
			(shmFile name: @temp592)
			(if (not (shmFile open: 1))
				(= temp604 0)
			else
				(for
					((= temp605 0))
					(<= temp605 (StrLen @local50))
					((++ temp605))
					
					(if (< 96 (StrAt @local50 temp605) 123)
						(= temp628 (- (StrAt @local50 temp605) 32))
						(StrAt @local50 temp605 temp628)
					)
				)
				(= temp604 0)
				(while (!= (FileIO fiREAD_STRING @temp552 80 (shmFile handle:)) -1)
					(if (not (StrCmp @temp552 {(define} 6))
						(for ((= temp605 0)) (<= temp605 40) ((++ temp605))
							(= [temp552 temp605] [temp552 (+ temp605 4)])
						)
						(if (not (StrCmp @temp552 @local50 (StrLen @local50)))
							(= temp606 0)
							(for
								((= temp605 (+ (/ (StrLen @local50) 2) 1)))
								(< temp605 20)
								((++ temp605))
								
								(= [temp607 temp606] [temp552 temp605])
								(++ temp606)
							)
							(= temp604 (ReadNumber @temp607))
							(break)
						)
					)
					(if (not (StrCmp @temp552 {; CASES}))
						(break)
					)
				)
				(shmFile close:)
			)
			(= temp627 (Feature new:))
			(temp627
				init:
				setName: @local0
				nsLeft: (param1 nsLeft:)
				nsTop: (param1 nsTop:)
				nsBottom: (param1 nsBottom:)
				nsRight: (param1 nsRight:)
				x: (param1 x:)
				y: (param1 y:)
				z: (param1 z:)
				heading: (param1 heading:)
				sightAngle: (param1 sightAngle:)
				approachX: (param1 approachX:)
				approachY: (param1 approachY:)
				noun: temp604
			)
		else
			(Format
				@temp400
				{ \t\tview\t\t\t%d\r\n\t\tloop\t\t\t%d\r\n\t\tcel\t\t\t%d\r\n}
				(param1 view:)
				(param1 loop:)
				(param1 cel:)
			)
		)
		(Format
			@temp440
			{ \t\tapproachX\t\t%d\r\n\t\tapproachY\t\t%d\r\n\t\tapproachDist\t%d\r\n\t\t_approachVerbs\t$%x\r\n}
			(param1 approachX:)
			(param1 approachY:)
			(param1 approachDist:)
			(param1 _approachVerbs:)
		)
		(Format
			@temp0
			{ \r\n(instance %s of %s\r\n\t(properties\r\n\t\tx\t\t\t\t\t%d\r\n\t\ty\t\t\t\t\t%d\r\n\t\tz\t\t\t\t\t%d\r\n\t\theading\t\t\t%d\r\n%s \t\tsightAngle\t\t%d\r\n%s \t\tnoun\t\t\t\t%s\r\n\t)\r\n}
			@local0
			((param1 -super-:) name:)
			(param1 x:)
			(param1 y:)
			(param1 z:)
			(param1 heading:)
			@temp400
			(param1 sightAngle:)
			@temp440
			@local50
		)
		(if local387
			(Print
				font: 999
				addText: @temp0
				addTitle: {Feature Writer V1.0}
				init:
			)
		)
		(Logit @temp0)
		(if local391
			(Format
				@temp0
				{ \t(method (doVerb theVerb)\r\n\t\t(switch theVerb\r\n}
			)
			(Logit @temp0)
			(if [local180 0]
				(Format @temp0 { \t\t\t(LOOK\r\n\t\t\t)\r\n} @local180)
				(Logit @temp0)
			)
			(if [local80 0]
				(Format @temp0 { \t\t\t(DO\r\n\t\t\t)\r\n} @local80)
				(Logit @temp0)
			)
			(if [local280 0]
				(Format @temp0 { \t\t\t(TALK\r\n\t\t\t)\r\n} @local280)
				(Logit @temp0)
			)
			(Format
				@temp0
				{ \t\t\t(else\r\n\t\t\t\t(super doVerb: theVerb)\r\n\t\t\t)\r\n\t\t)\r\n\t)\r\n}
			)
			(Logit @temp0)
		)
		(StrCpy @temp0 {)\r\n})
		(Logit @temp0)
		(if (param1 isMemberOf: Feature)
			(param1 dispose:)
		else
			(param1 addToPic:)
		)
		(local393 close: dispose:)
		(DisposeScript 993)
		(return (DisposeScript 948))
	)

	(method (writeList param1)
		(param1 eachElementDo: #perform self)
		(WriteCode doit:)
		(DisposeScript 948)
	)
)

(instance selectorI of DSelector
	(properties
		x 18
	)

	(method (handleEvent event &tmp eType eMsg)
		(super handleEvent: event)
		(= eType (event type:))
		(= eMsg (event message:))
		(if
			(or
				(and (== eType evMOUSEBUTTON) (event claimed:))
				(and (== eType evKEYBOARD) (== eMsg KEY_SPACE))
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

(instance clearBut of DButton ; UNUSED
	(properties
		state 1
		text {Clear}
	)

	(method (doit &tmp i)
		(for ((= i 0)) (< i 6) ((++ i))
			(StrAt local380 (* i 18) 32)
		)
		(selectorI draw:)
	)
)

(instance allBut of DButton ; UNUSED
	(properties
		state 1
		value 2
		text {  All  }
	)

	(method (doit &tmp i)
		(for ((= i 0)) (< i 6) ((++ i))
			(StrAt local380 (* i 18) 62)
		)
		(selectorI draw:)
	)
)

(instance doneBut of DButton ; UNUSED
	(properties
		value 1
		text { Done }
	)
)

(instance wfWin of Window
	(properties)
)

(instance shmFile of File
	(properties)
)

