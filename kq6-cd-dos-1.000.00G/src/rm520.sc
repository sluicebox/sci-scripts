;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	local0 = 1
	local1
	local2
)

(instance rm520 of KQ6Room
	(properties
		noun 5
		picture 520
		horizon 70
		north 510
		south 500
	)

	(method (init &tmp temp0)
		(Load rsVIEW 308)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 223 166 217 175 139 173 103 169 109 163 164 153 166 134 166 103 155 94 130 66 129 65 319 13 319 189 285 189 269 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 8 122 65 98 80 129 90 114 102 122 112 97 141 79 160 47 165 31 173 45 183 71 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 199 189 168 189 176 185 194 186
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 158 186 144 186 141 183 145 180 157 180 164 183
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 120 181 104 181 99 176 108 174 119 174 127 177
					yourself:
				)
		)
		(super init: &rest)
		(if (== gPrevRoomNum north)
			(gEgo init: reset: 2 posn: 130 90)
		else
			(gEgo init: reset: 3 posn: 105 187)
		)
		(if (not (IsFlag 13))
			(boilingPond
				init:
				signal: (| (boilingPond signal:) $1000)
				setCycle: Fwd
				setPri: 9
				ignoreActors: 1
				cycleSpeed: 12
			)
			(boilFx play:)
		else
			(boilingPond
				init:
				view: 525
				setLoop: 0
				setPri: 9
				posn: 141 125
				cycleSpeed: 12
				ignoreActors: 1
				setCycle: Fwd
			)
		)
		(finishedPond init:)
		(mushrooms init:)
		(frontPath init:)
		(backPath init:)
		(banks init:)
		(rocks init:)
		(trees init:)
		(if (<= temp0 (Random 1 100) 500) ; UNINIT
			(bunny init: setScript: bunnyScript)
		else
			(squirrel init:)
		)
		(if (== ((gInventory at: 19) owner:) gCurRoomNum) ; huntersLamp
			(theHuntersLamp init:)
		)
		(gEgo setScale: Scaler 100 50 184 72)
		((gEgo scaler:) doit:)
		(gGame handsOn:)
	)

	(method (doit &tmp temp0)
		(if (and (GameIsRestarting) (not (IsFlag 13)))
			(boilFx play:)
		)
		(super doit: &rest)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom newRoom: north)
			)
			((and (& temp0 $0002) local0)
				(gGame handsOff:)
				(self setScript: bravePond)
			)
		)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(if (IsFlag 13)
						(gMessager say: noun theVerb 4) ; "Alexander is traveling on a path through a dense forest. Across the path lies a pond, still steaming from what remains of the magic which once made it boil."
						1
					else
						(gMessager say: noun theVerb 3) ; "Alexander is traveling on a path through a dense forest. The woods on either side of the path are teaming with wildlife. Blocking his progress north is a pond that boils with a magical intensity."
						1
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance boilFx of Sound
	(properties
		flags 1
		number 520
		loop -1
	)
)

(instance boilDeath of Sound
	(properties
		flags 1
		number 521
	)
)

(instance theHuntersLamp of Prop
	(properties
		x 111
		y 65
		noun 4
		view 520
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "An old, abandoned hunter's lamp is hanging on one of the trees. Alexander wonders who might have hunted in these dense woods."
			)
			(5 ; Do
				(if (IsFlag 13)
					(gGame handsOff:)
					(= local1 1)
					(gEgo setScript: getLamp)
				else
					(gMessager say: noun theVerb 3) ; "To get the lamp, Alexander must first cross the pond."
				)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(else
				(if (IsFlag 13)
					(gMessager say: noun 0 4) ; "There's no reason to use that on the hunter's lamp."
				else
					(gMessager say: noun 0 3) ; "To do anything with the lamp, Alexander must first cross the pond."
				)
			)
		)
	)
)

(instance splash of Prop
	(properties
		view 520
		loop 4
	)

	(method (init)
		(self x: (+ (gEgo x:) 16) y: (- (gEgo y:) 32))
		(super init:)
	)
)

