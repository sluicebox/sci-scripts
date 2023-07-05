;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use n913)
(use PolyPath)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	pullOutMapScr 0
	MapScr 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 7]
)

(instance pullOutMapScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					(= [local10 temp0] (& ((gTheIconBar at: temp0) signal:) $0004))
				)
				(gGame handsOff:)
				(gTheIconBar disable:)
				(gMessager say: 1 12 5 0 self 0) ; "Alexander pulls out his magic map."
			)
			(1
				(switch gCurRoomNum
					(200
						(if (not (gEgo inRect: 93 98 284 183))
							(gEgo setMotion: PolyPath 182 126 self)
						else
							(= cycles 2)
						)
					)
					(450
						(if (not (gEgo inRect: 24 103 252 155))
							(gEgo setMotion: PolyPath 176 131 self)
						else
							(= cycles 2)
						)
					)
					(550
						(if (not (gEgo inRect: 0 79 274 133))
							(gEgo setMotion: PolyPath 167 101 self)
						else
							(= cycles 2)
						)
					)
					(500
						(if (not (gEgo inRect: 86 89 318 159))
							(gEgo setMotion: PolyPath 203 129 self)
						else
							(= cycles 2)
						)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(2
				(if (!= (gEgo cel:) 2)
					(gEgo setHeading: 180 self)
				else
					(= cycles 2)
				)
			)
			(3
				(gEgo
					normal: 0
					cycleSpeed: 10
					view: 207
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(if next
					((ScriptID 130 1) next: next) ; MapScr
					(= next 0)
				)
				(gCurRoom setScript: (ScriptID 130 1)) ; MapScr
			)
		)
	)
)

(class MapScr of Script
	(properties)

	(method (init)
		(= local0 gCast)
		(= local1 gFeatures)
		(= local2 gAddToPics)
		(= local3 gMouseDownHandler)
		(= local4 gKeyDownHandler)
		(= local6 gWalkHandler)
		(= local7 (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gCast (EventHandler new:)) name: {newCast} add:)
		((= gFeatures (EventHandler new:)) name: {newFeatures})
		((= gAddToPics (EventHandler new:)) name: {newATPs} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {newMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {newKH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {newWH} add:)
		(if register
			(gInventory hide:)
			(= register 0)
		)
		(super init: &rest)
	)

	(method (resetHandlers)
		(gMouseDownHandler delete: self dispose:)
		(gKeyDownHandler delete: self dispose:)
		(gWalkHandler delete: self dispose:)
		(= gMouseDownHandler local3)
		(= gKeyDownHandler local4)
		(= gWalkHandler local6)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(& (event type:) evMOUSEKEYBOARD)
				(not (event claimed:))
			)
			(cond
				(
					(and
						(User canControl:)
						(= local8 (gCast firstTrue: #onMe event))
					)
					(if (== local8 mistsProp)
						(= local8 mists)
					)
					(event claimed: 1)
					(local8 doVerb: ((gTheIconBar curIcon:) message:))
				)
				((User canControl:)
					(gFeatures delete: MapScr)
					(= local8 (gFeatures firstTrue: #onMe event))
					(event claimed: 1)
					(local8 doVerb: ((gTheIconBar curIcon:) message:))
				)
			)
			(return 1)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DrawPic 130 10)
				(sacredMountain init:)
				(wonder init:)
				(crown init:)
				(beast init:)
				(northMarker init:)
				(mists init:)
				(mapTitle init:)
				(exitFeature init:)
				(theMap init:)
				(mapSound number: 130 loop: 1 play:)
				(= cycles 10)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar enable: disable: 0 3 4 5 6)
			)
			(2
				(if (gCast contains: mistsProp)
					(mistsProp dispose:)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gGame setCursor: gWaitCursor)
				(gCast
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
					dispose:
				)
				(gAddToPics dispose:)
				(gFeatures delete: self dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: local7)
				(= gCast local0)
				(= gFeatures local1)
				(= gAddToPics local2)
				(UnLoad 128 131)
				(DrawPic (gCurRoom picture:) 100)
				(if gAddToPics
					(gAddToPics doit:)
				)
				(if register
					(gTheIconBar enable: disable: 2 1)
					(= cycles 15)
				else
					(= next 0)
					(= seconds 2)
				)
			)
			(3
				(if register
					(gEgo
						normal: 0
						cycleSpeed: 10
						view: 207
						setLoop: 2
						lastCel:
						setCycle: Beg self
					)
				else
					(= seconds 2)
				)
			)
			(4
				(if register
					(gEgo reset: 2)
					(gGame handsOn:)
					(gTheIconBar enable: 6)
					(for ((= temp0 0)) (< temp0 6) ((++ temp0))
						(if (!= [local10 temp0] 0)
							(gTheIconBar disable: (gTheIconBar at: temp0))
						)
					)
					(self dispose:)
				else
					(mapSound loop: 1 number: 947 play:)
					(gEgo cel: 0 setLoop: 0 setCycle: End self)
				)
			)
			(5
				(= seconds 1)
			)
			(6
				(gTheIconBar enable: enable: 6)
				(SetFlag 103)
				(switch (local8 tpRoom:)
					(200
						(gEgo posn: 182 126)
					)
					(300
						(gEgo posn: 151 134)
					)
					(450
						(gEgo posn: 176 131)
					)
					(550
						(gEgo posn: 167 101)
					)
					(500
						(gEgo posn: 203 129)
					)
				)
				(gCurRoom newRoom: (local8 tpRoom:))
			)
		)
	)
)

(instance theMap of Feature
	(properties
		noun 6
		modNum 130
		nsBottom 200
		nsRight 320
	)
)

(class HighliteMap of Feature
	(properties
		modNum 130
		view 0
		loop 0
		tpRoom 0
		theMapObj 0
	)

	(method (doVerb theVerb)
		(= local8 self)
		(if (== theVerb 5) ; Do
			(MapScr resetHandlers:)
		)
		(cond
			((and (== theVerb 5) (== gCurRoomNum tpRoom)) ; Do
				(gTheIconBar enable:)
				(MapScr register: 1 cue:)
			)
			((== theVerb 5) ; Do
				(if (not (IsFlag 128))
					(SetFlag 128)
					(gGame givePoints: 1)
				)
				(gMessager say: noun theVerb 0 0 self 130)
				(gTheIconBar enable:)
				(gGame handsOff:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		((= theMapObj (Actor new:))
			view: view
			setPri: 15
			loop: loop
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			posn: x y
			init:
			setCycle: End MapScr
		)
		(mapSound number: 131 loop: 1 play:)
	)
)

(instance mistsProp of Prop
	(properties
		x 256
		y 142
		onMeCheck 128
		view 132
		loop 2
	)

	(method (doVerb)
		(mists doVerb: &rest)
	)
)

(instance sacredMountain of HighliteMap
	(properties
		x 156
		y 49
		noun 9
		onMeCheck 2
		view 131
		tpRoom 300
	)
)

(instance crown of HighliteMap
	(properties
		x 124
		y 129
		noun 1
		onMeCheck 8
		view 131
		loop 1
		tpRoom 200
	)
)

(instance wonder of HighliteMap
	(properties
		x 82
		y 81
		noun 5
		onMeCheck 4
		view 132
		tpRoom 450
	)
)

(instance beast of HighliteMap
	(properties
		x 213
		y 92
		noun 2
		onMeCheck 16
		view 132
		loop 1
		tpRoom 500
	)
)

(instance mists of HighliteMap
	(properties
		x 256
		y 142
		noun 3
		onMeCheck 128
		view 132
		loop 2
		tpRoom 550
	)

	(method (init)
		(if (IsFlag 3)
			(mistsLabel init:)
			(mistsProp init:)
		)
		(super init: &rest)
	)

	(method (onMe)
		(if (IsFlag 3)
			(= noun 3)
		else
			(= noun 4)
		)
		(return (super onMe: &rest))
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (IsFlag 3))
		(cond
			((and (== theVerb 5) temp0) ; Do
				(super doVerb: theVerb &rest)
			)
			((and (== theVerb 1) temp0 (not (IsFlag 80))) ; Look
				(SetFlag 80)
				(gMessager say: noun theVerb 12 0 0 modNum)
			)
			((and (== theVerb 1) temp0) ; Look
				(gMessager say: noun theVerb 11 0 0 modNum)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 modNum)
			)
		)
	)
)

(instance northMarker of Feature
	(properties
		noun 8
		modNum 130
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gMessager say: 6 theVerb 0 0 0 130) ; "Nothing happens. Apparently, the map won't teleport its user anywhere except the other islands. It's a good thing, too! Alexander has had enough of ocean swimming lately!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mapTitle of Feature
	(properties
		noun 7
		modNum 130
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gMessager say: 6 theVerb 0 0 0 130) ; "Nothing happens. Apparently, the map won't teleport its user anywhere except the other islands. It's a good thing, too! Alexander has had enough of ocean swimming lately!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mistsLabel of Actor
	(properties
		x 207
		y 156
		noun 3
		view 132
		loop 3
	)

	(method (doVerb)
		(mists doVerb: &rest)
	)
)

(instance exitFeature of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb)
		(MapScr resetHandlers: register: 1 cue:)
	)
)

(instance mapSound of Sound
	(properties)
)

