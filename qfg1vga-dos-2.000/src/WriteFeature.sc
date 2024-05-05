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
	local380 = { WALK____________}
	[local381 6] = [{ LOOK____________} { DO______________} { TALK____________} { ASK_____________} { HELP____________} {}]
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
	(proc921_0 {Click left mouse button on top left corner})
	(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
		(event dispose:)
	)
	(GlobalToLocal event)
	(= theTop (event y:))
	(= theLeft (event x:))
	(event dispose:)
	(proc921_0 {Click left mouse button on bottom right corner})
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
			addButton: 1 {Select with mouse} 0 12
			addButton: 0 {Default to x, y} 0 24
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
			addText: {How far away must ego be before}
			addText: {he tries to approach?} 0 12
			addEdit: @str 5 -113 13
			addButton: 1 {Select with mouse} 0 24
			addButton: 0 {Always approach} 0 36
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
			(if (not (proc921_2 @temp0 30 {Enter path and filename}))
				(return)
			else
				(Format @gSysLogPath @temp0)
				(= local388
					(Print
						addText: {Outline Features?}
						title: {Feature Write V1.0}
						addButton: 1 {YES} 0 12
						addButton: 0 {NO} 50 12
						init:
					)
				)
				(= local387
					(Print
						addText: {Display code to screen? (but not doVerb)}
						title: {Feature Write V1.0}
						addButton: 0 {NO} 0 12
						addButton: 1 {YES} 50 12
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
						title: {Feature Writer V1.0}
						addButton: Feature {Feature} 0 12
						addButton: View {View} 141 12
						addButton: Prop {Prop} 180 12
						addButton: Actor {Actor} 220 12
						init:
					)
				)
			)
			(return)
		)
		(= temp15 (local390 new:))
		(= local0 0)
		(proc921_2 @local0 30 {Name?})
		(= local50 0)
		(proc921_2 @local50 16 {Noun?})
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
				title: {Feature Writer V1.0}
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

	(method (doit param1 &tmp [temp0 400] [temp400 40] [temp440 50] temp490 temp491 [temp492 60])
		(if (FileIO fiEXISTS @gSysLogPath)
			(Format @temp492 {The file '%s' already exists} @gSysLogPath)
			(if
				(not
					(= temp491
						(Print
							addText: @temp492
							addButton: 1 {Replace} 0 12
							addButton: 2 {Append} 73 12
							addButton: 0 {Cancel} 133 12
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
			(proc921_0 @temp0)
			(local393 dispose:)
			(return 0)
		)
		(= temp0 0)
		(if (param1 isMemberOf: Feature)
			(Format
				@temp400
				{ \t\tnsLeft\t\t\t%d\0d\n\t\tnsTop\t\t\t\t%d\0d\n\t\tnsBottom\t\t\t%d\0d\n\t\tnsRight\t\t\t%d\0d\n}
				(param1 nsLeft:)
				(param1 nsTop:)
				(param1 nsBottom:)
				(param1 nsRight:)
			)
		else
			(Format
				@temp400
				{ \t\tview\t\t\t%d\0d\n\t\tloop\t\t\t%d\0d\n\t\tcel\t\t\t%d\0d\n}
				(param1 view:)
				(param1 loop:)
				(param1 cel:)
			)
		)
		(Format
			@temp440
			{ \t\tapproachX\t\t%d\0d\n\t\tapproachY\t\t%d\0d\n\t\tapproachDist\t%d\0d\n\t\t\_approachVerbs\t$%x\0d\n}
			(param1 approachX:)
			(param1 approachY:)
			(param1 approachDist:)
			(param1 _approachVerbs:)
		)
		(Format
			@temp0
			{ \0d\n(instance %s of %s\0d\n\t(properties\0d\n\t\tx\t\t\t\t\t%d\0d\n\t\ty\t\t\t\t\t%d\0d\n\t\tz\t\t\t\t\t%d\0d\n\t\theading\t\t\t%d\0d\n%s \t\tsightAngle\t\t%d\0d\n%s \t\tnoun\t\t\t\t%s\0d\n\t)\0d\n}
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
			(Print font: 999 addText: @temp0 title: {Feature Writer V1.0} init:)
		)
		(Logit @temp0)
		(if local391
			(Format
				@temp0
				{ \t(method (doVerb theVerb)\0d\n\t\t(switch theVerb\0d\n}
			)
			(Logit @temp0)
			(if [local180 0]
				(Format @temp0 { \t\t\t(LOOK\0d\n\t\t\t)\0d\n} @local180)
				(Logit @temp0)
			)
			(if [local80 0]
				(Format @temp0 { \t\t\t(DO\0d\n\t\t\t)\0d\n} @local80)
				(Logit @temp0)
			)
			(if [local280 0]
				(Format @temp0 { \t\t\t(TALK\0d\n\t\t\t)\0d\n} @local280)
				(Logit @temp0)
			)
			(Format
				@temp0
				{ \t\t\t(else\0d\n\t\t\t\t(super doVerb: theVerb)\0d\n\t\t\t)\0d\n\t\t)\0d\n\t)\0d\n}
			)
			(Logit @temp0)
		)
		(StrCpy @temp0 {)\0d\n})
		(Logit @temp0)
		(if (param1 isMemberOf: Feature)
			(param1 dispose:)
		else
			(param1 addToPic:)
		)
		(local393 close: dispose:)
		(return (DisposeScript 993))
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
		text {__All__}
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

