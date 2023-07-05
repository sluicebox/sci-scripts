;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use CycleBet)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm400 of LarryRoom
	(properties
		noun 1
		picture 400
		horizon 0
	)

	(method (cue)
		(self setScript: egoGetsFried)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 2 128 0 139 156 139 168 125 184 112 205 94 257 94 276 105 284 111 242 138 319 137 319 106 309 101 308 97 287 94 284 93 257 92 207 92 192 84 170 84 164 87 133 88 122 96 105 98 81 93 58 97 92 106 62 115 29 109 1 128
					yourself:
				)
				(= local0
					((Polygon new:)
						type: PBarredAccess
						init: 76 115 112 101 133 97 153 99 157 101 144 110 135 117 121 123 112 131 94 132 72 127 70 123
						yourself:
					)
				)
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 124 127 139 117 160 102 181 100 188 105 180 112 172 118 156 135 126 135
						yourself:
					)
				)
		)
		(= local2
			((Polygon new:) type: PTotalAccess init: 202 0 196 22 148 20 144 0 yourself:)
		)
		(= local3
			((Polygon new:)
				type: PTotalAccess
				init: 293 24 265 12 283 0 312 0 319 10 319 25 294 24
				yourself:
			)
		)
		(gGlobalSound2 stop:)
		(gEgo init: normalize:)
		(manShowerDoor init: approachVerbs: 4) ; Do
		(plants init:)
		(if (not (IsFlag 203))
			(lock init: approachVerbs: 4) ; Do
		)
		(girlShowerDoor init: approachVerbs: 4) ; Do
		(steamDoor init: setPri: 80 approachVerbs: 4) ; Do
		(shockDoor
			init:
			setCel: (if (== gPrevRoomNum 380) 5 else 0)
			approachVerbs: 4 ; Do
		)
		(leftGlass init: approachVerbs: 4) ; Do
		(rightGlass init: approachVerbs: 4) ; Do
		(newPlant init: approachVerbs: 4) ; Do
		(if (IsFlag 32)
			(plant1 posn: 42 108 loop: 0 cel: 0 init:)
			(plant2 posn: 44 111 loop: 1 cel: 0 init:)
			(plant3 posn: 54 113 loop: 2 cel: 0 init:)
		else
			(plant1 init: setPri: 107)
			(plant2 init: setPri: 107)
			(plant3 init: setPri: 107)
		)
		(camera init: setPri: 90 setCel: (if (IsFlag 18) 3 else 0))
		(bubbles1
			init:
			setPri: 30
			ignoreActors: 1
			setLoop: 4 1
			cycleSpeed: 8
			setCycle: Fwd
		)
		(bubbles2
			init:
			setPri: 30
			ignoreActors: 1
			setLoop: 5 1
			cycleSpeed: 10
			setCycle: Fwd
		)
		(couple1 init: setPri: 30 hide: setScript: couple1Script)
		(couple2 init: setPri: 30 hide: setScript: couple2Script)
		(bath1 init: approachVerbs: 4) ; Do
		(bath2 init:)
		(bath3 init:)
		(charBath init: approachVerbs: 4 1) ; Do, Look
		(louver1 init:)
		(louver2 init:)
		(socket init:)
		(if (!= gPrevRoomNum 410)
			(gGlobalSound1 number: 310 play: setVol: 127 setLoop: -1)
		)
		(if (and (IsFlag 31) (not (IsFlag 203)))
			(theCord init: approachVerbs: 5) ; Take
		)
		(if (not (IsFlag 88))
			(chardonnay
				init:
				approachVerbs: 1 2 4 25 ; Look, Talk, Do, batteries
				setScript: (if (== gPrevRoomNum 410) charDown else charScript)
			)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(350
				(self setScript: enterFromShower)
			)
			(370
				(if (== (gEgo view:) 900)
					(gEgo posn: 175 95 normalize: 900 3)
					(gGame handsOn:)
				else
					(self setScript: enterFromSteamRoom)
				)
			)
			(380
				(self setScript: enterFromShockRoom)
			)
			(420
				(SetFlag 9)
				(self setScript: enterFromWeightRoom)
			)
			(410
				(if (and (IsFlag 204) (IsFlag 203))
					(charScript dispose:)
					(gCurRoom setScript: charBails)
				else
					(gGame handsOn:)
				)
			)
			(else
				(self setScript: enterFromShower)
			)
		)
		(bubbleFx number: 406 loop: -1 play: setVol: 127)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (gCast contains: chardonnay)
					(gMessager say: 1 2 8) ; "You may want to direct your attention to that young lady sitting all alone in the mud."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo edgeHit:))
		(super doit: &rest)
		(if
			(and
				(gCast contains: theCord)
				(gEgo has: 9) ; cord
				(> (gEgo distanceTo: theCord) 20)
			)
			(gEgo put: 9) ; cord
		)
		(cond
			(script)
			((== temp0 2)
				(if (!= (gEgo view:) 900)
					(gEgo x: 317 setMotion: 0)
					(gMessager say: 1 0 2) ; "Out of consideration to La Costa Lotta's other patrons, you decide to get dressed before appearing in public!"
				else
					(gCurRoom setScript: toWeightRoom)
				)
			)
		)
	)

	(method (dispose)
		(local2 dispose:)
		(local3 dispose:)
		(super dispose: &rest)
	)
)

