;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use sHRoom8)
(use Talker)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm230 0
	goToCopier 1
	sExitDoorFromOffice 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 2]
	local9
	local10
	local11
	local12
	local13
	[local14 2]
	local16
	local17
	local18
	local19
	local20
)

(instance rm230 of Room
	(properties
		noun 1
		picture 230
		style 14
		exitStyle 13
		horizon 80
	)

	(method (notify)
		(return
			(cond
				(local6 2)
				(
					(or
						(IsFlag 100)
						(and
							(== (deskSarg view:) 232)
							(== (deskSarg loop:) 3)
							(<= 1 (deskSarg cel:) 4)
						)
						(not local1)
					)
					1
				)
				(local17 3)
				(else 0)
			)
		)
	)

	(method (init)
		(frankyTeller init: franky)
		(= local9 gNarrator)
		(= gNarrator policeNarrator)
		(super init: &rest)
		(if (not (== gPrevRoomNum 50)) ; interrogation
			(gGkMusic1
				number: 230
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 5 0
			)
		)
		(Load rsVIEW 233)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 136 103 160 103 201 96 246 108 269 119 269 106 304 84 288 78 259 78 252 88 128 93
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 1 86 1 125 27 146 200 148 92 93 70 93 58 87 42 87 38 84
					yourself:
				)
		)
		(deskSarg init:)
		(if (not (IsFlag 34))
			((ScriptID 231 11) init:) ; frankCam
			(franky init:)
		else
			(franky init: z: 1000 hide:)
		)
		(if (== gDay 5)
			((ScriptID 231 14) init:) ; drummer
		)
		(switch gPrevRoomNum
			(50 ; interrogation
				(if (== global178 6)
					(if
						(and
							(or (== gDay 4) (== gDay 5))
							local0
							(not (IsFlag 5))
						)
						(gCurRoom setScript: whinerTimerScr)
					)
					(if (and (IsFlag 12) (not (IsFlag 61)))
						(SetFlag 61)
						(gCurRoom setScript: getPhotos)
					else
						(deskSarg setCycle: RandCycle)
						(gEgo normalize: 0 posn: 191 145 init:)
						(if
							(and
								(== gDay 6)
								(not (gEgo has: 18)) ; tracker
								(IsFlag 9)
							)
							(gCurRoom setScript: sargSleeping)
						)
					)
				)
				(mosDoor init:)
				(extDoor init:)
			)
			(240
				(= local6 1)
				(deskSarg setCycle: RandCycle)
				(gEgo
					normalize: 2
					cel: 0
					setCycle: StopWalk -1
					posn: 265 84
					init:
					setMotion: MoveTo 265 90
				)
				(= local20 1)
				(mosDoor cycleSpeed: 12 cel: 4 setCycle: Beg mosDoor init:)
				(cond
					((and (IsFlag 16) (< gDay 6))
						((ScriptID 231 15) ; mosely
							posn: 245 102
							loop: 1
							setSpeed: 3
							setCycle: StopWalk -1
							init:
						)
						(gCurRoom setScript: moselyLeaves)
						((ScriptID 231 0) init: 0) ; sal
					)
					((== gDay 6)
						(gCurRoom setScript: getOuttaHere)
					)
					((IsFlag 245)
						(gCurRoom setScript: sBackFromFiles)
					)
				)
				(if (IsFlag 13)
					(Load rsVIEW 2350)
				)
				(extDoor init:)
			)
			(else
				(if
					(not
						(or
							(IsFlag 100)
							(and
								(== (deskSarg view:) 232)
								(== (deskSarg loop:) 3)
								(<= 1 (deskSarg cel:) 4)
							)
							(not local1)
						)
					)
					(if (IsFlag 11)
						((ScriptID 231 0) init: 1) ; sal
					else
						((ScriptID 231 0) init: 0) ; sal
					)
				)
				(deskSarg setCycle: RandCycle)
				(mosDoor init:)
				(gEgo normalize: init:)
				(cond
					((and (== gDay 6) (IsFlag 298) (not (IsFlag 9)))
						(sGabeEnters next: beignetManShows)
					)
					(
						(and
							(== gDay 6)
							(not ((gInventory at: 18) owner:)) ; tracker
							(IsFlag 9)
						)
						(sGabeEnters next: sargSleeping)
					)
					((and (== gDay 2) (not (IsFlag 420)))
						(SetFlag 420)
						((ScriptID 231 1) init:) ; rep
						(sGabeEnters next: (ScriptID 231 10)) ; repair
					)
				)
				(gCurRoom setScript: sGabeEnters)
			)
		)
		(thermo init:)
		(gate init:)
		((ScriptID 231 20) init:) ; copyTop
		(gEgo state: (| $0002 (gEgo state:)))
		(gFeatures
			add:
				(ScriptID 231 2) ; seal
				inBox
				(ScriptID 231 8) ; franksDesk
				(ScriptID 231 18) ; copier
				(ScriptID 231 3) ; umbrellaStand
				(ScriptID 231 4) ; coatRack
				(ScriptID 231 19) ; bullBoard
				(ScriptID 231 5) ; desk
				(ScriptID 231 6) ; fileCab
				mirror
				(ScriptID 231 9) ; bench
				(ScriptID 231 7) ; windows
			eachElementDo: #init
		)
	)

	(method (dispose)
		(if (gEgo has: 16) ; policeVeve
			(SetFlag 3)
		)
		(if script
			(self setScript: 0)
		)
		(= gNarrator local9)
		(DisposeScript 231)
		(super dispose:)
	)
)

(instance sGabeEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCel: 0
					view: 900
					setLoop: 2
					setCycle: StopWalk -1
					posn: -5 76
					setPri: 1
					setSpeed: 4
					ignoreActors: 1
					setMotion: MoveTo 19 75 self
				)
				(extDoor setCel: 0 init:)
			)
			(1
				(Face gEgo 20 90 0)
				(extDoor setCycle: CT 3 1 self)
			)
			(2
				(gEgo setMotion: MoveTo 22 97)
				(extDoor cycleSpeed: 15 setCycle: End self)
			)
			(3
				(= cycles 6)
			)
			(4
				(extDoor setCycle: Beg self)
				(gEgo setPri: -1 ignoreActors: 0)
			)
			(5
				(gGkSound1 stop:)
				(gGkSound2 number: 374 loop: 1 play:)
				(extDoor cycleSpeed: 8)
				(if (!= next beignetManShows)
					(gGame handsOn:)
				)
				(gEgo normalize: 2)
				(self dispose:)
			)
		)
	)
)

