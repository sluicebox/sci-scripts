;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Talker)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
	studioNarrator 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm220 of Room
	(properties
		noun 1
		picture 220
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(= local6 (Random 0 1))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 106 123 113 123 109 130 76 126 74 128 102 132 94 138 60 137 43 147 285 140 281 134 195 138 181 115 253 115 247 109 160 110 161 116 124 116 120 108 89 108 81 113 95 113 94 120
					yourself:
				)
		)
		(Load rsMESSAGE 220)
		(Load rsSCRIPT 221)
		(gEgo
			view: 901
			setCel: 0
			setLoop: 0
			signal: (| $1000 (gEgo signal:))
			init:
			setCycle: StopWalk -1
			state: 2
			ignoreActors: 1
			setScaler: Scaler 100 88 107 100
			posn: 94 114
		)
		(curtainDoor init:)
		(fridge init:)
		(chair init:)
		(bathRoom init:)
		(bed init:)
		(bookShelf init:)
		(closet init:)
		(booksOnDesk init:)
		(desk init:)
		(dresser init:)
		(beads init:)
		(theMask init:)
		(pencils init:)
		(radio init:)
		(robe init:)
		(rug init:)
		(trunk init:)
		(typeWritter init:)
		(trashCan init:)
		(medCabinet init:)
		(leftLamp init:)
		(middleLamp init:)
		(rightLamp init:)
		(poster init:)
		(phone init:)
		(if (not (gEgo has: 73)) ; lit_flash
			(theFlashLight init:)
		)
		(if (not (gEgo has: 46)) ; hair_gel
			(theHairGel init:)
		)
		(gWalkHandler add: self)
		(gWalkHandler add: curtainDoor)
		(= gNarrator studioNarrator)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(if (!= global178 46)
					(gEgo setLoop: 1 posn: 185 126)
					(mosely init: posn: 155 126 setCycle: StopWalk -1)
					(if (IsFlag 326)
						(mosely setScript: moselyLeaves)
					else
						(UpdateScreenItem mosely)
						(mosely setScript: playItAgainMosely)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PBarredAccess
									init: 138 126 153 119 170 124 157 132
									yourself:
								)
						)
					)
				else
					(gEgo setLoop: 1 posn: 104 126 setScript: hangUpWithWolf)
				)
			)
			((== gDay 7)
				(if (not (IsFlag 10))
					(if (IsFlag 279)
						(ClearFlag 279)
					)
					(gCurRoom setScript: wakeUp)
				)
			)
			((and (== gDay 10) (not (IsFlag 326)))
				(if (IsFlag 279)
					(ClearFlag 279)
				)
				(gEgo setScript: gabAndMosely)
			)
			(else
				(gEgo setScript: enterTheRoom)
			)
		)
		(cond
			((and (== gDay 10) (!= gPrevRoomNum 50)) ; interrogation
				(gGkMusic1
					number: 226
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 25 10 0
				)
			)
			((IsFlag 279)
				(gGkMusic1
					number:
						(cond
							((== gDay 7) 225)
							(local6 220)
							(else 11)
						)
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 25 10 0
				)
				(gCurRoom setScript: theRadioIsOn)
			)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(= gNarrator GKNarrator)
		(gWalkHandler delete: self)
		(gWalkHandler delete: curtainDoor)
		(DisposeScript 64956)
		(DisposeScript 64935)
		(DisposeScript 221)
		(DisposeScript 64939)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 352)
			(curtainDoor init:)
			(fridge init:)
			(chair init:)
			(bathRoom init:)
			(bed init:)
			(bookShelf init:)
			(closet init:)
			(booksOnDesk init:)
			(desk init:)
			(dresser init:)
			(beads init:)
			(theMask init:)
			(pencils init:)
			(radio init:)
			(robe init:)
			(rug init:)
			(trunk init:)
			(typeWritter init:)
			(trashCan init:)
			(ClearFlag 352)
		)
		(if (IsFlag 209)
			(curtainDoor dispose:)
			(fridge dispose:)
			(chair dispose:)
			(bathRoom dispose:)
			(bed dispose:)
			(bookShelf dispose:)
			(closet dispose:)
			(booksOnDesk dispose:)
			(desk dispose:)
			(dresser dispose:)
			(beads dispose:)
			(theMask dispose:)
			(pencils dispose:)
			(radio dispose:)
			(robe dispose:)
			(rug dispose:)
			(trunk dispose:)
			(typeWritter dispose:)
			(trashCan dispose:)
			(ClearFlag 209)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gEgo setScript: standUp)
					(return 1)
				)
			)
			(10 ; Ask
				(if local1
					(gMessager say: noun theVerb 49 0) ; "Mosely is the only person here to talk to."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(11 ; Talk
				(if local1
					(gMessager say: noun theVerb 49 0) ; "Mosely is the only person here to talk to."
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

(instance studioNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self fore: 7 back: global214 font: gUserFont talkWidth: 314 x: 0 y: 157)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(2 21)
				(8 30)
				(45 26)
				(58 59)
				(59 44)
				(55 46)
				(56 25)
				(33 55)
				(57 61)
				(48 35)
				(49 21)
				(50 37)
				(51 34)
				(52 43)
				(53 9)
				(54 58)
				(46 11)
				(12 10)
				(else 7)
			)
		)
		(switch global180
			(1
				(if (== (gEgo view:) 901)
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
					(= local5 (gEgo cycleSpeed:))
					(= temp1 (gEgo cel:))
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldCel: (gEgo cel:)
						view: temp0
						setLoop: temp1
						setCel: 0
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
			(2
				(if (and (gCast contains: grace) (IsFlag 361))
					(= local2 1)
					(if local4
						(grace
							view: 2202
							setCel: 0
							setLoop: 3 1
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					else
						(grace
							view: 2222
							setCel: 0
							setLoop: 0
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					)
				)
			)
			(8
				(if (gCast contains: mosely)
					(= local3 1)
					(moselyHead
						init:
						setPri: 116
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setCel: (gEgo oldCel:)
				setLoop: (gEgo oldLoop:)
				talking: 0
				setSpeed: local5
				setCycle: StopWalk -1
			)
		)
		(if local2
			(= local2 0)
			(if local4
				(grace posn: 184 124 view: 2202 setLoop: 3 setCel: 0)
			else
				(grace view: 223 setLoop: 0 setCycle: StopWalk -1)
			)
		)
		(if local3
			(moselyHead dispose:)
			(= local3 0)
		)
		(super dispose:)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gCurRoom script:) theRadioIsOn)
					(theRadioIsOn dispose:)
				)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 101 116 self)
			)
			(2
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gEgo
					view: 221
					setLoop: 1
					setCel: 0
					posn: 87 113
					setCycle: End self
				)
				(gGkSound1 number: 215 play: self)
			)
			(3)
			(4
				(gEgo normalize: hide:)
				(gCurRoom newRoom: 210) ; bookstore
			)
		)
	)
)

