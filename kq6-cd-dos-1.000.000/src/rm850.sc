;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use rgCastle)
(use NewFeature)
(use KQ6Print)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm850 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(class NewProp of Prop
	(properties
		normal 1
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not normal)
				(& (event type:) evVERB)
				(self onMe: event)
				(& _approachVerbs (gKq6ApproachCode doit: (event message:)))
			)
			(CueObj state: 0 cycles: 0 client: self theVerb: (event message:))
			(self doSpecial: (CueObj theVerb:))
			(event claimed: 1)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (doSpecial)
		(self cue:)
	)

	(method (cue)
		(gEgo setMotion: PolyPath approachX approachY CueObj)
	)
)

(instance rm850 of CastleRoom
	(properties
		noun 3
		picture 850
		style 10
		south 730
		vanishingX 124
		vanishingY 92
		minScaleSize 37
		minScaleY 111
		maxScaleY 177
		moveOtherGuard 1
	)

	(method (init)
		(LoadMany rsVIEW 881 883 850)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 181 -10 181 -10 -10 319 -10 319 189 304 179 288 179 279 182 263 182 254 179 246 179 225 164 202 164 191 152 206 152 193 143 229 143 203 129 172 129 156 124 151 116 169 116 169 112 101 112 89 124 76 129 70 129 50 141 57 141 38 155 56 155 45 166 21 166
					yourself:
				)
		)
		(if
			(and
				(gEgo has: 20) ; letter
				(== ((gInventory at: 8) owner:) 870) ; dagger
				(not ((ScriptID 80 0) tstFlag: #rFlag3 512)) ; rgCastle
				(> ((ScriptID 80 0) guardTimer:) 30) ; rgCastle
			)
			((ScriptID 80 0) setFlag: #rFlag3 512 guardTimer: 30) ; rgCastle
		)
		(portrait init: setPri: 0)
		(super init: &rest)
		((ScriptID 1015 6) talkWidth: 150 x: 15 y: 20) ; tlkGuardDog1
		((ScriptID 1015 7) talkWidth: 135 x: 160 y: 20) ; tlkGuardDog2
		(if (== ((gInventory at: 27) owner:) 850) ; nightingale
			(bird init:)
		)
		(gEgo
			init:
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(870
				(if (!= (gGlobalSound number:) 700)
					(gGlobalSound fadeTo: 700 -1)
				)
				(gEgo posn: 149 112)
			)
			(781
				(gGlobalSound fadeTo: 700 -1)
				(gEgo posn: (vizierDoor approachX:) (vizierDoor approachY:))
			)
			(880
				(gEgo loop: 1)
				(if (> (gEgo x:) 126)
					(gEgo posn: 173 130)
				else
					(gEgo posn: 187 140)
				)
			)
			(else
				(= local6 1)
				(if
					(or
						(not ((ScriptID 80 0) tstFlag: #rFlag1 512)) ; rgCastle
						((ScriptID 80 0) tstFlag: #rFlag2 1) ; rgCastle
						(not ((ScriptID 80 0) tstFlag: #rFlag1 128)) ; rgCastle
					)
					(gEgo posn: 230 185)
				else
					(gEgo posn: 160 185)
				)
				((ScriptID 80 0) setFlag: #rFlag1 128) ; rgCastle
			)
		)
		((ScriptID 80 0) guard1Code: guardsCode guard2Code: guardsCode) ; rgCastle
		(= spotEgoScr captureEgo)
		(if
			(or
				(not ((ScriptID 80 0) tstFlag: #rFlag1 512)) ; rgCastle
				(and
					((ScriptID 80 0) tstFlag: #rFlag2 1) ; rgCastle
					(not ((ScriptID 80 0) tstFlag: #rFlag3 256)) ; rgCastle
				)
				(not ((ScriptID 80 0) tstFlag: #rFlag1 128)) ; rgCastle
			)
			((ScriptID 80 5) ; guard1
				init:
				noun: 6
				loop: 3
				actions: guardDoVerb
				okToCheck: okToCheckCode
			)
			((ScriptID 80 5) signal: (& ((ScriptID 80 5) signal:) $efff)) ; guard1, guard1
			((ScriptID 80 6) ; guard2
				init:
				noun: 6
				loop: 3
				actions: guardDoVerb
				okToCheck: okToCheckCode
			)
			((ScriptID 80 6) signal: (& ((ScriptID 80 6) signal:) $efff)) ; guard2, guard2
			(= local1 1)
		)
		(vizierDoor cel: (* (== gPrevRoomNum 781) 3) init:)
		(gFeatures
			add:
				floor
				roomFeatures
				studyDoor
				cassima_door
				pillar
				chairs
				hideFeature
			eachElementDo: #init
		)
		(cond
			((and local1 ((ScriptID 80 0) tstFlag: #rFlag3 128)) ; rgCastle
				((ScriptID 80 5) loop: 2 posn: 118 116 okToCheck: 0) ; guard1
				((ScriptID 80 6) loop: 2 posn: 133 117 okToCheck: 0) ; guard2
				(self setScript: walkOutAtWrongTime)
			)
			((not ((ScriptID 80 0) tstFlag: #rFlag1 128)) ; rgCastle
				((ScriptID 80 5) posn: 105 149) ; guard1
				((ScriptID 80 6) posn: 143 150) ; guard2
				(self setScript: shouldNotHaveComeOut)
			)
			(
				(and
					((ScriptID 80 0) tstFlag: #rFlag2 1) ; rgCastle
					(not ((ScriptID 80 0) tstFlag: #rFlag3 256)) ; rgCastle
				)
				((ScriptID 80 5) okToCheck: 0 posn: 126 231) ; guard1
				((ScriptID 80 6) okToCheck: 0 posn: 163 233) ; guard2
				(self setScript: walkGuardsOnScreen)
			)
			((and local6 local1)
				(gGame handsOff:)
				(gEgo setSpeed: 8)
				(hideFeature doVerb: 5)
				((ScriptID 80 5) sightAngle: 180 posn: 105 149) ; guard1
				((ScriptID 80 6) sightAngle: 180 posn: 143 150) ; guard2
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 8)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag1 8) ; rgCastle
					(startGuardScr next: watchGuardsTalk)
					(watchGuardsTalk next: guardPatrol)
				else
					(startGuardScr next: guardPatrol)
				)
				((ScriptID 80 5) setScript: startGuardScr) ; guard1
			)
			(else
				(cond
					(((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
						((ScriptID 80 5) posn: 118 116) ; guard1
						((ScriptID 80 6) posn: 133 117) ; guard2
					)
					(((ScriptID 80 0) tstFlag: #rFlag3 256) ; rgCastle
						(= spotEgoScr walkGuardsOnScreen)
						((ScriptID 80 0) clrFlag: #rFlag2 1 guardTimer: 2) ; rgCastle
					)
					(local1
						((ScriptID 80 5) posn: 118 126) ; guard1
						((ScriptID 80 6) posn: 133 126) ; guard2
						(startGuardScr next: guardPatrol)
						((ScriptID 80 5) setScript: startGuardScr) ; guard1
					)
				)
				(gGame handsOn:)
				(if (== gPrevRoomNum 781)
					(gGame handsOff:)
				)
			)
		)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
		((ScriptID 80 0) setupGuards:) ; rgCastle
		(if local1
			(gGlobalSound4 number: 702 loop: 1 play:)
		)
	)

	(method (doit)
		(= local0 (gEgo onControl: 1))
		(cond
			(script 0)
			((and ((User alterEgo:) edgeHit:) ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
				(self setScript: weddingStarts)
			)
			((InRect 158 0 320 115 gEgo)
				(gCurRoom newRoom: 870)
			)
			((& local0 $2000)
				(gCurRoom newRoom: 781)
			)
			((& local0 $1200)
				(gCurRoom newRoom: 880)
			)
		)
		(if (and (not ((ScriptID 80 0) tstFlag: #rFlag2 2)) (< (gEgo y:) 117)) ; rgCastle
			((ScriptID 80 0) setFlag: #rFlag2 2) ; rgCastle
			(gMessager say: 3 3 17 0) ; "Alexander hears the muffled sound of crying coming from the back hallway."
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(roomConv add: -1 noun theVerb 0 1) ; "Alexander is standing in the upstairs hallway of the castle. Several doors lead off the hallway on the west wall. On the east wall is an alcove set behind a pillar. At the end of the hall is an exit into a north hallway."
					1
					(if local1
						(roomConv add: -1 noun theVerb 21 1) ; "Two guard dogs are on duty in the hallway."
						1
					else
						(roomConv add: -1 noun theVerb 22 1) ; "The hallway is currently empty."
						1
					)
					(roomConv init:)
					1
				)
				(2 ; Talk
					(if local1
						(gMessager say: noun theVerb 21) ; "The hallway does not reply."
						1
					else
						(gMessager say: noun theVerb 22) ; "Although the guards have been cleverly dismissed, Alexander still feels it prudent to be as quiet as possible."
						1
					)
				)
				(else
					(super doVerb: theVerb &rest)
					1
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if ((ScriptID 80 5) script:) ; guard1
			((ScriptID 80 5) setScript: 0) ; guard1
		)
		(if (!= newRoomNumber 730)
			((ScriptID 80 0) clrFlag: #rFlag3 16384) ; rgCastle
		)
		(if ((ScriptID 80 0) tstFlag: #rFlag3 256) ; rgCastle
			((ScriptID 80 0) guardTimer: 0) ; rgCastle
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (warnUser param1)
		(switch param1
			(1
				(self setScript: weddingStartsNow)
			)
			(2
				(gMessager say: 1 0 24 0) ; "Alexander hears the guard patrol coming back up the stairs from their little excursion with the mechanical nightingale."
				(= spotEgoScr walkGuardsOnScreen)
				((ScriptID 80 0) setFlag: #rFlag3 256 guardTimer: 5) ; rgCastle
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)
)

(instance hideEgo of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(= register ((ScriptID 80 0) tstFlag: #rFlag1 8)) ; rgCastle
		(super init: &rest)
	)

	(method (doit)
		(if (and (gEgo mover:) (== state 3))
			(gGame handsOff:)
			(if (not local4)
				(= local4 ((User curEvent:) x:))
				(= local5 ((User curEvent:) y:))
				(= cycles 3)
			)
			(gEgo setMotion: 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (and (not (event modifiers:)) (User input:))
			(event claimed: 1)
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 3))
					local1
					(or
						((ScriptID 80 5) onMe: event) ; guard1
						((ScriptID 80 6) onMe: event) ; guard2
					)
				)
				(gGame handsOff:)
				(= local8 1)
				(CueObj state: 0 cycles: 0 client: (ScriptID 80 5) theVerb: 2) ; guard1
				((CueObj client:) approachX: 218 approachY: 178)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				(gMessager say: 6 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dogs."
				(= next talkToGuards)
			else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 260 180 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo
					normal: 0
					view: 881
					setLoop: 2
					cel: 0
					x: 246
					y: 188
					setScale:
					scaleX: 148
					scaleY: 148
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(if (not local9)
					(if register
						(gGame handsOn:)
					)
				else
					(= local9 0)
					(= cycles 1)
				)
			)
			(4
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				((ScriptID 80 5) sightAngle: 40) ; guard1
				((ScriptID 80 6) sightAngle: 40) ; guard2
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					reset: 5 900
					posn: (hideFeature approachX:) (hideFeature approachY:)
				)
				(cond
					(
						(and
							(CueObj client:)
							((CueObj client:) approachX:)
							(&
								((CueObj client:) _approachVerbs:)
								(gKq6ApproachCode doit: (CueObj theVerb:))
							)
						)
						(if (== (CueObj client:) hideFeature)
							(= local10 1)
							((CueObj client:) doVerb: (CueObj theVerb:))
						else
							(gEgo
								setMotion:
									PolyPath
									((CueObj client:) approachX:)
									(+
										(gEgo z:)
										((CueObj client:) approachY:)
									)
									CueObj
							)
						)
					)
					(local4
						(gEgo setMotion: PolyPath local4 local5)
					)
				)
				(gGame handsOn:)
				(= local4 (= local5 (= register 0)))
				(self dispose:)
			)
		)
	)
)

(instance putDownBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(gMessager say: 4 37 19 0 self) ; "Alexander winds the mechanical nightingale and places it strategically on the floor of the upstairs hallway."
			)
			(3
				(gGlobalSound4 number: 930 loop: -1 play:)
				(gEgo
					normal: 0
					view: 883
					loop: 0
					cel: 0
					setScale:
					scaleX: 85
					scaleY: 85
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(4
				(gGlobalSound4 loop: 1 stop:)
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(bird init:)
				(gGlobalSound fadeTo: 931 -1)
				(gEgo put: 27 850) ; nightingale
				(gEgo reset: 1)
				(gGame givePoints: 4)
				((ScriptID 80 0) setFlag: #rFlag3 16384) ; rgCastle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance timerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(gMessager say: 1 0 2 1 self 880) ; "The mechanical song echoes in the corridor. Alexander hears the sound of boots pounding as the guard dogs come to investigate."
			)
			(2
				(if (& local0 (floor onMeCheck:))
					(gGame handsOff:)
					(gCurRoom spotEgo: (proc80_7))
					(self dispose:)
				else
					((ScriptID 80 6) ; guard2
						setMotion: MoveTo (bird x:) (- (bird y:) 2)
					)
					((ScriptID 80 5) ; guard1
						setMotion: MoveTo (- (bird x:) 30) (bird y:) self
					)
				)
			)
			(3
				((ScriptID 80 5) setMotion: MoveTo 129 144 self) ; guard1
			)
			(4
				((ScriptID 80 5) setHeading: 90 self) ; guard1
			)
			(5
				(= cycles 4)
			)
			(6
				(roomConv add: 880 1 0 2 2 add: 880 1 0 2 3 init: self) ; "Look at this, Wolf! A metal bird!", "Sure is, Bay. How do you suppose a metal bird got in here?"
			)
			(7
				((ScriptID 80 5) view: 884 loop: 1 cel: 0 setCycle: CT 4 1 self) ; guard1
				(gGlobalSound fadeTo: 700 -1)
			)
			(8
				(bird hide:)
				((ScriptID 80 5) setCycle: End self) ; guard1
			)
			(9
				(roomConv
					add: 880 1 0 2 4 ; "You got me, but there's somethin' weird about.... Hey! Could this be Cassima's nightingale, do you think?"
					add: 880 1 0 2 5 ; "What? You lapdog! The princess's nightingale isn't some tin thing!"
					add: 880 1 0 2 6 ; "How do you know? Have you seen it?"
					add: 880 1 0 2 7 ; "Well. No, but...."
					add: 880 1 0 2 8 ; "I don't know, Bay. Humans can be pretty strange. <Growf> With THEIR sense of smell, maybe she wouldn't even know it wasn't real. I say we take it downstairs to Captain Saladin. He'll know what to do with it."
					add: 880 1 0 2 9 ; "What about our post?"
					add: 880 1 0 2 10 ; "Jowels and Mite are in the other hallway. They can handle it for five minutes. Think about how happy the princess'd be to get her nightingale back."
					add: 880 1 0 2 11 ; "And then there's that reward money and my missus...."
					add: 880 1 0 2 12 ; "Right, Wolf. Let's go."
					init: self
				)
			)
			(10
				((ScriptID 80 5) view: 724 loop: 4 cel: 0 setCycle: StopWalk -1) ; guard1
				(self setScript: walkGuardsOffScreen self)
			)
			(11
				(gMessager say: 1 0 13 0 self) ; "The guard dogs spot Alexander on their way down the stairs with the mechanical nightingale."
			)
			(12
				(if (== (gCurRoom script:) hideEgo)
					(CueObj client: 0)
					(= local4 0)
					(hideEgo caller: self)
					(if (== ((gCurRoom script:) state:) 3)
						(hideEgo cue:)
					else
						(= local9 1)
					)
				else
					(= cycles 1)
				)
			)
			(13
				(gCurRoom spotEgo: (proc80_7))
				(self dispose:)
			)
		)
	)
)

(instance walkGuardsOffScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) setMotion: MoveTo 126 176 self) ; guard1
				((ScriptID 80 6) setMotion: MoveTo 163 176) ; guard2
			)
			(1
				(if register
					(gCurRoom spotEgo: (proc80_7))
				)
				(self dispose:)
			)
		)
	)
)

(instance captureEgo of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) setScript: 0 setMotion: 0 okToCheck: 0) ; guard1
				((ScriptID 80 6) setScript: 0 setMotion: 0 okToCheck: 0) ; guard2
				(Face register gEgo self)
			)
			(1
				(gMessager say: 1 0 9 1 self) ; "Hey! Who the...?"
			)
			(2
				(cond
					((not (gEgo facingMe: (ScriptID 80 5))) ; guard1
						(Face (ScriptID 80 5) gEgo self) ; guard1
					)
					((not (gEgo facingMe: (ScriptID 80 6))) ; guard2
						(Face (ScriptID 80 6) gEgo self) ; guard2
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(Face gEgo register self)
			)
			(4
				(roomConv add: -1 1 0 9 2 add: -1 1 0 9 3 init: self) ; "Um. Hello, there.", "Don't just stand there! Grab 'em, Bay!"
			)
			(5
				((proc80_7) setScript: (ScriptID 80 4) self 1) ; guardsGetEgo
			)
			(6
				(roomConv
					add: -1 1 0 9 4 ; "<GRRR> It's that saboteur fellow the vizier warned us about, I'll bet! I say we run him through right here and now!"
					add: -1 1 0 9 5 ; "No <woof>! The vizier'll run YOU through if he doesn't get a chance at the prisoner. Let's put him in the dungeon for safe keepin', then we'll go tell the Captain."
					add: -1 1 0 9 6 ; "Aye, Wolf. You're right. Let's go."
					init: self
				)
			)
			(7
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance walkGuardsOnScreen of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				((ScriptID 80 0) clrFlag: #rFlag2 1) ; rgCastle
				((ScriptID 80 5) ; guard1
					init:
					posn: 126 231
					setMotion: MoveTo 126 188 self
				)
				((ScriptID 80 6) init: posn: 163 233 setMotion: MoveTo 163 188) ; guard2
				((ScriptID 80 0) setupGuards:) ; rgCastle
			)
			(1
				(gMessager say: 1 0 11 0 self) ; "The two patrol guard dogs, returning from downstairs, walk into the hallway and see Alexander."
			)
			(2
				(if (== (gCurRoom script:) hideEgo)
					(CueObj client: 0)
					(= local4 0)
					(hideEgo caller: self)
					(if (== (hideEgo state:) 3)
						(hideEgo cue:)
					else
						(= local9 1)
					)
				else
					(self cue:)
				)
			)
			(3
				(if (not (vizierDoor cel:))
					(gCurRoom spotEgoScr: captureEgo)
					(gCurRoom spotEgo: (proc80_7))
				else
					((ScriptID 80 0) setFlag: #rFlag1 1) ; rgCastle
				)
			)
		)
	)
)

(instance shouldNotHaveComeOut of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				(= cycles 4)
			)
			(1
				(gMessager say: 1 0 3 0 self) ; "Alexander steps confidently out into the upstairs hallway...and sees two guard dogs."
			)
			(2
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance talkToGuards of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				((ScriptID 80 5) approachX: 0 approachY: 0) ; guard1
				(if (not local8)
					(gMessager say: 6 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dogs."
				else
					(= cycles 1)
				)
			)
			(1
				(if (& local0 $0080)
					(gEgo setMotion: PolyPath 218 178 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (not (gEgo facingMe: (ScriptID 80 5))) ; guard1
					(Face gEgo (ScriptID 80 5) self) ; guard1
				else
					(= cycles 1)
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 6 2 0 2 self oneOnly: 0) ; "Er, hello there. Could you tell me how I might go about getting an audience with the vizier?"
			)
			(5
				(gCurRoom spotEgo: (proc80_7))
				(self dispose:)
			)
		)
	)
)

(instance startGuardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) ignoreActors: 1 setMotion: MoveTo 118 116 self) ; guard1
				((ScriptID 80 6) setMotion: MoveTo 133 117) ; guard2
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance watchGuardsTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 1 0 self) ; "By Cerebus' collar, but I'll be glad when this weddin' is over! I'm gettin' mighty tired of this patrol, Bay! It's wearied me to the bones!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guardPatrol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(= cycles 2)
			)
			(2
				(if (not local7)
					((ScriptID 80 5) setMotion: MoveTo 102 145 self) ; guard1
					((ScriptID 80 6) setMotion: MoveTo 143 145) ; guard2
				else
					(self dispose:)
				)
			)
			(3
				(= state -1)
				((ScriptID 80 5) setMotion: MoveTo 115 114 self) ; guard1
				((ScriptID 80 6) setMotion: MoveTo 130 114) ; guard2
			)
		)
	)
)

(instance weddingStarts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound number: 701 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 8 1 self) ; "From downstairs, Alexander hears the first wafting strains of music. Hmmm. It's beautiful music...."
			)
			(2
				(gMessager say: 1 0 8 2 self) ; "It's wedding music!!!!!"
			)
			(3
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance weddingStartsNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) setFlag: #rFlag3 16384) ; rgCastle
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 8 0 self) ; "From downstairs, Alexander hears the first wafting strains of music. Hmmm. It's beautiful music...."
			)
			(2
				((ScriptID 80 5) setScript: walkGuardsOffScreen 0 1) ; guard1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkOutAtWrongTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (gCast contains: bird)
					(gMessager say: 1 0 33 0 self) ; "Alexander steps into the main hallway while the guards are investigating the nightingale."
				else
					(gMessager say: 1 0 7 0 self) ; "Alexander steps into the main hallway while the guards are headed south on their patrol."
				)
			)
			(2
				(gCurRoom spotEgo: (proc80_7))
			)
		)
	)
)

(instance lookThruKeyhole of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch (CueObj client:)
						(vizierDoor 795)
						(studyDoor 798)
					)
				)
				((ScriptID 82 1) ; keyHoleView
					noun: ((CueObj client:) noun:)
					actions: keyHoleActions
					init: temp0 0 0 92 54
				)
				(= cycles 2)
			)
			(1
				(gMessager say: ((CueObj client:) noun:) 1 29)
			)
		)
	)
)

(instance bird of Prop
	(properties
		x 146
		y 144
		view 883
		loop 4
		scaleSignal 1
		scaleX 96
		scaleY 96
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd ignoreActors: setScript: timerScr)
	)
)

(instance portrait of View
	(properties
		x 200
		view 850
		loop 6
		signal 24577
	)

	(method (init)
		(= y
			(if (OneOf ((gInventory at: 26) owner:) 880 gEgo) 112 else 100) ; nail
		)
		(super init: &rest)
	)
)

(instance vizierDoor of NewProp
	(properties
		x 59
		y 111
		noun 9
		sightAngle 40
		approachX 79
		approachY 127
		view 850
		signal 16385
	)

	(method (init)
		(if cel
			(self setScript: closeMe)
		)
		(super init: &rest)
		(if local1
			(if (not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
				(self approachVerbs: 5) ; Do
				(= normal 0)
			)
		else
			(self approachVerbs: 2 5) ; Talk, Do
		)
	)

	(method (onMe param1)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 2))
			(if (== (gEgo view:) 881)
				(= sightAngle 26505)
			else
				(= sightAngle 40)
			)
		)
		(return (super onMe: param1))
	)

	(method (doVerb theVerb)
		(if (not local1)
			(switch theVerb
				(5 ; Do
					(if (not ((ScriptID 80 0) tstFlag: #rFlag3 1024)) ; rgCastle
						((ScriptID 80 0) setFlag: #rFlag3 1024) ; rgCastle
						(gMessager say: noun theVerb 31 1) ; "Alexander finds the hallway door unlocked and slips inside."
					)
					(gCurRoom setScript: openVizDoor)
				)
				(1 ; Look
					(if (not local2)
						(++ local2)
						(|= _approachVerbs (gKq6ApproachCode doit: 1))
						(gMessager say: 10 theVerb 27) ; "A heavy wooden door leads off the hall."
					else
						(gCurRoom setScript: (ScriptID 82) 0 lookThruKeyhole) ; keyHoleScr
					)
				)
				(2 ; Talk
					(gMessager say: noun theVerb 22) ; "Is anyone in there?"
				)
				(else
					(if (== (gKq6ApproachCode doit: theVerb) -32768)
						(gMessager say: 9 0) ; "There's no reason to use that on the door."
					else
						(super doVerb: theVerb)
					)
				)
			)
		else
			(switch theVerb
				(1 ; Look
					(if (not local2)
						(++ local2)
						(gMessager say: 10 theVerb 27) ; "A heavy wooden door leads off the hall."
					else
						(gMessager say: 10 1 28) ; "Alexander wouldn't mind taking a peek through that keyhole, but it wouldn't be safe with the guard dogs around."
					)
				)
				(5 ; Do
					(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
						(gMessager say: 9 theVerb 25) ; "Alexander doesn't have time to mess with that now! Those guards won't be distracted forever!"
					else
						(gMessager say: noun theVerb 21) ; "!!!Do not print this! Comment MSG only."
					)
				)
				(2 ; Talk
					(gMessager say: noun theVerb 21) ; "Now would not be the best time to be knocking on or calling through the hallway doors."
				)
				(else
					(if (== (gKq6ApproachCode doit: theVerb) -32768)
						(gMessager say: 9 0) ; "There's no reason to use that on the door."
					else
						(gCurRoom spotEgo: (proc80_7))
					)
				)
			)
		)
	)

	(method (cue)
		(gGlobalSound4 flags: 1 stop:)
		(if cel
			(proc80_2 4)
		else
			(self setPri: -1 stopUpd:)
		)
	)

	(method (doSpecial param1)
		(switch param1
			(5
				(gMessager say: 10 5 21 0 NewProp) ; "Alexander decides to make a try for one of the bedroom doors."
			)
			(else
				(super doSpecial:)
			)
		)
	)
)

(instance openVizDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGlobalSound4 number: 901 loop: 1 flags: 0 play:)
				(vizierDoor setPri: 10 setCycle: End self)
			)
			(2
				(vizierDoor cue:)
				(self dispose:)
			)
		)
	)
)

(instance closeMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(vizierDoor setPri: 10 setCycle: Beg self)
			)
			(2
				(gGlobalSound4 number: 902 loop: 1 play:)
				(if ((ScriptID 80 0) tstFlag: #rFlag1 128) ; rgCastle
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance studyDoor of NewFeature
	(properties
		x 91
		y 114
		z 11
		noun 10
		nsTop 93
		nsLeft 88
		nsBottom 114
		nsRight 94
		sightAngle 360
		approachX 96
		approachY 115
	)

	(method (init)
		(super init: &rest)
		(if local1
			(if (not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
				(self approachVerbs: 5) ; Do
				(= normal 0)
			)
		else
			(self approachVerbs: 2 5) ; Talk, Do
		)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
						(or
							(and (== (gEgo view:) 881) (= sightAngle 26505))
							(= sightAngle 40)
						)
					)
					1
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((not local3)
						(++ local3)
						(gMessager say: noun theVerb 27) ; "A heavy wooden door leads off the hall."
						(if (not local1)
							(|= _approachVerbs (gKq6ApproachCode doit: 1))
						)
					)
					(local1
						(gMessager say: noun theVerb 28) ; "Alexander wouldn't mind taking a peek through that keyhole, but it wouldn't be safe with the guard dogs around."
					)
					(else
						(gCurRoom setScript: (ScriptID 82) 0 lookThruKeyhole) ; keyHoleScr
					)
				)
			)
			(2 ; Talk
				(if local1
					(gMessager say: 9 2 21 0) ; "Now would not be the best time to be knocking on or calling through the hallway doors."
				else
					(SetFlag 59)
					(gMessager say: noun theVerb 22 0 self) ; "Hello! Anybody in there?"
				)
			)
			(5 ; Do
				(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
					(gMessager say: 9 theVerb 25) ; "Alexander doesn't have time to mess with that now! Those guards won't be distracted forever!"
				else
					(gMessager say: noun theVerb 22) ; "The door is locked from the inside. There must be somebody in there."
				)
			)
			(64 ; nail
				(if local1
					(gMessager say: noun theVerb 21) ; "The guard dog patrol would probably not appreciate Alexander fiddling around with that door."
				else
					(gMessager say: noun theVerb 22) ; "Fiddling with that door would draw attention Alexander does not need--either from the guards in the next hallway or from the person behind the door."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(ClearFlag 59)
	)

	(method (doSpecial param1)
		(switch param1
			(5
				(gMessager say: 10 5 21 0 NewFeature) ; "Alexander decides to make a try for one of the bedroom doors."
			)
			(else
				(super doSpecial:)
			)
		)
	)
)

(instance floor of NewFeature
	(properties
		noun 4
		onMeCheck 66
	)

	(method (init)
		(super init: &rest)
		(= normal (not local1))
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== (gTheIconBar curInvIcon:) (gInventory at: 27)) ; nightingale
						(= _approachVerbs -32768)
						(= approachX 161)
						(= approachY 143)
					)
					(and
						(not (= _approachVerbs 0))
						(not (= approachX 0))
						(not (= approachY 0))
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(37 ; nightingale
				((ScriptID 80 0) setFlag: #rFlag1 256) ; rgCastle
				(= local7 1)
				(gCurRoom setScript: putDownBird)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doSpecial param1)
		(switch param1
			(37
				(gMessager say: 4 37 20 0 self) ; "Alexander walks into the hallway to use the mechanical nightingale."
			)
			(else
				(super doSpecial:)
			)
		)
	)
)

(instance cassima_door of Feature
	(properties
		x 155
		y 109
		z 7
		heading 180
		noun 11
		nsTop 94
		nsLeft 152
		nsBottom 110
		nsRight 159
		approachX 154
		approachY 111
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and (== (gEgo view:) 881) (= sightAngle 26505))
					(= sightAngle 45)
				)
			)
		)
	)
)

