;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 &tmp temp0) ; UNUSED
	(= temp0 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(param1 y: (- (param1 y:) temp0) z: (- (param1 z:) temp0))
)

(instance rm440 of EcoRoom
	(properties
		picture 440
		horizon 5
		east 480
		west 420
		picAngle 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 6 1) ; Delphineus, "I just love it down here. It's what the ocean looked like before all the pollution."
				)
			)
		)
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(self setRegions: 51) ; bubblesRegion
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 109 0 88 65 96 85 83 108 93 91 128 64 126 57 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 146 165 169 120 220 115 244 135 265 146 319 111 330 230 -20 230 -20 148 54 155 85 172 102 185 149 185 309 184 291 171 235 172 154 178
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 104 124 106 108 112 107 114 94 122 95 123 112 136 111 136 121
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 177 102 187 91 196 102 206 102 186 111 166 103
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 186 57 313 13 313 5 138 5 138 40 92 42 92 -40 45 -40 45 35 -10 35 -10 -45 330 -45 330 50 272 68 194 68
					yourself:
				)
		)
		(gFeatures
			add:
				CoveCave
				BrainCoral
				StaghornCoral1
				StaghornCoral2
				StaghornCoral3
				CrownOfThornsStarfish
				SeaUrchins
				LoneUrchin
				SeaFan
				SeaPlume
				Anemones1
				Anemones2
				SkinnyStarFish
				FatStarFish
				RedbeardSponge
				CommonSponge
				LettuceCoral
				TreeCoral
				OceanFloor
			eachElementDo: #init
		)
		(bigAnemoneTop init:)
		(if (and (not (IsFlag 19)) (== global124 440))
			(SetFlag 21)
			(bigAnemoneBottom init:)
			(anemBubbles init:)
		)
		(ghostAnemone init:)
		(blackSeaweed init:)
		(tubeSponge init:)
		(gEgo init:)
		(NormalEgo)
		(gEgo ignoreHorizon: illegalBits: 0)
		(if (not (IsFlag 73))
			(gDelph
				x: -80
				y: -20
				view: 831
				ignoreActors: 0
				ignoreHorizon: 1
				moveSpeed: 0
				cycleSpeed: 0
				init:
			)
			(NormalDelph)
			(gDelph z: 50 setPri: 15 setMotion: PFollow gEgo 90)
		)
		(fallingKey
			view: 442
			setLoop: 5
			x: 77
			y: 5
			xStep: 3
			yStep: 3
			cycleSpeed: 12
			init:
			setPri: 0
			stopUpd:
			hide:
		)
		(if (IsFlag 19)
			(fallingKey posn: 106 87 setPri: 0 show: stopUpd:)
			(redFish
				posn: 47 85
				ignoreActors: 1
				setLoop: 5
				xStep: 7
				yStep: 3
				moveSpeed: 1
				init:
				setCycle: Fwd
				setMotion: PolyPath 50 85
			)
		)
		(if (IsFlag 22)
			(fallingKey posn: 126 180 setPri: 11 show: stopUpd:)
		)
		(if (!= global124 440)
			(clownFish init:)
		)
		(if (< (fish3 detailLevel:) (gGame detailLevel:))
			(fish3 init:)
		)
		(if (< (fish4 detailLevel:) (gGame detailLevel:))
			(fish4 init:)
		)
		(if (< (fish5 detailLevel:) (gGame detailLevel:))
			(fish5 init:)
		)
		(if (< (fish7 detailLevel:) (gGame detailLevel:))
			(fish7 init:)
		)
		(switch gPrevRoomNum
			(420
				(= style -32759)
				(if (IsFlag 19)
					(fallingKey posn: 106 87 show: stopUpd:)
				)
				(gEgo posn: 1 82 heading: 90 setMotion: PolyPath 14 88 self)
				(if (not (IsFlag 73))
					(gDelph posn: -100 62 setMotion: PFollow gEgo 90)
				)
			)
			(460
				(= style -32761)
				(gEgo posn: 55 0)
				(cond
					((IsFlag 18)
						(self setScript: fromCoveNormal)
					)
					((IsFlag 19)
						(self setScript: fromCoveAfterKey)
					)
					(else
						(self setScript: fromCoveNormal)
					)
				)
			)
			(480
				(= style 11)
				(if (not (IsFlag 73))
					(gDelph posn: 420 62)
				)
				(if (and (not (IsFlag 19)) (== global124 440))
					(gEgo x: 295)
					(ghostAnemone setScript: followedRedFishTalk)
				)
			)
			(else
				(= style 7)
				(gEgo posn: 150 100)
				(if (not (IsFlag 73))
					(gDelph posn: -40 30)
				)
			)
		)
		(super init:)
		(if (!= (gLongSong number:) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 443 loop: -1 flags: 1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 42 7)
		)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $0002)
				(self setScript: toCove)
			)
		)
	)

	(method (dispose)
		(if (gCast contains: gDelph)
			(gDelph setMotion: 0 dispose:)
		)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber west 460)
			(gLongSong fade:)
			(gLongSong2 flags: 0)
		)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance redFish of Actor
	(properties
		yStep 7
		view 443
		loop 1
		cycleSpeed 8
		xStep 11
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setCycle: Fwd)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 3 0 0 30) ; "Even if he has swallowed the key, the red fish doesn't deserve THAT."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fallingKey of Actor
	(properties
		approachX 146
		approachY 95
		signal 24576
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if (IsFlag 19)
						(ClearFlag 19)
						(fallingKey setScript: chaseFish)
					)
					(if (IsFlag 22)
						(fallingKey setScript: egoGetsKey)
						(SetScore 2 310)
					)
				)
			)
			(2 ; Look
				(if (IsFlag 91)
					((ScriptID 2 1) init: 1 0 0 11 1) ; Adam, "Gross me out!"
				else
					(Narrator init: 3 0 0 10) ; "The key has fallen to the sand here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fish3 of Actor
	(properties
		x 155
		y 75
		view 54
		cycleSpeed 10
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 3
			setLoop: 1
			setCycle: Fwd
			setPri: 9
			setHeading: 250
			setMotion: MoveTo -85 100 self
		)
	)

	(method (doit)
		(if (< (self x:) -75)
			(self x: 435 y: 50)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 1 0 0 (Random 1 8) 0 50)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 1 0 0 (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: 1 0 0 (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: 1 0 0 (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: 1 0 0 (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: 1 0 0 (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: 1 0 0 (Random 29 32) 0 50)
					)
					(else
						(Narrator init: 1 0 0 (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 1 0 0 (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fish4 of Actor
	(properties
		x 180
		y 6
		view 56
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 3
			setLoop: 2
			setCycle: Fwd
			setPri: 2
			xStep: 3
			cycleSpeed: 22
			setHeading: 250
			setMotion: MoveTo 725 25 self
		)
	)

	(method (doit)
		(if (> (self x:) 720)
			(self x: -125 y: 4)
		)
		(super doit: &rest)
	)

	(method (doVerb)
		(fish3 doVerb: &rest)
	)
)

(instance fish5 of Actor
	(properties
		x 245
		y 90
		view 59
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 2
			setLoop: 3
			setCycle: Fwd
			setPri: 0
			xStep: 1
			cycleSpeed: 12
			setHeading: 100
			setMotion: MoveTo -65 85 self
		)
	)

	(method (doit)
		(if (< (self x:) -55)
			(self x: 475 y: 78)
		)
		(super doit: &rest)
	)

	(method (doVerb)
		(fish3 doVerb: &rest)
	)
)

(instance fish7 of Actor
	(properties
		x -125
		y 175
		view 55
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 1
			setLoop: 3
			setCycle: Fwd
			setPri: 15
			cycleSpeed: 4
			xStep: 4
			setHeading: 250
			setMotion: PolyPath 800 100 self
		)
	)

	(method (cue)
		(if (> (self x:) 790)
			(self posn: -500 190 setMotion: PolyPath 800 140 self)
		)
		(super doit: &rest)
	)

	(method (doVerb)
		(fish3 doVerb: &rest)
	)
)

(instance clownFish of Actor
	(properties
		x 38
		y 161
		z 15
		approachX 110
		approachY 160
		view 72
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setPri: 15
			detailLevel: 1
			setCycle: Fwd
			cycleSpeed: 10
			moveSpeed: 9
			setStep: 1 1
			setLoop: 0
			setMotion: MoveTo 50 161 self
		)
		(self approachVerbs: 3 2 4 5) ; Do, Look, Inventory, Talk
	)

	(method (cue)
		(cond
			((> (clownFish x:) 43)
				(self setMotion: MoveTo 41 151 self)
			)
			((< (clownFish y:) 153)
				(self setMotion: MoveTo 35 167 self)
			)
			((> (clownFish y:) 165)
				(self setMotion: MoveTo 30 163 self)
			)
			((< (clownFish x:) 32)
				(self setMotion: MoveTo 47 156 self)
			)
		)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 1) init: 1 0 0 7 1) ; Adam, "It's covered with that mucus gunk. I don't want to touch it."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: clownTalk)
				)
			)
			(5 ; Talk
				((ScriptID 2 1) init: 1 0 0 8 1) ; Adam, "On second thought, I don't want to scare the clownfish."
			)
			(4 ; Inventory
				(if (OneOf invItem 12 13 30) ; trident, sharpShell, hackSaw
					(Narrator init: 3 0 0 45) ; "Adam has no reason to do that."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 46) ; "The clown fish lives among the anemone's tendrils. It shouldn't be moved."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance burper of Prop
	(properties
		x 50
		y 136
		view 442
		loop 7
		cycleSpeed 18
	)
)

(instance bigAnemoneTop of Prop
	(properties
		x 41
		y 143
		approachX 110
		approachY 160
		view 442
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 1
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 23
		)
		(self approachVerbs: 3 2 4 5) ; Do, Look, Inventory, Talk
	)

	(method (doVerb theVerb invItem)
		(bigAnemoneBottom doVerb: theVerb invItem &rest)
	)
)

