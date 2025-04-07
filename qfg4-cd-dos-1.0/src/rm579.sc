;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 579)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use forest)
(use Interface)
(use Array)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm579 0
)

(local
	local0
	local1
	[local2 2]
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
	local14
	local15
	local16
	local17
	local18
	local19
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(cond
		((< (= temp0 (GetAngle param1 param2 (gEgo x:) (gEgo y:))) 90)
			(return 2)
		)
		((< temp0 180)
			(return 0)
		)
		((< temp0 270)
			(return 1)
		)
		(else
			(return 3)
		)
	)
)

(instance rm579 of GloryRm
	(properties
		noun 1
		picture 430
		horizon 79
		north 578
		east 585
		west 571
		topX 188
	)

	(method (init)
		(if
			(and
				(not gNight)
				(not (IsFlag 255))
				(not (IsFlag 35))
				(not gCombatMonsterNum)
			)
			(= local16 1)
			(= local4 (IntArray with: 0 0 0 0))
			(= local5 (IntArray with: 0 0 0 0))
			(= local6 (IntArray with: -15 105 76 105 76 123 -15 123))
			(= local7 (IntArray with: 102 117 195 117 195 131 102 131))
			(= local8 (IntArray with: 195 96 271 96 271 109 195 109))
			(= local9 (IntArray with: 241 143 335 143 335 162 241 162))
			(= local10 (IntArray with: 126 151 230 151 230 169 126 169))
			(= local11 (IntArray with: -10 153 88 153 88 171 -10 171))
			(SetFlag 35)
			(cond
				(gDebugging
					(= local0 (GetNumber {Leshy Event? (1 - 8)}))
				)
				((not (IsFlag 256))
					(= local0 1)
				)
				((not (IsFlag 257))
					(= local0 2)
				)
				((not (IsFlag 199))
					(= local0 3)
				)
				((not (IsFlag 186))
					(= local0 4)
				)
				((not (IsFlag 258))
					(= local0 5)
				)
				((not (IsFlag 259))
					(= local0 6)
				)
				((not (IsFlag 260))
					(= local0 7)
				)
				(else
					(= local0 8)
				)
			)
			(switch gPrevRoomNum
				(578
					(= local1 bush6)
				)
				(585
					(= local1 bush1)
				)
				(else
					(= local1 bush4)
				)
			)
			(heroTeller init: gEgo 579 7 128 2)
			((ScriptID 50 1) caller: self) ; enterRoomScr
			(bushPoly1 points: local6 size: 4)
			(bushPoly3 points: local8 size: 4)
			(bushPoly4 points: local9 size: 4)
			(bushPoly6 points: local11 size: 4)
			(if (not (OneOf local0 4 7 8))
				(bushPoly2 points: local7 size: 4)
				(bushPoly5 points: local10 size: 4)
				(gCurRoom
					addObstacle:
						bushPoly1
						bushPoly2
						bushPoly3
						bushPoly4
						bushPoly5
						bushPoly6
				)
			else
				(gCurRoom addObstacle: bushPoly1 bushPoly3 bushPoly4 bushPoly6)
			)
			(gLongSong number: 579 setLoop: -1 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 174 319 174 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 169 0 169 96 151 113 80 113 80 103 40 93 0 93
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 88 246 88 206 80 206 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(if (IsFlag 35)
			(bush1 init: setScaler: gEgo approachVerbs: 4) ; Do
			(if (not (OneOf local0 4 7 8))
				(bush2 init: setScaler: gEgo approachVerbs: 4) ; Do
			)
			(bush3 init: setScaler: gEgo approachVerbs: 4) ; Do
			(bush4 init: setScaler: gEgo approachVerbs: 4) ; Do
			(if (== local0 8)
				(bush5 x: 164 y: 147)
			)
			(bush5 init: setScaler: gEgo approachVerbs: 4) ; Do
			(bush6 init: setScaler: gEgo approachVerbs: 4) ; Do
		)
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 166 50 228 88 242 109 135 86 yourself:)
				130
				((Polygon new:)
					init: 301 123 160 189 75 189 53 148 77 115 126 134 165 126 129 109 160 95
					yourself:
				)
				60
		)
		(atp1 init:)
		(if gNight
			(atp2 view: 436 loop: 0 cel: 1 x: 79 y: 189)
			(atp3 init: setPri: 189)
		)
		(atp2 init: setPri: 189)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; detectMagicSpell
				(gMessager say: 0 81 0) ; "This entire area is permeated with powerful magical energy. It seems to be very chaotic and a little bit playful in nature. The bushes seem particularly suspect."
			)
			((Message msgSIZE 579 0 theVerb 0 1)
				(gMessager say: 0 theVerb 0 0 0 579)
			)
			(else
				((ScriptID 50) doVerb: theVerb) ; forest
			)
		)
	)

	(method (cue)
		(cond
			(local17
				(gLongSong number: 558 setLoop: -1 play:)
			)
			((OneOf local0 1 2 3 5 6)
				(bush1 setScript: sBushWiggle)
			)
			((OneOf local0 4 7)
				(bush5 cycleSpeed: 0 setScript: sRunFarBush)
			)
			((== local0 8)
				(bush5 setScript: sLastEvent)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== (bush5 script:) sRunFarBush)
			(bush5 setScript: 0)
		)
		(if local16
			(local4 dispose:)
			(local5 dispose:)
			(local6 dispose:)
			(local7 dispose:)
			(local8 dispose:)
			(local9 dispose:)
			(local10 dispose:)
			(local11 dispose:)
			(if (> (++ global455) 2)
				(= global455 0)
			)
			(gLongSong fade:)
			(ClearFlag 35)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				local16
				(== (gCurRoom script:) (ScriptID 32)) ; project
				(== ((ScriptID 32) state:) 3) ; project
			)
			(if (gCast contains: leshy)
				(leshy dispose:)
			)
			(if (gCast contains: bush1)
				(bush1 dispose:)
			)
			(if (gCast contains: bush2)
				(bush2 dispose:)
			)
			(if (gCast contains: bush3)
				(bush3 dispose:)
			)
			(if (gCast contains: bush4)
				(bush4 dispose:)
			)
			(if (gCast contains: bush5)
				(bush5 dispose:)
			)
			(if (gCast contains: bush6)
				(bush6 dispose:)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly1)
				((gCurRoom obstacles:) delete: bushPoly1)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly2)
				((gCurRoom obstacles:) delete: bushPoly2)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly3)
				((gCurRoom obstacles:) delete: bushPoly3)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly4)
				((gCurRoom obstacles:) delete: bushPoly4)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly5)
				((gCurRoom obstacles:) delete: bushPoly5)
			)
			(if ((gCurRoom obstacles:) contains: bushPoly6)
				((gCurRoom obstacles:) delete: bushPoly6)
			)
			(if (gEgo actions:)
				((gEgo actions:) dispose:)
			)
			(if (== (gLongSong number:) 579)
				(gLongSong number: 558 setLoop: -1 play:)
			)
		)
	)
)

