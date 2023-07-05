;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PChase)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm28 0
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
	[local9 46] = [0 0 319 0 319 189 247 189 311 139 295 121 269 123 256 108 218 106 200 98 162 93 129 95 91 105 71 116 110 122 105 132 56 133 88 146 75 156 21 159 11 153 24 142 0 148]
	[local55 28] = [0 0 319 0 319 189 128 189 188 122 110 122 105 132 56 133 88 146 75 156 21 159 11 153 24 142 0 148]
)

(instance rm28 of SQRoom
	(properties
		picture 28
		south 24
		west 24
	)

	(method (init)
		(= global166 2)
		(if (= local0 (not (IsFlag 59)))
			(roomPoly points: @local55 size: 14)
		else
			(roomPoly points: @local9 size: 23)
		)
		(self addObstacle: roomPoly)
		(LoadMany rsVIEW 128 10 19)
		(Load rsSOUND 452)
		(cond
			(local0
				(orat init: stopUpd:)
				(LoadMany rsVIEW 424)
				(LoadMany rsSOUND 420)
				(if global181
					(LoadMany rsVIEW 422 328)
					(Load rsSOUND 411)
				)
			)
			(
				(= local1
					(if (not (IsFlag 60))
						(IsFlag 59)
					)
				)
				(part init:)
			)
		)
		(gEgo init:)
		(self setScript: intoCave)
		(super init:)
		(skullHoles init:)
		(farWall init:)
		(nearWall init:)
		(skulls init:)
		(bigRock init:)
		(smallRock init:)
		(floor init:)
		(gLongSong number: (if (IsFlag 59) 420 else 415) loop: -1 play:)
	)

	(method (newRoom)
		(gLongSong fade:)
		(super newRoom: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 59)
					(Print 28 0) ; "You notice a fine spray of glistening, metallic jelly decorating the walls. Otherwise, it's still the same old homey cave-in-a-skull."
				else
					(Print 28 1) ; "This skull makes a darn comfortable little cave if you ignore the disturbing human-size remains in the back."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance intoCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: -9 203 setMotion: MoveTo 51 175 self)
			)
			(1
				(if local0
					(gEgo setScript: noticeEgo)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 11 150 self)
			)
			(1
				(gEgo
					view: 19
					setLoop: 1
					cel: 0
					posn: 38 147
					cycleSpeed: 16
					setCycle: End self
				)
			)
			(2
				(gEgo stopUpd:)
				(if (and global181 local0)
					((ScriptID 704 3) ; spider
						init:
						view: 422
						setCycle: Walk
						setLoop: 0
						z: 0
						posn: -30 203
						setMotion: MoveTo 72 168 self
					)
					(= global183 3000)
				else
					(gEgo setScript: 0)
					(gCurRoom setScript: egoReadyToComeOut)
				)
			)
			(3
				(orat setLoop: 3 forceUpd:)
				((ScriptID 704 3) setMotion: MoveTo 130 130 self) ; spider
				(Print 28 2) ; "You shiver at the sight of the spider droid entering the cave on its spindly legs. The cold metallic body searches for something to get up close and personal with. This could be interesting."
			)
			(4
				(= local5 1)
				(orat cycleSpeed: 15 cel: 0 setCycle: Osc 1)
				((ScriptID 704 3) setMotion: MoveTo 180 118 self) ; spider
			)
			(5
				(= local5 0)
				(orat setLoop: 2 cel: 0 cycleSpeed: 20 setCycle: End self)
			)
			(6
				((ScriptID 704 3) ; spider
					view: 328
					setLoop: 0
					cel: 0
					setPri: (+ (orat priority:) 1)
					cycleSpeed: 15
					setCycle: CT 1 1 self
				)
				(gSoundEffects number: 411 loop: 1 play:)
			)
			(7
				(orat hide:)
				((ScriptID 704 3) cycleSpeed: 12 setCycle: End self) ; spider
			)
			(8
				(gLongSong fade:)
				(orat
					show:
					setLoop: 4
					cel: 6
					cycleSpeed: 10
					setCycle: CT 8 1 self
				)
				(ClearFlag 55)
				(= global181 0)
				(SetScore 5 148)
				((ScriptID 704 3) dispose:) ; spider
			)
			(9
				(gSoundEffects number: 419 loop: 1 play:)
				(orat setCycle: End self)
			)
			(10
				(gLongSong number: 420 loop: -1 play: 0 fade: 127 25 10 0)
				(orat dispose:)
				(part init:)
				(= local0 0)
				(= local1 1)
				(SetFlag 59)
				(SetScore 5 149)
				(gEgo setCycle: Beg self)
			)
			(11
				(NormalEgo 0 1 61)
				(gEgo setMotion: MoveTo 109 130 self)
			)
			(12
				(Print 28 3) ; "Now THAT was cool! That killed two problems with no stones."
				(roomPoly points: @local9 size: 24)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoReadyToComeOut of Script
	(properties)

	(method (init)
		(super init: &rest)
		(HandsOn)
		(User canControl: 0)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(if (== (event message:) JOY_UP)
					(= local4 1)
					(if (OnControl CONTROL (event x:) (event y:))
						(= local2 162)
					else
						(= local2 (event x:))
					)
					(= local3 (event y:))
				)
				(event claimed: 1)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
			)
			(1
				(HandsOff)
				(gEgo
					posn: 19 147
					view: 19
					setLoop: 2
					cel: 0
					cycleSpeed: 30
					setCycle: End self
				)
			)
			(2
				(if local4
					(NormalEgo 0 1 61)
					(gEgo setMotion: PolyPath local2 local3 self)
				else
					(self cue:)
				)
			)
			(3
				(NormalEgo 0 1 61)
				(HandsOn)
				(= local4 0)
				(if (and local0 (!= next egoThrowsWater))
					(gEgo setScript: noticeEgo)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoThrowsWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(water init: hide:)
				(= global183 11000)
				(orat
					cycleSpeed: 8
					view: 424
					setLoop: 3
					cel: 0
					setCycle: CT Osc
				)
				(gEgo
					cycleSpeed: 8
					view: 19
					setLoop: 0
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(water
					show:
					cycleSpeed: 4
					posn: (+ (gEgo x:) 54) (- (gEgo y:) 34)
				)
				(orat cycleSpeed: 12 cel: 1 setCycle: CT 2 1)
				(= cycles 2)
			)
			(2
				(water
					cycleSpeed: 18
					moveSpeed: 11
					setCycle: Fwd
					setMotion: JumpTo (- (orat x:) 8) (- (orat y:) 48) self
				)
				(gEgo setCycle: End put: 5) ; Dehydrated_Water
			)
			(3
				(NormalEgo 0 1 61)
				(gEgo loop: 6 heading: 45)
				(orat setCycle: End self)
				(gSoundEffects number: 417 loop: 1 play:)
				(water dispose:)
			)
			(4
				(gLongSong fade:)
				(orat setLoop: 4 cycleSpeed: 12 cel: 0 setCycle: CT 3 1 self)
				(Print 28 4) ; "Orat, always in the mood for a snack, snatches the can out of the air with his spacious oral cavity, chews and swallows it. He notices a rumbling deep within his abdomen."
			)
			(5
				(gLongSong2 number: 418 loop: 1 play:)
				(orat setCycle: CT 8 1 self)
			)
			(6
				(gSoundEffects number: 419 loop: 1 play:)
				(orat setCycle: End self)
			)
			(7
				(gLongSong number: 420 loop: -1 play: 0 fade: 127 25 10 0)
				(orat dispose:)
				(part init:)
				(= local0 0)
				(= local1 1)
				(SetFlag 59)
				(SetScore 5 149)
				(roomPoly points: @local9 size: 24)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance noticeEgo of Script
	(properties)

	(method (doit)
		(if (and local6 (== (gEgo cel:) 2) (!= local7 (gEgo cel:)))
			(gSoundEffects number: 452 loop: 1 play:)
		)
		(cond
			(local4 0)
			((and (& (gEgo onControl: 1) $4000) (not local8) (not local4))
				(if state
					(Print 28 5) ; "It's too late for that! You'd best jam!!"
					(HandsOff)
					(= local8 1)
					(gEgo setMotion: MoveTo (gEgo x:) 200)
				else
					(gEgo setScript: egoHides)
				)
			)
			((and (<= state 1) (!= (gEgo view:) 19) (<= (gEgo y:) 148))
				(= state 1)
				(self cue:)
			)
		)
		(super doit: &rest)
		(= local7 (gEgo cel:))
	)

	(method (dispose)
		(= local5 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(= local5 1)
				(orat setLoop: 3 cel: 0 cycleSpeed: 18 setCycle: Osc 2 self)
			)
			(2
				(= local5 0)
				(if (< (gEgo y:) 190)
					(gEgo setMotion: 0)
					(orat
						setLoop: 0
						cycleSpeed: 2
						moveSpeed: 2
						setCycle: Walk
						setMotion: PChase gEgo 30 self
					)
				)
			)
			(3
				(HandsOff)
				(Face gEgo orat self)
			)
			(4
				(Print 28 6) ; "OH, NOOOOO!!!"
				(orat setMotion: MoveTo (+ (gEgo x:) 18) (gEgo y:) self)
			)
			(5
				(gEgo hide:)
				(orat
					ignoreActors: 1
					view: 19
					setLoop: 3
					cel: 0
					cycleSpeed: 18
					setCycle: CT 7 1 self
				)
			)
			(6
				(gSoundEffects number: 453 loop: 1 play:)
				(orat cel: 8 setCycle: End self)
			)
			(7
				(gSoundEffects stop:)
				(= local6 1)
				(orat setLoop: 4 stopUpd:)
				(gEgo
					ignoreActors: 1
					show:
					posn: (- (orat x:) 20) (orat y:)
					view: 19
					setLoop: 5
					cel: 0
					cycleSpeed: 18
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(8
				(= local6 1)
				(Print 28 7) ; "Orat has transformed you into a new piece of recreational equipment. Along with finding this treatment extremely rude, you don't survive it."
				(EgoDead 19 6 0 28 8) ; "It's tough to make friends around here. Relax, stretch out, restore, and let's get back to it. There's adventuring to be done!"
			)
		)
	)
)

(instance orat of Actor
	(properties
		x 214
		y 113
		description {orat}
		lookStr {Orat is huge and ugly. Of course, your opinion may differ depending on what part of the universe you come from. You also get the impression that he might be quite mean.}
		yStep 4
		view 424
		loop 1
		signal 16384
		cycleSpeed 4
		xStep 6
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 19)
					(egoReadyToComeOut start: 1)
					(= local4 1)
					(= local2 x)
					(= local3 y)
					(gEgo setScript: 0)
					(gCurRoom setScript: egoReadyToComeOut)
				else
					(HandsOff)
					(gEgo setMotion: PolyPath (orat x:) (orat y:))
				)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; Dehydrated_Water
						(cond
							(
								(and
									(== (gEgo script:) noticeEgo)
									(>= (noticeEgo state:) 2)
								)
								(Print 28 9) ; "It's too late for that now. Orat has already tuned his taste buds to your flavor frequency!"
							)
							((== (gCurRoom script:) egoReadyToComeOut)
								(= local4 1)
								(= local2 120)
								(= local3 160)
								(gEgo setScript: 0)
								(egoReadyToComeOut next: egoThrowsWater cue:)
							)
							(else
								(gEgo setScript: egoThrowsWater)
							)
						)
					)
					(4 ; Knife
						(Print 28 10) ; "That thing? The knife can barely cut through rancid grell lard, much less the thick hide of Orat."
					)
					(10 ; buckazoid
						(Print 28 11) ; "You think you can buy this guy off?  HA!"
					)
					(0 ; Cartridge
						(Print 28 12) ; "The data cartridge seems to strike the orat as a big so what."
					)
					(15 ; Widget
						(Print 28 13) ; "The widget does not appear edible to the big smelly monster. On the other hand, you do."
					)
					(2 ; Gadget
						(Print 28 14) ; "Growwwwrrrr! Hmmm. Sounds the same in any language, doesn't it."
					)
					(3 ; Survival_Kit
						(Print 28 15) ; "Throwing him your survival kit does not seem the best strategy for your survival."
					)
					(16 ; Plant
						(Print 28 16) ; "Does he look like a vegetarian to you?"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(Print 28 17) ; "Though normally known for his intellectually stimulating conversation in the monster and beast community, Orat seems limited to grunts in the way of response to your probing questions."
			)
			(12 ; Smell
				(Print 28 18) ; "The stench? Phew! Not even a text adventure would attempt that description."
			)
			(11 ; Taste
				(Print 28 19) ; "You wouldn't want to do that. From the stench, you can make an educated guess, and it isn't a pleasant one."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== view 424) (== loop 3) (== cel 2) local5 (!= local7 cel))
			(gSoundEffects number: 416 loop: 1 play:)
		)
		(= local7 cel)
	)
)

