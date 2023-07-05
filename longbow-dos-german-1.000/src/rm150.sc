;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	[local0 3]
	[local3 3] = [27 54 78]
	[local6 3] = [82 79 72]
	[local9 3] = [0 0 2]
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	[local57 4] = [1150 13 1 0]
	[local61 4] = [1150 24 1 0]
	[local65 4] = [1150 25 1 0]
	[local69 4] = [1150 26 1 0]
	[local73 4] = [1150 27 1 0]
	[local77 4] = [1150 30 1 0]
	[local81 6] = [1150 31 2 1 2 0]
	[local87 4] = [1150 34 1 0]
	[local91 5] = [1150 16 1 2 0]
	[local96 5] = [1150 18 1 2 0]
	[local101 4] = [1150 20 1 0]
	[local105 4] = [1150 21 1 0]
	[local109 5] = [1150 22 1 2 0]
	[local114 5] = [1150 39 2 1 0]
	[local119 5] = [1150 41 2 1 0]
	[local124 5] = [1150 28 1 1 0]
	[local129 5] = [1150 49 1 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		((= [local0 temp0] (wave new:))
			x: [local3 temp0]
			y: [local6 temp0]
			cel: [local9 temp0]
			init:
		)
	)
)

(procedure (localproc_1)
	(switch gDay
		(1
			(= local44 1)
			(cond
				((not (IsFlag 71))
					(SetFlag 71)
					(= local49 1)
					(= local12 (ScriptID 151 0)) ; dayOne
					(= local13 (ScriptID 23)) ; Tuck
					(= local16 168)
					(= local17 3)
					(= local18 Fwd)
					(= local14 147)
					(= local15 103)
					(= local19 (ScriptID 19)) ; John
					(= local20 71)
					(= local21 136)
					(= local25 (ScriptID 20)) ; Will
					(= local26 265)
					(= local27 96)
					(= local31 (ScriptID 21)) ; Alan
					(= local34 170)
					(gRgnMusic2 number: 154 loop: -1)
					(= local35 1)
					(= local36 Fwd)
					(= local32 226)
					(= local33 103)
					((ScriptID 23) actions: tucksActions detailLevel: 2) ; Tuck
					((ScriptID 19) actions: johnsActions) ; John
					((ScriptID 20) actions: willsActions) ; Will
					((ScriptID 21) actions: alansActions detailLevel: 2) ; Alan
				)
				((and (not (IsFlag 163)) (not (IsFlag 44)))
					(SetFlag 163)
					(= local43 1)
					(= local12 tuckAlone)
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 207)
					(= local15 88)
					(= local16 168)
					(= local17 0)
					(= local18 End)
					((ScriptID 23) actions: tucksActions) ; Tuck
				)
			)
		)
		(2
			(if (not (IsFlag 71))
				150
				(SetFlag 71)
				(SetFlag 21)
				(= local12 (ScriptID 151 1)) ; dayTwo
				(= local13 (ScriptID 23)) ; Tuck
				(= local14 210)
				(= local15 129)
				(= local19 (ScriptID 19)) ; John
				(= local20 232)
				(= local21 111)
				(= local25 (ScriptID 21)) ; Alan
				(= local29 3)
				(= local26 148)
				(= local27 167)
				(= local31 (ScriptID 20)) ; Will
				(= local32 -15)
				(= local33 131)
				((ScriptID 23) actions: tucksActions) ; Tuck
				((ScriptID 19) actions: johnsActions) ; John
				((ScriptID 21) actions: alansActions) ; Alan
				((ScriptID 20) actions: willsActions) ; Will
			)
		)
		(3
			(if (and (IsFlag 49) (not (IsFlag 54)))
				(SetFlag 54)
				(SetFlag 151)
				(= local12 (ScriptID 151 2)) ; dayThree
				(= local13 (ScriptID 19)) ; John
				(= local17 2)
				(= local14 218)
				(= local15 77)
				((ScriptID 19) actions: johnsActions) ; John
			)
		)
		(4
			(if (not (IsFlag 71))
				(SetFlag 71)
				(= local12 (ScriptID 151 3)) ; dayFour
				(= local13 (ScriptID 20)) ; Will
				(= local14 78)
				(= local15 185)
				(= local17 3)
				((ScriptID 20) actions: willsActions) ; Will
			)
		)
		(5
			(cond
				((not (IsFlag 71))
					(SetFlag 71)
					(= local12 (ScriptID 151 4)) ; dayFive
					(= local13 (ScriptID 21)) ; Alan
					(= local14 230)
					(= local15 111)
					(= local17 2)
					((ScriptID 21) actions: alansActions) ; Alan
				)
				((and (IsFlag 169) (not (IsFlag 55)))
					(SetFlag 55)
					(SetFlag 25)
					(= gBlowCount 0)
					(= local12 (ScriptID 151 5)) ; noRobeAbbeyMonkMet
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 88)
					(= local15 177)
					((ScriptID 23) actions: tucksActions) ; Tuck
				)
				((and (IsFlag 39) (not (IsFlag 147)) (not (IsFlag 25)))
					(SetFlag 147)
					(= local12 (ScriptID 151 6)) ; noRobeFensMonkMet
					(= local13 (ScriptID 19)) ; John
					(= local17 2)
					(= local14 266)
					(= local15 97)
					((ScriptID 19) actions: johnsActions) ; John
				)
				(
					(and
						(== gDisguiseNum 5) ; abbey monk
						(not (IsFlag 56))
						(not (IsFlag 161))
						(== global142 2)
					)
					(SetFlag 161)
					(= local12 (ScriptID 151 7)) ; secondNoRescue
					(= local13 (ScriptID 20)) ; Will
					(= local14 141)
					(= local15 98)
					(= local18 Walk)
					((ScriptID 20) actions: willsActions) ; Will
				)
				((and (== gDisguiseNum 5) (not (IsFlag 56)) (== global142 3)) ; abbey monk
					(SetFlag 56)
					(= local43 1)
					(= local12 (ScriptID 151 8)) ; thirdNoRescue
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 204)
					(= local15 88)
					(= local16 168)
					(= local17 0)
					(= local18 End)
					((ScriptID 23) actions: tucksActions) ; Tuck
				)
			)
		)
		(6
			(ClearFlag 19)
			(cond
				((and (not (IsFlag 71)) (IsFlag 25))
					(SetFlag 71)
					(= local12 (ScriptID 151 9)) ; day6B
					(= local53 1)
					(= local13 (ScriptID 19)) ; John
					(= local16 167)
					(= local17 1)
					(= local18 End)
					(= local14 201)
					(= local15 71)
					(= local19 (ScriptID 21)) ; Alan
					(= local22 147)
					(= local23 4)
					(= local24 Fwd)
					(= local20 242)
					(= local21 108)
					(gRgnMusic2 number: 154 loop: -1)
					((ScriptID 19) detailLevel: 2 actions: johnsActions) ; John
					((ScriptID 21) detailLevel: 1 actions: alansActions) ; Alan
				)
				((not (IsFlag 71))
					(SetFlag 71)
					(= local12 (ScriptID 151 10)) ; day6A
					(= local13 (ScriptID 22)) ; Much
					(= local14 71)
					(= local15 136)
					((ScriptID 22) actions: muchsActions) ; Much
				)
				((and (IsFlag 169) (not (IsFlag 25)) (not (IsFlag 55)))
					(SetFlag 55)
					(= local12 (ScriptID 151 5)) ; noRobeAbbeyMonkMet
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 88)
					(= local15 177)
					((ScriptID 23) actions: tucksActions) ; Tuck
				)
				((and (IsFlag 39) (not (IsFlag 147)))
					(SetFlag 147)
					(= local12 (ScriptID 151 6)) ; noRobeFensMonkMet
					(= local13 (ScriptID 19)) ; John
					(= local17 2)
					(= local14 266)
					(= local15 97)
					((ScriptID 19) actions: johnsActions) ; John
				)
				(
					(and
						(== gDisguiseNum 5) ; abbey monk
						(== global142 2)
						(not (IsFlag 56))
						(not (IsFlag 161))
					)
					(SetFlag 161)
					(= local12 (ScriptID 151 7)) ; secondNoRescue
					(= local13 (ScriptID 20)) ; Will
					(= local18 Walk)
					(= local14 141)
					(= local15 98)
					((ScriptID 20) actions: willsActions) ; Will
				)
				((and (== gDisguiseNum 5) (== global142 3) (not (IsFlag 56))) ; abbey monk
					(SetFlag 56)
					(= local12 (ScriptID 151 8)) ; thirdNoRescue
					(= local43 1)
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 204)
					(= local15 88)
					(= local16 168)
					(= local17 0)
					(= local18 End)
					((ScriptID 23) actions: tucksActions) ; Tuck
				)
			)
		)
		(7
			(if (and (IsFlag 34) (not (gEgo has: 4)) (not (IsFlag 71))) ; net
				(SetFlag 71)
				(= local12 (ScriptID 151 11)) ; day7
				(= local13 (ScriptID 23)) ; Tuck
				(= local17 1)
				(= local14 71)
				(= local15 136)
				(SetFlag 19)
				((ScriptID 23) actions: tucksActions) ; Tuck
			)
		)
		(8
			(cond
				((not (IsFlag 71))
					(SetFlag 71)
					(= local12 (ScriptID 151 12)) ; day8
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 104)
					(= local15 147)
					(= local17 2)
					(= local19 (ScriptID 19)) ; John
					(= local53 1)
					(= local20 55)
					(= local21 186)
					(= local23 0)
					(= local31 (ScriptID 21)) ; Alan
					(= local32 100)
					(= local33 189)
					(= local35 1)
					(= local25 (ScriptID 22)) ; Much
					(= local26 76)
					(= local27 172)
					(= local29 2)
					((ScriptID 19) actions: johnsActions) ; John
					((ScriptID 21) actions: alansActions) ; Alan
					((ScriptID 23) actions: tucksActions) ; Tuck
					((ScriptID 22) actions: muchsActions) ; Much
				)
				((and (IsFlag 135) (IsFlag 191) (not (IsFlag 57)))
					(SetFlag 57)
					(= local12 (ScriptID 151 13)) ; day8Puck
					(= local13 (ScriptID 19)) ; John
					(= local14 192)
					(= local15 151)
				)
			)
		)
		(9
			(cond
				((not (IsFlag 71))
					(SetFlag 71)
					(= local12 (ScriptID 151 14)) ; day9Will
					(= local43 1)
					(= local13 (ScriptID 20)) ; Will
					(= local17 0)
					(= local18 Walk)
					(= local14 192)
					(= local15 151)
				)
				((IsFlag 102)
					(= gDisguiseNum 0) ; outlaw
					(= local12 (ScriptID 153 0)) ; day9
					(= local13 (ScriptID 23)) ; Tuck
					(= local14 205)
					(= local15 82)
					(= local17 2)
					(= local16 168)
					(= local18 End)
					(= local19 (ScriptID 19)) ; John
					(= local53 1)
					(= local23 0)
					(= local20 77)
					(= local21 92)
					(= local25 (ScriptID 20)) ; Will
					(= local26 160)
					(= local27 84)
					(= local31 (ScriptID 21)) ; Alan
					(= local34 170)
					(gRgnMusic2 number: 393 loop: -1)
					(= local34 0)
					(= local54 1)
					(= local32 38)
					(= local33 170)
					(= local37 (ScriptID 22)) ; Much
					(= local38 148)
					(= local39 167)
					((ScriptID 23) actions: tucksActions) ; Tuck
					((ScriptID 21) actions: alansActions) ; Alan
					((ScriptID 20) actions: willsActions) ; Will
					((ScriptID 19) actions: johnsActions) ; John
					((ScriptID 22) actions: muchsActions) ; Much
				)
			)
		)
		(10
			(if (not (IsFlag 71))
				(SetFlag 71)
				(= local12 (ScriptID 151 15)) ; day10
				(= local13 (ScriptID 19)) ; John
				(= local14 191)
				(= local15 85)
				((ScriptID 19) actions: johnsActions) ; John
			)
		)
		(11
			(if (not (IsFlag 71))
				(SetFlag 71)
				(= local12 (ScriptID 151 16)) ; day11
				(= local13 (ScriptID 23)) ; Tuck
				(= local14 310)
				(= local15 90)
				(= local17 1)
				(= local18 Walk)
				((ScriptID 23) actions: tucksActions) ; Tuck
			)
		)
		(12
			(if (not (IsFlag 71))
				(SetFlag 71)
				(= local12 (ScriptID 151 17)) ; day12
				(= local13 (ScriptID 19)) ; John
				(= local43 1)
				(= local17 0)
				(= local14 192)
				(= local15 151)
			)
		)
		(13
			(if (not (IsFlag 71))
				(SetFlag 71)
				(= local12 (ScriptID 151 18)) ; day13
				(= local13 (ScriptID 20)) ; Will
				(= local14 150)
				(= local15 176)
				((ScriptID 20) actions: willsActions) ; Will
			)
		)
	)
)

