;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room230 0
	door 1
	bookWyrm 2
	wyrmHead 3
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
)

(procedure (localproc_0 param1 param2)
	(switch (param1 owner:)
		(150
			(StrCpy param2 {North-east})
		)
		(200
			(StrCpy param2 {North-east})
		)
		(210
			(StrCpy param2 {West})
		)
		(220
			(StrCpy param2 {West})
		)
		(240
			(StrCpy param2 {East})
		)
		(250
			(StrCpy param2 {East})
		)
		(260
			(StrCpy param2 {South-west})
		)
		(270
			(StrCpy param2 {South-west})
		)
		(280
			(StrCpy param2 {South})
		)
		(300
			(StrCpy param2 {South-east})
		)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(gCindStory
			(gEgo doCode: egoDoCind)
			(bookWyrm doCode: wyrmDoCind)
		)
		(gJackStory
			(gEgo doCode: egoDoJack)
			(bookWyrm doCode: wyrmDoJack)
		)
		(gBremenStory
			(gEgo doCode: egoDoBremen)
			(bookWyrm doCode: wyrmDoBremen)
		)
		(gBeautyStory
			(gEgo doCode: egoDoBeauty)
			(bookWyrm doCode: wyrmDoBeauty)
		)
		(gSnowStory
			(gEgo doCode: egoDoSnow)
			(bookWyrm doCode: wyrmDoSnow)
		)
	)
)

(procedure (localproc_2)
	(house init:)
	(window1 init:)
	(road init:)
	(fence init:)
	(flower1 init:)
	(flower2 init:)
	(flower3 init:)
	(mountain init:)
	(stone init:)
	(rock init:)
	(grass init:)
	(stream init:)
	(cloud init:)
)

(procedure (localproc_3 &tmp temp0 temp1) ; UNUSED
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp1 (gStorySet at: temp0))
		(if (and (not (temp1 done:)) (temp1 selected:))
			(return temp1)
		)
	)
	(return -1)
)

