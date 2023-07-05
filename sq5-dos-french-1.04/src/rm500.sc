;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
	victim 1
	guard2 2
	lavaglob1 3
	lavaglob2 4
	sStairs 5
	sGetUpFromTable 6
	gotoTeleporter 7
	gotoTeleporterFTable 8
	gotoTable 9
	genTalker 10
	sDownTheStairs 11
	sToDetention 12
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 17] = [-20 220 30 161 340 220 287 161 -20 -20 31 27 340 -20 287 27 0]
	local24
	local25
	local26
	[local27 3] = [504 5041 5042]
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm500 of Rm
	(properties
		picture 72
		style 10
		vanishingY 50
	)

	(method (init)
		(gEgo view: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 156 0 165 176 165 226 156 316 156 316 142 223 142 205 109 147 109 146 112 154 118 109 144 53 144 22 157
					yourself:
				)
		)
		(gCurRoom setRegions: 505) ; sbar
		((ScriptID 501 29) init:) ; theBar
		((ScriptID 501 2) init: setOnMeCheck: 1 32) ; theNukem
		((ScriptID 501 30) init:) ; theTable
		((ScriptID 501 31) init: setOnMeCheck: 1 64) ; theTeleporter
		((ScriptID 501 3) init: setOnMeCheck: 1 16) ; theStairs
		((ScriptID 501 7) init: setOnMeCheck: 1 256) ; thePlants
		((ScriptID 501 5) init: setOnMeCheck: 1 512) ; thePatrons1
		((ScriptID 501 6) init: setOnMeCheck: 1 1024) ; thePatrons2
		((ScriptID 501 4) init:) ; theQuirk
		((ScriptID 501 10) init:) ; theLamp
		((ScriptID 501 32) init:) ; theAlien
		((ScriptID 501 33) init:) ; theDetention
		((ScriptID 501 34) init:) ; theSprint
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gWalkHandler addToFront: (ScriptID 501 30)) ; theTable
		(gWalkHandler addToFront: (ScriptID 501 31)) ; theTeleporter
		(gWalkHandler addToFront: (ScriptID 501 3)) ; theStairs
		(gWalkHandler addToFront: (ScriptID 501 33)) ; theDetention
		(if (not (IsFlag 54))
			(LoadMany rsVIEW 502 515)
			((ScriptID 501 22) init: stopUpd:) ; guy1
			((ScriptID 501 25) init: stopUpd:) ; guy1Mouth
			(lavaLamp init:)
			(lavaglob1 init: setScript: (ScriptID 501 13)) ; sGlob1
			(lavaglob2 init: setScript: (ScriptID 501 14)) ; sGlob2
			(bartender setCycle: Fwd detailLevel: 2 init:)
			(ex1 setCycle: Fwd detailLevel: 2 init:)
			(ex2 setCycle: Fwd detailLevel: 2 init:)
			(ex3 setCycle: Fwd detailLevel: 2 init:)
			(ex4 setCycle: Fwd detailLevel: 2 init:)
			(ex5 setCycle: Fwd detailLevel: 2 init:)
			(ex6 setCycle: Fwd detailLevel: 2 init:)
		)
		(if (IsFlag 48)
			(bigbody init: setCycle: Fwd cycleSpeed: 300)
			(bigtail init: setCycle: Fwd)
			((ScriptID 501 20) init: setCycle: Fwd cycleSpeed: 50) ; monkswim
			((ScriptID 501 21) init: setStep: 6 4 setCycle: Fwd cycleSpeed: 50) ; monkswim2
			((ScriptID 501 16) init: setStep: 10 8 setCycle: Fwd) ; tinymonk1
			((ScriptID 501 17) init: setStep: 8 5 setCycle: Fwd) ; tinymonk2
			((ScriptID 501 18) init: setCycle: Fwd setStep: 12 10) ; tinymonk3
			((ScriptID 501 19) init: setCycle: Fwd setStep: 6 4) ; tinymonk4
		)
		(if (and (not (IsFlag 54)) (IsFlag 48))
			(bartender stopUpd:)
			(ex1 stopUpd:)
			(ex2 stopUpd:)
			(ex3 stopUpd:)
			(ex4 stopUpd:)
			(ex5 stopUpd:)
			(ex6 stopUpd:)
		)
		(switch gPrevRoomNum
			(510
				(if (and (IsFlag 54) (not (IsFlag 49)))
					(gGame handsOff:)
					(gCurRoom setScript: sEscape self)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sFromDetention self)
				)
			)
			(520
				(gGame handsOff:)
				(switch global124
					(9
						(ClearFlag 62)
						(gCurRoom setScript: sFromTableWQuirk)
						(flo setScript: sDrinking)
					)
					(8
						(SetFlag 62)
						(gCurRoom setScript: sFromTableWSalesman)
						(flo setScript: sDrinking)
					)
					(7
						(SetFlag 62)
						(gCurRoom setScript: sSalesmanToTable)
						(flo setScript: sDrinking)
					)
					(11
						(SetFlag 62)
						(flo init:)
						(drool init:)
						(gEgo
							init:
							view: 501
							setLoop: 3
							cel: 0
							x: 81
							y: 127
							setPri: 8
						)
						(flo setScript: sDrinking)
						(self setScript: sInitRoom)
						(gGame handsOn:)
					)
				)
			)
			(850
				(if (IsFlag 70)
					(self setScript: sFromUpstairs)
				else
					(LoadMany rsVIEW 507)
					(self setScript: sCliffyFight)
				)
			)
			(else
				(gGame handsOff:)
				(if (OneOf global124 0 1 2)
					(gEgo init: view: 500 loop: 0 cel: 0 x: 254 y: 126)
				)
				(switch global124
					(0
						(SetFlag 52)
						(SetFlag 53)
						(LoadMany rsVIEW 500 20 0 515)
						(gCurRoom setScript: sCrewFromEureka)
					)
					(1
						(gCurRoom setScript: sRogerFromEureka)
					)
					(2
						(gCurRoom setScript: sRogerFromEureka)
					)
					(10
						(gCurRoom setScript: sCliffyFight)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 62)
			(switch theVerb
				(3 ; Walk
					(= local24 gMouseX)
					(= local25 gMouseY)
					(gCurRoom setScript: sGetUpFromTable)
					(return 1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
		(if (IsFlag 70)
			(switch theVerb
				(3 ; Walk
					(= local24 gMouseX)
					(= local25 gMouseY)
					(gCurRoom setScript: sFromUpstairs)
					(return 1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
		(return
			(switch theVerb
				(1 ; Look
					(if (not (IsFlag 48))
						(gMessager say: 20 1 0 0) ; "The Nova station is home to this galactically infamous SpaceBar and is the main port of call for ships on liberty in the G6 Quadrant."
					else
						(gMessager say: 20 1 1 0) ; "The atmosphere of the spacebar is growing thick with the pungent smelling bodies of Space Monkeys. It's only a matter of time until the cooling ducts get plugged up. This could soon turn into a dangerous situation."
					)
				)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: (ScriptID 501 30)) ; theTable
		(gWalkHandler delete: (ScriptID 501 3)) ; theStairs
		(gWalkHandler delete: (ScriptID 501 31)) ; theTeleporter
		(gWalkHandler delete: (ScriptID 501 33)) ; theDetention
		(gWalkHandler delete: self)
		(DisposeScript 501)
		(super dispose: &rest)
	)
)

(instance sInitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 54)
					(theMusic3 number: 105 loop: -1 flags: 1 play:)
				else
					(theMusic3 number: 500 loop: -1 flags: 1 play:)
				)
				(gGame handsOff:)
				(if (and (IsFlag 48) (IsFlag 81))
					(gCurRoom overlay: 78)
				)
				(if (and (IsFlag 52) (not (IsFlag 54)))
					((ScriptID 501 22) addToPic:) ; guy1
					((ScriptID 501 25) startUpd:) ; guy1Mouth
					(if (and (IsFlag 48) (not (IsFlag 81)))
						(gSq5Music1 number: 26 loop: -1 play:)
						((ScriptID 501 25) setScript: sGuyTalk) ; guy1Mouth
						(SetFlag 81)
						(gCurRoom overlay: 77)
					else
						((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
					)
					(drool init:)
					(flo init:)
					(if (IsFlag 51)
						(flo setScript: sDrinking)
					)
				)
				(if (IsFlag 50)
					(cliffy init:)
					(Cliffysfriend init:)
				)
				(if (< global125 3)
					(salesman init:)
					(quirk init:)
					(quirkHead init: setScript: sQuirk)
					(alien init:)
				)
				(if (IsFlag 48)
					((ScriptID 501 15) init: setScript: ambientMonkeys) ; smallmonk
					(theMusic4 number: 501 loop: -1 play:)
				)
				(if (== global124 11)
					(SetFlag 62)
				)
				(if (and (IsFlag 54) (not (IsFlag 69)))
					(self setScript: sAliensBeam self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGuyTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 3 0 0 0 self) ; "Who's the moron who let all the dang space monkeys loose!"
			)
			(2
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(self dispose:)
			)
		)
	)
)

(instance sEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 26 loop: -1 play:)
				(theMusic3 number: 105 loop: -1 play:)
				(theMusic4 number: 501 loop: -1 play:)
				(bartender dispose:)
				(gCurRoom overlay: 78)
				(if (IsFlag 54)
					((ScriptID 501 15) init: setScript: ambientMonkeys) ; smallmonk
				)
				(if (not (IsFlag 69))
					(self setScript: sAliensBeam self)
				else
					(= cycles 3)
				)
			)
			(1
				(gEgo
					init:
					view: 517
					setLoop: 0
					cel: 0
					x: 306
					y: 144
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 0
					setCel: 15
					setScale: Scaler 85 85 157 109
					x: 292
					y: 126
				)
				(cliffy
					init:
					view: 20
					loop: 1
					cel: 0
					x: 330
					y: 151
					setPri: 10
					setScale: Scaler 132 38 157 109
					setCycle: StopWalk -1
					setLoop: Grooper
					setMotion: MoveTo 210 151 self
				)
			)
			(3
				(gMessager say: 25 0 0 0 self) ; "I'm hurrying, I'm hurrying!"
			)
			(4
				(cliffy setMotion: MoveTo 214 129 self)
			)
			(5
				(cliffy
					setScale: Scaler 80 80 157 109
					setStep: 6 6
					setMotion: MoveTo 233 119 self
				)
			)
			(6
				(cliffy setMotion: MoveTo 244 118 self)
			)
			(7
				(cliffy
					view: 500
					setLoop: 1
					setCel: 15
					x: 244
					y: 118
					setCycle: Beg self
				)
				(gEgo setCycle: Beg self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(8 0)
			(9
				(cliffy hide:)
				(gEgo hide:)
				(gSq5Music1 fade:)
				(theMusic3 fade:)
				(theMusic4 fade:)
				(SetScore 176 200)
				(= cycles 5)
			)
			(10
				(gCurRoom newRoom: 550)
			)
		)
	)
)

(instance sDrinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(if (< global125 3)
					(= local4
						(switch (Random 1 3)
							(1 drool)
							(2 flo)
							(3 gEgo)
						)
					)
				else
					(= local4
						(switch (Random 1 2)
							(1 drool)
							(2 flo)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(local4 setCycle: End)
				(= seconds (Random 1 3))
			)
			(3
				(local4 setCycle: Beg self)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sQuirk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(quirkHead setCycle: End self)
			)
			(2
				(alien setCycle: Fwd)
				(= seconds (Random 1 4))
			)
			(3
				(alien setCycle: End)
				(= seconds (Random 1 5))
			)
			(4
				(quirkHead setCycle: Beg self)
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sAliensBeam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alien1 init: setLoop: 0 cel: 0 setPri: 10 setCycle: End self)
				(alien2 init: setLoop: 2 cel: 0 setPri: 11 setCycle: End self)
			)
			(1 0)
			(2
				(alien1 setLoop: 1 cel: 15 x: 237 y: 116 setCycle: Beg self)
				(alien2 setLoop: 3 cel: 15 x: 248 y: 126 setCycle: Beg self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(3 0)
			(4
				(alien1 hide: dispose:)
				(alien2 hide: dispose:)
				(= cycles 1)
			)
			(5
				(SetFlag 69)
				(self dispose:)
			)
		)
	)
)

(instance sFromDetention of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 26 loop: -1 play:)
				(gGame handsOff:)
				(self setScript: sInitRoom self)
			)
			(1
				(gGame handsOff:)
				(= cycles 1)
			)
			(2
				(= seconds 1)
			)
			(3
				(NormalEgo 0)
				(gEgo
					init:
					view: 0
					setScale: Scaler 132 38 157 109
					setLoop: 1
					posn: 319 151
					setMotion: MoveTo 210 149 self
				)
			)
			(4
				(if (IsFlag 48)
					(gMessager say: 9 0 0 0 self) ; "The space monkeys are reproducing at an alarming rate."
				else
					(= cycles 1)
				)
			)
			(5
				(ClearFlag 62)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSalesmanToTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				((ScriptID 501 22) addToPic:) ; guy1
				((ScriptID 501 25) startUpd:) ; guy1Mouth
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(SetFlag 51)
				(Cliffysfriend init:)
				(alien init:)
				(quirk init:)
				(quirkHead init: setScript: sQuirk)
				(flo init:)
				(drool init:)
				(cliffy
					init:
					setPri: 7
					setScale: Scaler 132 38 157 109
					view: 20
					loop: 8
					cel: 1
					posn: 174 111
				)
				(gEgo init: view: 501 loop: 3 cel: 0 x: 81 y: 127 setPri: 8)
				((ScriptID 501 27) init: setScript: (ScriptID 501 28)) ; droid, sDroidExit
				(salesman init:)
				(= seconds 3)
			)
			(1
				(salesman setCycle: End self)
			)
			(2
				(salesman
					view: 503
					setLoop: 5
					cel: 0
					x: 216
					y: 114
					setScale: Scaler 132 38 157 109
					setCycle: Fwd
					setMotion: MoveTo 140 128 self
				)
			)
			(3
				(salesman
					setLoop: 1
					cel: 0
					setScale: Scaler 80 80 157 109
					setStep: 6 6
					setMotion: MoveTo 109 125 self
				)
			)
			(4
				(salesman setLoop: 6 cel: 0 setCycle: 0)
				(= seconds 2)
			)
			(5
				(= global125 1)
				(gCurRoom newRoom: 520)
			)
		)
	)
)

(instance sFromTableWQuirk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				((ScriptID 501 22) addToPic:) ; guy1
				((ScriptID 501 25) startUpd:) ; guy1Mouth
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(Cliffysfriend init:)
				(cliffy
					init:
					setPri: 7
					setScale: Scaler 132 38 157 109
					view: 20
					loop: 8
					cel: 1
					posn: 174 111
				)
				(flo init: view: 501 loop: 4 cel: 0 x: 90 y: 124 setPri: 7)
				(drool init: view: 501 loop: 5 cel: 0 x: 55 y: 115 setPri: 8)
				(gEgo
					init:
					view: 520
					setLoop: 1
					cel: 7
					x: 40
					y: 150
					setStep: 7 3
					setPri: 10
				)
				(quirk
					init:
					view: 527
					setLoop: 0
					cel: 0
					x: 48
					y: 145
					setPri: 10
				)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: Fwd setMotion: MoveTo -20 120 self)
				(quirk setCycle: Fwd setMotion: MoveTo -20 110 self)
			)
			(2 0)
			(3
				(= seconds 2)
			)
			(4
				(quirk
					view: 9
					loop: 0
					cel: 0
					x: -10
					y: 48
					setPri: 1
					setLoop: Grooper
					setMotion: MoveTo 58 48 self
				)
			)
			(5
				(NormalEgo 0 0)
				(gEgo
					setHeading: 0
					x: -10
					y: 48
					setMotion: MoveTo 24 48 self
				)
			)
			(6
				(= global124 10)
				(gSq5Music1 fade:)
				(gCurRoom newRoom: 850)
			)
		)
	)
)