(instance bushPoly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bushPoly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bushPoly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bushPoly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bushPoly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bushPoly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance atp1 of ForestView
	(properties
		x 81
		y 6
		view 434
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 316
		y 154
		view 432
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		x 202
		y 189
		view 436
		cel 2
	)
)

(instance heroTeller of Teller
	(properties)

	(method (respond)
		(super respond: &rest)
		(if
			(and
				(or (not iconValue) (== iconValue -999))
				(== (sEvent1_3_5Room state:) 5)
			)
			(self clean:)
			(sEvent1_3_5Room register: 1 cue:)
		)
		(if (== iconValue -999)
			((User curEvent:) claimed: 1)
		)
		(return 1)
	)
)

(instance heroTeller1 of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				10 ; Guess "Leshy"
				(or (IsFlag 176) (IsFlag 135))
				11 ; Guess "Rusalka"
				(or (IsFlag 177) (IsFlag 135))
		)
	)

	(method (sayMessage)
		(if (== iconValue 10) ; Guess "Leshy"
			(sEvent1_3_5Room register: 0)
			(gEgo solvePuzzle: 414 2)
			(SetFlag 256)
		else
			(sEvent1_3_5Room register: 1)
		)
		(gMessager say: sayNoun verb iconValue 0 sEvent1_3_5Room modNum)
	)

	(method (respond)
		(super respond: &rest)
		(if
			(and
				(or (not iconValue) (== iconValue -999))
				(== (sEvent1_3_5Room state:) 5)
			)
			(self clean:)
			(sEvent1_3_5Room register: 1 cue:)
		)
		(return 1)
	)
)

(instance heroTeller2 of Teller
	(properties)

	(method (showCases)
		(super showCases: 21 (IsFlag 166) 20 (IsFlag 335)) ; Guess "Elderbury Bush", Tell About Bush in Goo
	)

	(method (sayMessage)
		(if (== iconValue 20) ; Tell About Bush in Goo
			(SetFlag 257)
			(gEgo solvePuzzle: 416 2)
			(if (== (bush1 script:) sBushWiggle)
				(bush1 setScript: 0)
			)
			(self clean:)
			(gCurRoom setScript: sEvent2_6Room2)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance heroTeller3 of Teller
	(properties)

	(method (showCases)
		(super showCases: 22 (IsFlag 199) 41 (not (IsFlag 176))) ; Answer "Plant Bush", Make Wild Guess
	)

	(method (sayMessage)
		(if (== iconValue 22) ; Answer "Plant Bush"
			(sEvent1_3_5Room register: 2)
		else
			(sEvent1_3_5Room register: 0)
		)
		(gMessager say: sayNoun verb iconValue 0 sEvent1_3_5Room modNum)
	)

	(method (respond)
		(super respond: &rest)
		(if
			(and
				(or (not iconValue) (== iconValue -999))
				(== (sEvent1_3_5Room state:) 5)
			)
			(self clean:)
			(sEvent1_3_5Room cue:)
		)
		(return 1)
	)
)

(instance heroTeller4 of Teller
	(properties)

	(method (showCases)
		(super showCases: 37 (or (IsFlag 177) (IsFlag 135))) ; Guess "Rusalka"
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 37) ; Guess "Rusalka"
			(gEgo solvePuzzle: 418 2)
			(self clean:)
			(gCurRoom setScript: s4_7DoRiddle)
		else
			(ClearFlag 51)
			(super sayMessage: &rest)
		)
	)
)

