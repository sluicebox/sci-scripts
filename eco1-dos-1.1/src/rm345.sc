;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm345 0
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
	[local10 9] = [146 153 174 177 200 224 225 227 233]
	[local19 9] = [40 29 24 14 20 23 30 25 20]
	[local28 9] = [116 134 155 171 199 224 246 261 268]
	[local37 9] = [21 38 52 61 63 61 55 47 42]
	[local46 9] = [0 1 2 3 4 5 6 7 7]
	[local55 9] = [0 1 1 2 3 4 5 6 7]
	[local64 8] = [255 255 256 267 269 273 293 307]
	[local72 8] = [20 50 65 85 83 74 63 61]
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (> global102 16)
		(= local0 1)
		(= local1 0)
		(= local2 param1)
	else
		(gCurRoom drawPic: 340 8)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if (> global102 16)
		(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait param1)
		)
	else
		(gCurRoom drawPic: 901 8)
	)
)

(instance rm345 of EcoRoom
	(properties
		lookStr 46
		picture 340
		style -32759
		horizon -20
		vanishingY -20
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(NormalEgo)
		(super init: &rest)
		(if (IsFlag 73)
			(gCurRoom setScript: emptyRoom)
		else
			(gCurRoom setScript: chaseSequence)
		)
	)

	(method (doit)
		(if local0
			(Palette palSET_INTENSITY 0 255 (+= local1 local2))
			(if (>= local1 100)
				(= local0 0)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== local7 1)
					(Narrator init: 3 0 0 41) ; "The driftnet that once spread death is now gone - and so is DELPHINEUS!"
				else
					(Narrator init: 3 0 0 46) ; "Adam and Delphineus are trapped in a driftnet while Flesh-Eater circles them, gleefully toying with his dinner!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(gTheIconBar enable: 7)
		(super dispose: &rest)
	)
)

(instance manta of Actor
	(properties
		x 450
		y -50
		yStep 8
		view 582
		signal 8192
		xStep 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 43) ; "The horrid monster, Flesh-Eater, only circles them as though gloating over his treasures."
			)
			(5 ; Talk
				(Narrator init: 3 0 0 43) ; "The horrid monster, Flesh-Eater, only circles them as though gloating over his treasures."
			)
			(3 ; Do
				(Narrator init: 3 0 0 44) ; "Adam can't do anything to the manta while he's tangled in the net."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 44) ; "Adam can't do anything to the manta while he's tangled in the net."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 51) ; "The Flesh-Eater problem won't be that easy to deal with!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance driftNet of Actor
	(properties
		x 232
		y 103
		z 50
		yStep 6
		view 363
		xStep 9
		moveSpeed 3
	)

	(method (init)
		(self
			setLoop: 0
			setPri: 2
			ignoreActors: 1
			ignoreHorizon: 1
			cycleSpeed: 26
		)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if local8
					(Narrator init: 3 0 0 25) ; "Adam struggles against the rough nylon rope but he's too entangled to pull himself free. He'll have to cut the net."
				else
					(Narrator init: 3 0 0 24) ; "Adam can't do anything to help Delphineus while he himself is caught in the net."
				)
				(^= local8 $0001)
			)
			(2 ; Look
				(if (== local3 0)
					(if local9
						(Narrator init: 3 0 0 28) ; "The coarse nylon rubs roughly against Adam's skin. The nylon is a terrible prison."
					else
						(Narrator init: 3 0 0 27) ; "Delphineus struggles madly in the net. He's clearly terrified and unable to free himself."
					)
					(^= local9 $0001)
				)
			)
			(4 ; Inventory
				(switch invItem
					(13 ; sharpShell
						(rm345 setScript: adamCutsOutOfNet)
						(= local6 1)
						(gEgo cycleSpeed: 30)
						(SetScore 10 339)
					)
					(30 ; hackSaw
						(Narrator init: 3 0 0 26) ; "Adam can't wield that hacksaw while he's entangled - it's too big. Besides, the hacksaw is too dangerous to use so close to Adam's flesh."
					)
					(else
						(Narrator init: 3 0 0 45) ; "That won't cut the nylon mesh!"
					)
				)
			)
			(5 ; Talk
				((ScriptID 2 0) init: 2 0 0 11 1) ; Delphineus, "Free yourself, Adam! Cut yourself free!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance delInNet of Actor
	(properties
		x 246
		view 603
		loop 7
	)

	(method (init)
		(self setPri: 9 ignoreActors: 1 cycleSpeed: 26)
		(super init: &rest)
	)
)