(instance rm150 of Rm
	(properties
		picture 150
		style 100
		north 220
		east 140
		south 220
		west 220
	)

	(method (init)
		(gRgnMusic2 number: 0)
		(if (and (not (IsFlag 0)) (!= gPrevRoomNum 240) (not (IsFlag 115))) ; robbedOne
			(localproc_0)
		)
		(localproc_1)
		(LoadMany rsVIEW 150 7 157 143)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 155 319 189 213 189 192 189 123 189 130 176 270 179 292 178 249 131 289 124 319 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 204 113 176 117 166 113 144 113 116 105 116 93 120 91 126 85 137 85 162 94 169 96 177 101 179 104 203 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 240 111 229 112 206 108 170 93 164 93 163 89 229 76 265 63 292 77 280 87 252 91 275 98 277 101 247 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 140 128 125 131 103 135 77 143 62 142 54 136 32 138 18 133 17 128 104 103 129 117 144 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 233 140 216 148 207 151 209 165 187 171 175 171 171 169 162 170 132 171 119 174 87 158 96 152 165 119 220 127
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 74 163 45 165 33 172 21 177 9 178 0 184 0 137 23 145 41 145 53 152 70 158
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 71 81 77 90 68 95 33 96 14 92 24 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 56 110 53 115 32 118 12 115 14 110 33 106 48 105
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 101 74 107 60 107 52 103 56 101 80 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 97 319 118 279 121 254 123 231 121 251 110 253 108
					yourself:
				)
		)
		(streamSound play:)
		(if local13
			(if (!= local18 0)
				(local13 setCycle: local18)
			else
				(local13 setCycle: StopWalk (+ (local13 view:) 1))
			)
			(local13 x: local14 y: local15 cel: 0 signal: 16384 init:)
			(if (and (== local53 1) (IsFlag 25) (== gDay 6))
				((ScriptID 19) setPri: 3) ; John
			)
			(cond
				((> local17 0)
					(local13 loop: local17)
				)
				(local43
					(local13 loop: 0)
				)
				(else
					(local13 loop: 2)
				)
			)
			(if (!= local16 0)
				(local13 view: local16)
			)
		)
		(if local19
			(local19 x: local20 y: local21 ignoreActors: 1 init:)
			(cond
				((!= local23 0)
					(local19 loop: local23)
				)
				((== local53 1)
					(local19 loop: 0)
				)
				(else
					(local19 loop: 2)
				)
			)
			(if (!= local22 0)
				(local19 view: local22)
			)
			(cond
				((!= local24 0)
					(local19 setCycle: local24)
				)
				((== local53 1)
					(local19 setCycle: 0)
				)
				(else
					(local19 setCycle: StopWalk (+ (local19 view:) 1))
				)
			)
		)
		(if local25
			(local25 x: local26 y: local27 ignoreActors: 1 init:)
			(cond
				((!= local29 0)
					(local25 loop: local29)
				)
				((== local55 1)
					(local25 loop: 0)
				)
				(else
					(local25 loop: 2)
				)
			)
			(if (!= local28 0)
				(local25 view: local28)
			)
			(if (!= local30 0)
				(local25 setCycle: local30)
			else
				(local25 setCycle: StopWalk (+ (local25 view:) 1))
			)
		)
		(if local31
			(if (!= local36 0)
				(local31 setCycle: local36)
			else
				(local31 setCycle: StopWalk (+ (local31 view:) 1))
			)
			(local31 x: local32 y: local33 ignoreActors: 1 init:)
			(cond
				((!= local35 0)
					(local31 loop: local35)
				)
				((== local54 1)
					(local31 loop: 0)
				)
				(else
					(local31 loop: 2)
				)
			)
			(if (!= local34 0)
				(local31 view: local34)
			)
		)
		(if local37
			(local37 x: local38 y: local39 ignoreActors: 1 init:)
			(if (!= local41 0)
				(local37 loop: local41)
			else
				(local37 loop: 2)
			)
			(if (!= local40 0)
				(local37 view: local40)
			)
			(if (!= local42 0)
				(local37 setCycle: local42)
			else
				(local37 setCycle: StopWalk (+ (local37 view:) 1))
			)
		)
		(if (and (IsFlag 102) (== gDay 9))
			((ScriptID 22) setPri: 15) ; Much
			((ScriptID 19) setPri: 10 signal: 16) ; John
		)
		(if (== local44 1)
			(theFire init:)
			(fireSound play:)
		)
		(if (== local49 1)
			(AddToFeatures food)
		)
		(AddToFeatures
			table1
			table2
			table3
			table4
			rock1
			rock2
			rock3
			rock4
			rock5
			stump1
			stump2
			stump3
			stump4
			stump5
			cave
			stream
			cliffs
			woods
			everyThing
		)
		(if (== gPrevRoomNum 140)
			(= gEgoEdgeHit 4)
		)
		(if (and (IsFlag 102) (== gDay 9))
			(= gDisguiseNum 0) ; outlaw
		)
		(super init:)
		(gEgo actions: bowActions)
		(gRgnMusic number: 905 play:)
		(if (or (== (gRgnMusic2 number:) 154) (== (gRgnMusic2 number:) 393))
			(gRgnMusic2 play:)
		)
		(if (and (IsFlag 102) (== gDay 9))
			(NormalEgo 1 0 1)
			(gEgo posn: 262 119 loop: 2 init: setScript: local12)
		else
			(gEgo setScript: egoEnters 0 gEgoEdgeHit)
		)
	)

	(method (doit &tmp temp0)
		(if (and (> (gGame detailLevel:) 2) (not (IsFlag 115)))
			(Palette palANIMATE 236 253 -1)
		)
		(cond
			((gEgo script:) 0)
			((gEgo edgeHit:)
				(= temp0
					(switch (= gEgoEdgeHit (gEgo edgeHit:))
						(2 east)
						(3 south)
						(4 west)
						(1 north)
					)
				)
				(if (!= gEgoEdgeHit 2)
					(gEgo setScript: walkOutOfHere 0 temp0)
				else
					(gEgo setScript: walkOutOfHere 0 temp0)
				)
			)
			((== (gEgo onControl: 1) 2)
				(gCurRoom horizon: (gEgo y:))
				(gEgo setMotion: 0 setCycle: 0)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(cave onMe: event)
				(== gTheCursor 0)
				(== (event modifiers:) $0000)
				(OneOf (event type:) evMOUSEBUTTON evKEYBOARD evJOYDOWN)
				(!= (event message:) KEY_ESCAPE)
			)
			(event claimed: 1)
			(gEgo setScript: walkInToCave)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gRgnMusic2 fade: 0 20 12 1)
		(super dispose:)
	)
)

