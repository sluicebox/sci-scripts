;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use MapButton)
(use n013)
(use Wat)
(use verseScript)
(use Polygon)
(use Feature)
(use Game)

(public
	rm100 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm100 of Rm
	(properties
		picture 100
	)

	(method (init)
		(if
			(or
				(and
					(== gDay 1)
					(IsFlag 46)
					(IsFlag 45)
					(IsFlag 44)
					(not (Wat whichChar:))
				)
				(and (== gDay 3) (IsFlag 54) (IsFlag 82))
				(and
					(== gDay 4)
					(IsFlag 48)
					(IsFlag 47)
					(not (Wat whichChar:))
				)
				(and (== gDay 7) (IsFlag 34) (IsFlag 35))
				(and
					(== gDay 8)
					(IsFlag 58)
					(or
						(IsFlag 191)
						(and
							(not (IsFlag 191))
							(or
								(IsFlag 10)
								(IsFlag 160)
								(IsFlag 131)
								(> gRoomCount 42)
							)
						)
					)
				)
				(and (== gDay 9) (or (IsFlag 145) (IsFlag 146)))
				(and (== gDay 12) (IsFlag 27))
			)
			(gCurRoom newRoom: 160)
		)
		(super init:)
		(= local3 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(= local2
			(switch gHowFast
				(0 40)
				(1 60)
				(2 80)
			)
		)
		(SetFlag 4)
		(if
			(or
				(!= (gRgnMusic number:) 902)
				(not (gRgnMusic handle:))
				(not (gRgnMusic vol:))
			)
			(gRgnMusic number: 902 loop: -1 play:)
		)
		(town init:)
		(cottage init:)
		(monks init:)
		(willowGrove init:)
		(camp init:)
		(oakGrove init:)
		(if (IsFlag 137)
			(overlook init:)
		)
		(AddToFeatures
			watlingStGood
			watlingStBad
			banner
			riverTrent
			riverLeene
			forestBad1
			forestBad2
			lion1
			lion2
			emblem1
			emblem2
			forestGood
		)
		(HandsOn)
		(SetIcon 0)
		((gTheIconBar at: 0) message: 11)
	)

	(method (doit)
		(++ local1)
		(cond
			((IsFlag 70)
				(ClearFlag 70)
				(Say 1100 18) ; "For one of my reputation for daring, wit, and cunning, that was a dazzling display of indecision."
			)
			((== (mod local1 local2) 0)
				(Palette palANIMATE 240 247 -1)
			)
		)
	)

	(method (dispose)
		(ClearFlag 4)
		(gTheIconBar enable: 2 3 4 5 6 7)
		(= gUseSortedFeatures local3)
		((gTheIconBar at: 0) message: 1)
		(super dispose:)
	)
)

(instance town of MapButton
	(properties
		x 146
		y 130
		heading 260
		lookStr 1 ; "The town of Nottingham."
		view 100
		loop 5
	)

	(method (handleEvent event)
		(if
			(and
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(== ((gTheIconBar curIcon:) message:) 11)
				(self onMe: event)
				(or
					(and (== gDay 9) (not (IsFlag 36)))
					(and (== gDay 12) (not (IsFlag 38)))
				)
			)
			(Say 1100 19 1) ; "There are dozens of Sheriff's men around the city gates. I'd best stay well away from town for now."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance cottage of MapButton
	(properties
		x 209
		y 87
		heading 250
		lookStr 2 ; "The Widow dwells here."
		view 100
		loop 2
	)
)

(instance monks of MapButton
	(properties
		x 117
		y 182
		heading 580
		lookStr 3 ; "This is the Monastery in the Fens."
		view 100
		loop 4
	)
)

(instance willowGrove of MapButton
	(properties
		x 192
		y 111
		heading 210
		lookStr 4 ; "Near the river Trent is the sacred willow grove."
		view 100
		loop 3
	)
)

(instance overlook of MapButton
	(properties
		x 196
		y 65
		heading 110
		lookStr 6 ; "This hill overlooks Watling Street."
		view 100
		loop 6
	)
)

(instance camp of MapButton
	(properties
		x 214
		y 65
		heading 150
		lookStr 5 ; "My hidden camp within Sherwood."
		view 100
		loop 1
	)

	(method (init)
		(if (IsFlag 137)
			(= x 218)
		)
		(super init:)
	)
)

(instance oakGrove of MapButton
	(properties
		x 144
		y 74
		heading 180
		lookStr 7 ; "This most ancient of oaks is the soul of Sherwood Forest."
		view 100
	)
)

(instance watlingStGood of Feature
	(properties
		onMeCheck -32768
		lookStr 8 ; "Watling Street passes close by Nottingham, travels through Sherwood Forest, and thence to York in the north."
	)

	(method (init)
		(= local0
			(= onMeCheck
				((Polygon new:)
					type: PTotalAccess
					init: 209 25 209 28 202 31 202 36 194 45 194 58 191 63 186 70 189 73 189 77 186 76 182 91 180 93 176 112 163 110 164 108 167 103 161 95 167 89 161 82 169 78 166 70 173 64 168 58 178 55 179 42 189 36 186 33 193 28 193 22
					yourself:
				)
			)
		)
		(super init:)
	)

	(method (dispose)
		(local0 dispose:)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (not (event claimed:))
			(if
				(or
					(!= ((gTheIconBar curIcon:) message:) 11)
					(& (event modifiers:) emSHIFT)
					(& (event modifiers:) emCTRL)
				)
				(super handleEvent: event)
			else
				(= temp0 (Wat section:))
				(= onMeCheck 0)
				(if
					(or
						(and
							(= onMeCheck 2)
							(self onMe: event)
							(Wat section: 1)
							(= gForestRoomNum 24)
						)
						(and
							(= onMeCheck 4)
							(self onMe: event)
							(Wat section: 2)
							(= gForestRoomNum 39)
						)
						(and
							(= onMeCheck 8)
							(self onMe: event)
							(Wat section: 3)
							(= gForestRoomNum 54)
						)
						(and
							(= onMeCheck 16)
							(self onMe: event)
							(Wat section: 4)
							(= gForestRoomNum 70)
						)
						(and
							(= onMeCheck 32)
							(self onMe: event)
							(Wat section: 5)
							(= gForestRoomNum 86)
						)
						(and
							(= onMeCheck 64)
							(self onMe: event)
							(Wat section: 6)
							(= gForestRoomNum 101)
						)
						(and
							(= onMeCheck 128)
							(self onMe: event)
							(Wat section: 7)
							(= gForestRoomNum 117)
						)
						(and
							(= onMeCheck 256)
							(self onMe: event)
							(Wat section: 8)
							(= gForestRoomNum 133)
						)
						(and
							(= onMeCheck 512)
							(self onMe: event)
							(Wat section: 9)
							(= gForestRoomNum 149)
						)
					)
					(if (>= (Wat section:) temp0)
						(Wat enterDir: 1)
					else
						(Wat enterDir: 3)
					)
					(if (== ((gTheIconBar curIcon:) message:) 11)
						(event claimed: 1)
						(gCurRoom newRoom: 120)
					)
				else
					(= onMeCheck local0)
				)
			)
		)
	)
)

(instance watlingStBad of Feature
	(properties
		lookStr 9 ; "Watling street continues south from Nottingham all the way to London."
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 160 110 178 113 173 133 184 143 187 158 182 189 165 189 175 151 167 147 167 121
						yourself:
					)
				)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance riverTrent of Feature
	(properties
		lookStr 13 ; "The River Trent."
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 89 189 91 172 131 135 148 136 183 116 222 109 240 114 240 125 218 117 183 127 165 142 135 148 124 155 133 159 154 189 138 189 119 160 100 178 100 189
						yourself:
					)
				)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance riverLeene of Feature
	(properties
		lookStr 14 ; "The River Leene."
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 106 26 103 46 113 60 112 75 118 83 112 92 127 112 126 123 158 131 147 136 121 131 114 122 113 110 101 99 101 87 105 82 98 73 99 59 93 45 96 28
						yourself:
					)
				)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance banner of Feature
	(properties
		nsLeft 80
		nsBottom 29
		nsRight 239
		lookStr 10 ; "The town, lands and forest fall within the boundaries of Nottinghamshire."
	)
)

