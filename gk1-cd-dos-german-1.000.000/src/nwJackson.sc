;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use GKTeller)
(use PFollow)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Orbit)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	nwJackson 0
	sMimeStuff 1
)

(local
	local0 = 1
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6
)

(instance nwJackson of Room
	(properties
		modNum 401
		noun 8
		picture 420
		style 14
		exitStyle 13
		horizon 25
		north 450
		east 410
		south 440
		vanishingY 35536
	)

	(method (cue)
		(if
			(or
				(gEgo script:)
				(IsFlag 443)
				(gEgo has: 42) ; veil
				(gTalkers size:)
			)
			(loreleiTimer setReal: nwJackson 5)
		else
			(sLoreleiDance cue:)
		)
	)

	(method (init)
		((ScriptID 401 4) beenAttached: 0) ; xMan
		(self setRegions: 401) ; JacksonSq
		(super init:)
		(if (!= gPrevRoomNum 400)
			(gEgo
				view: 902
				setLooper: (ScriptID 401 2) ; xSmallStopGroop
				setStep: 2 1
				setCycle: StopWalk -1
				init:
				state: 2
			)
		else
			(gCurRoom setScript: (ScriptID 402 0) 0 0) ; sBinoc
		)
		(if (IsFlag 228)
			(drawing init:)
		)
		(switch gPrevRoomNum
			(450
				(if (IsFlag 328)
					((ScriptID 401 7) ; xCrash
						posn: 165 100
						destX: 155
						destY: 190
						destRoom: 440
						init:
					)
				)
				(self setScript: sGabeEntersFromNorth)
			)
			(410 ; neJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 165 100
						destX: 165
						destY: 190
						destRoom: 440
						init:
					)
				)
				(cond
					((< (gEgo y:) 35)
						(gEgo y: 35)
					)
					((> (gEgo y:) 102)
						(gEgo y: 102)
					)
				)
				(gEgo
					posn: 315 (gEgo y:)
					setMotion: PolyPath 300 (gEgo y:)
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: 319 (gEgo y:)) ; xMime
				)
			)
			(440 ; swJackson
				(if (and (IsFlag 328) (== ((ScriptID 401 7) room:) gCurRoomNum)) ; xCrash
					((ScriptID 401 7) ; xCrash
						posn: 240 65
						destX: 340
						destY: 70
						destRoom: 410
						init:
					)
				)
				(if (> (gEgo x:) 225)
					(gEgo x: 225)
				)
				(if (< (gEgo x:) 20)
					(gEgo x: 20)
				)
				(if (IsFlag 229)
					(gCurRoom setScript: sTapBoy)
				else
					(gEgo
						posn: (gEgo x:) 140
						setMotion: PolyPath (gEgo x:) 130
					)
				)
				(if (IsFlag 102)
					((ScriptID 401 1) posn: (gEgo x:) 185) ; xMime
				)
			)
			(else
				(gEgo posn: 160 100)
			)
		)
		(if (and (IsFlag 102) (== gDay 1))
			((ScriptID 401 1) ; xMime
				view: 422
				code: specialMimeCode
				setCycle: StopWalk 422
				setMotion: PFollow gEgo 15
				setPri: -1
			)
		)
		(if (and (not (IsFlag 102)) (== gDay 1))
			((ScriptID 401 1) ; xMime
				view: 422
				code: specialMimeCode
				posn: 245 63
				init:
				setScript: sMimeStuff
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 309 20 297 28 277 27 224 28 190 31 158 37 120 48 81 64 52 81 33 100 13 132 13 189 229 189 229 121 237 117 249 116 260 111 262 108 284 104 319 103 319 20
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 87 129 87 129 82 151 82 151 94 163 94 163 111 138 111 138 97 103 97 103 109 88 109
					yourself:
				)
		)
		(bush init:)
		(statue init:)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1
				number: 420
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 10 0
			)
		)
		(slide init: setCycle: RandCycle)
		(accordian init: setCycle: Fwd)
		(washboard init: setCycle: Fwd)
		(jug init: setCycle: RandCycle)
		(if (<= 3 gDay 6)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 171 57 208 63 204 71 192 69 181 78 168 76 168 70 156 66
						yourself:
					)
			)
			(if (and (not (IsFlag 223)) (<= gDay 5))
				(SetFlag 390)
				(lorelei init: approachVerbs: 11 0 setScript: sLoreleiDance) ; Talk
				(fortuneTeller init: lorelei)
				(if (IsFlag 443)
					(veil init:)
				)
			)
			(booth init:)
			(chair1 init:)
			(chair2 init:)
			(if (and (not (IsFlag 399)) (IsFlag 397))
				(malia init: ignoreActors: 0)
				(= local3 1)
			)
		)
		(lamp init:)
		(trash init:)
		(bench init:)
		(sidewalk init:)
		(fence init:)
		(northExit init:)
		(southExit init:)
		(eastExit init:)
		(if (IsFlag 239)
			(ClearFlag 239)
			(if (== gPrevRoomNum 410) ; neJackson
				(artist init:)
				(gCurRoom setScript: sArtistTrysPickUpDrawing)
			)
		)
	)

	(method (dispose)
		(ClearFlag 390)
		(DisposeScript 402)
		(DisposeScript 64986)
		(DisposeScript 64939)
		(DisposeScript 64932)
		(DisposeScript 21)
		(DisposeScript 920)
		(DisposeScript 51)
		(if (!= gPrevRoomNum 400)
			(gGkMusic1 fade:)
		)
		(if (and (== (gEgo edgeHit:) EDGE_TOP) (IsFlag 102))
			(ClearFlag 102)
		)
		(mimeTimer2 client: 0 dispose: delete:)
		(super dispose:)
	)

	(method (doit)
		(if (and global181 (not script) (gEgo inRect: 308 21 319 30))
			(self setScript: sGabeExits)
		)
		(super doit:)
	)

	(method (reflectPosn param1 param2 &tmp temp0)
		(switch param2
			(1
				(param1 y: 136)
			)
			(2
				(param1 x: (+ 0 (param1 xStep:)))
			)
		)
	)

	(method (handleEvent event)
		(if (== gPrevRoomNum 400)
			(cond
				((event claimed:) 0)
				((== (event type:) evMOUSEBUTTON)
					((ScriptID 402 0) cue:) ; sBinoc
					(event claimed: 1)
				)
				((== (event type:) evMOUSERELEASE)
					(event claimed: 1)
				)
				((== (event type:) evKEYBOARD)
					(event claimed: 1)
				)
				(else
					(event claimed: 1)
				)
			)
			(super handleEvent: event &rest)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance sTapBoy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 229)
				(ClearFlag 228)
				(gEgo posn: 220 140 setMotion: MoveTo 211 140 self)
				(tapper
					posn: 220 155
					setStep: 2 1
					setCycle: StopWalk -1
					init:
					setMotion: MoveTo 220 145
				)
			)
			(1
				(Face gEgo drawing)
				(Face tapper drawing)
				(gMessager say: 9 0 18 1 self) ; "Can you reach that piece of paper?"
			)
			(2
				(gMessager say: 9 0 18 2 self) ; "<shrug>Sure thing."
			)
			(3
				(= cycles 2)
			)
			(4
				(tapper
					setCel: 0
					setLoop: 0
					view: 4281
					posn: 208 107
					setCycle: CT 6 1 self
				)
			)
			(5
				(drawing dispose:)
				(tapper setCycle: End self)
			)
			(6
				(gMessager say: 9 0 18 3 self) ; "Here ya go."
				(tapper setCel: 0 setLoop: 1 setCycle: End self)
			)
			(7
				(tapper view: 442 setCel: 1 posn: 220 142 setLoop: 4)
				(gEgo view: 440 setCel: 9 setLoop: 5 setCycle: Beg self)
			)
			(8
				(gEgo
					view: 902
					setCel: 0
					setLoop: 0
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
					setCycle: StopWalk -1
					init:
					state: 2
					get: 35 ; lostDrawing
				)
				(= cycles 1)
			)
			(9
				(gMessager say: 9 0 18 4 self) ; "Thanks, kid."
			)
			(10
				(gMessager say: 9 0 18 5 self) ; "Yup. See ya."
			)
			(11
				(tapper
					view: 442
					posn: 220 145
					setPri: -1
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: MoveTo 210 199 self
				)
				(gEgo getPoints: -999 1)
			)
			(12
				(SetFlag 238)
				(tapper dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x:) 20 self
				)
			)
			(1
				(gMessager say: 13 13 8 0 0 401) ; "The path north leads to St. Louis Cathedral. The cathedral is not available for the day 1 demo."
				(gEgo setMotion: MoveTo (gEgo x:) 35 self)
			)
			(2
				(gEgo ignoreHorizon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 193 78 self)
			)
			(1
				(gMessager say: 6 11 0 1 self 420) ; "(FRIENDLY. SPEAKING TO FORTUNE TELLER THAT HAD PREVIOUSLY RUN OFF)You're back! You know, you really freaked me out, running off like that!"
				(Face gEgo malia)
			)
			(2
				(= cycles 2)
			)
			(3
				(malia setCel: 0 setLoop: 1 setCycle: End self)
				(UpdateScreenItem malia)
				(gEgo hide:)
				(gMessager say: 6 11 0 2 self 420) ; "(SHE DOESN'T RESPOND...)Yoo-hoo. Anybody home?"
			)
			(4 0)
			(5
				(malia dispose:)
				(gCast eachElementDo: #hide)
				(self setScript: (ScriptID 421 0) self) ; sCutPanel1
			)
			(6
				(= cycles 2)
			)
			(7
				(DisposeScript 421)
				(gCurRoom style: 14 exitStyle: 13 drawPic: 420)
				((ScriptID 401 4) init:) ; xMan
				((ScriptID 401 3) init:) ; xWoman
				(SetFlag 399)
				(gCast eachElementDo: #show)
				(Face gEgo 320 20 self)
			)
			(8
				(gMessager say: 6 11 0 5 self 420) ; "(RRCC. A TERRIFIED, QUICK INTAKE OF BREATH)<gasp>!"
			)
			(9
				(gMessager say: 6 11 0 7 self 420) ; "(SCARED)What the hell is going on?"
			)
			(10
				(= local3 0)
				(gEgo getPoints: -999 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeEntersFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 310 31
					ignoreHorizon: 1
					setMotion: MoveTo 310 40 self
				)
			)
			(1
				(gEgo ignoreHorizon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAnnoyCajons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mimeTimer2 setReal: mimeTimer2 20)
				((ScriptID 401 1) ; xMime
					view: 422
					ignoreHorizon: 1
					ignoreActors: 1
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 122 118 self
				)
			)
			(1
				((ScriptID 401 1) ; xMime
					setSpeed: 12
					view: 4271
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) setCel: 0 setLoop: 1 setCycle: Fwd) ; xMime
				(= seconds 4)
			)
			(3
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: Fwd) ; xMime
				(= seconds 4)
			)
			(4
				((ScriptID 401 1) setCel: 0 setLoop: 3 setCycle: Osc) ; xMime
				(= seconds 4)
			)
			(5
				(self changeState: (Random 2 4))
			)
		)
	)
)