(instance cabinDoor of View
	(properties
		x 47
		y 98
		view 581
		loop 3
		priority 6
		signal 16401
	)
)

(instance cable1 of View
	(properties
		x 44
		y 43
		view 580
		loop 4
		priority 4
		signal 20497
	)
)

(instance cable2 of View
	(properties
		x 63
		y 79
		view 580
		loop 4
		cel 1
		priority 15
		signal 20497
	)
)

(instance cable3 of View
	(properties
		x 93
		y 121
		view 580
		loop 4
		cel 2
		priority 15
		signal 20497
	)
)

(instance chaseSequence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 7)
				(LoadMany rsVIEW 603 802 831 342)
				(NormalDelph)
				(gDelph
					yStep: 6
					xStep: 9
					posn: 400 -20
					z: 0
					setScript: (ScriptID 127 0) 0 920 ; delSpeakScript
					ignoreHorizon: 1
					init:
				)
				(manta init:)
				(gEgo
					yStep: 6
					xStep: 9
					init:
					ignoreHorizon: 1
					posn: 370 -58
					ignoreActors:
				)
				(driftNet init: stopUpd: hide:)
				(= cycles 3)
			)
			(1
				(Narrator init: 3 0 0 49) ; "Adam and Delphineus flee in terror from the huge, flesh-eating monster!"
				(gEgo setMotion: MoveTo -12 240 self)
				(gDelph
					ignoreActors:
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo -2 250 self
				)
			)
			(2 0)
			(3
				(manta
					setLoop: 0
					moveSpeed: (gEgo moveSpeed:)
					setCycle: Fwd
					setMotion: MoveTo 0 223 self
				)
			)
			(4
				(manta hide:)
				(localproc_1 5)
				(= cycles 3)
			)
			(5
				(localproc_0 5)
				(= cycles 2)
			)
			(6
				(gEgo x: 60 y: -30 setMotion: DPath 35 51 133 150 self)
				(gDelph x: 45 y: -60 setMotion: DPath 19 33 180 220)
			)
			(7
				(gEgo setMotion: MoveTo 175 220)
				(manta
					setLoop: 1
					x: -40
					y: -30
					show:
					setMotion: MoveTo 175 250 self
				)
			)
			(8
				(manta hide:)
				(localproc_1 5)
				(= cycles 3)
			)
			(9
				(localproc_0 5)
				(= cycles 2)
			)
			(10
				(gEgo x: 135 y: -30 setMotion: DPath 148 46 91 95 -30 92)
				(gDelph
					x: 145
					y: -45
					setMotion: DPath 183 63 128 98 40 98 self
				)
			)
			(11
				(gDelph setMotion: MoveTo -55 96)
				(manta
					setLoop: 0
					x: 140
					y: -30
					show:
					setMotion: MoveTo -40 128 self
				)
				(= cycles 4)
			)
			(12
				(Narrator init: 3 0 0 2) ; "With a feeling of utter helplessness, Adam prepares to feel the sharp bite of Flesh-Eater's jaws. The monster is so close that his hot wake ruffles the back of Adam's neck!"
			)
			(13
				(manta hide:)
				(localproc_1 5)
				(= cycles 3)
			)
			(14
				(gCurRoom setScript: crashIntoNet)
			)
		)
	)
)