(instance finishedPond of Feature
	(properties
		noun 3
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Do
				(gGame handsOff:)
				(= local2 1)
				(gEgo setScript: feelPond)
			)
			((OneOf theVerb 1 2) ; Look, Talk
				(if (IsFlag 13)
					(gMessager say: noun theVerb 4)
				else
					(gMessager say: noun theVerb 3)
				)
			)
			((OneOf theVerb 28 25 43 94 44 34) ; spellBook, holeInTheWall, huntersLamp, participle, teaCup, tomato
				(gMessager say: noun theVerb 0)
			)
			((== theVerb 54) ; lettuce (melted)
				(if (IsFlag 13)
					(gMessager say: noun theVerb 4) ; "A puddle of green water would have little impact on that cooling pond."
				else
					(gMessager say: noun theVerb 3) ; "A puddle of green water would have little effect on that boiling pond."
				)
			)
			((OneOf theVerb 52 53) ; lettuce, lettuce (melting)
				(gEgo setScript: throwLettuceInPond 0 theVerb)
			)
			((IsFlag 13)
				(gMessager say: noun 0 4) ; "Alexander has no reason to toss that in the cooling pond."
			)
			(else
				(gMessager say: noun 0 3) ; "That would have no effect on the boiling pond."
			)
		)
	)
)

(instance boilingPond of Prop
	(properties
		x 85
		y 150
		noun 3
		view 524
	)

	(method (doVerb theVerb)
		(finishedPond doVerb: theVerb &rest)
	)
)

(instance bunny of Actor
	(properties
		x 143
		y 176
		noun 13
		view 503
		loop 2
	)

	(method (init)
		(self ignoreActors: 1 setLoop: (self loop:))
		(super init: &rest)
	)
)