(instance Room230 of FRoom
	(properties
		lookStr {This is the home of Bookwyrm.}
		picture 230
		style 0
		north 180
		east 240
		south 280
		west 220
		northX 81
		northY 46
		southX 166
		southY 172
		eastX 316
		eastY 160
		westX 5
		westY 160
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(LoadMany rsSOUND 122 104 103 154)
		(if (or (== gPrevRoomNum 180) (== gPrevRoomNum 235))
			(self defeatEntrance: 1)
		)
		(super init:)
		(proc10_29)
		(sfx number: 122 play:)
		(gTheIconBar enable: show:)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(localproc_2)
		(birdHouse stopUpd: init:)
		(switch global140
			(1
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 141 289 139 275 144 261 140 245 140 228 140 225 148 207 155 190 161 167 154 169 148 184 138 193 129 200 117 191 112 180 110 162 104 157 96 149 91 127 88 107 90 100 79 110 73 107 60 96 52 0 67 0 -26 319 -26
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 101 26 89 56 85 69 87 94 102 96 109 101 112 125 117 142 112 151 105 158 109 169 113 172 126 143 138 124 144 83 144 76 131 32 130 33 138 27 143 12 142 0 136
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 240 173 245 159 319 159 319 173
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 94 173 0 173 0 158 87 158
							yourself:
						)
				)
				(= local2 (Random 90 120))
				(bookWyrm view: 752 setLoop: 0 cel: 0 posn: 63 96 init:)
				(wyrmHead init:)
				(wyrmHands setPri: 4 init:)
				(door init:)
				(if (not (= global224 (proc10_17 InvFriend)))
					(cond
						((or (gEgo has: 2) (gEgo has: 3))
							(= global142 gJackStory)
							(localproc_1 global142)
						)
						((or (gEgo has: 0) (gEgo has: 1))
							(= global142 gCindStory)
							(localproc_1 global142)
						)
						(
							(and
								(== (gCindStory done:) 1)
								(== (gJackStory done:) 1)
								(== (gBeautyStory done:) 1)
								(== (gBremenStory done:) 1)
								(not (gSnowStory selected:))
							)
							(= local6 2)
							(gEgo doCode: egoDoSpecial)
							(bookWyrm doCode: wyrmDoSpecial)
						)
						(
							(and
								(== (gCindStory done:) 1)
								(== (gJackStory done:) 1)
								(== (gBeautyStory done:) 1)
								(== (gSnowStory done:) 1)
								(not (gBremenStory selected:))
							)
							(= local6 3)
							(gEgo doCode: egoDoSpecial)
							(bookWyrm doCode: wyrmDoSpecial)
						)
						(
							(and
								(== (gCindStory done:) 1)
								(== (gJackStory done:) 1)
								(== (gBeautyStory done:) 1)
								(not (gSnowStory selected:))
								(not (gBremenStory selected:))
							)
							(= local6 1)
							(gEgo doCode: egoDoSpecial)
							(bookWyrm doCode: wyrmDoSpecial)
						)
						(global142
							(localproc_1 global142)
						)
						(
							(and
								(IsObject global143)
								(== (global143 state:) 1)
								(== (global143 heardPro:) 0)
							)
							(localproc_1 global143)
						)
						((not (proc10_18))
							(gEgo doCode: egoDoNoStory)
							(bookWyrm doCode: wyrmDoNoStory)
						)
						((and (IsObject global144) (== (global144 heardEp:) 0))
							(localproc_1 global144)
						)
					)
				else
					(= global224 (global224 regActor:))
					(= local3 (gEgo doCode:))
					(= local4 (global224 doCode:))
					(global224 doCode: doFollower)
					(cond
						((OneOf (global224 talkerID:) 6 7 9 8)
							(= local5 gBremenStory)
						)
						((OneOf (global224 talkerID:) 16 15)
							(= local5 gSnowStory)
						)
					)
					(localproc_1 local5)
				)
			)
			(0
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 141 289 139 275 144 261 140 245 140 225 141 222 148 205 154 195 159 173 159 169 148 174 140 203 124 206 117 195 110 180 110 162 105 159 102 159 97 133 87 100 91 100 82 110 73 107 60 96 52 0 67 0 -26 319 -26
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 101 41 88 41 101 116 115 142 112 149 108 161 108 171 117 170 130 161 134 124 144 85 146 76 131 29 133 37 139 27 143 12 142 0 136
							yourself:
						)
				)
				(gEgo doCode: egoDo230)
				(bookWyrm doCode: wyrmBegGame)
				(gCurRoom setScript: (ScriptID 232 5)) ; begGame
			)
			(2
				(door init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 141 289 139 275 144 261 140 245 140 228 140 225 148 207 155 190 161 167 154 169 148 184 138 207 128 207 117 195 110 180 110 162 104 157 96 149 91 127 88 114 89 103 81 110 73 107 60 96 52 0 67 0 -26 319 -26
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 101 26 89 56 85 69 87 94 102 96 109 101 112 125 117 142 112 151 105 158 109 169 113 172 126 143 138 124 144 83 144 76 131 32 130 33 138 27 143 12 142 0 136
							yourself:
						)
				)
			)
		)
		(falls setCycle: Fwd init:)
	)

	(method (enterSpecial)
		(cond
			((!= gPrevRoomNum 235)
				(self setScript: (ScriptID 231 2) self) ; enterFromNorth
			)
			((== global140 0)
				(self setScript: (ScriptID 231 4) self) ; enterFromHouse
			)
			(else
				(self setScript: (ScriptID 231 1) self) ; exitFromHouse
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch global140
			(1
				((= local8 (bookWyrmTalkObj)) view: 748)
				(local8 nsLeft: 108)
				((local8 bust:) nsLeft: 43 nsTop: 16 view: 748)
				((local8 eyes:) nsLeft: 47 nsTop: 18 view: 748)
				((local8 mouth:) nsLeft: 43 nsTop: 33 view: 748)
				(cond
					((not global224)
						(cond
							(
								(and
									(== (gCindStory done:) 1)
									(== (gJackStory done:) 1)
									(== (gBeautyStory done:) 1)
									(== (gBremenStory done:) 1)
									(not (gSnowStory selected:))
								)
								(self setScript: enterSpec 0 local6)
							)
							(
								(and
									(== (gCindStory done:) 1)
									(== (gJackStory done:) 1)
									(== (gBeautyStory done:) 1)
									(== (gSnowStory done:) 1)
									(not (gBremenStory selected:))
								)
								(self setScript: enterSpec 0 local6)
							)
							(
								(and
									(== (gCindStory done:) 1)
									(== (gJackStory done:) 1)
									(== (gBeautyStory done:) 1)
									(not (gSnowStory selected:))
									(not (gBremenStory selected:))
								)
								(self setScript: enterSpec 0 local6)
							)
							(global142
								(switch global142
									(gCindStory
										(self setScript: (ScriptID 233 0)) ; enterCind
									)
									(gJackStory
										(self setScript: (ScriptID 233 1)) ; enterJack
									)
									(gBremenStory
										(self setScript: (ScriptID 233 2)) ; enterBremenNo
									)
									(gBeautyStory
										(self setScript: (ScriptID 233 3)) ; enterBeautyNo
									)
									(gSnowStory
										(self setScript: (ScriptID 233 4)) ; enterSnowNo
									)
								)
							)
							(
								(and
									(IsObject global143)
									(== (global143 state:) 1)
									(== (global143 heardPro:) 0)
								)
								(self setScript: (ScriptID 232 1)) ; storyIntro
								(global143 heardPro: 1)
							)
							((and (!= gPrevRoomNum 235) (not (proc10_18)))
								(self setScript: (ScriptID 232 0)) ; enterNoStory
							)
							(
								(and
									(IsObject global144)
									(== (global144 heardEp:) 0)
								)
								(self setScript: (ScriptID 232 2)) ; storyWrap
								(global144 heardEp: 1)
							)
						)
					)
					((OneOf (global224 talkerID:) 6 7 9 8)
						(self setScript: (ScriptID 233 5)) ; enterBremenFol
					)
					((OneOf (global224 talkerID:) 16 15)
						(self setScript: (ScriptID 233 6)) ; enterSnowFol
					)
				)
				(wyrmHead cel: 0)
			)
			(2 0)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) 33 24)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(sfx number: 122 setVol: (- 127 (/ temp0 3)))
		(cond
			((gCurRoom script:) 0)
			((== (gEgo onControl: 1) 2)
				(gCurRoom setScript: (ScriptID 231 0)) ; exitNorth
			)
			((== global140 1)
				(= local0 (GetTime 1)) ; SysTime12
				(if (!= local1 local0)
					(= local0 local1)
					(if (not (-- local2))
						(wyrmHands setCycle: End)
						(= local2 (Random 60 90))
					)
				)
			)
		)
		(cond
			((gCurRoom script:) 0)
			((not (gCast contains: global224)) 0)
			((> (gEgo x:) 180)
				(if (!= local7 1)
					(global224 setMotion: PolyPath 230 151)
					(= local7 1)
				)
			)
			((< (gEgo y:) 116)
				(if (and (not (gEgo has: 7)) (!= local7 2))
					(global224 setMotion: PolyPath 155 98)
					(= local7 2)
				)
			)
			((and (>= (gEgo y:) 116) (<= (gEgo x:) 180) (!= local7 3))
				(global224 setMotion: PolyPath 109 148)
				(= local7 3)
			)
		)
	)

	(method (dispose)
		(if local3
			(gEgo doCode: local3)
			(global224 doCode: local4)
		else
			(gEgo doCode: 0)
		)
		(cond
			((== gNewRoomNum 235)
				(if (gGlobalMusic2 handle:)
					(gGlobalMusic2 fade: 0 15 12 1)
					(= global225 38)
				)
			)
			((gGlobalMusic handle:)
				(gGlobalMusic fade: 0 15 12 1)
				(= global225 6)
			)
		)
		(super dispose: &rest)
		(LoadMany 0 231 232 233)
	)
)