(instance crashIntoNet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 5)
				(SetFlag 73)
				(driftNet show:)
				(gCurRoom setRegions: 51) ; bubblesRegion
				(= cycles 2)
			)
			(1
				(gEgo
					setCycle: 0
					posn: 370 79
					setCycle: Walk
					setMotion: MoveTo 300 84 self
				)
				((gDelph script:) register: 918)
				(gDelph
					ignoreActors: 1
					posn: 370 60
					moveSpeed: 3
					setCycle: 0
					setMotion: MoveTo 300 68
				)
			)
			(2
				(gDelph
					view: 342
					setLoop: 0
					cycleSpeed: (* (gEgo moveSpeed:) 2)
					setCycle: Fwd
					setMotion: MoveTo 229 68
				)
				(gEgo
					cycleSpeed: (* (gEgo moveSpeed:) 2)
					setMotion: MoveTo 241 84 self
				)
			)
			(3
				(gLongSong number: 341 loop: -1 play:)
				(driftNet x: 217 y: 107 setCel: 1 setMotion: MoveTo 182 124)
				(gEgo
					view: 342
					setLoop: 3
					setCycle: End
					setMotion: MoveTo 208 78
				)
				(gDelph
					setLoop: 1
					setCycle: End
					setMotion: MoveTo 199 76 self
				)
			)
			(4
				(Narrator posn: -1 130 init: 3 0 0 30 self) ; "In their panicked terror of the danger behind them, Adam and Delphineus fail to notice the danger in front of them. They both plow headfirst into the driftnet."
			)
			(5
				(driftNet setCel: 2 setMotion: MoveTo 141 123)
				(gEgo
					setLoop: 4
					setCycle: Fwd
					cycleSpeed: 18
					setMotion: MoveTo 167 77
				)
				(gDelph setLoop: 2 setCycle: Fwd setMotion: MoveTo 158 75)
				(= seconds 2)
			)
			(6
				(Narrator posn: -1 130 init: 3 0 0 31 self) ; "The nylon mesh wraps its arms around them. The two are trapped!"
			)
			(7
				(gEgo setScript: trappedTalk self)
			)
			(8
				(Narrator posn: -1 130 init: 3 0 0 32 self) ; "Adam waits for the manta to finish them off - two helpless victims trapped in the net. To his surprise, Flesh-Eater only circles them."
			)
			(9
				(gLongSong number: 340 loop: -1 play:)
				(manta posn: 380 50 show: setMotion: MoveTo 30 280 self)
			)
			(10
				(driftNet setScript: timedHintTalk)
				(manta setScript: mantaCircles)
				(gDelph setScript: shiftNetAround)
				(= cycles 1)
			)
			(11
				(HandsOn)
				(gTheIconBar disable: (gTheIconBar at: 0))
				(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(gTheIconBar curIcon: (gTheIconBar at: 1))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				)
				(self dispose:)
			)
		)
	)
)

(instance mantaCircles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manta
					view: 603
					x: 400
					y: 7
					xStep: 4
					yStep: 4
					setLoop: 0
					signal: 24576
					setPri: 1
					cycleSpeed: 26
					hide:
				)
				(= seconds 2)
			)
			(1
				(manta
					x: -60
					y: 50
					show:
					xStep: 34
					yStep: 2
					setCycle: 0
					setLoop: 1
					setCel: 4
					moveSpeed: 18
					setMotion: MoveTo 330 100 self
				)
			)
			(2
				(if (== local6 1)
					(self dispose:)
				else
					(= seconds 2)
				)
			)
			(3
				(manta setLoop: 2 setCel: 0 posn: 283 36 setCycle: CT 4 1 self)
			)
			(4
				(manta
					xStep: 38
					yStep: 3
					setCycle: 0
					setCel: 4
					moveSpeed: 18
					setMotion: MoveTo 60 56 self
				)
			)
			(5
				(if (== local5 0)
					(Narrator posn: -1 130 init: 3 0 0 33 self) ; "Flesh-Eater's toying with them!"
					(= local5 1)
				else
					(self cue:)
				)
			)
			(6
				(= seconds 1)
			)
			(7
				(if (== local6 1)
					(self dispose:)
				else
					(= state -1)
					(self cue:)
				)
			)
		)
	)
)

(instance adamCutsOutOfNet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 167 y: 77)
				(driftNet x: 141 y: 123)
				(gDelph x: 158 y: 75 setScript: 0)
				(HandsOff)
				(Narrator posn: -1 130 init: 3 0 0 42 self) ; "Adam maneuvers the sharp shell around and begins to rub it against the nylon net."
			)
			(1
				(gEgo
					view: 342
					loop: 5
					cel: 0
					posn: 165 76
					setPri: 14
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(Narrator posn: -1 130 init: 3 0 0 36 self) ; "The shell saws through the nylon, loosening the net's grasp on Adam. He's free!"
			)
			(3
				(if (manta script:)
					(if (driftNet script:)
						(timedHintTalk dispose:)
						(= state 2)
						(= cycles 1)
					else
						(= state 2)
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (driftNet script:)
					(timedHintTalk dispose:)
				)
				((ScriptID 2 0) init: 2 0 0 41 1 self) ; Delphineus, "You did it, Adam! Now get out of here! Fast!"
				(driftNet
					xStep: 1
					yStep: 1
					cycleSpeed: 12
					setMotion: PolyPath 144 (- (driftNet y:) 70)
				)
				(gDelph
					xStep: 1
					yStep: 1
					cycleSpeed: 12
					setScript: 0
					setMotion: PolyPath 161 (- (gDelph y:) 70)
				)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 12 1 self) ; Adam, "Are you crazy?! What kind of friend do you think I am?!"
			)
			(6
				(NormalEgo)
				(gEgo
					x: 132
					y: 89
					view: 802
					loop: 3
					setPri: 14
					cel: 0
					setMotion: MoveTo 185 56
				)
				(Narrator posn: -1 130 init: 3 0 0 37 self) ; "Adam turns back frantically to cut loose his friend..."
			)
			(7
				(driftNet setScript: 0)
				(manta setScript: mantaCarriesOffDel)
				(self dispose:)
			)
		)
	)
)

