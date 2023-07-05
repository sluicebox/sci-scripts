;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use sHRoom8)
(use Array)
(use Talker)
(use Scaler)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	napoleon 0
)

(local
	local0
	local1 = -1
	local2 = -1
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 2]
	local13
)

(instance napoleon of Room
	(properties
		noun 1
		picture 460
		style 14
		exitStyle 13
	)

	(method (init)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1
				setLoop: -1
				number: 460
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(Load rsPIC 460)
		(Load rsSCRIPT 64941)
		(Load rsSCRIPT 64939)
		(Load rsSCRIPT 64969)
		(gEgo
			view: 900
			loop: 1
			cel: 0
			posn: 247 107
			state: 2
			setCycle: StopWalk -1
			normalize:
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			init:
			setScaler: Scaler 100 89 117 106
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 205 107 197 110 194 123 165 128 141 121 138 127 172 135 172 151 104 149 98 139 40 139 41 156 224 157 205 129 221 109
					yourself:
				)
		)
		(nappy init:)
		(bigBottles init:)
		(chessTable init:)
		(squareTable init:)
		(roundTable init:)
		(stools init:)
		(lamp init:)
		(bar init:)
		(wayOut init:)
		(paintings init:)
		(backShelves init:)
		(miscChairs init:)
		(barFly init: setScript: drinking)
		(drummer init: setCycle: RandCycle cycleSpeed: 8)
		(bartender init: setScript: bartending)
		(gentleman init: setScript: (drinking new:))
		(lady init: setScript: victoriasSecript)
		(cond
			((not (IsFlag 255))
				(sam init: setScript: (drinking new:))
				(markus init: setScript: (drinking new:))
				(markusBottle init: hide:)
				(samBottle init: hide:)
				(self setScript: playChess)
			)
			(
				(or
					(IsFlag 405)
					(and (IsFlag 255) (not (IsFlag 256)))
					(and (> gDay 3) (IsFlag 256) (not (IsFlag 257)))
				)
				(sam
					view: 466
					loop: 0
					cel: 0
					init:
					posn: 125 128
					setScript: (drinking new:)
				)
			)
		)
		(= local3 1)
		(if (and (== gPrevRoomNum 50) (== global178 34)) ; interrogation
			(gEgo posn: 144 123)
		else
			(gGame handsOff:)
			(gEgo setScript: egoEnters)
			(= local3 0)
		)
		(= local9 gNarrator)
		(= gNarrator nappyNarrator)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(UnLoad 129 460)
		(DisposeScript 64941)
		(DisposeScript 64939)
		(DisposeScript 64969)
		(DisposeScript 51)
		(DisposeScript 920)
		(DisposeScript 64935)
		(if (and (!= 50 gNewRoomNum) gGkMusic1) ; interrogation
			(gGkMusic1 fade:)
		)
		(= gNarrator local9)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 30)
			)
			(1
				(wayOut setCycle: Beg self)
			)
			(2
				(gEgo setMotion: MoveTo 197 110 self)
			)
			(3
				(Face gEgo wayOut self)
			)
			(4
				(gEgo hide:)
				(wayOut cel: 0 loop: 1 setCycle: End self)
			)
			(5
				(gEgo show: posn: 198 111)
				(wayOut loop: 0 cel: 6)
				(UpdateScreenItem gEgo)
				(UpdateScreenItem wayOut)
				(= cycles 2)
			)
			(6
				(gEgo normalize: 2)
				(= cycles 1)
			)
			(7
				(= local3 1)
				(if (and (> gDay 3) (IsFlag 256) (not (IsFlag 257)))
					(gCurRoom setScript: getBracelet)
				else
					(gGame handsOn:)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 197 110 self)
			)
			(1
				(Face gEgo wayOut self)
			)
			(2
				(gEgo hide:)
				(wayOut loop: 1 cel: 9 setCycle: Beg self)
			)
			(3
				(gEgo show: setMotion: MoveTo 247 107 self)
				(wayOut loop: 0 cel: 0)
			)
			(4
				(wayOut setCycle: End self)
			)
			(5
				(ClearFlag 405)
				(gGame handsOn:)
				(if (gTalkers size:)
					(gMessager caller: 0 cue: 1)
				)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance playChess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 30))
			)
			(1
				(if (and (Random 0 1) (not (gTalkers size:)))
					(gMessager say: 20 0 (Random 2 6) 0 self)
				else
					(= seconds 2)
				)
			)
			(2
				(sam loop: (Random 0 3) cel: 0 setCycle: End self)
				(samBottle show:)
				(FrameOut)
			)
			(3
				(sam loop: 4 cel: 0)
				(samBottle hide:)
				(= seconds (Random 1 3))
			)
			(4
				(if (< 3 (Random 1 5))
					(markus loop: 4 cel: 0 setCycle: End)
					(markusBottle show:)
					(FrameOut)
					((markus script:) register: 0)
				)
				(= seconds (Random 3 6))
			)
			(5
				(markus loop: (Random 1 2) cel: 0 setCycle: End self)
				(if (not (markusBottle isNotHidden:))
					(markusBottle show:)
					(FrameOut)
				)
			)
			(6
				(markus loop: 3 cel: 0)
				(markusBottle hide:)
				((markus script:) register: 1)
				(= state -1)
				(= seconds 2)
			)
		)
	)
)

