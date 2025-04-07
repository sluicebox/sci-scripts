;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use OccCyc)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Sight)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance rm320 of GloryRm
	(properties
		noun 48
		picture 320
	)

	(method (init)
		(= local2
			(cond
				((not (IsFlag 126)) 1)
				(
					(and
						(IsFlag 37)
						(OneOf gTime 4 5)
						(not (IsFlag 39))
						(not (IsFlag 48))
						(not (IsFlag 131))
					)
					6
				)
				(
					(and
						(IsFlag 48)
						(IsFlag 39)
						(not (IsFlag 132))
						(OneOf gTime 4 5)
					)
					7
				)
				(
					(and
						(>= gTime 6)
						(IsFlag 128)
						(not (IsFlag 135))
						(>= gDay (+ gPrevDomoTalkDayNumber 1))
						(not (IsFlag 138))
					)
					13
				)
				(
					(and
						(>= gTime 6)
						(IsFlag 136)
						(not (IsFlag 137))
						(== gPrevRoomNum 330)
					)
					14
				)
				(
					(and
						(>= gTime 6)
						(IsFlag 128)
						(IsFlag 138)
						(not (IsFlag 163))
					)
					15
				)
				((and (not (IsFlag 127)) (OneOf gTime 4 5)) 2)
				((and (>= gTime 6) (not (IsFlag 128)) (not (IsFlag 136))) 3)
				(
					(and
						(IsFlag 127)
						(>= gDay 3)
						(OneOf gTime 4 5)
						(not (IsFlag 129))
						(not (IsFlag 130))
					)
					4
				)
				(
					(and
						(OneOf gTime 4 5)
						(IsFlag 130)
						(not (IsFlag 146))
						(!= gPrevRoomNum 240)
					)
					5
				)
				(
					(and
						(<= gTime 3)
						(== gHeroType 3) ; Paladin
						(IsFlag 132)
						(!= global419 0)
						(not (IsFlag 133))
					)
					8
				)
				((and (<= gTime 3) (IsFlag 115) (not (IsFlag 134))) 9)
				(
					(and
						(not (IsFlag 132))
						(or (<= gTime 3) (OneOf gTime 4 5))
					)
					10
				)
				((and (IsFlag 132) (not (IsFlag 134))) 11)
				((IsFlag 134) 12)
				(else 0)
			)
		)
		(gLongSong number: 320 setLoop: -1 play:)
		(gWalkHandler addToFront: self)
		(= local8 (IntArray with: 2 6 0 4 1 7 3 5))
		(= local9 (IntArray with: 2 4 0 6 3 7 1 5))
		(gEgo init: normalize:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 6 173 0 189 0 0 319 0 319 189 245 189 245 187 294 187 340 119 276 49 252 48 165 85 192 85 267 52 324 119 287 184 257 184 257 175 183 175 183 181 120 181 120 175 143 175 143 171 105 171 105 173 50 173 50 159 80 159 80 158 49 158 49 173
					yourself:
				)
		)
		(if (OneOf gPrevRoomNum 260 4)
			(gEgo posn: 193 270 setScaler: Scaler 130 79 189 160)
		else
			(gEgo setScaler: Scaler 63 77 88 51 looper: myLooper)
			(switch gPrevRoomNum
				(330
					(gEgo setPri: 40 posn: 273 49)
				)
				(240
					(gEgo setPri: 0 posn: 193 87)
				)
				(else
					(gEgo posn: 106 184)
				)
			)
		)
		(innkeepDoor init: approachVerbs: 4) ; Do
		(railing init: approachVerbs: 4) ; Do
		((ScriptID 325 0) init: approachVerbs: 4) ; barrel, Do
		((ScriptID 325 1) init: approachVerbs: 4) ; stool, Do
		((ScriptID 325 2) init: approachVerbs: 4) ; chair1, Do
		((ScriptID 325 3) init: approachVerbs: 4) ; chair2, Do
		((ScriptID 325 4) init: approachVerbs: 4) ; chair3, Do
		(chair4 init:)
		((ScriptID 325 5) init: approachVerbs: 4) ; leftTable, Do
		((ScriptID 325 6) init: approachVerbs: 4) ; rightTable, Do
		((ScriptID 325 7) init: approachVerbs: 4) ; firePlace, Do
		((ScriptID 325 8) init: approachVerbs: 4) ; chandelier1, Do
		((ScriptID 325 9) init: approachVerbs: 4) ; chandelier2, Do
		((ScriptID 325 10) init: approachVerbs: 4) ; boarHead, Do
		((ScriptID 325 11) init: approachVerbs: 4) ; plates, Do
		((ScriptID 325 12) init: approachVerbs: 4) ; garlic1, Do
		(cabinet init: approachVerbs: 4 1) ; Do, Look
		((ScriptID 325 13) init: approachVerbs: 4) ; ashPot, Do
		(bedroomDoor init: approachVerbs: 4) ; Do
		((ScriptID 325 14) init: approachVerbs: 4) ; door2, Do
		(gnomeDoor init: approachVerbs: 4 28 42) ; Do, theLockpick, theToolkit
		((ScriptID 325 15) init: approachVerbs: 4) ; pillar1, Do
		((ScriptID 325 16) init: approachVerbs: 4) ; pillar2, Do
		((ScriptID 325 17) init: approachVerbs: 4) ; garlic2, Do
		((ScriptID 325 18) init: approachVerbs: 4) ; garlic3, Do
		((ScriptID 325 19) init: approachVerbs: 4) ; garlic4, Do
		(fire init: setCycle: Fwd)
		(fireplaceSlab init: setCycle: Fwd)
		(woodFloor init: setCycle: Fwd)
		(jug init: setCycle: Fwd)
		(if
			(or
				(== local2 1)
				(and
					(OneOf local2 2 4 5 6 7 10 11 12)
					(OneOf gTime 4 5)
				)
			)
			(peasant1 init: approachVerbs: 4 2 setScript: sPeasantsTalk) ; Do, Talk
			(peasant2 init: approachVerbs: 4 2) ; Do, Talk
			(peasant3 init: setPri: 170 approachVerbs: 4 2) ; Do, Talk
		)
		(if
			(or
				(== local2 1)
				(and
					(OneOf local2 2 4 5 6 7 8 9 10 11 12)
					(or (OneOf gTime 4 5) (<= gTime 3))
				)
			)
			(innKeeper
				init:
				setPri: 170
				approachVerbs: 4 ; Do
				setScript: sInnKeeperSmoke
			)
		)
		(if
			(or
				(== local2 1)
				(and
					(OneOf local2 2 6 7 8 9 10 11 12)
					(or (OneOf gTime 4 5) (<= gTime 3))
				)
			)
			(bella init: approachVerbs: 4) ; Do
		)
		(if (OneOf local2 4 5)
			(gnome init: approachVerbs: 4 setPri: 180) ; Do
		)
		(if (== local2 9)
			(child init: approachVerbs: 4) ; Do
		)
		(if (OneOf local2 3 13 15)
			(domovoi init: approachVerbs: 4 2) ; Do, Talk
		)
		(super init: &rest)
		(PalVary 0 320 0) ; PalVaryStart
		(switch gPrevRoomNum
			(240
				(self setScript: sExitGnome)
			)
			(260
				(self setScript: sEnterFromTown)
			)
			(4
				(self setScript: sEnterFromTown)
			)
			(330
				(self setScript: sOutBedroomDoor)
			)
			(else
				(gGlory handsOn:)
			)
		)
	)

	(method (doit)
		(if local5
			(Palette 2 66 85 100) ; PalIntensity
		)
		(if
			(and
				(IsFlag 72)
				(gEgo mover:)
				(User canControl:)
				(User canInput:)
			)
			(gEgo setPri: 170 x: 206 y: 168 setMotion: 0)
			(= local6 (gApproachCode doit: ((gUser curEvent:) message:)))
			(= local3 gMouseX)
			(= local4 (- gMouseY 10))
			(gCurRoom setScript: sHeroSit)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if
					(and
						(<= gMouseX 248)
						(>= (- gMouseY 10) 188)
						(not (IsFlag 72))
					)
					(gEgo setScript: sExitInn)
				else
					(gEgo setMotion: PolyPath gMouseX (- gMouseY 10))
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(DisposeScript 321)
		(DisposeScript 322)
		(DisposeScript 323)
		(DisposeScript 324)
		(DisposeScript 325)
		(gWalkHandler delete: self)
		(local8 dispose:)
		(local9 dispose:)
		(super dispose: &rest)
	)
)

