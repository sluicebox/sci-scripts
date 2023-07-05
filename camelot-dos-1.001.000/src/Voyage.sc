;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	Voyage 0
)

(local
	local0
	local1
	local2 = 4
)

(procedure (localproc_0 param1)
	((gTObj tWindow:) brLeft: 10 brRight: 310)
	(gTObj noTimer: 1 noDispose: 1)
	(if param1
		((gTObj tWindow:) brTop: -20 brBottom: 130)
	else
		((gTObj tWindow:) brTop: 130 brBottom: 195)
	)
	(Talk &rest)
)

(instance ship of Act
	(properties)

	(method (doit)
		(super doit:)
		(if (> (GetDistance x y local0 local1) 6)
			(= local0 x)
			(= local1 y)
			(DrawCel
				951
				8
				(cond
					((or (< 22 heading 68) (< 205 heading 248)) 3)
					((or (< 67 heading 113) (< 247 heading 293)) 0)
					((or (< 112 heading 158) (< 292 heading 338)) 2)
					(else 1)
				)
				(- x 2)
				(- y 2)
				1
			)
		)
	)
)

(instance voyageResult of Prop
	(properties
		view 952
	)

	(method (init)
		(super init:)
		(switch (gCurRoom script:)
			(gazaVoyage
				(self loop: local2 posn: 240 143)
				(++ local2)
			)
			(athensVoyage
				(self loop: 0 posn: 159 114)
			)
			(rennesVoyage
				(self loop: 1 posn: 120 92)
			)
			(romeVoyage
				(self loop: 2 posn: 182 120)
			)
			(dublinVoyage
				(self loop: 3 posn: 123 62)
			)
		)
	)
)

(instance shipWindow of SysWindow
	(properties
		color 15
		back 8
	)
)

(instance skull of View
	(properties
		view 951
		loop 7
		priority 15
	)
)

(instance Voyage of Rm
	(properties
		picture 34
		style 17
	)

	(method (init)
		(Load rsVIEW 952)
		(Load rsSOUND 98)
		(Load rsSOUND 97)
		(Load rsSOUND 99)
		(Load rsSOUND 100)
		(super init:)
		(MenuBar state: 0)
		(proc0_13 64)
		(gAddToPics doit:)
		(gEgo posn: -100 100 init:)
		(User canControl: 0)
		(gTObj tWindow: shipWindow)
		(ship
			view: 951
			setLoop: 1
			cel: 0
			setStep: 1 1
			posn: 87 43
			cycleSpeed: 2
			setCycle: Fwd
			init:
		)
		(if (!= gPrevRoomNum 33)
			(= global128
				(Print ; "Enter destination:"
					34
					0
					150
					{Gaza}
					0
					150
					{Athens}
					1
					150
					{Rennes}
					2
					150
					{Rome}
					3
					150
					{Dublin}
					4
				)
			)
		)
		(= global109 6)
		(if (gEgo has: 2) ; lodestone
			(SetFlag 72)
		)
		(gRmMusic number: 97 loop: -1)
		(gCurRoom
			setScript:
				(switch global128
					(0 gazaVoyage)
					(1 athensVoyage)
					(2 rennesVoyage)
					(3 romeVoyage)
					(4 dublinVoyage)
				)
		)
		(HandsOff)
	)

	(method (doit)
		(super doit:)
		(cond
			((> (ship loop:) 5) 0)
			((>= 250 (ship heading:) 205)
				(ship setLoop: 5)
			)
			((>= 105 (ship heading:) 160)
				(ship setLoop: 4)
			)
			((>= 315 (ship heading:) 225)
				(ship setLoop: 1)
			)
			((>= 135 (ship heading:) 45)
				(ship setLoop: 0)
			)
			((>= 225 (ship heading:) 135)
				(ship setLoop: 2)
			)
			(else
				(ship setLoop: 3)
			)
		)
	)
)