(instance moselyLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mosDoor cycleSpeed: 6 setCycle: Beg self)
			)
			(1
				((ScriptID 231 15) setMotion: PolyPath 176 96 self) ; mosely
			)
			(2
				((ScriptID 231 15) setMotion: MoveTo 134 102 self) ; mosely
			)
			(3
				(gate setLoop: 4 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(4
				((ScriptID 231 15) setMotion: MoveTo 98 102 self) ; mosely
			)
			(5
				(gate setScript: sOscillateGate 0 0)
				((ScriptID 231 15) setMotion: MoveTo 76 102 self) ; mosely
			)
			(6
				(self setScript: outGate self)
			)
			(7
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 50 102 self)
			)
			(8
				(Face gEgo (ScriptID 231 15) self) ; mosely
			)
			(9
				(gMessager sayRange: 23 0 17 1 2 self) ; "Now lay low, and let me handle this!"
			)
			(10
				((ScriptID 231 15) setMotion: PolyPath 10 90 self) ; mosely
			)
			(11
				((ScriptID 231 15) setHeading: 0 self) ; mosely
			)
			(12
				(extDoor setCycle: End self)
			)
			(13
				((ScriptID 231 15) setMotion: MoveTo 10 80 self setPri: 1) ; mosely
			)
			(14
				((ScriptID 231 15) setMotion: MoveTo -12 82 self) ; mosely
				(extDoor setCycle: Beg self)
			)
			(15 0)
			(16
				(gGame handsOn:)
				((ScriptID 231 15) dispose:) ; mosely
				(ClearFlag 100)
				(SetFlag 16)
				(self dispose:)
			)
		)
	)
)

(instance sWalkToFranks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 267 115 self)
			)
			(1
				(Face gEgo franky self)
				(franky view: 238 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(2 0)
			(3
				(gMessager say: 10 11 0 0 self) ; "Excuse me, Officer?"
			)
			(4
				(frankyTeller doVerb: 11 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance askFranky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 267 115 self)
			)
			(1
				(Face gEgo franky self)
			)
			(2
				(franky view: 238 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(if (== register 12)
					(gMessager say: 10 0 register 1 self) ; "Can you tell me anything about this?"
				else
					(gMessager say: 10 10 register 1 self)
				)
			)
			(4
				(franky setCycle: ROsc 100 5 8)
				(if (== register 12)
					(gMessager say: 10 0 register 2 self) ; "Nope."
				else
					(gMessager say: 10 10 register 2 self)
				)
			)
			(5
				(franky setCycle: Beg self)
			)
			(6
				(franky setLoop: 0 1 view: 2380 setCycle: Fwd)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPhotos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2321 setLoop: 1 cel: 0 posn: 191 145 init:)
				(deskSarg
					view: 2321
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: 0
				)
				(= seconds 2)
			)
			(1
				(gMessager say: 23 0 6 1 self) ; "Here's that envelope for ya, Gabriel Knight."
				(deskSarg view: 232 setLoop: 2 setCycle: 0)
			)
			(2
				(deskSarg
					view: 2321
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 7 1 self
				)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(deskSarg setCycle: End self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo normalize: 0)
				(gMessager say: 23 0 6 2 self) ; "Thanks."
			)
			(7
				(gGame handsOn:)
				(gEgo get: 0 getPoints: -999 1) ; phoEnvelope
				(deskSarg
					setCel: 0
					setLoop: 0
					view: 232
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterMosDoorFromLobby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 103 106 self)
			)
			(1
				(if
					(or
						(IsFlag 100)
						(and
							(== (deskSarg view:) 232)
							(== (deskSarg loop:) 3)
							(<= 1 (deskSarg cel:) 4)
						)
						(not local1)
					)
					(gEgo setScript: sInGateWithPermission self)
				else
					(gEgo setScript: sInGateWithoutPermission)
				)
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(mosDoor approachX:)
						(mosDoor approachY:)
						self
				)
			)
			(3
				(gGame handsOn:)
				(mosDoor doVerb: 6)
				(self dispose:)
			)
		)
	)
)

(instance sInGateWithoutPermission of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(deskSarg
					view: 232
					setLoop: 1
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gMessager say: 6 6 (if (IsFlag 16) 21 else 9) 1 self)
				(gEgo
					view: 233
					loop: 0
					cel: 0
					posn: 88 108
					setCycle: End self
				)
			)
			(3
				(if (gEgo cycler:)
					(= ticks 10)
				else
					(gEgo posn: 81 110)
				)
				(gEgo normalize:)
			)
			(4
				(deskSarg
					view: 232
					setLoop: 1
					setCel: 2
					cycleSpeed: 12
					setCycle: Beg
				)
				(gMessager say: 6 6 9 2 self) ; "Oh. Sorry."
			)
			(5
				(deskSarg setLoop: 0 cycleSpeed: 6 setCycle: RandCycle)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInGateWithPermission of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gCurRoom script:) daySixBeignet)
					(daySixBeignet cycles: 200)
				)
				(gate setLoop: 3 cycleSpeed: 12 setCel: 0 setCycle: CT 2 1)
				(gEgo setMotion: MoveTo 138 103 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(self setScript: sOscillateGate self 1)
			)
			(3
				(gEgo normalize:)
				(if (and (not (mosDoor script:)) (!= client getOuttaHere))
					(gGame handsOn:)
				)
				(= local6 1)
				(self dispose:)
			)
		)
	)
)

(instance sExitDoorFromOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 133 103 self)
			)
			(1
				(gCurRoom setScript: outGate self)
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(extDoor approachX:)
						(extDoor approachY:)
						self
				)
			)
			(3
				(gCurRoom setScript: leaveStation)
				(self dispose:)
			)
		)
	)
)

(instance outGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 134 103 self)
			)
			(1
				(if (and (gEgo has: 16) (not (IsFlag 3)) local0) ; policeVeve
					(gMessager say: 6 6 20 1) ; "Don't leave the office area with that file, please."
					(if (== (extDoor script:) sExitDoorFromOffice)
						(extDoor setScript: 0)
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(gate setCel: 0 setLoop: 4 cycleSpeed: 12 setCycle: CT 2 1)
					(gEgo setMotion: MoveTo 100 105 self)
				)
			)
			(2
				(gate setScript: sOscillateGate 0 0)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(= local6 0)
				(self dispose:)
			)
		)
	)
)

(instance sOscillateGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gate cycleSpeed: 6 setCycle: Beg self)
				(gGkSound2 number: 232 loop: 1 play:)
			)
			(1
				(if register
					(gate setLoop: 4)
				else
					(gate setLoop: 3)
				)
				(gate setCel: 1 setCycle: CT 2 1 self)
			)
			(2
				(gate setCycle: Beg self)
			)
			(3
				(if register
					(gate setLoop: 3)
				else
					(gate setLoop: 4)
				)
				(gate setCel: 1)
				(= cycles 1)
			)
			(4
				(gate setCycle: Beg self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance getOuttaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gMessager say: 23 0 15 1 self) ; "!!!Blank msg"
			)
			(2
				(deskSarg setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(gMessager say: 23 0 15 2 self) ; "Hey! Get outta there, you!"
			)
			(4
				(Face gEgo 95 110 self)
			)
			(5
				(if register
					(= cycles 1)
				else
					(gMessager say: 23 0 15 3 self) ; "Sorry. Just looking for a restroom."
				)
			)
			(6
				(gEgo setScript: outGate self)
			)
			(7
				(deskSarg setCycle: Beg self)
			)
			(8
				(deskSarg setLoop: 0 setCycle: RandCycle)
				(self dispose:)
			)
		)
	)
)