(instance bigAnemoneBottom of Prop
	(properties
		x 21
		y 161
		approachX 110
		approachY 160
		view 442
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 3
			setPri: 15
			setCel: 3
			setCycle: Fwd
			cycleSpeed: 23
		)
		(self approachVerbs: 3 2 4 5) ; Do, Look, Inventory, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 77 79) 0 4)
					)
					((IsFlag 21)
						(Narrator init: 3 0 0 19) ; "Some anemones have a venom that stings humans. Even with gloves, Adam shouldn't touch it."
					)
					((IsFlag 91)
						((ScriptID 2 0) init: 2 0 0 42 1) ; Delphineus, "I think we should leave him alone now, Adam."
					)
					(else
						(if local1
							((ScriptID 2 0) init: 2 0 0 9 1) ; Delphineus, "Aaah! Don't touch! Some anemones have a toxin that stings humans. They catch their prey by paralyzing them with the toxin first."
						else
							((ScriptID 2 0) init: 2 0 0 10 1) ; Delphineus, "Look out! Some of these guys sting humans as well as fish!"
						)
						(^= local1 $0001)
					)
				)
			)
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((IsFlag 91)
						((ScriptID 2 0) init: 2 0 0 41 1) ; Delphineus, "I thought he couldn't digest that lure, but I was wrong!"
					)
					((not (IsFlag 21))
						(rm440 setScript: preBulgeAnemLookTalk)
					)
					(else
						(Narrator init: 3 0 0 18) ; "The anemone heaves with discomfort. Clearly, he's bitten off more than he can chew."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(29 ; fishLure
						(if (IsFlag 21)
							(bigAnemoneBottom setScript: dangleHeavePuke)
							(SetScore 10 309)
						else
							(Narrator init: 3 0 0 33) ; "The lure attracts the anemone, but it is happily digesting something else right now."
						)
					)
					(12 ; trident
						(Narrator init: 3 0 0 12) ; "The trident would not only puncture his vanity, it would also put some serious holes in his pride."
					)
					(30 ; hackSaw
						(if (IsFlag 21)
							(Narrator init: 3 0 0 40) ; "Cutting the anemone open would get the key - but it would also get the anemone."
						else
							(Narrator init: 3 0 0 41) ; "Adam is curious about the anemones, but cutting them open isn't the answer."
						)
					)
					(13 ; sharpShell
						(if (IsFlag 21)
							(Narrator init: 3 0 0 43) ; "Cutting open the anemone isn't a good idea."
						else
							(Narrator init: 3 0 0 42) ; "The sharp shell would injure the anemones."
						)
					)
					(21 ; healingPotion
						(if (IsFlag 21)
							(Narrator init: 3 0 0 52) ; "That won't cure the anemone's indigestion."
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(else
						(cond
							((IsFlag 21)
								(Narrator init: 3 0 0 35) ; "That just seems to make the anemone feel worse."
							)
							((IsFlag 91)
								(Narrator init: 3 0 0 23) ; "The anemone should be left in peace now."
							)
							(else
								(Narrator init: 3 0 0 34) ; "That won't help the anemones."
							)
						)
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((IsFlag 21)
						(self setScript: burpAnim)
					)
					((IsFlag 91)
						(Narrator init: 3 0 0 32) ; "The anemone has said all it's going to say."
					)
					(else
						((ScriptID 2 0) init: 2 0 0 18 1) ; Delphineus, "Anemones use their mouths only for eating, not for talking."
					)
				)
			)
			(10 ; Recycle
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((IsFlag 21)
						(Narrator init: 3 0 0 20) ; "The anemone's stomach is like a garbage bag, but that doesn't mean he wants to be in one."
					)
					(else
						(Narrator init: 3 0 0 38) ; "Anemones are animals. As such, they don't want to be bagged."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance anemBubbles of Prop
	(properties
		x 40
		y 130
		approachX 110
		approachY 160
		view 807
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 1
			ignoreActors: 1
			detailLevel: 0
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 23
			setScript: handleAnemBubbles
		)
	)
)

(instance swingingLure of Prop
	(properties
		view 441
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 13 setCycle: Fwd cycleSpeed: 16)
	)
)

(instance ghostAnemone of Prop
	(properties
		x 300
		y 107
		approachX 220
		approachY 95
		view 440
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 2
			setPri: 13
			setCycle: Fwd
			cycleSpeed: 16
		)
		(self approachVerbs: 3 2 5) ; Do, Look, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local1
						((ScriptID 2 0) init: 2 0 0 9 1) ; Delphineus, "Aaah! Don't touch! Some anemones have a toxin that stings humans. They catch their prey by paralyzing them with the toxin first."
					else
						((ScriptID 2 0) init: 2 0 0 10 1) ; Delphineus, "Look out! Some of these guys sting humans as well as fish!"
					)
					(^= local1 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 27 1) ; Delphineus, "Ghost anemone. Wooooooo."
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 18 1) ; Delphineus, "Anemones use their mouths only for eating, not for talking."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blackSeaweed of Prop
	(properties
		x 160
		y 171
		approachX 160
		approachY 95
		lookStr 47
		view 440
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 detailLevel: 3 setCycle: Fwd cycleSpeed: 21)
		(self approachVerbs: 3 2 4 5) ; Do, Look, Inventory, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 48) ; "The weeds are fine where they are."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 49) ; "The weeds are living. They don't need to be thrown out."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tubeSponge of Prop
	(properties
		x 34
		y 91
		approachX 120
		approachY 95
		view 440
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 detailLevel: 3 setCycle: Fwd cycleSpeed: 28)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 29 1) ; Delphineus, "Guess why they call this a tube sponge!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishSkeleton of Prop ; UNUSED
	(properties
		x 135
		y 160
		approachX 120
		approachY 140
		view 900
		loop 2
		cel 7
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 7 setCel: 3 cycleSpeed: 28)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 12 1) ; Delphineus, "What would you want with an old fish skeleton?"
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 13 1) ; Delphineus, "I guess that'll show him to get grabby!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance CoveCave of Feature
	(properties
		x 70
		y 27
		nsTop 13
		nsLeft 20
		nsBottom 35
		nsRight 110
		onMeCheck 2
		approachX 130
		approachY 80
	)

	(method (init)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(gCurRoom setScript: toCove)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 9) ; "A small opening with just enough room for one person to squeeze through...before lunch that is."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Anemones1 of Feature
	(properties
		x 24
		y 141
		nsTop 130
		nsBottom 190
		nsRight 60
		approachX 110
		approachY 160
	)

	(method (init)
		(self approachVerbs: 3 2 5) ; Do, Look, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 77 79) 0 4)
					)
					((IsFlag 91)
						(Narrator init: 3 0 0 29) ; "Adam remembers that anemones can sting their prey and draws back."
					)
					((not (IsFlag 21))
						(if local1
							((ScriptID 2 0) init: 2 0 0 9 1) ; Delphineus, "Aaah! Don't touch! Some anemones have a toxin that stings humans. They catch their prey by paralyzing them with the toxin first."
						else
							((ScriptID 2 0) init: 2 0 0 10 1) ; Delphineus, "Look out! Some of these guys sting humans as well as fish!"
						)
						(^= local1 $0001)
					)
					(else
						(Narrator init: 3 0 0 27) ; "They can't do anything about this."
					)
				)
			)
			(2 ; Look
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((IsFlag 91)
						(Narrator init: 3 0 0 28) ; "The anemones wave their tendrils."
					)
					((not (IsFlag 21))
						(Narrator init: 3 0 0 16) ; "A cluster of anemones waves its tendrils. Unwary fish who swim through will be swallowed!"
					)
					(else
						(Narrator init: 3 0 0 26) ; "No doubt the other anemones are jealous... On second, thought, maybe not."
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 73)
						(Narrator init: 2 0 0 (Random 74 76) 0 4)
					)
					((or (IsFlag 21) (IsFlag 91))
						(Narrator init: 3 0 0 31) ; "The anemones are speechless."
					)
					(else
						((ScriptID 2 0) init: 2 0 0 18 1) ; Delphineus, "Anemones use their mouths only for eating, not for talking."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Anemones2 of Feature
	(properties
		x 87
		y 165
		nsTop 160
		nsLeft 72
		nsBottom 190
		nsRight 106
		approachX 110
		approachY 160
	)

	(method (init)
		(self approachVerbs: 3 2 5) ; Do, Look, Talk
	)

	(method (doVerb theVerb invItem)
		(Anemones1 doVerb: theVerb invItem &rest)
	)
)