(instance birdSound of Sound
	(properties
		flags 1
		number 154
	)
)

(instance birdFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 230 0 #time 4 #at -1 160 #dispose) ; "You see the bird."
				(birdSound play:)
				(birdie
					setCycle: End
					loop: 2
					cel: 0
					posn: 283 57
					setPri: 12
					init:
				)
				(= ticks 12)
			)
			(1
				(birdie
					setLoop: 3
					setCycle: Fwd
					setStep: 6 2
					setMotion: MoveTo 0 57 self
				)
			)
			(2
				(birdie dispose:)
				(self dispose:)
			)
		)
	)
)

(instance wyrmBegGame of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (bookWyrm selection:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 1)
					)
					(1
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 1 230 2)
					)
					(2
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 1 230 3)
					)
					(else
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 1 230 4)
					)
				)
			)
		)
		(bookWyrm incSel:)
	)
)

(instance egoDo230 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 0 230 5)
						(proc10_13 0 gEgo bookWyrm -1 1 230 6)
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 7)
						(proc10_13 0 bookWyrm gEgo -1 1 230 8)
					)
					(1
						(proc10_13 0 gEgo bookWyrm -1 1 230 9)
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 10)
						(proc10_13 0 bookWyrm gEgo -1 0 230 11)
						(proc10_13 0 bookWyrm gEgo -1 1 230 12)
						(proc10_13 0 gEgo bookWyrm -1 1 230 13)
						(proc10_13 0 bookWyrm gEgo -1 0 230 14)
						(proc10_13 0 bookWyrm gEgo -1 1 230 15)
					)
					(2
						(proc10_13 2 gEgo bookWyrm -1 1 230 16)
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 17)
						(proc10_13 0 bookWyrm gEgo -1 1 230 18)
					)
					(else
						(proc10_13 0 gEgo bookWyrm -1 1 230 19)
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 20)
						(proc10_13 0 bookWyrm gEgo -1 1 230 21)
					)
				)
			)
		)
		(gEgo incSel:)
	)
)