(instance heroTeller5 of Teller
	(properties)

	(method (showCases)
		(super showCases: 50 (IsFlag 150)) ; Guess "Baba Yaga"
	)

	(method (sayMessage)
		(if (== iconValue 50) ; Guess "Baba Yaga"
			(gEgo solvePuzzle: 419 2)
			(sEvent1_3_5Room register: 3)
		else
			(sEvent1_3_5Room register: 4)
		)
		(gMessager say: sayNoun verb iconValue 0 sEvent1_3_5Room modNum)
	)

	(method (respond)
		(super respond: &rest)
		(if
			(and
				(or (not iconValue) (== iconValue -999))
				(== (sEvent1_3_5Room state:) 5)
			)
			(self clean:)
			(sEvent1_3_5Room cue:)
		)
		(return 1)
	)
)

(instance heroTeller6 of Teller
	(properties)

	(method (showCases)
		(super showCases: 51 (IsFlag 166)) ; Guess "Elderbury Bush"
	)

	(method (sayMessage)
		(if (== iconValue 51) ; Guess "Elderbury Bush"
			(SetFlag 259)
			(gEgo solvePuzzle: 420 2)
			(self clean:)
			(gCurRoom setScript: sEvent2_6Room2)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance heroTeller7 of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				53 ; Guess "Wraith"
				(!= gHeroType 1) ; Magic User
				52 ; Guess "Staff"
				(and (== gHeroType 1) [gEgoStats 35]) ; Magic User, ritualOfReleaseSpell
		)
	)

	(method (sayMessage)
		(cond
			((== iconValue 52) ; Guess "Staff"
				(gEgo solvePuzzle: 421 2)
				(self clean:)
				(gCurRoom setScript: s4_7DoRiddle)
			)
			((== iconValue 53) ; Guess "Wraith"
				(gEgo solvePuzzle: 421 2)
				(self clean:)
				(gCurRoom setScript: s4_7DoRiddle)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance leshy of Prop
	(properties
		view 425
		signal 16384
	)

	(method (init)
		(self setScale:)
		(= scaleX (Random 50 200))
		(= scaleY (Random 50 200))
		(super init: &rest)
	)
)

(instance bush1 of Actor
	(properties
		noun 13
		approachX 33
		approachY 125
		x 33
		y 121
		view 579
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((OneOf local0 1 3 5)
						(if (== self local1)
							(gCurRoom setScript: sEvent1_3_5Room)
						else
							(super doVerb: theVerb)
						)
					)
					((OneOf local0 2 6)
						(if (or (== self local1) local15)
							(= local15 0)
							(if (== (leshy script:) sEvent2_6Room)
								(sEvent2_6Room cue:)
							else
								(if (== (bush1 script:) sBushWiggle)
									(bush1 setScript: 0)
								)
								(leshy
									signal: (| (leshy signal:) $0001)
									init:
									x: 1000
									setScript: sEvent2_6Room
								)
							)
						else
							(super doVerb: theVerb)
						)
					)
					((OneOf local0 4 7)
						(if (not (s4Pop client:))
							(if (== (sRunFarBush register:) 1)
								(self setScript: s4Pop)
								(sRunFarBush changeState: 0)
							else
								(super doVerb: theVerb)
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((Message msgSIZE 579 noun theVerb 0 1)
				(super doVerb: theVerb)
			)
			(else
				((ScriptID 50) doVerb: theVerb) ; forest
			)
		)
	)
)

(instance bush2 of Prop
	(properties
		noun 13
		x 146
		y 129
		view 579
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (OneOf local0 1 3 5)) ; Do
				(if (== self local1)
					(gCurRoom setScript: sEvent1_3_5Room)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 2 6)) ; Do
				(if (== self local1)
					(= local15 1)
					(bush1 doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(bush1 doVerb: theVerb)
			)
		)
	)
)

(instance bush3 of Actor
	(properties
		noun 13
		x 235
		y 106
		view 579
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(or (== local0 4) (== local0 7))
					(== theVerb 4) ; Do
					(not (s4Pop client:))
				)
				(if (== (sRunFarBush register:) 3)
					(self setScript: s4Pop)
					(sRunFarBush changeState: 0)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 1 3 5)) ; Do
				(if (== self local1)
					(gCurRoom setScript: sEvent1_3_5Room)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 2 6)) ; Do
				(if (== self local1)
					(= local15 1)
					(bush1 doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(bush1 doVerb: theVerb)
			)
		)
	)
)

(instance bush4 of Actor
	(properties
		noun 13
		approachX 291
		approachY 150
		x 291
		y 159
		view 579
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(or (== local0 4) (== local0 7))
					(== theVerb 4) ; Do
					(not (s4Pop client:))
				)
				(if (== (sRunFarBush register:) 4)
					(self setScript: s4Pop)
					(sRunFarBush changeState: 0)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 1 3 5)) ; Do
				(if (== self local1)
					(gCurRoom setScript: sEvent1_3_5Room)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 2 6)) ; Do
				(if (== self local1)
					(= local15 1)
					(bush1 doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(bush1 doVerb: theVerb)
			)
		)
	)
)