(instance bowActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(4 ; Inventory
				(if (== invItem 1) ; horn
					(gCurRoom setScript: (ScriptID 5 0)) ; blowArbitrator
				)
			)
		)
	)
)

(instance tucksActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Talk
					(switch gDay
						(1
							(if (not local52)
								(= local52 1)
								(Converse 2 @local96 2 0 15 3 0) ; "We must hope for a rich Abbot or greedy Baron to come along and replenish our treasury."
								1
							)
						)
						(5
							(if (IsFlag 111)
								(Converse 1 @local101 15 0 0) ; "You must find a way to save those fine boys."
								1
							else
								(Converse 1 @local105 15 0 0) ; "Please go to her at once."
								1
							)
						)
						(11
							(Converse 2 @local109 1 0 15 3 0) ; "Where are the rest of the men?"
							1
						)
					)
				)
			)
		)
	)
)

(instance alansActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Talk
					(switch gDay
						(1
							(Converse 1 @local61 16 0 0) ; "Pardon me, I'm just working on a song in honour of Tuck's fine cooking, and I need to concentrate."
							1
						)
						(6
							(Converse 1 @local65 16 0 0) ; "I was watching Watling Street from the Overlook earlier and there's quite a few Monks coming and going today."
							1
						)
					)
				)
			)
		)
	)
)