(instance enterTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 107 114 normalize: 0 901 ignoreActors: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(if (IsFlag 303)
					(if (IsFlag 279)
						(theRadioIsOn dispose:)
					)
					(gEgo setScript: doTheTattoo)
				)
			)
		)
	)
)

(instance openTheFridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 141 118 self)
			)
			(2
				(gEgo view: 227 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(= cycles 15)
			)
			(4
				(gMessager say: 7 6 0 1 self) ; "Gabriel! Shut that refrigerator, please! I can smell it from here!"
			)
			(5
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(6
				(gEgo normalize: 3 901 ignoreActors: 1)
				(= cycles 1)
			)
			(7
				(gMessager say: 7 6 0 2 self) ; "Women!"
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 96 129 self)
			)
			(1
				(gEgo
					view: 2271
					setCel: 0
					setLoop: 0 1
					posn: 82 127
					setCycle: End self
				)
			)
			(2
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2271 setCel: 0 setLoop: 4 setCycle: End self)
				(= local0 0)
			)
			(1
				(gGame handsOn:)
				(gEgo normalize: 2 901 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance egoTypes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo
					view: 2271
					setCel: 0
					setLoop: 3
					setCycle: ForwardCounter 2 self
				)
			)
			(2
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gMessager say: 9 8 0 0) ; "Writer's block."
				(self setScript: standUp self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance lieDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 253 115 self)
			)
			(2
				(gEgo
					view: 2281
					setCel: 0
					setLoop: 0
					posn: 253 104
					setPri: 130
					setCycle: End self
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 2 901 ignoreActors: 1 posn: 253 115)
				(gMessager say: 2 8 0 0) ; "It's no use. I can't sleep."
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance operateRadio of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 79 138 self)
			)
			(2
				(gEgo view: 228 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(if (IsFlag 279)
					(ClearFlag 279)
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gGkMusic1 stop:)
					(theRadioIsOn dispose:)
				else
					(SetFlag 279)
					(gGkMusic1
						number: (if local6 220 else 11)
						setLoop: -1
						play:
						setVol: 0
						fade: (gGkMusic1 musicVolume:) 25 10 0
					)
					(gCurRoom setScript: theRadioIsOn)
				)
				(self cue:)
			)
			(4
				(gEgo normalize: 1 901 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theRadioIsOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (gNarrator dialog:)
					(self cue:)
				else
					(gMessager say: 23 0 1 (Random 1 6) self)
				)
			)
			(2
				(= seconds 15)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance doTheTattoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 361)
				(gGame handsOff:)
				(Load rsVIEW 221)
				(gEgo ignoreActors: 1 setMotion: MoveTo 193 126 self)
				(UpdateScreenItem gEgo)
				(grace
					setLoop: 0 1
					setCycle: Walk
					ignoreActors: 1
					init:
					setMotion: MoveTo 166 127 self
				)
				(gMessager say: 23 0 32 1) ; "(GETTING READY TO DO TATTOO ON HIS CHEST. BUSINESS-LIKE.)All right. Let's go. The shirt please."
			)
			(1
				(grace setLoop: 0 setCel: 5)
			)
			(2
				(Face gEgo grace self)
			)
			(3
				(= cycles 3)
			)
			(4
				(gMessager sayRange: 23 0 32 2 3 self) ; "(FAKING FLIRTATIOUSNESS)You don't know how long I've been waiting for this moment."
			)
			(5
				(gEgo view: 2201 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(SetFlag 361)
				(= local4 1)
				(grace
					view: 2202
					setCel: 0
					setLoop: 0
					posn: 184 124
					setPri: 127
					setCycle: End self
				)
			)
			(9
				(gMessager sayRange: 23 0 32 4 7 self) ; "Hold still!"
			)
			(10
				(ClearFlag 361)
				(= local4 0)
				(gEgo hide:)
				(grace
					view: 2202
					setCel: 0
					setLoop: 1
					posn: 193 126
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(11
				(gEgo show: view: 2203 setLoop: 0 setCel: 0)
				(grace
					view: 2202
					posn: 184 124
					setLoop: 2
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(gMessager sayRange: 23 0 32 8 9 self) ; "Done. It's just stunning."
			)
			(12)
			(13
				(graceHead
					view: 2202
					setLoop: 4 1
					setCel: 0
					init:
					setPri: 199
					setCycle: RandCycle
				)
				(gMessager say: 23 0 32 10 self) ; "(ARCC)Well, it was about what I expected from you."
			)
			(14
				(graceHead dispose:)
				(gEgo view: 2203 setCel: 0 setLoop: 0 setCycle: End self)
				(grace
					setPri: -1
					view: 224
					setCel: 0
					setLoop: 1 1
					setCycle: Walk
					setMotion: PolyPath 101 116 self
				)
			)
			(15)
			(16
				(grace
					view: 221
					setCel: 0
					setLoop: 2
					posn: 87 113
					setCycle: End
				)
				(gGkSound1 number: 215 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(17
				(gEgo
					normalize: 1 901
					put: 26 ; tatooTrace
					ignoreActors: 1
					setMotion: MoveTo 183 126 self
				)
			)
			(18
				(if (IsFlag 279)
					(gCurRoom setScript: theRadioIsOn)
				)
				(SetFlag 361)
				(grace dispose:)
				(ClearFlag 303)
				(SetFlag 299)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useThePhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 279)
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(theRadioIsOn dispose:)
				)
				(gEgo setMotion: PolyPath 104 126 self)
			)
			(1
				(SetFlag 209)
				(gEgo view: 226 setCel: 0 setLoop: 0 setCycle: CT 8 1 self)
			)
			(2
				(phone cel: 1)
				(gEgo view: 226 setCel: 9 setLoop: 0 setCycle: End self)
			)
			(3
				(self setScript: (ScriptID 221 0) self) ; dialThePhone
			)
			(4
				(if (IsFlag 324)
					(ClearFlag 324)
					(= global178 46)
					(gCurRoom newRoom: 50) ; interrogation
				else
					(gGame handsOff:)
					(gEgo setCycle: CT 8 -1 self)
				)
			)
			(5
				(phone cel: 0)
				(gEgo setCel: 7 setCycle: Beg self)
			)
			(6
				(if (IsFlag 279)
					(gCurRoom setScript: theRadioIsOn)
				)
				(SetFlag 352)
				(gEgo normalize: 1 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 221)
				(Load rsVIEW 2221)
				(Load rsVIEW 2222)
				(gEgo
					view: 222
					setCel: 0
					setLoop: 1
					posn: 245 133
					cycleSpeed: 10
					setCycle: Osc 2 self
				)
				(UpdateScreenItem gEgo)
				(gMessager say: 23 0 33 1) ; "Gabriel! Gabriel, wake up!"
			)
			(1
				(gEgo view: 222 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(grace
					posn: 220 135
					setLooper: Grooper
					init:
					setCycle: StopWalk -1
				)
				(gEgo
					view: 222
					setLoop: 4
					setCel: 0
					posn: 246 111
					setPri: 130
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 5 setCel: 0 setCycle: End self)
				(SetFlag 361)
				(gMessager sayRange: 23 0 33 2 3 self) ; "Ow! My head!"
			)
			(4)
			(5
				(ClearFlag 361)
				(grace setMotion: PolyPath 169 111 self)
				(gMessager say: 23 0 33 4 self) ; "I had another dream."
			)
			(6)
			(7
				(gMessager say: 23 0 33 5 self) ; "(ARCC)It wasn't a dream, believe me. Now come on, get dressed."
				(grace
					view: 2221
					setCel: 0
					setLoop: 0
					setPri: 125
					setCycle: End self
				)
			)
			(8)
			(9
				(SetFlag 361)
				(gMessager say: 23 0 33 6) ; "Wait a minute! I'm starting to remember. Something about Malia...."
				(grace view: 223 setLoop: 3 setCycle: StopWalk -1)
				(Face grace gEgo)
				(gEgo view: 2221 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(11
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(13
				(gEgo
					normalize: 3 901
					posn: 246 129
					setMotion: MoveTo 240 135 self
				)
			)
			(14
				(Face gEgo grace self)
			)
			(15
				(gMessager sayRange: 23 0 33 7 23 self) ; "She's the head priestess of the Voodoo cartel. They're responsible for the murders--they've been doing it for years."
			)
			(16
				(grace
					setPri: -1
					view: 223
					setCycle: StopWalk -1
					setMotion: PolyPath 101 116 self
				)
			)
			(17
				(grace
					view: 221
					setCel: 0
					setLoop: 2
					posn: 87 113
					setCycle: End self
				)
				(gGkSound1 number: 215 setLoop: 1 play:)
			)
			(18
				(SetFlag 10)
				(grace dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gabAndMosely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 94 114
					ignoreActors: 1
					setMotion: PolyPath 185 126 self
				)
				(mosely
					init:
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					ignoreActors: 1
					setMotion: MoveTo 155 126
				)
			)
			(1
				(Face gEgo mosely self)
			)
			(2
				(gMessager say: 23 0 48 0 self) ; "Okay. Now let's talk."
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 138 126 153 119 170 124 157 132
							yourself:
						)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateMosely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 185) (!= (gEgo y:) 126))
					(gEgo setMotion: PolyPath 185 126 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo mosely self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 35 10 0 0 self) ; "All right, let's talk."
			)
			(4
				(= global178 8)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance talkToMosely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 185) (!= (gEgo y:) 126))
					(gEgo setMotion: PolyPath 185 126 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo mosely self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 35 11 0 0 self) ; "So, what's up?"
			)
			(4
				(gGame handsOn:)
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
				(Load rsVIEW 2212)
				(gEgo put: 18) ; tracker
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 2212 setCel: 0 setLoop: 0 setCycle: End self)
				(UpdateScreenItem gEgo)
				(gMessager say: 23 0 52 1 self) ; "Here's the tracker."
				(mosely hide:)
			)
			(2)
			(3
				(gEgo normalize: 1 901)
				(mosely show: view: 2212 setCel: 0 setLoop: 2)
				(moselyHead init: setPri: 116 setCycle: RandCycle)
				(gMessager say: 23 0 52 2 self) ; "Great. Don't forget to leave the signal device near the entrance to the hounfour...and be careful."
			)
			(4
				(mosely
					view: 245
					loop: 0
					setLoop: -1
					setLooper: Grooper
					ignoreActors: 1
					setMotion: MoveTo 101 116 self
				)
			)
			(5
				(mosely
					view: 2211
					setCel: 0
					setLoop: 1
					posn: 87 113
					setCycle: End self
				)
			)
			(6
				(mosely hide:)
				(= seconds 4)
			)
			(7
				(gGkSound1 number: 373 setLoop: 1 play: self)
			)
			(8
				(gGkSound1 number: 374 setLoop: 1 play:)
				(gMessager say: 23 0 52 3 self) ; "You too."
			)
			(9
				(gEgo getPoints: -999 2)
				(mosely dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playItAgainMosely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 23 0 53 0 self) ; "I'm not sure we've quite got it right, Knight."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheFlashLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 221 111 self)
			)
			(2
				(gEgo view: 2282 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(3
				(theFlashLight hide:)
				(gEgo get: 73 setCel: 3 setCycle: End self) ; lit_flash
				(gMessager say: 32 12 0 0) ; "I might need a flashlight."
			)
			(4
				(theFlashLight dispose:)
				(gEgo
					get: 73 ; lit_flash
					getPoints: -999 1
					normalize: 0 901
					ignoreActors: 1
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheGel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 115 108 self)
			)
			(2
				(gEgo setMotion: MoveTo 109 102 self)
			)
			(3
				(gEgo view: 2282 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
				(gMessager say: 36 12 55 0) ; "I'll take this hair gel. You never know when you'll need a touch up."
			)
			(4
				(theHairGel dispose:)
				(gEgo setCel: 4 get: 46 setCycle: End self) ; hair_gel
			)
			(5
				(gEgo
					normalize: 3 901
					getPoints: -999 1
					setMotion: MoveTo 115 108 self
				)
			)
			(6
				(SetFlag 378)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hangUpWithWolf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo view: 226 setCel: 13 setLoop: 0 setCycle: CT 8 -1 self)
			)
			(2
				(phone cel: 0)
				(gEgo setCel: 7 setCycle: Beg self)
			)
			(3
				(gEgo normalize: 1 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance grace of Actor
	(properties
		x 100
		y 115
		view 223
	)
)

(instance mosely of Actor
	(properties
		noun 35
		sightAngle 20
		x 100
		y 115
		view 245
		signal 4129
	)

	(method (init)
		(super init:)
		(= local1 1)
	)

	(method (dispose)
		(super dispose:)
		(= local1 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Ask
				(gEgo setScript: interrogateMosely)
			)
			(29 ; wallet
				(super doVerb: theVerb)
				(gEgo put: 72) ; wallet
			)
			(86 ; master_card
				(super doVerb: theVerb)
				(gEgo put: 71) ; master_card
			)
			(11 ; Talk
				(gEgo setScript: talkToMosely)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moselyHead of Prop
	(properties
		x 155
		y 79
		view 2212
		loop 1
	)
)

(instance graceHead of Prop
	(properties
		x 176
		y 82
		view 2202
		loop 4
	)
)

(instance phone of View
	(properties
		noun 24
		x 95
		y 106
		view 226
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 120)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (== gDay 10)
					(if local1
						(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
					else
						(gMessager say: noun theVerb 51 0) ; "There's no more time for phone calls, and 911 can't help Gabriel now."
					)
				else
					(gEgo setScript: useThePhone)
				)
			)
			(12 ; Pickup
				(if (== gDay 10)
					(if local1
						(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
					else
						(gMessager say: noun theVerb 51 0) ; "There's no more time for phone calls, and 911 can't help Gabriel now."
					)
				else
					(gEgo setScript: useThePhone)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theFlashLight of View
	(properties
		noun 32
		x 236
		y 78
		view 2282
		loop 2
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: getTheFlashLight)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHairGel of View
	(properties
		noun 36
		x 122
		y 66
		view 2282
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 378)
					(gMessager say: noun theVerb 56 0) ; "The medicine cabinet contains a few old prescriptions, personal hygiene stuff, and lots of hair products."
				else
					(gMessager say: noun theVerb 55 0) ; "The medicine cabinet contains a few old prescriptions, personal hygiene stuff, and lots of hair products, including some hair gel."
				)
			)
			(12 ; Pickup
				(if (IsFlag 378)
					(gMessager say: noun theVerb 56 0) ; "There's nothing else Gabriel needs from the medicine cabinet."
				else
					(gEgo setScript: getTheGel)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance curtainDoor of Feature
	(properties
		noun 21
		sightAngle 20
		x 77
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 115 64 41 87 45 88 111
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if local1
					(gMessager say: noun theVerb 49 0) ; "How about going out to the shop for a minute?"
				else
					(gEgo setScript: leaveTheRoom)
				)
			)
			(8 ; Operate
				(if local1
					(gMessager say: noun 6 49 0) ; "How about going out to the shop for a minute?"
				else
					(gEgo setScript: leaveTheRoom)
				)
			)
			(13 ; Walk
				(if local1
					(gMessager say: noun 6 49 0) ; "How about going out to the shop for a minute?"
				else
					(gEgo setScript: leaveTheRoom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fridge of Feature
	(properties
		noun 7
		nsLeft 132
		nsTop 91
		nsRight 153
		nsBottom 113
		sightAngle 30
		x 135
		y 95
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if (== gDay 10)
					(if local1
						(gMessager say: noun 6 49 0) ; "Not while Mosely's here."
					else
						(gMessager say: noun 6 51 0) ; "Gabriel can't even think about food--much less what might be in that refrigerator--while Grace is missing."
					)
				else
					(gEgo setScript: openTheFridge)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair of Feature
	(properties
		noun 14
		sightAngle 30
		x 94
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 125 81 114 93 112 100 99 107 99 99 125
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((== gDay 10)
						(if local1
							(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
						else
							(gMessager say: noun theVerb 51 0) ; "There's no time for that! Grace is missing!"
						)
					)
					(local0
						(gEgo setScript: standUp)
					)
					(else
						(gEgo setScript: sitDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bathRoom of Feature
	(properties
		noun 8
		nsLeft 99
		nsTop 49
		nsRight 133
		nsBottom 108
		sightAngle 30
		x 119
		y 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(if local1
					(gMessager say: 1 theVerb 49 0) ; "Mosely is the only person here to talk to."
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

(instance bed of Feature
	(properties
		noun 2
		sightAngle 30
		x 250
		y 119
		z 10
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 98 261 91 278 86 305 98 304 122 269 123 270 132 213 137 192 118 191 104
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((not (== gDay 10))
						(gEgo setScript: lieDown)
					)
					(local1
						(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
					)
					(else
						(gMessager say: noun theVerb 51 0) ; "There's no time for that! Grace is missing!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookShelf of Feature
	(properties
		noun 22
		nsLeft 20
		nsTop 42
		nsRight 61
		nsBottom 88
		sightAngle 30
		x 43
		y 79
	)
)

(instance closet of Feature
	(properties
		noun 13
		nsLeft 151
		nsTop 48
		nsRight 185
		nsBottom 106
		sightAngle 30
		x 168
		y 66
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (IsFlag 269)
					(gMessager say: noun theVerb 57 0) ; "I think I'll travel light."
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

(instance booksOnDesk of Feature
	(properties
		noun 18
		sightAngle 30
		x 37
		y 104
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 33 100 43 101 43 108 27 113 26 103
					yourself:
				)
		)
	)
)

(instance desk of Feature
	(properties
		noun 6
		sightAngle 30
		x 72
		y 105
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 117 31 112 68 97 94 98 94 109 86 113 83 106 68 113 68 129 59 134
					yourself:
				)
		)
	)
)

(instance dresser of Feature
	(properties
		noun 12
		nsLeft 196
		nsTop 81
		nsRight 240
		nsBottom 103
		sightAngle 30
		x 218
		y 89
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(if (IsFlag 269)
					(gMessager say: noun theVerb 57 0) ; "I think I'll travel light."
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

(instance beads of Feature
	(properties
		noun 10
		sightAngle 30
		x 32
		y 142
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 146 26 133 81 145 yourself:)
		)
	)
)

(instance theMask of Feature
	(properties
		noun 4
		nsTop 89
		nsRight 23
		nsBottom 137
		sightAngle 30
		x 12
		y 119
	)
)

(instance poster of Feature
	(properties
		noun 3
		nsLeft 200
		nsTop 46
		nsRight 234
		nsBottom 76
		sightAngle 30
		x 217
		y 60
	)
)

(instance pencils of Feature
	(properties
		noun 19
		nsLeft 70
		nsTop 91
		nsRight 76
		nsBottom 100
		sightAngle 30
		x 72
		y 95
	)
)

(instance radio of Feature
	(properties
		noun 15
		sightAngle 30
		x 42
		y 123
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 115 52 116 52 124 35 131 30 131 30 122
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (== gDay 10)
					(if local1
						(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
					else
						(gMessager say: noun theVerb 51 0) ; "There's no time for that! Grace is missing!"
					)
				else
					(gEgo setScript: operateRadio)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robe of Feature
	(properties
		noun 20
		sightAngle 30
		x 189
		y 81
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 111 184 107 180 86 192 62 198 103 190 103
					yourself:
				)
		)
	)
)

(instance rug of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 117 190 117 220 139 84 140
					yourself:
				)
		)
	)
)

(instance trunk of Feature
	(properties
		noun 17
		sightAngle 30
		x 50
		y 130
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 125 60 135 49 139 30 133 53 124
					yourself:
				)
		)
	)
)

(instance typeWritter of Feature
	(properties
		noun 9
		nsLeft 53
		nsTop 97
		nsRight 75
		nsBottom 108
		sightAngle 30
		x 65
		y 108
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (== gDay 10)
					(if local1
						(gMessager say: noun theVerb 49 0) ; "Not while Mosely's here."
					else
						(gMessager say: noun theVerb 51 0) ; "There's no time for that! Grace is missing!"
					)
				else
					(gEgo setScript: egoTypes)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trashCan of Feature
	(properties
		noun 16
		nsLeft 66
		nsTop 121
		nsRight 81
		nsBottom 133
		sightAngle 30
		x 75
		y 128
	)
)

(instance medCabinet of Feature
	(properties
		noun 36
		nsLeft 118
		nsTop 51
		nsRight 130
		nsBottom 70
		sightAngle 20
		x 127
		y 65
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 378)
					(gMessager say: noun theVerb 56 0) ; "The medicine cabinet contains a few old prescriptions, personal hygiene stuff, and lots of hair products."
				else
					(gMessager say: noun theVerb 55 0) ; "The medicine cabinet contains a few old prescriptions, personal hygiene stuff, and lots of hair products, including some hair gel."
				)
			)
			(12 ; Pickup
				(if (IsFlag 378)
					(gMessager say: noun theVerb 56 0) ; "There's nothing else Gabriel needs from the medicine cabinet."
				else
					(gEgo setScript: getTheGel)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middleLamp of Feature
	(properties
		noun 11
		nsLeft 201
		nsTop 66
		nsRight 214
		nsBottom 82
		sightAngle 20
		x 206
		y 75
	)
)

(instance rightLamp of Feature
	(properties
		noun 11
		sightAngle 20
		x 283
		y 54
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 99 243 80 282 43 293 48 293 58 274 57 247 80 248 99
					yourself:
				)
		)
	)
)

(instance leftLamp of Feature
	(properties
		noun 11
		sightAngle 20
		x 56
		y 87
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 101 37 95 58 80 67 88 42 96 43 101
					yourself:
				)
		)
	)
)

