;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2475)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm2475 0
)

(instance rm2475 of KQRoom
	(properties
		picture 2475
	)

	(method (init)
		(super init:)
		(gEgo init:)
		((ScriptID 7001 0) client: king clientCel: -1) ; kingTalker
		(self setScript: talkToKing)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(super dispose:)
	)
)

(instance talkToKing of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gGame handsOn:)
					(gCurRoom newRoom: 2100)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(gGame handsOff: 1)
					(Load rsSOUND 2453)
					(Load rsSOUND 2454)
					(Load rsSOUND 2455)
					(Load rsSOUND 24530)
					(Load rsSOUND 2456)
					(Load rsVIEW 2476)
					(Load rsVIEW 2477)
					(Load rsVIEW 24765)
					(Load rsVIEW 2478)
					(Load rsVIEW 24785)
					(gEgo
						view: 2476
						setLoop: 1
						setCel: 0
						posn: 141 127
						setCycle: 0
					)
					(king view: 2476 setLoop: 0 setCel: 0 posn: 185 124 init:)
					(= ticks 30)
				)
				(1
					(king setCycle: End self)
				)
				(2
					(gMessager sayRange: 0 0 1 7 8 self 2450) ; "(STAGE WHISPER)Oh my. I wasn't expecting THIS."
				)
				(3
					(gEgo setCycle: End self)
				)
				(4
					(gEgo view: 24765 setLoop: 3 setCel: 0 setCycle: End)
					(king
						posn: 175 135
						view: 2476
						setLoop: 2
						setCel: 0
						setCycle: End self
					)
				)
				(5
					(gMessager say: 0 0 1 9 self 2450) ; "(GRINNING WIDELY, TRYING TO MAKE A QUICK RECOVERY BUT DOING BADLY.)I...wasn't expecting you to be so lovely, my lady. You will be the most radient bride in all the world!"
				)
				(6
					(gKqSound1 number: 2453 setLoop: 1 play:)
					(gEgo
						view: 2477
						setLoop: 0
						setCel: 0
						setCycle: CT 2 1 self
					)
				)
				(7
					(gKqSound1 number: 2454 setLoop: 1 play:)
					(gEgo setCel: 3 setCycle: End self)
				)
				(8
					(gEgo setLoop: 3 setCel: 0 setCycle: End)
					(gMessager say: 0 0 1 10 self 2450) ; "(SHOCKED AND HORRIFIED)BRIDE?!"
					(king view: 2477 setLoop: 1 setCel: 0 setCycle: End self)
				)
				(9 0)
				(10
					(king posn: 200 125 setLoop: 2 setCel: 0 setCycle: End self)
					(gMessager say: 0 0 1 11 self 2450) ; "(TICKED OFF AND A LITTLE SCARED)See here, King Otar, I'm very honored and all, but I can't marry you. I don't even know you. Now if you'll excuse me--"
				)
				(11 0)
				(12
					(gEgo
						posn: 156 143
						view: 2478
						setLoop: 0
						setCel: 0
						setCycle: CT 9 1 self
					)
				)
				(13
					(gEgo setCycle: End self)
					(gKqSound1 number: 24530 setLoop: 1 play:)
				)
				(14
					(gEgo setLoop: 1 setCel: 0 setCycle: End self)
					(king setCycle: Beg)
				)
				(15
					(gMessager say: 0 0 1 12 self 2450) ; "AAAAAAAAAAH!"
					(king posn: 174 138 setLoop: 1 cel: 0 setCycle: End self)
				)
				(16 0)
				(17
					(gKqSound1 number: 2455 setLoop: 1 play:)
					(king setCycle: Beg)
					(Load rsVIEW 2479)
					(gEgo
						posn: 135 130
						setLoop: 2
						setCel: 0
						setCycle: End self
					)
				)
				(18
					(gMessager say: 0 0 1 13 self 2450) ; "(IN SHOCK)I'm a--I'm a--I'm a--"
				)
				(19
					((ScriptID 7001 0) clientCel: 0) ; kingTalker
					(king cel: 0)
					(gMessager say: 0 0 1 14 self 2450) ; "(TRYING TO PLACATE HER)A troll, dear lady."
				)
				(20
					((ScriptID 7001 0) clientCel: -1) ; kingTalker
					(gEgo setLoop: 3 setCel: 0 setCycle: End self)
					(gMessager say: 0 0 1 15 self 2450) ; "A troll?! EEEEEEEE!"
				)
				(21 0)
				(22
					(gEgo setCel: 0)
					(king
						posn: 175 133
						view: 24785
						setLoop: 4
						setCel: 0
						setCycle: End self
					)
					(gMessager say: 0 0 1 16 self 2450) ; "(HELPLESSLY)Oh, please, don't be sad, Princess. You make a lovely troll. A--a simply stunning troll!"
				)
				(23 0)
				(24
					(gEgo
						view: 24785
						setLoop: 6
						setCel: 0
						setCycle: End self
					)
					(king setLoop: 5 cel: 0 setCycle: End)
				)
				(25
					(gMessager say: 0 0 1 17 self 2450) ; "(IN SHOCK, MUTTERING TO HERSELF)I'm a troll! How can I be a troll? I'm not a troll, am I?"
				)
				(26
					(king dispose:)
					(gEgo
						posn: 152 128
						setLoop: 7
						setCel: 0
						setPri: 140
						setCycle: CT 1 1 self
					)
				)
				(27
					(gMessager sayRange: 0 0 1 18 19 self 2450) ; "(GENTLY)Come along, Princess. Let me escort you to your chamber. Perhaps you'll feel better if you rest..."
				)
				(28
					(gEgo setCycle: End self)
				)
				(29
					(gKqMusic1 number: 2456 setLoop: 1 play:)
					(gEgo
						view: 2479
						setLoop: 0
						cel: 0
						posn: 146 71
						setCycle: End self
					)
				)
				(30
					(gCurRoom newRoom: 2510)
				)
			)
		)
	)
)

(instance king of Actor
	(properties)
)

