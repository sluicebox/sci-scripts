;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
)

(local
	local0
)

(instance rm560 of KQ6Room
	(properties
		noun 3
		picture 560
		horizon 0
		east 580
		south 550
		vanishingY -200
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 164 152 137 160 119 162 83 158 75 151 74 148 68 139 78 134 94 128 138 128 158 147
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 132 232 148 201 147 196 141 221 137 197 134 182 128 169 132 159 125 147 118 168 117 191 94 161 94 149 98 140 108 91 96 70 113 43 104 15 97 13 99 38 105 74 122 62 128 62 143 56 145 33 148 26 166 19 184 78 184 88 171 110 171 130 177 136 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 244 189 248 186 319 186
					yourself:
				)
		)
		(stairs init:)
		(rocks init:)
		(bear init:)
		(skull init:)
		(pit init:)
		(doors init: approachVerbs: 1 5 2) ; Look, Do, Talk
		(trees init: approachVerbs: 2) ; Talk
		(roomPath init:)
		(if (== ((gInventory at: 42) owner:) 560) ; scythe
			(scythe init: stopUpd: setPri: 13)
		)
		(gCurRoom setScript: egoEnters)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $0800)
				(gGame handsOff:)
				(self setScript: backUpScript)
			)
			((and (& temp0 $0080) (not (== (gEgo priority:) 14)))
				(gEgo setPri: 14)
				(= local0 1)
			)
			((and (not (& temp0 $0080)) local0)
				(gEgo setPri: -1)
				(= local0 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance trees of Feature
	(properties
		noun 9
		onMeCheck 2
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (<= gMouseX 180)
				(self approachX: 92 approachY: 107 x: 53 y: 70)
			else
				(self approachX: 197 approachY: 143 x: 249 y: 105)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 2) ; Talk
				(super doVerb: theVerb &rest)
			)
			((IsFlag 25)
				(gMessager say: noun theVerb 4)
			)
			(else
				(gMessager say: noun theVerb 3)
			)
		)
	)
)

(instance roomPath of Feature
	(properties
		noun 10
		onMeCheck 256
	)
)

(instance rocks of Feature
	(properties
		noun 2
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 10 0 0 0) ; "Mysterious-looking volcanic rocks dot this island."
			)
			((OneOf theVerb 2 5) ; Talk, Do
				(gMessager say: noun theVerb 0 0 0 0)
			)
			(else
				(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
			)
		)
	)
)

(instance bear of Feature
	(properties
		noun 12
		onMeCheck 16
	)
)

(instance stairs of Feature
	(properties
		noun 13
		onMeCheck 128
	)
)

(instance doors of Feature
	(properties
		noun 7
		onMeCheck 4
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (<= gMouseX 180)
				(self approachX: 92 approachY: 107 x: 53 y: 70)
			else
				(self approachX: 197 approachY: 143 x: 249 y: 105)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 8 16 35) ; dagger, scythe, skeletonKey
				(gMessager say: noun theVerb 0)
			)
			((OneOf theVerb 2 5) ; Talk, Do
				(if (IsFlag 25)
					(gMessager say: noun theVerb 4)
				else
					(gMessager say: noun theVerb 3)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skull of Feature
	(properties
		noun 8
		onMeCheck 64
	)
)

(instance pit of Feature
	(properties
		noun 5
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gCurRoom setScript: lookFireKludgeScript)
			)
			((!= theVerb 5) ; Do
				(super doVerb: theVerb &rest)
			)
			((!= ((gInventory at: 6) owner:) 560) ; coal
				(gMessager say: noun theVerb 6)
			)
			(else
				(gCurRoom setScript: getCoal)
			)
		)
	)
)

(instance scythe of View
	(properties
		x 15
		y 45
		noun 4
		view 560
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: getScythe)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lookFireKludgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 1 0 1 self) ; "A communal fire pit occupies a place of honor in the center of the little village. The fire pit, naturally enough, contains coal."
			)
			(1
				(if (not (IsFlag 14))
					(gMessager say: 5 1 8 1 self) ; "The coals are cold. That's odd, because Alexander definitely smells the smoke of an open fire close by."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance backUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 7 0 self) ; "The way north is blocked by impenetrable forest."
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound3 number: 580 loop: 1 flags: 1 play:)
				(if (== gPrevRoomNum 550)
					(gEgo
						init:
						posn: 150 188
						setScale: Scaler 100 75 190 84
						setMotion: MoveTo 150 170 self
					)
				else
					(gEgo
						init:
						posn: 318 162
						setScale: Scaler 100 75 190 84
						setMotion: MoveTo 250 162 self
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getCoal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 152 142 self)
			)
			(1
				(gEgo
					view: 561
					setPri: 14
					normal: 0
					setPri: 12
					setLoop: 1
					cel: 0
					cycleSpeed: 14
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gGame givePoints: 1)
				(gEgo get: 6 reset:) ; coal
				(gMessager say: 5 5 5 1 self) ; "Alexander reaches into the fire pit and takes a lump of coal."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getScythe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 34 103 self
				)
			)
			(1
				(scythe dispose:)
				(gEgo
					normal: 0
					view: 561
					cel: 0
					setLoop: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo get: 42) ; scythe
				(gGame givePoints: 1)
				(gMessager say: 4 5 0 1 self) ; "Alexander takes the scythe."
			)
			(3
				(gGame handsOn:)
				(gEgo reset:)
				(gEgo setPri: 14)
				(self dispose:)
			)
		)
	)
)