(instance egoDoSpecial of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch local6
					(1
						(proc10_13 2 gEgo bookWyrm -1 1 230 22)
						(proc10_13 0 bookWyrm gEgo -1 0 230 23)
						(proc10_13 0 bookWyrm gEgo -1 1 230 24)
					)
					(2
						(proc10_13 2 gEgo bookWyrm -1 1 230 25)
						(proc10_13 0 bookWyrm gEgo -1 0 230 26)
						(proc10_13 0 bookWyrm gEgo -1 1 230 27)
					)
					(3
						(proc10_13 2 gEgo bookWyrm -1 1 230 28)
						(proc10_13 0 bookWyrm gEgo -1 1 230 29)
					)
				)
			)
		)
	)
)

(instance wyrmDoSpecial of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch local6
					(1
						(proc10_13 0 bookWyrm gEgo -1 1 230 30)
					)
					(2
						(proc10_13 0 bookWyrm gEgo -1 1 230 31)
					)
					(3
						(proc10_13 2 bookWyrm gEgo -1 0 230 32)
						(proc10_13 2 bookWyrm gEgo -1 1 230 33)
					)
				)
			)
		)
	)
)

(instance doFollower of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch local5
					(gBremenStory
						(switch (global224 talkerID:)
							(6
								(proc10_13 0 global224 gEgo -1 1 230 34)
								(proc10_13 0 bookWyrm global224 -1 1 230 35)
							)
							(7
								(proc10_13
									0
									global224
									bookWyrm
									-1
									1
									(Format @temp0 230 36 @global110) ; "I am so glad %s came here. I needed help."
								)
								(proc10_13
									0
									bookWyrm
									global224
									-1
									0
									(Format @temp0 230 37 @global110) ; "Many needed %s to help them."
								)
								(proc10_13
									0
									bookWyrm
									gEgo
									-1
									1
									(Format @temp0 230 38 @global110) ; "We can't thank you too much, %s."
								)
							)
							(9
								(proc10_13 0 global224 bookWyrm -1 1 230 39)
								(proc10_13
									0
									bookWyrm
									global224
									-1
									1
									(Format @temp0 230 40 @global110) ; "%s knows the way. It's just to the north."
								)
								(proc10_13 0 global224 bookWyrm -1 1 230 41)
								(proc10_13 0 bookWyrm global224 -1 1 230 42)
							)
						)
					)
					(gSnowStory
						(switch (global224 talkerID:)
							(15
								(proc10_13 0 global224 bookWyrm -1 0 230 43)
								(proc10_13 0 global224 bookWyrm -1 1 230 44)
								(proc10_13
									0
									bookWyrm
									global224
									-1
									1
									(Format @temp0 230 45 @global110) ; "I know %s will find the house for you."
								)
							)
							(16
								(proc10_13
									0
									global224
									gEgo
									-1
									0
									(Format @temp0 230 46 @global110) ; "Well, then, let's be off, %s."
								)
								(proc10_13 0 global224 gEgo -1 0 230 47)
								(proc10_13 0 global224 gEgo -1 0 230 48)
								(proc10_13 0 global224 gEgo -1 1 230 49)
							)
						)
					)
				)
			)
		)
	)
)

(instance egoDoNoStory of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 50)
						(proc10_13
							0
							bookWyrm
							gEgo
							-1
							1
							(Format @temp0 230 51 @global110) ; "Thanks, %s. I'm glad you like it."
						)
					)
					(1
						(proc10_13 3 gEgo bookWyrm -1 1 230 52)
						(proc10_13 0 bookWyrm gEgo -1 0 230 53)
						(proc10_13 0 bookWyrm gEgo -1 1 230 54)
					)
					(2
						(proc10_13 2 gEgo bookWyrm -1 1 230 55)
						(proc10_13 0 bookWyrm gEgo -1 0 230 56)
						(proc10_13 0 bookWyrm gEgo -1 0 230 57)
						(proc10_13 0 bookWyrm gEgo -1 0 230 58)
						(proc10_13 0 bookWyrm gEgo -1 1 230 59)
					)
					(3
						(proc10_13 0 gEgo bookWyrm -1 1 230 60)
						(proc10_13 0 bookWyrm gEgo -1 0 230 61)
						(proc10_13 0 bookWyrm gEgo -1 1 230 62)
						(gEgo selection: -1)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance egoDoCind of Code
	(properties)

	(method (doit param1 &tmp [temp0 10] [temp10 200])
		(switch param1
			(5
				(switch (gCindStory state:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 63)
						(proc10_13 0 bookWyrm gEgo -1 1 230 64)
					)
					(1
						(if (gEgo has: 0)
							(proc10_13 0 gEgo bookWyrm -1 1 230 65)
							(proc10_13 0 bookWyrm gEgo -1 1 230 66)
						else
							(proc10_13 0 gEgo bookWyrm -1 1 230 67)
							(localproc_0 (gInventory at: 0) @temp0)
							(proc10_13
								2
								bookWyrm
								gEgo
								-1
								1
								(Format @temp10 230 68 @temp0) ; "Try looking to the %s of my house for the pumpkin."
							)
						)
					)
					(2
						(proc10_13 2 gEgo bookWyrm -1 1 230 69)
						(proc10_13 0 bookWyrm gEgo -1 0 230 70)
						(proc10_13 0 bookWyrm gEgo -1 1 230 71)
					)
					(3
						(if (gEgo has: 1)
							(proc10_13 2 gEgo bookWyrm -1 1 230 72)
							(proc10_13 0 bookWyrm gEgo -1 1 230 73)
						else
							(proc10_13 0 gEgo bookWyrm -1 1 230 74)
							(localproc_0 (gInventory at: 1) @temp0)
							(proc10_13
								1
								bookWyrm
								gEgo
								-1
								1
								(Format @temp10 230 75 @temp0) ; "I think Bookend hid the slipper to the %s of here."
							)
						)
					)
					(else
						(proc10_13 2 gEgo bookWyrm -1 1 230 76)
						(proc10_13 0 bookWyrm gEgo -1 1 230 77)
						(proc10_13 3 gEgo bookWyrm -1 1 230 78)
						(proc10_13 0 bookWyrm gEgo -1 1 230 79)
					)
				)
			)
		)
	)
)