(instance BrainCoral of Feature
	(properties
		x 210
		y 129
		nsTop 115
		nsLeft 179
		nsBottom 143
		nsRight 241
		approachX 210
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: brainCoralTalk)
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance StaghornCoral1 of Feature
	(properties
		x 11
		y 39
		nsTop 18
		nsLeft 3
		nsBottom 61
		nsRight 20
		approachX 120
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance StaghornCoral2 of Feature
	(properties
		x 107
		y 64
		nsTop 46
		nsLeft 90
		nsBottom 82
		nsRight 125
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance StaghornCoral3 of Feature
	(properties
		x 153
		y 32
		nsTop 1
		nsLeft 123
		nsBottom 64
		nsRight 184
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance CrownOfThornsStarfish of Feature
	(properties
		x 281
		y 130
		nsTop 121
		nsLeft 269
		nsBottom 140
		nsRight 291
		approachX 220
		approachY 95
	)

	(method (init)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 38 1) ; Delphineus, "I wouldn't mess with him, if I were you."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 5) ; "The crown-o'-thorns starfish chews up the coral. If their population gets too big, they can do in a whole reef."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SeaUrchins of Feature
	(properties
		x 23
		y 90
		nsTop 86
		nsLeft 12
		nsBottom 95
		nsRight 34
		approachX 120
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 50) ; "Careful! Adam can get a nasty infection if one of those sea urchin spines punctures his skin."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 2) ; "Sea urchins eat algae - and that encourages the coral to grow more. The spines have fallen off this skeleton."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance LoneUrchin of Feature
	(properties
		x 187
		y 181
		nsTop 174
		nsLeft 177
		nsBottom 189
		nsRight 198
		approachX 110
		approachY 160
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 50) ; "Careful! Adam can get a nasty infection if one of those sea urchin spines punctures his skin."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: loneUrchinTalk)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SeaFan of Feature
	(properties
		x 241
		y 25
		nsTop 14
		nsLeft 228
		nsBottom 36
		nsRight 254
		approachX 220
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 26 1) ; Delphineus, "Sea fans are my favorite."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SeaPlume of Feature
	(properties
		x 117
		y 109
		nsTop 97
		nsLeft 108
		nsBottom 121
		nsRight 126
		approachX 160
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 51) ; "Despite its neat-o name, Adam decides not to gather the sea plume for a pirate hat."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 47 1) ; Delphineus, "That's known as a 'sea plume'. They even look like big feathers, don't they?"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SkinnyStarFish of Feature
	(properties
		x 59
		y 117
		nsTop 111
		nsLeft 53
		nsBottom 124
		nsRight 66
		approachX 120
		approachY 95
	)

	(method (init)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 24) ; "Sea stars can grow new arms. Still, it doesn't do to pry one up."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 8) ; "Sea stars can open a whole clam with their suction cups."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance FatStarFish of Feature
	(properties
		x 220
		y 167
		nsTop 156
		nsLeft 212
		nsBottom 178
		nsRight 227
		approachX 110
		approachY 160
	)

	(method (init)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 24) ; "Sea stars can grow new arms. Still, it doesn't do to pry one up."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 32 1) ; Delphineus, "Starfish love to eat oysters. It drives fishermen nuts."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance RedbeardSponge of Feature
	(properties
		x 300
		y 173
		nsTop 159
		nsLeft 292
		nsBottom 188
		nsRight 319
		approachX 110
		approachY 160
	)

	(method (init)
		(self approachVerbs: 2) ; Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 3) ; "Redbeard sponge looks soft and, well, spongy."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance CommonSponge of Feature
	(properties
		x 193
		y 91
		nsTop 81
		nsLeft 178
		nsBottom 101
		nsRight 207
		approachX 160
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 20 1) ; Delphineus, "That's called a common sponge, but we like it."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance LettuceCoral of Feature
	(properties
		x 311
		y 115
		nsTop 105
		nsLeft 304
		nsBottom 125
		nsRight 319
		approachX 220
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 25 1) ; Delphineus, "I've heard lettuce coral is low fat. Hehe."
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance TreeCoral of Feature
	(properties
		x 300
		y 60
		nsTop 45
		nsLeft 281
		nsBottom 75
		nsRight 319
		approachX 220
		approachY 95
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1) ; Delphineus, "Look out! If you touch the coral, it dies. It's sharp, too!"
					)
					(^= local0 $0001)
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 4) ; "The tree coral looks a lot like regular you-know-whats."
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1) ; Delphineus, "The coral are gossips. I wouldn't get into it with them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance OceanFloor of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(Narrator init: 3 0 0 11) ; "Adam doesn't have any use for a handful of sand."
				)
			)
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(Narrator init: 3 0 0 1) ; "The ground-up coral makes beautiful, white sand."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fromCoveNormal of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 0 posn: 72 -34 forceUpd:)
				(= ticks 60)
			)
			(1
				(gEgo setMotion: PolyPath 78 50 self)
			)
			(2
				(gEgo setPri: -1 setMotion: PolyPath 103 90 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance fromCoveAfterKey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 0 posn: 72 34 loop: 2 setHeading: 170)
				(if (IsFlag 44)
					(fallingKey
						posn: 77 5
						show:
						ignoreActors: 1
						view: 442
						loop: 5
						xStep: 5
						yStep: 7
						cycleSpeed: 18
						setCycle: Fwd
						setMotion: MoveTo 106 87 self
					)
				else
					(fallingKey posn: 106 87)
					(self cue:)
				)
				(ClearFlag 44)
			)
			(1
				(fallingKey setPri: 0 stopUpd:)
				(gEgo setMotion: MoveTo 85 64 self)
			)
			(2
				(gEgo setPri: -1 setMotion: PolyPath 140 70 self)
			)
			(3
				(gEgo setHeading: 305 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance toCove of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 70 20 self)
			)
			(1
				(gEgo setCycle: 0 setLoop: 3)
				(= ticks 10)
			)
			(2
				(gEgo setCycle: Fwd setMotion: MoveTo 70 10 self)
			)
			(3
				(gCurRoom newRoom: 460)
				(self dispose:)
			)
		)
	)
)

