;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro5B 0
)

(local
	local0
	local1
	[local2 2]
	local4
)

(instance intro5B of Rm
	(properties
		picture 71
	)

	(method (init)
		(super init:)
		(= local0 1)
		(HandsOff)
		(gGame setCursor: 5 1)
		(egoHead init:)
		(gEgo
			view: 763
			loop: 1
			posn: 102 109
			normal: 0
			cycleSpeed: 2
			init:
			setPri: (+ (egoHead priority:) 1)
		)
		((gEgo head:) hide:)
		(owl view: 757 setPri: 10 ignoreActors: 1 setLoop: 1 init:)
		(intro_eyes
			setPri: (+ (owl priority:) 1)
			setLoop: 2
			posn: (+ (owl x:) 2) (- (owl y:) 34)
			setScript: blinkScript
			init:
		)
		(intro_mouth
			setPri: (+ (owl priority:) 1)
			setLoop: 3
			posn: (+ (owl x:) 3) (- (owl y:) 30)
			init:
		)
		(rWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 4
			posn: (- (owl x:) 5) (- (owl y:) 28)
			signal: 16384
			setScript: rWingScript
			init:
		)
		(lWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 5
			posn: (+ (owl x:) 7) (- (owl y:) 26)
			setScript: lWingScript
			signal: 16384
			init:
		)
		(self setRegions: 763) ; cartoonRegion
		(self setScript: sceneEightScript)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(intro_eyes setPri: (+ (owl priority:) 1))
		(intro_mouth setPri: (+ (owl priority:) 1))
		(rWing setPri: (+ (owl priority:) 2))
		(lWing setPri: (+ (owl priority:) 2))
	)
)

