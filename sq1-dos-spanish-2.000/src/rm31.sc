;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm31 0
)

(local
	[local0 8] = [114 160 133 169 157 177 171 183]
)

(instance rm31 of SQRoom
	(properties
		lookStr {This is another large chamber in the underground complex. Paths run along the top and bottom ledges.}
		picture 31
		east 30
		west 32
	)

	(method (init)
		(LoadMany rsVIEW 428 21 10)
		(LoadMany rsSOUND 449 425 450 426 451)
		(cond
			((== gPrevRoomNum 32)
				(= style 12)
			)
			((== gPrevRoomNum 30)
				(gEgo posn: 308 123)
				(= style 11)
			)
			(else
				(= style 11)
			)
		)
		(if (== global166 1)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 -100 319 -100 318 45 254 53 216 53 203 57 189 55 118 60 0 65
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 73 150 73 255 57 319 50 319 189 0 189
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 0 189 28 180 117 147 152 157 163 156 186 161 180 170 223 182 319 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 100 232 108 216 132 173 143 143 137 117 144 28 178 0 180
						yourself:
					)
			)
		)
		(grate init:)
		(frontOfGrate init:)
		(upperledge init:)
		(lowerLedge init:)
		(gEgo init:)
		(if (IsFlag 72)
			(stickyPlant init:)
		)
		(if (IsFlag 31)
			(grateMonster1 init:)
			(grateMonster2 init:)
			(eyeStalk init: setScript: waveYourEyeStalk)
			(if (IsFlag 21)
				(gLongSong2 number: 449 loop: -1 play:)
				(grateMonster1 setScript: tentacleStuck)
			else
				(gLongSong2 number: 425 loop: -1 play:)
				(tentacle1 init: hide:)
				(tentacle1 setScript: tentacleWave 0 0)
			)
		)
		(super init:)
		(HandsOn)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $0008)
				(gCurRoom newRoom: 34)
			)
			((and (not (IsFlag 31)) (& (gEgo onControl: 0) $2000))
				(gLongSong2 number: 425 loop: -1 play:)
				(SetFlag 31)
				(grateMonster1 init:)
				(grateMonster2 init:)
				(eyeStalk init: hide: setScript: waveYourEyeStalk)
				(tentacle1 init: hide:)
				(tentacle1 setScript: tentacleWave 0 0)
			)
			((and (not (IsFlag 21)) (& (gEgo onControl: 1) $4000))
				(HandsOff)
				(self setScript: monsterGrabsEgo)
			)
			((and (not (IsFlag 21)) (& (gEgo onControl: 1) $0200))
				(HandsOff)
				(self setScript: monsterGrabsEgoSide)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 31 0) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 31 1) ; "No one here cares what you have to say."
			)
			(12 ; Smell
				(Print 31 2) ; "You get a hint of sulfur in the musty air."
			)
			(11 ; Taste
				(Print 31 3) ; "Nothing worth tasting there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tentacleWave of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (IsFlag 21)
					(= state 4)
				else
					(= state register)
				)
				(= cycles 3)
			)
			(1
				(= temp0 (* 2 (Random 0 3)))
				(tentacle1
					setLoop: 7
					show:
					x: [local0 temp0]
					y: [local0 (+ temp0 1)]
					cel: 0
					show:
					setCycle: End self
				)
				(= register 1)
				(= state -1)
			)
			(2
				(tentacle1 setLoop: (Random 6 8) cel: 0 setCycle: End self)
				(= register 2)
				(= state -1)
			)
			(3
				(tentacle1 setCycle: Beg self)
				(= register 3)
				(= state -1)
			)
			(4
				(tentacle1 setLoop: 7 cel: 1)
				(= register 0)
				(= cycles 3)
			)
			(5
				(tentacle1 setCycle: Beg self)
			)
			(6
				(tentacle1 setLoop: 7 cel: 0 setCycle: Beg self)
			)
			(7
				(tentacle1 hide:)
				(if (not (IsFlag 21))
					(= state -1)
				)
				(= cycles 3)
			)
			(8
				(self setScript: tentacleGetsStuck self)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance tentacleGetsStuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tentacle2
					init:
					show:
					x: 150
					y: 175
					setLoop: 9
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gLongSong2 number: 450 loop: 1 play: self)
			)
			(2
				(self setScript: tentacleStuck self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance tentacleStuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 449 loop: -1 play:)
				(tentacle2
					init:
					x: 150
					y: 175
					setLoop: 10
					cel: 0
					cycleSpeed: 8
					setCycle: Osc
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance waveYourEyeStalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyeStalk hide: x: (Random 80 150) y: (Random 170 190))
				(= cycles (Random 60 180))
			)
			(1
				(eyeStalk show: setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(eyeStalk setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(eyeStalk setLoop: 3 cel: 0 setCycle: Osc 2 self)
			)
			(4
				(eyeStalk setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(self init:)
			)
		)
	)
)