(instance bartending of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register (IntArray with: 2 4 5 7 10 14))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(= state (register at: (Random 0 (- (register size:) 1))))
				(-- state)
				(= cycles 1)
			)
			(2
				(bartender loop: 4 setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(3
				(bartender loop: 0 cel: 0 setCycle: 0)
				(= state -1)
				(= cycles 1)
			)
			(4
				(bartender loop: 4 setCycle: RandCycle)
				(= state 2)
				(= seconds (Random 3 8))
			)
			(5
				(bartender loop: 4 setCycle: RandCycle cycleSpeed: 12)
				(= seconds (Random 4 10))
			)
			(6
				(bartender setCycle: 0 cycleSpeed: 6)
				(= state -1)
				(= cycles 1)
			)
			(7
				(bartender loop: 3 cel: 0 setCycle: End self)
			)
			(8
				(bartender loop: 2 cel: 0 setCycle: End)
				(= seconds (Random 2 5))
			)
			(9
				(bartender loop: 3 cel: 0 setCycle: End self)
				(= state 2)
			)
			(10
				(bartender loop: 3 cel: 0 setCycle: End self)
			)
			(11
				(bartender loop: 2 cel: 0 setCycle: End)
				(= seconds (Random 1 2))
			)
			(12
				(bartender loop: 1 cel: 0 setCycle: Fwd)
				(if (> 4 (Random 1 7))
					(-= state 2)
				)
				(= seconds (Random 2 4))
			)
			(13
				(bartender loop: 3 cel: 0 setCycle: End self)
				(= state 2)
			)
			(14
				(bartender loop: 3 cel: 0 setCycle: End self)
			)
			(15
				(bartender loop: 1 cel: 0 setCycle: Fwd)
				(if (> 4 (Random 1 4))
					(-= state 2)
				)
				(= seconds (Random 2 4))
			)
			(16
				(bartender loop: 3 cel: 0 setCycle: End self)
				(= state 2)
			)
		)
	)

	(method (dispose)
		(register dispose:)
		(super dispose:)
	)
)

(instance drinking of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 50))
			)
			(1
				(if (and register (not (client cycler:)))
					(client cycleSpeed: 12 setCycle: Osc 1 self)
				else
					(= seconds 1)
				)
				(-= state 2)
			)
		)
	)
)

(instance victoriasSecript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= cycles 1)
			)
			(1
				(if (> 3 (Random 1 11))
					(^= register $0001)
				)
				(= cycles 1)
			)
			(2
				(lady loop: register cel: 0)
				(= seconds (Random 5 15))
			)
			(3
				(= state (Random 1 60))
				(= state
					(cond
						((< state 30) 4)
						((< state 50) 5)
						(else 6)
					)
				)
				(-- state)
				(= cycles 1)
			)
			(4
				(lady loop: (^ register $0001))
				(= seconds (Random 1 5))
				(= state 0)
			)
			(5
				(lady loop: 1 setCycle: End)
				(= seconds (Random 3 5))
				(= state 0)
			)
			(6
				(lady loop: 0 setCycle: End)
				(= seconds (Random 3 7))
				(= state 0)
			)
		)
	)
)