(instance sMimeStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 401 1) ; xMime
					view: 420
					setCel: 0
					setSpeed: 12
					setLoop: 0
					setCycle: End self
				)
			)
			(1
				(= seconds 4)
			)
			(2
				((ScriptID 401 1) setCycle: Beg self) ; xMime
			)
			(3
				(= seconds 4)
			)
			(4
				((ScriptID 401 1) setCycle: Beg self) ; xMime
			)
			(5
				((ScriptID 401 1) setCel: 0 setLoop: 2 setCycle: End self) ; xMime
			)
			(6
				((ScriptID 401 1) setCel: 0 setLoop: 3 setCycle: Fwd) ; xMime
				(= seconds 4)
			)
			(7
				((ScriptID 401 1) setCel: 0 setLoop: 4 setCycle: Fwd) ; xMime
				(= seconds 4)
			)
			(8
				((ScriptID 401 1) setCel: 8 setLoop: 2 setCycle: Beg self) ; xMime
			)
			(9
				(= seconds 4)
			)
			(10
				(self changeState: 0)
			)
		)
	)
)

(instance sMimeLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				((ScriptID 401 1) ; xMime
					view: 4201
					setCel: 0
					setLoop: 3
					setCycle: End self
				)
			)
			(2
				((ScriptID 401 1) ; xMime
					view: 422
					posn: 138 118
					ignoreHorizon: 1
					setSpeed: 6
					setCycle: StopWalk 422
					setPri: -1
					setMotion: PolyPath 245 63 self
				)
			)
			(3
				(gGame handsOn:)
				((ScriptID 401 1) setScript: sMimeStuff) ; xMime
				(self dispose:)
			)
		)
	)
)