(instance stickyPlant of Actor
	(properties
		x 211
		y 117
		description {sticky plant thing}
		lookStr {A piece of sticky plant is stuck to the floor.}
		yStep 13
		view 21
		loop 2
		priority 11
		signal 18448
		cycleSpeed 3
		xStep 13
		moveSpeed 3
	)

	(method (init)
		(self setCycle: End setMotion: MoveTo 171 163)
		(super init: &rest)
	)
)

(instance grateMonster1 of Actor
	(properties
		x 115
		y 200
		description {grate monster 1}
		sightAngle 45
		view 428
		priority 1
		signal 16400
		cycleSpeed 8
	)

	(method (init)
		(self setCycle: Fwd setLoop: 0 setMotion: MoveTo 115 189)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 21)
					(Print 31 4) ; "It's a grate monster. At the moment ,he's stuck on something - fortunately not you."
				else
					(Print 31 5) ; "It's a grate monster. I'll bet he's lonely and just wants to be your friend."
				)
			)
			(4 ; Inventory
				(grate doVerb: theVerb invItem &rest)
			)
			(12 ; Smell
				(Print 31 6) ; "It smells grate."
			)
			(11 ; Taste
				(Print 31 7) ; "I don't think you want to get that close. Then again, maybe you do."
			)
			(3 ; Do
				(if (IsFlag 21)
					(Print 31 8) ; "You now have a chance get your buns out of here. You'd better take advantage of the opportunity."
				else
					(Print 31 9) ; "Get closer."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance grateMonster2 of Actor
	(properties
		x 115
		y 200
		description {grate monster 2}
		sightAngle 45
		view 428
		cel 5
		priority 1
		signal 16400
		cycleSpeed 10
	)

	(method (init)
		(self setCycle: Fwd setLoop: 0 setMotion: MoveTo 115 189)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(grateMonster1 doVerb: theVerb invItem)
	)
)

(instance tentacle1 of Actor
	(properties
		x 126
		y 164
		description {tentacle 1}
		lookStr {Hey, this puppy has some keen-looking tentacles.}
		view 428
		loop 7
		priority 14
		signal 16400
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(grateMonster1 doVerb: theVerb invItem)
	)
)

(instance tentacle2 of Actor
	(properties
		x 161
		y 178
		description {tentacle 2}
		lookStr {Hey, this puppy has some keen-looking tentacles.}
		view 428
		loop 7
		signal 18432
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(grateMonster1 doVerb: theVerb invItem)
	)
)

(instance eyeStalk of Prop
	(properties
		x 125
		y 179
		description {creature eyestalk}
		lookStr {It's got the cutest little grey eye you've ever seen.}
		view 428
		loop 1
		signal 18432
		cycleSpeed 6
	)

	(method (doVerb theVerb invItem)
		(grateMonster1 doVerb: theVerb invItem)
	)
)

(instance upperledge of Feature
	(properties
		x 134
		y 55
		description {upper ledge}
		sightAngle 45
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gEgo onControl: 2)
					(Print 31 10) ; "This is the upper pathway."
				else
					(Print 31 11) ; "A path is visible there, but you can't seem to access it from here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerLedge of Feature
	(properties
		x 156
		y 142
		description {lowerledge}
		sightAngle 45
		onMeCheck 8208
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (gEgo onControl: 8208)
					(Print 31 12) ; "This is the lower pathway."
				else
					(Print 31 13) ; "There is a path there which you don't seem to have access to from here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance genericItem of Actor
	(properties
		x 205
		y 100
		view 810
		priority 5
		signal 16400
		cycleSpeed 5
	)
)

(instance frontOfGrate of Feature
	(properties
		description {front of grate area}
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 31 14) ; "It's more cave floor."
			)
			(4 ; Inventory
				(switch invItem
					(16 ; Plant
						(gEgo setScript: egoThrowsPlant)
					)
				)
			)
		)
	)
)

