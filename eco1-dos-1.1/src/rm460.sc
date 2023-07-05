;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm460 0
	stopGroop 1
)

(local
	local0
	local1
	local2
	local3
)

(instance rm460 of EcoRoom
	(properties
		picture 460
		style 7
		horizon 10
		south 440
		picAngle 70
		vanishingX 180
		vanishingY 44
	)

	(method (init)
		(LoadMany rsSOUND 461 462 463 464 465 466 467)
		(= global250 1)
		(gFeatures
			add: Skeleton Grass Sky CoveExit Cliff Beach
			eachElementDo: #init
		)
		(if ((Inv at: 25) ownedBy: 460) ; boxKey
			(SetFlag 18)
			(= local0 0)
			(ppike init:)
			(= local2 1)
			(theGlint init:)
			(gFeatures add: Glint eachElementDo: #init)
		else
			(= local0 2)
		)
		(chest init:)
		(rollingWater init:)
		(gEgo
			view: 461
			loop: 0
			cel: 0
			posn: 118 115
			z: 0
			ignoreActors: 1
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
			init:
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 185 110 204 102 208 92 209 87 196 88 196 92 176 93 161 87 159 88 159 92 133 96 132 99
					yourself:
				)
		)
		(self setScript: enterFromGoodReef1)
		(super init:)
		(gLongSong number: 460 loop: -1 play:)
		((gTheIconBar at: 0) loop: 9)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 0 2) ; "Adam rises into a small air pocket underneath the reef. Somebody found it before he did. In fact, the guy is still here."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0040)
				(self setScript: leaveCove)
			)
		)
	)

	(method (newRoom newRoomNumber)
		((gTheIconBar at: 0) loop: 0)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance ppike of Prop
	(properties
		x 116
		y 59
		approachX 147
		approachY 92
		view 460
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 4 setLoop: 1 setCel: 0)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== local0 0)
					(rm460 setScript: doPikeFirst)
				else
					(rm460 setScript: doPikeSecond)
				)
			)
			(2 ; Look
				(if (gCast contains: theGlint)
					(theGlint setCycle: Beg)
				)
				(Narrator init: 1 0 0 11) ; "It's a Conquistador's pike. Someone made sure the pirate on duty would get the point."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chest of Prop
	(properties
		x 160
		y 86
		view 460
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setLoop: 2 setPri: 3)
		(if (IsFlag 41)
			(self setCel: 1)
		else
			(self setCel: 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 41)
					((ScriptID 2 1) init: 2 0 0 14 1) ; Adam, "The lid's stuck. Oh, well, it's empty anyhow."
				else
					(self setScript: openChest)
				)
			)
			(2 ; Look
				(if (not (IsFlag 321))
					(theGlint setCycle: Beg)
				)
				(if (IsFlag 41)
					(Narrator init: 1 0 0 6) ; "The chest was empty except for the crab. Someone else has been here recently - unless, of course, you believe in hundred-year-old crabs."
				else
					(self setScript: lookChestTalk)
				)
			)
			(4 ; Inventory
				(switch invItem
					(25 ; boxKey
						(self setScript: useKeyOnChestTalk)
					)
					(30 ; hackSaw
						(Narrator init: 1 0 0 27) ; "No need to do major surgery. The lock is already broken."
					)
					(else
						(Narrator init: 1 0 0 28) ; "The lock has been snapped. The chest should open easily."
					)
				)
			)
			(5 ; Talk
				(Narrator init: 1 0 0 31) ; "The chest gave up its secrets already."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rollingWater of Prop
	(properties
		x 121
		y 108
		nsTop 109
		nsLeft 82
		nsBottom 138
		nsRight 190
		view 4611
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setLoop: 0
			setCycle: Fwd
			cycleSpeed: 16
			detailLevel: 2
			setPri: 4
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(rm460 setScript: leaveCove)
			)
			(2 ; Look
				(if (and (== local0 2) local2)
					((ScriptID 2 1) init: 2 0 0 16 1) ; Adam, "The key is sinking fast!"
				else
					(Narrator init: 1 0 0 15) ; "The water laps against the beach."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theGlint of Prop
	(properties
		x 122
		y 81
		view 823
		loop 1
		priority 4
		signal 16400
	)

	(method (doVerb)
		(Glint doVerb: &rest)
	)
)

(instance KeyInset of Prop
	(properties
		x 157
		y 155
		view 460
		priority 15
		signal 20496
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not (event modifiers:))
			)
			(event claimed: 1)
			((gCurRoom script:) cue:)
			(SetScore 5 323)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				((ScriptID 2 1) init: 2 0 0 8 1) ; Adam, "The key's stuck under the pike tip!"
			)
			(2 ; Look
				(Narrator init: 1 0 0 24) ; "No doubt this is a skeleton key."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance CoveExit of Feature
	(properties
		x 170
		y 106
		nsTop 102
		nsLeft 163
		nsBottom 110
		nsRight 181
		onMeCheck 64
	)
)

(instance Skeleton of Feature
	(properties
		x 122
		y 72
		nsTop 51
		nsLeft 110
		nsBottom 93
		nsRight 133
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 18) ; "Adam feels creepy about touching a skeleton."
			)
			(5 ; Talk
				(Narrator init: 1 0 0 29) ; ""Are you by any chance related to a guy named LeChuck?"... No answer from the skeleton."
			)
			(2 ; Look
				(if (== local0 2)
					(Narrator init: 1 0 0 4) ; "The pike is gone. The pirate doesn't feel any better however."
				else
					(Narrator init: 1 0 0 3) ; "The pirate ghost has the job of guarding the treasure. The pirate chief made sure he wouldn't quit."
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 1 0 0 22) ; "The pirate can't be threatened anymore."
					)
					(30 ; hackSaw
						(Narrator init: 1 0 0 32) ; "What a grisly idea."
					)
					(21 ; healingPotion
						(Narrator init: 1 0 0 34) ; "The time for that is long past."
					)
					(17 ; spine
						(Narrator init: 1 0 0 35) ; "He's already got a spine. Haha."
					)
					(else
						(Narrator init: 1 0 0 33) ; "The skeleton is beyond help."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Sky of Feature
	(properties
		x 125
		y 10
		nsLeft 60
		nsBottom 20
		nsRight 190
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 17) ; "Adam can't get to the surface from here."
			)
			(2 ; Look
				(Narrator init: 1 0 0 20) ; "The reef formation is close to the coastline."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Cliff of Feature
	(properties
		x 247
		y 89
		nsTop 22
		nsLeft 202
		nsBottom 156
		nsRight 293
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 0 16) ; "Adam has found a small air pocket in the cliff walls that line the coast."
			)
			(3 ; Do
				(Narrator init: 1 0 0 14) ; "Adam's too wet to climb the slippery rock."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Grass of Feature
	(properties
		x 159
		y 178
		nsTop 167
		nsBottom 189
		nsRight 318
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 0 16) ; "Adam has found a small air pocket in the cliff walls that line the coast."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Glint of Feature
	(properties
		x 115
		y 160
		z 80
		nsTop 73
		nsLeft 110
		nsBottom 83
		nsRight 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: popKeyInset 0 theVerb)
			)
			(2 ; Look
				(gCurRoom setScript: popKeyInset 0 theVerb)
			)
			(else
				(theGlint setCycle: Beg)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Beach of Feature
	(properties
		x 166
		y 98
		nsTop 92
		nsLeft 129
		nsBottom 104
		nsRight 204
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(rm460 setScript: lookBeachTalk)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler:) vStopped:))
		)
		(super doit: &rest)
	)
)

