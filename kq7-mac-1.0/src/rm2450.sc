;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2450)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm2450 0
	spikeTalker 1
)

(instance rm2450 of KQRoom
	(properties
		picture 2450
	)

	(method (init &tmp temp0)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 201 82 260 82 273 98 239 112 145 111 116 108 121 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 320 136 0 136 0 105 33 112 108 117 136 129 285 129 320 124
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 112 88 58 87 58 101 0 102 0 0 320 0 320 61 276 79 215 75 186 80 120 80 120 77 80 72
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 520 113 320 113 306 120 248 120 248 112 300 102 311 71 320 65 520 65
					yourself:
				)
		)
		((ScriptID 7001 1) client: malicia hide_mouth: 0) ; maliciaTalker
		((ScriptID 7001 2) client: mathilde hide_mouth: 0) ; mathildeTalker
		((ScriptID 7001 0) client: king hide_mouth: 0) ; kingTalker
		(Load rsMESSAGE 2450)
		(Load rsSOUND 2450)
		(= temp0 (if (IsFlag 50) 2450 else 2460))
		(gEgo init: normalize: posn: 140 114 setSpeed: 3)
		(chair init: ignoreActors:)
		(table init: ignoreActors:)
		(if (not (IsFlag 61))
			(shield init:)
		)
		(exKitchen init:)
		(exChamber init:)
		(exBridge init:)
		(exForge init:)
		(vent init:)
		(exJacuzzi init:)
		(if (not (IsFlag 55))
			(throne init:)
			(gEgo setScaler: Scaler 36 36 109 78)
		else
			(gEgo setScaler: Scaler 48 46 110 79)
		)
		(if (not (IsFlag 88))
			(toad init:)
		)
		(if (and (IsFlag 50) (not (gEgo has: 23)) (not (IsFlag 90))) ; Toy_Rat
			(rat init:)
		)
		(cond
			((IsFlag 357)
				(mathilde init:)
				(mathilde
					view: 24504
					setLoop: 1
					cel: 10
					posn: 227 106
					z: 10
					setCycle: 0
					setMotion: 0
				)
				((ScriptID 7001 2) hide_mouth: 0 mouth_y: -10) ; mathildeTalker
			)
			(
				(and
					(not (and (IsFlag 55) (not (IsFlag 357))))
					(!= gPrevRoomNum 2475)
				)
				(mathilde init: setCycle: Fwd)
			)
		)
		(switch gPrevRoomNum
			(2100
				(gEgo posn: 92 74 loop: 2)
			)
			(2050
				(gEgo posn: 21 106 loop: 0)
			)
			(2550
				(gEgo posn: 312 122 loop: 1)
			)
			(2500
				(gEgo posn: 307 68 loop: 1)
			)
			(2455
				(gEgo posn: 210 114 loop: 6)
			)
			(2460
				(gEgo posn: 63 87 loop: 4)
				(self setScript: fromJacuzzi)
			)
		)
		(cond
			((== gPrevRoomNum 2455)
				(cond
					((and (IsFlag 55) (not (IsFlag 89)))
						(self setScript: postTransform)
					)
					((IsFlag 56)
						(self setScript: verminToon)
					)
					(else
						(gGame handsOn:)
					)
				)
				(if (and (not (IsFlag 355)) (IsFlag 352))
					(females init:)
				else
					(males init:)
				)
			)
			((== gPrevRoomNum 2300)
				(self setScript: fallFromTunnel)
				(males init:)
			)
			((not (IsFlag 50))
				(SetFlag 50)
				(self setScript: meetMathilde)
				(males init:)
			)
			((not (IsFlag 352))
				(males init:)
				(SetFlag 86)
				(self setScript: malToon)
			)
			((and (not (IsFlag 355)) (IsFlag 352))
				(if (!= gPrevRoomNum 2460)
					(SetFlag 87)
					(females init:)
				else
					(males init:)
				)
				(gGame handsOn:)
			)
			((IsFlag 55)
				(males init:)
				(gGame handsOn:)
			)
			(else
				(females init:)
				(gGame handsOn:)
			)
		)
		(gKqMusic1 number: temp0 setLoop: -1 play:)
	)

	(method (newRoom newRoomNumber)
		(gKqMusic1 fade: 0 10 10 1)
		(super newRoom: newRoomNumber)
	)
)

(instance pickUpToad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8421)
				(gEgo setHeading: 270 self)
			)
			(1
				(gMessager say: 7 8 0 1 self) ; "(LAUGHS, THEN THINKS TO HERSELF)What is this little thing?"
			)
			(2
				(gEgo setPri: 87 setMotion: MoveTo 147 75 self)
			)
			(3
				(gEgo
					view: 8421
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: CT 7 1 self
				)
			)
			(4
				(gEgo setCycle: End self)
				(toad dispose:)
			)
			(5
				(gEgo
					get: 31 ; Dragon_Toad
					normalize: 1
					setPri: 87
					setMotion: MoveTo 150 90 self
				)
			)
			(6
				(gEgo setPri: -1)
				(SetFlag 88)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goShowToad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 228 112 self)
			)
			(1
				(gEgo
					setPri: 110
					ignoreActors:
					setMotion: MoveTo 227 107 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 212 107 self)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(gCurRoom newRoom: 2455)
			)
		)
	)
)