(instance willsActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Talk
					(switch gDay
						(5
							(if (or (== gDisguiseNum 6) (== gDisguiseNum 5)) ; fens monk, abbey monk
								(Converse 1 @local69 14 0 0) ; "If this disguise worked once, it may work again. This is a time for risks."
								1
							)
						)
						(6
							(if (or (== gDisguiseNum 6) (== gDisguiseNum 5)) ; fens monk, abbey monk
								(Converse 1 @local69 14 0 0) ; "If this disguise worked once, it may work again. This is a time for risks."
								1
							)
						)
					)
				)
			)
		)
	)
)

(instance johnsActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Talk
					(switch gDay
						(6
							(if (== local51 0)
								(= local51 1)
								(Converse @local124 13 0) ; "You'll be off to the Fens, I reckon, to fetch that scroll the Lady Marian wants."
							else
								(Converse @local73 13 0) ; "I'm glad it's not me that must figure a way inside."
							)
							1
						)
						(10
							(if local50
								(Converse 1 @local77 13 0 0) ; "You'll have whatever help you want of me."
								1
							else
								(Converse 2 @local81 2 0 13 3 0) ; "The sheriff will be expecting a rescue attempt."
								(= local50 1)
								1
							)
						)
					)
				)
			)
		)
	)
)

