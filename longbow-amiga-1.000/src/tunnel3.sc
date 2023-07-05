;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 562)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	tunnel3 0
)

(local
	local0
	local1
	[local2 9] = [1561 28 1 2 1 1 2 1 0]
	[local11 6] = [1561 25 1 2 1 0]
	[local17 6] = [-1 {Hal} 11 -1 {Hob} 12]
	[local23 3] = [-1 {Dicken} 13]
)

(procedure (localproc_0)
	(SetMessageColor 11)
	(Say &rest 80 {Hal})
)

(procedure (localproc_1)
	(SetMessageColor 12)
	(Say &rest 80 {Hob})
)

(procedure (localproc_2)
	(SetMessageColor 13)
	(Say &rest 80 {Dicken})
)

(instance tunnel3 of Rm
	(properties
		picture 562
		style -32758
		north 561
	)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(= local1 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gTheIconBar disable: 5 3)
		(Load rsVIEW 562)
		(Load rsSCRIPT 930)
		(DoSound sndGLOBAL_REVERB 20)
		(HandsOn)
		(switch gPrevRoomNum
			(560 ; tunnel1
				(gEgo posn: 143 175 init:)
				(NormalEgo)
				(if (and (!= gDay 10) (or (IsFlag 125) (IsFlag 56)))
					(HandsOff)
					(gGame setCursor: gWaitCursor 1 10 25)
					(sonHal
						setCycle: SyncWalk
						init:
						setMotion: PFollow gEgo 30
					)
					(sonHob
						setCycle: SyncWalk
						init:
						setMotion: PFollow sonHal 15
					)
					(sonDicken
						setCycle: SyncWalk
						init:
						setMotion: PFollow sonHob 10
					)
					(gCurRoom setScript: onwardsHo)
				)
			)
			(561 ; tunnel2
				(HandsOff)
				(= local0 1)
				(gEgo
					init:
					view: 562
					setLoop: (if (== gDisguiseNum 5) 2 else 0) ; abbey monk
					posn: 169 125
					setCycle: Fwd
				)
				(NormalEgo)
				(if (and (!= gDay 10) (or (IsFlag 125) (IsFlag 56)))
					(HandsOff)
					(sonHal
						view: 562
						setLoop: 2
						setCycle: SyncWalk
						posn: 166 111
						init:
						setMotion: PFollow gEgo 30
					)
					(sonHob
						view: 562
						setLoop: 2
						setCycle: SyncWalk
						posn: 167 95
						init:
						setMotion: PFollow sonHal 12
					)
					(sonDicken
						view: 562
						setLoop: 2
						setCycle: SyncWalk
						posn: 169 88
						init:
						setMotion: PFollow sonHob 10
					)
					(gCurRoom setScript: theLeader)
				else
					(gCurRoom setScript: walkIn)
				)
			)
			(else
				(gGame setCursor: 0 1 10 25)
				(NormalEgo (gEgo loop:) 0 1)
				(gEgo posn: 146 150 init:)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -2 319 -1 319 81 319 189 262 189 255 181 248 171 231 166 196 153 173 129 176 100 169 100 156 100 147 108 116 136 74 164 59 189
					yourself:
				)
		)
		(if (!= (gRgnMusic number:) 560)
			(gRgnMusic number: 560 loop: -1 play:)
		)
		(AddToFeatures tunnelWall)
	)

	(method (doit)
		(if (and (< (gEgo y:) 150) (!= local0 1))
			(= local0 1)
			(HandsOff)
			(gEgo setScript: changeTunnels)
		)
		(if (and (> (gEgo y:) 186) (!= local0 1))
			(= local0 1)
			(HandsOff)
			(gEgo setScript: backAgain)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(= gUseSortedFeatures local1)
		(sonHal setMotion: 0)
		(sonHob setMotion: 0)
		(sonDicken setMotion: 0)
		(super dispose:)
		(DoSound sndGLOBAL_REVERB 0)
		(DisposeScript 971)
		(HandsOn)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1561 48) ; "Loosing an arrow down the tunnel would be more reckless than I care to be right now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tunnelWall of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 0 319 189 0 189 0 0
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1561 49) ; "The sandstone tunnel runs fairly straight on for a long distance."
			)
			(3 ; Do
				(Say 1561 50) ; "Sandstone all feels the same--soft and crumbly."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance sonHal of Actor
	(properties
		x 166
		y 189
		view 434
		loop 3
		cel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 self) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_0 1561 12 self) ; "Even in whispers, it's not a safe place for talk."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_0 1561 13 self) ; "We could never repay what we owe you now. I couldn't accept any more."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_0 1561 14 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_0 1561 14 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_0 1561 15 self) ; "Nay, I could not take it."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_0 1561 16 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_0 1561 16 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonHob of Actor
	(properties
		x 111
		y 195
		view 434
		loop 3
		cel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 1) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_1 1561 17 self) ; "We'd best keep quiet."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_1 1561 18 self) ; "Nay, you've done enough for us."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_1 1561 19 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_1 1561 19 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_1 1561 20 self) ; "I've no idea how to open such a thing."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_1 1561 21 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_1 1561 21 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonDicken of Actor
	(properties
		x 135
		y 210
		view 434
		loop 3
		cel 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 1) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_2 1561 22 self) ; "I won't make a sound."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_2 1561 23 self) ; "Thank you, but Hal will wallop me if I take it."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_2 1561 24 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_2 1561 24 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(gCurRoom setScript: dickenPuzBoxTalk)
					)
					(18 ; waterRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
					(10 ; fireRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannotUsePuzbox of SpecialDoVerb ; UNUSED
	(properties)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(1 ; horn
					(Say 1561 46) ; "I dare not wind my horn here."
				)
			)
		)
	)
)

(instance dickenPuzBoxTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(Converse 2 @local2 @local23 0 @local17 1 self) ; "I like rings--"
			)
			(2
				(HandsOn)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance waterOrFireRingTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(Converse 2 @local11 @local23 0 @local17 1 self) ; "What a wondrous box! Hal,  may I?"
			)
			(2
				(HandsOn)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance changeTunnels of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 562
					setLoop: (if (== gDisguiseNum 5) 3 else 1) ; abbey monk
					setCycle: Walk
					setMotion: MoveTo 167 113 self
				)
			)
			(1
				(gCurRoom newRoom: 561) ; tunnel2
				(self dispose:)
			)
		)
	)
)

(instance backAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Walk setMotion: MoveTo (gEgo x:) 240 self)
			)
			(1
				(gCurRoom newRoom: 560) ; tunnel1
				(self dispose:)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 159 self)
			)
			(1
				(HandsOn)
				(gGame setCursor: 0 1 10 25)
				(NormalEgo
					2
					(if (== gDisguiseNum 5) 23 else 0) ; abbey monk
					(if (== gDisguiseNum 5) 24 else 1) ; abbey monk
				)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance theLeader of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 240 self)
			)
			(1
				(gCurRoom newRoom: 560) ; tunnel1
				(self dispose:)
			)
		)
	)
)

(instance onwardsHo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 111 self)
			)
			(1
				(gCurRoom newRoom: 561) ; tunnel2
				(self dispose:)
			)
		)
	)
)