(instance fromJacuzzi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo init:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 82 90 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getShield of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 61)
				(gEgo view: 8773 setLoop: 0 cel: 0 setCycle: CT 10 1 self)
			)
			(1
				(shield dispose:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo get: 29 normalize: 3 setSpeed: 3 setHeading: 180 self) ; Shield
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickUpRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rat setPri: 80)
				(gEgo view: 8754 setLoop: 0 setCel: 0 setCycle: CT 8 1 self)
			)
			(1
				(gEgo setCycle: End self)
				(gEgo get: 23) ; Toy_Rat
				(rat dispose:)
			)
			(2
				(gEgo normalize: 4 setSpeed: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roseClimbAndJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 80 setMotion: MoveTo 150 64 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					setScale: 0
					view: 24501
					setLoop: 0
					setCel: 0
					posn: 146 72
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gKqSound1 number: 2458 setLoop: 1 play:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo
					normalize: 2
					setSpeed: 3
					setScaler: Scaler 48 46 110 79
					posn: 149 70
					setPri: 80
					cycleSpeed: register
					setMotion: MoveTo 149 78 self
				)
			)
			(6
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance trollClimbAndJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 80 setMotion: MoveTo 150 64 self)
			)
			(1
				(if (IsFlag 384)
					(= cycles 2)
				else
					(gMessager say: 10 8 12 1 self) ; "Hmmm...There's a hole up there. I wonder where it leads?"
					(SetFlag 384)
					(vent dispose:)
				)
			)
			(2
				(= register (gEgo cycleSpeed:))
				(gEgo
					setScale: 0
					view: 24501
					cel: 0
					setLoop: 3
					posn: 147 64
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 setLoop: 4 posn: 144 53 setCycle: End self)
			)
			(4
				(gKqSound1 number: 2458 setLoop: 1 play:)
				(gEgo cel: 0 setLoop: 5 posn: 148 67 setCycle: End self)
			)
			(5
				(= ticks 20)
			)
			(6
				(gEgo
					normalize: 2
					setSpeed: 3
					setScaler: Scaler 36 36 109 78
					posn: 150 64
					setPri: 80
					cycleSpeed: register
					setMotion: MoveTo 156 78 self
				)
			)
			(7
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToBridge of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 335 122 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2550)
			)
		)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 92 72 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2100)
			)
		)
	)
)

(instance goToKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 334 68 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2500)
			)
		)
	)
)

(instance goToForge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 106 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 2050)
			)
		)
	)
)