(instance water of Actor
	(properties
		yStep 9
		view 128
		loop 1
		priority 9
		signal 18448
		xStep 6
	)
)

(instance waterMover of Jump ; UNUSED
	(properties
		gx -1
	)
)

(instance part of View
	(properties
		x 179
		y 117
		description {part of the orat}
		approachX 167
		approachY 127
		lookStr {This gleaming chunk of Orat's anatomy is the only visible proof that Orat ever existed. After that explosion, it's amazing there's that much left.}
		view 128
		priority 1
		signal 16400
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gEgo setScript: pickUpPart)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickUpPart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 10
					setLoop: 2
					cel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(2
				(part dispose:)
				(SetScore 2 150)
				(gEgo get: 8) ; Orat_Part
				(SetFlag 60)
				(= local1 0)
				(gEgo setCycle: End self)
			)
			(3
				(HandsOn)
				(NormalEgo 0 1 61)
				(gEgo loop: 3)
				(Print 28 20) ; "You reach down and take the Orat part in your hand. Some of it oozes to fill the space between your fingers."
				(if (== global182 2)
					(= global182 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance skullHoles of Feature
	(properties
		description {holes}
		onMeCheck 4096
		lookStr {The orbs in this gigantic skull offer the only passageways for light into this gloomy place.}
	)
)

(instance farWall of Feature
	(properties
		description {far wall}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 59)
					(Print 28 21) ; "You notice a fine spray of glistening, metallic jelly decorating the walls."
				else
					(Print 28 22) ; "The walls are blank. This place could use some sprucing-up. Perhaps a nice little wall hanging or a velvet Elvis painting could warm the look of the place a bit."
				)
			)
			(3 ; Do
				(Print 28 23) ; "There's nothing on the walls that you want or need."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nearWall of Feature
	(properties
		x 190
		y 200
		description {near wall}
		onMeCheck 1024
	)

	(method (doVerb theVerb invItem)
		(farWall doVerb: theVerb &rest)
	)
)

(instance skulls of Feature
	(properties
		x 278
		y 118
		description {pile of skulls}
		onMeCheck 512
		lookStr {A pile of skulls lie here sucked clean by Orat, or was a result of them writing too many adventure games.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 28 24) ; "Just leave those depressing remnants of unfortunate explorers alone, will you?"
			)
			(5 ; Talk
				(Print 28 25) ; "They have surprisingly little to say. And if they did, would you really want to stay around to listen."
			)
			(11 ; Taste
				(Print 28 26) ; "While you might be in the mood for a little skull, you've got more important business to tend to."
			)
			(12 ; Smell
				(Print 28 27) ; "Any scent these skulls may once have had is long gone, compliments of the the incredibly hot, dry climate."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigRock of Feature
	(properties
		description {big rock}
		onMeCheck 256
		lookStr {That rock is almost as big as you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 28 28) ; "You have trouble moving your own carcass around. You sure can't move something that weighs several times more than you. Besides, you left your truss back on the Arcada."
			)
			(12 ; Smell
				(Print 28 29) ; "No odor is detectable."
			)
			(11 ; Taste
				(Print 28 30) ; "You've tasted better."
			)
			(5 ; Talk
				(Print 28 31) ; "While potentially an even conversational match for you, the rock has no speech mechanism."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smallRock of Feature
	(properties
		description {small rock}
		onMeCheck 128
		lookStr {That rock is too small to hide behind but too large to lift.}
	)

	(method (doVerb theVerb invItem)
		(bigRock doVerb: theVerb &rest)
	)
)

(instance floor of Feature
	(properties
		description {cave floor}
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf
					{The cave floor is littered with the usual stuff a cave would be littered with. Some sand, some rock, %s}
					(if (= local1 (not (IsFlag 60)))
						{and that's about it. Oh, Yeah. There's also an Orat part.}
					else
						{none of it useful, though.}
					)
				)
			)
			(12 ; Smell
				(Print 28 32) ; "Other than the cave's special aroma, you smell nothing."
			)
			(11 ; Taste
				(Print 28 33) ; "Give it a rest. It's going to be raw soon."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties
		type PBarredAccess
	)
)