(instance forestGood of Feature
	(properties
		nsTop 30
		nsLeft 100
		nsBottom 111
		nsRight 239
		lookStr 11 ; "Sherwood Forest."
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (event claimed:)))
			(cond
				(
					(or
						(!= ((gTheIconBar curIcon:) message:) 11)
						(& (event modifiers:) emSHIFT)
						(& (event modifiers:) emCTRL)
					)
					(super handleEvent: event)
				)
				((== gPrevRoomNum 220) ; forest
					(gCurRoom newRoom: 220) ; forest
				)
				(else
					(= gForestRoomNum 73)
					(gCurRoom newRoom: 220) ; forest
				)
			)
		)
	)
)

(instance forestBad1 of Feature
	(properties
		nsTop 110
		nsLeft 85
		nsBottom 190
		nsRight 239
		lookStr 12 ; "The forest beyond the rivers is of no use to outlaws, for there is no easy way to cross save by the bridge next to Nottingham."
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(== ((gTheIconBar curIcon:) message:) 11)
				(not (& (event modifiers:) emSHIFT))
				(not (& (event modifiers:) emCTRL))
			)
			(Say 1100 12 1) ; "The forest beyond the rivers is of no use to outlaws, for there is no easy way to cross save by the bridge next to Nottingham."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance forestBad2 of Feature
	(properties
		nsTop 110
		nsLeft 80
		nsBottom 190
		nsRight 239
		lookStr 12 ; "The forest beyond the rivers is of no use to outlaws, for there is no easy way to cross save by the bridge next to Nottingham."
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 92 39 99 60 97 74 105 83 99 88 101 101 112 110 115 133 79 133 80 121 88 110 78 107 79 84 90 84 95 76 89 54
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(== ((gTheIconBar curIcon:) message:) 11)
				(not (& (event modifiers:) emSHIFT))
				(not (& (event modifiers:) emCTRL))
			)
			(Say 1100 12 1) ; "The forest beyond the rivers is of no use to outlaws, for there is no easy way to cross save by the bridge next to Nottingham."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance emblem1 of Feature
	(properties
		nsTop 124
		nsBottom 189
		nsRight 80
		lookStr 15 ; "Upon King Richard the Lionheart's shield are three lions passant guardant."
	)
)

(instance emblem2 of Feature
	(properties
		nsTop 124
		nsLeft 239
		nsBottom 189
		nsRight 320
		lookStr 16 ; "Upon this shield is the device of the Sheriff of Nottingham, a raven."
	)
)

(instance lion1 of Feature
	(properties
		nsTop 19
		nsBottom 124
		nsRight 81
		lookStr 17 ; "In heraldic terms, 'tis a lion salient."
	)
)

(instance lion2 of Feature
	(properties
		nsTop 19
		nsLeft 240
		nsBottom 124
		nsRight 319
		lookStr 17 ; "In heraldic terms, 'tis a lion salient."
	)
)