(instance fallFromTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 92)
				(Load 140 31561) ; WAVE
				(Load 140 2478) ; WAVE
				(Load 140 2479) ; WAVE
				(Load rsSOUND 817)
				(Load 140 2480) ; WAVE
				(gEgo
					setScale: 0
					view: 24502
					setLoop: 0
					cel: 0
					posn: 157 120
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 cel: 0 posn: 158 118 setCycle: End self)
				(gKqSound1 number: 2478 setLoop: 1 play:)
			)
			(2
				(gEgo setLoop: 3 cel: 0 posn: 155 130 setCycle: End self)
				(gKqSound1 number: 2479 setLoop: 1 play:)
			)
			(3
				(toad
					view: 24502
					setLoop: 2
					posn: 149 140
					approachVerbs: 8 ; Do
					setHotspot: 8 10 ; Do, Exit
					approachX: 152
					approachY: 78
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 10 1 self
				)
				(gKqSound1 number: 817 setLoop: 1 play:)
			)
			(4
				(gKqSound1 number: 31561 setLoop: 1 play:)
				(toad setCycle: End self)
			)
			(5
				(gKqSound1 number: 2480 setLoop: 1 play: self)
				(toad setPri: 79 view: 24507 setLoop: 2 posn: 140 73 setCel: 1)
			)
			(6
				(gEgo
					normalize: 2
					setSpeed: 3
					setScaler: Scaler 48 46 110 79
					posn: 154 66
					setPri: 80
					setMotion: MoveTo 155 83 self
				)
			)
			(7
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitOnThrone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 2473)
				(= register (gEgo cycleSpeed:))
				(gEgo setPri: 82 setMotion: MoveTo 156 70 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gKqMusic1 stop:)
				(gEgo
					setScale: 0
					view: 2454
					setLoop: 0
					cel: 0
					posn: 152 68
					cycleSpeed: 14
					setCycle: Fwd
				)
				(gKqSound1 number: 2473 setLoop: 1 play: self)
			)
			(3
				(gEgo
					normalize: 2
					setPri: 82
					setSpeed: 3
					posn: 154 70
					heading: 180
					setScaler: Scaler 36 36 109 78
					cycleSpeed: register
					setMotion: MoveTo 156 82 self
				)
				(gKqSound1 stop:)
				(gKqMusic1 play:)
			)
			(4
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bounceOnThrone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 844) ; WAVE
				(= register (gEgo cycleSpeed:))
				(gEgo
					setPri: 82
					cycleSpeed: 12
					setMotion: MoveTo 156 70 self
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo setScale: 0 view: 2454 setLoop: 1 cel: 0 posn: 153 67)
				(= register 0)
				(= ticks 20)
			)
			(3
				(gEgo cel: 0 setCycle: End self)
				(gKqSound1 number: 844 setLoop: 1 play:)
				(if (< (++ register) 6)
					(-- state)
				)
			)
			(4
				(gEgo
					normalize: 2
					setPri: 82
					setSpeed: 3
					posn: 154 70
					heading: 180
					setScaler: Scaler 36 36 109 78
					cycleSpeed: register
					setMotion: MoveTo 156 82 self
				)
			)
			(5
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance meetMathilde of Script
	(properties)

	(method (changeState newState)
		(if (or (IsFlag 539) register)
			(switch (= state newState)
				(0
					(gEgo
						normalize:
						setSpeed: 3
						setMotion: 0
						setHeading: 180
					)
					(gKqSound1 stop:)
					(mathilde setMotion: 0)
					(mathilde
						view: 2451
						setLoop: 0
						posn: 219 107
						z: 5
						setCycle: Fwd
					)
					(ClearFlag 539)
					(= register 1)
					(= cycles 2)
				)
				(1
					(gGame handsOn:)
					(client setScript: kidRat)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 2451)
					(Load rsVIEW 8954)
					(Load rsVIEW 8974)
					(Load rsVIEW 903)
					(Load rsVIEW 8994)
					(Load rsSOUND 2489)
					(gEgo
						ignoreActors: 1
						posn: 87 73
						setMotion: PolyPath 140 114 self
					)
					(mathilde
						setPri: 110
						view: 2451
						posn: 219 107
						setLoop: 0
						setCycle: Fwd
					)
				)
				(1
					(gGame handsOff: 1)
					(mathilde setLoop: 1 cel: 0 setCycle: End self)
				)
				(2
					(mathilde setLoop: 2 cel: 0 setCycle: End self)
				)
				(3
					(mathilde
						view: 903
						setCycle: Walk
						setMotion: MoveTo 158 122 self
					)
				)
				(4
					(mathilde
						view: 2451
						posn: 156 120
						setLoop: 3
						cel: 0
						z: 0
						setCycle: CT 5 1 self
					)
					(gEgo view: 8954 setLoop: 0 cel: 0 setCycle: End)
				)
				(5
					((ScriptID 7001 2) hide_mouth: 1) ; mathildeTalker
					(gMessager say: 0 0 2 1 self) ; "(ANGRILY)Who are you, missy? You're no real troll! I can see right through you. What do you want with King Otar, you human minx?"
					(gEgo setCycle: Beg)
				)
				(6
					(gEgo view: 8974 setLoop: 0 cel: 0 setCycle: End self)
				)
				(7
					(gEgo normalize: 4)
					(= ticks 20)
				)
				(8
					(gMessager say: 0 0 2 2 self) ; "(BEWILDERED)I don't want anything, I was just looking into this pool, and then I saw this--"
				)
				(9
					(gMessager say: 0 0 2 3 self) ; "(ANGRILY, TRIUMPHANT)Baloney, little girl! You're trying to steal the throne of the Underground! Userper! Userper!"
				)
				(10
					(gEgo
						view: 8994
						setLoop: 0
						cel: 0
						setCycle: ForwardCounter 2 self
					)
					(gKqSound1 number: 2489 setLoop: -1 play:)
				)
				(11
					(mathilde setCycle: CT 13 1 self)
				)
				(12
					(mathilde setCycle: End self)
					((ScriptID 7001 2) hide_mouth: 0) ; mathildeTalker
				)
				(13
					(gMessager say: 0 0 2 4 self) ; "(SOFTLY, VISIBLY MELTS)Why, you're no userper. You poor little thing. Don't cry. I didn't mean to be cross. It's just that King Otar has been so strange lately, and that horrible WOMAN has been snooping around."
					(gKqSound1 stop:)
				)
				(14
					((ScriptID 7001 2) hide_mouth: 1) ; mathildeTalker
					(gEgo normalize: 4 setSpeed: 3)
					(= cycles 2)
				)
				(15
					(gMessager say: 0 0 2 5 self) ; "(VOICE QUIVERING)I'm not crying."
				)
				(16
					(mathilde setLoop: 3 cel: 17 setCycle: CT 7 -1 self)
				)
				(17
					(gMessager sayRange: 0 0 2 6 9 self) ; "(INDULGENTLY)Of course you're not, dear. Now you listen to me. I can help you turn back into a human."
				)
				(18
					(mathilde setCycle: CT 3 -1 self)
				)
				(19
					(gMessager sayRange: 0 0 2 10 11 self) ; "Up above this kingdom is a dark land called Ooga Booga. Our kingdoms were never crazy about each other, but we had a civil relationship. Now, because of HER, the Ooga Boogites attack any troll that shows his face above ground. Missy, once you're human, will you go above and investigate? I have a gut feeling that our kingdom is in terrible trouble."
				)
				(20
					(mathilde setCycle: CT 7 1 self)
				)
				(21
					(gMessager sayRange: 0 0 2 12 13 self) ; "(HAPPILY)Wonderful! Now listen, girl. Bring me some baked beetles, a crystal dragon scale, water of emerald, a silver spoon, and a gold bowl. Got it?"
				)
				(22
					((ScriptID 7001 2) hide_mouth: 0) ; mathildeTalker
					(mathilde
						view: 903
						setCycle: Walk
						posn: 161 120
						z: 5
						setMotion: MoveTo 219 107 self
					)
				)
				(23
					(mathilde
						view: 2451
						setLoop: 5
						cel: 0
						posn: 223 110
						setCycle: End self
					)
				)
				(24
					(mathilde
						view: 2451
						setLoop: 0
						posn: 219 107
						z: 5
						setCycle: Fwd
					)
					(= seconds 2)
				)
				(25
					(client setScript: kidRat)
				)
			)
		)
	)
)