(instance sceneEightScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(intro_mouth cycleSpeed: 2 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gGlobalSound number: 10 loop: -1 playBed:)
				(PrintDC 114 0 #at 140 100 #dispose #width 150) ; "Je peux peut-\88tre vous aider. Il se fait que mon patron est aussi un magicien et c'est pour \87a que j'ai reconnu Mordack. Cependant, contrairement \85 Mordack, mon patron est un tr\8as bon magicien."
				(= seconds (LangSwitch 10 15))
			)
			(3
				(cls)
				(PrintDC 114 1 #at 140 100 #dispose #width 150) ; "Il s'apelle Crispinophur...mais tout le monde l'apelle Crispin, c'est plus court. Le seul probl\8ame, c'est que, vous savez...,"
				(= seconds (LangSwitch 2 4))
			)
			(4
				(= local0 0)
				(intro_eyes hide:)
				(intro_mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(owl
					view: 758
					cycleSpeed: (if (== gHowFast 2) 2 else 1)
					posn: 189 86
					setPri: 10
					setLoop: 0
					setCycle: End self
				)
			)
			(5
				(cls)
				(gGlobalSound number: 808 loop: 1 playBed:)
				(= local0 0)
				(intro_eyes hide:)
				(intro_mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(PrintDC 114 2 #at 140 10 #dispose) ; "Quuuoi...!"
				(owl view: 758 cel: 1 setPri: 1 setLoop: 2 setCycle: End self)
			)
			(6
				(owl
					setLoop: 3
					setStep: 10 13
					setCycle: Fwd
					setMotion: MoveTo 203 200 self
				)
			)
			(7
				(egoHead setCel: 0)
				(owl setMotion: MoveTo 203 242 self)
			)
			(8
				(arms dispose:)
				(= cycles 1)
			)
			(9
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(gGlobalSound number: 809 playBed:)
				(leaves
					view: 758
					init:
					posn: 197 188
					setPri: 14
					setLoop: 4
					setCycle: End self
				)
			)
			(11
				(cls)
				(leaves dispose:)
				(= seconds 2)
			)
			(12
				(gGlobalSound number: 807 playBed:)
				(owl
					view: 759
					setLoop: 0
					setPri: 0
					setCycle: Fwd
					setStep: 3 2
					cycleSpeed: 2
					setMotion: MoveTo 189 150 self
				)
			)
			(13
				(egoHead setCel: 3)
				(owl setMotion: MoveTo 189 100 self)
			)
			(14
				(egoHead setCel: 2)
				(owl setMotion: MoveTo 189 86 self)
			)
			(15
				(owl setCycle: End self)
			)
			(16
				(owl setLoop: 1 setPri: 10 setCel: 0 setCycle: End self)
			)
			(17
				(intro_eyes
					view: 757
					show:
					setLoop: 2
					setScript: blinkScript
					posn: (+ (owl x:) 2) (- (owl y:) 34)
				)
				(intro_mouth
					view: 757
					setLoop: 3
					posn: (+ (owl x:) 3) (- (owl y:) 30)
				)
				(rWing
					view: 757
					setLoop: 4
					posn: (- (owl x:) 5) (- (owl y:) 28)
					signal: 16384
				)
				(lWing
					view: 757
					setLoop: 5
					posn: (+ (owl x:) 7) (- (owl y:) 26)
					signal: 16384
				)
				(owl view: 757 setLoop: 1)
				(= cycles 1)
			)
			(18
				(= local0 1)
				(lWingScript cue:)
				(rWingScript cue:)
				(intro_mouth show: setCycle: Fwd cycleSpeed: 2)
				(PrintDC 114 3 #at 140 100 #dispose #width 150) ; "Hum! De toute mani\8are...O\97 en \82tais-je? Ah oui."
				(= seconds (LangSwitch 4 6))
			)
			(19
				(cls)
				(PrintDC 114 4 #at 140 100 #dispose #width 150) ; "Le seul probl\8ame est que Crispin est avanc\82 en \83ge et sa m\82moire n'est plus cequ'elle \82tait."
				(= seconds (LangSwitch 6 9))
			)
			(20
				(intro_mouth setCycle: End self)
			)
			(21
				(cls)
				(gEgo setCycle: Fwd)
				(PrintDC 114 5 #at 10 10 #dispose) ; "Je ne sais pas si \87a pourrait marcher."
				(= seconds (LangSwitch 6 9))
			)
			(22
				(gEgo setCycle: End self)
			)
			(23
				(cls)
				(lWingScript cue:)
				(rWingScript cue:)
				(intro_mouth setCycle: Fwd cycleSpeed: 2)
				(PrintDC 114 6 #at 140 100 #dispose #width 150) ; "Oh, sans aucun doute. Crispin est un magicien tr\8as capable. Il devient juste un peu oublieux, de temps \85 autre, c'est tout."
				(= seconds (LangSwitch 10 15))
			)
			(24
				(intro_mouth setCycle: End self)
			)
			(25
				(= cycles 1)
			)
			(26
				(PrintDC 114 7 #at 140 100 #dispose #width 150) ; "Bon, o\97 est-ce que je l'ai mis? Je suis s\96r que je l'ai pris avec moi. Haha! Le voici!"
				(intro_eyes hide:)
				(= local0 0)
				(intro_mouth hide:)
				(rWing hide:)
				(lWing hide:)
				(owl view: 759 setLoop: 2 setCycle: End self)
			)
			(27
				(owl setLoop: 3 setCycle: End self)
			)
			(28
				(intro_mouth show: setCycle: Fwd)
				(= seconds 5)
			)
			(29
				(intro_mouth setCycle: End self)
			)
			(30
				(cls)
				(gEgo setCycle: Fwd)
				(PrintDC 114 8 #at 10 10 #dispose) ; "Qu'est-ce que c'est?"
				(= seconds (LangSwitch 3 5))
			)
			(31
				(gEgo setCycle: End self)
			)
			(32
				(owl view: 757 setLoop: 8)
				(rWing show:)
				(intro_eyes show: setScript: blinkScript)
				(= local0 1)
				(rWingScript cue:)
				(cls)
				(intro_mouth show: setCycle: Fwd cycleSpeed: 2)
				(PrintDC 114 9 #at 140 100 #dispose #width 150) ; "Bon! Je crois que vous n'avez pas une chance contre un sorcier du calibre de Mordack."
				(= seconds (LangSwitch 6 9))
			)
			(33
				(cls)
				(PrintDC 114 10 #at 140 100 #dispose #width 150) ; "Escusez mon audace, Votre Majest\82...mais vous n'avez pas le choix. Vous DEVEZ venir avec moi. Je suis certain que Crispin peut vous aider!"
				(= seconds (LangSwitch 7 11))
			)
			(34
				(intro_mouth setCycle: End self)
			)
			(35
				(intro_eyes dispose:)
				(= local0 0)
				(rWing dispose:)
				(intro_mouth hide:)
				(cls)
				(owl view: 785 setLoop: 4 setCycle: End self)
			)
			(36
				(owl setLoop: 5 setCycle: Fwd setMotion: MoveTo 110 58 self)
			)
			(37
				(owl setCycle: End self)
			)
			(38
				(egoHead setCel: 4)
				(owl setLoop: 6 setCycle: Fwd setScript: dustingEgo self)
			)
			(39
				(owl setLoop: 6 setCycle: End self)
			)
			(40
				(sack
					init:
					illegalBits: 0
					signal: 16384
					setStep: 5 5
					setPri: (- (egoHead priority:) 1)
					posn: 91 37
					setLoop: 9
					setMotion: MoveTo 59 201
				)
				(owl setLoop: 10 setCycle: End self)
			)
			(41
				(owl setLoop: 10 cel: 0 setCycle: Fwd)
				(intro_mouth
					view: 785
					posn: (- (owl x:) 15) (- (owl y:) 24)
					setLoop: 11
					cel: 0
					setPri: (+ (owl priority:) 1)
					cycleSpeed: 2
					setCycle: Fwd
				)
				(sack setPri: (- (egoHead priority:) 1))
				(= seconds 2)
			)
			(42
				(gEgo setCycle: Fwd)
				(PrintDC 114 11 #at 129 51 #dispose) ; "Qu'est-ce que c'est que \87a?"
				(= seconds (LangSwitch 2 3))
			)
			(43
				(gEgo setCycle: End self)
			)
			(44
				(cls)
				(intro_mouth show:)
				(= cycles 3)
			)
			(45
				(PrintDC 114 12 #at 140 10 #width 150 #dispose) ; "Oh, tout juste un reste de vieille poussi\8are de f\82e que j'ai gard\82 sur moi. Cela vous aidera \85 voler."
				(= seconds (LangSwitch 6 9))
			)
			(46
				(cls)
				(= global380 1)
				(PrintDC 114 13 #at 170 10 #dispose #width 100) ; "Vous pouvez me suivre au pays de Serenia, o\97 Crispin et moi-m\88me vivons. Vous savez, c'est VRAIMENT trop loin pour s'y rendre \85 pied. Je pense que la poussi\8are de f\82e est encore bonne."
				(= seconds (LangSwitch 13 20))
			)
			(47
				(egoHead setCel: 1)
				(intro_mouth dispose:)
				(owl setScript: leaveRoomScript)
				(= cycles 1)
			)
			(48
				(SetFlag 31)
				(gCurRoom newRoom: 100) ; intro
			)
		)
	)
)

(instance lWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(lWing cycleSpeed: 2 setLoop: 5 setCycle: End)
				(= seconds 4)
			)
			(2
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(3)
			(4
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(5
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(6)
			(7
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(8
				(lWing setLoop: 6 setCycle: End)
				(= seconds 4)
			)
			(9
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance rWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(rWing cycleSpeed: 2 setCycle: End)
				(= seconds 2)
			)
			(2
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(3
				(= local0 0)
				(rWing setLoop: 7 setCycle: End)
				(= seconds 2)
			)
			(4
				(= local0 1)
				(rWing setLoop: 4 setCel: 0)
				(= cycles 1)
			)
			(5)
			(6
				(rWing setCycle: End)
				(= seconds 2)
			)
			(7
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(8)
			(9
				(rWing setCycle: End)
				(= seconds 4)
			)
			(10
				(rWing setCycle: Beg)
				(= seconds 2)
			)
			(11)
			(12
				(= local0 0)
				(rWing setLoop: 7 setCycle: End self)
			)
			(13
				(= local0 1)
				(rWing setLoop: 4 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(14
				(rWing setCycle: Beg)
				(= seconds 4)
			)
			(15
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local0 0)
			(if (> (intro_eyes cel:) 0)
				(intro_eyes setCycle: Beg self)
			else
				(= cycles 1)
			)
			(= state 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(intro_eyes setCycle: End self)
			)
			(2
				(intro_eyes setCycle: Beg self)
				(= state -1)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance dustingEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (client cel:) 0)
					(if local4
						(= local4 0)
					else
						(++ local4)
					)
					(dust
						init:
						setPri:
							(if local4
								(- (egoHead priority:) 1)
							else
								(+ (egoHead priority:) 1)
							)
						setLoop: 7
						posn: 81 75
						setCycle: End self
					)
				else
					(= state -1)
					(= cycles 1)
				)
			)
			(1
				(if (not (== (gGlobalSound3 number:) 811))
					(gGlobalSound3 number: 811 play:)
				)
				(dust hide: dispose:)
				(if (== local1 3)
					(gGlobalSound3 stop:)
					(self dispose:)
				else
					(++ local1)
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance owl of Actor
	(properties
		x 189
		y 86
		view 757
	)
)

(instance leaves of Prop
	(properties
		x 203
		y 188
		view 757
	)
)

(instance intro_eyes of Prop
	(properties
		view 757
	)
)

(instance intro_mouth of Prop
	(properties
		view 757
	)
)

(instance rWing of Prop
	(properties
		view 757
	)
)

(instance lWing of Prop
	(properties
		view 757
	)
)

(instance arms of Actor
	(properties
		view 757
	)
)

(instance dust of Actor
	(properties
		view 785
	)
)

(instance sack of Actor
	(properties
		view 785
	)
)

(instance egoHead of Prop
	(properties
		x 81
		y 118
		view 763
		cel 2
		priority 10
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (setCel)
		(super setCel: &rest)
		(self stopUpd:)
		(switch (self cel:)
			(0
				(gEgo hide:)
				(self posn: 101 105)
			)
			(1
				(gEgo hide:)
				(self posn: 103 108)
			)
			(2
				(gEgo show:)
				(self posn: 81 118)
			)
			(3
				(gEgo hide:)
				(self posn: 99 112)
			)
			(4
				(gEgo hide:)
				(self posn: 97 109)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setMotion: MoveTo 22 -20 self)
			)
			(1
				(owl hide:)
				(client setScript: 0)
			)
		)
	)
)