(instance egoDoJack of Code
	(properties)

	(method (doit param1 &tmp [temp0 10] [temp10 200])
		(switch param1
			(5
				(switch (gJackStory state:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 80)
						(proc10_13 0 bookWyrm gEgo -1 1 230 81)
					)
					(1
						(if (gEgo has: 2)
							(proc10_13 0 gEgo bookWyrm -1 1 230 82)
							(proc10_13 0 bookWyrm gEgo -1 0 230 83)
							(proc10_13 0 bookWyrm gEgo -1 1 230 84)
						else
							(proc10_13 3 gEgo bookWyrm -1 1 230 85)
							(localproc_0 (gInventory at: 2) @temp0)
							(proc10_13
								0
								bookWyrm
								gEgo
								-1
								1
								(Format @temp10 230 86 @temp0) ; "Look for the Bag of Magic Beans to the %s of my house."
							)
						)
					)
					(2
						(proc10_13 0 gEgo bookWyrm -1 1 230 87)
						(proc10_13 0 bookWyrm gEgo -1 1 230 88)
					)
					(3
						(if (not (gEgo has: 3))
							(proc10_13 0 gEgo bookWyrm -1 1 230 89)
							(localproc_0 (gInventory at: 3) @temp0)
							(proc10_13
								0
								bookWyrm
								gEgo
								-1
								1
								(Format @temp10 230 90 @temp0) ; "Why don't you look to the %s of here?"
							)
						else
							(proc10_13 0 gEgo bookWyrm -1 1 230 82)
							(proc10_13 0 bookWyrm gEgo -1 0 230 83)
							(proc10_13 0 bookWyrm gEgo -1 1 230 84)
						)
					)
					(else
						(proc10_13 3 gEgo bookWyrm -1 1 230 91)
						(proc10_13 0 bookWyrm gEgo -1 0 230 92)
						(proc10_13 0 bookWyrm gEgo -1 1 230 93)
					)
				)
			)
		)
	)
)

(instance egoDoBremen of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch (gBremenStory state:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 94)
						(proc10_13 0 bookWyrm gEgo -1 1 230 95)
					)
					(1
						(proc10_13 2 gEgo bookWyrm -1 1 230 96)
						(proc10_13 0 bookWyrm gEgo -1 1 230 97)
						(proc10_13 0 global224 global224 -1 1 230 98)
						(proc10_13 0 bookWyrm global224 -1 1 230 99)
					)
					(2
						(proc10_13 2 gEgo bookWyrm -1 1 230 100)
						(proc10_13 0 bookWyrm gEgo -1 1 230 101)
					)
					(3
						(proc10_13 0 gEgo global224 -1 1 230 102)
						(proc10_13 0 global224 bookWyrm -1 1 230 103)
						(proc10_13 0 bookWyrm global224 -1 1 230 104)
					)
					(4
						(proc10_13 2 gEgo bookWyrm -1 1 230 105)
						(proc10_13 0 bookWyrm gEgo -1 1 230 106)
					)
					(6
						(proc10_13 2 gEgo bookWyrm -1 1 230 107)
						(proc10_13 0 bookWyrm gEgo -1 1 230 108)
					)
					(7
						(proc10_13 0 gEgo global224 -1 1 230 109)
						(proc10_13 0 global224 gEgo -1 1 230 110)
						(proc10_13 0 gEgo global224 -1 1 230 111)
						(proc10_13 0 bookWyrm gEgo -1 1 230 112)
						(proc10_13
							0
							global224
							gEgo
							-1
							1
							(Format @temp0 230 113 @global110) ; "Come on, %s. We can still have fun together on the way to Bremen Town."
						)
					)
					(else
						(proc10_13 0 gEgo bookWyrm -1 1 230 114)
						(proc10_13 0 bookWyrm gEgo -1 0 230 115)
						(proc10_13 0 bookWyrm gEgo -1 1 230 116)
					)
				)
			)
		)
	)
)