(instance kidRat of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(ClearFlag 539)
			(gKqMusic1 number: 2457 setLoop: -1 play:)
			(kid dispose:)
			(rat init:)
			(gEgo normalize: 2)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 539)
					(gKqMusic1 stop:)
					(kid
						posn: 17 89
						setLoop: 0 1
						init:
						setScript: kidMusicScript
						setCycle: Walk
						setMotion: MoveTo 38 91 self
					)
				)
				(1
					(gGame handsOff: 1)
					(kid setMotion: MoveTo 113 99 self)
				)
				(2
					(gEgo setHeading: 290)
					(kid posn: 121 100 setLoop: 1 cel: 0 setCycle: CT 8 1 self)
				)
				(3
					(gMessager say: 0 0 2 14 self) ; "(VERY BRATTY)Stupid old toy RAT! This is NOT what I wanted! I wanted a BATTLE-AX!"
				)
				(4
					(kid setCycle: End)
					(gMessager say: 0 0 2 15 self) ; "Spike! Time for lunch! Don't forget your new toy!"
				)
				(5
					(kid setCycle: CT 8 -1 self)
				)
				(6
					(gMessager say: 0 0 2 16 self) ; "Dumb stupid RAT!"
				)
				(7
					(kid posn: 120 102 setLoop: 2 cel: 0 setCycle: End self)
				)
				(8
					(rat init:)
					(kid
						posn: 114 98
						setLoop: 0 1
						setCycle: Walk
						setScript: kidMusicScript
						setMotion: MoveTo 196 84 self
					)
				)
				(9
					(kid setMotion: MoveTo 274 78 self)
				)
				(10
					(gGame handsOn:)
					(kid setMotion: MoveTo 321 60 self)
					(gEgo setHeading: 180)
				)
				(11
					(= ticks 45)
				)
				(12
					(kid dispose:)
					(self dispose:)
				)
			)
		)
	)
)

(instance kidMusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqMusic1 number: 2462 setLoop: 1 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gKqMusic1 number: 2450 setLoop: -1 play:)
		((ScriptID 7001 2) mouth_y: -999) ; mathildeTalker
	)
)

(instance postTransform of Script
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
					(gCurRoom newRoom: 2485)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(gGame handsOff: 1)
					(SetFlag 89)
					(Load 140 816) ; WAVE
					(Load rsSOUND 2472)
					((ScriptID 7001 1) clientCel: -2) ; maliciaTalker
					((ScriptID 7001 0) clientCel: -2) ; kingTalker
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(gEgo
						setScale: 0
						view: 2453
						setLoop: 1
						setCel: 0
						posn: 201 109
						cycleSpeed: 12
						setCycle: 0
					)
					(mathilde
						view: 2453
						init:
						setPri: 111
						setLoop: 0
						setCel: 0
						posn: 164 138
						cycleSpeed: 10
						setCycle: 0
					)
					(= ticks 45)
				)
				(1
					(king
						view: 2453
						setLoop: 2
						setCel: 0
						posn: 166 135
						init:
						setCycle: End self
					)
					(gKqSound1 number: 816 setLoop: 1 play:)
				)
				(2
					(king posn: 166 135 setLoop: 3 cel: 0 setCycle: End self)
				)
				(3
					(mathilde setCycle: End self)
				)
				(4
					(gEgo setCycle: End self)
				)
				(5
					(gMessager say: 0 0 11 7 self) ; "(DELIGHTED THAT ROSELLA IS A GIRL ONCE MORE)My dear Princess Rosella! I'm stunned! Your beauty is only surpassed by your intelligence, and your courage, and..."
				)
				(6
					(gKqMusic1 number: 2472 setLoop: 1 play:)
					(malicia
						view: 2453
						setLoop: 8
						cel: 0
						posn: 120 120
						init:
						setCycle: End self
					)
					(gKqSound1 number: 816 setLoop: 1 play:)
				)
				(7
					(king
						setLoop: 4
						cel: 0
						cycleSpeed: 12
						setPri: 107
						setCycle: End self
					)
				)
				(8
					(gMessager say: 0 0 11 8 self) ; "(REALLY ANGRY)You! I've had just about enough of you distracting the king, you little snip!"
				)
				(9
					(gEgo
						setLoop: 6
						cel: 2
						posn: 195 109
						cycleSpeed: 12
						setPri: 108
						x: 198
						setCycle: CT 5 1 self
					)
				)
				(10
					(king hide:)
					(gEgo cel: 6)
					(= cycles 8)
				)
				(11
					(gEgo cel: 7 setCycle: End self)
					(king show: setLoop: 9 cel: 0 setCycle: End posn: 161 110)
				)
				(12
					(gMessager say: 0 0 11 9 self) ; "(ANGRY, INDIGNANT)Now look here, lady--"
				)
				(13
					(malicia setLoop: 7 cel: 0 posn: 100 120 setCycle: End self)
					(gKqSound1 number: 816 setLoop: 1 play:)
				)
				(14
					(malicia dispose:)
					(gMessager sayRange: 0 0 11 10 11 self) ; "(ANGRY, TRIUMPHANT)No, look here!"
				)
				(15
					(gGame handsOn:)
					(gCurRoom newRoom: 2485)
				)
			)
		)
	)
)