(instance sStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 62)
					(= local24 60)
					(= local25 150)
					(self setScript: sGetUpFromTable self)
				else
					(gEgo setMotion: PolyPath 40 150 self)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo
					init:
					view: 520
					setLoop: 1
					cel: 7
					x: 40
					y: 150
					setStep: 7 3
					setScale: 0
					setPri: 10
					setCycle: Fwd
					setMotion: MoveTo -20 120 self
				)
			)
			(2
				(NormalEgo 0 0)
				(gEgo
					init:
					view: 0
					loop: 0
					setScale: 0
					setHeading: 0
					x: -10
					y: 48
					setMotion: MoveTo 58 48 self
				)
				(SetFlag 70)
			)
			(3
				(gGame handsOn:)
				(= global167 2)
				(self dispose:)
			)
		)
	)
)

(instance sFromTableWSalesman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 500 setLoop: -1 play:)
				((ScriptID 501 22) addToPic:) ; guy1
				((ScriptID 501 25) startUpd:) ; guy1Mouth
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(Cliffysfriend init:)
				(cliffy
					init:
					setPri: 7
					setScale: Scaler 132 38 157 109
					view: 20
					loop: 8
					cel: 1
					posn: 174 111
				)
				(flo init:)
				(drool init:)
				(gEgo init: view: 501 loop: 3 cel: 0 x: 81 y: 127 setPri: 8)
				(quirk init:)
				(quirkHead init: setScript: sQuirk)
				(alien init:)
				(salesman
					init:
					view: 503
					setLoop: 0
					cel: 2
					x: 111
					y: 128
					setScale: Scaler 80 80 157 109
				)
				(quirk setScript: sQuirkApproaches)
				(= seconds 2)
			)
			(1
				(salesman setCycle: Fwd setMotion: MoveTo 118 121 self)
			)
			(2
				(salesman setStep: 5 6 setMotion: MoveTo 140 128 self)
			)
			(3
				(salesman
					setStep: 5 2
					setScale: Scaler 132 38 157 109
					setMotion: MoveTo 147 135 self
				)
			)
			(4
				(salesman
					view: 503
					setLoop: 4
					cel: 3
					setMotion: MoveTo 151 139 self
				)
			)
			(5
				(salesman setLoop: 2 cel: 0 setMotion: MoveTo 150 146 self)
			)
			(6
				(salesman setMotion: MoveTo 141 149 self)
			)
			(7
				(salesman setLoop: 5 cel: 0 setMotion: MoveTo 109 162 self)
			)
			(8
				(salesman setLoop: 1 cel: 0 setMotion: MoveTo -20 162 self)
			)
			(9
				(salesman dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sAlienExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alien setLoop: 4 setCycle: End self)
			)
			(1
				(alien
					setLoop: 5
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 325 22 self
				)
			)
			(2
				(alien setCycle: 0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sQuirkApproaches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 53)
				(quirkHead hide: setScript: sAlienExits)
				(quirk view: 506 setLoop: 1 cel: 7 setCycle: End self)
			)
			(1
				(quirk view: 506 setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(quirk
					view: 9
					loop: 0
					cel: 4
					x: 260
					y: 46
					setCycle: Walk
					setMotion: MoveTo 330 46 self
				)
			)
			(3
				(= seconds 5)
			)
			(4
				(quirk
					loop: 1
					x: 322
					y: 152
					setScale: Scaler 132 38 157 109
					setMotion: MoveTo 237 149 self
				)
			)
			(5
				(quirk setMotion: MoveTo 140 128 self)
			)
			(6
				(quirk
					setScale: Scaler 80 80 157 109
					setStep: 6 6
					setMotion: MoveTo 118 119 self
				)
			)
			(7
				(quirk setStep: 5 2 setMotion: MoveTo 108 123 self)
			)
			(8
				(quirk setLoop: 4 cel: 1)
				(= cycles 2)
			)
			(9
				(= global125 2)
				(gCurRoom newRoom: 520)
			)
		)
	)
)

