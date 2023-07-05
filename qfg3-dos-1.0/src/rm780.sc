;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm780 0
)

(local
	local0
	local1
)

(instance rm780 of Rm
	(properties
		noun 10
		picture 780
	)

	(method (init)
		(gEgo setScale: 190 x: 5 y: 76 init: normalize:)
		(HandsOn)
		(gTheIconBar disable: 6)
		(super init:)
		(if gNight
			(gLongSong2 number: 927 setLoop: -1 play: 127)
		else
			(gLongSong2 number: 914 setLoop: -1 play: 127)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 170 120 170 123 204 123 204 120 173 120
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 168 111 129 126 48 126 48 139 147 156 213 146 230 137 143 143 129 147 55 136 55 130 132 130 187 109 195 104 124 104 0 73 0 92 137 111
					yourself:
				)
		)
		(egoTell init: gEgo)
		(platform init:)
		(stream init:)
		(purpleLeaves init:)
		(purpleTree init:)
		(purpleBranch init:)
		(orangeTree init:)
		(fungi init:)
		(flower init:)
		(if (> (gGame detailLevel:) 2)
			(water1 setCycle: Fwd init:)
			(water2 setCycle: Fwd init:)
		)
		(gWalkHandler addToFront: platform)
		(gCurRoom setScript: egoEnters)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(83 ; forceBoltSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(20 ; theDaggers
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(88 ; lightningBallSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(33 ; theRocks
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(78 ; dazzleSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(76 ; detectMagicSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(84 ; levitateSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(80 ; calmSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(86 ; jugglingLightsSpell
				(gMessager say: 1 6 3) ; "You feel too happy to do that here."
			)
			(74 ; Sleep
				(if (== local0 0)
					(self setScript: goToBed)
				else
					(gMessager say: 1 6 4) ; "There is not enough room for you to sleep comfortably on the platform. Perhaps you should get down first."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: platform)
		(super dispose:)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 147 148 self)
			)
			(1
				(gEgo view: 35 loop: 0 cel: 0 x: 166 setCycle: End self)
			)
			(2
				(if (= temp0 (PalVary pvGET_CURRENT_STEP))
					(if (< temp0 64)
						(PalVary pvCHANGE_TICKS 3)
						(= seconds 5)
					else
						(self cue:)
					)
				else
					(PalVary pvINIT 310 3)
					(IsFlag 81)
					(= seconds 15)
				)
			)
			(3
				(PalVary pvREVERSE 3)
				(ClearFlag 81)
				(= seconds 4)
			)
			(4
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 6 cel: 6 x: 147 changeGait: 0 code: outChek) ; walking
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance climbDownPlatform of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gLongSong number:) 782)
					(gLongSong number: 780 setLoop: -1 play: 127)
				)
				(gEgo setMotion: MoveTo 161 124 self)
			)
			(1
				(gEgo setMotion: MoveTo 194 133 self)
			)
			(2
				(gEgo setMotion: MoveTo 172 137 self)
			)
			(3
				(gEgo setLoop: 3 setMotion: MoveTo 163 155 self)
			)
			(4
				(gEgo
					setLoop: -1
					code: outChek
					setMotion: MoveTo 139 146 self
				)
			)
			(5
				(gEgo setPri: -1 setScale: 190)
				(HandsOn)
				(gTheIconBar disable: 6)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance climbOntoPlatform of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 139 146 self)
			)
			(1
				(gEgo setScale: setPri: 12 setMotion: MoveTo 163 155 self)
			)
			(2
				(gEgo setPri: 12 setLoop: 2 setMotion: MoveTo 172 137 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 194 133 self)
			)
			(4
				(gEgo setMotion: MoveTo 161 124 self)
			)
			(5
				(gEgo setMotion: MoveTo 187 122 self)
			)
			(6
				(gEgo code: downChek setHeading: 180)
				(HandsOn)
				(gTheIconBar disable: 6)
				(= local0 1)
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
				(HandsOff)
				(= [gEgoStats 18] (gEgo maxMana:)) ; mana
				(= [gEgoStats 16] (gEgo maxHealth:)) ; health
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(gLongSong fade: self)
			)
			(1
				(gLongSong number: 780 setLoop: -1 play: 127)
				(gMessager say: 1 6 1 0 self) ; "An incredible feeling of living energy flows through you as you enter. You smell the perfumes of thousands of different flowers, all blending together to overwhelm your senses."
			)
			(2
				(gEgo setMotion: PolyPath 147 148 self)
			)
			(3
				(gEgo code: outChek setHeading: 180)
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance giveItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 0)
					(self setScript: climbOntoPlatform self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(gEgo view: 4 loop: 0 setCycle: End self)
			)
			(2
				(if (not local1)
					(gMessager say: 1 6 8) ; "You gently place the glowing blue orchid on the platform."
				)
				(gEgo setCycle: Beg self)
				(gLongSong number: 783 setLoop: 1 play: 127 self)
			)
			(3)
			(4
				(gLongSong number: 783 setLoop: 1 play: 127 self)
				(if local1
					(thatOldFruit init: setPri: 12)
					(gEgo drop: 37 1 get: 15) ; thePeaceWater, theWaterskin
					(gMessager say: 1 6 7 0 self) ; "You empty the skin of peace water onto the spiral platform. A few moments later a new fruit appears on the branch near you. This must be your "gift from the heart"! You take the gift and carefully place it in your pack."
				else
					(gEgo normalize: setPri: 12 setHeading: 270)
					(thatOldStaff init: cycleSpeed: 7 setCycle: End self)
					(gEgo drop: 39) ; theOrchid
				)
			)
			(5)
			(6
				(gLongSong number: 782 setLoop: -1 play: 127)
				(gEgo normalize: setPri: 12 setMotion: MoveTo 178 122 self)
			)
			(7
				(gEgo view: 31 loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(if local1
					(thatOldFruit dispose:)
					(gEgo setCycle: Beg self)
				else
					(thatOldStaff dispose:)
					(gEgo setCycle: Beg self)
				)
			)
			(9
				(if local1
					(gEgo get: 38 solvePuzzle: 327 5 normalize: setPri: 12) ; theHeartGift
					(SetFlag 157)
				else
					(gEgo get: 44 solvePuzzle: 328 5 2 normalize: setPri: 12) ; theWood
					(gMessager say: 1 6 9) ; "You pluck the magical piece of wood from the tree."
				)
				(HandsOn)
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance thatOldFruit of Prop
	(properties
		x 177
		y 75
		view 790
		signal 16384
	)
)

(instance thatOldStaff of Prop
	(properties
		x 143
		y 83
		view 781
		loop 1
		signal 16384
	)
)

(instance stepFeat of Feature ; UNUSED
	(properties
		x 180
		y 141
		nsTop 121
		nsLeft 147
		nsBottom 161
		nsRight 213
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local0 0)
					(gCurRoom setScript: climbOntoPlatform)
				else
					(gCurRoom setScript: climbDownPlatform)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance water1 of Prop
	(properties
		x 203
		y 189
		view 780
		priority 14
		signal 16400
		detailLevel 3
	)
)

(instance water2 of Prop
	(properties
		x 245
		y 189
		view 780
		loop 1
		priority 14
		signal 16400
		detailLevel 3
	)
)

(instance egoTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if local0
			(platform doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFx of GlorySong ; UNUSED
	(properties)
)

(instance platform of Feature
	(properties
		x 186
		y 119
		z 1
		noun 8
		nsTop 119
		nsLeft 150
		nsBottom 165
		nsRight 210
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; theOrchid
				(if ((gInventory at: 39) state:) ; theOrchid
					(= local1 0)
					(SetFlag 139)
					(if (not (IsFlag 139))
						(gEgo addHonor: 20)
					)
					(gCurRoom setScript: giveItem)
				else
					(gMessager say: 1 6 5) ; "You carefully place the orchid on the platform, but nothing happens. Something is not quite right, so you pick up the orchid and put it away for later."
				)
			)
			(48 ; thePeaceWater
				(= local1 1)
				(if (not (IsFlag 138))
					(gEgo addHonor: 20)
					(SetFlag 138)
					(gCurRoom setScript: giveItem)
				else
					(gMessager say: 1 6 6) ; "You have already received a gift from the Heart of the World."
				)
			)
			(4 ; Do
				(if (== local0 0)
					(gCurRoom setScript: climbOntoPlatform)
				else
					(gCurRoom setScript: climbDownPlatform)
				)
			)
			(3 ; Walk
				(if (== local0 0)
					(gCurRoom setScript: climbOntoPlatform)
				else
					(gCurRoom setScript: climbDownPlatform)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stream of Feature
	(properties
		x 231
		y 173
		noun 2
		nsTop 157
		nsLeft 165
		nsBottom 189
		nsRight 298
		sightAngle 180
	)
)

(instance purpleLeaves of Feature
	(properties
		x 249
		y 21
		noun 3
		nsTop -2
		nsLeft 180
		nsBottom 45
		nsRight 319
		sightAngle 180
	)
)

(instance purpleTree of Feature
	(properties
		x 259
		y 95
		noun 9
		nsTop 48
		nsLeft 223
		nsBottom 142
		nsRight 295
		sightAngle 180
	)
)

(instance purpleBranch of Feature
	(properties
		x 177
		y 72
		noun 4
		nsTop 48
		nsLeft 132
		nsBottom 97
		nsRight 222
		sightAngle 180
	)
)

(instance orangeTree of Feature
	(properties
		x 99
		y 71
		noun 5
		nsTop 42
		nsLeft 71
		nsBottom 101
		nsRight 127
		sightAngle 180
	)
)

(instance fungi of Feature
	(properties
		x 82
		y 169
		noun 6
		nsTop 150
		nsLeft 38
		nsBottom 189
		nsRight 127
		sightAngle 180
	)
)

(instance flower of Feature
	(properties
		x 301
		y 147
		noun 7
		nsTop 138
		nsLeft 288
		nsBottom 157
		nsRight 315
		sightAngle 180
	)
)

(instance outChek of Code
	(properties)

	(method (doit)
		(if (gEgo inRect: 0 50 50 95)
			(gCurRoom newRoom: 760)
		)
	)
)

(instance downChek of Code
	(properties)

	(method (doit)
		(if (< (gEgo x:) 174)
			(gEgo code: outChek)
			(gCurRoom setScript: climbDownPlatform)
		)
	)
)

