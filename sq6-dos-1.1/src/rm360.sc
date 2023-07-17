;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use DText)
(use Str)
(use Array)
(use Talker)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use DPath)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
	Admiral_Toolman 1
	Sharpei 2
	Chief_Engineer 3
	Commander_Kielbasa 4
	Computer 5
)

(local
	local0
	local1
	local2
	local3 = 9
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(procedure (localproc_0 param1 param2 param3 param4)
	(Message msgGET 360 param1 param2 param3 param4 (local0 data:))
	(= local1 (IntArray with: 0 0 0 0))
	(Text 0 (local1 data:) (local0 data:) 60 320)
	((= local2 (DText new:))
		text: (KString 8 (local0 data:)) ; StrDup
		fore: 84
		font: 60
		mode: 1
		x: (- 160 (/ (local1 at: 2) 2))
		y: 65
		setPri: 250
		setSize: 320
		init:
	)
)

(instance rm360 of SQRoom
	(properties
		noun 2
		picture 360
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 13 138 294 138 272 123 269 112 245 104 225 98 161 91 107 96 77 99 46 106 53 113 22 115 13 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 160 98 223 104 240 110 246 117 236 124 188 130 111 129 81 122 78 109 98 102
					yourself:
				)
		)
		(Load rsVIEW 900 3653)
		(Load 140 941 926) ; WAVE
		(super init:)
		(starfield init:)
		(cond
			((and (== gPrevRoomNum 460) (or (== gComPostNextRoomNum 0) (== gComPostNextRoomNum 360)))
				(gEgo normalize: posn: 32 123 setHeading: 315 init:)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: sExitThruComPost)
			)
			((IsFlag 38)
				(= gDeepshipLocation 2) ; Space
				(gCurRoom setScript: sTransmission)
			)
			(else
				(gCurRoom setScript: sEnterRoom)
			)
		)
		(if (!= gPrevRoomNum 460)
			(gGSound1 number: 901 loop: -1 play: 90 0)
		)
		(starfield init: approachVerbs: 4) ; Do
		(cptTerminal init:)
		(cond
			((IsFlag 38)
				(kielbasa
					view: 369
					loop: 0
					cel: 0
					setPri: 115
					posn: 66 115
					z: 0
					cycleSpeed: 50
					init:
				)
				(hands init: cycleSpeed: 12 setCycle: Fwd)
				(tail init: setCycle: RandCycle)
			)
			((and (IsFlag 118) (not (IsFlag 188)))
				(kielbasa init: setScript: sKielbasaWorking)
			)
			((not (IsFlag 189))
				(kielbasa init: setScript: sKielbasaUp_About)
			)
			(else
				(kielbasa init: setScript: sKielbasaWorking)
			)
		)
		(engineer init: setScript: sEngineerTyping)
		(dorff init: setScript: sDorffWork)
		(comm init: setScript: sCommOfficerWork)
		(if (Random 0 1)
			(science init: setScript: sSciOfficerWork)
			(= local11 1)
		else
			(asteroids init: setCycle: Fwd)
		)
		(sciTerminal init: setCycle: Fwd)
		(fuzzy init: setCycle: RandCycle)
		(bargraph init: setCycle: RandCycle)
		(diagrams init: setCycle: Fwd)
		(chair1 init: approachVerbs: 4) ; Do
		(chair2 init: approachVerbs: 4) ; Do
		(chair3 init: approachVerbs: 4) ; Do
		(chair4 init: approachVerbs: 4) ; Do
		(station1 init: approachVerbs: 4) ; Do
		(station2 init: approachVerbs: 4) ; Do
		(station3 init: approachVerbs: 4) ; Do
		(station4 init: approachVerbs: 4) ; Do
		(sandbox init: approachVerbs: 4) ; Do
		(chairControls init: approachVerbs: 4) ; Do
		(sandboxControls init: approachVerbs: 4) ; Do
		(captainControls init: approachVerbs: 4) ; Do
		(teleportTubeTop init: approachVerbs: 4) ; Do
		(teleportTubeBottom init: approachVerbs: 4) ; Do
		(comPost init: approachVerbs: 4) ; Do
		(captainChair init: approachVerbs: 4) ; Do
		(PalCycle 0 229 230 1 25) ; Start
		(PalCycle 0 231 232 -1 25) ; Start
	)

	(method (doit)
		(if (and (not (IsFlag 38)) (not local12) (not (kielbasa script:)))
			(cond
				((== (= local5 (RandomNumber 1 2)) 1)
					(kielbasa setScript: sKielbasaWorking)
				)
				((== local5 2)
					(kielbasa setScript: sKielbasaScratches)
				)
			)
		)
		(if (not (engineer script:))
			(cond
				((and (== local4 2) (not (IsFlag 38)) (not local12))
					(engineer setScript: sEngineerLeaving)
				)
				((<= (= local6 (RandomNumber 0 3)) 2)
					(engineer setScript: sEngineerTyping)
				)
				((== local6 3)
					(++ local4)
					(engineer setScript: sEngineerTalking)
				)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 460)
			(gGSound1 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(PalCycle 4) ; Off
		(if (IsFlag 38)
			(ClearFlag 38)
		)
		(super dispose:)
	)
)

(instance sBurksilon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(self setScript: sGetReadyToTalk self)
			)
			(2
				(SetFlag 117)
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTransmission of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 900 3601 3600 3602)
				(Load 140 919 363 362 917) ; WAVE
				(= cycles 3)
			)
			(1
				(= ticks 120)
			)
			(2
				(sound1 number: 919 loop: 0 play:)
				(= cycles 1)
			)
			(3
				(gMessager say: 0 0 6 1 self) ; "Commander, I am receiving a message from StarCon."
			)
			(4
				(gMessager say: 0 0 6 2 self) ; "Computer, on screen."
				(kielbasa view: 369 loop: 4 cel: 0 cycleSpeed: 5 setCycle: End)
			)
			(5
				(starfield hide:)
				(kielbasa view: 369 loop: 0 cel: 0)
				(sound1 number: 363 loop: 0 play: self)
				(transScreen view: 3602 cel: 0 loop: 1 init: setCycle: End self)
			)
			(6)
			(7
				(= ticks 45)
			)
			(8
				(transScreen hide:)
				(sound1 number: 362 loop: 0 play:)
				(starConTrans init: cycleSpeed: 12 setCycle: End self)
			)
			(9
				(sound1 stop:)
				(starConTrans dispose:)
				(gMessager sayRange: 0 0 6 3 5 self) ; "Hello, Commander Kielbasa. I have a new directive for DeepShip 86."
				(kielbasa loop: (Random 0 1) cycleSpeed: 50 setCycle: RandCycle)
			)
			(10
				(kielbasa setCycle: End)
				(sound1 number: 917 loop: 0 play:)
				(transScreen cel: 0 loop: 1 show: setCycle: End self)
			)
			(11
				(= ticks 180)
			)
			(12
				(transScreen dispose:)
				(gMessager sayRange: 0 0 6 6 9 self) ; "Hello, Commander Kielbasa. As Admiral Toolman mentioned, we have almost completed our project here, but could use StarCon assistance."
				(kielbasa loop: 0 cel: 0)
				((sharpeiBust new:) init:)
			)
			(13
				(gMessager say: 0 0 6 10) ; "Allow me to explain ........"
				(gGSound1 fade:)
				(= ticks 120)
			)
			(14
				(sharpeiBust init:)
				(sharpeiMouth cel: 3 init: setCycle: RandCycle)
				(sharpeiEyes init: setCycle: RandCycle)
				(= ticks 180)
			)
			(15
				(Fade 1 1 self)
			)
			(16
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: -1)
				(= local0 (Str newWith: 200 {}))
				(= cycles 5)
			)
			(17
				(localproc_0 0 0 6 12)
				(= cycles 5)
			)
			(18
				(DoAudio audPLAY 360 0 0 6 12) ; "Meanwhile back in Sickbay..."
				(= ticks 200)
			)
			(19
				(DoAudio audSTOP 360 0 0 6 12) ; "Meanwhile back in Sickbay..."
				(local2 dispose:)
				(= cycles 5)
			)
			(20
				(gCurRoom newRoom: 380)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGSound2 number: 941 loop: 1 play:)
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 32 123
					setPri: 115
					setSpeed: local3
					setCycle: End self
					init:
				)
			)
			(2
				(if (IsFlag 189)
					(gEgo normalize: 2)
					(gCurRoom setScript: sBurksilon)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo normalize: loop: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: loop: 3 init:)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(gGSound2 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 32 123
					setPri: 115
					setSpeed: local3
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance sSciOfficerWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(science view: 365 loop: 0 setCycle: RandCycle)
				(= ticks (RandomNumber 120 180))
			)
			(1
				(if local8
					(self changeState: 2)
				else
					(self changeState: 0)
				)
			)
			(2
				(= next sSciOficerTalks)
				(self dispose:)
			)
		)
	)
)