(instance sCrewFromEureka of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 26 loop: -1 play: 0 fade: 127 25 10 0)
				(theMusic3 number: 500 loop: -1 play:)
				(quirk init:)
				(quirkHead init: setScript: sQuirk)
				(alien init:)
				(salesman init:)
				(Cliffysfriend init:)
				((ScriptID 501 22) addToPic:) ; guy1
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(cliffy
					init:
					view: 534
					loop: 2
					posn: 214 129
					setScale: Scaler 132 38 157 109
					setCycle: StopWalk -1
					setLoop: Grooper
				)
				(drool init:)
				(flo init:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo setScale: Scaler 80 80 157 109 setCycle: End self)
			)
			(2
				(SetScore 213 10)
				(= cycles 2)
			)
			(3
				(gMessager say: 7 0 0 0 self) ; "Excuse me, Captain, but I see an 'ol buddy of mine over there by the bar."
			)
			(4
				(cliffy
					setStep: 5 2
					setScale: Scaler 132 38 157 109
					setMotion: MoveTo 174 111 self
				)
			)
			(5
				(NormalEgo 0 1)
				(gEgo
					setHeading: 315
					posn: 254 126
					setMotion: MoveTo 234 119 self
				)
			)
			(6
				(gEgo
					view: 0
					setHeading: 270
					setStep: 5 7
					setMotion: MoveTo 214 129 self
				)
			)
			(7
				(gEgo
					setStep: 6 2
					setPri: 13
					setScale: Scaler 132 38 157 109
					setMotion: MoveTo 180 129 self
				)
			)
			(8
				(= seconds 3)
			)
			(9
				(= global167 0)
				(SetFlag 50)
				(SetFlag 52)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFromEureka of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 26 loop: -1 play: 0 fade: 127 25 10 0)
				(theMusic3 number: 500 loop: -1 play:)
				(gGame handsOff:)
				(self setScript: sInitRoom self)
			)
			(1
				(gGame handsOff:)
				(gEgo setScale: Scaler 80 80 157 109 setCycle: End self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(2
				(NormalEgo 0 1)
				(gEgo
					view: 0
					setHeading: 315
					posn: 254 126
					setScale: Scaler 80 80 157 109
					setMotion: MoveTo 233 119 self
				)
			)
			(3
				(gEgo
					view: 0
					setHeading: 270
					setStep: 5 7
					setMotion: MoveTo 214 129 self
				)
			)
			(4
				(gEgo
					setScale: Scaler 132 38 157 109
					setStep: 6 2
					setPri: 13
					setMotion: MoveTo 180 129 self
				)
			)
			(5
				(= global167 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sQuirkFromNukem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(quirk
					init:
					view: 519
					setLoop: 1
					cel: 0
					x: 0
					y: 100
					setPri: 12
					setCycle: Fwd
					setMotion: MoveTo 57 109 self
				)
			)
			(1
				(quirk
					view: 17
					loop: 0
					cel: 0
					x: 63
					y: 144
					setScale: Scaler 132 38 157 109
					setCycle: StopWalk -1
					setLoop: Grooper
				)
				(= cycles 4)
			)
			(2
				(UnLoad 128 519)
				(self dispose:)
			)
		)
	)
)