(instance maliciaComes of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(and
					(& (event type:) evMOUSEBUTTON)
					(= temp0 1)
					(not (gInterfacePlane onMe: event))
					(not (malicia onMe: event))
				)
				(& (event type:) evMOVE)
			)
			(event claimed: 1)
			(self cue:)
		)
		(if temp0
			(event globalize:)
		)
		(event claimed:)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gWalkHandler contains: self)
					(gWalkHandler delete: self)
					(gMouseDownHandler delete: self)
				)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(mathilde
					view: 24504
					setLoop: 1
					cel: 10
					posn: 227 106
					z: 10
					setCycle: 0
					setMotion: 0
				)
				((ScriptID 7001 2) hide_mouth: 0 mouth_y: -10) ; mathildeTalker
				(Load 140 6261) ; WAVE
				(Load 140 816) ; WAVE
				(Load rsSOUND 2482)
				(Load rsVIEW 24506)
				(Load rsVIEW 24505)
				(Load rsVIEW 837)
				(Load rsSOUND 5316)
				(gEgo setMotion: PolyPath 251 123 self)
			)
			(1
				(gMessager say: 9 8 20 0 self) ; "(REALLY MAD, MUTTERING TO HERSELF)Try to escape, will she? Well, just let her try!"
			)
			(2
				(= register (gEgo moveSpeed:))
				(gEgo
					view: 837
					ignoreActors: 1
					setLoop: 6 1
					setStep: 10 6
					setSpeed: 8
					setMotion: MoveTo 226 102 self
				)
			)
			(3
				(mathilde setPri: 110)
				(gEgo
					setPri: 111
					setLoop: 1 1
					setMotion: MoveTo 208 103 self
				)
			)
			(4
				(gEgo
					setScale: 0
					view: 24505
					loop: 2
					cel: 0
					posn: 203 110
					setCycle: End self
				)
			)
			(5
				(gEgo view: 24506 loop: 5 cel: 0 posn: 192 109)
				(malicia
					init:
					view: 24506
					loop: 0
					cel: 0
					posn: 256 127
					setHotspot: 8 32 ; Do, Toy_Rat
					cycleSpeed: 10
					setCycle: End self
				)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(6
				(gKqSound1 number: 5316 setLoop: 1 play: self)
			)
			(7
				(gKqMusic1 stop:)
				(gKqMusic1 number: 2472 setLoop: -1 play:)
				(gGame handsOn:)
				(= seconds 10)
				(gWalkHandler add: self)
				(gMouseDownHandler add: self)
			)
			(8
				(gEgo setCycle: 0 setMotion: 0)
				(malicia setLoop: 1 cel: 0 posn: 262 129 setCycle: CT 14 1 self)
				(gKqMusic1 fade:)
			)
			(9
				(gKqSound1 number: 2482 setLoop: 1 play: self)
			)
			(10
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
				(gMessager say: 0 0 21 0 self) ; "(GLEEFUL)AHA!"
			)
			(11
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
				(malicia setCycle: CT 16 1 self)
				(gGame handsOff:)
			)
			(12
				(malicia setCycle: End self)
				(gKqSound1 number: 843 setLoop: 1 play:)
			)
			(13
				(gEgo
					view: 24506
					setLoop: 6
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(gKqSound1 number: 6261 setLoop: 1 play: self)
			)
			(14 0)
			(15
				(EgoDead 64 self)
			)
			(16
				(malicia dispose:)
				(rat dispose:)
				(gKqSound1 stop:)
				(= seconds 0)
				(gEgo
					setScaler: Scaler 48 46 110 79
					normalize:
					ignoreActors:
					posn: 225 116
				)
				(self init:)
			)
		)
	)
)

(instance malToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(malicia
					view: 9060
					cel: 0
					setLoop: 1 1
					init:
					setScaler: Scaler 95 41 131 63
					posn: 130 95
					setPri: 90
				)
				(if (== gPrevRoomNum 2460)
					(gEgo setMotion: MoveTo 93 100 self)
				else
					(= cycles 1)
				)
			)
			(1
				(malicia
					setCycle: Fwd
					cycleSpeed: 9
					setMotion: MoveTo 90 90 self
				)
			)
			(2
				(malicia setMotion: MoveTo 40 86 self)
			)
			(3
				(malicia setLoop: 3 setMotion: MoveTo 40 76 self)
				(gEgo setSpeed: 6 setMotion: PolyPath 93 92)
			)
			(4
				(malicia setLoop: 6)
				(= cycles 2)
			)
			(5
				(SetFlag 86)
				(gCurRoom newRoom: 2460)
			)
		)
	)
)