(instance sSciOficerTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(science view: 3650 loop: 0 setCycle: End self)
			)
			(1
				(science loop: 1 setCycle: End self)
			)
			(2
				(science loop: 0 cel: 0)
				(= cycles 1)
			)
			(3
				(= next sSciOfficerWork)
				(self dispose:)
			)
		)
	)
)

(instance sCommOfficerWork of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (dorff x:) 97) (== (dorff y:) 99) (not local9))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(comm view: 365 loop: 2 setCycle: RandCycle)
			)
			(1
				(= next sCommTalk)
				(self dispose:)
			)
		)
	)
)

(instance sCommTalk of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if local7
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(comm view: 3650 loop: 2 setCycle: End self)
			)
			(1
				(comm loop: 3 setCycle: RandCycle)
				(= ticks (RandomNumber 120 180))
			)
			(2
				(= local7 1)
			)
			(3
				(= local9 1)
				(= local7 0)
				(sDorffWork changeState: 5)
				(= next sCommOfficerWork)
				(self dispose:)
			)
		)
	)
)

(instance sDorffWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 1)
				(dorff
					view: 3651
					loop: 0
					cel: 0
					posn: 262 102
					setCycle: RandCycle
				)
				(if local10
					(= local10 0)
					(screenSaver dispose:)
					(sciTerminal init: setCycle: RandCycle)
				)
				(= ticks (RandomNumber 600 900))
			)
			(1
				(if (or local12 (IsFlag 38))
					(self changeState: 0)
				else
					(= cycles 1)
				)
			)
			(2
				(= local8 0)
				(sciTerminal hide:)
				(screenSaver init: setCycle: Fwd)
				(= local10 1)
				(dorff
					view: 366
					setStep: 3 2 0
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: DPath 250 106 231 130 156 134 87 125 self
				)
			)
			(3
				(dorff
					view: 366
					setStep: 3 2 0
					setLooper: Grooper
					loop: 3
					setCycle: Walk
					setMotion: DPath 87 125 97 99 self
				)
			)
			(4)
			(5
				(dorff setMotion: PolyPath 262 102 self)
			)
			(6
				(= local9 0)
				(= cycles 1)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance sKielbasaUp_About of Script
	(properties
		name {sKielbasaUp&About}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (Random 0 3))
					(kielbasa setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(kielbasa loop: 1 setCycle: Fwd)
				(= ticks (RandomNumber 300 600))
			)
			(2
				(kielbasa setCycle: End self)
			)
			(3
				(kielbasa setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sKielbasaWorking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielbasa view: 3611 loop: 0 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 60 180))
			)
			(1
				(kielbasa loop: (RandomNumber 1 2) setCycle: Fwd)
				(if (== (kielbasa loop:) 1)
					(cptTerminal setCycle: Fwd)
				)
				(= ticks (RandomNumber 180 400))
			)
			(2
				(kielbasa loop: (RandomNumber 1 2) setCycle: Fwd)
				(= ticks (RandomNumber 120 300))
			)
			(3
				(cptTerminal setCycle: End)
				(self dispose:)
			)
		)
	)
)