(instance sRogerFromNukem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					view: 518
					setLoop: 0
					cel: 0
					x: 0
					y: 126
					setStep: 8 3
					setPri: 13
					setCycle: Fwd
					setScale: Scaler 110 110 157 109
					setMotion: MoveTo 38 156 self
				)
			)
			(1
				(UnLoad 128 518)
				(if (not (IsFlag 70))
					(NormalEgo 0 8)
					(gEgo
						view: 0
						loop: 6
						x: 36
						y: 153
						setStep: 3 2
						setScale: Scaler 132 38 157 109
						setPri: 13
					)
				else
					(NormalEgo 0 8)
					(gEgo
						view: 0
						loop: 0
						x: 36
						y: 153
						setStep: 3 2
						setScale: Scaler 132 38 157 109
						setPri: 13
					)
				)
				(= cycles 2)
			)
			(2
				(= seconds 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFromUpstairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 70)
					(gEgo setMotion: MoveTo -10 48 self)
				else
					(gSq5Music1 number: 26 loop: -1 play: 0 fade: 127 25 10 0)
					(= cycles 1)
				)
			)
			(1
				(self setScript: sRogerFromNukem self)
			)
			(2
				(gEgo
					setStep: 5 2
					setScale: Scaler 132 38 157 109
					setMotion: PolyPath local24 local25
				)
				(ClearFlag 70)
				(= global167 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 70)
				(gEgo setMotion: MoveTo -10 48 self)
			)
			(1
				(self setScript: sRogerFromNukem self)
			)
			(2
				(gEgo
					setStep: 5 2
					setScale: Scaler 132 38 157 109
					setMotion: PolyPath 45 153 self
				)
			)
			(3
				(= global167 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFightNoise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic4 number: [local27 (Random 0 2)] setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sWalkToFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 120 147 self
				)
			)
			(1
				(gEgo
					view: 16
					loop: 8
					cel: 6
					x: 118
					y: 147
					setCycle: 0
					setPri: 13
					stopUpd:
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sCliffyFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 26 loop: -1 play: 0 fade: 127 25 10 0)
				(theMusic3 number: 500 loop: -1 play:)
				(gGame handsOff:)
				(= local26 1)
				(ClearFlag 62)
				((ScriptID 501 22) addToPic:) ; guy1
				(bartender hide: stopUpd:)
				(ex1 stopUpd:)
				(ex2 stopUpd:)
				(ex3 stopUpd:)
				(ex4 stopUpd:)
				(ex5 stopUpd:)
				(ex6 stopUpd:)
				((ScriptID 501 22) addToPic:) ; guy1
				((ScriptID 501 25) setScript: 0) ; guy1Mouth
				(flo init: stopUpd:)
				(drool init: stopUpd:)
				(cliffy
					init:
					view: 507
					setLoop: 0
					cel: 0
					x: 192
					y: 136
					signal: 16384
				)
				(victim init:)
				(guard2 init:)
				(drool setScript: sRogerFromNukem)
				(self setScript: sQuirkFromNukem self)
			)
			(1
				(= seconds 1)
			)
			(2
				(gMessager say: 14 0 0 0 self) ; "|f3|Why you dirty no good..."
			)
			(3
				(cliffy setCycle: CT 3 1 self)
				(theMusic4 number: 5042 loop: 1 play:)
			)
			(4
				(cliffy setCycle: End self)
				(victim setCycle: End self)
			)
			(5 0)
			(6
				(guard2 hide:)
				(victim setLoop: 5 cel: 0 setCycle: End self)
			)
			(7
				(self setScript: sFightNoise)
				(cliffy setLoop: 1 setCycle: Fwd)
				(victim setLoop: 6 cycleSpeed: 10 setCycle: Fwd)
				(quirk setMotion: MoveTo 130 138 self)
				(gEgo setScript: sWalkToFight)
			)
			(8
				(quirk stopUpd:)
				(= cycles 2)
			)
			(9
				(= seconds 3)
			)
			(10
				(gMessager say: 6 0 0 0 self) ; "What's going on here, Cliffy?"
			)
			(11
				(cliffy setCycle: End self)
				(victim setCycle: End self)
			)
			(12 0)
			(13
				(self setScript: 0)
				(cliffy setLoop: 2 cel: 0 setCycle: End self)
				(victim setLoop: 7 cel: 0)
				(guard2 show: setLoop: 8 cel: 0 x: 159 y: 134 setCycle: End)
			)
			(14
				(UnLoad 128 507)
				(Load rsVIEW 5072)
				(= cycles 2)
			)
			(15
				(guard1
					init:
					view: 5072
					setLoop: 11
					cel: 0
					x: 190
					y: 134
					setCycle: End self
				)
				(cliffy view: 5072 setLoop: 9 cel: 0 setCycle: End self)
				(guard2 view: 5072 setLoop: 13 cel: 0 setCycle: End self)
				(victim view: 5072 setLoop: 12 cel: 0 setPri: 13)
			)
			(16 0)
			(17 0)
			(18
				(cliffy
					view: 510
					setLoop: 2
					cel: 0
					x: 193
					y: 135
					setScale: Scaler 104 87 152 135
					setCycle: Fwd
					setMotion: MoveTo 201 152 self
				)
				(guard1
					view: 509
					setLoop: 2
					cel: 0
					x: 208
					y: 136
					setScale: Scaler 103 88 146 133
					setCycle: Fwd
					setMotion: MoveTo 211 146 self
				)
			)
			(19 0)
			(20
				(quirk startUpd:)
				(cliffy setLoop: 3 setMotion: MoveTo 227 153 self)
				(guard1 setLoop: 3 setMotion: MoveTo 236 147 self)
				(victim setScript: (ScriptID 501 11)) ; sVictimExit
				(guard2 setScript: (ScriptID 501 12)) ; sVictimGuardExit
			)
			(21 0)
			(22
				(quirk setScript: sQuirkExit)
				(cliffy setLoop: 0 setMotion: MoveTo 340 153 self)
				(guard1 setLoop: 0 setMotion: MoveTo 340 147 self)
			)
			(23 0)
			(24
				(guard1 setCycle: 0 dispose:)
				(cliffy setCycle: 0 dispose:)
				(= cycles 1)
			)
			(25
				(bartender show: startUpd:)
				(ex1 startUpd:)
				(ex2 startUpd:)
				(ex3 startUpd:)
				(ex4 startUpd:)
				(ex5 startUpd:)
				(ex6 startUpd:)
				(drool startUpd:)
				(flo startUpd: setScript: sDrinking)
				((ScriptID 501 25) setScript: (ScriptID 501 24)) ; guy1Mouth, sGuys
				(= cycles 2)
			)
			(26
				(NormalEgo 0 0)
				(gEgo view: 0 loop: 6 x: 118 y: 147 setPri: 13 startUpd:)
				(= global124 11)
				(SetFlag 49)
				(= global167 0)
				(= local26 0)
				(= cycles 2)
			)
			(27
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sQuirkExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((quirk looper:) dispose:)
				(quirk view: 17 setLoop: 0 setMotion: MoveTo 214 129 self)
			)
			(1
				(quirk
					setScale: Scaler 80 80 157 109
					setStep: 6 6
					setMotion: MoveTo 233 119 self
				)
			)
			(2
				(quirk setMotion: MoveTo 254 126 self)
			)
			(3
				(quirk view: 528 setLoop: 0 cel: 15 setCycle: Beg self)
				(victim setCycle: Beg self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(4 0)
			(5
				(quirk hide:)
				(victim dispose:)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gotoTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== global167 2)
					(= local24 45)
					(= local25 153)
					(self setScript: sFromUpstairs self)
				else
					(= cycles 2)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 140 128 self)
			)
			(2
				(gEgo
					setScale: Scaler 80 80 157 109
					setStep: 6 6
					setMotion: MoveTo 118 119 self
				)
			)
			(3
				(gEgo
					setStep: 6 2
					setHeading: 5
					setMotion: MoveTo 88 127 self
				)
			)
			(4
				(gEgo
					view: 501
					loop: 0
					cel: 0
					x: 81
					y: 127
					setPri: 8
					setScale: 0
					setCycle: End self
				)
			)
			(5
				(= global167 1)
				(SetFlag 62)
				(gCurRoom newRoom: 520)
			)
		)
	)
)