(instance pitchTheOil of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sam setSpeed: 9)
				(gMessager say: 15 46 local4 1 self)
			)
			(1
				(sam view: 4622 loop: 0 cel: 0 setCycle: End self)
				(samBottle show:)
				(gMessager say: 15 46 local4 2 self)
			)
			(2 1)
			(3
				(if (not (IsFlag 258))
					(sam loop: 1 cel: 0 setCycle: End)
					(gMessager sayRange: 15 46 local4 3 4 self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo
					setCycle: 0
					setLoop: 1 1
					cel: (gEgo lastCel:)
					setCycle: Rev
					setMotion: MoveTo 168 (gEgo y:) self
				)
			)
			(5
				(gEgo setCycle: 0 normalize:)
				(sam loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(sam
					setCycle: 0
					view: 465
					setLoop: 0 1
					posn: 133 139
					setCycle: Walk
					setMotion: MoveTo 125 128 self
				)
				(gEgo setMotion: MoveTo 148 122 self)
			)
			(7 1)
			(8
				(sam view: 463 loop: 0 setCycle: Beg self)
				(gEgo loop: 1)
			)
			(9
				(= temp0 (if (not (IsFlag 258)) 6 else 4))
				(gMessager sayRange: 15 46 local4 (- temp0 1) temp0 self)
			)
			(10
				(= local6 (= local7 (= local8 0)))
				(oilTeller init: doVerb: 11)
			)
			(11
				(SetFlag 258)
				(oilTeller dispose:)
				(if local8
					(markus setScript: 0 loop: 4 cel: 0 setCycle: End)
					(gCurRoom setScript: useTheOil)
				else
					(sam view: 4631 loop: 3 cel: 1 setCycle: CT 15 1 self)
				)
			)
			(12
				(sam
					view: 465
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 133 139 self
				)
				(gEgo loop: 5)
			)
			(13
				(sam loop: 2 setCycle: End self)
				(gMessager say: 22 0 33 0) ; "Welcome back, loser."
			)
			(14
				(sam view: 4621 loop: 4 cel: 0 posn: 123 139)
				(gEgo loop: 2)
				(gCurRoom setScript: playChess)
				(samBottle hide:)
				(sam setScript: (drinking new:))
				(gGame handsOn:)
			)
		)
	)
)