(instance feelPond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 99 148 self)
			)
			(1
				(gEgo
					view: 521
					normal: 0
					cycleSpeed: 10
					setLoop: 3
					posn: 110 154
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo reset: posn: 99 148)
				(= cycles 2)
			)
			(3
				(if (IsFlag 13)
					(gMessager say: 3 5 4 0 self) ; "The pond is no longer boiling, but it's still pretty hot."
				else
					(gMessager say: 3 5 3 0 self) ; "OUCH! That water is HOT!"
				)
			)
			(4
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 119 99 self)
			)
			(1
				(gEgo setHeading: 315)
				(theHuntersLamp dispose:)
				(gEgo
					normal: 0
					view: 523
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gMessager say: 4 5 4 1 self) ; "Alexander takes the old hunter's lamp from the tree."
			)
			(3
				(gGame handsOn:)
				(gEgo reset: 1)
				(gEgo get: 19) ; huntersLamp
				(gGame givePoints: 1)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance throwLettuceInPond of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 113 159 self)
			)
			(1
				(gEgo setHeading: 0)
				(= ticks 6)
			)
			(2
				(if (IsFlag 13)
					(gMessager say: 3 52 4 1 self) ; "Alexander tosses another head of iceberg lettuce into the cooling pond."
				else
					(gMessager say: 3 52 3 1 self) ; "Hoping to cool down the boiling pond, Alexander throws in a head of iceberg lettuce."
				)
			)
			(3
				(gEgo
					view: 521
					normal: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(4
				(splash init: setPri: 10 setCycle: CT 3 1 self)
			)
			(5
				(pondWalk number: 923 loop: 1 play:)
				(splash setCycle: End self)
			)
			(6
				(splash dispose:)
				(gEgo put: 21 gCurRoomNum reset: 3) ; lettuce
				((ScriptID 0 7) dispose:) ; lettuceTimer
				(= ticks 12)
			)
			(7
				(gGame handsOn:)
				(if (IsFlag 13)
					(gMessager say: 3 52 4 2 self) ; "It doesn't seem to make much of a difference."
					(self dispose:)
				else
					(SetFlag 13)
					(gGame givePoints: 4)
					(boilingPond
						setLoop: 1
						cel: 0
						posn: 92 150
						cycleSpeed: 24
						setCycle: End self
					)
					(boilFx stop:)
				)
			)
			(8
				(gMessager say: 3 52 3 2 self) ; "The pond's water slowly stops boiling, cooled by the ice. It still looks hot, but bearable."
			)
			(9
				(boilingPond view: 525 setLoop: 0 posn: 141 125 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance pondWalk of Sound
	(properties
		number 920
		loop -1
	)
)

(instance bravePond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (IsFlag 13))
						(= cycles 1)
					)
					((not (IsFlag 83))
						(gMessager say: 3 3 5 1 self) ; "Alexander decides to brave the steaming pond."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (IsFlag 13)
					(gEgo
						illegalBits: 0
						view: 521
						setPri: 14
						setSpeed: 6
						ignoreActors: 1
					)
					(if (< (gEgo y:) 110)
						(gEgo setLoop: 5 setMotion: PolyPath 110 143 self)
					else
						(gEgo setLoop: 4 setMotion: PolyPath 137 107 self)
					)
					(pondWalk number: 920 loop: -1 play:)
				else
					(self setScript: egoBoilsScript)
				)
			)
			(2
				(pondWalk stop:)
				(if (== (gEgo loop:) 5)
					(gEgo reset: setMotion: PolyPath 94 154 self)
				else
					(gEgo reset: setMotion: PolyPath 139 102 self)
				)
			)
			(3
				(if (IsFlag 83)
					(= cycles 1)
				else
					(gMessager say: 3 3 5 2 self) ; "OUCH! OW! OOH! OUCH!"
				)
			)
			(4
				(gEgo reset:)
				(if (not (IsFlag 83))
					(SetFlag 83)
					(gMessager say: 3 3 5 3 self) ; "The pond is no longer boiling, but it's hardly bath water."
				else
					(= cycles 1)
				)
			)
			(5
				(cond
					(local1
						(gGame handsOff:)
						(gEgo setScript: getLamp)
					)
					(local2
						(gGame handsOff:)
						(gEgo setScript: feelPond)
					)
					(else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoBoilsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 3 3 1 self) ; "Alexander decides to brave the boiling pond...."
			)
			(1
				(gEgo
					view: 521
					normal: 0
					setLoop: 4
					cycleSpeed: 12
					setMotion:
						PolyPath
						(+ (gEgo x:) 2)
						(- (gEgo y:) 3)
						self
				)
			)
			(2
				(boilDeath play:)
				(gEgo setLoop: 0 cel: 0 cycleSpeed: 24 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(gMessager say: 3 3 3 2 self) ; "And soon realizes a deep sympathy for soup vegetables as he learns the true meaning of "being in a stew.""
			)
			(4
				(= local0 0)
				(EgoDead 5) ; "It looks like Alexander's in a bit of a stew."
			)
		)
	)
)

(instance mushrooms of Feature
	(properties
		noun 8
		onMeCheck 4
	)
)

(instance frontPath of Feature
	(properties
		noun 6
		onMeCheck 16
	)
)

(instance backPath of Feature
	(properties
		noun 7
		onMeCheck 8
	)
)

(instance banks of Feature
	(properties
		noun 10
		onMeCheck 32
	)
)

(instance rocks of Feature
	(properties
		noun 2
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 2 0 0 0) ; "This heavily-forested isle is dotted with rough granite rocks."
			)
			((OneOf theVerb 1 2 5) ; Look, Talk, Do
				(gMessager say: noun theVerb 0 0 0 0)
			)
			(else
				(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
			)
		)
	)
)

(instance trees of Feature
	(properties
		noun 9
		onMeCheck 128
	)
)

(instance squirrel of Prop
	(properties
		x 204
		y 179
		view 520
		loop 5
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 13)
			(self setScript: squirrelScript)
		else
			(self stopUpd:)
		)
	)
)

(instance squirrelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bunnyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bunny setCycle: Fwd setMotion: MoveTo 206 179 self)
			)
			(1
				(bunny setLoop: 3 setCycle: End self)
			)
			(2
				(bunny setCycle: End self)
			)
			(3
				(bunny setLoop: 2 setCycle: Fwd setMotion: MoveTo 244 207 self)
			)
			(4
				(client dispose:)
			)
		)
	)
)