(instance grate of Feature
	(properties
		x 106
		y 181
		description {grate on floor}
		sightAngle 45
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 31)
					(Print 31 15) ; "The grate is made of metal and seems to be fastened securely to the floor. A strange tentacled beast lurks at the bottom of the pit."
				else
					(Print 31 16) ; "The grate is made of metal and seems to be fastened securely to the floor. It is too dark to see down through the grate. However, an odd smell emanates from the depths of the pit."
				)
			)
			(12 ; Smell
				(Print 31 6) ; "It smells grate."
			)
			(4 ; Inventory
				(switch invItem
					(16 ; Plant
						(gEgo setScript: egoThrowsPlant)
					)
					(10 ; buckazoid
						(Print 31 17) ; "This critter isn't interested in your money - he perfers raw, bleeding flesh."
					)
					(0 ; Cartridge
						(Print 31 18) ; "You doubt this hideous creature could help you read the cartridge."
					)
					(15 ; Widget
						(Print 31 19) ; "The monster is much less interested in the widget than in stripping the flesh from your bones."
					)
					(2 ; Gadget
						(Print 31 20) ; "The disgusting slimy, slimy, slurping, slithering sounds from the grate would not be improved by running them through the translator gadget."
					)
					(4 ; Knife
						(Print 31 21) ; "You might be able to cut off one head, but, meanwhile, the others would be turning you into fresh-ground turkey."
					)
					(5 ; Dehydrated_Water
						(Print 31 22) ; "You really don't feel like sharing your precious dehydrated water with snake-face here."
					)
					(8 ; Orat_Part
						(Print 31 23) ; "He's hungry, but not THAT hungry."
					)
					(else
						(cond
							((IsFlag 21)
								(Print 31 24) ; "Don't waste your time. It's already stuck and you've got better things to do."
							)
							((IsFlag 31)
								(if (== global166 1)
									(Print 31 25) ; "You don't need to do that again."
								else
									(tentacle2 init: hide:)
									(tentacle2 setScript: egoThrowsWrongItem)
								)
							)
							(else
								(Print 31 26) ; "Don't waste your time. You've got better things to do than throw your items in an empty pit."
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance monsterGrabsEgoSide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: (gEgo loop:) setMotion: MoveTo 25 183 self)
				(tentacle2
					init:
					x: 61
					y: 189
					setPri: 14
					view: 21
					setLoop: 4
					cel: 0
					setCycle: CT 1 1
				)
			)
			(1
				(tentacle2 setCycle: CT 3 1 self)
			)
			(2
				(tentacle2 cel: 4)
				(gEgo hide:)
				(= cycles 1)
			)
			(3
				(tentacle2 setCycle: CT 7 1 self)
			)
			(4
				(gLongSong2 number: 366 loop: 1 play:)
				(tentacle2 cel: 8 setCycle: End self)
			)
			(5
				(gLongSong2 number: 426 loop: 1 play:)
				(Print 31 27) ; "CRUNCH! CRUNCH! CRUNCH!"
				(= seconds 4)
			)
			(6
				(Print 31 28) ; "You've been snatched out of existence by the tentacled beast lurking beneath the grate. You feel the painful sting of digestive fluids."
				(EgoDead 943 0 0 31 29) ; "Don't stop now. We're having so much fun watching you."
				(self dispose:)
			)
		)
	)
)

