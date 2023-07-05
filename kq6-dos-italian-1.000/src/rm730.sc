;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm730 0
	kitchenDoor 1
	basementDoor 2
	proc730_3 3
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc730_3)
	(gCurRoom
		vanishingX: 160
		vanishingY: -10000
		maxScaleSize: 100
		minScaleSize: 60
	)
	(if local0
		(gCurRoom maxScaleY: 127 minScaleY: 68 minScaleSize: 64)
	else
		(gCurRoom maxScaleY: 174 minScaleY: 127)
	)
	(gEgo
		setScale:
			Scaler
			(gCurRoom maxScaleSize:)
			(gCurRoom minScaleSize:)
			(gCurRoom maxScaleY:)
			(gCurRoom minScaleY:)
	)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(for ((= temp0 param3)) (& param1 (OnControl CONTROL param2 temp0)) ((++ temp0))
	)
	(return temp0)
)

(instance rm730 of CastleRoom
	(properties
		noun 3
		picture 730
		style 10
		horizon 0
	)

	(method (init)
		(Load rsVIEW 730)
		(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
			0
		else
			(LoadMany rsVIEW 794 736)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 19 170 9 158 12 141 75 69 53 69 0 109 -50 110 -50 -60 369 -60 319 114 263 65 246 65 315 146 312 162 286 178 212 129 109 129 90 142 77 142 80 149 37 179
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 176 134 196 134 200 141 176 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 126 134 145 134 145 141 122 141
					yourself:
				)
		)
		(gFeatures
			add: urns chandelier balconyFtr pillarsFtr stairs
			eachElementDo: #init
		)
		((ScriptID 80 5) noun: 4) ; guard1
		((ScriptID 80 6) noun: 4) ; guard2
		(super init: &rest)
		(gEgo init:)
		(candles setCycle: Fwd init:)
		(switch gPrevRoomNum
			(740
				(gEgo posn: (throneDoor approachX:) (throneDoor approachY:))
			)
			(860
				(= local0 1)
				(gEgo posn: 272 84)
			)
			(850
				(= local0 1)
				(gEgo posn: 52 84)
				(cond
					(((ScriptID 80 0) tstFlag: #rFlag3 16384) ; rgCastle
						((ScriptID 80 0) clrFlag: #rFlag3 16384) ; rgCastle
						((ScriptID 80 5) ; guard1
							init:
							loop: 0
							posn: 107 68
							setPri: 0
							ignoreActors:
							setScale: Scaler 35 64 107 59 1
						)
						((ScriptID 80 6) ; guard2
							init:
							loop: 3
							posn: 111 68
							setPri: 0
							ignoreActors:
							setScale: Scaler 35 64 111 69 1
						)
						(gEgo posn: 46 83)
						(gGlobalSound fade: 80 25 10 0)
						(self setScript: followEgoIn)
					)
					((= local2 ((ScriptID 80 0) tstFlag: #rFlag1 512)) ; rgCastle
						((ScriptID 80 5) init: loop: 0 posn: 82 165) ; guard1
						((ScriptID 80 6) init: loop: 3 posn: 103 176) ; guard2
						((ScriptID 80 6) ; guard2
							signal: (& ((ScriptID 80 6) signal:) $efff) ; guard2
						)
						(saladin init: loop: 4 cel: 1 stopUpd:)
						(cond
							(((ScriptID 80 0) tstFlag: #rFlag2 1) ; rgCastle
								((ScriptID 80 5) posn: 9 113) ; guard1
								((ScriptID 80 6) posn: 18 128) ; guard2
								(self spotEgo: (ScriptID 80 5)) ; guard1
							)
							((not ((ScriptID 80 0) tstFlag: #rFlag1 2048)) ; rgCastle
								(gEgo posn: 51 83)
								(self setScript: overseeGuards)
							)
							(else
								(self setScript: tooManyTimes)
							)
						)
					)
				)
			)
			(840
				(gEgo setSpeed: 8 posn: 261 144)
				(self setScript: (ScriptID 732 0)) ; enterFromBasement
			)
			(else
				(gGlobalSound fadeTo: 700 -1)
				(gEgo reset: 3 733 posn: 229 181)
				((ScriptID 80 0) setFlag: #rFlag1 128) ; rgCastle
				(self setScript: (ScriptID 731 0)) ; bypassingWaiter
			)
		)
		(kitchenDoor init: stopUpd: ignoreActors:)
		(throneDoor
			init:
			ignoreActors:
			setPri: 1
			cel: ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
			stopUpd:
		)
		(basementDoor init: stopUpd: ignoreActors:)
		(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
			(if script
				(script next: saladinEnters)
			else
				(self setScript: saladinEnters)
			)
		)
		(proc730_3)
		((ScriptID 80 0) setupGuards:) ; rgCastle
		(if (gCast contains: saladin)
			(saladin
				setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
			)
			((saladin scaler:) doit:)
		)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (doit)
		(= local1 (gEgo onControl: 1))
		(cond
			(script 0)
			((== ((User alterEgo:) edgeHit:) 3)
				(gEgo y: (- (gEgo y:) 2))
				(self setScript: don_tLeave)
			)
			((& local1 $4000)
				(gCurRoom newRoom: 860)
			)
			((& local1 $2000)
				(gCurRoom newRoom: 850)
			)
			((& local1 $0800)
				(gCurRoom newRoom: 840)
			)
		)
		(if (!= (gEgo view:) 881)
			(if (and (& local1 $0200) local0)
				(= local0 0)
				(proc730_3)
			)
			(if (and (& local1 $0400) (not local0))
				(= local0 1)
				(proc730_3)
			)
		)
		(if (and (not (& local1 $0600)) (== vanishingY -10000))
			(if local0
				(= vanishingY -7)
			else
				(= vanishingY 92)
			)
		)
		(super doit: &rest)
	)

	(method (setScript param1)
		(if (and (== script saladinEnters) (!= param1 showLetter))
			(gGame handsOff:)
			(saladinEnters cue:)
		else
			(super setScript: param1 &rest)
		)
	)
)

(instance don_tLeave of Script
	(properties
		name {don'tLeave}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(gMessager say: 3 3 14 0 self) ; "The castle gates are locked from the outside. Alexander can't leave that way."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 32768)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 32768) ; rgCastle
					(gMessager say: 8 5 0 1 self) ; "Alexander decides to check out the door the waiter came through."
				else
					(= cycles 1)
				)
			)
			(1
				(gGlobalSound4 number: 901 loop: 1 play:)
				(gGlobalSound3 number: 731 loop: -1 play:)
				(kitchenDoor setCycle: End self)
			)
			(2
				(gGlobalSound4 stop:)
				(gEgo setHeading: 270 setMotion: MoveTo 57 143 self)
			)
			(3
				(gMessager say: 8 5 0 2 self) ; "No lunch is being served today! We're busy catering the wedding!"
			)
			(4
				(gEgo
					setMotion:
						MoveTo
						(kitchenDoor approachX:)
						(kitchenDoor approachY:)
						self
				)
			)
			(5
				(gGlobalSound3 stop:)
				(kitchenDoor setCycle: Beg self)
			)
			(6
				(gMessager say: 8 5 0 3 self oneOnly: 0) ; "Apparently, the kitchen is no place to be today."
			)
			(7
				(gGlobalSound4 number: 902 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance overseeGuards of Script
	(properties)

	(method (dispose)
		((ScriptID 80 0) setFlag: #rFlag1 2048) ; rgCastle
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1015 6) talkWidth: 150 x: 15 y: 20) ; tlkGuardDog1
				((ScriptID 1015 7) talkWidth: 135 x: 160 y: 20) ; tlkGuardDog2
				(= cycles 10)
			)
			(1
				(gMessager say: 1 0 3 0 self) ; "Uh, oh! So this is where they took the mechanical nightingale!"
			)
			(2
				(= seconds 2)
			)
			(3
				(gGlobalSound number: 710 loop: -1 play:)
				(if (IsFlag 72)
					(= register 5)
				else
					(= register 4)
				)
				(gMessager say: 1 0 register 1 self)
			)
			(4
				((ScriptID 80 5) setScript: (ScriptID 80 4) self 1) ; guard1, guardsGetEgo
			)
			(5
				(gEgo
					setSpeed: 8
					ignoreActors:
					setMotion: PolyPath (- (saladin x:) 45) (saladin y:) self
				)
				(= seconds 3)
			)
			(6
				((ScriptID 80 5) ; guard1
					setSpeed: 8
					ignoreActors:
					setMotion:
						PolyPath
						(- (saladin x:) 45)
						((ScriptID 80 6) y:) ; guard2
						self
				)
			)
			(7
				(gEgo setHeading: 90)
			)
			(8
				(gMessager say: 1 0 register 2 self oneOnly: 0)
			)
			(9
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance tooManyTimes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(= register (if (IsFlag 72) 5 else 4))
				(gMessager say: 1 0 register 1 self)
			)
			(2
				((ScriptID 80 5) setScript: (ScriptID 80 4) self 1) ; guard1, guardsGetEgo
			)
			(3
				(gMessager say: 1 0 register 2 self oneOnly: 0)
			)
			(4
				((ScriptID 80 0) setFlag: #rFlag1 8192) ; rgCastle
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance saladinEnters of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
		(gDirectionHandler add: self)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser canInput:)
				(or
					(& (event type:) evMOVE)
					(and (& (event type:) $0040) (!= (event message:) JOY_NULL)) ; direction
				)
			)
			(event claimed: 1)
			(self cue:)
		)
		(event claimed:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) weddingRemind: 0) ; rgCastle
				(if (== gPrevRoomNum 840)
					(self setScript: exitBaseScr self)
				else
					(self setScript: exitUpstairsScr self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 150 128 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(= cycles 5)
			)
			(4
				(saladin
					view: 737
					setLoop: 0
					cel: 0
					posn: 160 123
					setPri: 0
					sightAngle: 180
					init:
				)
				(throneDoor startUpd: cel: 2 stopUpd:)
				(gEgo
					setCycle: Rev
					setLoop: -1
					setLoop: 6
					setMotion: MoveTo 141 131 self
				)
			)
			(5
				(gEgo setCycle: StopWalk -1)
				(saladin setCycle: CT 2 1 self)
			)
			(6
				(DisposeScript 969)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(saladin setCycle: End self)
				(throneDoor setCycle: End)
			)
			(7
				(= cycles 20)
			)
			(8
				(gGlobalSound4 stop:)
				(saladin setLoop: 7 cel: 9 setPri: 9 setCycle: Beg self)
				(gGlobalSound4 number: 652 setLoop: 1 play:)
				(throneDoor setCycle: Beg throneDoor)
			)
			(9
				(= register (if (IsFlag 72) 11 else 10))
				(gMessager say: 1 0 register 0 self)
			)
			(10
				(gGame handsOn:)
				(if (HaveMouse)
					(= seconds 11)
				else
					(= seconds 21)
				)
			)
			(11
				(gGame handsOff:)
				(= register (if (IsFlag 72) 13 else 12))
				(gMessager say: 1 0 register 0 self)
			)
			(12
				(gEgo hide:)
				(saladin setLoop: 1 cel: 0 posn: 140 133 setCycle: End self)
			)
			(13
				(gEgo
					view: 737
					normal: 0
					setLoop: 2
					cel: 0
					x: 121
					y: 134
					setScale: 0
					setCycle: Walk
					setSpeed: 8
					setStep: 3 2
					show:
					setMotion: MoveTo 99 135 self
				)
				(saladin
					setLoop: 3
					cel: 0
					posn: 149 134
					setSpeed: 8
					setStep: 3 2
					setCycle: Walk
					setMotion: MoveTo 128 134
				)
			)
			(14
				(gEgo setLoop: 5 cel: 0)
				(saladin setMotion: MoveTo 128 134 self)
			)
			(15
				(gGlobalSound number: 705 setLoop: 1 play:)
				(saladin setLoop: 4 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 756 setLoop: 1 play:)
			)
			(16
				(saladin cycleSpeed: 8 setCycle: CT 2 -1 self)
			)
			(17
				(gEgo setLoop: 8 cel: 0 cycleSpeed: 5 setCycle: CT 3 1 self)
			)
			(18
				(= cycles 10)
			)
			(19
				(gGlobalSound2 number: 971 setLoop: 1 play: self)
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(20
				(EgoDead 32) ; "Evidently, Saladin is a dog to be reckoned with."
			)
		)
	)
)

(instance exitBaseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 173 127 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo
					normal: 0
					view: 881
					loop: 2
					cel: 0
					x: 158
					y: 132
					setScale:
					scaleX: 90
					scaleY: 90
					cycleSpeed: 8
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
				(gEgo posn: 173 127 reset: 5 setSpeed: 8)
				(= cycles 3)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance exitUpstairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 8 1 self) ; "Alexander looks cautiously around the grand hall, but there are no guard dogs to be seen."
			)
			(2
				(gEgo setSpeed: 8 setMotion: PolyPath 19 166 self)
			)
			(3
				(gEgo setHeading: 135 self)
			)
			(4
				(= cycles 4)
			)
			(5
				(gGame handsOff:)
				(gEgo
					normal: 0
					setScale:
					scaleX: 144
					scaleY: 144
					view: 881
					loop: 3
					cel: 4
					x: 38
					y: 175
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(gMessager say: 1 0 8 2 self) ; "The wedding music is coming from behind those two large doors!"
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo reset: 4 posn: 19 166 setSpeed: 8)
				(= cycles 4)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance showLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) setFlag: #rFlag1 1024) ; rgCastle
				(gGame givePoints: 3)
				(roomConv add: -1 6 61 21 1 add: -1 6 61 21 2 init: self) ; "Wait! If you love your princess, you'll hear me out!", "The vizier is not what he appears to be. Cassima is in terrible danger. I have proof that this is so! For your princess's sake, you must believe me!"
			)
			(1
				(gEgo hide:)
				(saladin
					setLoop: 6
					cel: 0
					setPri: 9
					posn: 140 133
					setCycle: End self
				)
			)
			(2
				(roomConv add: -1 6 61 21 3 init: self) ; "Let me see that!"
			)
			(3
				(= seconds 3)
			)
			(4
				(roomConv add: -1 6 61 21 4 init: self) ; "Saladin reads the letter, his sword point still against Alexander's throat. Alexander watches the guard dog's noble face darken with rage."
			)
			(5
				(saladin setCycle: Beg self)
			)
			(6
				(roomConv
					add: -1 6 61 21 5 ; "<Growl!> This is treason! I'll have his throat! But how do I know this letter is not a forgery? You could have written this yourself!"
					add: -1 6 61 21 6 ; "But I did not! Have you no doubts of your own about Alhazred? Don't you see, all he wants is the Crown! Cassima is being coerced. We must stop the wedding!"
					add: -1 6 61 21 7 ; "It is true. I have had my suspicions about the vizier--especially when King Caliphim and Queen Allaria died."
					init: self
				)
			)
			(7
				(gEgo show:)
				(saladin setLoop: 7 cel: 0 posn: 160 123 setCycle: End self)
				(gGlobalSound4 number: 652 setLoop: 1 play:)
			)
			(8
				(roomConv add: -1 6 61 21 8 add: -1 6 61 21 9) ; "But I have seen Cassima with him several times. She appears to be quite happy. Even...enthusiastic. I don't believe she could love him if he truly were so wicked.", "I cannot believe for a moment that she loves that snake."
				(if (IsFlag 72)
					(roomConv add: -1 6 61 20 1) ; "A jilted lover WOULD not believe it. But, come. See for yourself."
				else
					(roomConv add: -1 6 61 21 10) ; "Then see for yourself."
				)
				(roomConv init: self)
			)
			(9
				(gEgo put: 20) ; letter
				(= cycles 1)
			)
			(10
				(saladin
					view: 736
					loop: 4
					cel: 2
					scaleSignal: 1
					scaleX: 87
					scaleY: 87
					x: (+ (saladin x:) 1)
					y: (+ (saladin y:) 3)
				)
				(= cycles 8)
			)
			(11
				(saladin cel: 0)
				(= cycles 8)
			)
			(12
				(saladin cel: 3)
				(= cycles 8)
			)
			(13
				(throneDoor setCycle: End self)
				(gGlobalSound4 number: 901 setLoop: 1 play:)
			)
			(14
				(saladin
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 167 123 self
				)
			)
			(15
				(saladin loop: 4 cel: 3 stopUpd:)
				(gEgo setMotion: MoveTo 152 128 self)
			)
			(16
				(gEgo setMotion: MoveTo 152 122 self)
			)
			(17
				(= cycles 4)
			)
			(18
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance enterThroneRoom of Script
	(properties)

	(method (doit)
		(if (& local1 $1000)
			(gCurRoom newRoom: 740)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(throneDoor setCycle: End self)
			)
			(1
				(gGlobalSound4 stop:)
				(proc80_2 1)
			)
		)
	)
)

(instance followEgoIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGlobalSound stop:)
				(gGlobalSound number: 700 loop: -1 play: 80 fade: 127 25 10 0)
				(= cycles 10)
			)
			(2
				((ScriptID 80 5) setMotion: MoveTo 59 68 self) ; guard1
				((ScriptID 80 6) setMotion: MoveTo 69 68 self) ; guard2
			)
			(3 0)
			(4
				(gGlobalSound number: 710 loop: -1 play:)
				(gMessager say: 1 0 2 1 self) ; "I think Captain Saladin is down here and...."
			)
			(5
				(gMessager say: 1 0 2 2 self) ; "Hey! Look! An intruder! Grab him!"
			)
			(6
				(gCurRoom moveOtherGuard: 1)
				((ScriptID 80 5) setScript: (ScriptID 80 4) self 1) ; guard1, guardsGetEgo
			)
			(7
				(gMessager say: 1 0 2 3 self oneOnly: 0) ; "I'll bet this is the foreign saboteur fellow the vizier's been rantin' on about!"
			)
			(8
				(gGlobalSound fade:)
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance tryToOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 730
					loop: 4
					cel: 0
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 7 5 0 0 self) ; "The door is locked."
			)
			(4
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throneDoor of Prop
	(properties
		x 160
		y 100
		noun 9
		approachX 155
		approachY 129
		view 730
	)

	(method (init)
		(super init: &rest)
		(if (and (not local2) (not ((ScriptID 80 0) tstFlag: #rFlag1 2))) ; rgCastle
			(self approachVerbs: 5) ; Do
		)
	)

	(method (onMe param1)
		(return (and (super onMe: param1) (<= (param1 y:) 127)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (or (not local3) local2)
					(++ local3)
					(if
						(and
							(not local2)
							(not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
						)
						(|= _approachVerbs (gKq6ApproachCode doit: 1))
					)
					(gMessager say: 9 1 25) ; "On the north wall is a set of large double doors. From his experience with castle architecture, Alexander guesses that they lead to the throne room."
				else
					(gMessager say: noun theVerb 26 1 (ScriptID 82)) ; "Alexander looks through the keyhole.", keyHoleScr
					(gCurRoom
						setScript:
							((ScriptID 82) start: -1 yourself:) ; keyHoleScr
							0
							lookIntoThroneRoom
					)
				)
			)
			(5 ; Do
				(if local2
					(gMessager say: 7 5 22) ; "Alexander would never make it to that door with the guard dogs in the way."
				else
					(gCurRoom setScript: enterThroneRoom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance lookIntoThroneRoom of Script
	(properties)

	(method (dispose)
		(tempGuard1 dispose:)
		(tempGuard2 dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 82 1) noun: 5 init: 794) ; keyHoleView
				(tempGuard1 init: stopUpd:)
				(tempGuard2 view: ((ScriptID 80 6) view:) init: stopUpd:) ; guard2
				(= cycles 4)
			)
			(1
				(gMessager say: 9 1 26 2) ; "Two guard dogs are on duty in what appears to be a throne room."
			)
		)
	)
)

(instance tempGuard1 of View
	(properties
		x 148
		y 128
		noun 5
		view 724
		loop 4
		priority 14
		signal 16400
		scaleSignal 1
	)
)

(instance tempGuard2 of View
	(properties
		x 167
		y 126
		noun 5
		loop 4
		cel 1
		priority 14
		signal 16400
		scaleSignal 1
	)
)

(instance kitchenDoor of Prop
	(properties
		x 70
		y 143
		z 28
		noun 8
		approachX 79
		approachY 142
		view 730
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (and (not local2) (not ((ScriptID 80 0) tstFlag: #rFlag1 2))) ; rgCastle
			(self approachVerbs: 5) ; Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if local2
					(gMessager say: 7 5 22) ; "Alexander would never make it to that door with the guard dogs in the way."
				else
					(gCurRoom setScript: doKitchen)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basementDoor of Prop
	(properties
		x 250
		y 119
		noun 7
		approachX 228
		approachY 144
		view 730
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (and (not local2) (not ((ScriptID 80 0) tstFlag: #rFlag1 2))) ; rgCastle
			(self approachVerbs: 5) ; Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if local2
					(gMessager say: 7 5 22) ; "Alexander would never make it to that door with the guard dogs in the way."
				else
					(gCurRoom setScript: tryToOpenDoor)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance candles of Prop
	(properties
		x 161
		y 39
		onMeCheck 0
		view 730
		loop 3
		priority 15
		signal 16400
	)
)

(instance saladin of Actor
	(properties
		x 115
		y 166
		noun 6
		view 736
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			(local2
				(if (== theVerb 1) ; Look
					(if (IsFlag 72)
						(gMessager say: noun theVerb 18) ; "Saladin, the Captain of the Guard, is discussing the find of his upstairs patrol guards."
					else
						(gMessager say: noun theVerb 19) ; "The upstairs patrol guards are conversing with a regal-looking guard dog. He must be the one they were discussing upstairs; Saladin, Captain of the Guard."
					)
				else
					(gMessager say: 6 5 22) ; "With three guard dogs in the grand hall, it wouldn't be a good idea for Alexander to call attention to himself now!"
				)
			)
			((== theVerb 61) ; letter
				(gCurRoom setScript: showLetter)
			)
			((OneOf theVerb 1 2) ; Look, Talk
				(if (IsFlag 72)
					(gMessager say: noun theVerb 20)
				else
					(gMessager say: noun theVerb 21)
				)
			)
			((OneOf theVerb 5 8 18 65 33 16) ; Do, dagger, cassimaHair, note, ribbon, scythe
				(gMessager say: noun theVerb 23)
			)
			(else
				(gMessager say: 6 0 23) ; "I have this...."
			)
		)
	)
)

(instance urns of Feature
	(properties
		y 163
		onMeCheck 2
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(= x (param1 x:))
				(or (and (> (param1 x:) 160) (= noun 13)) (= noun 12))
			)
		)
	)
)

(instance chandelier of Feature
	(properties
		x 160
		y 160
		noun 14
		onMeCheck 4
	)
)

(instance balconyFtr of Feature
	(properties
		noun 16
		onMeCheck 128
	)
)

(instance pillarsFtr of Feature
	(properties
		noun 15
		onMeCheck 256
	)

	(method (onMe param1)
		(= x (param1 x:))
		(= y 0)
		(return
			(and
				(or
					(super onMe: param1)
					(InRect 50 59 66 70 param1)
					(InRect 254 62 271 70 param1)
				)
				(= y (localproc_0 256 x 116))
			)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 11
		onMeCheck 1040
	)

	(method (onMe param1)
		(= x (= y 0))
		(return (and (super onMe: param1) (= x (param1 x:)) (= y (param1 y:))))
	)
)

(instance roomConv of Conversation
	(properties)
)