(instance gazaVoyage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRmMusic play:)
				(ship setMotion: MoveTo 72 43 self)
				(if (not (IsFlag 65))
					(SetScore 0 2 -50)
				)
			)
			(1
				(ship setMotion: MoveTo 67 44 self)
			)
			(2
				(ship setMotion: MoveTo 53 53 self)
			)
			(3
				(ship setMotion: MoveTo 24 75 self)
			)
			(4
				(ship setMotion: MoveTo 16 110 self)
			)
			(5
				(localproc_0 0 34 1) ; "Weary days and nights march on. A storm catches the ship and you are forced to lend your strong back to the efforts of the crew to save themselves."
				(if (gEgo has: 6) ; iron_key | broom | grail
					(PutItem 6) ; iron_key | broom | grail
				)
				(PutItem 4) ; rose | apple | green_apple
				(ship setMotion: MoveTo 26 118 self)
			)
			(6
				(ship setMotion: MoveTo 43 122 self)
			)
			(7
				(DrawCel 951 8 4 (- (ship x:) 3) (- (ship y:) 13) 1)
				(= seconds 2)
			)
			(8
				(ship setMotion: MoveTo 92 122 self)
			)
			(9
				(localproc_0 1 34 2) ; "Huge waves crash across the decks. You barely save your mule, but your pack and nearly all your belongings are washed away."
				(ship setMotion: MoveTo 96 124 self)
			)
			(10
				(ship setMotion: MoveTo 128 128 self)
			)
			(11
				(DrawCel 951 8 4 (- (ship x:) 5) (+ (ship y:) 1) 1)
				(= seconds 2)
			)
			(12
				(ship setMotion: MoveTo 157 146 self)
			)
			(13
				(voyageResult init:)
				(localproc_0 1 34 3) ; "The next day, the Captain thanks you by giving good advice, "You are not a king in these lands, so do not be quick to draw your sword for you will be surrounded by enemies. Be careful who you trust and never pay bribes with too much coin.""
				(ship setMotion: MoveTo 170 148 self)
			)
			(14
				(ship setMotion: MoveTo 187 150 self)
			)
			(15
				(ship setMotion: MoveTo 210 155 self)
			)
			(16
				(ship setMotion: MoveTo 249 162 self)
			)
			(17
				(DrawCel 951 8 4 (+ (ship x:) 2) (+ (ship y:) 1) 1)
				(= seconds 2)
			)
			(18
				(ship setMotion: MoveTo 270 152 self)
			)
			(19
				(voyageResult init:)
				(DrawCel 951 8 4 (+ (ship x:) 6) (- (ship y:) 4) 4)
				(RedrawCast)
				(localproc_0 1 34 4) ; "You join the crew in sharing several rounds of wine as they wait for the tide to change so they may enter Gaza port."
				(= seconds 7)
			)
			(20
				(voyageResult init:)
				(RedrawCast)
				(localproc_0 1 34 5) ; "The wine flows freely after such a long and arduous journey. Soon, you fall into a very deep, dreamless sleep."
				(= seconds 7)
			)
			(21
				(gTObj endTalk:)
				(voyageResult dispose:)
				(RedrawCast)
				(gRmMusic fade:)
				(= seconds 2)
			)
			(22
				(gCurRoom newRoom: 35)
			)
		)
	)
)

(instance athensVoyage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRmMusic play:)
				(ship setMotion: MoveTo 62 45 self)
			)
			(1
				(ship setMotion: MoveTo 57 50 self)
			)
			(2
				(localproc_0 0 34 6) ; "The skilled Captain beats past Celtic Brittany with all speed thanks to good winds."
				(ship setMotion: MoveTo 30 67 self)
			)
			(3
				(ship setMotion: MoveTo 15 104 self)
			)
			(4
				(ship setMotion: MoveTo 19 117 self)
			)
			(5
				(ship setMotion: MoveTo 42 122 self)
			)
			(6
				(localproc_0 1 34 7) ; "At Malaga you get your first sight of those who worship Islam. Their manners and dress are strange to you, yet they are hospitable to any man who worships the one god, no matter by what name he is called."
				(DrawCel 951 8 4 (- (ship x:) 2) (- (ship y:) 13) 1)
				(= seconds 2)
			)
			(7
				(ship setMotion: MoveTo 128 127 self)
			)
			(8
				(DrawCel 951 8 4 (- (ship x:) 5) (+ (ship y:) 2) 1)
				(= seconds 2)
			)
			(9
				(ship setMotion: MoveTo 130 129 self)
			)
			(10
				(localproc_0 1 34 8) ; "In Tunis the worshippers of Allah seem much the same but are ruled instead by the Aghlabid Emirate under the Abbasid Empire."
				(ship setMotion: MoveTo 151 140 self)
			)
			(11
				(ship setMotion: MoveTo 202 142 self)
			)
			(12
				(ship setMotion: MoveTo 209 135 self)
			)
			(13
				(ship setMotion: MoveTo 211 126 self)
			)
			(14
				(gRmMusic number: 100 loop: 1 play:)
				(voyageResult init:)
				(localproc_0 0 34 9) ; "As you approach Athens, a corsair filled with Saracen pirates overtakes your ship."
				(= seconds 7)
			)
			(15
				(localproc_0 0 34 10) ; "You fight like the great warrior you are, but the Saracens are many and merciless. You are finally cut down and thrown to the fish."
				(= seconds 8)
			)
			(16
				(gTObj endTalk:)
				(voyageResult dispose:)
				(skull posn: (ship x:) (ship y:) setPri: 15 init:)
				(= seconds 4)
			)
			(17
				(EgoDead)
			)
		)
	)
)

