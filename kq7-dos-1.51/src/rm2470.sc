;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2470)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm2470 0
)

(instance rm2470 of KQRoom
	(properties
		picture 2470
	)

	(method (init)
		(super init:)
		(gGame handsOff:)
		((ScriptID 7001 0) client: king clientCel: -1) ; kingTalker
		(Load rsSOUND 2450)
		(gKqMusic1 number: 2450 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(Load rsPIC 2475)
		(Load rsVIEW 2471)
		(Load rsVIEW 24710)
		(Load rsVIEW 2472)
		(Load rsVIEW 24725)
		(Load rsSOUND 2451)
		(Load rsSOUND 942)
		(Load rsSOUND 2452)
		(Load rsSOUND 24520)
		(self setScript: pullThruMirror)
	)
)

(instance pullThruMirror of Script
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
					(gGame handsOff: 1)
					(gEgo
						view: 2471
						cel: 0
						setLoop: 0
						posn: 155 141
						init:
						setPri: 120
						cycleSpeed: 12
						setCycle: CT 17 1 self
					)
				)
				(1
					(gKqSound1 number: 2451 setLoop: 1 play:)
					(gEgo setCycle: End self)
				)
				(2
					(gEgo
						view: 24710
						posn: 180 131
						setLoop: 0
						setCel: 0
						setCycle: CT 1 1 self
					)
					(king
						view: 24710
						setLoop: 1 1
						posn: 217 122
						setCel: 0
						init:
						moveSpeed: 0
						setMotion: MoveTo 236 118
						setCycle: End self
					)
				)
				(3
					(gKqSound1 number: 942 setLoop: 1 play:)
					(gEgo setCycle: End)
				)
				(4
					(gEgo
						posn: 171 141
						setLoop: 3
						setCel: 0
						setPri: -1
						setCycle: End self
					)
					(king posn: 264 117 setLoop: 2 setCel: 0 setCycle: Fwd)
				)
				(5
					(gEgo
						posn: 171 140
						setLoop: 4
						cel: 0
						setCycle: ForwardCounter 2 self
					)
				)
				(6
					(gEgo setCycle: ForwardCounter 2)
					(king
						view: 2472
						posn: 264 117
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
				(7
					(gMessager say: 0 0 1 1 self 2450) ; "(BEAMING, DELIGHTED)Welcome, most beautiful of princesses!"
				)
				(8
					(gEgo
						posn: 171 126
						view: 2472
						setLoop: 1
						setCel: 0
						setCycle: End
					)
					(king
						view: 24725
						setLoop: 3
						cel: 0
						posn: 244 127
						setCycle: CT 3 1 self
					)
				)
				(9
					(gKqSound1 number: 24520 setLoop: 1 play:)
					(king setCycle: End self)
				)
				(10
					(gMessager say: 0 0 1 2 self 2450) ; "(CONFUSED)Hmm?"
				)
				(11
					(gEgo
						setLoop: 2
						cel: 0
						setMotion: MoveTo 144 128
						setCycle: End self
					)
					(gKqSound1 number: 2452 setLoop: 1 play:)
					(king setLoop: 4 cel: 0 posn: 246 129 setCycle: End self)
				)
				(12 0)
				(13
					(gMessager sayRange: 0 0 1 3 4 self 2450) ; "(STARTLED AND A LITTLE SCARED OF THE TROLL KING, BUT DETERMINED TO KEEP HER COOL AND STAY POLITE.)Who--who are you, sir?"
				)
				(14
					(king setCycle: Beg self)
				)
				(15
					(gMessager say: 0 0 1 5 self 2450) ; "(CONFUSED BUT EXCITED)I am, your majesty. How do you know me? Where am I? I saw a beautiful castle before--where could I find it, please?"
				)
				(16
					(king setCycle: End self)
				)
				(17
					(gMessager say: 0 0 1 6 self 2450) ; "Castle? Oh, that. It's a dull place. You wouldn't like it."
				)
				(18
					(gCurRoom newRoom: 2475)
				)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 226
		y 124
	)
)