(instance muchsActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Talk
					(if (== gDay 6)
						(Converse @local87 17 0) ; "I think the poor widow will die if she loses all her sons."
						1
					)
				)
			)
		)
	)
)

(instance tableDoVerb of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(Say 1150 6 1) ; "Our camp tables are crude, but they serve their purpose."
			)
			(3
				(Say 1150 7 1) ; "There's nothing on the table to take."
			)
			(10
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(4
				(switch param2
					(1
						(Say 1150 8 1) ; "I'd rather keep it with me."
					)
					(0
						(Say 1150 9 1) ; "I've no reason to leave coins lying around. Tuck sees to it that the men have what they need."
					)
					(else
						(Say 1150 10 1) ; "It would serve no purpose there."
					)
				)
			)
			(else
				(gDoVerbCode doit: param1 &rest)
			)
		)
	)
)

(instance stumpDoVerb of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(Say 1150 11 1) ; "The stumps are our `chairs'."
			)
			(3
				(Say 1150 1 1) ; "It's fine where it is."
			)
			(10
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(gDoVerbCode doit: param1 &rest)
			)
		)
	)
)

(instance rockDoVerb of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(Say 1150 12 1) ; "The boulders are slightly less comfortable to sit on than the stumps."
			)
			(3
				(Say 1150 1 1) ; "It's fine where it is."
			)
			(10
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(gDoVerbCode doit: param1 &rest)
			)
		)
	)
)