(instance rennesVoyage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRmMusic number: 98 loop: 1 play:)
				(ship setMotion: MoveTo 80 43 self)
			)
			(1
				(ship setMotion: MoveTo 72 48 self)
			)
			(2
				(voyageResult init:)
				(localproc_0 0 34 11) ; "A quick voyage brings you to the northern coast of Brittany where you are tragically dashed to death upon jagged rocks."
				(ship setLoop: 6 cel: 0 cycleSpeed: 4 setCycle: End)
				(= seconds 11)
			)
			(3
				(gTObj endTalk:)
				(voyageResult dispose:)
				(skull posn: (ship x:) (ship y:) setPri: 15 init:)
				(= seconds 4)
			)
			(4
				(EgoDead)
			)
		)
	)
)

(instance romeVoyage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRmMusic play:)
				(ship setMotion: MoveTo 61 45 self)
			)
			(1
				(ship setMotion: MoveTo 55 51 self)
			)
			(2
				(ship setMotion: MoveTo 29 71 self)
			)
			(3
				(ship setMotion: MoveTo 17 92 self)
			)
			(4
				(localproc_0 0 34 12) ; "Many days and nights pass in cramped discomfort. The coastline of Muslim-held Iberia glides past."
				(ship setMotion: MoveTo 18 118 self)
			)
			(5
				(ship setMotion: MoveTo 42 122 self)
			)
			(6
				(ship setMotion: MoveTo 128 125 self)
			)
			(7
				(DrawCel 951 8 4 (- (ship x:) 5) (+ (ship y:) 4) 1)
				(localproc_0 1 34 13) ; "You land briefly in Tunis, ruled by the Muslims of the Aghlabid Emirate under the Abbasid Empire. Soon you will reach Rome."
				(= seconds 4)
			)
			(8
				(ship setMotion: MoveTo 136 116 self)
			)
			(9
				(gRmMusic number: 100 loop: 1 play:)
				(ship setLoop: 6 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(10
				(voyageResult init:)
				(localproc_0 0 34 14) ; "Approaching Rome, your ship is caught in a powerful storm. You are washed overboard and your armour quickly drags you to the bottom of the sea."
				(= seconds 11)
			)
			(11
				(gTObj endTalk:)
				(voyageResult dispose:)
				(skull posn: (ship x:) (ship y:) setPri: 15 init:)
				(= seconds 4)
			)
			(12
				(EgoDead)
			)
		)
	)
)

(instance dublinVoyage of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (== (gRmMusic prevSignal:) 10))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship setMotion: MoveTo 62 41 self)
				(gRmMusic number: 99 loop: 1 play:)
			)
			(1
				(localproc_0 0 34 15) ; "Captain beats his way expertly up St. George's Channel toward Dublin."
				(ship setMotion: MoveTo 65 32 self)
			)
			(2
				(ship setMotion: MoveTo 75 21)
			)
			(3
				(voyageResult init:)
				(localproc_0 0 34 16) ; "Alas, a longship of crazed Vikings falls upon the ship. Excaliber sings from its sheath and does mighty work. The decks run red, but you are overwhelmed and killed in combat with a berserker."
				(= seconds 15)
			)
			(4
				(gTObj endTalk:)
				(voyageResult dispose:)
				(skull posn: (ship x:) (ship y:) setPri: 15 init:)
				(= seconds 4)
			)
			(5
				(EgoDead)
			)
		)
	)
)

