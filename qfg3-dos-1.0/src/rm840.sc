;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	local0
)

(instance rm840 of Rm
	(properties
		picture 840
	)

	(method (cue)
		(if local0
			(firstEntrance cue:)
			(= local0 0)
		)
	)

	(method (init)
		(if (IsFlag 77)
			(gEgo setScale: x: 160 y: 137 init: normalize:)
		else
			(gEgo setScale: x: 160 y: 189 init: normalize:)
		)
		(super init:)
		(gLongSong number: 840 setLoop: -1 play: self)
		(if (IsFlag 77)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 48 83 129 83 143 143 167 164 167 173 132 189 32 189 32 83 50 83
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 162 189 195 158 195 83 319 83 319 189
						yourself:
					)
			)
		)
		(if (IsFlag 77)
			(gCurRoom setScript: secondEntrance)
		else
			(SetFlag 77)
			(gCurRoom setScript: firstEntrance)
		)
	)

	(method (dispose)
		(LoadMany 0 41 36 39)
		(super dispose:)
	)
)

(instance firstEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 6 4 0 self) ; "You find yourself drawn to the mirror at the opposite end of the room."
			)
			(1
				(if (IsFlag 150)
					(gMessager say: 2 6 5 0 self) ; "You have a strong sense of danger."
				else
					(self cue:)
				)
			)
			(2
				(gEgo solvePuzzle: 339 3 setMotion: MoveTo 158 155 self)
			)
			(3
				((ScriptID 36 1) ; Johari
					x: 160
					y: 200
					ignoreActors: 1
					setScale:
					init:
					setCycle: Walk
					setMotion: MoveTo 72 174 self
				)
				((ScriptID 39 1) ; Yesufu
					x: 160
					y: 200
					ignoreActors: 1
					setScale:
					init:
					setStep: 3 2
					moveSpeed: 12
					setCycle: Walk
					setMotion: MoveTo 198 161
				)
			)
			(4
				((ScriptID 41 1) ; Manu
					x: 160
					y: 200
					ignoreActors: 1
					setScale:
					init:
					setCycle: Walk
					setMotion: MoveTo 118 149
				)
				(reesha init: setCycle: Walk setMotion: MoveTo 250 168 self)
			)
			(5
				(= cycles 1)
			)
			(6
				(= local0 1)
			)
			(7
				(johariBiz init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= cycles 2)
			)
			(8
				(= local0 1)
			)
			(9
				(manuBiz init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= cycles 2)
			)
			(10
				(= local0 1)
			)
			(11
				(egoBiz init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= cycles 2)
			)
			(12
				(= local0 1)
			)
			(13
				(yesufuBiz init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= cycles 2)
			)
			(14
				(= local0 1)
			)
			(15
				(reeshaBiz init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= seconds 3)
			)
			(16
				(= local0 1)
			)
			(17
				(johariBiz setCycle: End self)
			)
			(18
				(= local0 1)
			)
			(19
				(manuBiz setCycle: End self)
			)
			(20
				(= local0 1)
			)
			(21
				(egoBiz setCycle: End self)
			)
			(22
				(= local0 1)
			)
			(23
				(yesufuBiz setCycle: End self)
			)
			(24
				(= local0 1)
			)
			(25
				(reeshaBiz setCycle: End self)
			)
			(26
				(= seconds 2)
			)
			(27
				(gCurRoom newRoom: 549)
				(self dispose:)
			)
		)
	)
)

(instance secondEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(johariBiz view: 842 loop: 1 cel: 1 x: 37 y: 125 init:)
				(yesufuBiz view: 842 loop: 0 cel: 2 x: 159 y: 81 init:)
				(manuBiz view: 842 loop: 1 cel: 0 x: 83 y: 91 init:)
				(reeshaBiz view: 842 loop: 0 cel: 0 x: 149 y: 136 init:)
				(gEgo setMotion: PolyPath 109 248 self)
			)
			(1
				(if (not (IsFlag 117))
					(if 12
						(= [gEgoStats 18] (gEgo maxMana:)) ; mana
						(= [gEgoStats 16] (gEgo maxHealth:)) ; health
						(gMessager say: 2 6 3 0 self) ; "As you run up the weird spiral staircase, you take the healing and mana pills Harami handed you."
					else
						(= [gEgoStats 16] (gEgo maxHealth:)) ; health
						(gMessager say: 2 6 2 0 self) ; "As you run up an eerie spiral staircase, you take the healing pills Harami handed you."
					)
				else
					(self cue:)
				)
			)
			(2
				(switch gHeroType
					(0 ; Fighter
						(gCurRoom newRoom: 851)
					)
					(3 ; Paladin
						(gCurRoom newRoom: 852)
					)
					(1 ; Magic User
						(gCurRoom newRoom: 853)
					)
					(2 ; Thief
						(gCurRoom newRoom: 854)
					)
				)
			)
		)
	)
)

(instance egoBiz of Prop
	(properties
		x 155
		y 111
		view 841
		signal 16384
	)
)

(instance johariBiz of Prop
	(properties
		x 29
		y 129
		view 841
		loop 3
		signal 16384
	)
)

(instance yesufuBiz of Prop
	(properties
		x 228
		y 116
		view 841
		loop 1
		signal 16384
	)
)

(instance manuBiz of Prop
	(properties
		x 84
		y 123
		view 841
		loop 4
		signal 16384
	)
)

(instance reesha of Actor
	(properties
		x 160
		y 200
		view 831
		cel 2
		signal 16384
	)
)

(instance reeshaBiz of Prop
	(properties
		x 278
		y 134
		view 841
		loop 2
		signal 16384
	)
)