(instance chaseFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(redFish setLoop: 6 cel: 0 posn: 85 74 setCycle: CT 1 1 self)
			)
			(1
				(gSoundEffects number: 442 loop: 1 play:)
				(fallingKey hide:)
				(redFish setLoop: 6 posn: 85 74 setCycle: End self)
			)
			(2
				(Narrator posn: -1 130 init: 3 0 0 17 self) ; "Out of nowhere a lurking fish darts forward."
			)
			(3
				((ScriptID 2 1) init: 1 0 0 10 1) ; Adam, "Hey, you, give that back!"
				(redFish
					setLoop: 0
					posn: 118 100
					xStep: 11
					yStep: 7
					setCycle: Fwd
					setMotion: PolyPath 189 110 self
				)
				(gEgo setMotion: PolyPath 310 95)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 44 1 self) ; Delphineus, "He swallowed it, he swallowed it! I can't believe it!"
			)
			(5
				((ScriptID 2 0) init: 2 0 0 46 1) ; Delphineus, "After him, Adam, what a pig!"
				(redFish
					setLoop: 2
					posn: 200 122
					setMotion: PolyPath 355 85 self
				)
				(ClearFlag 19)
				(= global124 480)
			)
			(6
				(gEgo setMotion: PolyPath 330 95 self)
			)
			(7
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance delWanders of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gDelph setPri: 15)
				(if (> (gDelph x:) 320)
					(gDelph setMotion: MoveTo -20 20 self)
				)
				(if (< (gDelph x:) 0)
					(gDelph setMotion: MoveTo 340 20 self)
				)
			)
			(1
				(self dispose:)
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance dangleHeavePuke of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 54 109 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 441
					loop: 1
					posn: 54 109
					setCycle: Fwd
				)
				(swingingLure
					view: 441
					loop: 0
					init:
					posn: 45 108
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(2
				(Narrator posn: -1 25 init: 3 0 0 21 self) ; "Adam moves the bright fishing lure in front of the anemone."
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo put: 29 0) ; fishLure
				(SetFlag 91)
				(bigAnemoneTop
					view: 442
					loop: 1
					cel: 0
					posn: 41 143
					cycleSpeed: 23
					setCycle: CT 3 1 self
				)
				(bigAnemoneBottom view: 442 loop: 6 posn: 21 161 setCycle: Beg)
			)
			(5
				(swingingLure dispose:)
				(gSoundEffects number: 441 loop: 1 play:)
				(bigAnemoneTop setCycle: CT 5 1 self)
			)
			(6
				(bigAnemoneTop setCel: 6)
				(fallingKey
					view: 442
					loop: 2
					setCel: 0
					setPri: 15
					posn: 105 139
					show:
				)
				(= cycles 7)
			)
			(7
				(bigAnemoneTop
					view: 442
					loop: 0
					cel: 0
					x: 41
					y: 143
					cycleSpeed: 23
					setCycle: Fwd
				)
				(fallingKey
					view: 442
					loop: 2
					posn: 105 139
					cycleSpeed: 23
					setCycle: End self
				)
			)
			(8
				(fallingKey
					view: 442
					loop: 5
					posn: 117 146
					setCycle: Fwd
					setMotion: MoveTo 129 172 self
				)
			)
			(9
				((ScriptID 2 0) init: 2 0 0 13 1 self) ; Delphineus, "I guess that'll show him to get grabby!"
			)
			(10
				(fallingKey
					setCel: 0
					posn: 129 172
					setPri: 0
					approachX: 110
					approachY: 170
					stopUpd:
				)
				(NormalEgo)
				(= global124 0)
				(ClearFlag 21)
				(SetFlag 22)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsKey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 123 158 self)
			)
			(1
				(Narrator init: 3 0 0 14 self) ; "Adam picks up the key and tries not to think about where it's been."
			)
			(2
				(gEgo get: 25) ; boxKey
				(fallingKey hide: dispose:)
				(ClearFlag 22)
				(self dispose:)
			)
		)
	)
)