(instance useTheOil of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(sam setCycle: End)
				(gEgo loop: 7)
				(gEgo put: 22) ; oil
				(gMessager say: 20 0 45 1 self) ; "(CURIOUS)Lemme see that bottle."
			)
			(1
				(sam loop: 2 cel: 0 setCycle: End)
				(= seconds 2)
			)
			(2
				(gMessager sayRange: 20 0 45 2 3 self) ; "(IMPRESSED)This looks authentic."
			)
			(3
				(sam view: 4631 loop: 0 cel: 0 setCycle: End)
				(gMessager say: 20 0 45 4 self) ; "(WISTFUL)If I could really beat that bastard...."
			)
			(4
				(sam view: 463 loop: 3 cel: 0 setCycle: Osc 1)
				(gMessager say: 20 0 45 5 self) ; "(CALLING TO BARTENDER)Stonewall, gimme a Pimm's Cup, would ya?"
			)
			(5
				(bartender
					setScript: 0
					posn: (bartender x:) (+ (bartender y:) 5)
					view: 4601
					loop: 0
					cel: 0
					setCycle: End self
				)
				(= gNarrator local9)
				(gMessager say: 20 0 45 6 self) ; "Comin' up, Sam."
			)
			(6 0)
			(7
				(bartender loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(= gNarrator nappyNarrator)
				(bartender
					view: 460
					loop: 0
					cel: 0
					posn: (bartender x:) (- (bartender y:) 5)
					setScript: bartending
				)
				(gMessager sayRange: 20 0 45 7 8 self) ; "(CONSPIRING--SPEAKING OF PUTTING VOODOO LUCKY POTION IN DRINK)How much you think I oughta put in here?"
			)
			(9
				(gMessager say: 20 0 45 9 self) ; "(CONFIDENT)Hah! There's no such thing as too much! Now stand back."
				(sam view: 4631 loop: 1 cel: 0 setCycle: End self)
			)
			(10 1)
			(11
				(sam loop: 2 cel: 0 setCycle: End self)
			)
			(12
				(gMessager say: 20 0 45 10 self) ; "Come on, already! I'm ready to checkmate!"
				(markus setCycle: Beg)
			)
			(13
				(sam loop: 3 cel: 0 setCycle: End)
				(gMessager say: 20 0 45 11 self) ; "We'll see about that, Mr. Smarty Bigmouth!"
			)
			(14
				(sam
					view: 465
					posn: (- (sam x:) 5) (sam y:)
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 133 139 self
				)
				(gEgo loop: 5)
			)
			(15
				(sam loop: 2 cel: 0 setCycle: End self)
			)
			(16
				(sam view: 4621 loop: 4 cel: 0 posn: 123 139)
				(gEgo loop: 2)
				(= seconds 1)
			)
			(17
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(18
				(gEgo posn: 146 127 loop: 2)
				(= seconds 2)
			)
			(19
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= seconds 1)
			)
			(20
				(sam view: 464 loop: 0 cel: 0 setCycle: End self)
			)
			(21
				(sam loop: 1 cel: 0 setCycle: End self)
			)
			(22
				(gMessager say: 20 0 37 1 self) ; "(GLEEFUL, GLOATING)Checkmate! Hee, hee, hee! Checkmate, ya bastard!"
				(sam loop: 2 cel: 0 setCycle: Fwd)
			)
			(23
				(markus view: 4612 loop: 0 cel: 0 setCycle: End)
				(gMessager say: 20 0 37 2 self) ; "(CAN'T BELIEVE IT)Sonovabitch!"
			)
			(24
				(sam loop: 3 cel: 0 setCycle: Fwd)
				(gMessager say: 20 0 37 3 self) ; "Twenty YEARS I've been waiting to say that! Checkmate, checkmate, checkmate!"
			)
			(25
				(gMessager say: 20 0 37 4 self) ; "You are the biggest butthead, Sam Singleton, that I EVER met!"
			)
			(26
				(sam view: 4641 loop: 0 cel: 0 setCycle: End self)
			)
			(27
				(gMessager say: 20 0 37 5 self) ; "CHECKMATE!"
				(sam loop: 3 cel: 0 setCycle: Fwd)
			)
			(28
				(gMessager say: 20 0 37 6 self) ; "You...you...! You can just put this chessboard where the sun don't shine!"
			)
			(29
				(markus setScaler: Scaler 100 89 117 106)
				(markus loop: 1 cel: 0 setCycle: End self)
			)
			(30
				(markus
					setLoop: 2 1
					cycleSpeed: 6
					setCycle: Fwd
					posn: (+ 10 (markus x:)) (markus y:)
					setMotion: MoveTo 217 119 self
				)
			)
			(31
				(gMessager say: 20 0 37 7) ; "Hallelujah! I did it! Yippee!"
				(sam loop: 1 cel: 0 setCycle: End self)
				(markus setCycle: 0)
			)
			(32
				(sam loop: 2 cel: 0 setCycle: Fwd)
				(wayOut setCycle: Beg self)
				(markus view: 4613 cel: 0 setLoop: 2 0 setCycle: End self)
			)
			(33 1)
			(34
				(wayOut setPri: 1)
				(markus
					view: 4612
					setLoop: 2 1
					cel: 0
					setPri: 2
					setCycle: Fwd
					setMotion: MoveTo 247 107 self
				)
			)
			(35
				(wayOut setCycle: End)
				(markus setMotion: MoveTo 290 121)
				(gMessager say: 20 0 37 8 self) ; "Nice game."
			)
			(36
				(sam view: 463 loop: 0 cel: 0 setCycle: End self)
				(gMessager say: 20 0 37 9 self) ; "Nice game, hell! I was brilliant!"
			)
			(37 0)
			(38
				(sam
					setCycle: 0
					view: 465
					setLoop: 0 1
					cel: 0
					posn: 133 139
					setCycle: Walk
					setMotion: MoveTo 125 128 self
				)
				(gMessager say: 20 0 37 10 self) ; "Course, I gotta give some of the credit to that oil of yours."
			)
			(39 0)
			(40
				(sam view: 463 loop: 0 0 cel: (sam lastCel:) setCycle: Beg)
				(gEgo loop: 1)
				(gMessager sayRange: 20 0 37 11 12 self) ; "I've been losing to that guy for twenty years! If you ever need a favor, you come to Sam, you hear?"
			)
			(41
				(wayOut setPri: -1)
				(markus dispose:)
				(SetFlag 255)
				(sam setCycle: End self)
			)
			(42
				(gEgo getPoints: 179 2)
				(sam view: 466 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showMold of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo sam self)
			)
			(1
				(gMessager say: 15 43 41 1 self) ; "Could you do anything with this?"
			)
			(2
				(sam setScript: 0 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gEgo put: 40) ; braceMold
				(sam loop: 2 cel: 0 setCycle: Osc 1 self)
			)
			(4
				(gMessager sayRange: 15 43 41 2 8 self) ; "What is this, a clay mold?"
			)
			(5
				(sam loop: 1 cel: 3 setCycle: CT 0 -1 self)
			)
			(6
				(gEgo getPoints: -999 1)
				(SetFlag 405)
				(sam loop: 0 cel: 0 setScript: (drinking new:))
				(SetFlag 256)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showSomething of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0
					(switch register
						(14 5)
						(17 5)
						(18 5)
						(19 1)
						(16 3)
						(15 1)
						(else 5)
					)
				)
				(gEgo
					setLoop: -1
					view: 904
					loop: temp0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if register
					(gMessager say: register 0 0 0 self)
				else
					(gMessager say: 14 31 0 0 self) ; "Does this mean anything to you?"
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= temp0
					(switch register
						(14 3)
						(17 1)
						(18 3)
						(19 1)
						(16 5)
						(15 5)
						(else 3)
					)
				)
				(gEgo normalize: temp0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBracelet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 147 127 self)
				(gMessager say: 20 0 39 1 self) ; "Sam, my man."
			)
			(1 1)
			(2
				(sam setScript: 0 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gMessager say: 20 0 39 2 self) ; "(ARCC)Hey there! It's you! I got that bracelet for you."
			)
			(4
				(sam loop: 2 cel: 0 setCycle: Osc 1 self)
			)
			(5
				(gMessager sayRange: 20 0 39 3 10 self) ; "(ARCC)This piece was a real toughie--for some reason the metal just wasn't setting. I must be outta practice."
			)
			(6
				(sam loop: 1 cel: 3 setCycle: CT 0 -1 self)
			)
			(7
				(gEgo getPoints: -999 1)
				(sam loop: 0 cel: 0 setScript: (drinking new:))
				(SetFlag 257)
				(SetFlag 405)
				(gEgo get: 41) ; braceRep
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance askBartender of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(= temp1
			(cond
				((== (= temp0 (if (== register sam) 15 else 14)) 14) 0)
				((++ local1) 8)
				(else 7)
			)
		)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo register self)
			)
			(1
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gMessager say: temp0 10 temp1 0 self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance markus of Actor
	(properties
		noun 16
		sightAngle 30
		approachX 170
		approachY 140
		approachDist 25
		x 140
		y 147
		view 461
		loop 3
		signal 20513
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 10) ; Ask
				(gMessager say: 16 10 (if local0 10 else 9) 0)
				(++ local0)
			)
			((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(super doVerb: theVerb &rest)
			)
			(else
				(gEgo setScript: showSomething 0 (self noun:))
			)
		)
	)
)