(instance table1 of Feature
	(properties
		x 35
		y 131
	)

	(method (init)
		((= onMeCheck (Polygon new:)) type: PTotalAccess init: 35 143 0 155 0 131 33 137)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(tableDoVerb doit: theVerb invItem)
	)
)

(instance table2 of Feature
	(properties
		x 129
		y 93
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 129 101 67 117 30 110 30 107 91 93 128 98
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(tableDoVerb doit: theVerb invItem)
	)
)

(instance table3 of Feature
	(properties
		x 207
		y 113
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 207 121 158 150 110 141 108 137 165 113 204 117
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(tableDoVerb doit: theVerb invItem)
	)
)

(instance table4 of Feature
	(properties
		x 273
		y 63
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 273 71 209 85 174 78 174 74 230 63 271 68
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(tableDoVerb doit: theVerb invItem)
	)
)

(instance rock1 of Feature
	(properties
		x 220
		y 131
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 220 138 212 143 188 143 187 138 215 131 220 134
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(rockDoVerb doit: theVerb invItem)
	)
)

(instance rock2 of Feature
	(properties
		x 105
		y 117
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 105 127 91 129 82 126 86 120 95 117 102 120
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(rockDoVerb doit: theVerb invItem)
	)
)

(instance rock3 of Feature
	(properties
		x 57
		y 120
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 57 130 52 132 31 132 18 127 25 121 45 120
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(rockDoVerb doit: theVerb invItem)
	)
)