(instance sKielbasaScratches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielbasa view: 362 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(kielbasa loop: 1 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 60 120))
			)
			(2
				(self changeState: (RandomNumber 3 5))
			)
			(3
				(kielbasa loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(kielbasa loop: 3 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 60 120))
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sGetReadyToTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local12 1)
				(gEgo setMotion: PolyPath 80 118 self)
			)
			(1
				(gEgo setHeading: 90)
				(cond
					((== (kielbasa script:) sKielbasaUp_About)
						(sKielbasaUp_About dispose:)
						(self changeState: 5)
					)
					((== (kielbasa script:) sKielbasaScratches)
						(sKielbasaScratches dispose:)
						(= cycles 1)
					)
					((== (kielbasa script:) sKielbasaWorking)
						(sKielbasaWorking dispose:)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (== (kielbasa cel:) 0)
					(= cycles 1)
				else
					(kielbasa cel: (kielbasa cel:) setCycle: Beg self)
				)
			)
			(3
				(kielbasa view: 3612 loop: 0 cel: 0)
				(= cycles 1)
			)
			(4
				(self changeState: 7)
			)
			(5
				(kielbasa cel: (kielbasa cel:) setCycle: End self)
			)
			(6
				(kielbasa view: 3610 loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(cond
					((and (IsFlag 118) (not (IsFlag 188)))
						(gGame points: 1 474)
						(SetFlag 188)
						(gMessager say: 0 0 7 0 self) ; "Commander Kielbasa, you're going to think I'm crazy but I've just recieved a distress message on my ComPost. And it was from Stellar!"
					)
					((and (IsFlag 116) (not (IsFlag 160)))
						(gMessager say: 0 0 9 0 self) ; "Janitor Wilco, why are you here?! You're supposed to have gotten your orders from your ComPost as instructed and reported to transport for beaming to Delta Burksilon V. Do it now or I'll be forced to make you the subject and recipient of a Captain's Log entry. Now, move it!"
					)
					(else
						(gMessager say: 28 2 0 0 self) ; "Janitor Wilco, you must have something to clean up somewhere. Make yourself scarce. We're very busy up here."
					)
				)
			)
			(8
				(= local12 0)
				(kielbasa setScript: sKielbasaWorking)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEngineerTyping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(engineer view: 3651 loop: 2 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 300 600))
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sEngineerTalking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(engineer view: 3653 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(engineer loop: 1 cel: 0 setCycle: RandCycle)
				(= ticks (RandomNumber 120 180))
			)
			(2
				(engineer loop: 0 cel: 1 setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEngineerLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(engineer view: 3651 loop: 2 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 300 600))
			)
			(1
				(engineer
					posn: 35 123
					view: 367
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(engineer loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (teleportTubeBottom onMe: gEgo)
					(engineer view: 3670 cel: 0 loop: 1 setCycle: End self)
				else
					(self changeState: 6)
				)
			)
			(4
				(gGame handsOff:)
				(gEgo ignoreActors: 1 setMotion: PolyPath 88 128 self)
			)
			(5
				(gEgo ignoreActors: 0 setHeading: 270 self)
			)
			(6
				(engineer view: 3670 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(gGame handsOn:)
				(gGSound2 number: 926 loop: 1 play:)
				(engineer view: 3671 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(engineer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dorff of Actor
	(properties
		noun 32
		x 262
		y 102
		view 3651
		signal 4129
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance comm of Actor
	(properties
		noun 30
		x 90
		y 95
		z 5
		view 365
		loop 2
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 90)
	)
)

(instance engineer of Actor
	(properties
		noun 29
		x 60
		y 95
		view 3651
		loop 2
		signal 20513
	)
)

(instance science of Actor
	(properties
		noun 33
		x 232
		y 111
		z 10
		view 365
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 80)
	)
)

(instance kielbasa of Actor
	(properties
		noun 28
		x 160
		y 100
		z 20
		view 3610
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 109)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: sGetReadyToTalk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tail of Prop
	(properties
		noun 28
		x 64
		y 108
		view 369
		loop 3
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 120)
	)
)

(instance hands of Prop
	(properties
		noun 28
		x 64
		y 84
		view 369
		loop 2
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 120)
	)
)

(instance cptTerminal of Prop
	(properties
		x 118
		y 48
		view 3611
		loop 4
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 109)
	)
)

(instance starConTrans of Prop
	(properties
		x 119
		y 11
		view 3601
		loop 4
	)
)

(instance starfield of Prop
	(properties
		noun 3
		sightAngle 0
		x 119
		y 8
		view 3603
		signal 20513
	)

	(method (init)
		(cond
			((== gDeepshipLocation 0) ; Polysorbate
				(= loop 0)
			)
			((== gDeepshipLocation 1) ; Delta Burksilon
				(= loop 1)
			)
			((== gDeepshipLocation 2) ; Space
				(= loop 2)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((== gDeepshipLocation 0) ; Polysorbate
						(gMessager say: 3 1 11) ; "Orbiting Polysorbate LX."
					)
					((== gDeepshipLocation 1) ; Delta Burksilon
						(gMessager say: 3 1 10) ; "Orbiting Delta Burksilon V."
					)
					((== gDeepshipLocation 2) ; Space
						(gMessager say: 3 1) ; "The main viewscreen is filled with stars and distant galaxies, representing untold scores of civilizations and a vast amount of untapped knowledge that could reshape the way we think of time and space."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance transScreen of Prop
	(properties
		x 119
		y 8
		view 3602
		loop 1
	)
)

(instance diagrams of Prop
	(properties
		noun 34
		x 49
		y 54
		view 360
		signal 20513
	)
)

(instance bargraph of Prop
	(properties
		noun 14
		x 73
		y 92
		z 15
		view 360
		loop 1
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 80)
	)
)

(instance fuzzy of Prop
	(properties
		noun 11
		x 40
		y 80
		view 360
		loop 2
		signal 20513
	)
)

(instance sciTerminal of Prop
	(properties
		noun 12
		x 262
		y 78
		view 360
		loop 4
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 95)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCast contains: science))
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance asteroids of Prop
	(properties
		noun 13
		x 229
		y 75
		view 360
		loop 3
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self setPri: 95)
	)
)

(instance screenSaver of Prop
	(properties
		x 262
		y 78
		view 360
		loop 3
		signal 20513
	)
)

(instance comPost of Feature
	(properties
		noun 1
		nsLeft 15
		nsTop 74
		nsRight 27
		nsBottom 82
		sightAngle 40
		approachX 32
		approachY 123
		x 20
		y 103
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chairControls of Feature
	(properties
		noun 5
		nsLeft 166
		nsTop 104
		nsRight 178
		nsBottom 112
		sightAngle 40
		approachX 183
		approachY 127
		x 172
		y 113
	)
)

(instance captainChair of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 131
		approachY 127
		x 165
		y 85
		z 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 111 99 116 110 120 158 123 194 122 218 118 223 115 223 109 220 105 219 67 199 62 176 59 159 58 125 61 102 67 102 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance captainControls of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 131
		approachY 127
		x 165
		y 84
		z 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 66 105 66 99 61 112 57 112 51 116 46 135 45 138 53 152 52 172 51 184 52 185 49 197 50 209 52 207 55 222 59 223 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sandbox of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 289
		approachY 135
		x 304
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 112 288 117 289 129 309 138 319 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sandboxControls of Feature
	(properties
		noun 15
		nsLeft 310
		nsTop 130
		nsRight 317
		nsBottom 136
		sightAngle 40
		approachX 289
		approachY 135
		x 313
		y 133
	)
)

(instance teleportTubeTop of Feature
	(properties
		noun 8
		approachX 31
		approachY 122
		x 165
		y 79
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 13 0 13 25 31 27 49 25 49 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance teleportTubeBottom of Feature
	(properties
		noun 9
		sightAngle 40
		approachX 31
		approachY 122
		x 165
		y 79
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 122 19 118 31 117 43 118 50 121 43 125 31 126 18 125
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair1 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 63
		approachY 104
		x 63
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 100 57 98 52 97 51 94 65 92 65 89 59 89 62 82 68 81 72 82 74 85 74 89 71 89 70 93 73 94 73 96 67 98 67 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair2 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 89
		approachY 100
		x 89
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 96 88 93 83 92 83 89 96 88 96 85 91 84 93 77 100 76 102 75 102 91 98 93 98 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair3 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 227
		approachY 100
		x 226
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 96 234 93 239 92 238 89 227 88 226 85 232 84 228 77 220 76 220 91 224 93 223 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair4 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 269
		approachY 112
		x 257
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 100 262 97 269 95 269 93 258 92 257 90 263 89 259 82 254 82 249 82 248 88 251 89 252 93 249 94 253 97 254 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance station1 of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 63
		approachY 104
		x 52
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 84 68 78 68 66 39 69 39 82 43 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance station2 of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 89
		approachY 100
		x 85
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 84 102 80 102 62 72 65 72 78
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance station3 of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 227
		approachY 100
		x 231
		y 102
		z 22
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 83 249 77 249 65 218 63 218 80
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCast contains: science))
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance station4 of Feature
	(properties
		noun 13
		sightAngle 270
		approachX 269
		approachY 112
		x 264
		y 101
		z 18
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 88 283 82 283 69 253 66 253 76 246 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance Sharpei of Talker
	(properties)

	(method (init)
		(super init: sharpeiMouth sharpeiBust sharpeiEyes)
	)
)

(instance sharpeiBust of Prop
	(properties
		x 162
		y 25
		view 3600
	)
)

(instance sharpeiMouth of Prop
	(properties
		x 162
		y 25
		view 3600
		loop 1
	)
)

(instance sharpeiEyes of Prop
	(properties
		x 162
		y 25
		view 3600
		loop 2
	)
)

(instance Admiral_Toolman of Talker
	(properties
		name {Admiral Toolman}
	)

	(method (init)
		(super init: starConMouth starConBust starConEyes)
	)
)

(instance starConBust of Prop
	(properties
		x 119
		y 11
		view 3601
	)
)

(instance starConMouth of Prop
	(properties
		x 160
		y 26
		view 3601
		loop 1
	)
)

(instance starConEyes of Prop
	(properties
		x 160
		y 14
		view 3601
		loop 2
	)
)

(instance Chief_Engineer of SmallTalker
	(properties
		name {Chief Engineer}
		talkView 3670
		talkLoop 1
	)

	(method (init)
		(= client engineer)
		(super init:)
	)
)

(instance Commander_Kielbasa of SmallTalker
	(properties
		name {Commander Kielbasa}
	)

	(method (init)
		(= client kielbasa)
		(if (IsFlag 38)
			(= showTalk 0)
		else
			(= showTalk 1)
			(= talkView 3612)
			(= talkLoop 1)
		)
		(super init:)
	)
)

(instance Computer of SmallTalker
	(properties)

	(method (init)
		(= client kielbasa)
		(= showTalk 0)
		(super init:)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