(instance bush5 of Actor
	(properties
		noun 13
		approachX 182
		approachY 160
		x 182
		y 167
		view 579
		signal 16384
		moveSpeed 0
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (or (== local0 4) (== local0 7))) ; Do
				(if (bush5 mover:)
					(gMessager say: 13 4 61) ; "This bush is way too fast for you to catch!"
				else
					(gMessager say: 13 4 67) ; "The bush seems to be just out of your reach."
				)
			)
			((and (== theVerb 4) (OneOf local0 1 3 5)) ; Do
				(if (== self local1)
					(gCurRoom setScript: sEvent1_3_5Room)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 2 6)) ; Do
				(if (== self local1)
					(= local15 1)
					(bush1 doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(bush1 doVerb: theVerb)
			)
		)
	)
)

(instance bush6 of Actor
	(properties
		noun 13
		approachX 43
		approachY 160
		x 43
		y 167
		view 579
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(or (== local0 4) (== local0 7))
					(== theVerb 4) ; Do
					(not (s4Pop client:))
				)
				(if (== (sRunFarBush register:) 6)
					(self setScript: s4Pop)
					(sRunFarBush changeState: 0)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 1 3 5)) ; Do
				(if (== self local1)
					(gCurRoom setScript: sEvent1_3_5Room)
				else
					(super doVerb: theVerb)
				)
			)
			((and (== theVerb 4) (OneOf local0 2 6)) ; Do
				(if (== self local1)
					(= local15 1)
					(bush1 doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(bush1 doVerb: theVerb)
			)
		)
	)
)