(instance sEnterFromTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(if (IsFlag 70)
					(ClearFlag 70)
					(gMessager say: 22 6 104 0 self) ; "The townspeople follow you into the inn."
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: MoveTo 193 184 self)
			)
			(3
				(self setScript: sInitShit self)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInitShit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(if
					(and
						(= local7
							(/ (+ (* (+ (- gDay global469) 1) 15) 99) 100)
						)
						(> local7 global468)
						(gCast contains: innKeeper)
						(or (>= ((gInventory at: 0) amount:) 1) (>= global395 100)) ; thePurse
					)
					(= local12 1)
				)
				(if
					(and
						(< (gEgo y:) 105)
						(or local12 (OneOf local2 1 4 5))
					)
					(= state 3)
					(= local11 1)
					(gEgo setMotion: PolyPath 268 51 self)
				else
					(= local11 0)
					(= cycles 1)
				)
			)
			(1
				1
				(if (OneOf local2 1 2 3 4 5 6 7 8 9 10 11 12 13 15 16)
					((ScriptID 324 0) init: local2 gEgo 324) ; heroTeller
				)
				(switch local2
					(1
						(SetFlag 126)
						(if gNight
							(SetFlag 127)
							(gMessager say: 22 6 23) ; "You've entered a small but nicely-furnished country inn. Stairs lead up to the guest bedrooms. The floor is covered with sawdust and peanut shells. A barrel contains the few shells that managed to land in it."
						else
							(gMessager say: 22 6 20) ; "You've entered a small but nicely-furnished country inn. Stairs lead up to the guest bedrooms. The floor is covered with sawdust and peanut shells. A barrel contains the few shells that managed to land in it."
						)
					)
					(2
						(SetFlag 127)
						(gMessager say: 22 6 26) ; "The inhabitants of the inn eye you suspiciously. You get the feeling that you're not particularly welcome here."
					)
					(3
						(gMessager say: 22 6 3) ; "You have the feeling you are being watched."
					)
					(4
						(self setScript: sGnomeEntertain self 1)
					)
					(5
						(SetFlag 162)
						(gMessager say: 25 6 46) ; "So you're back. No, it's your front. Take a seat, no, take two, they're small. I've got a joke just for ewe, so don't look so sheepish!"
					)
					(6
						(SetFlag 131)
						(gMessager say: 26 6 47) ; "The only good Werewolf is a dead Werewolf, I always say."
					)
					(7
						(SetFlag 132)
						(gMessager say: 26 6 48) ; "So Dmitri says the gypsy didn't really kill Igor after all."
					)
					(8
						(= cycles 1)
					)
					(9
						(SetFlag 134)
						(gMessager say: 12 6 13) ; "I must thank you for saving our Tanya. You have brought joy again into our lives. We are in your debt."
					)
					(13
						(SetFlag 135)
						(gMessager say: 22 6 28) ; "You notice the Domovoi is watching you from its usual place."
					)
					(14
						(gMessager say: 22 6 30) ; "As you enter the hallway, you hear someone faintly crying downstairs."
					)
					(15
						(SetFlag 139)
						(gMessager say: 22 6 29) ; "You see that the Domovoi is here again."
					)
				)
				(if (not (== local2 4))
					(= cycles 1)
				)
			)
			(2
				2
				(if (== local2 14)
					(gMessager say: 22 6 108 0 self) ; "The crying is coming from the door below the stairs. That's the innkeeper's room."
				else
					(= cycles 1)
				)
			)
			(3
				3
				(if local12
					(= local12 0)
					(self setScript: sPayKeeper self)
				else
					(= cycles 1)
				)
			)
			(4
				4
				(if (not local13)
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sUpStairs of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gEgo mover:))
				(gEgo cycler:)
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(= register 1)
			(self changeState: state)
		)
		(cond
			((and (== state 0) (<= (gEgo y:) 180))
				(self cue:)
			)
			((and (== state 1) (<= (gEgo y:) 128))
				(self cue:)
			)
			((and (== state 2) (<= (gEgo y:) 53))
				(self cue:)
			)
			((and (== state 3) (<= (gEgo x:) 263))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setPri: 196 setScaler: Scaler 130 77 189 51)
				(if register
					(gEgo setMotion: MoveTo 298 186 self)
				)
			)
			(1
				(if register
					(gEgo setMotion: MoveTo 341 128 self)
				)
			)
			(2
				(gEgo setPri: 64)
				(if register
					(gEgo setMotion: MoveTo 273 51 self)
				)
			)
			(3
				(gEgo setPri: -1 setScaler: Scaler 63 77 88 51)
				(if register
					(gEgo setMotion: PolyPath 263 52 self)
				)
			)
			(4
				(gEgo looper: myLooper)
				(gGlory handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sDownStairs of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gEgo mover:))
				(gEgo cycler:)
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(= register 1)
			(self changeState: state)
		)
		(cond
			((and (== state 0) (>= (gEgo y:) 128))
				(self cue:)
			)
			((and (== state 1) (>= (gEgo y:) 180))
				(self cue:)
			)
			((and (== state 2) (<= (gEgo x:) 263))
				(self cue:)
			)
			((and (== state 3) (<= (gEgo x:) 257))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setLoop: -1
					setLooper: (ScriptID 28 1) 1 ; stopGroop
					setCycle: StopWalk 5
					setHeading: 135
					setPri: 64
					setScaler: Scaler 130 77 189 51
				)
				(if register
					(gEgo setMotion: MoveTo 341 128 self)
				)
			)
			(1
				(gEgo setPri: 196)
				(if register
					(gEgo setMotion: MoveTo 298 186 self)
				)
			)
			(2
				(gEgo setScaler: Scaler 130 79 189 160)
				(if register
					(gEgo setMotion: MoveTo 263 186 self)
				)
			)
			(3
				(gEgo setPri: -1)
				(if register
					(gEgo setMotion: PolyPath 257 186 self)
				)
			)
			(4
				(if local11
					(= next sInitShit)
				)
				(gGlory handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sInBedroomDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 3 4 0 0 self) ; "You unlock the door to your room and go on in."
			)
			(1
				(gLongSong2 number: 960 loop: 1 play:)
				(bedroomDoor setCycle: End self)
			)
			(2
				(if (== local2 5)
					(self setScript: sGnomeLeaves self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo setPri: 40 setMotion: MoveTo 273 49 self)
			)
			(4
				(bedroomDoor setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(6
				(ClearFlag 162)
				(gGlory handsOn:)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance sOutBedroomDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong2 number: 960 loop: 1 play:)
				(bedroomDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 244 55 self)
			)
			(2
				(bedroomDoor setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 961 loop: 1 play:)
				(= local13 1)
				(gEgo setPri: -1)
				(self setScript: sInitShit self)
			)
			(4
				(= local13 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInnKeeperSmoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(innKeeper setCycle: OccCyc self 1 5 360 (Random 1 2) self)
			)
			(1
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sPeasantsTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= state
					(switch (Random 0 4)
						(0 0)
						(1 1)
						(2 3)
						(3 4)
						(4 5)
					)
				)
				(= seconds (Random 2 6))
			)
			(1
				1
				(= state 6)
				(peasant1 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				2
				(peasant1 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				3
				(= state 6)
				(peasant1 setCycle: Beg self)
			)
			(4
				4
				(= state 6)
				(peasant1 loop: 0 cel: 10)
				(= seconds 2)
			)
			(5
				5
				(= state 6)
				(peasant1 loop: 1 cycleSpeed: 12 setCycle: End self)
			)
			(6
				6
				(peasant2 loop: 2 cel: 0 setCycle: End self)
			)
			(7
				7
				(= cycles 6)
			)
			(8
				8
				(peasant1 loop: 0 cel: 0 cycleSpeed: 6)
				(peasant2 loop: 2 cel: 0)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sGnomeEntertain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(SetFlag 129)
				(if register
					(gnome setCycle: End self)
				else
					(self changeState: 3)
				)
			)
			(1
				1
				(gnome loop: 4 setCycle: End self)
			)
			(2
				2
				(= state 5)
				(SetFlag 162)
				(gMessager say: 25 6 45 0 self) ; "Have a seat. Wait, no, better leave the seats here. But why don't you sit down on one? This show can't get on the road until you get off your load. So sit a while and enjoy yourself. Or maybe just sit."
			)
			(3
				3
				(ClearFlag 162)
				(if (== local2 4)
					(gMessager say: 25 6 38 0 self) ; "Good Evening, ladies and germs. A funny thing happened on the way to Mordavia -- I got here."
				else
					(gMessager say: 25 6 40 0 self) ; "Good Evening, ladies and gentlemen and all you others. I'd like to say how glad I am to be here -- I'd like to say it... Seriously, folks, staying at the Hotel Mordavia has been like staying at a resort. A last resort."
				)
			)
			(4
				4
				(if (== local2 4)
					(gMessager say: 25 6 36 0 self) ; "Whew! The Gnome has stopped speaking. Maybe he's finished telling his joke. You think about applauding, but you're not quite sure if you've heard the punchline yet."
				else
					(gMessager say: 25 6 37 0 self) ; "The Gnome takes a deep bow and gets down off the stage. (That's funny, you always thought you got down off a duck.) The townspeople explode into spontaneous applause."
				)
			)
			(5
				(= state 5)
				(if (== local2 4)
					(gMessager say: 25 6 35 0 self) ; "What did you think of my performance? Was I hilarious or what?"
				else
					(gMessager say: 25 6 41 0 self) ; "Keep smiling; it makes people wonder what you've been up to. So, was that funny or are you just keeping your mouth shut?"
				)
			)
			(6
				6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHeroSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(if (IsFlag 72)
					(if
						(or
							(== local6 4)
							(&
								local6
								(| $000a ((CueObj client:) _approachVerbs:))
							)
						)
						(gEgo setMotion: 0)
						(= cycles 1)
					else
						(self changeState: 19)
					)
				else
					(self changeState: 6)
				)
			)
			(1
				1
				(ClearFlag 72)
				(gEgo setCycle: Beg self)
			)
			(2
				2
				(gEgo normalize: setPri: 168 setMotion: MoveTo 138 165 self)
			)
			(3
				3
				(if (gCast contains: gnome)
					(gnome setCycle: Beg self)
				)
				(gEgo setMotion: MoveTo 131 171 self)
			)
			(4
				4
				(if (gCast contains: gnome)
					0
				else
					(= cycles 1)
				)
			)
			(5
				5
				(gEgo setPri: -1)
				(if (& local6 (| $000a ((CueObj client:) _approachVerbs:)))
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							(+ (gEgo z:) ((CueObj client:) approachY:))
							CueObj
					)
				else
					(gEgo setMotion: PolyPath local3 local4)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
			(6
				6
				(gEgo setPri: 168 setMotion: MoveTo 138 165 self)
			)
			(7
				7
				(if (gCast contains: gnome)
					(gnome view: 322 setLoop: 4 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(8
				8
				(gEgo setMotion: MoveTo 206 168 self)
			)
			(9
				9
				(SetFlag 72)
				(if (gCast contains: tray)
					(= state 18)
				)
				(gEgo view: 54 setLoop: 4 1 cel: 0 setCycle: End self)
			)
			(10
				10
				(if (IsFlag 162)
					(self setScript: sGnomeEntertain self 0)
				else
					(= cycles 1)
				)
			)
			(11
				11
				(if
					(and
						(gCast contains: bella)
						(or
							(OneOf local2 6 7 8 9 11 12)
							(and (OneOf local2 1 2 10) (< gFreeMeals 2))
						)
					)
					(bella setCycle: Walk setMotion: MoveTo 193 159 self)
				else
					(self changeState: 19)
				)
			)
			(12
				12
				(bella setMotion: MoveTo 187 165 self)
			)
			(13
				13
				(cond
					((IsFlag 3)
						(ClearFlag 3)
					)
					((IsFlag 2)
						(ClearFlag 2)
					)
					(else
						(++ gFreeMeals)
					)
				)
				(bella
					view: 329
					loop: 0
					cel: 0
					posn: 185 161
					setCycle: End self
				)
			)
			(14
				14
				(if (>= gTime 3)
					(gMessager say: 22 6 21 (Random 1 5) self)
				else
					(gMessager say: 22 6 19 (Random 1 5) self)
				)
			)
			(15
				15
				(tray init: setPri: 175)
				(if (OneOf local2 1 2 6 10)
					(bella loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(16
				16
				(if (OneOf local2 7 8 9 11 12)
					(bella setScript: sBellaIncidental)
					(self changeState: 19)
				else
					(bella
						view: 327
						setLoop: 2 1
						cel: 0
						posn: 187 165
						setCycle: Walk
						setMotion: MoveTo 193 159 self
					)
				)
			)
			(17
				17
				(bella setMotion: MoveTo 239 159 self)
			)
			(18
				18
				(bella dispose:)
				(= cycles 1)
			)
			(19
				19
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBellaIncidental of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local2
					(7
						(gMessager say: 23 6 32 0 self) ; "It was kind of you to aid Igor. It has been a long time since we have had someone as heroic as you in Mordavia. Forgive us if we have seemed unkind to you. It is just that we have lived so long in fear."
					)
					(8
						(SetFlag 133)
						(gMessager say: 23 6 31 0 self) ; "It has been my custom to sometimes go over to the center of the town and sit by the Staff. I fell asleep there the other afternoon, and I had the most wonderful dream."
					)
					(9
						(gMessager say: 23 6 33 0 self) ; "I don't know how we can ever thank you enough. It is such a joy to have my little Tanya home again."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (== local2 8)
					((gEgo actions:) dispose:)
				)
				(= cycles 1)
			)
			(2
				(if (== local2 8)
					((ScriptID 324 0) init: 16 gEgo 324) ; heroTeller
				)
				(= cycles 1)
			)
			(3
				(bella loop: 5 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(4
				(bella loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 300)
			)
			(5
				(bella loop: 3 cel: 0 setCycle: End self)
			)
			(6
				(bella loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(= seconds 4)
			)
			(8
				(bella setCycle: Beg self)
			)
			(9
				(bella loop: 3 cel: 7 setCycle: Beg self)
			)
			(10
				(self changeState: 1)
			)
		)
	)
)

(instance sHeroShock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(gEgo view: 31 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				1
				(gLongSong2 number: 371 play:)
				(gEgo view: 31 loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				2
				(gEgo view: 31 loop: 1 cel: 2 setCycle: Beg self)
			)
			(3
				3
				(if (gEgo takeDamage: 10)
					(if register
						(= state 9)
						(= register 0)
						(gMessager say: 22 6 24 0 self) ; "A squeaky voice from beyond the door says, "Trying ta break and enter, eh? Well, forget it! I'm the only one allowed ta be rude around here.""
					else
						(gMessager say: 22 6 25 0 self) ; "A voice from behind the door says, "Oops, sorry! Seems I forgot about my burglar alarm. Hope it wasn't too shocking for you.""
					)
				else
					(EgoDead 18 320 961 1 912) ; "That one zapped you clean out of the inn... and this life."
				)
			)
			(4
				4
				(gLongSong2 number: 960 loop: 1 play:)
				(gnomeDoor setPri: 0 setCycle: End self)
			)
			(5
				5
				(gEgo normalize: 7 setMotion: MoveTo 178 87 self)
			)
			(6
				6
				(gEgo setPri: 0 setMotion: MoveTo 193 87 self)
			)
			(7
				7
				(gnomeDoor setPri: 170 setCycle: Beg self)
			)
			(8
				8
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(9
				9
				(gGlory handsOn:)
				(gEgo normalize:)
				(gCurRoom newRoom: 240)
			)
			(10
				10
				(gGlory handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo get: 33) ; theDoll
				(SetFlag 163)
				(cabinetDoor init:)
				(doll init:)
				(= seconds 3)
			)
			(1
				(doll hide:)
				(= seconds 2)
			)
			(2
				(gMessager say: 5 4 1 0 self) ; "You open the cabinet and see a lovely doll. You carefully remove the elegant doll from the cabinet and store it in your pack."
			)
			(3
				(cabinetDoor hide:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitGnome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong2 number: 960 loop: 1 play:)
				(gnomeDoor setPri: 0 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 178 87 self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 200 76 self)
			)
			(3
				(gnomeDoor setCycle: Beg self)
			)
			(4
				(gLongSong2 number: 961 loop: 1 play:)
				(self setScript: sInitShit self)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitInn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(if (< (gEgo y:) 105)
					(= state 6)
					(gEgo setMotion: PolyPath 268 51 self)
				else
					(= cycles 1)
				)
			)
			(1
				1
				(Face gEgo 193 189 self)
			)
			(2
				2
				(cond
					((<= 4 gTime 5)
						(self changeState: 3)
					)
					((<= 6 gTime 7)
						(if (gCast contains: innKeeper)
							(self changeState: 3)
						else
							(= state 6)
							(gMessager say: 22 6 16 0 self) ; "You've never seen so many locks and bars on a door; you can't find any way to open it."
						)
					)
					(else
						(self changeState: 5)
					)
				)
			)
			(3
				3
				(gMessager say: 22 6 16 0 self) ; "You've never seen so many locks and bars on a door; you can't find any way to open it."
			)
			(4
				4
				(gMessager say: 12 6 100 0 self) ; "It is very dangerous in Mordavia at night. We always keep things locked up when it gets dark. I will let you out for now."
			)
			(5
				5
				(if (== local2 5)
					(self setScript: sGnomeLeaves self)
				else
					(= cycles 1)
				)
			)
			(6
				6
				(ClearFlag 162)
				(gGlory handsOff:)
				(gCurRoom south: 260)
				(gEgo setMotion: ((ScriptID 17) new:) 193 189 self) ; pOffMover
			)
			(7
				7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPayKeeper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (>= global395 100)
					(-= global395 100)
				else
					((gInventory at: 0) ; thePurse
						amount: (- ((gInventory at: 0) amount:) local7) ; thePurse
					)
				)
				(+= global468 local7)
				(= global469 gDay)
				(gEgo setMotion: PolyPath 186 183 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gMessager say: 12 6 102 0 self) ; "You pay the innkeeper for your room and board."
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGnomeLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 146)
				(gMessager say: 25 6 39 0 self) ; "Now it's so long, it's been nice to know you. I like you -- I have no taste, but I like you. If you ever make it to Silmaria, look me up. I never forget a friend, especially if he owes me money."
			)
			(1
				(gMessager say: 25 6 42 0 self) ; "So everyone, I'll leave you with this story. A man runs up to his doctor and says, 'Doc, ya gotta help me. I keep thinking I'm a goat.'"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance gnomeDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((and (IsFlag 146) (not (gCast contains: gnome)))
					(gMessager say: 9 4 8) ; "There is no response to your knock. When you open the door, you find that the room has been cleaned out completely."
					(return 1)
				)
				(
					(or
						(<= local2 3)
						(and (== local2 10) (not (IsFlag 129)))
						(gCast contains: gnome)
					)
					(gMessager say: 9 4 103) ; "There is no response. Whoever (or whatever) is renting this room must not be there right now."
					(return 1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (showCases)
		(super showCases: 12 (or (gEgo has: 13) (gEgo has: 24))) ; Pick Lock, theLockpick, theToolkit
	)

	(method (sayMessage)
		(switch iconValue
			(9 ; Knock on Door
				(self clean:)
				(gCurRoom setScript: sHeroShock)
			)
			(11 ; Open Door
				(self clean:)
				(gCurRoom setScript: sHeroShock 0 1)
			)
			(12 ; Pick Lock
				(self clean:)
				(gCurRoom setScript: sHeroShock 0 1)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance innKeepDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				12 ; Pick Lock
				(or (gEgo has: 13) (gEgo has: 24)) ; theLockpick, theToolkit
				10 ; Listen at Door
				(or (<= local2 13) (>= local2 15))
				17 ; Listen at Door
				(and (== local2 14) (not (IsFlag 137)))
		)
	)

	(method (sayMessage)
		(if (== iconValue 17) ; Listen at Door
			(SetFlag 137)
		)
		(super sayMessage: &rest)
	)
)

(instance bella of Actor
	(properties
		noun 23
		approachX 210
		approachY 175
		x 239
		y 159
		view 327
		loop 1
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(if (OneOf local2 7 8 9 11 12)
			((ScriptID 323 0) init: local2 self 323) ; bellaTeller
		)
	)

	(method (handleEvent event)
		(if (and (== (event message:) JOY_UPRIGHT) (IsFlag 72))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 4 2) ; Do, Talk
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (OneOf local2 1 2 10)
					(gMessager say: 22 6 27) ; "The innkeeper's wife glances timidly at you for a minute, then continues with her work."
				else
					(super doVerb: theVerb)
				)
			)
			(59 ; theFlowers
				(gEgo use: 40) ; theFlowers
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gnome of Prop
	(properties
		noun 25
		approachX 156
		approachY 184
		x 151
		y 150
		view 320
		loop 3
		signal 16385
	)

	(method (init)
		(if (== local2 5)
			(= view 322)
			(= loop 4)
			(= cel 0)
		)
		(super init: &rest)
		((ScriptID 322 0) init: local2 self 322) ; gnomeTeller
	)

	(method (handleEvent event)
		(if (and (== (event message:) JOY_UPRIGHT) (IsFlag 72))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 4 2) ; Do, Talk
		)
		(super handleEvent: event &rest)
	)
)

(instance domovoi of Prop
	(properties
		noun 50
		approachX 66
		approachY 173
		x 30
		y 95
		fixPriority 1
		view 335
		signal 16385
	)

	(method (init)
		(super init: &rest)
		((ScriptID 324 1) init: local2 self 324) ; domovoiTeller
	)
)

(instance innKeeper of Prop
	(properties
		noun 12
		approachX 186
		approachY 183
		x 164
		y 167
		view 320
		loop 5
		signal 16385
	)

	(method (init)
		(super init: &rest)
		((ScriptID 321 0) init: local2 self 321) ; innKeepTeller
	)

	(method (handleEvent event)
		(if (and (== (event message:) JOY_UPRIGHT) (IsFlag 72))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 4 2) ; Do, Talk
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; thePurse
				(if
					(and
						(= local7
							(/ (+ (* (+ (- gDay global469) 1) 15) 99) 100)
						)
						(> local7 global468)
					)
					(gMessager say: 12 15 105) ; "Although you are a bit short, you offer all of your remaining cash to the innkeeper."
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

(instance child of Prop
	(properties
		noun 24
		approachX 210
		approachY 179
		x 226
		y 218
		z 50
		priority 170
		fixPriority 1
		view 655
		loop 1
		cel 6
		signal 16385
	)

	(method (init)
		(super init: &rest)
		((ScriptID 323 1) init: local2 self 323) ; childTeller
	)

	(method (handleEvent event)
		(if (and (== (event message:) JOY_UPRIGHT) (IsFlag 72))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 4 2) ; Do, Talk
		)
		(super handleEvent: event &rest)
	)
)

(instance peasant1 of Prop
	(properties
		noun 26
		approachX 116
		approachY 171
		x 125
		y 164
		priority 165
		fixPriority 1
		view 320
		signal 16385
	)

	(method (init)
		(super init: &rest)
		((ScriptID 322 1) init: local2 self 322) ; peasantTeller
	)
)

(instance peasant2 of Prop
	(properties
		noun 26
		approachX 116
		approachY 171
		x 97
		y 164
		priority 170
		fixPriority 1
		view 320
		loop 2
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions (ScriptID 322 1)) ; peasantTeller
	)
)

(instance peasant3 of Prop
	(properties
		noun 26
		approachX 116
		approachY 171
		x 74
		y 181
		z 50
		view 320
		loop 6
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions (ScriptID 322 1)) ; peasantTeller
	)
)

(instance gnomeDoor of Prop
	(properties
		noun 9
		approachX 197
		approachY 84
		x 177
		y 44
		view 322
		loop 1
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(gnomeDoorTeller init: self 320 20 142)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; theLockpick
				(if (== (gEgo trySkill: 9 225) 1) ; pick locks
					(cond
						((and (not (gCast contains: gnome)) (IsFlag 146))
							(gMessager say: 9 4 8) ; "There is no response to your knock. When you open the door, you find that the room has been cleaned out completely."
							(return 1)
						)
						(
							(or
								(<= local2 3)
								(and (== local2 10) (not (IsFlag 129)))
								(gCast contains: gnome)
							)
							(gMessager say: 9 4 103) ; "There is no response. Whoever (or whatever) is renting this room must not be there right now."
							(return 1)
						)
						(else
							(gCurRoom setScript: sHeroShock 0 1)
						)
					)
				else
					(gMessager say: 9 9 7) ; MISSING MESSAGE
				)
			)
			(42 ; theToolkit
				(if (== (gEgo trySkill: 9 200) 1) ; pick locks
					(cond
						((and (not (gCast contains: gnome)) (IsFlag 146))
							(gMessager say: 9 4 8) ; "There is no response to your knock. When you open the door, you find that the room has been cleaned out completely."
							(return 1)
						)
						(
							(or
								(<= local2 3)
								(and (== local2 10) (not (IsFlag 129)))
								(gCast contains: gnome)
							)
							(gMessager say: 9 4 103) ; "There is no response. Whoever (or whatever) is renting this room must not be there right now."
							(return 1)
						)
						(else
							(gCurRoom setScript: sHeroShock 0 1)
						)
					)
				else
					(gMessager say: 9 9 7) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bedroomDoor of Prop
	(properties
		noun 3
		approachX 239
		approachY 58
		x 255
		y 5
		priority 30
		fixPriority 1
		view 322
		loop 3
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 277 46 277 55 267 55 267 46
						yourself:
					)
					6
					0
					4
					sDownStairs
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sInBedroomDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(heading dispose:)
		(super dispose: &rest)
	)
)

(instance fire of Prop
	(properties
		noun 10
		x 16
		y 167
		fixPriority 1
		view 321
		cel 2
		signal 16385
		cycleSpeed 8
		detailLevel 3
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(> (gGlory detailLevel:) 1)
				(< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
			)
			(= local5 1)
			(switch (Random 0 2)
				(0
					(Palette 2 78 79 88) ; PalIntensity
					(Palette 2 84 85 88) ; PalIntensity
				)
				(1
					(Palette 2 78 79 62) ; PalIntensity
					(Palette 2 84 85 62) ; PalIntensity
				)
				(else
					(Palette 2 78 79 75) ; PalIntensity
					(Palette 2 84 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance cabinetDoor of Prop
	(properties
		noun 5
		x 56
		y 114
		fixPriority 1
		view 322
		cel 1
		signal 16385
	)
)

(instance fireplaceSlab of Prop
	(properties
		x 16
		y 167
		priority 1
		fixPriority 1
		view 321
		loop 4
		signal 16385
		cycleSpeed 10
		detailLevel 3
	)
)

(instance woodFloor of Prop
	(properties
		x 84
		y 165
		fixPriority 1
		view 321
		loop 5
		cel 1
		signal 16385
		cycleSpeed 10
		detailLevel 3
	)
)

(instance jug of Prop
	(properties
		noun 1
		x 34
		y 145
		fixPriority 1
		view 321
		loop 1
		signal 16385
		detailLevel 3
	)
)

(instance doll of View
	(properties
		x 67
		y 119
		priority 1
		fixPriority 1
		view 321
		loop 6
		signal 16384
	)
)

(instance tray of View
	(properties
		noun 49
		x 180
		y 146
		view 329
		loop 2
		signal 16384
	)
)

(instance railing of Feature
	(properties
		noun 17
		sightAngle 180
		x 172
		y 72
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					init: 151 95 242 58 298 120 273 146 271 181 318 130 317 103 240 28 151 73
					yourself:
				)
		)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 286 182 286 189 259 189 268 182
						yourself:
					)
					6
					0
					4
					sUpStairs
				yourself:
			)
		)
	)

	(method (dispose)
		(heading dispose:)
		(super dispose: &rest)
	)
)

(instance chair4 of Feature
	(properties
		noun 6
		nsLeft 204
		nsTop 121
		nsRight 222
		nsBottom 148
		sightAngle 180
		x 213
		y 134
	)

	(method (handleEvent event)
		(switch (event message:)
			(JOY_UP
				(self approachVerbs: 4 1) ; Do, Look
				(= approachX 212)
				(= approachY 179)
			)
			(JOY_DOWNRIGHT
				(if (IsFlag 72)
					(self approachVerbs: 0)
				else
					(self approachVerbs: 4 1) ; Do, Look
					(= approachX 131)
					(= approachY 171)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 72)
					(gMessager say: 22 6 107) ; "You are already seated."
				else
					(gEgo setScript: sHeroSit)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		noun 5
		nsLeft 52
		nsTop 107
		nsRight 94
		nsBottom 157
		sightAngle 180
		approachX 80
		approachY 159
		x 73
		y 132
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 163))
					(gMessager say: 5 1 5) ; "This cabinet contains some extra plates, glasses and silverware. There is also a beautiful and ornate doll on one of the shelves."
				else
					(gMessager say: 5 1 4) ; "This cabinet contains some extra plates, glasses and silverware."
				)
			)
			(4 ; Do
				(cond
					((and (>= gTime 6) (IsFlag 139) (not (IsFlag 163)))
						(gCurRoom setScript: sGetDoll)
					)
					((>= gTime 6)
						(super doVerb: theVerb &rest)
					)
					(else
						(gMessager say: 5 4 3) ; "You start to reach into the cabinet, then realize that you're being watched and decide against it."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance innkeepDoor of Feature
	(properties
		noun 13
		nsLeft 260
		nsTop 103
		nsRight 290
		nsBottom 175
		sightAngle 180
		approachX 255
		approachY 178
		x 275
		y 139
	)

	(method (init)
		(super init: &rest)
		(innKeepDoorTeller init: self 320 20 143)
	)
)

(instance myLooper of Grooper
	(properties)

	(method (cue &tmp temp0)
		(cond
			((not (client mover:))
				(client mover: oldMover)
			)
			(oldMover
				(oldMover dispose:)
			)
		)
		(if oldCycler
			(if (client cycler:)
				(oldCycler dispose:)
			else
				(client cycler: oldCycler)
			)
		)
		(= temp0 caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if temp0
			(temp0 cue: &rest)
		)
	)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1)
		(if (and (gEgo cycler:) ((gEgo cycler:) isKindOf: StopWalk))
			(gEgo view: ((gEgo cycler:) vWalking:))
		)
		(if (not client)
			(= client param1)
		)
		(if (>= argc 3)
			(= caller param3)
		)
		(if (& (client signal:) $0800)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= temp1 (if (< (NumLoops client) 8) 4 else 8))
		(if (or (not (gCast contains: client)) (and (>= argc 4) param4))
			(client
				loop:
					(local9
						at:
							(*
								(if (== temp1 4) 2 else 1)
								(/
									(umod
										(+ (client heading:) (/ 180 temp1))
										360
									)
									(/ 360 temp1)
								)
							)
					)
			)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= temp0
			(if
				(and
					(== (client loop:) (- (NumLoops client) 1))
					((client cycler:) isKindOf: StopWalk)
					(== ((client cycler:) vStopped:) -1)
				)
				(local8 at: (client cel:))
			else
				(local8 at: (client loop:))
			)
		)
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if
			(and
				oldCycler
				(or
					(oldCycler isMemberOf: Grycler)
					(not ((client cycler:) isMemberOf: Grycler))
				)
			)
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if (not oldCycler)
			(= oldCycler (client cycler:))
		)
		(if (and (client cycler:) ((client cycler:) isMemberOf: Grycler))
			((client cycler:) dispose:)
		)
		(= oldMover (client mover:))
		(client
			cycler: 0
			mover: 0
			setMotion: 0
			setCycle: myGradualCycler self temp0
		)
	)
)

(instance myGradualCycler of Grycler
	(properties)

	(method (init param1 param2 param3)
		(super init: param1)
		(= caller param2)
		(= numOfLoops (if (< (NumLoops client) 8) 4 else 8))
		(= cycleDir
			(- (sign (AngleDiff (* param3 45) (param1 heading:))))
		)
		(= loopIndex param3)
		(if (self loopIsCorrect:)
			(if
				(and
					(((client looper:) oldCycler:) isKindOf: StopWalk)
					(== (((client looper:) oldCycler:) vStopped:) -1)
				)
				(client loop: (local9 at: loopIndex))
			)
			(self cycleDone:)
		)
	)

	(method (nextCel)
		(if
			(or
				(< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				(self loopIsCorrect:)
			)
			(client loop:)
		else
			(= cycleCnt gGameTime)
			(+= loopIndex (* cycleDir (/ 8 numOfLoops)))
			(= loopIndex (umod loopIndex 8))
			(local9 at: loopIndex)
		)
	)
)