(instance egoDoBeauty of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBeautyStory state:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 117)
						(proc10_13 0 bookWyrm gEgo -1 1 230 118)
					)
					(1
						(proc10_13 0 gEgo bookWyrm -1 1 230 119)
						(proc10_13 0 bookWyrm gEgo -1 0 230 120)
						(proc10_13 0 bookWyrm gEgo -1 1 230 121)
					)
					(3
						(proc10_13 0 gEgo bookWyrm -1 1 230 122)
						(proc10_13 0 bookWyrm gEgo -1 0 230 123)
						(proc10_13 0 bookWyrm gEgo -1 1 230 124)
					)
					(else
						(proc10_13 2 gEgo bookWyrm -1 1 230 125)
						(proc10_13 0 bookWyrm gEgo -1 0 230 126)
						(proc10_13 0 bookWyrm gEgo -1 0 230 127)
						(proc10_13 0 bookWyrm gEgo -1 1 230 128)
					)
				)
			)
		)
	)
)

(instance egoDoSnow of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch (gSnowStory state:)
					(0
						(proc10_13 0 gEgo bookWyrm -1 1 230 129)
						(proc10_13 0 bookWyrm gEgo -1 1 230 130)
					)
					(1
						(proc10_13 0 gEgo bookWyrm -1 1 230 131)
						(proc10_13 0 bookWyrm gEgo -1 1 230 132)
						(proc10_13 0 global224 bookWyrm -1 1 230 133)
						(proc10_13
							0
							bookWyrm
							global224
							-1
							1
							(Format @temp0 230 134 @global110) ; "Good-bye, Snow White! See you soon, %s."
						)
					)
					(2
						(proc10_13 3 gEgo bookWyrm -1 1 230 135)
						(proc10_13 1 bookWyrm gEgo -1 0 230 136)
						(proc10_13 3 bookWyrm gEgo -1 1 230 137)
					)
					(3
						(if global224
							(proc10_13 0 gEgo bookWyrm -1 1 230 138)
							(proc10_13 0 bookWyrm gEgo -1 1 230 139)
							(proc10_13 3 global224 bookWyrm -1 1 230 140)
							(proc10_13
								0
								bookWyrm
								global224
								-1
								1
								(Format @temp0 230 141 @global110) ; "Just follow %s. He can show you."
							)
							(proc10_13 3 global224 bookWyrm -1 1 230 142)
						else
							(proc10_13 3 gEgo bookWyrm -1 1 230 143)
							(proc10_13 1 bookWyrm gEgo -1 0 230 144)
							(proc10_13 3 bookWyrm gEgo -1 1 230 145)
						)
					)
					(else
						(proc10_13 0 gEgo bookWyrm -1 1 230 146)
						(proc10_13 0 bookWyrm gEgo -1 0 230 147)
						(proc10_13 0 bookWyrm gEgo -1 1 230 148)
					)
				)
			)
		)
	)
)

(instance wyrmDoSnow of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch (gSnowStory state:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 149)
					)
					(1
						(proc10_13 0 bookWyrm gEgo -1 1 230 150)
						(proc10_13
							0
							bookWyrm
							global224
							-1
							0
							(Format @temp0 230 151 @global110) ; "%s will help you."
						)
						(proc10_13 0 bookWyrm gEgo -1 0 230 152)
						(proc10_13 0 bookWyrm gEgo -1 1 230 153)
						(proc10_13
							0
							global224
							gEgo
							-1
							1
							(Format @temp0 230 154 @global110) ; "I'm so glad I'm with you, %s."
						)
					)
					(2
						(proc10_13 3 bookWyrm gEgo -1 0 230 155)
						(proc10_13 3 bookWyrm gEgo -1 1 230 156)
					)
					(3
						(if global224
							(proc10_13 0 bookWyrm global224 -1 1 230 157)
							(proc10_13 0 global224 bookWyrm -1 0 230 158)
							(proc10_13 0 global224 bookWyrm -1 0 230 159)
							(proc10_13 3 global224 bookWyrm -1 0 230 160)
							(proc10_13 0 global224 bookWyrm -1 1 230 161)
							(proc10_13 0 bookWyrm global224 -1 1 230 162)
						else
							(proc10_13 3 bookWyrm gEgo -1 0 230 163)
							(proc10_13 3 bookWyrm gEgo -1 1 230 164)
						)
					)
				)
			)
		)
	)
)