(instance rock4 of Feature
	(properties
		x 72
		y 162
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 72 189 0 189 0 177 6 173 1 167 7 162 26 163 31 171 51 180 63 179 71 184
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(rockDoVerb doit: theVerb invItem)
	)
)

(instance rock5 of Feature
	(properties
		x 208
		y 172
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 208 178 177 181 154 189 145 189 142 184 146 180 155 177 170 172 195 174
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(rockDoVerb doit: theVerb invItem)
	)
)

(instance stump1 of Feature
	(properties
		x 255
		y 86
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 255 99 244 105 230 104 222 100 223 90 229 86 247 86 251 89
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(stumpDoVerb doit: theVerb invItem)
	)
)

(instance stump2 of Feature
	(properties
		x 195
		y 150
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 195 162 179 165 162 160 167 153 171 150 187 150 193 153
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(stumpDoVerb doit: theVerb invItem)
	)
)

(instance stump3 of Feature
	(properties
		x 137
		y 112
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 137 123 124 127 113 126 107 123 109 114 115 112 129 112 136 114
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(stumpDoVerb doit: theVerb invItem)
	)
)

(instance stump4 of Feature
	(properties
		x 46
		y 142
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 46 155 32 164 25 161 11 160 11 152 39 142 43 143
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(stumpDoVerb doit: theVerb invItem)
	)
)

(instance stump5 of Feature
	(properties
		x 142
		y 149
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 142 163 134 167 123 168 101 160 102 153 109 149 118 150 139 157
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(stumpDoVerb doit: theVerb invItem)
	)
)