(instance pillar of Feature
	(properties
		x 189
		y 134
		z 32
		noun 8
		nsTop 72
		nsLeft 183
		nsBottom 133
		nsRight 196
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and (== (gEgo view:) 881) (= sightAngle 26505))
					(= sightAngle 45)
				)
				(or
					(InRect 175 71 206 135 param1)
					(InRect 191 135 206 144 param1)
				)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		noun 19
		onMeCheck 768
	)

	(method (onMe param1)
		(= x (param1 x:))
		(= y (param1 y:))
		(= sightAngle 26505)
		(return (super onMe: param1))
	)
)

(instance hideFeature of Feature
	(properties
		nsTop 64
		nsLeft 253
		nsBottom 177
		nsRight 319
		approachX 260
		approachY 180
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(local10
						(= local10 0)
					)
					((!= (gCurRoom script:) hideEgo)
						(gCurRoom setScript: hideEgo)
					)
					(else
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

(instance roomFeatures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(return
			(or
				(and (& $0004 temp0) (= noun 16))
				(and (& $0008 temp0) (= noun 15))
				(and (& $0020 temp0) (= noun 13))
			)
		)
	)
)

(instance guardsCode of Code
	(properties)

	(method (doit param1)
		(return
			(or
				(and (!= (gEgo view:) 881) (& local0 $0042))
				(& (param1 onControl: 1) $0040)
			)
		)
	)
)

(instance okToCheckCode of Code
	(properties)

	(method (doit param1)
		(return
			(or
				(< 90 (param1 heading:) 270)
				(<= (gEgo y:) (param1 y:))
				(<= (gEgo y:) 129)
			)
		)
	)
)

(instance guardDoVerb of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(cond
			((== theVerb 2) ; Talk
				(gCurRoom setScript: talkToGuards)
			)
			(((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
				(cond
					((OneOf theVerb 5 1) ; Do, Look
						(gMessager say: 6 theVerb 25)
					)
					((== (gKq6ApproachCode doit: theVerb) -32768)
						(gMessager say: 6 0 25) ; "The guard dogs are talking at the end of the hall, and Alexander has no desire to disturb them!"
					)
					(else
						(= temp0 0)
					)
				)
			)
			((== theVerb 37) ; nightingale
				(CueObj client: floor state: 0 cycles: 0 theVerb: 37)
				(KQ6Print posn: -1 10 say: 0 6 37 0 1 init:) ; "Remembering the guard dogs' interest in Cassima's nightingale, Alexander has a thought...."
				(gEgo
					setMotion:
						PolyPath
						(floor approachX:)
						(floor approachY:)
						CueObj
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance keyHoleActions of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(1 ; Look
				(gMessager say: ((CueObj client:) noun:) theVerb 29 2)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