(instance fightToon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(ClearFlag 539)
			(mathilde init:)
			(mathilde
				view: 24504
				setLoop: 1
				cel: 10
				posn: 227 106
				z: 10
				setCycle: 0
				setMotion: 0
			)
			((ScriptID 7001 2) hide_mouth: 0 mouth_y: -10) ; mathildeTalker
			(gEgo setSpeed: register normalize: 2 posn: 96 96 setMotion: 0)
			(zap dispose:)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(SetFlag 357)
					(Load rsVIEW 24503)
					(Load rsVIEW 903)
					(Load rsVIEW 8535)
					(Load rsVIEW 24504)
					(Load 140 2481) ; WAVE
					(= register (gEgo cycleSpeed:))
					(gMessager sayRange: 8 8 19 1 2 self) ; "(ANGRY)Don't you hurt him! Don't you dare hurt him!"
				)
				(1
					(gEgo setSpeed: 3 setMotion: PolyPath 86 86 self)
				)
				(2
					(gEgo setHeading: 45 self)
				)
				(3
					(gEgo view: 8535 setLoop: 1 cel: 0 setCycle: End self)
					((ScriptID 7001 2) hide_mouth: 1) ; mathildeTalker
				)
				(4
					(gMessager sayRange: 8 8 19 3 4 self) ; "(ANGRY, ACCUSING)There's something wrong with him! What have you done to him, witch?"
				)
				(5
					(gMessager say: 8 8 19 5 self) ; "Barf! Barf! Barf!"
					(mathilde
						view: 903
						posn: 81 69
						init:
						setCycle: Walk
						setPri: -1
						setMotion: MoveTo 83 75 self
					)
				)
				(6 0)
				(7
					(mathilde setMotion: MoveTo 121 85 self)
				)
				(8
					(mathilde setMotion: MoveTo 125 90 self)
				)
				(9
					(mathilde
						view: 24503
						setLoop: 0
						setCel: 0
						posn: 125 92
						setCycle: End self
					)
				)
				(10
					(gMessager say: 8 8 19 6 self) ; "(SHOUTING, FURIOUS)You don't scare me, you cold-blooded beanstalk! You flinty-eyed LIZARD!"
				)
				(11
					(zap init: cycleSpeed: 20 setCycle: End self)
					(mathilde setLoop: 2 setCel: 0 setCycle: End)
					(gKqSound1 number: 2481 setLoop: 1 play:)
				)
				(12
					(zap dispose:)
					(mathilde setLoop: 3 setCel: 0 setCycle: End self)
				)
				(13
					(mathilde
						setCycle: Walk
						view: 903
						setPri: 108
						setMotion: PolyPath 211 111 self
					)
				)
				(14
					(mathilde
						view: 24504
						setLoop: 0
						cel: 0
						setPri: 108
						setCycle: End self
					)
					(gEgo setSpeed: 10 setCycle: Beg self)
				)
				(15 0)
				(16
					(mathilde
						setLoop: 1
						cel: 0
						posn: 227 106
						z: 10
						setCycle: End self
					)
					(gEgo setSpeed: register normalize: 7)
				)
				(17
					(gEgo setMotion: MoveTo 96 96 self)
				)
				(18
					((ScriptID 7001 2) hide_mouth: 0 mouth_y: -10) ; mathildeTalker
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance verminToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 356)
				(Load 140 2492) ; WAVE
				(Load rsVIEW 24505)
				(Load 140 816) ; WAVE
				(Load rsSOUND 5316)
				((ScriptID 7001 1) clientCel: -2) ; maliciaTalker
				(= register (gEgo moveSpeed:))
				(gEgo posn: 221 108 setPri: 111 cycleSpeed: 8 setLoop: 0)
				(= ticks 20)
			)
			(1
				(malicia
					init:
					view: 24506
					posn: 176 120
					setLoop: 0
					cel: 0
					cycleSpeed: 11
					setCycle: CT 3 1 self
				)
			)
			(2
				(malicia setCycle: End self)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(3
				(gEgo
					view: 24505
					posn: 215 111
					setLoop: 2 1
					cel: 0
					setScale: 0
					setCycle: End self
				)
				(gKqSound1 number: 5316 setLoop: 1 play:)
				(malicia view: 24505 setLoop: 1 cel: 0 posn: 176 120)
			)
			(4
				(gKqMusic1 number: 2472 setLoop: -1 play:)
				(gMessager say: 0 0 26 1 self) ; "Where is that little snip of a princess? When I find her, I'll--"
			)
			(5
				(gKqSound1 number: 2492 setLoop: -1 play:)
				(bat init: setPri: 190 cycleSpeed: 9 setCycle: CT 7 1 self)
			)
			(6
				(bat setCycle: End self)
				(malicia cycleSpeed: 8 setCycle: End self)
				(gMessager say: 0 0 26 4) ; "EEEEEEEEK!"
			)
			(7 0)
			(8
				(malicia setCycle: Beg self)
			)
			(9
				(gKqSound1 stop:)
				(bat dispose:)
				(= ticks 45)
			)
			(10
				(gMessager sayRange: 0 0 26 2 3 self) ; "Barf? BARF!"
			)
			(11
				(malicia view: 24505 setLoop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(12
				(malicia setCycle: End self)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(13
				(malicia dispose:)
				(gEgo
					normalize:
					setSpeed: 8
					setScaler: Scaler 48 46 110 79
					posn: 200 106
					setMotion: MoveTo 190 110 self
				)
				(gKqMusic1 number: 2450 setLoop: -1 play:)
			)
			(14
				(gEgo setMotion: MoveTo 190 110 self)
			)
			(15
				(gEgo setMotion: MoveTo 183 118 self)
			)
			(16
				(gEgo setSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useRatOnMal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 90)
				(Load 140 815) ; WAVE
				(Load 140 2483) ; WAVE
				(Load 140 2484) ; WAVE
				(Load 140 2485) ; WAVE
				(Load 140 816) ; WAVE
				(Load 140 2486) ; WAVE
				(Load rsVIEW 24506)
				(Load rsVIEW 8534)
				(gKqSound1 number: 815 setLoop: -1 play:)
				(gEgo
					view: 24506
					setLoop: 2
					cel: 0
					posn: 192 109
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				(gEgo setLoop: 5 cel: 0)
				(gKqSound1 number: 2483 setLoop: 1 play:)
				(rat
					view: 24506
					setLoop: 3
					cel: 0
					init:
					posn: 205 104
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gKqSound1 stop:)
				(gKqSound1 number: 2484 setLoop: 1 play: self)
			)
			(3
				(malicia
					view: 24506
					setLoop: 4
					posn: 263 127
					cel: 0
					setCycle: CT 9 1 self
				)
				(gKqSound1 number: 2485 setLoop: 1 play:)
			)
			(4
				(malicia setCycle: End self)
				(gKqSound1 number: 816 setLoop: 1 play:)
			)
			(5
				(malicia dispose:)
				(rat dispose:)
				(gEgo
					setScaler: Scaler 48 46 110 79
					view: 8534
					setLoop: 0
					cel: 14
					setCycle: Beg self
				)
				(gKqMusic1 number: 2450 setLoop: -1 play:)
			)
			(6
				(gEgo normalize: 4)
				(= ticks 30)
			)
			(7
				(gKqSound1 number: 2486 setLoop: 1 play: self)
			)
			(8
				(exBridge setHotspot: 8 10) ; Do, Exit
				(gEgo setMotion: MoveTo 176 112 self)
			)
			(9
				(gEgo setMotion: MoveTo 176 122 self)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mathilde of Actor
	(properties
		noun 1
		sightAngle 5
		approachX 210
		approachY 114
		x 219
		y 107
		z 5
		view 2451
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setHotspot: 9998
			setSpeed: 10
			approachVerbs: 8 95 33 42 34 35 36 39 ; Do, Bowl_b, Bowl_a, ???, Silver_Spoon, Baked_Beetles, Dragon_Scale, Dragon_Toad
		)
	)

	(method (doVerb theVerb)
		(cond
			((or (gEgo has: 32) (IsFlag 70)) ; Enchanted_Rope
				(gMessager say: noun 8 20 0) ; "(URGENTLY)Go, Rosella! Quickly!"
			)
			((and (IsFlag 55) (!= theVerb 8) (!= theVerb 39)) ; Do, Dragon_Toad
				(gMessager say: noun 0 25 0) ; "(DEFEATED)Run along, child. Run and hide."
			)
			((== theVerb 8) ; Do
				(cond
					((IsFlag 55)
						(cond
							((IsFlag 56)
								(gMessager say: noun theVerb 20 0) ; "(URGENTLY)Go, Rosella! Quickly!"
							)
							((IsFlag 374)
								(gMessager say: noun theVerb 24 0) ; "(SAD, DEFEATED)Leave me be, child. I'm sick at heart."
							)
							((IsFlag 373)
								(SetFlag 374)
								(gMessager say: noun theVerb 23 0) ; "(DETERMINED)Mathilde, maybe if we investigate, we can--"
							)
							(else
								(SetFlag 373)
								(gMessager say: noun theVerb 22 0) ; "(CONCERNED, SYMPATHETIC)Mathilde, I know you're concerned for the king, but maybe you shouldn't bait Malicia like you did. She's fully capable of...hurting you."
							)
						)
					)
					(
						(and
							(or (gEgo has: 24) (gEgo has: 33)) ; Bowl_a, Bowl_b
							(gEgo has: 26) ; Baked_Beetles
							(gEgo has: 25) ; Silver_Spoon
							(gEgo has: 27) ; Dragon_Scale
							(IsFlag 68)
						)
						(gMessager say: noun theVerb 4 0) ; "(EXCITED)Mathile! I think I have all of the ingredients for the spell!"
					)
					((IsFlag 57)
						(gMessager say: noun theVerb 3 0) ; "(SOFTLY, NOT WANTING TO DISTURB MATHILDE)Mathilde? What was that list of ingredients again?"
					)
					((IsFlag 350)
						(gMessager say: noun theVerb 6 0) ; "Hurry, Rosella. Find the gold bowl!"
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "(SOFTLY, NOT WANTING TO DISTURB MATHILDE)Mathilde? What was that list of ingredients again?"
					)
				)
				(return 1)
			)
			((== theVerb 39) ; Dragon_Toad
				(= global318 theVerb)
				(gCurRoom setScript: goShowToad)
			)
			((OneOf theVerb 95 33 42 34 35 36) ; Bowl_b, Bowl_a, ???, Silver_Spoon, Baked_Beetles, Dragon_Scale
				(= global318 theVerb)
				(gCurRoom newRoom: 2455)
			)
			(else
				(gMessager say: noun 0 9) ; "(IMPATIENTLY)You're wasting my time, little girl!"
			)
		)
		(return 1)
	)
)

(instance malicia of Actor
	(properties
		x 290
		y 130
		view 2450
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; Toy_Rat
				(gEgo put: 23) ; Toy_Rat
				(gCurRoom setScript: useRatOnMal)
				(return 1)
			)
		)
	)
)

(instance king of Prop
	(properties)
)

(instance toad of Prop
	(properties
		noun 7
		approachX 156
		approachY 78
		x 145
		y 16
		view 24507
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 92)
			(self cel: 1 posn: 140 73 approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		)
		(self setPri: 78)
	)

	(method (doVerb)
		(gCurRoom setScript: pickUpToad)
	)
)

(instance bat of Prop
	(properties
		x 214
		y 109
		view 24505
	)
)

(instance rat of Prop
	(properties
		approachX 114
		approachY 102
		x 120
		y 103
		view 24507
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 setPri: 20 ignoreActors:) ; Do, Exit, Do
		(|= signal $1000)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: pickUpRat)
			(return 1)
		)
	)
)