(instance sargSleeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 6 9))
			)
			(1
				(deskSarg
					setCel: 0
					setLoop: 3
					cycleSpeed: 16
					setCycle: CT 4 1 self
				)
			)
			(2
				(deskSarg cycleSpeed: 1 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(deskSarg setLoop: 3 cycleSpeed: 18 setCycle: CT 4 1 self)
			)
			(5
				(deskSarg cycleSpeed: 1 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(deskSarg
					setCel: 0
					setLoop: 3
					cycleSpeed: 18
					setCycle: CT 4 1 self
				)
			)
			(8
				(= cycles 220)
			)
			(9
				(deskSarg cycleSpeed: 1 setCycle: End self)
			)
			(10
				(if (and local6 (not (gEgo script:)) (not (mosDoor script:)))
					(self setScript: getOutOfThere self 38)
				else
					(= seconds 1)
				)
			)
			(11
				(deskSarg setLoop: 0 cycleSpeed: 6 setCycle: RandCycle)
				(self init:)
			)
		)
	)
)

(instance whinerTimerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds (Random 1 3))
			)
			(1
				(SetFlag 5)
				(gMessager sayRange: 23 0 11 1 3 self) ; "Has that beignet guy been by yet today? I'm starved."
			)
			(2
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance beignetManShows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 9)
				(= local17 1)
				(if (== gDay 6)
					(gEgo setMotion: PolyPath 62 112 self)
				else
					(= seconds 2)
				)
			)
			(1
				((ScriptID 231 16) ; theVendor
					init:
					setCycle: Walk
					setMotion: MoveTo 97 78 self
				)
				(gGkSound2 number: 234 loop: -1 play:)
			)
			(2
				((ScriptID 231 16) setMotion: MoveTo 150 84 self) ; theVendor
			)
			(3
				(gGkSound2 stop:)
				(deskSarg setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(if (== gDay 6)
					(gMessager say: 23 0 35 1 self) ; "Hey, it's the beignet guy! He's back!"
				else
					(gMessager say: 23 0 10 1 self) ; "(HUNGRY, EXCITED)Hey, it's the beignet guy!"
				)
			)
			(5
				(deskSarg setCycle: Beg self)
			)
			(6
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
				(franky view: 238 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(7
				(franky setCycle: ROsc 100 5 8)
				(if (== gDay 6)
					(gMessager say: 23 0 35 2 self) ; "Where?"
				else
					(gMessager say: 23 0 10 2 self) ; "Great! I'm starved!"
				)
			)
			(8
				(franky setCel: 4 setCycle: Beg self)
			)
			(9
				((ScriptID 231 13) init:) ; chair2
				(franky setCel: 0 view: 238 setLoop: 2 setCycle: End self)
			)
			(10
				(franky
					setCel: 0
					view: 2361
					setLoop: 7
					posn: 290 120
					setCycle: Walk
					ignoreHorizon: 1
					setSpeed: 7
					setMotion: MoveTo 255 110 self
				)
			)
			(11
				(franky setMotion: PolyPath 136 101 self)
			)
			(12
				(franky
					setCel: 0
					view: 239
					setLoop: 1
					setSpeed: 8
					setCycle: End self
				)
				(gate setCel: 0 setLoop: 4 cycleSpeed: 12 setCycle: End)
			)
			(13
				(franky
					setCel: 0
					view: 2361
					loop: 7
					posn: 106 101
					setLoop: -1
					setSpeed: 7
					setCycle: Walk
					setMotion: MoveTo 98 107 self
				)
				(gate setScript: sOscillateGate 0 0)
			)
			(14
				(franky setMotion: PolyPath 4 90 self)
			)
			(15
				(Face franky 4 70 self)
			)
			(16
				(gGkSound1 number: 373 loop: 1 play:)
				(extDoor setCycle: CT 3 1 self)
			)
			(17
				(extDoor setCycle: CT 4 1)
				(franky setPri: 1 setMotion: MoveTo 15 80 self)
			)
			(18
				(extDoor setCycle: CT 3 -1 self)
			)
			(19
				(franky setMotion: MoveTo 60 60)
				(extDoor setCycle: Beg self)
			)
			(20
				(= local0 0)
				(franky setMotion: MoveTo 140 80 self)
				(gGkSound2 number: 374 loop: 1 play:)
			)
			(21
				(deskSarg setCel: 0 setLoop: 1 setCycle: End self)
			)
			(22
				(= seconds 2)
			)
			(23
				(deskSarg setCycle: Beg self)
			)
			(24
				(deskSarg setCel: 0 setLoop: 0 setCycle: RandCycle)
				(= seconds 4)
			)
			(25
				(deskSarg setCel: 0 setLoop: 1 setCycle: End self)
			)
			(26
				(= seconds 2)
			)
			(27
				(deskSarg setCycle: Beg self)
			)
			(28
				((ScriptID 231 12) init:) ; chair1
				(deskSarg setCel: 0 view: 2302 setLoop: 6 setCycle: End self)
				(= local12 0)
				(= local11 0)
			)
			(29
				(deskSarg
					setPri: 95
					setCel: 0
					setLoop: 4
					posn: 240 128
					setCycle: Walk
					setSpeed: 5
					setMotion: MoveTo 174 99 self
				)
			)
			(30
				(deskSarg setCel: 0 setLoop: 1 setMotion: MoveTo 138 99 self)
			)
			(31
				(deskSarg
					setCel: 0
					view: 2301
					setPri: -1
					setLoop: 0
					setCel: 0
					posn: 118 99
					setSpeed: 12
					setCycle: CT 2 1 self
				)
				(gate setLoop: 4 setCel: 1 cycleSpeed: 12 setCycle: End self)
			)
			(32 0)
			(33
				(deskSarg setCycle: End self)
			)
			(34
				(gate setScript: sOscillateGate 0 0)
				(deskSarg
					setCel: 0
					view: 2302
					setLoop: 4
					posn: 93 101
					setCycle: Walk
					setSpeed: 5
					setMotion: MoveTo 21 89 self
				)
			)
			(35
				(gGkSound1 number: 373 loop: 1 play:)
				(extDoor hide:)
				(deskSarg
					setCel: 0
					view: 2303
					setLoop: 1
					setSpeed: 14
					setCycle: End self
				)
			)
			(36
				(if (== gDay 6)
					(deskSarg setCel: 0 setLoop: 3 setCycle: End)
					(gMessager sayRange: 23 0 35 3 5 self) ; "(MRCC)Grab me 3 or 4, would ya?"
				else
					(deskSarg setCel: 0 setLoop: 2 setCycle: End)
					(gMessager say: 23 0 10 3 self) ; "(TO GABRIEL--WARNING HIM NOT TO MOVE WHILE GUARD IS GONE)Stay put, you."
				)
			)
			(37
				(if (== gDay 6)
					(client setScript: daySixBeignet)
				else
					(deskSarg setCel: 0 setLoop: 3 setCycle: End)
					(gMessager sayRange: 23 0 10 4 5 self) ; "Hey! Grab me three, wouldya?"
				)
			)
			(38
				(deskSarg setCel: 2 setCycle: Beg self)
			)
			(39
				(client setScript: comeBackIn)
			)
		)
	)
)