(instance handleAnemBubbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(anemBubbles cel: 0 setCycle: End self)
			)
			(1
				(= ticks 720)
			)
			(2
				(= state -1)
				(self cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance clownTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 14 1 self) ; Delphineus, "Don't be fooled. That clownfish is a decoy for the anemone."
			)
			(1
				((ScriptID 2 1) init: 1 0 0 5 1 self) ; Adam, "What's a decoy?"
			)
			(2
				((ScriptID 2 0) init: 2 0 0 15 1 self) ; Delphineus, "He lures other fish near the anemone and then scarfs up the scraps when the anemone strikes."
			)
			(3
				((ScriptID 2 1) init: 1 0 0 3 1 self) ; Adam, "No way!"
			)
			(4
				((ScriptID 2 0) init: 2 0 0 16 1 self) ; Delphineus, "Yeah, the clownfish is covered with a special mucus."
			)
			(5
				((ScriptID 2 1) init: 1 0 0 4 1 self) ; Adam, "Yuck."
			)
			(6
				((ScriptID 2 0) init: 2 0 0 17 1 self) ; Delphineus, "Slimy, but it protects him from the anemone's sting. Weird partnership."
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance commonSpongeTalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 20 1 self) ; Delphineus, "That's called a common sponge, but we like it."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance commonSpongeDoTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 39 1 self) ; Delphineus, "Not a live sponge, Adam!"
			)
			(1
				((ScriptID 2 1) init: 1 0 0 6 1 self) ; Adam, "Yeah, I guess the ones we buy are skeletons. They're great for stuff like cleaning the car!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance staghornTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 21 0 self) ; Delphineus, "Coral are really a lot of small animals called polyps."
			)
			(1
				((ScriptID 2 0) init: 2 0 0 22 0 self) ; Delphineus, "Each generation builds on the skeletons of the last one."
			)
			(2
				((ScriptID 2 0) init: 2 0 0 23 0 self) ; Delphineus, "Little by little, they can form huge walls."
			)
			(3
				((ScriptID 2 0) init: 2 0 0 24 1 self) ; Delphineus, "That's staghorn coral."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance brainCoralTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 28 0 self) ; Delphineus, "The brain coral has its name for the obvious reason."
			)
			(1
				((ScriptID 2 0) init: 2 0 0 33 1 self) ; Delphineus, "I've never found this one very intelligent though!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance loneUrchinTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 30 0 self) ; Delphineus, "That's just a sea urchin skeleton, Adam. The live ones are covered with spines - sort of porcupines of the sea."
			)
			(1
				((ScriptID 2 0) init: 2 0 0 31 1 self) ; Delphineus, "Their spines get under your skin and cause a nasty infection."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance preBulgeAnemLookTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 2 0 self) ; Delphineus, "This guy is always eating. I tell him, 'Hey, slow down.' Anemones are like goats, they'll eat anything."
			)
			(1
				((ScriptID 2 0) init: 2 0 0 4 0 self) ; Delphineus, "His stomach is like a big sack. He can only eat one thing at a time. If he can't digest it, he'll throw it up after a while."
			)
			(2
				((ScriptID 2 1) init: 1 0 0 2 1 self) ; Adam, "Barferama!"
			)
			(3
				((ScriptID 2 0) init: 2 0 0 5 1 self) ; Delphineus, "I know. That's why I don't eat dinner with anemones too often."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bulgeAnemTalkT of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 3 1 self) ; Delphineus, "Oh no! What goats they are!"
			)
			(1
				((ScriptID 2 1) init: 1 0 0 4 1 self) ; Adam, "Yuck."
			)
			(2
				((ScriptID 2 0) init: 2 0 0 5 1 self) ; Delphineus, "I know. That's why I don't eat dinner with anemones too often."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance coralDoTalk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 8 0 self) ; Delphineus, "Tourists break pieces off for souvenirs."
			)
			(1
				((ScriptID 2 0) init: 2 0 0 37 1 self) ; Delphineus, "Weekend divers can kill a reef that took hundreds of years to grow in just a couple of years."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance followedRedFishTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 300)
			)
			(1
				(gEgo setMotion: PolyPath 200 85 self)
			)
			(2
				(gEgo setHeading: 270)
				(= ticks 100)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 9 1 self) ; Adam, "Rats! We lost him. Where'd he go?"
			)
			(4
				((ScriptID 2 0) init: 2 0 0 45 1 self) ; Delphineus, "Dunno, Adam, but I do know he's packing iron!"
			)
			(5
				(self setScript: burpAnim self)
			)
			(6
				(HandsOn)
				(= ticks 4200)
			)
			(7
				(if (not (IsFlag 91))
					((ScriptID 2 0) init: 2 0 0 40 1) ; Delphineus, "Something's really disagreed with him, Adam! We've got to get him to let go of it!"
				)
				(self dispose:)
			)
		)
	)
)

(instance burpAnim of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 441 loop: 1 play:)
				(burper init: setCycle: End self)
			)
			(1
				(burper dispose:)
				(self dispose:)
			)
		)
	)
)