(instance sam of Actor
	(properties
		noun 15
		sightAngle 30
		approachX 147
		approachY 127
		approachDist 25
		x 123
		y 139
		priority 130
		fixPriority 1
		view 4621
		loop 4
		signal 20513
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(10 ; Ask
				(= temp0
					(cond
						((IsFlag 255) 48)
						((++ local1) 8)
						(else 7)
					)
				)
				(gMessager say: 15 10 temp0 0)
			)
			(11 ; Talk
				(= temp0
					(if (not (IsFlag 255))
						(Random 17 19)
					else
						49
					)
				)
				(gMessager say: 15 11 temp0 0)
			)
			(46 ; oil
				(if (and (& [global182 6] $0001) (& [global182 7] $4000))
					(self setCycle: 0)
					(self setScript: 0)
					(= local4 (if (not (IsFlag 258)) 26 else 30))
					(if (not (IsFlag 258))
						(gEgo getPoints: -999 1)
					)
					(gCurRoom setScript: pitchTheOil)
				else
					(gMessager say: 15 46 50 0) ; "(RRCC)Gabriel has no reason to think Sam might be interested in that Voodoo oil."
				)
			)
			(43 ; braceMold_
				(if (not (IsFlag 255))
					(= temp0 (if (++ local2) 22 else 21))
					(gMessager say: 15 43 temp0 0)
				else
					(gCurRoom setScript: showMold)
				)
			)
			(7 ; Look
				(= temp0 (if (not (IsFlag 255)) 0 else 49))
				(gMessager say: 15 7 temp0 0)
			)
			(42 ; braceRep_
				(gMessager say: 15 42 0 0) ; "(GK-AM2)Sam made that bracelet for Gabriel. He'd be insulted if Gabriel gave it back."
			)
			(else
				(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(super doVerb: theVerb &rest)
				else
					(gEgo setScript: showSomething 0 (self noun:))
				)
			)
		)
	)
)

