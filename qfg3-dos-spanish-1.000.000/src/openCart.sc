;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Talker)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	openCart 0
	avisTalker 1
)

(local
	[local0 6]
)

(instance openCart of Rm
	(properties
		picture 100
		style 9
		vanishingY -200
	)

	(method (init)
		(Narrator color: 10)
		(HandsOff)
		(self setRegions: 61) ; intro
		(gTheIconBar disable:)
		(= [local0 0] (candle new:))
		(= [local0 1] (candle new:))
		(= [local0 2] (candle new:))
		(= [local0 3] (candle new:))
		(= [local0 4] (candle new:))
		(LoadMany rsSOUND 100 913 902)
		(switch gHeroType
			(0 ; Fighter
				(Load rsSOUND 101)
				(Load rsVIEW 650)
			)
			(2 ; Thief
				(Load rsSOUND 12)
				(Load rsSOUND 900)
			)
			(1 ; Magic User
				(Load rsSOUND 12)
				(Load rsSOUND 900)
				(Load rsSOUND 13)
			)
			(3 ; Paladin
				(Load rsSOUND 101)
			)
		)
		(candle
			x: 126
			y: 97
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		([local0 0]
			x: 102
			y: 80
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		([local0 1]
			x: 132
			y: 64
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		([local0 2]
			x: 182
			y: 67
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		([local0 3]
			x: 211
			y: 83
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		([local0 4]
			x: 186
			y: 102
			cel: (Random 0 (candle lastCel:))
			setCycle: Fwd
			init:
		)
		(avis setScale: 190 init:)
		(cond
			((== gHeroType 2) ; Thief
				(gEgo
					x: 27
					y: 119
					setScale: 190
					init:
					changeGait: 2 ; sneaking
					setCycle: Walk
				)
				(pillar init: setPri: 11 stopUpd:)
				(pillar2 init: setPri: 7 stopUpd:)
			)
			((or (== gHeroType 1) (IsFlag 144)) ; Magic User
				(gEgo
					x: 325
					y: 86
					setScale: 190
					normalize:
					init:
					setHeading: 300
					setStep: 3 2
				)
			)
			((or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
				(gEgo x: 325 y: 86 setScale: 190 normalize: init:)
				(avisTalker x: 4 y: 94 textX: 140 textY: 30 talkWidth: 145)
			)
		)
		(if (or (!= gHeroType 0) (IsFlag 144)) ; Fighter
			(spellImage setLoop: 0 setScale: 190 init: hide:)
		)
		(brazier
			setScale: 190
			setLoop: (if (== gHeroType 1) 1 else 0) ; Magic User
			x: (if (== gHeroType 1) 87 else 60) ; Magic User
			y: (if (== gHeroType 1) 68 else 87) ; Magic User
			init:
		)
		(super init: &rest)
		(gCurRoom setScript: charSwitch)
	)

	(method (dispose)
		(DisposeScript 951)
		(gTheIconBar enable:)
		(Narrator color: 17)
		(UnLoad 128 650)
		(UnLoad 132 13)
		(UnLoad 132 900)
		(UnLoad 132 12)
		(UnLoad 132 902)
		(UnLoad 132 913)
		(UnLoad 132 101)
		(super dispose:)
	)
)

(instance charSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gLongSong number: 100 play: 127 self hold: 1)
			)
			(2
				(gLongSong client: 0)
				(Narrator keepWindow: 0)
				(gMessager say: 1 6 12 0 self) ; "Ad Avis stood before his hexagram, preparing to unleash the foul Iblis to do his bidding."
			)
			(3
				(avis setLoop: 1 setCycle: End self)
			)
			(4
				(gNarrator y: 120)
				(gMessager say: 2 6 2 0 self) ; "Hear me, O Dark Powers! Light the darkness and bind Iblis to me forever!"
			)
			(5
				(gLongSong hold: 2)
				(self
					setScript:
						(cond
							((and (== gHeroType 3) (IsFlag 144)) mageCartoon) ; Paladin
							((== gHeroType 0) fighterCartoon) ; Fighter
							((== gHeroType 1) mageCartoon) ; Magic User
							((== gHeroType 2) thiefCartoon) ; Thief
							(else fighterCartoon)
						)
						self
				)
			)
			(6
				(gLongSong release:)
				(= cycles 3)
			)
			(7
				(gCurRoom newRoom: 110)
			)
		)
	)
)

(instance knockBrazier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(avis view: 103 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(1
				(brazier setCycle: End)
				(avis setCycle: End self)
			)
			(2
				(avis loop: 1 cel: 0 setCycle: End)
				(gLongSong2 number: 101 play: self)
				(flame init: setCycle: End self)
			)
			(3
				(brazier setLoop: 2 setCycle: Fwd)
			)
			(4
				(gLongSong2 number: 913 setLoop: -1 play:)
				(flame2 setPri: 1 setCycle: End self init:)
				(flame setLoop: 1 setCycle: Fwd)
			)
			(5
				(flame2 setLoop: 3 cel: 0 setCycle: Fwd)
				(avis view: 101 loop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance fighterCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo changeGait: 1 setMotion: MoveTo 217 83 self) ; running
			)
			(1
				(gLongSong2 number: 902 play:)
				([local0 3] cel: 0 loop: 1 x: (- ([local0 3] x:) 8))
				(= cycles 6)
			)
			(2
				([local0 3] setCycle: End self)
			)
			(3
				(gMessager say: 1 6 4 0 self) ; "You entered the room and broke the Seal of Suleiman by moving the candle."
			)
			(4
				(gLongSong hold: 3)
				(avis setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 2 6 3 0 self) ; "You idiot! You have destroyed my spell. Now you shall be destroyed!"
			)
			(6
				(gEgo setMotion: MoveTo 186 56 self)
				(self setScript: knockBrazier self)
			)
			(7
				(gLongSong hold: 4)
			)
			(8
				(gEgo normalize: 5)
				(gMessager say: 2 6 5 0 self) ; "Fool, you cannot hurt me now, and I shall send thee to thy death!"
			)
			(9
				(gEgo
					view: 109
					setCycle: Walk
					setLoop: 0
					cel: 0
					setMotion: MoveTo 90 74 self
				)
			)
			(10
				(gLongSong2 number: 901 setLoop: 1 play:)
				(avis
					view: 107
					loop: 0
					cel: 0
					x: 77
					y: 76
					setStep: 6 4
					xStep: 6
					yStep: 4
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 32 85 self
				)
			)
			(11
				(avis view: 105 loop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 912 setLoop: 1 play: 127)
			)
			(12
				(avisBust cel: 1)
				(avisEyes loop: 4)
				(gMessager say: 2 6 6 0 self) ; "No! No!  Master, help me!"
			)
			(13
				(= seconds 2)
			)
			(14
				(gLongSong2 fade: 0 2 5 1)
				(avis dispose:)
				(gMessager say: 1 6 7 0 self) ; "You passed through the raging flames and sent Ad Avis falling to his doom."
			)
			(15
				(gLongSong release:)
				(self dispose:)
			)
		)
	)
)

(instance mageCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 290 86 self)
			)
			(2
				(gEgo view: 14 loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(3
				(gLongSong2 number: 12 play:)
				(gEgo setCycle: Beg)
				(spellImage
					ignoreActors: 1
					setLoop: 7
					cel: 0
					setScale: 190
					x: 288
					y: 65
					setCycle: Fwd
					show:
					setMotion: JumpTo 182 63 self
				)
			)
			(4
				([local0 2] dispose:)
				(spellImage setMotion: JumpTo 280 65 self)
			)
			(5
				(gEgo normalize:)
				(spellImage hide:)
				(gMessager say: 1 6 4 0 self) ; "You entered the room and broke the Seal of Suleiman by moving the candle."
			)
			(6
				(gMessager say: 2 6 3 0 self) ; "You idiot! You have destroyed my spell. Now you shall be destroyed!"
			)
			(7
				(gLongSong hold: 3)
				(avis setLoop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 900 play:)
				(spellImage
					setLoop: 1
					origStep: 5138
					x: 76
					y: 40
					setScale: 190
					show:
					moveSpeed: 0
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 20)
						self
				)
			)
			(8)
			(9
				(gLongSong2 number: 10 play:)
				(spellImage
					origStep: 5138
					setMotion:
						MoveTo
						(- (gEgo x:) 50)
						(- (gEgo y:) 20)
						self
				)
			)
			(10
				(spellImage setCycle: 0 hide:)
				(gMessager say: 1 6 8 0 self) ; "Your spell of Reversal protected you from his spells."
			)
			(11
				(gEgo view: 14 loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(gEgo setCycle: Beg)
				(gLongSong2 number: 13 play:)
				(spellImage
					x: 285
					y: 67
					origStep: 5138
					xStep: 16
					yStep: 12
					show:
					setCycle: End
					setMotion: MoveTo 76 52 self
				)
			)
			(13
				(gEgo normalize:)
				(gLongSong2 number: 11 play:)
				(spellImage origStep: 5138 setMotion: MoveTo 126 53 self)
			)
			(14
				(spellImage setCycle: 0 hide:)
				(gMessager say: 1 6 9 0 self) ; "Unfortunately, Ad Avis also had a spell to reflect spells."
			)
			(15
				(= ticks 60)
			)
			(16
				(gEgo view: 14 loop: 1 cel: 0 setCycle: End self)
			)
			(17
				(gLongSong2 number: 13 play:)
				(spellImage
					setLoop: 5
					cel: 0
					x: 285
					y: 60
					origStep: 5138
					show:
					setCycle: Fwd
					setMotion: MoveTo 147 17 self
				)
				(gEgo setCycle: Beg)
			)
			(18
				(gLongSong2 number: 11 play:)
				(spellImage origStep: 5138 setMotion: MoveTo 76 52 self)
			)
			(19
				(gEgo normalize:)
				(spellImage dispose:)
				(gLongSong2 number: 902 play:)
				(brazier setCycle: CT 5 1 self)
			)
			(20
				(brazier setCycle: End self)
				(avis
					view: 107
					loop: 0
					cel: 0
					x: 77
					y: 76
					setStep: 4 3
					xStep: 4
					yStep: 3
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 32 85 self
				)
			)
			(21 0)
			(22
				(brazier setLoop: 2 setCycle: Fwd)
				(= cycles 6)
			)
			(23
				(avis view: 105 loop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 912 setLoop: 1 play: 127)
			)
			(24
				(avisBust cel: 1)
				(avisEyes loop: 4)
				(gMessager say: 2 6 6 0 self) ; "No! No!  Master, help me!"
			)
			(25
				(gLongSong hold: 4)
				(= seconds 2)
			)
			(26
				(gMessager say: 1 6 10 0 self) ; "You bounced your spell off the wall and into the flaming brazier, knocking Ad Avis to his doom below."
			)
			(27
				(gLongSong release:)
				(self dispose:)
			)
		)
	)
)