(instance gotoTeleporterFTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 62)
				(gEgo
					view: 501
					setLoop: 0
					setCel: 7
					x: 81
					y: 127
					setPri: 8
					setScale: 0
				)
				(= cycles 1)
			)
			(1
				(gEgo cel: 7 setCycle: CT 4 -1 self)
			)
			(2
				(NormalEgo 0 6)
				(gEgo
					view: 0
					loop: 1
					posn: 88 127
					setStep: 6 2
					setHeading: 45
					setScale: Scaler 80 80 157 109
					setMotion: MoveTo 118 119 self
				)
			)
			(3
				(gEgo setStep: 6 7 setMotion: MoveTo 140 128 self)
			)
			(4
				(gEgo setStep: 6 2 setMotion: MoveTo 214 128 self)
			)
			(5
				(gEgo setStep: 6 6 setMotion: MoveTo 231 119 self)
			)
			(6
				(gEgo setStep: 6 2 setMotion: MoveTo 254 126 self)
			)
			(7
				(gEgo view: 500 loop: 0 cel: 15 setCycle: Beg self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(8
				(if (IsFlag 48)
					(= global124 2)
				else
					(= global124 1)
				)
				(gSq5Music1 fade:)
				(theMusic3 fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance gotoTeleporter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== global167 2)
					(self setScript: sDownTheStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 214 129 self)
			)
			(2
				(gEgo
					setHeading: 90
					setStep: 6 6
					setScale: Scaler 80 80 157 109
					setMotion: MoveTo 233 119 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 254 128 self)
			)
			(4
				(gEgo view: 500 loop: 0 cel: 15 setCycle: Beg self)
				(gSq5Music2 number: 260 setLoop: 1 play:)
			)
			(5
				(if (IsFlag 48)
					(= global124 2)
				else
					(= global124 1)
				)
				(gSq5Music1 fade:)
				(theMusic3 fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sToDetention of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global167
					(2
						(= local24 45)
						(= local25 153)
						(self setScript: sDownTheStairs self)
					)
					(1
						(= local24 180)
						(= local25 149)
						(self setScript: sGetUpFromTable self)
					)
					(0
						(= cycles 1)
					)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 215 149 self)
			)
			(2
				(gEgo setMotion: MoveTo 315 149 self)
				(gSq5Music1 fade:)
				(theMusic3 fade:)
			)
			(3
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sGetUpFromTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 501
					setLoop: 0
					cel: 7
					x: 81
					y: 127
					setPri: 8
					setScale: 0
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: CT 3 -1 self)
			)
			(2
				(NormalEgo 0 6)
				(gEgo
					view: 0
					loop: 6
					posn: 81 127
					setStep: 6 2
					setHeading: 45
					setScale: Scaler 80 80 157 109
					setMotion: MoveTo 118 119 self
				)
			)
			(3
				(gEgo setStep: 6 7 setMotion: MoveTo 140 128 self)
			)
			(4
				(gEgo
					setScale: Scaler 132 38 157 109
					setMotion: PolyPath local24 local25 self
				)
			)
			(5
				(ClearFlag 62)
				(= global167 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ambientMonkeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 6))
			)
			(1
				(= local5 (* (= local5 (Random 0 3)) 4))
				(= cycles 1)
			)
			(2
				(bighead1
					init:
					x: [local7 local5]
					y: [local7 (+ local5 1)]
					setMotion:
						MoveTo
						[local7 (+ local5 2)]
						[local7 (+ local5 3)]
						self
				)
				(bigeyes1 init: setCycle: Fwd cycleSpeed: 100)
			)
			(3
				(= seconds (Random 1 5))
			)
			(4
				(bighead1
					setMotion: MoveTo [local7 local5] [local7 (+ local5 1)] self
				)
			)
			(5
				(bighead1 dispose:)
				(bigeyes1 dispose:)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance quirk of Actor
	(properties
		x 250
		y 43
		noun 15
		view 506
		priority 13
		signal 24576
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 53)
			(self view: 506 loop: 0 cel: 1 x: 250 y: 43)
		)
	)
)