(instance wyrmDoCind of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gCindStory state:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 165)
					)
					(1
						(if (gEgo has: 0)
							(proc10_13 0 bookWyrm gEgo -1 1 230 166)
						else
							(proc10_13 0 bookWyrm gEgo -1 1 230 167)
						)
					)
					(3
						(if (not (gEgo has: 1))
							(proc10_13 0 bookWyrm gEgo -1 1 230 168)
						else
							(proc10_13 0 bookWyrm gEgo -1 1 230 169)
						)
					)
					(else
						(proc10_13 0 bookWyrm gEgo -1 1 230 170)
					)
				)
			)
		)
	)
)

(instance wyrmDoBeauty of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBeautyStory state:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 171)
					)
					(1
						(proc10_13 3 bookWyrm gEgo -1 1 230 172)
					)
					(3
						(proc10_13 3 bookWyrm gEgo -1 1 230 173)
					)
					(else
						(proc10_13 0 bookWyrm gEgo -1 0 230 174)
						(proc10_13 0 bookWyrm gEgo -1 1 230 175)
					)
				)
			)
		)
	)
)

(instance wyrmDoBremen of Code
	(properties)

	(method (doit param1 &tmp [temp0 200])
		(switch param1
			(5
				(switch (gBremenStory state:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 176)
					)
					(1
						(proc10_13 3 bookWyrm global224 -1 1 230 177)
						(proc10_13 3 global224 bookWyrm -1 1 230 178)
						(proc10_13 1 bookWyrm gEgo -1 0 230 179)
						(proc10_13 1 bookWyrm gEgo -1 1 230 180)
					)
					(2
						(proc10_13 3 bookWyrm gEgo -1 1 230 181)
					)
					(3
						(proc10_13 0 bookWyrm gEgo -1 1 230 182)
						(proc10_13
							0
							global224
							gEgo
							-1
							1
							(Format @temp0 230 183 @global110) ; "Thanks, Bookwyrm. Shall we go, %s?"
						)
					)
					(4
						(proc10_13 0 bookWyrm gEgo -1 1 230 184)
					)
					(6
						(proc10_13 3 bookWyrm gEgo -1 1 230 185)
					)
					(7
						(proc10_13 0 bookWyrm global224 -1 1 230 186)
						(proc10_13 0 global224 bookWyrm -1 1 230 187)
						(proc10_13 0 bookWyrm global224 -1 1 230 188)
					)
					(else
						(proc10_13 0 bookWyrm gEgo -1 1 230 189)
						(proc10_13 0 gEgo bookWyrm -1 1 230 190)
					)
				)
			)
		)
	)
)

(instance wyrmDoJack of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gJackStory state:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 191)
					)
					(1
						(if (gEgo has: 2)
							(proc10_13 0 bookWyrm gEgo -1 1 230 192)
						else
							(proc10_13 0 bookWyrm gEgo -1 0 230 193)
							(proc10_13 0 bookWyrm gEgo -1 1 230 194)
						)
					)
					(3
						(proc10_13 1 bookWyrm gEgo -1 0 230 195)
						(proc10_13 1 bookWyrm gEgo -1 0 230 196)
						(proc10_13 1 bookWyrm gEgo -1 1 230 197)
					)
					(else
						(proc10_13 0 bookWyrm gEgo -1 1 230 198)
					)
				)
			)
		)
	)
)

(instance wyrmDoNoStory of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 0 bookWyrm gEgo -1 1 230 199)
					)
					(1
						(proc10_13 0 bookWyrm gEgo -1 1 230 200)
					)
					(2
						(proc10_13 2 bookWyrm gEgo -1 0 230 201)
						(proc10_13 2 bookWyrm gEgo -1 1 230 202)
					)
					(3
						(proc10_13 0 bookWyrm gEgo -1 0 230 203)
						(proc10_13 0 bookWyrm gEgo -1 1 230 204)
						(bookWyrm selection: -1)
					)
				)
				(bookWyrm incSel:)
			)
		)
	)
)

