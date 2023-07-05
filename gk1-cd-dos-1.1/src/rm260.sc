;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Talker)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
	theGirl 1
	drJohn 2
	drJohnHead 3
	drJohnReading 4
)

(local
	local0
	local1
	local2
	local3 = 28
	local4
	[local5 2]
	local7
	local8
	local9
)

(instance rm260 of Room
	(properties
		noun 1
		picture 260
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 260)
		(if (not (== gDay 5))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 104 142 120 153 235 151 247 139 301 133 299 126 280 128 267 131 236 127 229 120 109 122 89 131
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 166 129 232 128 242 141 215 142 167 141
						yourself:
					)
			)
			(pole init:)
			(backWall init:)
			(balcony init:)
			(candles init:)
			(counter init:)
			(drums init:)
			(theFlags init:)
			(bigUglyMask init:)
			(hornedDoll init:)
			(curlyKnife init:)
			(donationStuff init:)
			(mariePic init:)
			(sitSkeleton init:)
			(hatSkeleton init:)
			(whip init:)
			(theWindow init:)
			(stump init:)
			(gourd init:)
			(doorWay init:)
			(coffin init:)
		)
		(fanSwitch init:)
		(flame init:)
		(maskReflection init:)
		(headReflection init:)
		(if (not (== gDay 5))
			(fan init:)
		)
		(if (not (== gDay 5))
			(drummer init:)
		)
		(if (not (== gDay 5))
			(snake init:)
		)
		(if (== gDay 1)
			(theGirl init:)
		)
		(if (and (not (== gDay 5)) (not (== gDay 1)))
			(drJohn init:)
		)
		(if (not (== gDay 5))
			(gWalkHandler add: doorWay)
			(gWalkHandler add: balcony)
		)
		(gWalkHandler add: self)
		(Load rsVIEW 260)
		(Load rsVIEW 265)
		(if (== gDay 1)
			(Load rsVIEW 2601)
		)
		(cond
			((== gPrevRoomNum 50) ; interrogation
				(gEgo
					view: 900
					setCel: 0
					setLoop: 0
					setCycle: StopWalk -1
					signal: (| (gEgo signal:) $1000)
					init:
					state: 2
					ignoreActors: 1
					posn: 236 128
				)
				(drJohn setScript: drJohnReading)
			)
			((== gDay 5)
				(SetFlag 111)
				(gEgo actions: attackMsg)
				(gCurRoom setScript: snakeAttack)
				(SetFlag 465)
			)
			((== gDay 1)
				(gCurRoom setScript: (ScriptID 261 0)) ; enterEgoDay1
			)
			((IsFlag 278)
				(gCurRoom setScript: enterEgoOtr)
			)
			(else
				(gCurRoom setScript: enterEgoDay2)
			)
		)
		(if (!= gDay 1)
			(= gNarrator museumNarrator)
		)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1
				number: 260
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
	)

	(method (dispose)
		(if (not (== gDay 5))
			(gWalkHandler delete: doorWay)
			(gWalkHandler delete: balcony)
		)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(if (== gDay 5)
			(PalVary 3) ; PalVaryKill
		)
		(gWalkHandler delete: self)
		(= gNarrator GKNarrator)
		(if (theGirl script:)
			(theGirl setScript: 0)
		)
		(if (gCurRoom script:)
			(gCurRoom setScript: 0)
		)
		(if (gEgo script:)
			(gEgo setScript: 0)
		)
		(DisposeScript 64939)
		(DisposeScript 64938)
		(DisposeScript 64956)
		(DisposeScript 261)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== gDay 5)
			(gMessager say: 0 0 11 0) ; "There's no time for that now!"
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance museumNarrator of Narrator
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

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(25 25)
				(else global220)
			)
		)
		(switch global180
			(1
				(if
					(and
						(gCast contains: gEgo)
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
					(= local0 (gEgo cycleSpeed:))
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
			(25
				(cond
					(local9
						(drJohnHead setLoop: 5 setCycle: RandCycle)
					)
					(local8
						(drJohnHead setLoop: 3 setCycle: RandCycle)
					)
					(else
						(drJohnHead setLoop: 1 setCycle: ROsc -1 5 11)
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
				loop: (gEgo oldLoop:)
				cel: (gEgo oldCel:)
				talking: 0
				cycleSpeed: local0
				setCycle: StopWalk -1
			)
		)
		(if local8
			(drJohnHead setCel: 0 setCycle: 0)
		else
			(drJohnHead setCel: 3 setCycle: 0)
		)
		(super dispose:)
	)
)

(instance enterEgoDay2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 900
					setCel: 0
					setLoop: 0
					setCycle: StopWalk -1
					signal: (| (gEgo signal:) $1000)
					init:
					state: 2
					posn: 65 122
					setMotion: MoveTo 117 122
				)
				(= cycles 1)
			)
			(1
				(drJohn setCel: 0 setLoop: 4 setCycle: End self)
			)
			(2
				(drJohn view: 268 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
				(gMessager say: 26 0 4 1 self) ; "(FRIENDLY, CONTROLLED, SMOOTH)Welcome, my friend."
			)
			(3
				(drJohnHead init: hide:)
			)
			(4
				(drJohn view: 261 setCel: 4 setLoop: 4)
				(gMessager say: 26 0 4 2 self) ; "Hello."
			)
			(5
				(= local9 1)
				(drJohnHead setLoop: 5 posn: 272 76 setCel: 0 show:)
				(gMessager sayRange: 26 0 4 3 4 self) ; "I am the proprietor, Dr. John. If you have any questions I will be happy to assist."
			)
			(6
				(drJohnHead posn: 269 76 dispose:)
				(drJohn view: 261 setCel: 4 setLoop: 4 setCycle: Beg self)
			)
			(7
				(= local9 0)
				(SetFlag 278)
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				(drJohn view: 261 setLoop: 2 setScript: drJohnReading)
				(self dispose:)
			)
		)
	)
)