(instance lookChestTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 1 0 0 5 self) ; "A pirate crew left its treasure in this secret spot. They installed a security system before they left - a pirate ghost."
			)
			(1
				(Narrator init: 1 0 0 12 self) ; "The pirate loot was stored in this chest. Maybe the pirates lost their claim ticket or something."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance useKeyOnChestTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 1 0 0 1 self) ; "The key looks more modern than the chest. It won't open that old lock."
			)
			(1
				(Narrator init: 1 0 0 19 self) ; "Anyway the lock has been sawed through."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance lookBeachTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 1 0 0 8 self) ; "A small beach is just big enough for a couple of people to stand on."
			)
			(1
				(Narrator init: 1 0 0 9 self) ; "Part of it is occupied by a permanent guest."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterFromGoodReef1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 15)
			)
			(1
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo
					view: 461
					posn: 118 115
					loop: 0
					cel: 0
					z: 0
					signal: 16384
					setStep: 3 2
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(self setScript: shakeFins self)
			)
			(3
				(gEgo
					posn: 148 96
					view: 806
					loop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 2
				)
				(= cycles 2)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shakeFins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 159 108 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gSoundEffects number: 462 loop: 1 play:)
				(gEgo cel: 3 setCycle: CT 7 1 self)
			)
			(2
				(gSoundEffects number: 462 loop: 1 play:)
				(gEgo cel: 8 setCycle: CT 13 1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance doPikeFirst of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 819)
					(gEgo
						view: 806
						setLoop: stopGroop
						setCycle: StopWalk 819
						priority: 5
						signal: 16400
						cycleSpeed: 2
						setMotion: PolyPath 148 96 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(ppike hide:)
				(gEgo
					view: 461
					posn: 126 82
					loop: 2
					cel: 0
					ignoreActors: 1
					cycleSpeed: 15
					setCycle: End self
				)
				(= local0 1)
			)
			(2
				(gSoundEffects number: 464 loop: 1 play:)
				(ppike show:)
				(gEgo posn: 126 82 loop: 3 cel: 0 setCycle: CT 4 1 self)
				(SetScore 2 320)
			)
			(3
				(gSoundEffects number: 465 loop: 1 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(4
				(= ticks 120)
			)
			(5
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo posn: 118 115 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(self setScript: scratchSelf self)
			)
			(7
				(= ticks 60)
			)
			(8
				(self setScript: shakeFins self)
			)
			(9
				(gEgo
					posn: 147 95
					view: 806
					setLoop: stopGroop
					priority: 5
					signal: 16400
					cycleSpeed: 2
					setCycle: StopWalk 819
				)
				(= cycles 1)
			)
			(10
				((ScriptID 2 1) init: 2 0 0 15 1 self) ; Adam, "I think I felt it give a little!"
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance scratchSelf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 144 96 loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (<= (++ local3) 4)
					(-- state)
					(gSoundEffects number: 463 loop: 1 play:)
					(gEgo cel: (+ 2 (== (gEgo cel:) 2)))
				)
				(= cycles 4)
			)
			(2
				(gSoundEffects stop:)
				(gEgo setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance doPikeSecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo view:) 819)
					(gEgo
						view: 806
						setLoop: stopGroop
						setCycle: StopWalk 819
						priority: 5
						signal: 16400
						cycleSpeed: 2
						setMotion: PolyPath 147 92 self
					)
				)
			)
			(1
				(gEgo setCycle: 0 cel: 4)
				(= ticks 4)
			)
			(2
				(ppike hide:)
				(gEgo
					posn: 126 82
					view: 461
					loop: 2
					cel: 0
					ignoreActors: 1
					cycleSpeed: 15
					setCycle: End self
				)
				(= local0 2)
			)
			(3
				(gEgo posn: 126 82 loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(gSoundEffects number: 466 loop: 1 play:)
				(gEgo setCycle: End self)
				(ClearFlag 18)
				(SetFlag 19)
				(ppike dispose:)
				(Glint dispose:)
				(theGlint dispose:)
				(SetScore 2 321)
			)
			(5
				(Narrator init: 1 0 0 21 self) ; "The pike snaps into pieces and the key goes flying into the water."
			)
			(6
				(rollingWater setScript: showKeyTimer)
				(gEgo
					posn: 180 100
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 2
					setMotion: PolyPath 160 100 self
				)
			)
			(7
				((Inv at: 25) owner: 440) ; boxKey
				(= ticks 60)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showKeyTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 44)
				(= ticks 840)
			)
			(1
				(ClearFlag 44)
				(self dispose:)
			)
		)
	)
)