(instance oilTeller of GKTeller
	(properties
		curNoun 23
		sayNoun 24
		verb 75
	)

	(method (showCases)
		(super
			showCases:
				34 ; It might make a good salad dressing.
				(not local5)
				29 ; Got any squeaky doors?
				(== local5 1)
				35 ; I bet it would work as hair tonic.
				(== local5 2)
				23 ; You might be able to sell it to some poor dumb sucker.
				(>= local5 3)
				28 ; Ever wonder why Markus wins every time?
				(not local7)
				24 ; This is a powerful Voodoo oil.
				(not local6)
				25 ; This Voodoo oil could make a NUN get lucky.
				(== local6 1)
		)
	)

	(method (cue)
		(switch iconValue
			(34 ; It might make a good salad dressing.
				(++ local5)
				((gCurRoom script:) cue:)
			)
			(29 ; Got any squeaky doors?
				(++ local5)
				((gCurRoom script:) cue:)
			)
			(35 ; I bet it would work as hair tonic.
				(++ local5)
				((gCurRoom script:) cue:)
			)
			(23 ; You might be able to sell it to some poor dumb sucker.
				((gCurRoom script:) cue:)
			)
			(28 ; Ever wonder why Markus wins every time?
				(++ local7)
				(= iconValue (if local6 44 else 43))
				(self sayMessage:)
			)
			(43 ; "(THINKS GABE'S KIDDING)Get outta here! Markus would never use something like this!"
				(self doVerb: 11)
			)
			(44 ; "Markus? Using Voodoo? That old bastard!"
				(++ local8)
				((gCurRoom script:) cue:)
			)
			(24 ; This is a powerful Voodoo oil.
				(++ local6)
				(self doVerb: 11)
			)
			(25 ; This Voodoo oil could make a NUN get lucky.
				(++ local6)
				(= iconValue (if local7 47 else 46))
				(self sayMessage:)
			)
			(47 ; "(LEARNING HIS FRIEND IS CHEATING)Hmmm. And you say Markus uses this? That explains a lot."
				(++ local8)
				((gCurRoom script:) cue:)
			)
			(36 ; Never mind. It probably wouldn't work anyway.
				(= iconValue (if local7 32 else 31))
				(self sayMessage:)
			)
			(31 ; "If you say so. Too bad."
				((gCurRoom script:) cue:)
			)
			(32 ; "Whoa, hold it! You really think Markus uses this stuff?"
				(++ local8)
				((gCurRoom script:) cue:)
			)
			(else
				(self doVerb: 11)
			)
		)
	)
)