(instance quirkHead of Prop
	(properties
		x 246
		y 17
		view 506
		loop 3
	)
)

(instance alien of Actor
	(properties
		x 266
		y 22
		view 506
		loop 4
		cel 3
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 53)
			(self view: 506 loop: 6 cel: 0 x: 266 y: 22)
		)
	)
)

(instance salesman of Actor
	(properties
		x 218
		y 111
		noun 16
		view 503
		loop 7
		priority 8
		signal 16384
	)
)

(instance guard1 of Actor
	(properties
		x 209
		y 133
		view 507
		loop 9
		cel 1
	)
)

(instance guard2 of Actor
	(properties
		x 143
		y 98
		view 507
		loop 3
		priority 7
		signal 16400
	)
)

(instance victim of Actor
	(properties
		x 160
		y 136
		view 507
		loop 4
		priority 15
		signal 16400
	)
)

(instance cliffy of Actor
	(properties
		x 244
		y 118
		noun 5
		view 500
		loop 1
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 50)
			(cliffy
				view: 20
				loop: 8
				cel: 1
				posn: 174 111
				setCycle: StopWalk -1
				setLoop: Grooper
				setScale: Scaler 132 38 157 109
			)
		)
	)
)

(instance drool of Actor
	(properties
		x 293
		y 126
		view 500
		loop 3
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 52)
			(self view: 501 loop: 1 cel: 0 x: 61 y: 128 setPri: 8 setScale: 0)
		)
		(if (IsFlag 51)
			(self view: 501 setLoop: 5 cel: 0 x: 55 y: 115 setPri: 8)
		)
	)
)