(instance bookWyrm of Tactor
	(properties
		description {Bookwyrm}
		lookStr {Bookwyrm grins and winks at you.}
		talkerID 18
	)

	(method (setUp)
		((= talkerObj bookWyrmTalkObj)
			setUp: bookWyrmBust bookWyrmEyes bookWyrmMouth
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(if (IsObject doCode)
					(doCode doit: theVerb)
				else
					(Print 230 205) ; "Bookwyrm is at a loss for words right now."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bookWyrmTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 103
		view 751
	)
)

(instance bookWyrmBust of View
	(properties
		nsTop 36
		nsLeft 46
		view 751
		loop 6
	)
)

(instance bookWyrmEyes of Prop
	(properties
		nsTop 19
		nsLeft 49
		view 751
		loop 4
		cycleSpeed 36
	)
)

(instance bookWyrmMouth of Prop
	(properties
		nsTop 36
		nsLeft 46
		view 751
		loop 2
		cycleSpeed 12
	)
)

(instance wyrmHead of Prop
	(properties
		x 54
		y 65
		view 752
		loop 1
	)

	(method (doVerb theVerb)
		(bookWyrm doVerb: theVerb)
	)
)

(instance wyrmHands of Prop
	(properties
		x 55
		y 60
		view 752
		loop 2
	)

	(method (doVerb theVerb)
		(bookWyrm doVerb: theVerb)
	)
)

(instance door of Prop
	(properties
		x 129
		y 84
		description {Door}
		lookStr {This is the door to Bookwyrm's house.}
		view 230
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((door script:) 0)
					((== (bookWyrm view:) 230) 0)
					((proc10_17 InvFriend)
						(proc10_13 0 global224 gEgo -1 1 230 206)
					)
					(else
						(door setScript: (ScriptID 232 4)) ; openDoor
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdHouse of View
	(properties
		x 283
		y 57
		description {Birdhouse}
		lookStr {The birdhouse is a home for a bird.}
		view 230
		loop 4
		priority 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (birdie script:))
					(birdie setScript: birdFly)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdie of Actor
	(properties
		description {Bird}
		lookStr {The bird has a nest in the birdhouse.}
		view 230
		signal 24576
	)
)

(instance falls of Prop
	(properties
		x 33
		y 24
		description {Waterfall}
		lookStr {The waterfall flows down to the stream.}
		view 230
		loop 1
	)
)

(instance house of Feature
	(properties
		x 167
		y 64
		description {House}
		sightAngle 90
		onMeCheck 4
		lookStr {Bookwyrm's house has flowers growing on it.}
	)
)

(instance window1 of Feature
	(properties
		x 184
		y 85
		description {Window}
		sightAngle 90
		onMeCheck 8
		lookStr {The windows let you see into the house.}
	)
)

(instance stone of Feature
	(properties
		x 184
		y 140
		description {Stones}
		sightAngle 90
		onMeCheck 16
		lookStr {The stones make a path to the house.}
	)
)

(instance rock of Feature
	(properties
		x 59
		y 160
		description {Rock}
		sightAngle 90
		onMeCheck 32
		lookStr {The rock is dark gray.}
	)
)

(instance road of Feature
	(properties
		x 74
		y 73
		description {Road}
		sightAngle 90
		onMeCheck 64
		lookStr {The road leads north to the crossroads.}
	)
)

(instance fence of Feature
	(properties
		x 71
		y 126
		description {Fence}
		sightAngle 90
		onMeCheck 128
		lookStr {The fence keeps you from falling.}
	)
)

(instance stream of Feature
	(properties
		x 21
		y 94
		description {Stream}
		sightAngle 90
		onMeCheck 256
		lookStr {The stream flows to the west.}
	)
)

(instance flower1 of Feature
	(properties
		x 72
		y 171
		description {Flowers}
		sightAngle 90
		onMeCheck 1024
		lookStr {These flowers smell like cherry soda.}
	)
)

(instance flower2 of Feature
	(properties
		x 231
		y 142
		description {Flowers}
		sightAngle 90
		onMeCheck 2048
		lookStr {These flowers smell like orange soda.}
	)
)

(instance flower3 of Feature
	(properties
		x 233
		y 122
		description {Flowers}
		sightAngle 90
		onMeCheck 4096
		lookStr {These flowers have no smell.}
	)
)

(instance mountain of Feature
	(properties
		x 92
		y 46
		description {Mountain}
		sightAngle 90
		onMeCheck 8192
		lookStr {The mountain looks pretty.}
	)
)

(instance cloud of Feature
	(properties
		x 75
		y 35
		description {Clouds}
		sightAngle 90
		onMeCheck -32768
		lookStr {The clouds are far above.}
	)
)

(instance grass of Feature
	(properties
		x 143
		y 160
		description {Grass}
		sightAngle 90
		onMeCheck 16384
		lookStr {You can feel the grass under your shoes.}
	)
)

(instance enterSpec of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(switch register
					(1
						(wyrmHead cel: 1)
						(proc10_13
							0
							bookWyrm
							gEgo
							-1
							0
							(Format @temp0 230 207 @global110) ; "Ah, %s, you are doing very well."
						)
						(proc10_13 0 bookWyrm gEgo self 1 230 208)
					)
					(2
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 209)
						(proc10_13 0 bookWyrm gEgo self 1 230 210)
					)
					(3
						(wyrmHead cel: 1)
						(proc10_13 0 bookWyrm gEgo -1 0 230 211)
						(proc10_13 0 bookWyrm gEgo self 1 230 212)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 122
		loop -1
	)
)