(instance sGabeTrysPickUpDrawing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 226 140 self)
			)
			(1
				(Face gEgo drawing)
				(= cycles 1)
			)
			(2
				(gEgo view: 428 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gMessager say: 5 12 0 0) ; "Gabriel can't reach the drawing from where he is."
				(gEgo
					posn: 220 140
					normalize: 4 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sArtistTrysPickUpDrawing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(artist setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(artist setCycle: Beg self)
			)
			(3
				(gMessager say: 9 0 26) ; "Ooooh! Unbelievable! Rotten luck!"
				(artist
					view: 412
					setCel: 0
					setLoop: 9 1
					setCycle: Fwd
					setMotion:
						PolyPath
						315
						(if (> (gEgo y:) 80) 50 else 90)
						self
				)
			)
			(4
				(artist setMotion: MoveTo 340 (artist y:) self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLoreleiSpinL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lorelei setCel: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(lorelei setCel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(lorelei setCel: 0 setLoop: 6 setCycle: End self)
			)
			(3
				(lorelei setCel: 0 setLoop: 8 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sLoreleiSpinR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lorelei setCel: 3 setLoop: 8 setCycle: Beg self)
			)
			(1
				(lorelei setCel: 4 setLoop: 6 setCycle: Beg self)
			)
			(2
				(lorelei setCel: 4 setLoop: 3 setCycle: Beg self)
			)
			(3
				(lorelei setCel: 5 setLoop: 1 setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sPickUpVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 443)
				(gEgo setMotion: PolyPath 234 86 self)
			)
			(1
				(veil dispose:)
				(gEgo view: 425 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo
					get: 42 ; veil
					posn: 226 83
					normalize: 7 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setCel: 0
					setLoop: 7
					setStep: 2 1
				)
				(= cycles 1)
			)
			(3
				(gEgo getPoints: -999 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(ClearFlag 443)
				(gEgo getPoints: -999 1)
				(gEgo setMotion: PolyPath 194 71 self)
			)
			(2
				(if register
					(gMessager say: 2 35 0 1 self) ; "I think this veil belongs to you."
				else
					(gMessager say: 8 55 11 1 self) ; "Did you lose a veil?"
				)
				(gEgo
					view: 4251
					posn: 194 71
					setCel: 0
					setLoop: 0 1
					setCycle: End self
				)
			)
			(3 0)
			(4
				(gMessager say: 3 0 4 1 self) ; "Oh, my veil! I'm always losing those things--you have no idea...."
			)
			(5
				(gMessager say: 3 0 4 2 self) ; "Well, darling, you're such a sweetie to return a lady's delicates--and soooo handsome as well."
			)
			(6
				(gMessager say: 3 0 4 3 self) ; "Well, I...."
			)
			(7
				(gMessager say: 3 0 4 4 self) ; "And since you have such a clear...interest in fortunetelling, let me see your hands. They look soooo strong. Perhaps they will make both our fortunes clear, no?"
			)
			(8
				(gMessager say: 3 0 4 5 self) ; "(DISGUSTED)I wish something would."
				(gEgo z: 1000)
				(lorelei
					setPri: 75
					fixPriority: 1
					view: 4251
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(9 0)
			(10
				(gMessager say: 3 0 4 6 self) ; "(VERY FLIRTATIOUS)Mmmm, strong, yes, and yet so delicate and...flexible <sigh>."
			)
			(11
				(gMessager say: 3 0 4 7 self) ; "(FLIRTATIOUS)You don't know the half of it."
			)
			(12
				(gMessager say: 3 0 4 8 self) ; "Oh, good! I see a mysterious woman in your immediate future!"
			)
			(13
				(gMessager say: 3 0 4 9 self) ; "Madame Lorelei winks at Gabriel knowingly."
			)
			(14
				(gMessager say: 3 0 4 10 self) ; "(FLIRTATION AT FIRST, THEN FALTERING)She is a dangerous one, dark and beautiful. Ah...I see the road of your life forking, and very soon...."
				(lorelei
					fixPriority: 0
					setCel: 0
					setLoop: 3 1
					setCycle: End self
				)
				(gEgo z: 0 setCel: 0 setLoop: 2)
			)
			(15 0)
			(16
				(gMessager say: 3 0 4 11 self) ; "The blood drains from Madame Lorelei's face in an instant. Sweat beads on her upper lip."
				(lorelei setCel: 0 setLoop: 4 setCycle: End self)
			)
			(17 0)
			(18
				(gMessager say: 3 0 4 12 self) ; "Are you okay?"
				(gEgo view: 4251 setCel: 5 setLoop: 0)
			)
			(19
				(gMessager say: 3 0 4 13 self) ; "(BECOMING TRANCELIKE--HER VOICE CHANGES TO A MASCULINE ONE HERE--DEEP AND SCARY)There...are...forces...."
				(lorelei setCel: 0 setLoop: 5 setCycle: End self)
			)
			(20 0)
			(21
				(gMessager say: 3 0 4 14 self) ; "(TERRIFIED, CHOKED)Oh, God! Beware! Beware!"
			)
			(22
				(lorelei
					setSpeed: 3
					setCel: 0
					setLoop: 7 1
					setCycle: Fwd
					setMotion: MoveTo 221 60 self
				)
				(gEgo setCycle: Beg self)
			)
			(23 0)
			(24
				(gEgo
					normalize: 5 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
				)
				(= cycles 1)
			)
			(25
				(Face gEgo 320 0 0)
				(lorelei setMotion: MoveTo 350 60 self)
			)
			(26
				(gMessager say: 3 0 4 15 self) ; "What IS it about me lately?"
			)
			(27
				(SetFlag 223)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLoreleiGabeDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(loreleiCenter dispose:)
				(lorelei
					setCel: 0
					setLoop: 0 1
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 219 86 self
				)
			)
			(1
				(gEgo setMotion: PolyPath 234 86 self)
			)
			(2
				(Face gEgo lorelei self)
				(gMessager say: 2 12 2 0 self) ; "Not a bad idea."
			)
			(3 0)
			(4
				(lorelei z: 1000)
				(gEgo
					view: 4241
					setCel: 0
					setLoop: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(5
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(6
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(7
				(gEgo setCel: 0 setLoop: 3 setCycle: Fwd)
				(= ticks 120)
			)
			(8
				(gEgo setCel: 0 view: 4242 setLoop: 0 setCycle: End self)
			)
			(9
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(11
				(lorelei
					z: 0
					posn: 245 83
					view: 4243
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
				(gEgo
					normalize: 4 902
					setLooper: (ScriptID 401 2) ; xSmallStopGroop
					setStep: 2 1
				)
				(veil init:)
				(Face gEgo lorelei self)
			)
			(12 0)
			(13
				(lorelei setCel: 0 setLoop: 2 setCycle: End self)
			)
			(14
				(lorelei setCel: 0 setLoop: 3 setCycle: Fwd)
				(= ticks 120)
			)
			(15
				(lorelei
					view: 425
					setCel: 0
					setPri: 4
					setLoop: 0
					setCycle: End self
				)
			)
			(16
				(lorelei
					posn: 230 82
					setCel: 0
					setPri: -1
					setLoop: 2 1
					setCycle: Fwd
					setMotion: PolyPath 219 80 self
				)
				(Face gEgo lorelei self)
			)
			(17 0)
			(18
				(lorelei setMotion: PolyPath 212 62 self)
				(Face gEgo lorelei self)
			)
			(19 0)
			(20
				(lorelei setMotion: PolyPath 190 60 self)
			)
			(21
				(lorelei setMotion: MoveTo 173 68 self)
			)
			(22
				(lorelei view: 425 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(23
				(lorelei view: 4231 setCel: 14 setLoop: 0 setCycle: Beg self)
			)
			(24
				(gMessager say: 9 0 25 2 self) ; "Thanks, boys."
			)
			(25
				(gGkMusic1
					number: 420
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(SetFlag 443)
				(lorelei actions: fortuneTeller)
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLoreleiDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(loreleiTimer setReal: nwJackson (Random 10 25))
			)
			(1
				(= register 0)
				(lorelei actions: 0)
				(= local1 1)
				(if (not (== gPrevRoomNum 400))
					(gGame handsOff:)
					(gMessager say: 9 0 25 1 self) ; "Come on, boys, hoopla!"
				else
					(= cycles 1)
				)
			)
			(2
				(gGkMusic1
					number: 422
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(lorelei setCycle: End self)
			)
			(3
				(lorelei view: 423 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(4
				(lorelei
					view: 424
					setCel: 0
					setLoop: 2 1
					setCycle: Fwd
					setMotion: MoveTo 178 60 self
				)
			)
			(5
				(self setScript: sLoreleiSpinR self)
			)
			(6
				(lorelei
					setCel: 0
					setLoop: 2
					setCycle: Fwd
					setMotion: PolyPath 190 54 self
				)
			)
			(7
				(lorelei setCel: 0 setLoop: 6 setCycle: End self)
			)
			(8
				(lorelei setCel: 0 setLoop: 8 setCycle: End self)
			)
			(9
				(lorelei
					setCel: 0
					setLoop: 2
					setCycle: Fwd
					setMotion: PolyPath 222 60 self
				)
			)
			(10
				(loreleiCenter init:)
				(lorelei
					setCel: 0
					setLoop: 0
					setCycle: Fwd
					setMotion: PolyPath 234 86 self
				)
			)
			(11
				(gGame handsOn:)
				(lorelei setMotion: Orbit loreleiCenter 10)
				(self setScript: sLoreleiSpinR self)
			)
			(12
				(self setScript: sLoreleiSpinL self)
			)
			(13
				(lorelei setCel: 0 setLoop: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(14
				(if (< register 5)
					(++ register)
					(self changeState: 10)
				else
					(gGame handsOff:)
					(lorelei setMotion: PolyPath 234 86 self)
				)
			)
			(15
				(loreleiCenter dispose:)
				(lorelei setMotion: PolyPath 212 62 self)
			)
			(16
				(lorelei setCel: 0 setLoop: 7 setMotion: PolyPath 190 54 self)
			)
			(17
				(lorelei setCel: 0 setLoop: 0 setMotion: MoveTo 173 68 self)
			)
			(18
				(lorelei view: 423 setCel: 4 setLoop: 3 setCycle: Beg self)
			)
			(19
				(lorelei view: 423 setCel: 14 setLoop: 2 setCycle: Beg self)
			)
			(20
				(if (not (== gPrevRoomNum 400))
					(gGame handsOn:)
					(gMessager say: 9 0 25 2 self) ; "Thanks, boys."
				else
					(= cycles 1)
				)
			)
			(21
				(lorelei actions: fortuneTeller)
				(gGkMusic1
					number: 420
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(= cycles 1)
			)
			(22
				(= local1 0)
				(self changeState: 0)
			)
		)
	)
)

(instance artist of Actor
	(properties
		x 226
		y 140
		view 428
		loop 1
		signal 16417
	)
)

(instance malia of Actor
	(properties
		noun 6
		x 172
		y 80
		view 426
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 7) ; "It appears that Madame Lorelei has returned."
				(return 1)
			)
			(11 ; Talk
				(gCurRoom setScript: sGoToMalia)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lorelei of Actor
	(properties
		noun 2
		approachX 194
		approachY 71
		x 173
		y 68
		view 423
		loop 2
		yStep 1
		xStep 2
	)

	(method (doit)
		(super doit:)
		(if (and (self isBlocked:) (== script sLoreleiDance))
			(self setScript: sLoreleiGabeDance)
		)
	)

	(method (init)
		(super init:)
		(= baseSetter LoreleiBaseSetter)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(Face gEgo lorelei 0)
				(if local1
					(gMessager say: 2 7 2) ; "I'm looking, I'm looking!"
				else
					(gMessager say: 2 7 3) ; "(NRCC)Madame Lorelei, the fortuneteller, is garbed in a belly dancer's outfit and wears a boa around her neck...a REAL boa!"
				)
				(return 1)
			)
			(32 ; hundred
				(if local1
					(super doVerb: theVerb)
				else
					(gMessager say: 2 theVerb 3) ; MISSING MESSAGE
				)
				(return 1)
			)
			(10 ; Ask
				(if local1
					(gMessager say: 2 10 2) ; "She's busy at the moment."
				else
					(gMessager say: 2 10 3) ; "Could I ask you a few questions, Madame Lorelei?"
				)
				(return 1)
			)
			(12 ; Pickup
				(if local1
					(gEgo getPoints: 160 1)
					(self setScript: sLoreleiGabeDance)
				else
					(gMessager say: noun theVerb 3) ; "Madame Lorelei seems less approachable when she's behind that booth."
				)
				(return 1)
			)
			(22 ; fortScale_
				(gMessager say: noun theVerb 0) ; "Gabriel doesn't want to return the scale. It might be useful."
				(return 1)
			)
			(35 ; veil
				(gEgo put: 42) ; veil
				(self setScript: sGiveVeil 0 1)
				(return 1)
			)
			(11 ; Talk
				(if local1
					(gMessager say: noun theVerb 2) ; "She's busy at the moment."
				)
				(return 1)
			)
			(else
				(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(if local1
						(gMessager say: 2 0 2) ; "She's busy at the moment."
					else
						(gMessager say: noun 0 3) ; "Does this mean anything to you?"
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance tapper of Actor
	(properties
		view 442
		loop 2
	)
)

(instance mimeTimer2 of Timer
	(properties)

	(method (cue)
		(gMessager say: 1 13 1 1) ; "Knock it off, you, before I shove this washboard down your throat!"
		((ScriptID 401 1) setScript: sMimeLeaves) ; xMime
	)
)

(instance loreleiTimer of Timer
	(properties)
)

(instance accordian of Prop
	(properties
		noun 1
		x 93
		y 106
		view 427
		loop 1
		cel 4
		signal 16417
		cycleSpeed 9
	)
)

(instance washboard of Prop
	(properties
		noun 1
		x 151
		y 108
		view 427
		loop 2
		cel 5
		signal 16417
		cycleSpeed 9
	)
)

(instance slide of Prop
	(properties
		noun 1
		x 137
		y 94
		view 427
		loop 4
		cel 12
		signal 16417
		cycleSpeed 9
	)
)

(instance jug of Prop
	(properties
		noun 1
		x 112
		y 97
		view 427
		loop 5
		cel 9
		signal 16417
		cycleSpeed 9
	)
)

(instance drawing of View
	(properties
		noun 5
		x 252
		y 135
		view 428
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: sGabeTrysPickUpDrawing)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance veil of View
	(properties
		noun 10
		x 235
		y 86
		view 425
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(gEgo setScript: sPickUpVeil)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bush of View
	(properties
		noun 11
		modNum 401
		x 279
		y 63
		view 409
		loop 1
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; MISSING MESSAGE
		else
			(super doVerb: theVerb)
		)
	)
)

(instance statue of View
	(properties
		noun 14
		modNum 401
		x 313
		y 87
		priority 190
		fixPriority 1
		view 409
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel can't do that with the Jackson statue."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair1 of View
	(properties
		noun 4
		x 164
		y 67
		view 423
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 3) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "It appears that Madame Lorelei has returned."
					)
					(else
						(gMessager say: noun theVerb 6) ; "Madame Lorelei's booth is deserted."
					)
				)
				(return 1)
			)
			(8 ; Operate
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(GK-AM2)Madame Lorelei would not appreciate Gabriel using her booth while she's dancing."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 9) ; "(RRCC)Gabriel wouldn't mind getting his fortune told, but he doesn't want to pay good money for it."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "(RRCC)Perhaps Gabriel should just talk to her first."
					)
					(else
						(gMessager say: noun theVerb 6) ; "(GK-AM2)Gabriel wouldn't mind picking up a few extra bucks by using Madame Lorelei's booth while she's gone, but he doesn't know how to belly dance."
					)
				)
				(return 1)
			)
			(9 ; Move
				(gMessager say: noun theVerb 6) ; "Why do that to the booth?"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance booth of View
	(properties
		noun 4
		x 181
		y 74
		priority 70
		fixPriority 1
		view 423
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 3) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "It appears that Madame Lorelei has returned."
					)
					(else
						(gMessager say: noun theVerb 6) ; "Madame Lorelei's booth is deserted."
					)
				)
				(return 1)
			)
			(8 ; Operate
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(GK-AM2)Madame Lorelei would not appreciate Gabriel using her booth while she's dancing."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 9) ; "(RRCC)Gabriel wouldn't mind getting his fortune told, but he doesn't want to pay good money for it."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "(RRCC)Perhaps Gabriel should just talk to her first."
					)
					(else
						(gMessager say: noun theVerb 6) ; "(GK-AM2)Gabriel wouldn't mind picking up a few extra bucks by using Madame Lorelei's booth while she's gone, but he doesn't know how to belly dance."
					)
				)
				(return 1)
			)
			(9 ; Move
				(gMessager say: noun theVerb 6) ; "Why do that to the booth?"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair2 of View
	(properties
		noun 4
		x 196
		y 69
		view 423
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 3) ; "(NRCC)The booth is a colorful m\82lange. It announces the owner as Madame Lorelei and gives prices for palm readings--$20.00, crystal ball gazing--$15.00, and birth charts--$50.00."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "It appears that Madame Lorelei has returned."
					)
					(else
						(gMessager say: noun theVerb 6) ; "Madame Lorelei's booth is deserted."
					)
				)
				(return 1)
			)
			(8 ; Operate
				(cond
					(local1
						(gMessager say: noun theVerb 2) ; "(GK-AM2)Madame Lorelei would not appreciate Gabriel using her booth while she's dancing."
					)
					((and (not (IsFlag 223)) (not local1))
						(gMessager say: noun theVerb 9) ; "(RRCC)Gabriel wouldn't mind getting his fortune told, but he doesn't want to pay good money for it."
					)
					(local3
						(gMessager say: noun theVerb 7) ; "(RRCC)Perhaps Gabriel should just talk to her first."
					)
					(else
						(gMessager say: noun theVerb 6) ; "(GK-AM2)Gabriel wouldn't mind picking up a few extra bucks by using Madame Lorelei's booth while she's gone, but he doesn't know how to belly dance."
					)
				)
				(return 1)
			)
			(9 ; Move
				(gMessager say: noun theVerb 6) ; "Why do that to the booth?"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance loreleiCenter of Feature
	(properties
		nsRight 1
		nsBottom 1
		x 234
		y 86
	)
)

(instance lamp of Feature
	(properties
		noun 4
		modNum 401
		nsLeft 14
		nsTop 42
		nsRight 26
		nsBottom 84
		sightAngle 40
		approachX 49
		approachY 92
		approachDist 140
		x 20
		y 63
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "There's no reason to do that to the lampposts."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance trash of Feature
	(properties
		noun 12
		modNum 401
		nsLeft 11
		nsTop 89
		nsRight 26
		nsBottom 106
		sightAngle 40
		approachX 30
		approachY 105
		approachDist 31
		x 18
		y 97
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Gabriel doesn't want to throw that away."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bench of Feature
	(properties
		noun 1
		modNum 401
		nsTop 135
		nsRight 9
		nsBottom 145
		sightAngle 40
		approachX 18
		approachY 137
		approachDist 116
		x 4
		y 140
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "The bench doesn't work that way."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sidewalk of Feature
	(properties
		noun 9
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 301 41 215 45 155 58 100 81 63 109 55 131 192 131 207 110 230 101 229 143 9 143 11 126 28 97 47 79 87 56 155 32 204 25 301 25
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the sidewalk would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fence of Feature
	(properties
		noun 3
		modNum 401
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 107 291 107 275 111 240 125 259 134 319 140 318 144 238 144 231 134 234 107 269 98 318 97
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 0 0 0 modNum) ; "Using that on the fence would be pointless."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 140
		nsLeft 9
		nsBottom 145
		nsRight 231
		cursor 964
		exitDir 3
		eCursor 0
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 21
		nsLeft 308
		nsBottom 30
		nsRight 319
		cursor 961
		exitDir 1
		eCursor 0
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 31
		nsLeft 316
		nsBottom 109
		nsRight 319
		cursor 963
		exitDir 2
		eCursor 0
	)
)

(instance LoreleiBaseSetter of Code
	(properties)

	(method (doit param1)
		(param1
			brLeft: (- (param1 x:) 1)
			brRight: (+ (param1 x:) 1)
			brTop: (- (param1 y:) 1)
			brBottom: (param1 y:)
		)
	)
)

(instance specialMimeCode of Code
	(properties)

	(method (doit)
		(cond
			((and (IsFlag 102) ((ScriptID 401 1) inRect: 83 76 170 114)) ; xMime
				(ClearFlag 102)
				((ScriptID 401 1) setScript: sAnnoyCajons) ; xMime
			)
			(
				(and
					(not (IsFlag 102))
					(== gDay 1)
					(== ((ScriptID 401 1) script:) sAnnoyCajons) ; xMime
					(gEgo inRect: 112 118 132 128)
				)
				(SetFlag 102)
				(mimeTimer2 dispose:)
				((ScriptID 401 1) ; xMime
					view: 422
					setScript: 0
					setCycle: StopWalk 422
					setMotion: PFollow gEgo 15
					setPri: -1
				)
			)
			(
				(and
					(not (IsFlag 102))
					(== gDay 1)
					(== ((ScriptID 401 1) script:) sMimeStuff) ; xMime
					(gEgo inRect: 229 50 270 65)
				)
				(SetFlag 102)
				((ScriptID 401 1) ; xMime
					view: 422
					setScript: 0
					setCycle: StopWalk 422
					setMotion: PFollow gEgo 15
					setPri: -1
				)
			)
		)
	)
)

(instance fortuneTeller of GKTeller
	(properties
		curNoun 7
		sayNoun 8
		verb 55
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)

	(method (showCases)
		(super
			showCases:
				10 ; How's business?
				(and (not local6) (not (gEgo has: 42))) ; veil
				12 ; How about a reading?
				(== local5 1)
				13 ; (WEASELING)Could you just do a short reading...for an intimate friend?
				(== local5 2)
				14 ; That's a nice snake you have there.
				(== local4 1)
				15 ; I'd really like to know more about that snake.
				(== local4 2)
				11 ; Did you lose a veil?
				(gEgo has: 42) ; veil
		)
	)

	(method (cue)
		(switch iconValue
			(10 ; How's business?
				(= local6 1)
			)
			(12 ; How about a reading?
				(++ local5)
			)
			(13 ; (WEASELING)Could you just do a short reading...for an intimate friend?
				(++ local5)
			)
			(14 ; That's a nice snake you have there.
				(++ local4)
			)
			(15 ; I'd really like to know more about that snake.
				(++ local4)
			)
			(16 ; Er...nothing.
				(loreleiTimer setReal: sLoreleiDance (Random 10 25))
			)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(11 ; Did you lose a veil?
				(gEgo put: 42) ; veil
				(lorelei setScript: sGiveVeil)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