(instance enterEgoOtr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 900
					setCel: 0
					setLoop: 0
					signal: (| (gEgo signal:) $1000)
					init:
					setCycle: StopWalk -1
					state: 2
					posn: 65 122
					setMotion: MoveTo 117 122
				)
				(= cycles 1)
				(drJohnHead init: hide:)
			)
			(1
				(drJohnHead setCel: 0 show: setCycle: CT 3 1)
				(= cycles 1)
			)
			(2
				(gMessager say: 26 0 38 0 self) ; "Hello, Dr. John."
			)
			(3
				(drJohnHead cel: 4 setCycle: CT 0 -1 self)
			)
			(4
				(drJohnHead dispose:)
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				(drJohn view: 261 loop: 2 setScript: drJohnReading)
				(self dispose:)
			)
		)
	)
)

(instance showSomethingToJohn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drJohnReading dispose:)
				(if (or (!= (gEgo x:) 236) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 236 128 self)
				else
					(self cue:)
				)
			)
			(1
				(if (!= local2 31)
					(gEgo view: 904 loop: 0 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
				(drJohn view: 261 loop: 4 cel: 0 setCycle: End)
				(cond
					((OneOf local2 42 23 24 48 41 30 32 31 46)
						(gMessager say: 25 local2 0 1 self)
					)
					((== local2 17)
						(gMessager say: 25 local2 25 1 self) ; "Are you sure you don't recognize anything about the ritual in this photo?"
					)
					((or (== local2 40) (== local2 59))
						(gMessager say: 25 40 5 1 self) ; "Do these symbols mean anything to you?"
					)
					((== local2 16)
						(if (IsFlag 275)
							(gMessager say: 25 local2 27 1 self) ; "Are you sure about this pattern?"
						else
							(gMessager say: 25 local2 26 1 self) ; "Does this pattern look familiar to you?"
						)
					)
					(else
						(gMessager say: 25 0 0 1 self) ; "Does this mean anything to you?"
					)
				)
			)
			(2)
			(3
				(drJohn view: 266 loop: 0 cel: 0 setCycle: Osc 1 self)
				(drJohnHead init: hide:)
			)
			(4
				(drJohn view: 266 loop: 1 cel: 0 setCycle: End self)
				(= local9 1)
				(drJohnHead
					setCel: 0
					setLoop: 5
					posn: 272 76
					show:
					setCycle: CT 3 1
				)
				(cond
					((OneOf local2 42 23 24 48 41 30 32 31 46)
						(gMessager say: 25 local2 0 2 self)
					)
					((== local2 17)
						(gMessager say: 25 local2 25 2 self) ; "I told you, SIR, that has nothing to do with Voodoo."
					)
					((or (== local2 40) (== local2 59))
						(gMessager say: 25 40 5 2 self) ; "(STIFF)No. They look like nonsense to me. Where did you get them, if I might inquire?"
					)
					((== local2 16)
						(if (IsFlag 275)
							(gMessager say: 25 local2 27 2 self) ; "I am sure, Mr. Knight."
						else
							(gMessager say: 25 local2 26 2 self) ; "(SUSPICIOUS, SURPRISED)Where did you get that?"
						)
					)
					(else
						(gMessager say: 25 0 0 2 self) ; "I cannot say that it does."
					)
				)
			)
			(5)
			(6
				(if (!= local2 31)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
				(cond
					((OneOf local2 42 23 24 48 41)
						(gMessager say: 25 local2 0 3 self)
					)
					((OneOf local2 32 31 46)
						(self cue:)
					)
					((== local2 17)
						(gMessager say: 25 local2 25 3 self) ; "Right. Sorry."
					)
					((== local2 30)
						(gMessager sayRange: 25 local2 0 3 6 self) ; "Oh, just lying around."
					)
					((or (== local2 40) (== local2 59))
						(gMessager sayRange: 25 40 5 3 5 self) ; "I saw them scribbled somewhere. Just graffiti, I guess."
					)
					((== local2 16)
						(if (IsFlag 275)
							(= cycles 1)
						else
							(gMessager sayRange: 25 local2 26 3 4 self) ; "You do recognize it, then?"
							(SetFlag 275)
						)
					)
					(else
						(gMessager say: 25 0 0 3 self) ; "!!!Blank msg"
					)
				)
			)
			(7)
			(8
				(= local9 0)
				(drJohnHead dispose: posn: 269 76)
				(drJohn view: 261 loop: 4 cel: 4 setCycle: Beg self)
			)
			(9
				(gEgo normalize: ignoreActors: 1)
				(drJohn view: 261 loop: 2 setScript: drJohnReading)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showPhotoToJohn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drJohnReading dispose:)
				(if (or (!= (gEgo x:) 236) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 232 128 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 904 loop: 0 cel: 0 setCycle: End self)
				(gMessager say: 25 17 24 1 self) ; "Could you look at this and tell me if you recognize anything about the ritual?"
			)
			(2
				(drJohn view: 266 loop: 0 cel: 0 setCycle: Osc 1)
			)
			(3
				(drJohn view: 266 loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 25 17 24 2 self) ; "(FAKING GREAT OFFENSE)Mmmm! This is truly offensive! This is from one of those recent killings, is it not?"
			)
			(4)
			(5
				(gEgo setCycle: Beg self)
				(gMessager say: 25 17 24 3 self) ; "Well, actually...."
			)
			(6)
			(7
				(gEgo normalize: ignoreActors: 1)
				(drJohn view: 267 loop: 0 cel: 0 setCycle: End self)
				(gMessager say: 25 17 24 4 self) ; "But the police already know that this so-called 'Voodoo ritual' is fake! Voodoo is a respectable religion. This kind of thing has nothing to do with Voodoo in this city!"
			)
			(8
				(drJohn view: 267 loop: 1 cel: 0 setCycle: Osc -1)
			)
			(9
				(drJohn view: 267 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(gMessager say: 25 17 24 5 self) ; "Fine, let's say that's true. Are you sure there's nothing about the items in this photo...."
			)
			(11
				(drJohn view: 268 loop: 0 setCycle: RandCycle)
				(gMessager say: 25 17 24 6 self) ; "There is NOTHING about this...sickness that I would identify as Voodoo. Nothing!"
			)
			(12
				(drJohn setCycle: 0)
				(gMessager say: 25 17 24 7 self) ; "Thanks for looking, then."
			)
			(13
				(drJohn view: 261 loop: 4 cel: 4 setCycle: Beg self)
			)
			(14
				(drJohn view: 261 loop: 2 setScript: drJohnReading)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveSnake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(snake view: 260 loop: 3 cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 3 7))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance cycleTheDrummer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drummer loop: 4 setCycle: ForwardCounter (Random 5 8) self)
			)
			(1
				(drummer loop: 5 cel: 0)
				(= seconds (Random 3 7))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance flipTheSwitch of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(>= 8 state 3)
				(== (snake loop:) 4)
				(== (snake cel:) 3)
				(== (gGame detailLevel:) 3)
			)
			(gGkSound2 number: 264 setLoop: 1 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 98 128 self)
			)
			(1
				(gEgo view: 265 loop: 0 cel: 0 setCycle: End self)
				(if local4
					(drJohnHead init: hide:)
					(gMessager say: 28 8 7 1) ; "What does this do?"
				else
					(gMessager say: 28 8 8 1) ; "What does this switch do?"
				)
			)
			(2
				(moveSnake dispose:)
				(gGkSound1 number: 2670 setLoop: 1 play: self)
				(fan setPri: 180 cycleSpeed: 9 setCycle: End)
				(gEgo loop: 1 cel: 0 setCycle: End)
				(if local4
					(drJohnReading dispose:)
					(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1)
				)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 264) ; WAVE
				)
			)
			(3
				(gGkSound1 number: 2601 setLoop: -1 flags: 5 play:)
				(snake view: 265 loop: 4 cel: 0 setCycle: Fwd)
				(fan loop: 1 cel: 0 cycleSpeed: 9 setCycle: Fwd)
				(= cycles 1)
				(if (not local4)
					((ScriptID 261 4) dispose:) ; girlDoRandomStuff
				)
			)
			(4
				(if local4
					(gMessager say: 28 8 7 2 self) ; "(IRRITATED--TRYING TO BE HEARD OVER A NOISY FAN)Turn that thing off!"
				else
					(gMessager say: 28 8 8 2) ; "HEY! Turn that off!"
					(theGirl loop: 6 cel: 0 setCycle: End self)
				)
			)
			(5
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(if local4
					(gMessager say: 28 8 7 3) ; "Oh. Sorry."
				else
					(gMessager say: 28 8 8 3) ; "I didn't mean anything...."
				)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(8
				(gEgo loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(gGkSound1 number: 2671 loop: 1 flags: 1 play:)
				(snake view: 265 loop: 4 cel: 0 cycleSpeed: 11 setCycle: Osc 1)
				(fan loop: 0 cel: 12 cycleSpeed: 9 setCycle: Beg self)
				(gEgo loop: 1 cel: 0 setCycle: End self)
				(if local4
					(gMessager say: 28 8 7 4) ; "(CALMER--TRYING TO COVER HIS ANXIETY)We have air conditioning, you see."
				else
					(gMessager say: 28 8 8 4) ; "Dr. John told me to NEVER turn on that fan."
				)
			)
			(10
				(gGkSound2 stop:)
			)
			(11
				(if local4
					(self cue:)
				else
					(theGirl cel: 6 setCycle: Beg self)
				)
			)
			(12
				(snake setScript: moveSnake)
				(if local4
					(gMessager say: 28 8 7 5 self) ; "Yeah, I see."
				else
					(gMessager say: 28 8 8 5 self) ; "I can see why."
				)
				(gEgo normalize: 3 900 ignoreActors: 1)
			)
			(13
				(if local4
					(drJohnHead setCel: 4 setCycle: CT 0 -1 self)
				else
					(theGirl setScript: (ScriptID 261 4)) ; girlDoRandomStuff
					(= cycles 2)
				)
			)
			(14
				(fan setPri: -1)
				(if local4
					(drJohnHead dispose:)
					(drJohn setScript: drJohnReading)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTheSnake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(gEgo setMotion: PolyPath 299 127 self)
			)
			(1
				(Face gEgo snake self)
				(if (not local4)
					((ScriptID 261 4) dispose:) ; girlDoRandomStuff
				else
					(drJohnHead init: hide:)
				)
			)
			(2
				(if local4
					(drJohnReading dispose:)
					(drJohnHead setCel: 0 setLoop: 3 show:)
					(= cycles 1)
				else
					(theGirl loop: 4 cel: 0 setCycle: End self)
				)
			)
			(3
				(if local4
					(gMessager say: 9 4 20 1 self) ; "The python is quite dangerous. I would stay back if I were you."
				else
					(gMessager say: 9 4 21 1 self) ; "Don't go near the snake! It's not a pet!"
					(theGirl loop: 7 cel: 0 setCycle: Fwd)
				)
			)
			(4
				(if local4
					(self cue:)
				else
					(theGirl loop: 4 cel: 2 setCycle: Beg self)
				)
			)
			(5
				(Face gEgo donationStuff self)
			)
			(6
				(if local4
					(gMessager say: 9 4 20 2 self) ; "Thanks for the advice."
				else
					(gMessager say: 9 4 21 2 self) ; "Really? And it looks so friendly, too."
				)
			)
			(7
				(= local8 0)
				(gEgo normalize: ignoreActors: 1)
				(if (not local4)
					(theGirl setScript: (ScriptID 261 4)) ; girlDoRandomStuff
				else
					(drJohnHead dispose:)
					(drJohn setScript: drJohnReading)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryToPickUpSnake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(if local4
					(drJohnHead init: hide:)
				)
				(gEgo setMotion: PolyPath 299 127 self)
			)
			(1
				(gMessager say: 9 12 21 1 self) ; "That snake...."
				(Face gEgo snake)
				(if (not local4)
					((ScriptID 261 4) dispose:) ; girlDoRandomStuff
				else
					(drJohnReading dispose:)
					(drJohnHead setCel: 0 setLoop: 3 show:)
				)
			)
			(2
				(if local4
					(self cue:)
				else
					(theGirl loop: 4 cel: 0 setCycle: End self)
				)
			)
			(3
				(if local4
					(gMessager say: 9 12 20 2 self) ; "Is deadly--which is why the cage is out of public reach."
					(self cue:)
				else
					(gMessager say: 9 12 21 2 self) ; "Is locked up for a reason. Even I wouldn't touch it."
					(theGirl loop: 7 cel: 0 setCycle: Osc 1 self)
				)
			)
			(4)
			(5
				(if local4
					(gMessager say: 9 12 20 3 self) ; "I see."
				else
					(theGirl loop: 4 cel: 2 setCycle: Beg self)
				)
			)
			(6
				(= local8 0)
				(gGame handsOn:)
				(if (not local4)
					(theGirl setScript: (ScriptID 261 4)) ; girlDoRandomStuff
				else
					(drJohnHead dispose:)
					(drJohn setScript: drJohnReading)
				)
				(gEgo normalize: ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance playTheDrums of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(if local4
					(drJohnHead init: hide:)
				)
				(if (or (!= (gEgo x:) 268) (!= (gEgo y:) 136))
					(gEgo setMotion: PolyPath 268 136 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo 268 199 self)
				(if (not local4)
					((ScriptID 261 4) dispose:) ; girlDoRandomStuff
				else
					(drJohnReading dispose:)
					(drJohnHead setCel: 0 setLoop: 3 show:)
				)
			)
			(2
				(if local4
					(gMessager say: 8 8 20 1 self) ; "Please. Do not touch the drums. They are authentic."
				else
					(gMessager say: 8 8 21 1 self) ; "Please don't touch those drums, Mister!"
					(theGirl loop: 5 cel: 0 setCycle: Osc 1 self)
				)
			)
			(3
				(if local4
					(self cue:)
				)
			)
			(4
				(if local4
					(Face gEgo drJohn self)
				else
					(self cue:)
				)
			)
			(5
				(if local4
					(gMessager sayRange: 8 8 20 2 3 self) ; "Authentic what?"
				else
					(gGame handsOn:)
					(theGirl setScript: (ScriptID 261 4)) ; girlDoRandomStuff
					(self dispose:)
				)
			)
			(6
				(drJohnHead dispose:)
				(drJohn setScript: drJohnReading)
				(= local8 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTheCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 98) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 98 128 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(gMessager say: 10 6 15 1 self) ; "(TO HIMSELF. INTRIGUED)This coffin is so small. Interesting...."
				((ScriptID 261 4) dispose:) ; girlDoRandomStuff
				(theGirl setCel: 0 setLoop: 4 setCycle: End self)
			)
			(3)
			(4
				(gMessager say: 10 6 15 2 self) ; "(SINCERE)Cute, isn't it?"
				(theGirl setLoop: 5 setCycle: ROsc 3 4 5)
			)
			(5
				(gEgo view: 262 setCel: 0 setLoop: 0 setCycle: CT 1 1 self)
			)
			(6
				(gGkSound1 number: 2603 setLoop: 1 play:)
				(gEgo view: 262 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(7
				(gMessager say: 10 6 15 3 self) ; "(SARCASTIC)Adorable. Do you know anything about it?"
			)
			(8
				(gMessager say: 10 6 15 4 self) ; "'Fraid not."
				(theGirl setLoop: 5 setCycle: ROsc 3 4 5)
			)
			(9
				(gGkSound1 number: 2604 setLoop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(10
				(gGame handsOn:)
				(SetFlag 113)
				(theGirl setScript: (ScriptID 261 4)) ; girlDoRandomStuff
				(gEgo normalize: 1 900 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance putSignalDevInCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: (gInventory indexOf: (gTheIconBar curInvIcon:)))
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 98) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 98 128 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 262 setCel: 0 setLoop: 0 setCycle: CT 1 1 self)
			)
			(2
				(gGkSound1 number: 2603 setLoop: 1 play: self)
				(gEgo view: 262 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(3)
			(4
				(gEgo setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(5
				(gEgo setCel: 4 setLoop: 1 setCycle: End self)
				(gGkSound1 number: 263 setLoop: 1 play:)
				(gMessager say: 10 60 18 1 self) ; "(RRCC. SKIPPED. SLY, HUSHED)Gabriel slips the signal device into the sekey madoul\82."
			)
			(6)
			(7
				(gGkSound1 number: 2604 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
				(drJohnHead init: hide:)
			)
			(8
				(drJohnReading dispose:)
				(gEgo normalize: 1 900 ignoreActors: 1)
				(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1 self)
			)
			(9
				(Face gEgo drJohn self)
			)
			(10
				(gMessager sayRange: 10 60 18 2 3 self) ; "Can I assist you, Mr. Knight?"
			)
			(11
				(if (not (IsFlag 246))
					(gMessager say: 10 60 19 2 self) ; "(RRCC. SKIPPED. EXCITED)Now if only they take the coffin to the ritual!"
				else
					(= cycles 1)
				)
			)
			(12
				(drJohnHead setCel: 4 setCycle: CT 0 -1 self)
			)
			(13
				(drJohnHead dispose:)
				(drJohn setScript: drJohnReading)
				(gGame handsOn:)
				(SetFlag 113)
				(SetFlag 114)
				(gCurRoom setScript: makeEgoLeave)
				(self dispose:)
			)
		)
	)
)

(instance openCoffinAndJohnIsHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 98) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 98 128 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(if (IsFlag 46)
					(gMessager say: 10 6 14 1 self) ; "This is a sekey madoul\82, isn't it? A small ritual coffin?"
				else
					(gMessager say: 10 6 13 1 self) ; "(HE FINDS IT CURIOUS)This coffin is so small."
				)
				(drJohnHead init: hide:)
			)
			(3
				(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1)
				(drJohnReading dispose:)
				(gEgo view: 262 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(gGkSound1 number: 2603 setLoop: 1 play:)
				(gEgo view: 262 loop: 0 cel: 2 setCycle: End self)
			)
			(5
				(if (IsFlag 46)
					(gMessager sayRange: 10 6 14 2 4 self) ; "(TIGHT. HE'S LYING)I am not familiar with that terminology."
				else
					(gMessager sayRange: 10 6 13 2 4 self) ; "How observant of you, Mr. Knight."
				)
			)
			(6
				(gGkSound1 number: 2604 setLoop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(7
				(if (IsFlag 46)
					(gMessager say: 10 6 14 5 self) ; "!!!Blank msg"
				else
					(gMessager say: 10 6 13 5 self) ; "Huh. Imagine that."
				)
			)
			(8
				(drJohnHead setCel: 4 setCycle: CT 0 -1 self)
			)
			(9
				(drJohnHead dispose:)
				(drJohn setScript: drJohnReading)
				(gGame handsOn:)
				(SetFlag 113)
				(gEgo normalize: 1 900 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance openTheCoffinAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 98) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 98 128 self)
				else
					(self cue:)
				)
			)
			(1
				(gGkSound1 number: 2603 setLoop: 1 play:)
				(gEgo view: 262 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 10 6 16 0 self) ; "The little coffin is empty."
			)
			(3
				(gEgo setCycle: Beg self)
				(gGkSound1 number: 2604 setLoop: 1 play:)
			)
			(4
				(gGame handsOn:)
				(gEgo normalize: 1 900 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance rubTheStump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 166) (!= (gEgo y:) 137))
					(gEgo setMotion: PolyPath 166 137 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 2621 setCel: 0 setLoop: 0 setCycle: End)
				(= seconds 3)
			)
			(2
				(gEgo
					view: 2621
					setCel: 0
					setLoop: 1
					setPri: 150
					cycleSpeed: 9
					setCycle: CT 5 1 self
				)
			)
			(3
				(gGkSound1 number: 2605 setLoop: 1 play:)
				(gEgo setCel: 6 setLoop: 1 setCycle: CT 7 1 self)
			)
			(4
				(gEgo setCel: 6 setLoop: 1 setCycle: End self)
			)
			(5
				(gEgo normalize: 0 900 ignoreActors: 1)
				(if (and (IsFlag 11) (not (IsFlag 115)))
					(gMessager say: 11 8 52 0 self) ; "I wish Malia Gedde was permanently grafted to my thighs."
					(SetFlag 115)
				else
					(gMessager say: 11 8 (Random 45 50) 0 self)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateDrJohn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drJohnHead init: hide:)
				(if (or (!= (gEgo x:) 236) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 236 128 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo drJohn self)
			)
			(2
				(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1 self)
				(drJohnReading dispose:)
			)
			(3
				(if (IsFlag 290)
					(gMessager say: 25 10 23 0 self) ; "Could I ask you some more questions?"
				else
					(gMessager say: 25 10 22 0 self) ; "Could I ask you some questions?"
					(SetFlag 290)
				)
			)
			(4
				(= global178 25)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance drJohnReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(drJohn setCel: 0 setCycle: End self)
				else
					(drJohn setCel: 3 setCycle: Beg self)
				)
			)
			(1
				(= seconds 8)
			)
			(2
				(= local1 (Random 0 1))
				(self init:)
			)
		)
	)
)

(instance talkToDrJohn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drJohnReading dispose:)
				(drJohnHead init: hide:)
				(if (or (!= (gEgo x:) 236) (!= (gEgo y:) 128))
					(gEgo setMotion: PolyPath 236 128 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo drJohn self)
			)
			(2
				(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1 self)
			)
			(3
				(cond
					((not (IsFlag 448))
						(SetFlag 448)
						(gMessager say: 25 11 34 0 self) ; "(TRYING TO MAKE SMALL TALK. POLITE.)This is quite a place you have here."
					)
					((== gDay 6)
						(gMessager say: 25 11 60 0 self) ; "(RRCC. SLY)Do you know of anything...interesting going on this evening?"
					)
					(else
						(gMessager say: 25 11 local3 0 self)
					)
				)
			)
			(4
				(if (== local3 33)
					(= local3 28)
				else
					(++ local3)
				)
				(drJohnHead setCel: 4 setCycle: CT 0 -1 self)
			)
			(5
				(drJohnHead dispose:)
				(drJohn setScript: drJohnReading)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snakeAttack of Script
	(properties)

	(method (doit)
		(if local7
			(self changeState: 12)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(PalVary 8 260) ; PalVaryNewSource
				(gGame handsOff:)
				(snake view: 2631 setCel: 0 setLoop: 4 init: posn: 164 32)
				(= cycles 1)
			)
			(1
				1
				(gEgo
					view: 263
					setCel: 0
					setLoop: 0
					signal: (| (gEgo signal:) $1000)
					init:
					state: 2
					posn: 100 124
					setPri: 126
					setCycle: End self
				)
			)
			(2
				2
				(gMessager say: 26 0 9 1) ; "Why's it so dark in here?"
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				3
				(gEgo
					view: 263
					loop: 0
					cel: 0
					posn: 122 124
					setCycle: End self
				)
			)
			(4
				4
				(gMessager say: 26 0 9 2 self) ; "(CALLING OUT)Dr. John? Hello?"
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(5 5)
			(6
				6
				(snake cycleSpeed: 9 setCycle: End)
				(gMessager say: 26 0 9 4 self) ; "Uh-oh."
			)
			(7
				7
				(gGkSound1 number: 901 setLoop: 1 play:)
				(snake dispose:)
				(gEgo
					view: 2631
					loop: 0
					cel: 0
					cycleSpeed: 10
					posn: 139 122
					setCycle: End self
				)
				(UpdateScreenItem gEgo)
			)
			(8
				8
				(gGkMusic1
					number: 260
					setLoop: -1
					play:
					setVol: (gGkMusic1 musicVolume:)
				)
				(gEgo loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 26 0 9 5 self) ; "!!!Blank msg"
			)
			(9 9)
			(10
				10
				(gGame oldCurIcon: (gTheIconBar at: 3))
				(gGame handsOn:)
				(gEgo view: 2631 setLoop: 2 1 cel: 0 setCycle: Osc 4 self)
				(gMessager say: 26 0 9 6) ; "<choke>!!!"
			)
			(11
				11
				(gEgo
					view: 2631
					setLoop: 2 1
					cycleSpeed: 20
					setCycle: ROsc 3 0 3 self
				)
			)
			(12
				12
				(if local7
					(= local7 0)
					(gGame handsOff:)
					(gEgo setCycle: 0 setScript: getSnakeOff)
					(self dispose:)
				else
					(gEgo
						setPri: 130
						setLoop: 3
						setCel: 0
						setCycle: End self
					)
				)
			)
			(13
				13
				(gMessager say: 26 0 12 0 self) ; "!!!Blank msg"
				(gGame handsOn:)
			)
			(14
				14
				(self dispose:)
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance getSnakeOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2632 setLoop: 0 1 cel: 0 setCycle: End self)
				(gMessager say: 28 8 11 1) ; "!!!Blank msg"
			)
			(1
				(gEgo
					view: 2632
					loop: 1
					cel: 0
					posn: 111 128
					setPri: 130
					setCycle: End self
				)
			)
			(2
				(Load rsVIEW 264)
				(gGkSound1 number: 2670 play:)
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 2601) ; WAVE
				)
			)
			(3
				(gGkSound1 number: 2601 setLoop: -1 flags: 5 play:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
				(fan view: 2652 init: setPri: 180 cycleSpeed: 9 setCycle: End)
				(drJohn init: hide:)
				(gMessager say: 28 8 11 2) ; "(ADDRESSING A SNAKE THAT JUST ATTACKED HIM)You BASTARD!"
			)
			(4
				(PalVary 3) ; PalVaryKill
				(flame view: 260)
				(maskReflection view: 260)
				(headReflection view: 260)
				(= cycles 1)
			)
			(5
				(freeSnake init: setScript: slitherAway)
				(drJohn
					view: 264
					posn: 100 125
					show:
					setCel: 0
					setLoop: 1 1
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
				(fan view: 2652 loop: 1 cel: 0 cycleSpeed: 9 setCycle: Fwd)
				(gEgo normalize: 4 900)
			)
			(6
				(drJohn setCel: 3 setCycle: End)
				(gGkSound1 number: 2671 setLoop: 1 flags: 1 play:)
				(fan
					view: 2651
					setLoop: 0
					setCel: 12
					cycleSpeed: 9
					setCycle: Beg self
				)
			)
			(7
				(gMessager say: 28 8 11 3 self) ; "(SMOOTH, CALM)Good day, Mr. Knight."
			)
			(8
				(gEgo view: 264 loop: 0 cel: 0 setCycle: End self)
				(gMessager say: 28 8 11 4 self) ; "(ANGRY)That thing just tried to KILL me!"
			)
			(9)
			(10
				(gEgo posn: 115 130 normalize: 7 900)
				(gMessager sayRange: 28 8 11 5 8 self) ; "He did? I AM sorry. The museum is closed today, you see, and we were not expecting visitors."
			)
			(11
				(fan setPri: -1)
				(SetFlag 96)
				(gEgo ignoreActors: 1 setMotion: PolyPath 117 122 self)
			)
			(12
				(gEgo
					setPri: (- (drJohn priority:) 1)
					setMotion: MoveTo 65 122 self
				)
			)
			(13
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance slitherAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(freeSnake setLoop: 4 1 setCycle: End self)
			)
			(1
				(freeSnake
					posn: 151 135
					setLoop: 5 1
					setCycle: Fwd
					setMotion: MoveTo 321 135 self
				)
			)
			(2
				(freeSnake dispose:)
				(self dispose:)
			)
		)
	)
)

(instance makeEgoLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 129 122 self)
				(drJohnHead init: hide:)
			)
			(2
				(Face gEgo drJohn self)
				(drJohnHead setCel: 0 setLoop: 1 show: setCycle: CT 3 1)
			)
			(3
				(drJohnReading dispose:)
				(= cycles 2)
			)
			(4
				(gMessager say: 26 0 59 0 self) ; "(RRCC. POLITE BUT FEELING A LITTLE PRESSED FOR TIME)I hate to rush you, Mr. Knight, but I am afraid I must close the museum early this evening."
			)
			(5
				(gEgo setMotion: PolyPath 109 122 self)
			)
			(6
				(gEgo setMotion: MoveTo 65 122 self)
			)
			(7
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance drJohn of Actor
	(properties
		noun 25
		sightAngle 30
		approachX 229
		approachY 128
		x 270
		y 127
		view 261
		loop 2
		signal 4129
	)

	(method (init)
		(super init:)
		(= local4 1)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 24 48) ; veveCopy, policeVeve_
			(= theVerb 23) ; sLakePatter
		)
		(= local2 theVerb)
		(switch theVerb
			(11 ; Talk
				(gEgo setScript: talkToDrJohn)
			)
			(10 ; Ask
				(gEgo setScript: interrogateDrJohn)
			)
			(20 ; lakeScale
				(gMessager say: noun theVerb 0 0) ; "Perhaps Gabriel should learn more about the scale before showing it to anyone."
			)
			(26 ; musScale
				(gMessager say: noun theVerb 0 0) ; "Would that really be a good idea?"
			)
			(60 ; signalDev_ or signalDev2_
				(gMessager say: noun theVerb 0 0) ; "Why would Gabriel want to give Dr. John the signal device?"
			)
			(51 ; twoScales
				(gMessager say: noun theVerb 0 0) ; "Would that really be a good idea?"
			)
			(21 ; snakeSkin_
				(gMessager say: noun theVerb 0 0) ; "Dr. John is unlikely to be interested in that snake skin."
			)
			(22 ; fortScale_
				(gMessager say: noun theVerb 0 0) ; "Why would Dr. John be interested in that scale?"
			)
			(19 ; hartNotes
				(gMessager say: noun theVerb 0 0) ; "Hartridge died getting that information. Gabriel doesn't want to endanger anyone else."
			)
			(45 ; tracker
				(gMessager say: noun theVerb 0 0) ; "That tracker wouldn't do much good if everybody knew about it."
			)
			(17 ; murderPhoto
				(if (IsFlag 217)
					(gEgo setScript: showSomethingToJohn)
				else
					(SetFlag 217)
					(gEgo setScript: showPhotoToJohn)
				)
			)
			(40 ; VoodooCode1
				(if (IsFlag 396)
					(gMessager say: noun theVerb 6 0) ; "Dr. John didn't seem too thrilled with those symbols the first time he saw them."
				else
					(SetFlag 396)
					(gEgo setScript: showSomethingToJohn)
				)
			)
			(59 ; sVoodooCode
				(if (IsFlag 396)
					(gMessager say: noun theVerb 6 0) ; "Dr. John didn't seem too thrilled with those symbols the first time he saw them."
				else
					(SetFlag 396)
					(gEgo setScript: showSomethingToJohn)
				)
			)
			(else
				(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(super doVerb: theVerb)
				else
					(gEgo setScript: showSomethingToJohn)
				)
			)
		)
	)
)

(instance freeSnake of Actor
	(properties
		x 147
		y 135
		view 2632
		loop 4
	)
)

(instance theGirl of Prop
	(properties
		noun 24
		sightAngle 20
		x 275
		y 96
		view 2601
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)

	(method (doVerb theVerb)
		(if
			(or
				(== theVerb 7) ; Look
				(== theVerb 9) ; Move
				(== theVerb 6) ; Open
				(== theVerb 8) ; Operate
				(== theVerb 12) ; Pickup
			)
			(super doVerb: theVerb)
		else
			(switch theVerb
				(11 ; Talk
					(gEgo setScript: (ScriptID 261 3)) ; talkToGirl
				)
				(10 ; Ask
					(gEgo setScript: (ScriptID 261 1)) ; interrogateGirl
				)
				(else
					(gEgo setScript: (ScriptID 261 2)) ; showSomethingGirl
				)
			)
		)
	)
)

(instance flame of Prop
	(properties
		noun 5
		x 53
		y 107
		view 260
		signal 4129
	)

	(method (init)
		(super init:)
		(if (== gDay 5)
			(self view: 269)
		)
		(self setPri: 170 setCycle: Fwd)
	)
)

(instance maskReflection of Prop
	(properties
		noun 6
		x 58
		y 71
		view 260
		loop 1
		signal 4129
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (== gDay 5)
			(self view: 269)
		)
		(self setPri: 170 setCycle: Fwd)
	)
)

(instance headReflection of Prop
	(properties
		noun 4
		x 43
		y 143
		view 260
		loop 2
		signal 4129
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (== gDay 5)
			(self view: 269)
		)
		(self setPri: 170 setCycle: Fwd)
	)
)