(instance chair of View
	(properties
		x 218
		y 105
		view 24507
	)
)

(instance table of View
	(properties
		x 227
		y 105
		priority 112
		fixPriority 1
		view 24507
		cel 1
	)

	(method (init)
		(if (and (IsFlag 57) (not (IsFlag 55)))
			(= cel 3)
		)
		(super init: &rest)
	)
)

(instance shield of View
	(properties
		approachX 118
		approachY 76
		x 118
		y 52
		view 24507
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: getShield)
			(return 1)
		)
	)
)

(instance males of View
	(properties
		x 45
		y 63
		view 2450
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance females of View
	(properties
		noun 6
		x 49
		y 68
		view 2450
	)

	(method (onMe)
		(return 0)
	)
)

(instance zap of Prop
	(properties
		x 107
		y 80
		view 24503
		loop 1
	)
)

(instance exChamber of ExitFeature
	(properties
		nsLeft 78
		nsTop 42
		nsRight 92
		nsBottom 70
		approachX 92
		approachY 74
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(if (and (IsFlag 55) (not (IsFlag 357)))
				(gCurRoom setScript: fightToon)
			else
				(gCurRoom setScript: goToBed)
			)
			(return 1)
		)
	)
)

(instance exBridge of ExitFeature
	(properties
		noun 9
		nsLeft 300
		nsTop 83
		nsRight 320
		nsBottom 136
		sightAngle 359
		approachX 335
		approachY 122
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(not global308)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(= temp0 (event claimed: 1))
				(if
					(and
						(gUser canControl:)
						(& (gEgo state:) $0002)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gApproachCode
						(& _approachVerbs (gApproachCode doit: (event message:)))
					)
					(if (and (not (IsFlag 90)) (IsFlag 56))
						(SetFlag 90)
						(gCurRoom setScript: maliciaComes)
					else
						(gEgo
							setMotion:
								PolyPath
								approachX
								(+ (gEgo z:) approachY)
								CueObj
						)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
		(return temp0)
	)

	(method (doVerb)
		(gCurRoom newRoom: 2550)
		(return 1)
	)
)

(instance exKitchen of ExitFeature
	(properties
		nsLeft 300
		nsTop 40
		nsRight 319
		nsBottom 65
		sightAngle 359
		approachX 307
		approachY 68
		x 318
		y 68
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: goToKitchen)
		(return 1)
	)
)

(instance exForge of ExitFeature
	(properties
		nsTop 73
		nsRight 14
		nsBottom 103
		sightAngle 359
		approachX 21
		approachY 106
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: goToForge)
		(return 1)
	)
)

(instance exJacuzzi of ExitFeature
	(properties
		nsLeft 3
		nsTop 3
		nsRight 61
		nsBottom 80
		sightAngle 359
		approachX 50
		approachY 80
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom newRoom: 2460)
		(return 1)
	)
)

(instance vent of Feature
	(properties
		nsLeft 149
		nsTop 3
		nsRight 160
		nsBottom 17
		approachX 156
		approachY 78
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(SetFlag 75)
			(gCurRoom
				setScript:
					(if (IsFlag 55) roseClimbAndJump else trollClimbAndJump)
			)
			(return 1)
		)
	)
)

(instance throne of Feature
	(properties
		nsLeft 143
		nsTop 49
		nsRight 163
		nsBottom 75
		approachX 156
		approachY 78
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(if (IsFlag 74)
			(gCurRoom setScript: bounceOnThrone)
		else
			(SetFlag 74)
			(gCurRoom setScript: sitOnThrone)
		)
		(return 1)
	)
)

(instance kid of Actor
	(properties
		view 2452
	)
)

(instance spikeTalker of KQTalker
	(properties
		clientCel 8
	)

	(method (init)
		(= client kid)
		(super init: &rest)
	)
)