(instance bartender of Prop
	(properties
		noun 14
		sightAngle 30
		approachX 144
		approachY 123
		approachDist 25
		x 108
		y 85
		priority 7
		fixPriority 1
		view 460
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(gMessager say: 14 11 (Random 11 15) 0)
				(return 1)
			)
			(10 ; Ask
				(= global178 34)
				(gCurRoom setScript: (askBartender register: self yourself:))
				(return 1)
			)
			(31 ; crocMask
				(gEgo setScript: showSomething 0 0)
			)
			(else
				(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(super doVerb: theVerb &rest)
				else
					(gEgo setScript: showSomething 0 (self noun:))
				)
			)
		)
	)
)

(instance drummer of Prop
	(properties
		noun 21
		sightAngle 30
		x 271
		y 93
		view 460
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 51)
					(gMessager say: 21 7 16 0) ; "It's one of those cult drummers."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barFly of Prop
	(properties
		noun 19
		sightAngle 30
		approachX 203
		approachY 120
		approachDist 4
		x 163
		y 64
		priority 121
		fixPriority 1
		view 4602
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(super doVerb: theVerb &rest)
		else
			(gEgo setScript: showSomething 0 (self noun:))
		)
	)
)

(instance gentleman of Prop
	(properties
		noun 18
		sightAngle 30
		approachX 96
		approachY 140
		approachDist 25
		x 80
		y 107
		priority 130
		fixPriority 1
		view 4603
		loop 2
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(super doVerb: theVerb &rest)
		else
			(gEgo setScript: showSomething 0 (self noun:))
		)
	)
)

(instance lady of Prop
	(properties
		noun 17
		sightAngle 30
		approachX 61
		approachY 145
		approachDist 25
		x 71
		y 125
		priority 135
		fixPriority 1
		view 4603
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self approachVerbs: 10 11 0) ; Ask, Talk
	)
)

(instance wayOut of Prop
	(properties
		noun 2
		sightAngle 30
		x 224
		y 105
		view 4613
		cel 6
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 6 8) ; Open, Operate
			(gGame handsOff:)
			(gEgo setScript: outtaHere)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance markusBottle of View
	(properties
		x 125
		y 119
		priority 140
		fixPriority 1
		view 461
		cel 1
	)
)

(instance samBottle of View
	(properties
		x 107
		y 113
		priority 140
		fixPriority 1
		view 462
		cel 1
	)
)

(instance bar of Feature
	(properties
		noun 5
		nsLeft 60
		nsTop 59
		nsRight 184
		nsBottom 98
		sightAngle 30
		x 122
		y 60
	)
)

(instance stools of Feature
	(properties
		noun 3
		nsLeft 112
		nsTop 102
		nsRight 181
		nsBottom 112
		sightAngle 30
		x 146
		y 107
	)
)

(instance chessTable of Feature
	(properties
		noun 4
		nsLeft 106
		nsTop 113
		nsRight 153
		nsBottom 130
		sightAngle 30
		x 130
		y 143
	)

	(method (doVerb theVerb)
		(if (and (not (not (IsFlag 255))) (OneOf theVerb 9 12)) ; Move, Pickup
			(gMessager say: noun theVerb 49 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance backShelves of Feature
	(properties
		noun 10
		nsLeft 183
		nsTop 61
		nsRight 217
		nsBottom 99
		sightAngle 30
		x 200
		y 80
	)
)

(instance nappy of Feature
	(properties
		noun 7
		nsTop 40
		nsRight 37
		nsBottom 141
		sightAngle 30
		x 18
		y 199
	)
)

(instance paintings of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 48 41 55 88 25 86 25 32 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 182 36 192 39 217 39 241 26 242 42 224 49 217 60 192 60 180 52 58 52 58 36
					yourself:
				)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 11
		nsLeft 103
		nsTop 23
		nsRight 122
		nsBottom 48
		sightAngle 30
		x 112
		y 35
	)
)

(instance roundTable of Feature
	(properties
		noun 6
		nsLeft 60
		nsTop 104
		nsRight 105
		nsBottom 113
		sightAngle 30
		x 82
		y 108
	)
)

(instance squareTable of Feature
	(properties
		noun 9
		nsLeft 216
		nsTop 114
		nsRight 273
		nsBottom 121
		sightAngle 30
		x 244
		y 117
	)
)

(instance bigBottles of Feature
	(properties
		noun 8
		sightAngle 30
		x 319
		y 199
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 145 258 112 261 81 285 81 284 100 296 76 296 31 316 30 319 145
					yourself:
				)
		)
	)
)