(instance snake of Prop
	(properties
		noun 9
		sightAngle 20
		x 292
		y 63
		view 260
		loop 3
	)

	(method (init)
		(if (!= gDay 5)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 265 49 271 43 312 43 314 68 267 70
						yourself:
					)
				setScript: moveSnake
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(gEgo setScript: lookAtTheSnake)
			)
			(3 ; tweezers
				(gEgo setScript: lookAtTheSnake)
			)
			(12 ; Pickup
				(gEgo setScript: tryToPickUpSnake)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fan of Prop
	(properties
		noun 23
		sightAngle 20
		x 126
		y 64
		view 2651
	)
)

(instance drummer of Prop
	(properties
		noun 27
		sightAngle 20
		x 135
		y 97
		view 260
		loop 4
		signal 4129
	)

	(method (init)
		(super init:)
		(self setScript: cycleTheDrummer)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 51)
					(gMessager say: noun theVerb 35 0) ; "Gabriel wonders if that drummer is one of the cartel's messengers."
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

(instance drJohnHead of Prop
	(properties
		x 269
		y 76
		view 261
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 200)
	)
)

(instance pole of Feature
	(properties
		noun 3
		nsLeft 209
		nsTop 22
		nsRight 224
		nsBottom 138
		sightAngle 20
		x 215
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 46)
					(gMessager say: noun theVerb 3 0) ; "According to Hartridge, that pole in the center of the room is called a poteau-mitan."
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

(instance backWall of Feature
	(properties
		noun 19
		sightAngle 20
		x 193
		y 61
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 48 265 71 301 71 302 88 146 88 144 51
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb (Random 39 44) 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance balcony of Feature
	(properties
		noun 18
		sightAngle 20
		x 164
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 310 21 283 40 129 40 100 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance candles of Feature
	(properties
		noun 5
		sightAngle 20
		x 71
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 136 79 132 70 128 68 132 59 136 56 129 62 124 53 121 54 107 68 106 71 116 83 117 84 139 75 141
					yourself:
				)
		)
		(super init:)
	)
)

(instance counter of Feature
	(properties
		noun 13
		nsLeft 234
		nsTop 98
		nsRight 303
		nsBottom 126
		sightAngle 20
		x 266
		y 108
	)
)

(instance drums of Feature
	(properties
		noun 8
		sightAngle 20
		x 268
		y 151
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 140 246 135 252 129 282 128 280 122 284 115 306 110 312 116 319 118 319 145 243 145
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gEgo setScript: playTheDrums)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theFlags of Feature
	(properties
		noun 12
		sightAngle 20
		x 185
		y 38
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 45 184 21 199 20 211 41 222 40 232 21 244 21 241 67 229 33 225 42 207 42 196 26 185 50
					yourself:
				)
		)
		(super init:)
	)
)