(instance sBushWiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(switch global455
						(1
							(fx1 number: 998 play:)
						)
						(2
							(fx1 number: 1001 play:)
						)
						(else
							(fx1 number: 1002 play:)
						)
					)
					(= cycles 1)
				else
					(switch global455
						(1
							(gMessager say: 3 6 5 0 self) ; "Someone is giggling behind that bush. It sounds like a young child."
						)
						(2
							(gMessager say: 3 6 7 0 self) ; "A timid child's voice keeps calling plaintively, "Hello? Hello?""
						)
						(else
							(gMessager say: 3 6 3 0 self) ; "You hear a "Meow" sound from one of the bushes."
						)
					)
				)
			)
			(2
				(local1
					signal: (| (local1 signal:) $0001)
					setCycle: ForwardCounter 6 self
				)
			)
			(3
				(local1 signal: (& (local1 signal:) $fffe))
				(= seconds (Random 6 12))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sEvent1_3_5Room of Script
	(properties
		name {sEvent1&3&5Room}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(bush1 setScript: 0)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(switch global455
						(1
							(fx1 number: 1000 play:)
						)
						(2
							(fx1 number: 999 play:)
						)
						(else
							(fx1 number: 1003 play:)
						)
					)
					(= ticks 75)
				else
					(switch global455
						(1
							(gMessager say: 3 6 6 0 self) ; "Ha, ha! Gotcha!"
						)
						(2
							(gMessager say: 3 6 8 0 self) ; "A gruff male voice shouts, "Goodbye!""
						)
						(else
							(gMessager say: 3 6 4 0 self) ; "Suddenly the meow turns into a lion's ROAR!"
						)
					)
				)
			)
			(1
				(gEgo view: 2 setCel: 0 setCycle: 0)
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(2
				(fx1 number: 998 play:)
				(= cycles 30)
			)
			(3
				(gEgo normalize:)
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(4
				(heroTeller dispose:)
				(gGlory handsOff:)
				(switch local0
					(1
						(if (& gMsgType $0001)
							(= local18 1)
						else
							(|= gMsgType $0001)
						)
						(if (& gMsgType $0002)
							(^= gMsgType $0002)
							(= local19 1)
						)
						(gMessager say: 3 6 13 0 self) ; "You hear a giggle from behind the bush. Then a squeaky voice asks, "One and one and one make three; tell me what you make of me?""
						(heroTeller1 init: gEgo 579 7 128 4)
					)
					(3
						(gMessager say: 3 6 17 0 self) ; "Six and seven make thirteen; plant it in a garden green."
						(heroTeller3 init: gEgo 579 7 128 8)
					)
					(else
						(gMessager say: 3 6 31 0 self) ; "One and two and three make six; who hides her hut behind trick sticks?"
						(heroTeller5 init: gEgo 579 7 128 10)
					)
				)
			)
			(5
				(gGlory handsOff:)
				(switch local0
					(1
						(if (not local18)
							(^= gMsgType $0001)
						)
						(if local19
							(|= gMsgType $0002)
						)
						(heroTeller1 doVerb: 2)
					)
					(3
						(heroTeller3 doVerb: 2)
					)
					(else
						(heroTeller5 doVerb: 2)
					)
				)
			)
			(6
				(gGlory handsOff:)
				(if (gEgo actions:)
					((gEgo actions:) clean:)
				)
				(if (!= bush1 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush1
						signal: (| (bush1 signal:) $0001)
						setLoop: (+ (bush1 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(7
				(if (!= bush1 local1)
					(bush1 signal: (& (bush1 signal:) $fffe))
				)
				(if (!= bush2 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush2
						signal: (| (bush2 signal:) $0001)
						setLoop: (+ (bush2 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(8
				(if (!= bush2 local1)
					(bush2 signal: (& (bush2 signal:) $fffe))
				)
				(if (!= bush3 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush3
						signal: (| (bush3 signal:) $0001)
						setLoop: (+ (bush3 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(9
				(if (!= bush3 local1)
					(bush3 signal: (& (bush3 signal:) $fffe))
				)
				(if (!= bush4 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush4
						signal: (| (bush4 signal:) $0001)
						setLoop: (+ (bush4 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(10
				(if (!= bush4 local1)
					(bush4 signal: (& (bush4 signal:) $fffe))
				)
				(if (!= bush5 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush5
						signal: (| (bush5 signal:) $0001)
						setLoop: (+ (bush5 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(11
				(if (!= bush5 local1)
					(bush5 signal: (& (bush5 signal:) $fffe))
				)
				(if (!= bush6 local1)
					(gLongSong2 number: 939 setLoop: 1 play:)
					(bush6
						signal: (| (bush6 signal:) $0001)
						setLoop: (+ (bush6 loop:) 2) 1
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(12
				(if (!= bush6 local1)
					(bush6 signal: (& (bush6 signal:) $fffe))
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
				(local1
					signal: (| (local1 signal:) $0001)
					setLoop: (+ (local1 loop:) 2) 1
					setCycle: End self
				)
			)
			(13
				((gCurRoom obstacles:)
					delete:
						bushPoly1
						bushPoly2
						bushPoly3
						bushPoly4
						bushPoly5
						bushPoly6
				)
				(if (or (== register 0) (== register 3))
					(leshy
						signal: (| (leshy signal:) $0001)
						x: (local1 x:)
						y: (local1 y:)
						setLoop: (localproc_0 (local1 x:) (local1 y:)) 1
						setCel: 0
						init:
						setCycle: End self
					)
				else
					(= ticks 30)
				)
				(local1 dispose:)
			)
			(14
				(if (gCast contains: leshy)
					(leshy signal: (& (leshy signal:) $fffe))
				)
				(switch register
					(0
						(gMessager say: 3 6 15 0 self) ; "Leshy, Leshy, look and see, in a bush or up a tree."
					)
					(2
						(gCurRoom setScript: sEvent3Room)
					)
					(3
						(SetFlag 258)
						(if (IsFlag 166)
							(gMessager say: 3 6 32 0 self) ; "Baba Yaga Ogress fine; she makes magic with a rhyme."
						else
							(gMessager say: 3 6 33 0 self) ; "Guessing answers without knowing? Check your guesses first by going!"
						)
					)
					(else
						(switch local0
							(1
								(heroTeller1 dispose:)
							)
							(3
								(heroTeller3 dispose:)
							)
							(else
								(heroTeller5 dispose:)
							)
						)
						(= local17 1)
						(gLongSong fade: gCurRoom)
						(gGlory handsOn:)
						(self dispose:)
					)
				)
			)
			(15
				(= ticks 30)
			)
			(16
				(leshy signal: (| (leshy signal:) $0001) setCycle: Beg self)
			)
			(17
				(leshy dispose:)
				(switch local0
					(1
						(heroTeller1 dispose:)
					)
					(3
						(heroTeller3 dispose:)
					)
					(else
						(heroTeller5 dispose:)
					)
				)
				(= local17 1)
				(gLongSong fade: gCurRoom)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent2_6Room of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== local1 bush1)
						(local4 at: 0 bush4)
						(local4 at: 1 bush2)
						(local4 at: 2 bush6)
						(local4 at: 3 bush3)
						(local5 at: 0 bushPoly4)
						(local5 at: 1 bushPoly2)
						(local5 at: 2 bushPoly6)
						(local5 at: 3 bushPoly3)
						((gCurRoom obstacles:) delete: bushPoly1)
					)
					((== local1 bush4)
						(local4 at: 0 bush1)
						(local4 at: 1 bush3)
						(local4 at: 2 bush6)
						(local4 at: 3 bush2)
						(local5 at: 0 bushPoly1)
						(local5 at: 1 bushPoly3)
						(local5 at: 2 bushPoly6)
						(local5 at: 3 bushPoly2)
						((gCurRoom obstacles:) delete: bushPoly4)
					)
					((== local1 bush6)
						(local4 at: 0 bush3)
						(local4 at: 1 bush1)
						(local4 at: 2 bush4)
						(local4 at: 3 bush2)
						(local5 at: 0 bushPoly3)
						(local5 at: 1 bushPoly1)
						(local5 at: 2 bushPoly4)
						(local5 at: 3 bushPoly2)
						((gCurRoom obstacles:) delete: bushPoly6)
					)
				)
				(local1
					signal: (| (local1 signal:) $0001)
					setLoop: (+ (local1 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(1
				(local1 dispose:)
				(= cycles 10)
			)
			(2
				((= local1 (local4 at: 0))
					signal: (| (local1 signal:) $0001)
					setCycle: Fwd
				)
			)
			(3
				(local1
					setLoop: (+ (local1 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(4
				(local1 dispose:)
				((gCurRoom obstacles:) delete: (local5 at: 0))
				((= local1 (local4 at: 1))
					signal: (| (local1 signal:) $0001)
					setCycle: Fwd
				)
			)
			(5
				(local1
					setLoop: (+ (local1 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(6
				(local1 dispose:)
				((gCurRoom obstacles:) delete: (local5 at: 1))
				((= local1 (local4 at: 2))
					signal: (| (local1 signal:) $0001)
					setCycle: Fwd
				)
			)
			(7
				(local1
					setLoop: (+ (local1 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(8
				(local1 dispose:)
				((gCurRoom obstacles:) delete: (local5 at: 2))
				((= local1 (local4 at: 3))
					signal: (| (local1 signal:) $0001)
					setCycle: Fwd
				)
			)
			(9
				(local1
					setLoop: (+ (local1 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(10
				(local1 dispose:)
				((gCurRoom obstacles:) delete: (local5 at: 3))
				((= local1 bush5)
					signal: (& (local1 signal:) $0001)
					setCycle: Fwd
				)
			)
			(11
				(gGlory handsOff:)
				(local1
					setLoop: (+ (bush5 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(12
				(local1 dispose:)
				(= local1 0)
				((gCurRoom obstacles:) delete: bushPoly5)
				(leshy
					signal: (| (leshy signal:) $0001)
					x: (bush5 x:)
					y: (bush5 y:)
					setLoop: (localproc_0 (bush5 x:) (bush5 y:)) 1
					cycleSpeed: (* global433 2)
					setCel: 0
					setCycle: End self
				)
			)
			(13
				(leshy signal: (& (leshy signal:) $fffe))
				(if (== local0 2)
					(gMessager say: 3 6 16 0 self) ; "Two and two and two make six; a little bush is in a fix."
				else
					(gMessager say: 3 6 55 0 self) ; "Ten and twelve make twenty-two; this killer plant will crawl to you."
				)
			)
			(14
				(heroTeller dispose:)
				(if (== local0 2)
					(heroTeller2 init: gEgo 579 7 128 6)
				else
					(heroTeller6 init: gEgo 579 7 128 11)
				)
				(leshy signal: (| (leshy signal:) $0001) setCycle: Beg self)
			)
			(15
				(leshy x: 1000 signal: (& (leshy signal:) $fffe))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent2_6Room2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (< (gEgo x:) 160)
					(leshy
						x: (+ (bush5 x:) 30)
						setLoop: (localproc_0 (+ (bush5 x:) 30) (bush5 y:)) 1
					)
				else
					(leshy
						x: (- (bush5 x:) 30)
						setLoop: (localproc_0 (- (bush5 x:) 30) (bush5 y:)) 1
					)
				)
				(leshy
					signal: (| (leshy signal:) $0001)
					y: (bush5 y:)
					setScript: 0
					cycleSpeed: (* global433 2)
					setCycle: End self
				)
			)
			(1
				(leshy signal: (& (leshy signal:) $fffe))
				(= ticks 60)
			)
			(2
				(if (== local0 2)
					(gMessager say: 3 6 17 0 self) ; "Six and seven make thirteen; plant it in a garden green."
				else
					(gMessager say: 3 6 54 0 self) ; "Riddles, riddles, three, two, one. Next one and my riddling's done."
				)
			)
			(3
				(leshy signal: (| (leshy signal:) $0001) setCycle: Beg self)
			)
			(4
				(leshy dispose:)
				(if (== local0 2)
					(heroTeller2 dispose:)
				else
					(heroTeller6 dispose:)
				)
				(= local17 1)
				(gLongSong fade: gCurRoom)
				(= cycles 1)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent3Room of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (< (gEgo x:) 160)
					(leshy x: (+ (gEgo x:) 20) setLoop: 3 1)
				else
					(leshy x: (- (gEgo x:) 20) setLoop: 2 1)
				)
				(if (not (gCast contains: leshy))
					(leshy init:)
				)
				(leshy
					signal: (| (leshy signal:) $0001)
					show:
					y: (bush5 y:)
					setScript: 0
					setCel: 0
					cycleSpeed: (* global433 2)
					setCycle: End self
				)
			)
			(1
				(gMessager say: 3 6 66 0 self) ; "One and two should get you three; Come back when you've grown a tree."
			)
			(2
				(leshy setCycle: Beg self)
			)
			(3
				(if (== (gEgo actions:) heroTeller3)
					(heroTeller3 dispose:)
				)
				(leshy dispose:)
				(gLongSong fade:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRunFarBush of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(super doit: &rest)
		(if (== state 3)
			(= temp4 (gEgo x:))
			(= temp5 (gEgo y:))
			(switch register
				(1
					(= temp0 (local6 at: 0))
					(= temp1 (local6 at: 2))
					(= temp2 (local6 at: 1))
					(= temp3 (local6 at: 5))
					(if (< temp0 temp4 temp1)
						(bush5 x: (+ (- temp1 temp4) temp0))
					)
					(if (< temp2 temp5 temp3)
						(bush5 y: (+ (- temp3 temp5) temp2))
					)
				)
				(3
					(= temp0 (local8 at: 0))
					(= temp1 (local8 at: 2))
					(= temp2 (local8 at: 1))
					(= temp3 (local8 at: 5))
					(if (< temp0 temp4 temp1)
						(bush5 x: (+ (- temp1 temp4) temp0))
					)
					(if (< temp2 temp5 temp3)
						(bush5 y: (+ (- temp3 temp5) temp2))
					)
				)
				(4
					(= temp0 (local9 at: 0))
					(= temp1 (local9 at: 2))
					(= temp2 (local9 at: 1))
					(= temp3 (local9 at: 5))
					(if (< temp0 temp4 temp1)
						(bush5 x: (+ (- temp1 temp4) temp0))
					)
					(if (< temp2 temp5 temp3)
						(bush5 y: (+ (- temp3 temp5) temp2))
					)
				)
				(6
					(= temp0 (local11 at: 0))
					(= temp1 (local11 at: 2))
					(= temp2 (local11 at: 1))
					(= temp3 (local11 at: 5))
					(if (< temp0 temp4 temp1)
						(bush5 x: (+ (- temp1 temp4) temp0))
					)
					(if (< temp2 temp5 temp3)
						(bush5 y: (+ (- temp3 temp5) temp2))
					)
				)
			)
			(cond
				((!= (bush5 x:) local13)
					(= local13 (bush5 x:))
					(bush5 setCel: (Random 0 4))
				)
				((!= (bush5 y:) local14)
					(= local14 (bush5 y:))
					(bush5 setCel: (Random 0 4))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gPrevRoomNum
					(571
						(switch (++ local12)
							(1
								(= register 4)
							)
							(2
								(= register 1)
							)
							(3
								(= register 3)
							)
							(4
								(= register 6)
							)
						)
					)
					(578
						(switch (++ local12)
							(1
								(= register 6)
							)
							(2
								(= register 3)
							)
							(3
								(= register 1)
							)
							(4
								(= register 4)
							)
						)
					)
					(585
						(switch (++ local12)
							(1
								(= register 1)
							)
							(2
								(= register 4)
							)
							(3
								(= register 6)
							)
							(4
								(= register 3)
							)
						)
					)
				)
				(bush5
					signal: (| (bush5 signal:) $0001)
					setCycle: Fwd
					setStep: 5 5
					approachVerbs: 0
				)
				(switch register
					(1
						(bush5 setMotion: PolyPath 0 108 self)
					)
					(3
						(bush5 setMotion: PolyPath 269 97 self)
					)
					(4
						(bush5 setMotion: PolyPath 319 166 self)
					)
					(6
						(bush5 setMotion: PolyPath 0 184 self)
					)
				)
			)
			(1
				(if (< local12 5)
					(gMessager say: 3 6 28 0 self) ; "Nyaah ni nah ni naah nah!"
				)
			)
			(2
				(bush5 setCycle: End self)
			)
			(3
				(gGlory handsOn:)
			)
		)
	)
)

(instance s4Pop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local12 5)
					(gGlory handsOff:)
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
				(client
					signal: (| (client signal:) $0001)
					setLoop: (+ (client loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(client hide: signal: (& (client signal:) $fffe))
				(switch client
					(bush1
						((gCurRoom obstacles:) delete: bushPoly1)
					)
					(bush3
						((gCurRoom obstacles:) delete: bushPoly3)
					)
					(bush4
						((gCurRoom obstacles:) delete: bushPoly4)
					)
					(bush6
						((gCurRoom obstacles:) delete: bushPoly6)
					)
				)
				(if (== local12 5)
					(bush5
						signal: (| (bush5 signal:) $0001)
						setCycle: Fwd
						cycleSpeed: 6
						setMotion:
							MoveTo
							(if (< (bush5 x:) 160)
								(+ (bush5 x:) 30)
							else
								(- (bush5 x:) 30)
							)
							(bush5 y:)
							self
					)
				else
					(self dispose:)
				)
			)
			(2
				(bush5
					setScript: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(if (< (bush5 x:) 160)
							(- (bush5 x:) 10)
						else
							(+ (bush5 x:) 10)
						)
						(bush5 y:)
						self
				)
			)
			(3
				(gMessager say: 3 6 29 0 self) ; "Oops! Hi there."
			)
			(4
				(bush5
					setLoop: (+ (bush5 loop:) 2) 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong2 number: 939 setLoop: 1 play:)
			)
			(5
				(bush5 hide: signal: (& (bush5 signal:) $fffe))
				(leshy
					signal: (| (leshy signal:) $0001)
					x: (bush5 x:)
					y: (bush5 y:)
					setLoop: (localproc_0 (bush5 x:) (bush5 y:)) 1
					setCel: 0
					init:
					setCycle: End self
				)
			)
			(6
				(leshy signal: (& (leshy signal:) $fffe))
				(= ticks 120)
			)
			(7
				(heroTeller dispose:)
				(if (== local0 4)
					(gMessager say: 3 6 30 0 self) ; "Three and three and three make nine; who lives among the watery brine?"
					(heroTeller4 init: gEgo 579 7 128 9)
				else
					(if (== gHeroType 1) ; Magic User
						(gMessager say: 3 6 56 0 self) ; "Nine and eight make seventeen; watch out for the Faerie Queen."
					else
						(gMessager say: 3 6 57 0 self) ; "Five from fifteen leaves you ten; find the Heart scroll in its den."
					)
					(heroTeller7 init: gEgo 579 7 128 12)
				)
			)
			(8
				(= ticks 120)
			)
			(9
				(leshy signal: (| (leshy signal:) $0001) setCycle: End self)
			)
			(10
				(leshy setCycle: Beg self)
			)
			(11
				(leshy dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance s4_7DoRiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (not (gCast contains: leshy))
					(leshy init:)
				)
				(leshy
					signal: (| (leshy signal:) $0001)
					show:
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(if (== local0 4)
					(gMessager say: 3 6 31 0 self) ; "One and two and three make six; who hides her hut behind trick sticks?"
					(heroTeller4 dispose:)
					(SetFlag 186)
				else
					(gMessager say: 3 6 59 0 self) ; "I'm almost out of riddles; I'll ask you nothing more, but come back in a while just to see what I've in store!"
					(heroTeller7 dispose:)
					(SetFlag 260)
				)
			)
			(2
				(leshy setCycle: Beg self)
			)
			(3
				(leshy dispose:)
				(gLongSong fade:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLastEvent of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (not state) (< (gEgo distanceTo: bush5 55) 55))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bush5 setCycle: Fwd)
			)
			(1
				(gGlory handsOff:)
				(gEgo setMotion: 0)
				(fx1 number: 995 play:)
				(bush1
					signal: (| (bush1 signal:) $0001)
					setStep: 6 4
					setMotion: JumpTo (gEgo x:) (gEgo y:)
				)
				(= cycles 2)
			)
			(2
				(fx2 number: 995 play:)
				(bush3
					signal: (| (bush1 signal:) $0001)
					setStep: 6 4
					setMotion: JumpTo (gEgo x:) (gEgo y:)
				)
				(= cycles 2)
			)
			(3
				(fx3 number: 995 play:)
				(bush4
					signal: (| (bush1 signal:) $0001)
					setStep: 6 4
					setMotion: JumpTo (gEgo x:) (gEgo y:)
				)
				(= cycles 2)
			)
			(4
				(fx4 number: 995 play:)
				(bush6
					signal: (| (bush1 signal:) $0001)
					setStep: 6 4
					setMotion: JumpTo (gEgo x:) (gEgo y:)
				)
				(= cycles 20)
			)
			(5
				(fx1 number: 996 play:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 6
					setLoop: 4 1
					setCel: 0
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(6
				(fx2 number: 1000 play:)
				(bush1 signal: (& (bush1 signal:) $fffe))
				(bush3 signal: (& (bush3 signal:) $fffe))
				(bush4 signal: (& (bush4 signal:) $fffe))
				(bush5 signal: (& (bush5 signal:) $fffe))
				(bush6 signal: (& (bush6 signal:) $fffe))
				(= ticks 60)
			)
			(7
				(gMessager say: 3 6 58 0 self) ; "Leshy, Leshy, riddles done. Thank you much for all the fun."
			)
			(8
				(= ticks 60)
			)
			(9
				(SetFlag 255)
				(gLongSong2 number: 939 setLoop: 1 play:)
				(bush5
					signal: (| (bush5 signal:) $0001)
					setLoop: (+ (bush5 loop:) 2) 1
					setCycle: End self
				)
				(bush1
					signal: (| (bush1 signal:) $0001)
					setLoop: (+ (bush1 loop:) 2) 1
					setCycle: End
				)
				(bush3
					signal: (| (bush3 signal:) $0001)
					setLoop: (+ (bush3 loop:) 2) 1
					setCycle: End
				)
				(bush4
					signal: (| (bush4 signal:) $0001)
					setLoop: (+ (bush4 loop:) 2) 1
					setCycle: End
				)
				(bush6
					signal: (| (bush6 signal:) $0001)
					setLoop: (+ (bush6 loop:) 2) 1
					setCycle: End
				)
			)
			(10
				(= ticks 120)
			)
			(11
				(if ((gCurRoom obstacles:) contains: bushPoly1)
					((gCurRoom obstacles:) delete: bushPoly1)
				)
				(if ((gCurRoom obstacles:) contains: bushPoly2)
					((gCurRoom obstacles:) delete: bushPoly2)
				)
				(if ((gCurRoom obstacles:) contains: bushPoly3)
					((gCurRoom obstacles:) delete: bushPoly3)
				)
				(if ((gCurRoom obstacles:) contains: bushPoly4)
					((gCurRoom obstacles:) delete: bushPoly4)
				)
				(if ((gCurRoom obstacles:) contains: bushPoly5)
					((gCurRoom obstacles:) delete: bushPoly5)
				)
				(if ((gCurRoom obstacles:) contains: bushPoly6)
					((gCurRoom obstacles:) delete: bushPoly6)
				)
				(bush1 signal: (& (bush1 signal:) $fffe))
				(bush3 signal: (& (bush3 signal:) $fffe))
				(bush4 signal: (& (bush4 signal:) $fffe))
				(bush5 signal: (& (bush5 signal:) $fffe))
				(bush6 signal: (& (bush6 signal:) $fffe))
				(gEgo setLoop: 6 1 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo setSpeed: register normalize: 2)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fx1 of Sound
	(properties)
)

(instance fx2 of Sound
	(properties)
)

(instance fx3 of Sound
	(properties)
)

(instance fx4 of Sound
	(properties)
)