(instance openChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					ignoreActors: 1
					cycleSpeed: 2
					setMotion: PolyPath 159 68 self
				)
			)
			(1
				(gEgo loop: 0 cel: 4)
				(= ticks 3)
			)
			(2
				(Narrator init: 1 0 0 25 self) ; "Dreaming of pirate treasure, Adam opens the chest."
			)
			(3
				(chest hide:)
				(gEgo
					view: 461
					loop: 6
					cel: 0
					posn: 159 68
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(4
				(gSoundEffects number: 467 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(5
				(gSoundEffects number: 469 loop: 1 flags: 1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(gSoundEffects stop: flags: 0)
				(Narrator init: 1 0 0 26 self) ; "A tiny blue crab has been napping in the chest. He scuttles away to find new shelter."
			)
			(7
				(chest setCel: 1 show:)
				(gSoundEffects number: 468 loop: 1 play:)
				(gEgo loop: 7 cel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(8
				(gEgo
					posn: 155 95
					view: 806
					setLoop: stopGroop
					loop: 0
					setHeading: 50
					priority: 5
					signal: 16400
					cycleSpeed: 4
					setCycle: StopWalk 819
				)
				(SetScore 5 322)
				(= cycles 1)
			)
			(9
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "I guess he was napping. Not a good place for it."
			)
			(10
				(SetFlag 41)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leaveCove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 6
					setMotion: PolyPath 171 99 self
				)
			)
			(1
				(gEgo
					posn: 148 84
					view: 461
					loop: 8
					cel: 0
					cycleSpeed: 16
					setCycle: CT 5 1 self
				)
			)
			(2
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo hide:)
				(= ticks 120)
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 440)
				(self dispose:)
			)
		)
	)
)

(instance popKeyInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 3 4 5)
				(KeyInset init:)
				(= cycles 2)
			)
			(1
				(KeyInset doVerb: register)
			)
			(2
				(KeyInset dispose:)
				(= cycles 3)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