(instance flo of Actor
	(properties
		x 277
		y 118
		view 500
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 52)
			(self view: 501 loop: 2 cel: 0 x: 90 y: 124 setScale: 0 setPri: 7)
		)
		(if (IsFlag 51)
			(self view: 501 setLoop: 4 cel: 0 x: 90 y: 124 setPri: 7)
		)
	)
)

(instance lavaLamp of Prop
	(properties
		x 177
		y 96
		view 502
		priority 5
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(self setLoop: 0 setCycle: Fwd)
		(super init: &rest)
	)
)

(instance lavaglob1 of Actor
	(properties
		x 188
		y 83
		view 502
		loop 1
		cel 3
		priority 4
		signal 16384
		detailLevel 2
	)

	(method (init)
		(self setLoop: 1 cycleSpeed: 12 setCycle: Fwd)
		(super init: &rest)
	)
)

(instance lavaglob2 of Actor
	(properties
		x 220
		y 1
		view 502
		loop 2
		cel 3
		priority 3
		signal 16384
		detailLevel 2
	)

	(method (init)
		(self setLoop: 2 cycleSpeed 12 setCycle: Fwd)
		(super init: &rest)
	)
)

(instance bartender of Actor
	(properties
		view 515
		loop 7
		priority 6
		signal 16400
		detailLevel 2
	)

	(method (init)
		(if (== x 169)
			(= local0 169)
			(= local2 226)
			(= local6 6)
			(self show:)
		else
			(= local0 226)
			(= local2 169)
			(= local6 4)
			(self hide:)
		)
		(self
			setLoop: 7
			setCycle: Fwd
			x: local0
			y: 93
			setPri: local6
			detailLevel: 2
			setMotion: MoveTo local2 93 self
		)
		(super init: &rest)
	)

	(method (cue)
		(self init:)
	)
)