(instance cave of Feature
	(properties
		x 319
		y 28
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 111 301 94 308 63 319 64
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1150 2 1) ; "My cave entrance."
			)
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stream of Feature
	(properties
		x 71
		y 50
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 83 19 82 23 76 34 78 41 75 72 75 77 69 183 61 181 56 211 56 210 53 236 50 290 47 289 51 129 74 100 74 85 81 41 82 25 91 0 91
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1150 4 1) ; "We have good clear water for our camp."
			)
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(3 ; Do
				(Say 1150 51 1) ; "I've no need for water now."
			)
			(4 ; Inventory
				(if (== invItem 18) ; waterRing
					(Say 1150 52 1) ; "Nothing in this water responds to the water ring. It must not possess any water spirits."
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

(instance cliffs of Feature
	(properties
		x 60
		y 1
	)

	(method (init)
		((= onMeCheck (Polygon new:)) type: PTotalAccess init: 120 41 0 42 0 0 82 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1150 3 1) ; "More good Nottingham sandstone."
			)
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance woods of Feature
	(properties
		x 190
		y 1
	)

	(method (init)
		((= onMeCheck (Polygon new:)) type: PTotalAccess init: 125 45 85 0 295 0 293 39)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1150 5 1) ; "Sherwood Forest surrounds us."
			)
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance food of Feature
	(properties
		x 164
		y 94
		nsTop 77
		nsLeft 143
		nsBottom 94
		nsRight 186
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1150 37 1) ; "Looks like Tuck has himself a nice, plump fish."
			)
			(3 ; Do
				(cond
					((or (== local46 0) (== local47 0))
						(if (== local46 1)
							(= local47 1)
						)
						(= local46 1)
						(gEgo setScript: takeFood)
					)
					((and (== local46 1) (== local47 1) (== local48 0))
						(= local48 1)
						(Converse @local114 3 15) ; "Ahem. Leave a bit for me, if you please."
					)
					(else
						(Say 1150 38 1) ; "Tuck sees to it that I have all the food I need."
					)
				)
			)
			(10 ; Longbow
				(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance everyThing of Feature
	(properties
		nsBottom 190
		nsRight 322
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Longbow
			(Say 1150 0 1) ; "I wouldn't risk an arrow around here, with men coming and going. There's a shooting glade nearby for practice."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wave of Prop
	(properties
		view 150
		loop 7
		signal 16384
		cycleSpeed 18
		detailLevel 2
	)

	(method (init)
		(if (Random 0 1)
			(self setCycle: Fwd)
		else
			(self setCycle: Rev)
		)
		(super init:)
	)
)

(instance theFire of Prop
	(properties
		x 155
		y 105
		view 140
		priority 7
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd self)
		(super init:)
	)

	(method (cue &tmp temp0)
		(= temp0 (Random 0 1))
		(self cycleSpeed: (Random 6 18))
		(if temp0
			(self setCycle: End self)
		else
			(self setCycle: Beg self)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1150 15 1) ; "Friar Tuck is in charge of the campfires and cooking."
			)
			(3 ; Do
				(if (== global115 2)
					(gEgo setScript: burnHand)
				else
					(Say 1150 14 1) ; "I've no desire to burn myself."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo illegalBits: 0)
				(switch register
					(2
						(gEgo
							posn: -15 124
							init:
							setMotion: PolyPath 26 124 self
						)
					)
					(3
						(gEgo
							posn: 181 70
							init:
							loop: 5
							setMotion: PolyPath 252 125 self
						)
					)
					(4
						(if (== gPrevRoomNum 140)
							(gEgo
								posn: 339 119
								init:
								setMotion: PolyPath 262 125 self
							)
						else
							(gEgo
								posn: 302 88
								init:
								setMotion: PolyPath 262 125 self
							)
						)
					)
					(else
						(gEgo
							loop: 3
							posn: 107 241
							init:
							setMotion: PolyPath 107 184 self
						)
					)
				)
			)
			(1
				(gEgo stopUpd:)
				(if (IsFlag 179)
					(ClearFlag 179)
					(Converse @local129 1 0 self) ; "Thank the Blessed Virgin! The sprite's spell has worn off!"
				else
					(self cue:)
				)
			)
			(2
				(if local12
					(gEgo setScript: local12)
				else
					(HandsOn)
				)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance walkOutOfHere of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch gEgoEdgeHit
					(3
						(= temp1 240)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(HandsOff)
				(if (!= gEgoEdgeHit 1)
					(gEgo
						ignoreActors: 1
						setMotion: PolyPath temp0 temp1 self
					)
				else
					(self cue:)
				)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance burnHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 7)
				(gEgo setMotion: PolyPath 154 117 self)
			)
			(1
				(gEgo loop: 3)
				(= ticks 6)
			)
			(2
				(gEgo
					view: 7
					loop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(NormalEgo 6)
				(= ticks 6)
			)
			(4
				(Converse 1 @local57 1 0 self) ; "The Fire Ring protected me completely! I felt no pain and the flames had no effect on me."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tuckAlone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(Face gEgo (ScriptID 23)) ; Tuck
				(Face (ScriptID 23) gEgo) ; Tuck
				(= ticks 30)
			)
			(2
				(Converse 2 @local91 3 0 15 3 self) ; "You've wasted no time devouring that fish, I see."
				1
			)
			(3
				((ScriptID 23) actions: tucksActions) ; Tuck
				(= ticks 6)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 154 117 self)
			)
			(1
				(gEgo loop: 3)
				(= ticks 6)
			)
			(2
				(NormalEgo 6)
				(= ticks 6)
			)
			(3
				(Converse @local119 3 15 self) ; "Help yourself, Robin."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkInToCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 300 113 self)
			)
			(1
				(gEgo setMotion: PolyPath 335 119 self)
			)
			(2
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

(instance streamSound of Sound
	(properties
		flags 1
		number 581
		loop -1
	)
)