(instance comeBackIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extDoor setCel: 4 show: setCycle: Beg self)
				(deskSarg
					setCel: 0
					view: 2302
					setLoop: 2
					setCycle: Walk
					setSpeed: 9
					setMotion: PolyPath 108 105 self
				)
			)
			(1
				(gGkSound2 number: 374 loop: 1 play:)
			)
			(2
				(gate setCel: 0 setLoop: 3 cycleSpeed: 12 setCycle: CT 2 1)
				(deskSarg setCel: 0 setLoop: 0 setMotion: MoveTo 134 103 self)
			)
			(3
				(gate setScript: sOscillateGate 0 1)
				(deskSarg setPri: 95 setMotion: MoveTo 174 99 self)
			)
			(4
				(deskSarg setCel: 0 setLoop: 2 setMotion: MoveTo 230 132 self)
			)
			(5
				(deskSarg
					setLoop: 6
					setCel: 3
					setPri: 130
					posn: 252 118
					setCycle: Beg self
				)
			)
			(6
				((ScriptID 231 12) dispose:) ; chair1
				(deskSarg setCel: 0 view: 232 setLoop: 0 setCycle: RandCycle)
				(= seconds 1)
			)
			(7
				(franky
					setCel: 0
					view: 2361
					setCycle: Walk
					setLoop: 1 1
					setMotion: MoveTo 18 75 self
				)
				(= local0 1)
			)
			(8
				(franky
					view: (if (!= gDay 6) 2363 else 2361)
					setLoop: -1
					setHeading: 180 self
				)
			)
			(9
				(extDoor setCycle: End self)
				(gGkSound1 number: 373 loop: 1 play:)
			)
			(10
				(franky setPri: -1 setMotion: MoveTo 16 89 self)
			)
			(11
				(franky setLoop: 2)
				(= cycles 2)
			)
			(12
				(extDoor setCycle: CT 3 -1 self)
				(franky setLoop: 4 setMotion: MoveTo 30 102 self)
			)
			(13
				(extDoor setCycle: Beg self)
			)
			(14 0)
			(15
				(gGkSound2 number: 374 loop: 1 play:)
				(franky setMotion: MoveTo 106 102 self)
			)
			(16
				(gate setCel: 0 setLoop: 3 cycleSpeed: 12 setCycle: CT 2 1)
				(franky
					setCel: 0
					view: (if (!= gDay 6) 2391 else 239)
					setLoop: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(17
				(franky
					posn: 125 102
					setCel: 0
					view: (if (!= gDay 6) 2363 else 2361)
					setCycle: Walk
					loop: 4
					setPri: 95
					setMotion: MoveTo 170 103 self
				)
				(gate setScript: sOscillateGate 0 1)
			)
			(18
				(if (!= gDay 6)
					(franky setMotion: MoveTo 232 127 self)
				else
					(+= state 4)
					(franky setMotion: MoveTo 288 120 self)
				)
			)
			(19
				(franky
					view: 2391
					setCel: 0
					setLoop: 1
					setSpeed: 12
					setCycle: End self
				)
			)
			(20
				(deskSarg
					setCel: 0
					view: 2391
					setLoop: 2
					setSpeed: 14
					setCycle: CT 5 1 self
				)
			)
			(21
				(gMessager say: 23 0 10 6 self) ; "Thanks!"
				(franky
					setCel: 0
					view: 2361
					setCycle: Walk
					setSpeed: 6
					setLoop: 4
				)
				(deskSarg setCel: 6 setCycle: End self)
			)
			(22 0)
			(23
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
				(franky setMotion: MoveTo 288 120 self)
			)
			(24
				(franky
					setCel: 0
					setLoop: 0
					view: 238
					posn: 301 118
					setPri: -1
					setCycle: End self
				)
			)
			(25
				((ScriptID 231 13) dispose:) ; chair2
				(franky setCel: 0 setLoop: 0 view: 2380 setCycle: RandCycle)
				(= local17 0)
				(if
					(and
						(not
							(or
								(IsFlag 100)
								(and
									(== (deskSarg view:) 232)
									(== (deskSarg loop:) 3)
									(<= 1 (deskSarg cel:) 4)
								)
								(not local1)
							)
						)
						(IsFlag 11)
					)
					((ScriptID 231 0) init: 1) ; sal
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance daySixBeignet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo deskSarg self)
			)
			(1
				(deskSarg setCel: 0 setLoop: 2 setCycle: End self)
				(gMessager say: 23 0 35 6 self) ; "(TO GABE. WARNING HIM NOT TO MOVE WHILE GUARD IS GONE)You stay put. I'll be back in a minute."
			)
			(2
				(deskSarg
					setCel: 0
					view: 2302
					setPri: 1
					setLoop: 4
					heading: 130
					posn: 13 87
					setMotion: MoveTo 8 80
				)
				(UpdateScreenItem deskSarg)
				(extDoor setCel: 5 show: setCycle: Beg self)
			)
			(3
				(gGkSound2 number: 374 loop: 1 play:)
				(deskSarg setCel: 0 setLoop: 5 setMotion: MoveTo 40 70 self)
				(gGame handsOn:)
			)
			(4
				(deskSarg dispose:)
				(= cycles 220)
			)
			(5
				(if (not (gGame isHandsOn:))
					(-- state)
				else
					(gGame handsOff:)
				)
				(= cycles 1)
			)
			(6
				(if (InRect 0 80 125 110 (gEgo x:) (gEgo y:))
					(gEgo setMotion: PolyPath (gEgo x:) 120)
				)
				(deskSarg
					setCel: 0
					view: 2302
					setLoop: 3
					init:
					setPri: 1
					setCycle: Walk
					posn: 40 70
					setMotion: MoveTo 10 80 self
				)
			)
			(7
				(extDoor setCel: 0 setCycle: CT 3 1 self)
				(gGkSound2 number: 373 loop: 1 play:)
			)
			(8
				(Face gEgo deskSarg)
				(deskSarg
					setCel: 0
					loop: 2
					setPri: -1
					setMotion: MoveTo 7 87 self
					cel: 1
				)
			)
			(9
				(if local6
					(client setScript: getOutOfThere self 36)
				else
					(comeBackIn next: sargSleeping)
					(client setScript: comeBackIn)
				)
			)
		)
	)
)