(instance thiefCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo
					view: 9
					loop: 2
					cel: 0
					x: 27
					y: 119
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setHeading: 90)
				(dag
					x: 66
					y: 84
					init:
					setStep: 5 3
					setScale: 190
					setLoop: 2
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 102 80 self
				)
				(gLongSong2 number: 916 setLoop: 1 play: 127)
				(gEgo setCycle: End)
			)
			(3
				(gEgo view: 2)
				(dag dispose:)
				(gLongSong2 number: 902 play:)
				([local0 0] loop: 2 setCycle: End self)
			)
			(4
				(gMessager say: 1 6 4 0 self) ; "You entered the room and broke the Seal of Suleiman by moving the candle."
			)
			(5
				(gMessager say: 2 6 3 0 self) ; "You idiot! You have destroyed my spell. Now you shall be destroyed!"
			)
			(6
				(gLongSong hold: 3)
				(avis setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(7
				(gLongSong2 number: 900 play:)
				(spellImage
					x: 95
					y: 35
					init:
					setPri: 9
					origStep: 5138
					setScale: 190
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					show:
					setMotion: MoveTo 45 70 self
				)
				(avis setCycle: End)
			)
			(8
				(spellImage origStep: 5138 setMotion: MoveFwd 120)
				(gEgo view: 108 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				(= ticks 60)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo
					normalize:
					changeGait: 1 ; running
					setMotion: MoveTo 169 164 self
				)
			)
			(12
				(gEgo setMotion: MoveTo 183 164 self)
			)
			(13
				(spellImage hide:)
				(gEgo changeGait: 2) ; sneaking
				(= ticks 30)
			)
			(14
				(avis cel: 0 setCycle: CT 5 1 self)
			)
			(15
				(gLongSong2 number: 900 play:)
				(spellImage
					x: 95
					y: 35
					show:
					setPri: 7
					origStep: 5138
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 175 112 self
				)
			)
			(16
				(gLongSong2 number: 13 play:)
				(spellImage
					origStep: 5138
					yStep: 12
					setMotion: MoveTo 200 105 self
				)
			)
			(17
				(spellImage setCycle: 0 hide:)
				(gEgo changeGait: 1 setMotion: MoveTo 235 144 self) ; running
			)
			(18
				(gEgo setHeading: 315)
				(avis cel: 0 setCycle: CT 5 1 self)
			)
			(19
				(gLongSong2 number: 900 play:)
				(spellImage
					x: 95
					y: 35
					show:
					setPri: 7
					origStep: 5138
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 189 95 self
				)
			)
			(20
				(spellImage setPri: 11 origStep: 5138 setMotion: MoveFwd 180)
				(gEgo view: 108 setLoop: 3 setCycle: CT 4 1 self)
			)
			(21
				(= ticks 45)
			)
			(22
				(gEgo setCycle: End self)
			)
			(23
				(spellImage dispose:)
				(gEgo view: 9 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(24
				(dag
					x: 195
					y: 96
					origStep: 2568
					cycleSpeed: 0
					setScale: 190
					moveSpeed: 0
					setCycle: Rev
					setMotion: MoveTo 105 60 self
					init:
				)
				(gLongSong2 number: 916 setLoop: 1 play: 127)
				(gEgo setCycle: End)
			)
			(25
				(dag dispose:)
				(avis
					view: 107
					cel: 0
					moveSpeed: 0
					ignoreActors: 1
					setCycle: Rev
					setMotion: MoveTo 32 85 self
				)
			)
			(26
				(avis view: 105 loop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 912 setLoop: 1 play: 127)
			)
			(27
				(avisBust cel: 1)
				(avisEyes loop: 4)
				(gMessager say: 2 6 6 0 self) ; "No! No!  Master, help me!"
			)
			(28
				(gLongSong hold: 4)
				(= seconds 2)
			)
			(29
				(avis dispose:)
				(= cycles 3)
			)
			(30
				(gNarrator y: 30)
				(gMessager say: 1 6 11 0 self) ; "You threw your last dagger at Ad Avis, and he fell to his doom."
			)
			(31
				(gLongSong release:)
				(gNarrator y: 120)
				(self dispose:)
			)
		)
	)
)

(instance flame of Prop
	(properties
		x 65
		y 89
		view 650
		signal 16384
	)
)

(instance flame2 of Prop
	(properties
		x 65
		y 89
		view 650
		loop 2
		signal 16384
	)
)

(instance dag of Actor
	(properties
		view 46
		loop 2
		signal 16384
	)
)

(instance avis of Actor
	(properties
		x 76
		y 76
		view 101
	)
)

(instance brazier of Prop
	(properties
		x 60
		y 87
		view 100
		signal 16384
	)
)

(instance pillar of Prop
	(properties
		x 155
		view 106
		cel 1
		signal 24576
	)
)

(instance pillar2 of Prop
	(properties
		x 4
		view 106
		signal 24576
	)
)

(instance avisTalker of GloryTalker
	(properties
		x 110
		y 15
		view 119
		loop 1
		talkWidth 210
		back 57
		textX -60
		textY 100
	)

	(method (init)
		(super init: avisBust avisEyes avisMouth &rest)
	)

	(method (show)
		(super show:)
		(DrawCel
			(bust view:)
			(bust loop:)
			(bust cel:)
			(+ (bust nsLeft:) nsLeft)
			(+ (bust nsTop:) nsTop)
			-1
		)
	)
)

(instance avisBust of Prop
	(properties
		nsTop 28
		nsLeft 33
		view 119
		loop 3
	)
)

(instance avisMouth of Prop
	(properties
		nsTop 56
		nsLeft 33
		view 119
		cycleSpeed 10
	)
)

(instance avisEyes of Prop
	(properties
		nsTop 39
		nsLeft 34
		view 119
		loop 2
		cycleSpeed 30
	)
)

(instance candle of Prop
	(properties
		view 102
		signal 16384
	)
)

(instance spellImage of Actor
	(properties
		view 21
		signal 16384
	)
)