(instance mantaCarriesOffDel of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(manta
					view: 585
					setLoop: 0
					cel: 0
					x: -32
					y: -264
					xStep: 20
					yStep: 15
					setPri: 13
					cycleSpeed: 12
					setMotion: MoveTo 108 16 self
				)
			)
			(1
				(Narrator posn: -1 130 init: 3 0 0 38 self) ; "...But before he can free Delphineus, Flesh-Eater swoops in! Enraged to see one of his victims escape and determined not to lose the other, he seizes the net with poor Delphineus still in it..."
			)
			(2
				(manta setCycle: CT 3 1 self)
				(driftNet
					setCycle: 0
					setLoop: 0
					setCel: 2
					xStep: 6
					yStep: 4
					setPri: 10
					moveSpeed: 12
					setMotion: MoveTo 201 -36
				)
				(gDelph hide:)
				(gEgo setCycle: 0 setLoop: (gEgo loop:))
			)
			(3
				(Narrator posn: -1 130 init: 3 0 0 47 self) ; "...And knocks Adam aside with one flick of his huge wing!"
			)
			(4
				(gLongSong number: 342 loop: -1 play:)
				(manta setCycle: End self)
				(gEgo
					view: 221
					setLoop: 0
					cel: 2
					cycleSpeed: 3
					setCycle: reverseCounter 6
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 120)
				)
			)
			(5
				(NormalEgo)
				(gEgo loop: 0 x: (- (gEgo x:) 2) y: (- (gEgo y:) 8))
				(manta
					cycleSpeed: 12
					setCycle: End
					setMotion: MoveTo 380 0 self
				)
			)
			(6
				(NormalEgo)
				((ScriptID 2 0) init: 2 0 0 40 1 self) ; Delphineus, "Adam! Find Cetus! Only he can save me now!"
				(delInNet init: posn: -30 0 view: 603 loop: 7 cel: 0)
			)
			(7
				(driftNet hide:)
				(manta view: 603 loop: 3 cel: 0 x: 273 y: 39 setCycle: 0)
				(delInNet posn: 254 16 setPri: 10)
				(Animate (gCast elements:) 1)
				(for ((= temp0 1)) (< temp0 8) ((++ temp0))
					(Wait 0)
					(Wait 10)
					(manta cel: temp0)
					(delInNet x: [local64 temp0] y: [local72 temp0] cel: temp0)
					(Animate (gCast elements:) 1)
				)
				(manta hide:)
				(delInNet hide:)
				(= cycles 1)
			)
			(8
				(localproc_1 5)
				(manta setPri: 1 setCycle: 0 setLoop: 0)
				(gDelph setPri: 2 setCycle: 0 setLoop: 0)
				(gEgo hide:)
				(= cycles 3)
			)
			(9
				(if (> global102 16)
					(localproc_0 5)
					(gCurRoom drawPic: 580)
				else
					(gCurRoom drawPic: 580 8)
				)
				(cabinDoor init:)
				(cable1 init:)
				(cable2 init:)
				(cable3 init:)
				(= cycles 40)
			)
			(10
				(manta view: 603 setLoop: 3 cel: 0 x: 146 y: 40 show:)
				(gDelph view: 603 setLoop: 7 cel: 0 x: 116 y: 21 show:)
				(Animate (gCast elements:) 1)
				(for ((= temp0 1)) (< temp0 9) ((++ temp0))
					(Wait 0)
					(Wait 10)
					(manta
						x: [local10 temp0]
						y: [local19 temp0]
						cel: [local46 temp0]
					)
					(gDelph
						x: [local28 temp0]
						y: [local37 temp0]
						cel: [local55 temp0]
					)
					(Animate (gCast elements:) 1)
				)
				(= cycles 1)
			)
			(11
				(cabinDoor dispose:)
				(cable1 dispose:)
				(cable2 dispose:)
				(cable3 dispose:)
				(gDelph hide:)
				(manta hide:)
				(localproc_1 5)
				(= cycles 3)
			)
			(12
				(if (> global102 16)
					(gEgo show:)
					(gCurRoom drawPic: 340)
				)
				(localproc_0 5)
				(= cycles 35)
			)
			(13
				(gLongSong number: 343 loop: 1 play:)
				(NormalEgo)
				(gEgo
					yStep: 2
					cycleSpeed: 6
					setMotion: MoveTo (gEgo x:) 220 self
				)
				(= cycles 2)
			)
			(14
				(Narrator posn: -1 130 init: 3 0 0 39) ; "Adam finds himself suddenly alone. The driftnet with its precious cargo and the monster are gone. What on earth, Adam thinks, can he do now?"
			)
			(15
				(Narrator posn: -1 130 init: 3 0 0 40 self) ; "And will he ever see Delphineus again?"
				(= local7 1)
			)
			(16
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance shiftNetAround of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 920) ; delSpeakScript
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles (Random 1 2))
			)
			(1
				(switch (Random 0 4)
					(0
						(= temp0 0)
						(= temp1 1)
					)
					(1
						(= temp0 1)
						(= temp1 0)
					)
					(2
						(= temp0 0)
						(= temp1 -1)
					)
					(3
						(= temp0 -1)
						(= temp1 0)
					)
					(4
						(= temp0 0)
						(= temp1 0)
					)
				)
				(gEgo x: (+ 167 temp0) y: (+ 77 temp1))
				(driftNet x: (+ 141 temp0) y: (+ 123 temp1))
				(gDelph x: (+ 158 temp0) y: (+ 75 temp1))
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance emptyRoom of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo y: 220 init: setMotion: MoveTo 160 150 self)
			)
			(1
				(Narrator init: 3 0 0 41 self) ; "The driftnet that once spread death is now gone - and so is DELPHINEUS!"
			)
			(2
				(gEgo setMotion: MoveTo 160 220 self)
			)
			(3
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance timedHintTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 12 1 self) ; Delphineus, "Adam, you'd better hurry! He's going to get bored with this game real quickly!"
			)
			(2
				(= seconds 40)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 36 1 self) ; Delphineus, "Don't you have something you can use to cut your way out of the net, Adam?"
			)
			(4
				(= seconds 40)
			)
			(5
				((ScriptID 2 0) init: 2 0 0 37 1 self) ; Delphineus, "Use something sharp, Adam, and free yourself!"
			)
			(6
				(= seconds 40)
			)
			(7
				((ScriptID 2 0) init: 2 0 0 38 1 self) ; Delphineus, "Try your sharp shell, Adam! Cut yourself free!"
			)
			(8
				(= seconds 40)
			)
			(9
				((ScriptID 2 0) init: 2 0 0 38 1 self) ; Delphineus, "Try your sharp shell, Adam! Cut yourself free!"
			)
			(10
				(= seconds 40)
			)
			(11
				((ScriptID 2 0) init: 2 0 0 38 1 self) ; Delphineus, "Try your sharp shell, Adam! Cut yourself free!"
			)
			(12
				(= seconds 40)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance trappedTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local4 1)
					(= state 5)
				)
				(self cue:)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 10 1 self) ; Adam, "Delphineus! We're trapped!"
			)
			(2
				((ScriptID 2 0) init: 2 0 0 9 1 self) ; Delphineus, "Adam! You've got to save yourself! I'll never get out of this thing, but you still have a chance!"
			)
			(3
				((ScriptID 2 1) init: 1 0 0 11 1 self) ; Adam, "I won't leave you, Del!"
			)
			(4
				((ScriptID 2 0) init: 2 0 0 10 1 self) ; Delphineus, "So what, we both end up Manta food? DO IT, Adam! Save yourself!"
				(= local4 1)
			)
			(5
				(= state 6)
				(self cue:)
			)
			(6
				((ScriptID 2 0) init: 2 0 0 11 1 self) ; Delphineus, "Free yourself, Adam! Cut yourself free!"
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance reverseCounter of ForwardCounter
	(properties
		cycleDir -1
	)

	(method (cycleDone)
		(if (-- count)
			(client cel: (client lastCel:))
			(client cycleSpeed: (+ (client cycleSpeed:) 1))
		else
			(= completed 1)
			(self motionCue:)
		)
	)

	(method (doit &tmp temp0)
		(if (< (= temp0 (self nextCel:)) 0)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