(instance bigUglyMask of Feature
	(properties
		noun 6
		sightAngle 20
		x 24
		y 198
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 22 73 75 59 86 32 83 10 66 21 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance hornedDoll of Feature
	(properties
		noun 20
		nsLeft 150
		nsTop 74
		nsRight 161
		nsBottom 95
		sightAngle 20
		x 156
		y 85
	)
)

(instance curlyKnife of Feature
	(properties
		noun 16
		sightAngle 20
		x 196
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 77 206 68 197 82 191 84 189 83
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 46)
					(gMessager say: noun theVerb 3 0) ; "That knife looks familiar--probably from Hartridge's slides."
				else
					(gMessager say: noun theVerb 0 0) ; "Something about the shape of that knife gives Gabriel the creeps."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance donationStuff of Feature
	(properties
		noun 17
		nsLeft 238
		nsTop 92
		nsRight 264
		nsBottom 99
		sightAngle 20
		approachX 225
		approachY 121
		x 253
		y 95
	)

	(method (init)
		(self approachVerbs: 12) ; Pickup
		(super init:)
	)
)

(instance mariePic of Feature
	(properties
		noun 14
		nsLeft 230
		nsTop 57
		nsRight 263
		nsBottom 88
		sightAngle 20
		x 248
		y 75
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 43)
					(gMessager say: noun theVerb 36 0) ; "That must be Marie Laveau."
				else
					(gMessager say: noun theVerb 37 0) ; "A striking portrait of a turbaned woman is on the back wall. Gabriel wonders who she might be."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sitSkeleton of Feature
	(properties
		noun 21
		nsLeft 102
		nsTop 93
		nsRight 125
		nsBottom 119
		sightAngle 20
		x 114
		y 109
	)
)

(instance hatSkeleton of Feature
	(properties
		noun 4
		sightAngle 20
		x 30
		y 199
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 90 9 85 27 85 33 92 36 99 50 99 54 101 55 105 48 112 51 122 55 121 60 124 60 127 49 134 51 138 63 137 69 128 80 132 74 141 76 145 0 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance whip of Feature
	(properties
		noun 7
		sightAngle 20
		x 93
		y 197
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 98 22 103 51 91 68 93 78 88 79 85 70 76 70 77 63 89 58 81 46 83 37 77 22
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 46)
					(gMessager say: noun theVerb 3 0) ; "Don't the Voudoun call a ritual whip a fwet kash?"
				else
					(gMessager say: noun theVerb 0 0) ; "A leather whip hangs from a peg on the wall."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 22
		nsLeft 114
		nsTop 71
		nsRight 138
		nsBottom 94
		sightAngle 20
		x 126
		y 82
	)
)

(instance stump of Feature
	(properties
		noun 11
		sightAngle 20
		x 198
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 122 197 102 216 119 217 137 195 141 178 136
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gEgo setScript: rubTheStump)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gourd of Feature
	(properties
		noun 15
		sightAngle 20
		x 311
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 110 298 103 299 97 305 89 319 86 319 118 308 115 304 109 293 116 288 116
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 46)
					(gMessager say: noun theVerb 3 0) ; "That gourd must be an asson."
				else
					(gMessager say: noun theVerb 0 0) ; "A beaded gourd is on display."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorWay of Feature
	(properties
		noun 2
		nsLeft 77
		nsTop 60
		nsRight 99
		nsBottom 120
		sightAngle 20
		x 89
		y 82
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if
					(and
						(== (gCurRoom script:) makeEgoLeave)
						(== (makeEgoLeave state:) 0)
					)
					(makeEgoLeave seconds: 0)
					(makeEgoLeave changeState: 1)
					(self dispose:)
				else
					(gEgo setScript: (ScriptID 261 5)) ; leaveRoom
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fanSwitch of Feature
	(properties
		noun 28
		nsLeft 68
		nsTop 83
		nsRight 71
		nsBottom 90
		sightAngle 20
		x 69
		y 88
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(cond
					((and (== (gCurRoom script:) snakeAttack) (not local7))
						(if (> (snakeAttack state:) 9)
							(gGame handsOff:)
							(gEgo getPoints: -999 5)
							(= local7 1)
						else
							(return 1)
						)
					)
					((IsFlag 111)
						(gMessager say: noun theVerb 10 0) ; "Gabriel has no interest in the noisy fan at the moment."
					)
					(else
						(SetFlag 111)
						(gEgo setScript: flipTheSwitch)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coffin of Feature
	(properties
		noun 10
		nsLeft 64
		nsTop 97
		nsRight 87
		nsBottom 106
		sightAngle 20
		x 77
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 46)
					(gMessager say: noun theVerb 3 0) ; "Professor Hartridge said that in Voudoun, a small ritual coffin is called a sekey madoul\82."
				else
					(gMessager say: noun theVerb 0 0) ; "On the table is a small coffin--so small, in fact, that it would only fit an infant."
				)
			)
			(6 ; Open
				(cond
					((IsFlag 114)
						(gMessager say: noun theVerb 17 0) ; "Opening the coffin again might call attention to the signal device."
					)
					(local4
						(if (IsFlag 113)
							(gEgo setScript: openTheCoffinAgain)
						else
							(gEgo setScript: openCoffinAndJohnIsHere)
						)
					)
					((IsFlag 113)
						(gEgo setScript: openTheCoffinAgain)
					)
					(else
						(gEgo setScript: openTheCoffin)
					)
				)
			)
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 114)
					(gMessager say: noun 6 17 0) ; "Opening the coffin again might call attention to the signal device."
				else
					(gEgo getPoints: -999 3)
					(gEgo setScript: putSignalDevInCoffin)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance attackMsg of Feature
	(properties
		noun 30
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun theVerb 11 0)
			(return 1)
		else
			(gMessager say: noun 12 11 0) ; "(GK-AM2--PLAYING TRYING WRONG ACTIONS DURING SNAKE ATTACK--ANXIOUS)That won't help get the python off Gabriel!"
			(return 1)
		)
	)
)