(instance miscChairs of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 113 222 113 223 106 237 106
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 253 126 244 145 237 144 236 136 251 118
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 81 139 64 138 65 106 77 106
					yourself:
				)
		)
	)
)

(instance nappyNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(34 35)
				(35 59)
				(38 47)
				(37 61)
				(39 10)
				(36 5)
				(else global220)
			)
		)
		(= temp1 (+ 3 (/ (param1 size:) 10)))
		(switch global180
			(1
				(if
					(and
						(> (param1 size:) 10)
						(gCast contains: gEgo)
						(or (== (gEgo view:) 901) (== (gEgo view:) 900))
						(== (gEgo loop:) 8)
						(== (gEgo scaleX:) 128)
					)
					(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
						(= temp0 (+ (gEgo view:) 1000))
					else
						(if (== (gEgo view:) 900)
							(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
						else
							(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
						)
						(switch (Random 0 2)
							(0 1)
							(1
								(+= temp0 10)
							)
							(2
								(= temp0 (+ (gEgo view:) 1000))
							)
						)
					)
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldCel: (gEgo cel:)
						oldSig: (gEgo signal:)
						view: temp0
					)
					((= local13 (Prop new:))
						view: temp0
						loop: (gEgo cel:)
						cel: 0
						posn: (gEgo x:) (gEgo y:)
						ignoreActors:
						cycleSpeed: 14
						init:
					)
					(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
						(local13 setCycle: ForRepeat)
					else
						(local13 setCycle: Fwd)
					)
				)
			)
			(34
				(bartender loop: 6 cel: 0 setScript: 0 setCycle: ROsc temp1 0)
			)
			(35
				(if (and (== (sam view:) 4621) (== (sam loop:) 4))
					(if (& (samBottle signal:) $0008)
						(samBottle show:)
						(FrameOut)
					)
					(= local10 1)
					(sam view: 462 loop: 3 cel: 0 setCycle: ROsc temp1 0)
				)
			)
			(38
				(barFly loop: 1 cel: 0 setScript: 0 setCycle: ROsc temp1 0)
			)
			(37
				(gentleman loop: 3 cel: 0 setScript: 0 setCycle: ROsc temp1 0)
			)
			(39
				(lady loop: 4 cel: 0 setScript: 0 setCycle: ROsc temp1 0)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(switch global180
			(1
				(if (gEgo talking:)
					(local13 setCycle: 0 dispose:)
					(gEgo
						view: (gEgo oldView:)
						loop: (gEgo oldLoop:)
						cel: (gEgo oldCel:)
						signal: (gEgo oldSig:)
						talking: 0
					)
				)
			)
			(34
				(bartender loop: 0 cel: 0 setCycle: 0 setScript: bartending)
			)
			(35
				(if local10
					(if (not (& (samBottle signal:) $0008))
						(samBottle hide:)
					)
					(sam view: 4621 loop: 4 cel: 0 setCycle: 0)
					(= local10 0)
				)
			)
			(38
				(barFly loop: 0 cel: 0 setCycle: 0 setScript: (drinking new:))
			)
			(37
				(gentleman
					loop: 2
					cel: 0
					setCycle: 0
					setScript: (drinking new:)
				)
			)
			(39
				(lady loop: 0 cel: 0 setCycle: 0 setScript: victoriasSecript)
			)
		)
		(super dispose:)
	)
)