(instance getOutOfThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo view:) 900)
					(gEgo normalize: 3)
					(Face gEgo deskSarg self)
				else
					(self cue:)
				)
			)
			(1
				(gMessager say: 23 0 register 0 self)
			)
			(2
				(self setScript: outGate self)
			)
			(3
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 130 140 self)
			)
			(4
				(Face gEgo 140 135 self)
			)
			(5
				(if (== register 36)
					(client setScript: comeBackIn)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance goToMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 292 79 self)
			)
			(1
				(Face gEgo 299 80 self)
			)
			(2
				(gEgo
					setCel: 0
					view: 234
					setLoop: 1
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(if (== register 7)
					(gMessager say: 17 7 0 1 self) ; "(RRCC. VAIN--TO SELF. LOOKING IN MIRROR)Lookin' good, kid."
				else
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(if (== register 7)
					(= cycles 1)
				else
					(goIntoMosOffice start: 2)
					(client setScript: goIntoMosOffice)
				)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gGame handsOn:)
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance goIntoMosOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 284 85 self)
			)
			(1
				(Face gEgo 273 83 self)
			)
			(2
				(if (== register 44)
					(gEgo getPoints: 193 2)
				)
				(if (and (IsFlag 16) (== register 8))
					(gMessager say: 7 6 14 1 self) ; "The door is locked."
				else
					(= local6 0)
					(mosDoor setCycle: End)
					(gEgo
						setCel: 0
						view: 234
						setLoop: 3
						posn: 284 85
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(3
				(cond
					((and (IsFlag 16) (== register 8))
						(gGame handsOn:)
						(gEgo normalize:)
						(self dispose:)
					)
					((IsFlag 34)
						(gMessager say: 7 8 12 0 self) ; "Would you just get in here!"
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(gEgo normalize:)
				(gGkMusic1 fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance franksGetsFile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(gEgo setSpeed: 12)
				(gMessager sayRange: 28 100 55 1 4 self) ; "Can you get a file for me?"
			)
			(2
				(franky setCel: 0 setLoop: 2 view: 238 setCycle: End self)
			)
			(3
				(franky
					setCel: 0
					setLoop: 6 1
					view: 2361
					posn: 290 120
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 293 85 self
				)
			)
			(4
				(franky
					setCel: 0
					view: 2381
					setLoop: 0
					posn: 293 85
					setSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(5
				(franky setCycle: End self)
				(gGkSound1 number: 236 setLoop: 1 play:)
			)
			(6
				(franky setCycle: Beg self)
			)
			(7
				(franky
					setCel: 0
					view: 2383
					setSpeed: 7
					setLoop: 2 1
					setCycle: Walk
					setMotion: MoveTo 301 118 self
				)
			)
			(8
				(franky
					setCel: 0
					view: 238
					setLoop: 0 1
					setSpeed: 12
					setCycle: End self
				)
				(gEgo setMotion: MoveTo 282 129 self)
			)
			(9 0)
			(10
				(franky hide:)
				(gEgo
					setCel: 5
					view: 2383
					setLoop: 0 1
					setPri: 135
					setCycle: CT 3 -1 self
				)
			)
			(11
				((ScriptID 231 22) dispose:) ; folder
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo get: 16 getPoints: -999 2 normalize: 6) ; policeVeve
				(franky show:)
				(gMessager say: 28 100 55 5 self) ; "There it is. You can look at it all you want, but don't leave this area with it, okay? And no photocopies either, I'm afraid."
			)
			(13
				(franky setCel: 0 setLoop: 0 1 view: 2380 setCycle: Fwd)
				(gMessager say: 28 100 55 6 self) ; "Of course. I understand completely."
			)
			(14
				(gEgo setMotion: MoveTo 267 115 self)
			)
			(15
				(gEgo setHeading: 130 self)
			)
			(16
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackFromFiles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 245)
				(gGame handsOff:)
				(franky
					setCel: 0
					view: 2361
					setLoop: 6
					posn: 293 85
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 301 118 self
				)
			)
			(1
				(franky setCel: 0 view: 238 setLoop: 0 setCycle: End self)
			)
			(2
				(franky setCel: 0 setLoop: 0 1 view: 2380 show: setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToCopier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(cond
					((IsFlag 3)
						(gMessager say: 8 48 24 1 self) ; "(RRCC)It's too late to copy the file now--Gabriel left the station with it! It would be better not to let anyone here see it at this point."
					)
					(local0
						(Face gEgo franky)
						(gMessager say: 8 48 30 1 self) ; "I told you, you can't photocopy official police files."
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					((IsFlag 3)
						(gGame handsOn:)
						(self dispose:)
					)
					(local0
						(gEgo setMotion: PolyPath 227 107 self)
					)
					(else
						(client setScript: (ScriptID 231 17)) ; useXerox
					)
				)
			)
			(3
				(= cycles 3)
			)
			(4
				(gEgo setSpeed: 0)
				(gMessager say: 8 48 30 2 self) ; "Right. Sorry. I forgot."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putVeveInBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 267 115 self)
			)
			(1
				(gEgo setMotion: MoveTo 276 120 self)
			)
			(2
				(= cycles 4)
			)
			(3
				(gEgo
					view: 235
					setCel: 0
					setLoop: 0
					setPri: 135
					setSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(4
				((ScriptID 231 22) init:) ; folder
				(gEgo put: 16 normalize: 4 setSpeed: 0) ; policeVeve
				(= cycles 3)
			)
			(5
				(if local0
					(gMessager say: 15 48 27 0 self) ; "I'm done."
				else
					(if (IsFlag 2)
						(gEgo getPoints: 124 1)
					)
					(= cycles 1)
				)
			)
			(6
				(gEgo setMotion: MoveTo 267 115 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowStuffToSarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 1)
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 191) (!= (gEgo y:) 145))
					(gEgo setMotion: PolyPath 191 145 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== register 64)
					(= local13 0)
					(= cycles 1)
				else
					(gEgo
						view: 904
						setCel: 0
						setLoop: 0
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(2
				(gMessager say: 26 0 52 1 self) ; "Does this mean anything to you?"
			)
			(3
				(deskSarg view: 232 setCel: 0 setLoop: 1 setCycle: End self)
				(= local12 1)
				(= local11 232)
			)
			(4
				(= cycles 1)
			)
			(5
				(if (and gMsgType (Message msgGET 230 11 register 0 1))
					(gMessager say: 11 register 0 0 self)
				else
					(gMessager say: 11 0 0 0 self) ; "Nope."
				)
			)
			(6
				(deskSarg setCel: 2 view: 232 setLoop: 1 setCycle: Beg self)
			)
			(7
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
				(if (== register 64)
					(= cycles 1)
				else
					(gEgo
						view: 904
						setCel: 9
						setLoop: 0
						cycleSpeed: 12
						setCycle: Beg self
					)
				)
			)
			(8
				(gEgo normalize:)
				(= local13 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance askSergeant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== (deskSarg view:) 232)
						(== (deskSarg loop:) 3)
						(<= 1 (deskSarg cel:) 4)
					)
					(gGame handsOn:)
					(gMessager say: 11 11 39 0) ; "Don't ruin the man's nap!"
					(self dispose:)
				else
					(deskSarg view: 232 setCel: 2 setLoop: 1 setCycle: End self)
					(= local12 1)
					(= local11 232)
				)
			)
			(1
				(if (IsFlag 98)
					(gMessager say: 11 10 2 0 self) ; "Can I bother you again, Officer?"
				else
					(SetFlag 98)
					(gMessager say: 11 10 1 0 self) ; "Got a second, Officer?"
				)
			)
			(2
				(= global178 6)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance talkToSergeant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ local4)
					(1
						(= register 40)
					)
					(2
						(= register 41)
					)
					(3
						(= register 42)
					)
					(else
						(= register 43)
					)
				)
				(gMessager say: 11 11 register 0 self)
			)
			(1
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
				(gEgo setCel: 0 normalize: 0)
				(if
					(and
						(not (IsFlag 9))
						(< gDay 4)
						local0
						(not global181)
					)
					(gCurRoom setScript: beignetManShows)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance deskSarg of Actor
	(properties
		noun 11
		sightAngle 30
		approachX 191
		approachY 145
		x 252
		y 118
		priority 11
		view 232
		signal 24609
	)

	(method (init)
		(= local1 1)
		(self setPri: 130 setStep: 5 3)
		(super init: &rest)
	)

	(method (dispose)
		(= local1 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if local6
			(self approachVerbs:)
		else
			(self approachVerbs: 11 10) ; Talk, Ask
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(cond
				(local6
					(gMessager say: noun 10 12 0) ; "Gabriel should go to the counter to talk to the desk sergeant."
				)
				((!= (deskSarg view:) 232)
					(gMessager say: noun 0 68 0) ; "(RRCC)Officer Frick seems to be in no mood for further interaction with Gabriel."
				)
				((OneOf theVerb 44 61 86 45) ; mosKey, mosLetter, master_card, tracker
					(gMessager say: noun theVerb 0 0)
				)
				((and (>= gDay 7) (not (IsFlag 408)))
					(SetFlag 408)
					(gMessager say: noun 0 67 0) ; "(GK-AM1. POLITE)Excuse me, Officer Frick...."
				)
				((>= gDay 7)
					(gMessager say: noun 0 68 0) ; "(RRCC)Officer Frick seems to be in no mood for further interaction with Gabriel."
				)
				((OneOf theVerb 48 24 79 56) ; policeVeve_, veveCopy, badge, keyEnvelope
					(gMessager say: noun theVerb 0 0)
				)
				(else
					(gCurRoom setScript: sShowStuffToSarg 0 theVerb)
				)
			)
			(return 1)
		else
			(switch theVerb
				(7 ; Look
					(if
						(and
							(== (deskSarg view:) 232)
							(== (deskSarg loop:) 3)
							(<= 1 (deskSarg cel:) 4)
						)
						(gMessager say: noun theVerb 39 0) ; "Officer Frick drools only slightly as he nods off."
					else
						(gMessager say: noun theVerb 0 0) ; "The desk sergeant looks like a poster boy for heart disease--30 extra pounds between his armpits and his belt, and a complexion the consistency of gray oatmeal."
					)
				)
				(11 ; Talk
					(cond
						((and (>= gDay 7) (not (IsFlag 408)))
							(SetFlag 408)
							(gMessager say: noun 0 67 0) ; "(GK-AM1. POLITE)Excuse me, Officer Frick...."
						)
						((>= gDay 7)
							(gMessager say: noun 0 68 0) ; "(RRCC)Officer Frick seems to be in no mood for further interaction with Gabriel."
						)
						((== gDay 6)
							(gMessager say: noun theVerb 71 0) ; "(RRCC. INSISTENT)I think we should talk about what's going on around here, Officer Frick."
						)
						(
							(and
								(== (deskSarg view:) 232)
								(== (deskSarg loop:) 3)
								(<= 1 (deskSarg cel:) 4)
							)
							(gMessager say: noun theVerb 39 0) ; "Don't ruin the man's nap!"
						)
						(local6
							(gMessager say: noun 10 12 0) ; "Gabriel should go to the counter to talk to the desk sergeant."
						)
						(else
							(gCurRoom setScript: talkToSergeant)
						)
					)
				)
				(10 ; Ask
					(cond
						((and (>= gDay 7) (not (IsFlag 408)))
							(SetFlag 408)
							(gMessager say: noun 0 67 0) ; "(GK-AM1. POLITE)Excuse me, Officer Frick...."
						)
						((>= gDay 7)
							(gMessager say: noun 0 68 0) ; "(RRCC)Officer Frick seems to be in no mood for further interaction with Gabriel."
						)
						(local6
							(gMessager say: noun theVerb 12 0) ; "Gabriel should go to the counter to talk to the desk sergeant."
						)
						(
							(and
								(== (deskSarg view:) 232)
								(== (deskSarg loop:) 3)
								(<= 1 (deskSarg cel:) 4)
							)
							(gMessager say: 11 11 39 0) ; "Don't ruin the man's nap!"
						)
						(else
							(gCurRoom setScript: askSergeant)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance franky of Actor
	(properties
		noun 10
		sightAngle 30
		x 301
		y 118
		view 2380
		signal 28705
	)

	(method (init)
		(if (not (IsFlag 34))
			(= local0 1)
		)
		(self setStep: 6 2)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(= local0 0)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(if local6
				(switch theVerb
					(48 ; policeVeve_
						(if (IsFlag 3)
							(gMessager say: noun theVerb 24 1) ; "It's too late to return the file."
						else
							(self setScript: putVeveInBox)
						)
					)
					(24 ; veveCopy
						(gMessager say: noun theVerb 0 0) ; "Gabriel would be wiser not to flaunt that photocopy around here."
					)
					(else
						(gCurRoom setScript: askFranky 0 12)
					)
				)
			else
				(gMessager say: noun 0 13 0) ; "Gabriel can't do anything with the officer from the front lobby."
			)
			(return 1)
		else
			(switch theVerb
				(10 ; Ask
					(if local6
						(cond
							((IsFlag 3)
								(= temp0 44)
							)
							((IsFlag 97)
								(= temp0 5)
							)
							((not (IsFlag 97))
								(SetFlag 97)
								(= temp0 3)
							)
						)
						(gCurRoom setScript: askFranky 0 temp0)
					else
						(gMessager say: noun theVerb 4 0) ; "Gabriel can't do anything with the officer from the front lobby."
					)
				)
				(7 ; Look
					(if (IsFlag 3)
						(= temp0 24)
					else
						(= temp0 0)
					)
					(gMessager say: noun theVerb temp0 1)
				)
				(12 ; Pickup
					(if local6
						(super doVerb: theVerb)
					else
						(gMessager say: noun 12 13 0) ; "Gabriel can't do anything with the officer from the front lobby."
					)
				)
				(else
					(if local6
						(super doVerb: theVerb)
					else
						(gMessager say: noun 0 13 0) ; "Gabriel can't do anything with the officer from the front lobby."
					)
				)
			)
		)
	)
)

(instance mosDoor of Prop
	(properties
		noun 7
		sightAngle 40
		approachX 290
		approachY 88
		x 250
		y 76
		view 2300
		loop 1
		cycleSpeed 12
	)

	(method (handleEvent)
		(if local6
			(self approachVerbs: 44 6 8) ; mosKey, Open, Operate
		else
			(self approachVerbs:)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Open
			(= theVerb 8) ; Operate
		)
		(switch theVerb
			(7 ; Look
				(super doVerb: theVerb)
			)
			(8 ; Operate
				(if local6
					(cond
						((and (gEgo has: 16) (not (IsFlag 3))) ; policeVeve
							(gMessager say: noun theVerb (if local0 20 else 34))
						)
						((IsFlag 16)
							(self setScript: goIntoMosOffice 0 8)
						)
						(else
							(self setScript: goToMirror 0 theVerb)
						)
					)
				else
					(self setScript: sEnterMosDoorFromLobby)
				)
			)
			(44 ; mosKey
				(if local6
					(self setScript: goIntoMosOffice 0 44)
				else
					(gMessager say: noun 44 13 1) ; "Gabriel can't do anything with that door from the lobby."
				)
			)
			(else
				(if local6
					(super doVerb: theVerb)
				else
					(gMessager say: 7 0 13 0) ; "Gabriel can't do anything with that door from the lobby."
				)
			)
		)
	)

	(method (cue)
		(if local20
			(= local20 0)
			(gGkSound2 number: 248 loop: 1 play:)
		)
	)
)

(instance gate of Prop
	(properties
		noun 6
		sightAngle 40
		x 105
		y 92
		view 2300
		loop 3
		signal 16417
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 6 9 8 setPri: 94) ; Open, Move, Operate
	)

	(method (handleEvent event)
		(if local6
			(= approachX 133)
			(= approachY 103)
		else
			(= approachX 103)
			(= approachY 106)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 9 8) ; Open, Move, Operate
			(gGame handsOff:)
			(cond
				(local6
					(gCurRoom setScript: outGate)
				)
				(
					(or
						(IsFlag 100)
						(and
							(== (deskSarg view:) 232)
							(== (deskSarg loop:) 3)
							(<= 1 (deskSarg cel:) 4)
						)
						(not local1)
					)
					(self setScript: sInGateWithPermission)
				)
				(else
					(self setScript: sInGateWithoutPermission)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance inBox of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 282
		approachY 129
		x 302
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 99 302 95 313 101 304 103
					yourself:
				)
		)
		(if
			(and
				(not (gEgo has: 16)) ; policeVeve
				(not (IsFlag 159))
				(IsFlag 13)
				(not (IsFlag 3))
			)
			((ScriptID 231 22) init:) ; folder
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (gCast contains: (ScriptID 231 22)) ; folder
					(gMessager say: noun theVerb 18 0) ; "It's an in box."
				else
					(gMessager say: noun theVerb 19 0) ; "It's an in box."
				)
			)
			(12 ; Pickup
				(if local6
					(cond
						((gEgo has: 16) ; policeVeve
							(gMessager say: noun theVerb 19 1) ; "There's nothing of interest in the in box at the moment."
						)
						((IsFlag 2)
							(gMessager say: noun theVerb 32 1) ; "Gabriel already has everything he needs from that file."
						)
						((and local0 (IsFlag 13))
							(gCurRoom setScript: (ScriptID 231 23) 0 18) ; grabOriginalVeve
						)
						((IsFlag 13)
							(gCurRoom setScript: (ScriptID 231 23) 0 26) ; grabOriginalVeve
						)
						(else
							(gMessager say: noun theVerb 19 1) ; "There's nothing of interest in the in box at the moment."
						)
					)
				else
					(gMessager say: 0 0 13 1) ; "Gabriel can't do that from the front lobby."
				)
			)
			(48 ; policeVeve_
				(cond
					((not local6)
						(gMessager say: 0 0 13 1) ; "Gabriel can't do that from the front lobby."
					)
					((IsFlag 3)
						(gMessager say: noun 48 24 1) ; "It's too late to return the file."
					)
					(else
						(gCurRoom setScript: putVeveInBox)
					)
				)
			)
			(24 ; veveCopy
				(gMessager say: 1 theVerb 0 0) ; "Gabriel would be wiser not to flaunt that photocopy around here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirror of Feature
	(properties
		noun 17
		nsLeft 296
		nsTop 22
		nsRight 319
		nsBottom 42
		sightAngle 40
		approachX 311
		approachY 85
		approachDist 53
		x 307
		y 32
	)

	(method (handleEvent)
		(if local6
			(self approachVerbs: 7 10 11) ; Look, Ask, Talk
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if local6
					(if (IsFlag 16)
						(gMessager say: noun 9 0 1) ; "The mirror is built into the wall."
					else
						(gCurRoom setScript: goToMirror 0 theVerb)
					)
				else
					(gMessager say: noun 7 13 0) ; "Gabriel can't do anything with the mirror from where he's standing."
				)
			)
			(else
				(if local6
					(super doVerb: theVerb)
				else
					(gMessager say: noun 0 13 0) ; "Gabriel can't do anything with the mirror from where he's standing."
				)
			)
		)
	)
)

(instance thermo of View
	(properties
		noun 19
		sightAngle 36
		approachX 259
		approachY 85
		x 241
		y 34
		view 2342
		loop 2
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (!= gDay 2)
			(self setPri: 88)
		else
			(self setPri: 0)
		)
	)

	(method (handleEvent event)
		(if (gCast contains: (ScriptID 231 1)) ; rep
			(return 0)
		else
			(if local6
				(self approachVerbs: 7 8 12) ; Look, Operate, Pickup
			else
				(self approachVerbs:)
			)
			(super handleEvent: event)
			(return)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (!= gDay 2)
					(gMessager say: noun theVerb 64 0) ; "There's a temperature gauge on the wall near Mosely's office."
				else
					(gMessager say: noun theVerb 66 0) ; "There's a temperature gauge on the wall near Mosely's office."
				)
			)
			(8 ; Operate
				(cond
					((and (== gDay 2) (IsFlag 99))
						(gMessager say: noun theVerb 45 1) ; "Gabriel decides to give Mosely a break and not change the temperature again."
					)
					(local6
						(gCurRoom setScript: (ScriptID 231 21)) ; turnUpHeat
					)
					(else
						(gMessager say: noun theVerb 13 1) ; "Gabriel can't do that from the front lobby."
					)
				)
			)
			(12 ; Pickup
				(if local6
					(gMessager say: noun theVerb 0 1) ; "The gauge is fixed in place."
				else
					(gMessager say: noun 0 13) ; "Gabriel can't do that from the front lobby."
				)
			)
			(else
				(if local6
					(super doVerb: theVerb)
				else
					(gMessager say: noun 8 13 1) ; "Gabriel can't do that from the front lobby."
				)
			)
		)
	)
)

(instance frankyTeller of GKTeller
	(properties
		curNoun 27
		sayNoun 28
		verb 100
	)

	(method (showCases)
		(super
			showCases:
				55 ; Can you get a file for me?
				(and (IsFlag 75) (not (IsFlag 13)))
				54 ; So, what's it like being a policewoman?
				(not (IsFlag 467))
				53 ; You know, that uniform looks great on you.
				(and (IsFlag 467) (not (IsFlag 468)))
				57 ; Are you sure I can't make a copy of this file?
				(and (gEgo has: 16) (not (IsFlag 3))) ; policeVeve
				56 ; Could you get me some coffee?
				1
		)
	)

	(method (cue)
		(switch iconValue
			(54 ; So, what's it like being a policewoman?
				(SetFlag 467)
				(self doVerb: 11 0)
			)
			(53 ; You know, that uniform looks great on you.
				(SetFlag 468)
				(self doVerb: 11 0)
			)
			(56 ; Could you get me some coffee?
				(if local16
					(= iconValue 59) ; "(SARCASTIC)I can give you precise instructions for the handling of hot liquids if you need them."
				else
					(= iconValue 58) ; "(DISBELIEVING)Are YOU speaking to ME?"
				)
				(self sayMessage:)
				(++ local16)
			)
			(58 ; "(DISBELIEVING)Are YOU speaking to ME?"
				(self doVerb: 11 0)
			)
			(59 ; "(SARCASTIC)I can give you precise instructions for the handling of hot liquids if you need them."
				(self doVerb: 11 0)
			)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(55 ; Can you get a file for me?
				(SetFlag 13)
				(gCurRoom setScript: franksGetsFile)
			)
			(else
				(super sayMessage:)
			)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(if (and local6 (== theVerb 11)) ; Talk
			(cond
				((IsFlag 3)
					(gMessager say: 10 11 24 0) ; "Officer Franks looks too miffed about that file incident to talk to Gabriel."
				)
				((and (== argc 2) invItem)
					(SetCursor -2)
					(= temp0
						(gGame
							setCursor: ((ScriptID 0 1) view: 999 yourself:) ; globeCursor
						)
					)
					(while 1
						(if (self respond:)
							(break)
						)
					)
					(gGame setCursor: temp0)
					(SetCursor 0 0 319 155)
				)
				((== argc 2)
					(gGame handsOn:)
				)
				(else
					(gCurRoom setScript: sWalkToFranks)
				)
			)
			(return 1)
		else
			(return (client doVerb: theVerb))
		)
	)
)

(instance policeNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(6 60)
				(8 30)
				(7 47)
				(else global220)
			)
		)
		(switch global180
			(1
				(if
					(and
						(or (== (gEgo view:) 901) (== (gEgo view:) 900))
						(== (gEgo loop:) 8)
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
					(= local18 (gEgo cycleSpeed:))
					(gEgo oldCel: (gEgo cel:))
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldCel: (gEgo cel:)
						oldSig: (gEgo signal:)
						setCel: 0
						view: temp0
						setLoop: (gEgo oldCel:)
						ignoreActors:
						cycleSpeed: 14
					)
					(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
						(gEgo setCycle: ForRepeat)
					else
						(gEgo setCycle: Fwd)
					)
				)
			)
			(6
				(= local3 1)
				(switch (deskSarg loop:)
					(0
						(deskSarg view: 2322 loop: 0 setCycle: RandCycle)
					)
					(1
						(deskSarg view: 232 loop: 2 setCycle: RandCycle 100 0 1)
					)
				)
			)
			(7
				(franky view: 238 loop: 1 setCycle: ROsc 8 5)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(cond
			((and local3 (== local11 232) (== local12 0))
				(= local3 0)
				(deskSarg
					setCel: 0
					view: 232
					setLoop: 0
					cycleSpeed: 6
					setCycle: RandCycle
				)
				(= local12 0)
				(= local11 232)
			)
			((and (== local11 232) (== local12 1))
				(deskSarg view: 232 setLoop: 1 setCel: 2 setCycle: 0)
			)
		)
		(if (and local13 (gEgo talking:))
			(gEgo talking: 0)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				signal: (gEgo oldSig:)
				cycleSpeed: local18
				setCycle: StopWalk -1
				talking: 0
			)
		)
		(if (and (== (franky view:) 238) (== (franky loop:) 1))
			(franky setCel: 0 setLoop: 0 1 view: 2380 setCycle: Fwd)
		)
		(super dispose:)
	)
)

(instance extDoor of Prop
	(properties
		noun 5
		sightAngle 40
		approachX 15
		approachY 91
		x 41
		y 79
		view 2300
		signal 16417
		cycleSpeed 8
	)

	(method (handleEvent)
		(if local6
			(self approachVerbs:)
		else
			(self approachVerbs: 6 8) ; Open, Operate
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 8) ; Open, Operate
			(if local6
				(self setScript: sExitDoorFromOffice)
			else
				(gCurRoom setScript: leaveStation)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leaveStation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCel: 0
					view: 233
					setLoop: 5
					cel: 0
					setCycle: CT 4 1 self
				)
				(gGkSound1 number: 373 loop: 1 play:)
				(extDoor setCycle: CT 4 1 self)
			)
			(1 1)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(if (gEgo has: 16) ; policeVeve
					(SetFlag 3)
				)
				(ClearFlag 34)
				(ClearFlag 20)
				(gEgo setLoop: -1)
				(ClearFlag 97)
				(ClearFlag 98)
				(gGkMusic1 fade:)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

