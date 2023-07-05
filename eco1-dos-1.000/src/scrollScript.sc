;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 816)
(include sci.sh)
(use Main)
(use Talker)
(use User)
(use Actor)
(use System)

(public
	scrollScript 0
)

(local
	local0
	local1
	local2 = -1
	local3
	local4
	[local5 7]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(while
		(and
			(= temp0 (FirstNode (param1 elements:)))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(param2 add: temp1)
		(param1 delete: temp1)
	)
)

(procedure (localproc_1)
	(if (> (ProphesyScroll y:) 132)
		(ProphesyScroll y: (- (ProphesyScroll y:) 4) forceUpd:)
		(upperRoll cel: (not (upperRoll cel:)) forceUpd:)
		(lowerRoll cel: (not (lowerRoll cel:)) forceUpd:)
		(= global107 (ProphesyScroll y:))
	)
)

(procedure (localproc_2)
	(if (< (ProphesyScroll y:) 230)
		(ProphesyScroll y: (+ (ProphesyScroll y:) 4) forceUpd:)
		(upperRoll cel: (not (upperRoll cel:)) forceUpd:)
		(lowerRoll cel: (not (lowerRoll cel:)) forceUpd:)
		(= global107 (ProphesyScroll y:))
	)
)

(procedure (localproc_3 &tmp temp0)
	(= temp0 (- (ProphesyScroll y:) local4))
	(-= local3 (ProphesyScroll nsLeft:))
	(return
		(cond
			((< temp0 12) 10)
			((< temp0 31)
				(if (< local3 51) 7 else 8)
			)
			((< temp0 59)
				(cond
					((< local3 43) 5)
					((< temp0 45) 6)
					(else 9)
				)
			)
			((< temp0 97) 4)
			((< temp0 125) 3)
			((< temp0 165) 2)
			(else 1)
		)
	)
)

(instance scrollScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (doit)
		(super doit:)
		(if (GameIsRestarting)
			(= start 2)
			(self init:)
		)
	)

	(method (handleEvent event)
		(event localize:)
		(= local3 (event x:))
		(= local4 (event y:))
		(if (and (!= (event type:) evVERB) (not (event modifiers:)))
			(cond
				((& (event type:) $0044) ; direction | evKEYBOARD
					(event claimed: 1)
					(switch (event message:)
						(JOY_UP
							(localproc_1)
						)
						(JOY_DOWN
							(localproc_2)
						)
						(KEY_TAB
							(event claimed: 1)
							(return)
						)
						(KEY_ESCAPE
							(if (== state 2)
								(self cue:)
							)
						)
						(else
							(event claimed: 0)
							(return)
						)
					)
				)
				((& (event type:) evMOUSEBUTTON)
					(if
						(or
							(upperRoll onMe: event)
							(lowerRoll onMe: event)
							(ProphesyScroll onMe: event)
						)
						(if (== (gTheIconBar curIcon:) (gTheIconBar at: 1))
							(super handleEvent: event)
						else
							(if (<= local4 89)
								(localproc_1)
							else
								(localproc_2)
							)
							(event claimed: 1)
						)
					else
						(event claimed: 1)
						(if (== state 2)
							(self cue:)
						)
					)
					(return 1)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp temp0 [temp1 20] [temp21 20])
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					(= [local5 temp0] (& ((gTheIconBar at: temp0) signal:) $0004))
				)
				(gEgo setMotion: 0)
				(= local1 (User controls:))
				(User canControl: 0)
				(gTheIconBar disable: 0 7)
				(= local0 (gCurRoom lookStr:))
				(gCurRoom lookStr: 0)
				(= cycles 2)
			)
			(1
				(= register (gCurRoom curPic:))
				(= local2 gOverlays)
				(localproc_0 gAddToPics aList)
				(localproc_0 gFeatures fList)
				(localproc_0 gCast cList)
				(gCurRoom drawPic: 901 10)
				(gTheIconBar curIcon: (gTheIconBar at: 1))
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 5 6)
				(= cycles 2)
			)
			(2
				(if (HaveMouse)
					(GetMessage 99 5 221 @temp1)
					(GetMessage 99 5 222 @temp21)
					(Display @temp1 dsCOORD 67 159 dsCOLOR global213 dsFONT 300)
					(Display @temp21 dsCOORD 66 170 dsCOLOR global213 dsFONT 300)
				else
					(GetMessage 99 5 223 @temp1)
					(GetMessage 99 5 224 @temp21)
					(Display @temp1 dsCOORD 46 159 dsCOLOR global213 dsFONT 300)
					(Display @temp21 dsCOORD 83 170 dsCOLOR global213 dsFONT 300)
				)
				(ProphesyScroll init:)
				(upperRoll init:)
				(lowerRoll init:)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose &tmp temp0)
		(HandsOff)
		(gFeatures release:)
		(gCurRoom drawPic: register 10)
		(if (!= (= gOverlays local2) -1)
			(DrawPic gOverlays 10 0 global40)
		)
		(localproc_0 aList gAddToPics)
		(localproc_0 fList gFeatures)
		(localproc_0 cList gCast)
		(gAddToPics doit:)
		(aList eachElementDo: #dispose eachElementDo: #delete release: dispose:)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList eachElementDo: #dispose eachElementDo: #delete dispose:)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(gCurRoom lookStr: local0)
		(ProphesyScroll dispose: delete:)
		(upperRoll dispose: delete:)
		(lowerRoll dispose: delete:)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
		(HandsOn)
		(User canControl: local1)
		(gTheIconBar enable: 7)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (!= [local5 temp0] 0)
				(gTheIconBar disable: (gTheIconBar at: temp0))
			)
		)
		(if (== gCurRoomNum 540)
			(Animate (gCast elements:) 0)
			(gCurRoom notify: 1)
		)
		(DisposeScript 816)
	)
)

(instance fdc of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1 signal: (& (param1 signal:) $ffdf) dispose: delete:)
		else
			(param1 dispose:)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fList of Collect
	(properties)
)

(instance cList of Collect
	(properties)
)

(instance ProphesyScroll of View
	(properties
		x 156
		y 164
		view 144
		priority 3
		signal 16401
	)

	(method (init)
		(if global107
			(= y global107)
		else
			(= y 132)
		)
		(super init: &rest)
	)

	(method (onMe param1)
		(return
			(InRect
				(ProphesyScroll nsLeft:)
				(upperRoll nsTop:)
				(ProphesyScroll nsRight:)
				(lowerRoll nsBottom:)
				param1
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (<= local4 89)
					(localproc_1)
				else
					(localproc_2)
				)
			)
			(2 ; Look
				(Narrator posn: -1 10 init: (localproc_3) 0 816)
			)
		)
	)
)

(instance upperRoll of Prop
	(properties
		x 157
		y 52
		view 145
		cel 2
		priority 15
		signal 4113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(localproc_1)
			)
			(2 ; Look
				(Narrator init: 11 0 816) ; "The scroll contains the Oracle's prophecy."
			)
		)
	)
)

(instance lowerRoll of Prop
	(properties
		x 157
		y 153
		view 145
		loop 1
		cel 1
		priority 15
		signal 4113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(localproc_2)
			)
			(2 ; Look
				(Narrator init: 11 0 816) ; "The scroll contains the Oracle's prophecy."
			)
		)
	)
)