(instance monsterGrabsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setLoop: 5)
				(= cycles 3)
			)
			(1
				(tentacle2
					init:
					view: 428
					setLoop: 7
					cel: 0
					show:
					x: (- (gEgo x:) 35)
					y: (+ (gEgo y:) 7)
					setCycle: End self
				)
			)
			(2
				(tentacle2 view: 21 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gEgo hide:)
				(tentacle2 cel: 4 setCycle: CT 7 1 self)
			)
			(4
				(gLongSong2 number: 366 loop: 1 play:)
				(tentacle2 cel: 8 setCycle: End self)
			)
			(5
				(gLongSong2 number: 426 loop: 1 play:)
				(Print 31 27) ; "CRUNCH! CRUNCH! CRUNCH!"
				(= seconds 4)
			)
			(6
				(Print 31 28) ; "You've been snatched out of existence by the tentacled beast lurking beneath the grate. You feel the painful sting of digestive fluids."
				(EgoDead 943 0 0 31 29) ; "Don't stop now. We're having so much fun watching you."
			)
		)
	)
)

(instance egoThrowsWrongItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 250 138 self)
			)
			(1
				(Face gEgo grateMonster1)
				(= cycles 3)
			)
			(2
				(gEgo view: 21 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
				(self setScript: tentacleKnocksItBack)
			)
			(3
				(= ticks 10)
			)
			(4
				(genericItem
					init:
					setLoop: 5
					xStep: 6
					yStep: 6
					setCycle: Fwd
					cycleSpeed: 0
					setMotion: MoveTo 176 139 self
				)
				(gEgo setCycle: End)
			)
			(5
				(genericItem setMotion: MoveTo 205 148 self)
			)
			(6
				(genericItem setMotion: MoveTo 210 140 self)
			)
			(7
				(genericItem setMotion: MoveTo 216 143 self)
			)
			(8
				(gEgo view: 10 setLoop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(9
				(genericItem dispose:)
				(gEgo setCycle: End self)
			)
			(10
				(Print 31 30) ; "Maybe you should've kept that after all."
				(SetFlag 31)
				(NormalEgo 1 1 61)
			)
		)
	)
)

(instance tentacleKnocksItBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tentacle2
					show:
					cycleSpeed: 4
					x: 138
					y: 170
					view: 428
					setLoop: 6
					cel: 0
				)
				(= cycles 12)
			)
			(1
				(tentacle2 setCycle: End self)
			)
			(2
				(gSoundEffects number: 451 loop: 1 play:)
				(tentacle2 setCycle: Beg self)
			)
			(3
				(tentacle2 hide:)
			)
		)
	)
)

(instance egoThrowsPlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((IsFlag 21)
						(Print 31 31) ; "It's already stuck and you have better things to do."
						(self dispose:)
					)
					((not (IsFlag 31))
						(Print 31 32) ; "Don't waste your time. You've got better things to do."
						(self dispose:)
					)
					(else
						(HandsOff)
						(gEgo setMotion: PolyPath 249 132 self)
					)
				)
			)
			(1
				(Face gEgo grateMonster1)
				(= cycles 3)
			)
			(2
				(gEgo view: 21 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(stickyPlant init:)
				(gEgo put: 16 31) ; Plant
				(if (IsFlag 31)
					(SetFlag 21)
					(SetScore 5 144)
				)
				(gEgo setCycle: End self)
			)
			(4
				(NormalEgo 1 1 61)
				(= seconds 8)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