(instance tryToTurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 900
					setSpeed: 6
					setMotion: PolyPath 72 116 self
				)
			)
			(1
				(gEgo setHeading: 310 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					setPri: 200
					setSpeed: 6
					setStep: 6 4
					setMotion: MoveTo 43 82 self
				)
			)
			(4
				(gEgo
					view: 403
					loop: 2
					setSpeed: 12
					setCel: 2
					x: 44
					y: 79
					setCycle: CT 3 1 self
				)
			)
			(5
				(gEgo setCycle: CycleBet 4 3 3 self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(if (IsFlag 18)
					(gMessager say: 15 4 1 0 self) ; "You remember tightening that camera with the wrench, so there's no way you could loosen it with your fingers."
				else
					(gMessager say: 15 4 0 0 self) ; "You cleverly attempt to re-aim the camera through the louvers leading into the women's shower, but you cannot. The camera is held firmly in place by a large bolt, which is far too tight for you to turn with only your fingers."
				)
			)
			(8
				(gEgo
					view: 900
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 78 113 self
				)
			)
			(9
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance couple1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(couple1 show: setCycle: Fwd)
				(bubbles1 cycleSpeed: 12 setLoop: 0 1 setCycle: Fwd)
				(= ticks 90)
			)
			(2
				(couple1 cycleSpeed: (Random 4 12))
				(bubbles1 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(3
				(couple1 cycleSpeed: (Random 4 12))
				(bubbles1 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(4
				(couple1 cycleSpeed: (Random 4 12))
				(bubbles1 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(5
				(couple1 cycleSpeed: (Random 4 12))
				(bubbles1 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(6
				(couple1 setCycle: 0 cycleSpeed: 12 hide:)
				(bubbles1 setCel: 0 setCycle: End self)
			)
			(7
				(bubbles1 setLoop: 4 1 cycleSpeed: 8 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance couple2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(couple2 show: setCycle: Fwd)
				(bubbles2 cycleSpeed: 12 setLoop: 1 1 setCycle: Fwd)
				(= ticks 90)
			)
			(1
				(couple2 cycleSpeed: (Random 4 12))
				(bubbles2 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(2
				(couple2 cycleSpeed: (Random 4 12))
				(bubbles2 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(3
				(couple2 cycleSpeed: (Random 4 12))
				(bubbles2 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(4
				(couple2 cycleSpeed: (Random 4 12))
				(bubbles2 cycleSpeed: (Random 4 12))
				(= ticks (Random 60 120))
			)
			(5
				(couple2 setCycle: 0 cycleSpeed: 12 hide:)
				(bubbles2 setCel: 0 setCycle: End self)
			)
			(6
				(bubbles2 setLoop: 5 1 cycleSpeed: 10 setCycle: Fwd)
				(= seconds (Random 5 15))
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance charDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chardonnay setLoop: 3 setCel: 8 setCycle: Beg self)
			)
			(1
				(chardonnay setLoop: 0 setScript: charScript)
				(self dispose:)
			)
		)
	)
)

(instance muddyDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 402)
				(gEgo setMotion: PolyPath 62 129 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 12 4 3 1 self) ; "Wow! Free mud baths. I think I'll jump right in."
			)
			(4
				(gEgo
					view: 402
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: CT 8 1 self
				)
			)
			(5
				(sFx number: 401 loop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo loop: 1 setCycle: Fwd)
				(= cycles 2)
			)
			(7
				(gMessager say: 12 4 3 2 self) ; "The question is: Will polyester protect you from this extremely hot mud..."
			)
			(8
				(= ticks 30)
			)
			(9
				(EgoDead 11 self)
			)
			(10
				(gEgo normalize: 900 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putPlantsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: -1 setMotion: PolyPath 48 114 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 11 0 13 0 self) ; "While you don't need to return the plants to where you found them, you feel sure your mother would be proud of you!"
			)
			(3
				(gEgo
					view: 406
					setSpeed: 12
					loop: 0
					setCel: 9
					setCycle: CT 4 -1 self
				)
				(plant3 hide:)
			)
			(4
				(= ticks 11)
			)
			(5
				(gEgo setCel: 3 setCycle: Beg self)
				(plant3 x: 66 y: 102 show: setPri: 107 setLoop: 3 setCel: 2)
			)
			(6
				(gEgo
					view: 900
					setCycle: Walk
					setSpeed: 6
					setMotion: PolyPath 40 113 self
				)
			)
			(7
				(plant2 hide:)
				(gEgo
					view: 406
					setLoop: 1
					setSpeed: 12
					setCel: 9
					setCycle: CT 4 -1 self
				)
			)
			(8
				(= ticks 11)
			)
			(9
				(gEgo cel: 3 setCycle: Beg self)
				(plant2 x: 56 y: 91 show: setPri: 107 loop: 3 setCel: 1)
			)
			(10
				(gEgo
					view: 900
					setSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 34 109 self
				)
			)
			(11
				(plant1 hide:)
				(gEgo
					view: 406
					loop: 2
					setSpeed: 12
					setCel: 9
					setCycle: CT 4 -1 self
				)
			)
			(12
				(= ticks 11)
			)
			(13
				(gEgo cel: 3 setCycle: Beg self)
				(plant1 x: 49 y: 77 show: setPri: 107 loop: 3 setCel: 0)
			)
			(14
				(gEgo normalize: 900)
				(manShowerDoor setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toWeightRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance charBails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(charScript dispose:)
				(chardonnay loop: 3 setCel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(1
				(Face gEgo chardonnay self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 2 0 11 1 self) ; "After I shower, I'll meet you in the Electroshock Exercise Center."
			)
			(4
				(chardonnay
					view: 416
					setLoop: 0 1
					posn: 249 103
					cycleSpeed: 6
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 130 95 self
				)
				(plant1 ignoreActors: 1)
				(plant2 ignoreActors: 1)
				(plant3 ignoreActors: 1)
			)
			(5
				(Face gEgo chardonnay self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 2 0 11 2 self) ; "(DISGUSTED) (Well, that's the end of that. I know I'll never see her again!)"
			)
			(8
				(chardonnay setLoop: 2 1 setMotion: MoveTo 53 125 self)
			)
			(9
				(chardonnay setLoop: 0 1 setMotion: MoveTo 22 116 self)
			)
			(10
				(sFx number: 1032 loop: 1 play: setVol: 127)
				(girlShowerDoor setCycle: End self)
			)
			(11
				(chardonnay setMotion: MoveTo 16 107 self)
			)
			(12
				(chardonnay setPri: 0)
				(girlShowerDoor setCycle: Beg self)
			)
			(13
				(sFx number: 1033 loop: 1 play: setVol: 127)
				(chardonnay dispose:)
				(gEgo setMotion: PolyPath 293 99 self)
			)
			(14
				(gEgo normalize: setMotion: MoveTo 302 96 self)
			)
			(15
				(gEgo
					view: 901
					loop: 6
					setCel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: End self
				)
			)
			(16
				(sFx number: 1032 loop: 1 play:)
				(shockDoor setCycle: End self)
			)
			(17
				(gEgo
					view: 900
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 297 90 self
				)
				(gGlobalSound1 fade: 30 10 10 1 self)
			)
			(18
				(gEgo setCycle: 0)
			)
			(19
				(gGlobalSound1 number: 0 stop:)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance egoGetsFried of Script
	(properties)

	(method (doit)
		(if (== (self state:) 1)
			(switch (gEgo cel:)
				(4
					(sFx number: 403 play:)
				)
				(9
					(sFx number: 403 play:)
				)
				(6
					(sFx stop:)
				)
				(11
					(sFx stop:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 415
					loop: 0
					setSpeed: 12
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(sFx number: 403 play:)
				(gEgo setCycle: CycleBet 4 12 2 self)
			)
			(2
				(sFx stop:)
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(EgoDead 6 self)
			)
			(4
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((ResCheck 140 1033) ; WAVE
						(= local5 140)
					)
					((ResCheck rsAUDIO 1033)
						(= local5 141)
					)
					(else
						(= local5 132)
					)
				)
				(Load local5 1033)
				(gEgo posn: 68 91 normalize: (gEgo view:) 0)
				(manShowerDoor setCel: 8)
				(gEgo setPri: -1 setMotion: MoveTo 89 99 self)
			)
			(1
				(manShowerDoor setPri: -1 setCycle: Beg self)
			)
			(2
				(sFx number: 1033 loop: 1 play: self setVol: 127)
			)
			(3
				(UnLoad local5 1033)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromSteamRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 178 84)
				(sFx number: 1032 loop: 1 play: setVol: 127)
				(steamDoor setCycle: End self)
			)
			(1
				(gEgo setPri: -1 setMotion: MoveTo 175 95 self)
			)
			(2
				(steamDoor setCycle: Beg self)
			)
			(3
				(sFx number: 1033 loop: 1 play: setVol: 127)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromShockRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 302 96
					normalize: (gEgo view:) 2
					setPri: -1
					setMotion: MoveTo 292 105 self
				)
			)
			(1
				(shockDoor setCycle: Beg self)
			)
			(2
				(sFx number: 1033 loop: 1 play: setVol: 127)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromWeightRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 325 100 setMotion: MoveTo 310 100 self)
			)
			(1
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnCamera of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 900 setSpeed: 6 setMotion: PolyPath 77 112 self)
			)
			(1
				(gEgo setPri: 200 setStep: 6 4 setMotion: MoveTo 48 79 self)
			)
			(2
				(gEgo
					view: 403
					loop: 0
					setSpeed: 12
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo loop: 1 setCel: 0 setCycle: End self)
				(sFx number: 404 loop: 1 play:)
			)
			(4
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(5
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(6
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(7
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(8
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(9
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(10
				(gEgo loop: 2 setCel: 0 setCycle: CT 5 1 self)
			)
			(11
				(gEgo setCycle: End self)
				(sFx number: 405 play:)
				(if (IsFlag 18)
					(camera setCycle: Beg self)
				else
					(camera setCycle: End self)
				)
			)
			(12)
			(13
				(if (IsFlag 18)
					(ClearFlag 18)
					(gMessager say: 15 64 1 0 self) ; "Once again you loosen the large bolt holding the video camera in place. You turn the camera back toward the mud baths so no one will ever know you messed with it."
				else
					(SetFlag 18)
					(gGame changeScore: 12 200)
					(gMessager say: 15 64 0 0 self) ; "Using the plumber's wrench, you loosen the large bolt holding the video camera in place, then turn the camera so it's looking directly into the women's shower."
				)
			)
			(14
				(gEgo loop: 1 setCel: 0 setCycle: End self)
				(sFx number: 404 loop: 1 play:)
			)
			(15
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(16
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(17
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(18
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(19
				(sFx play:)
				(gEgo setCycle: Beg self)
			)
			(20
				(sFx play:)
				(gEgo setCycle: End self)
			)
			(21
				(gEgo
					view: 900
					setSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 78 113 self
				)
			)
			(22
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toMensShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo view:))
				(cond
					((== (gEgo view:) 900)
						(gEgo
							view: 901
							loop: 1
							setCel: 0
							setSpeed: 12
							setCycle: CT 2 1 self
						)
					)
					((OneOf (gEgo view:) 353 351)
						(gEgo
							view: 356
							loop: (if (== (gEgo view:) 353) 1 else 0)
							setCel: 0
							setSpeed: 12
							setCycle: CT 2 1 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(sFx number: 1032 loop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
				(manShowerDoor setCycle: End self)
			)
			(2)
			(3
				(gEgo
					view: local4
					setCycle: Walk
					setPri: (- (manShowerDoor priority:) 1)
					setSpeed: 6
					setMotion: MoveTo 65 92 self
				)
			)
			(4
				(gGlobalSound1 fade:)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance toSteamRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo view:))
				(cond
					((== (gEgo view:) 900)
						(gEgo
							view: 901
							loop: 6
							setCel: 0
							setSpeed: 12
							setCycle: End self
						)
					)
					((== (gEgo view:) 353)
						(gEgo
							view: 356
							loop: 2
							setCel: 0
							cycleSpeed: 12
							setCycle: End self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(sFx number: 1032 loop: 1 play: setVol: 127)
				(steamDoor setCycle: End self)
			)
			(2
				(gEgo
					view: local4
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 178 83 self
				)
			)
			(3
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance toShockRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo view:))
				(if (== (gEgo view:) 900)
					(gEgo
						view: 901
						loop: 6
						setCel: 0
						setSpeed: 12
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(sFx number: 1032 loop: 1 play: setVol: 127)
				(shockDoor setCycle: End self)
			)
			(2
				(gEgo
					view: local4
					setCycle: Walk
					setMotion: MoveTo 302 96 self
				)
			)
			(3
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance jumpInMud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 62 129 self)
			)
			(1
				(gEgo
					view: 404
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: CT 8 1 self
				)
			)
			(2
				(larryTowel init: ignoreActors: 1)
				(gEgo setCycle: End self)
				(sFx number: 401 loop: 1 play:)
			)
			(3
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(gGame changeScore: 1 201)
				((ScriptID 0 11) init: self) ; iconExit
				(gEgo state: (& (gEgo state:) $fffd))
				(gGame handsOn:)
				(gTheIconBar
					disableIcon:
						(ScriptID 0 7) ; icon4
						(ScriptID 0 5) ; icon2
						(ScriptID 0 9) ; icon6
						(ScriptID 0 6) ; icon3
					show:
				)
			)
			(5
				((ScriptID 0 11) dispose:) ; iconExit
				(gGame handsOff:)
				(gEgo
					loop: 2
					setCel: 0
					state: (| $0002 (gEgo state:))
					setCycle: End self
				)
				(sFx number: 402 play:)
			)
			(6
				(gMessager say: 12 0 10 0 self) ; "(Oops.)"
			)
			(7
				(= seconds 3)
			)
			(8
				(gEgo
					x: 62
					y: 126
					setLoop: 3
					setCel: 0
					setCycle: CT 9 1 self
				)
			)
			(9
				(larryTowel dispose:)
				(gEgo setCycle: End self)
			)
			(10
				(SetFlag 25)
				(gEgo posn: 75 128 normalize: 351 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance plugInCord of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 405)
				(gEgo setMotion: PolyPath 259 96 self)
			)
			(1
				(gEgo setMotion: MoveTo 259 96 self)
			)
			(2
				(gEgo
					view: 405
					setSpeed: 12
					loop: (if register 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gGame changeScore: 7 202)
				(SetFlag 31)
				(theCord init: approachVerbs: 5 cel: (if register 1 else 0)) ; Take
				(gEgo normalize: 900 0 setMotion: MoveTo 260 95 self)
			)
			(4
				(gEgo normalize: 900 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openShockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 275 93 self)
			)
			(1
				(gEgo
					view: 413
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: End self
				)
				(theCord dispose:)
			)
			(2
				(sFx number: 403 loop: 1 play:)
				(gEgo view: 414 loop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(sFx stop:)
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(gMessager sayRange: 6 27 9 1 2 self) ; "Cleverly touching the electronic lock with the bare ends of your electrical cord, you pass 120 volts at high amperage through the electronic lock's delicate printed circuit boards, frying them immediately with a gratifying shower of sparks."
			)
			(5
				(sFx number: 572 loop: 1 play: setVol: 127)
				(if (IsFlag 204)
					(Face gEgo chardonnay self)
				else
					(self cue:)
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(if (not (IsFlag 204))
					(gMessager say: 6 27 9 3 self) ; "I wonder what's inside here?"
				else
					(gMessager sayRange: 6 27 9 4 7 self) ; "Hey, Charlotte! I've got it open. Come on in."
				)
			)
			(8
				(gGame changeScore: 12 203)
				(gEgo normalize: 900 0 put: 9) ; cord
				(if (IsFlag 204)
					(gCurRoom setScript: charBails)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance touchPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 274 94 self)
			)
			(1
				(gEgo
					view: 413
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: End self
				)
				(theCord dispose:)
			)
			(2
				(gMessager say: 6 26 9 0 self) ; "What a great idea! Use the electrical cord to short-circuit the electronic door lock."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(theCord init:)
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance checkOutChar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo chardonnay self)
			)
			(1
				(= cycles 2)
			)
			(2
				(charScript dispose:)
				(if (IsFlag 64)
					(gMessager say: 19 1 8 0 self) ; "Charlotte Donay reclines in her mud bath. You cast your most radiant smile at her. She barely glances at you."
				else
					(gMessager say: 19 1 14 0 self) ; "Hello. My name is Larry; Larry Laffer."
				)
			)
			(3
				(chardonnay loop: 3 setCel: 0 setCycle: CT 8 1 self)
			)
			(4
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance charScript of Script
	(properties)

	(method (dispose)
		(chardonnay setCycle: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 10))
			)
			(1
				(chardonnay loop: 2 setCel: 4 cycleSpeed: 12 setCycle: Beg self)
			)
			(2
				(chardonnay loop: 1 setCycle: Fwd)
				(= seconds (Random 1 5))
			)
			(3
				(chardonnay loop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(chardonnay setCycle: 0 loop: 0 setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance chardonnay of Actor
	(properties
		approachX 268
		approachY 133
		x 258
		y 110
		view 401
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 2 1 4) ; Talk, Look, Do
				(if (gCurRoom script:)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: checkOutChar)
				)
			)
			(25 ; batteries
				(SetFlag 39)
				(gCurRoom setScript: checkOutChar)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance couple1 of Prop
	(properties
		noun 3
		x 108
		y 19
		view 411
		loop 2
		cycleSpeed 8
	)
)

(instance couple2 of Prop
	(properties
		noun 3
		x 239
		y 19
		view 411
		loop 3
		cel 7
		cycleSpeed 8
	)
)

(instance bubbles1 of Prop
	(properties
		noun 3
		x 107
		y 19
		view 411
		cel 2
		cycleSpeed 8
	)
)

(instance bubbles2 of Prop
	(properties
		noun 3
		x 239
		y 19
		view 411
		loop 1
		cel 4
		cycleSpeed 8
	)
)

(instance plants of Feature
	(properties
		noun 8
	)

	(method (onMe param1)
		(return
			(or
				(local2 onMe: (param1 x:) (param1 y:))
				(local3 onMe: (param1 x:) (param1 y:))
			)
		)
	)
)

(instance louver1 of Feature
	(properties
		noun 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 50 6 43 14 37 23 37 31 45 31 49
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance louver2 of Feature
	(properties
		noun 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 43 56 30 66 27 77 34 78 38 49 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plant1 of View
	(properties
		noun 8
		x 49
		y 77
		view 407
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 1 0 5) ; "You're in no condition to do that now."
						(return 1)
					)
					((IsFlag 32)
						(ClearFlag 32)
						(gCurRoom setScript: putPlantsUp)
					)
					(else
						(SetFlag 32)
						(gCurRoom setScript: takePlantsDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plant2 of View
	(properties
		noun 8
		x 56
		y 91
		view 407
		loop 3
		cel 1
	)

	(method (doVerb theVerb)
		(plant1 doVerb: theVerb)
	)
)

(instance plant3 of View
	(properties
		noun 8
		x 66
		y 102
		view 407
		loop 3
		cel 2
	)

	(method (doVerb theVerb)
		(plant1 doVerb: theVerb)
	)
)

(instance theCord of View
	(properties
		noun 13
		approachX 269
		approachY 86
		x 270
		y 83
		view 412
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 1 0 5) ; "You're in no condition to do that now."
						(return 1)
					)
					((not (gEgo has: 9)) ; cord
						(gEgo get: 9) ; cord
						(return 1)
					)
					(else
						(theCord dispose:)
						(ClearFlag 31)
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance larryTowel of View
	(properties
		x 62
		y 129
		view 404
		loop 4
	)
)

(instance girlShowerDoor of Prop
	(properties
		noun 4
		approachX 26
		approachY 125
		x 2
		y 60
		view 400
		loop 2
	)
)

(instance manShowerDoor of Prop
	(properties
		noun 5
		approachX 80
		approachY 94
		x 79
		y 90
		view 400
		loop 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: toMensShower)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance camera of Prop
	(properties
		noun 15
		x 37
		y 25
		view 400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; wrench
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 1 0 5) ; "You're in no condition to do that now."
						(return 1)
					)
					((IsFlag 32)
						(gCurRoom setScript: turnCamera)
					)
					(else
						(gMessager say: 15 4 12) ; "You can't reach the camera from down here. It's far from the floor, above those plants."
						(return 1)
					)
				)
			)
			(4 ; Do
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 1 0 5) ; "You're in no condition to do that now."
						(return 1)
					)
					((IsFlag 32)
						(gCurRoom setScript: tryToTurn)
					)
					(else
						(gMessager say: 15 4 12) ; "You can't reach the camera from down here. It's far from the floor, above those plants."
						(return 1)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 18)
					(gMessager say: 15 1 1) ; "The video camera is now aimed directly into the women's shower. Too bad you didn't bring your miniature wireless remote video monitor."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steamDoor of Prop
	(properties
		noun 7
		approachX 176
		approachY 92
		x 161
		y 84
		view 400
		loop 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== (gEgo view:) 351)
				(gMessager say: 7 4 4) ; "You can't leave here covered with mud."
			else
				(gCurRoom setScript: toSteamRoom)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shockDoor of Prop
	(properties
		noun 6
		approachX 293
		approachY 99
		x 282
		y 92
		view 400
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 203))
						(gMessager say: 6 4 6) ; "You try the knob but the door is kept locked by an electronic keypad with billions and billions of possible combinations. We'll pause a moment while you enter every one of them."
					)
					((== (gEgo view:) 351)
						(gMessager say: 6 4 4) ; "You can't leave here covered with mud."
					)
					(else
						(gCurRoom setScript: toShockRoom)
					)
				)
			)
			(26 ; cord
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 6 26 2) ; "You decide to wait until you're fully clothed before bothering further with the electrical cord."
						(return 1)
					)
					((IsFlag 31)
						(gCurRoom setScript: touchPad)
					)
					(else
						(gMessager say: 6 26 7) ; "You get a wild idea: use the electrical cord to short-circuit the electronic door lock. But just wrapping the wire around the lock does nothing."
						(return 1)
					)
				)
			)
			(27 ; cord [ stripped ]
				(cond
					((!= (gEgo view:) 900)
						(gMessager say: 6 27 2) ; "You decide to wait until you're fully clothed before bothering further with the electrical cord."
						(return 1)
					)
					((IsFlag 31)
						(gCurRoom setScript: openShockDoor)
					)
					(else
						(gMessager say: 6 27 7 0 self) ; "You tentatively place the bare end of the electrical cord on the door's electronic lock and wait for something to happen. Nothing does."
					)
				)
			)
			(1 ; Look
				(if (not (IsFlag 203))
					(gMessager say: 6 1 6) ; "This door bears a tiny brass plaque with the delicate La Costa Lotta logo and the words, "Electroshock Exercise Center.""
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if (not (IsFlag 203))
					(gMessager say: 6 2 6) ; "Please, open up!"
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Zipper
				(if (not (IsFlag 203))
					(gMessager say: 6 6 6) ; "Whizzing on the electronic lock won't help; it's waterproof."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance socket of Feature
	(properties
		noun 9
		nsLeft 260
		nsTop 68
		nsRight 276
		nsBottom 89
		approachX 267
		approachY 94
		x 268
		y 78
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (IsFlag 203)) (IsFlag 31))
					(gEgo get: 9) ; cord
					(ClearFlag 31)
				else
					(super doVerb: theVerb)
				)
			)
			(26 ; cord
				(if (!= (gEgo view:) 900)
					(gMessager say: 1 0 5) ; "You're in no condition to do that now."
					(return 1)
				else
					(gCurRoom setScript: plugInCord 0 0)
				)
			)
			(27 ; cord [ stripped ]
				(if (!= (gEgo view:) 900)
					(gMessager say: 1 0 5) ; "You're in no condition to do that now."
					(return 1)
				else
					(gCurRoom setScript: plugInCord 0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftGlass of Feature
	(properties
		noun 3
		approachX 108
		approachY 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 43 102 44 89 38 79 30 77 16 91 13 143 12 145 22 139 33
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightGlass of Feature
	(properties
		noun 3
		approachX 232
		approachY 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 15 266 15 270 18 263 32 246 45 228 45 217 41 206 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bath1 of Feature
	(properties
		noun 12
		approachX 62
		approachY 129
	)

	(method (onMe param1)
		(return (local0 onMe: (param1 x:) (param1 y:)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (gEgo view:) 353)
						(gCurRoom setScript: jumpInMud)
					)
					((== (gEgo view:) 900)
						(gCurRoom setScript: muddyDeath)
					)
					(else
						(gMessager say: 12 4 4) ; "You've had enough mud for this game!"
						(return 1)
					)
				)
			)
			(1 ; Look
				(gMessager say: 12 1 0 3) ; "This mud bath looks juuuuuu-st right!"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bath2 of Feature
	(properties
		noun 12
	)

	(method (onMe param1)
		(return (local1 onMe: (param1 x:) (param1 y:)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(bath1 doVerb: theVerb)
			)
			(1 ; Look
				(gMessager say: 12 1 0 2) ; "This mud bath looks too cold."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bath3 of Feature
	(properties
		noun 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 136 173 130 180 122 209 109 225 108 216 113 213 121 209 128 195 132 183 138 169 138 166 137
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(bath1 doVerb: theVerb)
			)
			(1 ; Look
				(gMessager say: 12 1 0 1) ; "This mud bath looks too hot."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance charBath of Feature
	(properties
		noun 19
		approachX 268
		approachY 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 138 201 135 247 106 276 111 238 138 201 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (not (gCurRoom script:)) (gCast contains: chardonnay))
					(gCurRoom setScript: checkOutChar)
				else
					(bath2 doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance newPlant of Feature
	(properties
		noun 8
		approachX 232
		approachY 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 62 212 47 229 45 245 48 251 63 245 74 233 82 225 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lock of Feature
	(properties
		noun 10
		approachX 293
		approachY 99
		y 91
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(shockDoor doVerb: theVerb)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 66 302 66 301 76 293 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties)
)

(instance bubbleFx of Sound
	(properties)
)

(instance takePlantsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 406)
				(gEgo setMotion: PolyPath 34 109 self)
			)
			(1
				(gEgo
					setSpeed: 12
					view: 406
					loop: 2
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(= ticks 11)
			)
			(3
				(gEgo cel: 4 setCycle: End self)
				(plant1 hide:)
			)
			(4
				(plant1 ignoreActors: 1 show: posn: 41 108 loop: 0 setCel: 0)
				(gEgo
					normalize: 900
					setSpeed: 6
					setMotion: PolyPath 40 113 self
				)
			)
			(5
				(gEgo
					view: 406
					setSpeed: 12
					loop: 1
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(6
				(= ticks 11)
			)
			(7
				(plant2 hide:)
				(gEgo cel: 4 setCycle: End self)
			)
			(8
				(plant2 ignoreActors: 1 show: posn: 44 110 loop: 1 setCel: 0)
				(gEgo
					normalize: 900
					setSpeed: 6
					setMotion: PolyPath 48 114 self
				)
			)
			(9
				(gEgo
					view: 406
					setSpeed: 12
					loop: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(10
				(= ticks 11)
			)
			(11
				(plant3 hide:)
				(gEgo cel: 4 setCycle: End self)
			)
			(12
				(plant3 ignoreActors: 1 show: posn: 54 112 loop: 2 setCel: 0)
				(gGame changeScore: 5 199)
				(gEgo normalize: 900 setMotion: PolyPath 62 123 self)
				(manShowerDoor setPri: -1)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