(instance ex1 of Prop
	(properties
		x 141
		y 98
		view 515
		loop 2
		cel 1
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ex2 of Prop
	(properties
		x 149
		y 98
		view 515
		loop 1
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ex3 of Prop
	(properties
		x 259
		y 100
		view 515
		cel 3
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ex4 of Prop
	(properties
		x 111
		y 105
		view 515
		loop 3
		cel 2
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ex5 of Prop
	(properties
		x 247
		y 103
		view 515
		loop 4
		cel 2
		cycleSpeed 15
		detailLevel 2
	)
)

(instance ex6 of Prop
	(properties
		x 123
		y 101
		view 515
		loop 5
		cycleSpeed 15
		detailLevel 2
	)
)

(instance bigbody of Actor
	(properties
		noun 18
		view 504
		loop 1
		priority 15
		signal 18448
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 1)
			(0
				(super init: &rest)
				(= local0 -40)
				(= local1 (Random 10 180))
				(= local2 360)
				(= local3 (Random 10 180))
				(self
					setLoop: 1
					x: local0
					y: local1
					setMotion: MoveTo local2 local3 self
				)
			)
			(1
				(super init: &rest)
				(= local0 360)
				(= local1 (Random 10 180))
				(= local2 -40)
				(= local3 (Random 10 180))
				(self
					setLoop: 0
					x: local0
					y: local1
					setMotion: MoveTo local2 local3 self
				)
			)
		)
	)

	(method (cue)
		(self init:)
		(bigtail init:)
	)
)

(instance bigtail of Prop
	(properties
		view 504
		loop 3
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (== 0 (bigbody loop:))
			(self setLoop: 2)
		else
			(self setLoop: 3)
		)
		(self x: (bigbody x:) y: (- (bigbody y:) 1))
	)

	(method (doit)
		(self x: (bigbody x:) y: (- (bigbody y:) 1))
		(super doit: &rest)
	)
)

(instance bighead1 of Actor
	(properties
		x -20
		y 220
		noun 17
		view 504
		loop 4
		priority 15
		signal 24592
		illegalBits 0
	)

	(method (init)
		(switch local5
			(0
				(self setPri: 15 setLoop: 4 setCel: 0 x: -20 y: 220)
			)
			(4
				(self setPri: 15 setLoop: 5 setCel: 0 x: 340 y: 220)
			)
			(8
				(self setPri: 15 setLoop: 8 setCel: 0 x: -25 y: -25)
			)
			(12
				(self setPri: 15 setLoop: 9 setCel: 0 x: 340 y: -20)
			)
		)
		(super init: &rest)
	)
)

(instance bigeyes1 of Prop
	(properties
		x 30
		y 161
		view 504
		loop 6
		priority 15
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(switch (bighead1 loop:)
			(4
				(self setLoop: 6)
			)
			(5
				(self setLoop: 7)
			)
			(8
				(self setLoop: 8)
			)
			(9
				(self setLoop: 11)
			)
		)
		(self x: (bighead1 x:) y: (bighead1 y:))
	)

	(method (doit)
		(self x: (bighead1 x:) y: (bighead1 y:))
		(super doit: &rest)
	)
)

(instance Cliffysfriend of View
	(properties
		x 162
		y 97
		view 501
		loop 6
		priority 6
		signal 16
	)
)

(instance alien1 of Actor
	(properties
		x 227
		y 118
		view 516
		cel 8
	)
)

(instance alien2 of Actor
	(properties
		x 234
		y 127
		view 516
		loop 1
		cel 6
	)
)

(instance genTalker of Narrator
	(properties
		talkWidth 200
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(switch global122
			(49
				(gSystemWindow tailX: 255 tailY: 130 xOffset: -90 isBottom: 1)
			)
			(9
				(gSystemWindow tailX: 190 tailY: 75 xOffset: -70 isBottom: 1)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

