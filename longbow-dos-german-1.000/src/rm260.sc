;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use MapButton)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use Polygon)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm260 of Rm
	(properties
		picture 260
	)

	(method (init)
		(super init:)
		(= local3
			(switch gHowFast
				(0 40)
				(1 60)
				(2 80)
			)
		)
		(if
			(and
				(== gDay 10)
				(not (OneOf gPrevRoomNum 450 440 350 390 270 280 290 300 310))
				(>= gBlowCount 1)
			)
			(= global151 global159)
		)
		(if (or (!= (gRgnMusic number:) 902) (< (gRgnMusic vol:) 127))
			(gRgnMusic number: 902 vol: 127 loop: -1 play:)
		)
		(= local1 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(AddToFeatures
			castle
			pub
			shop
			abbey
			fair
			river
			watling
			inField
			inTown
			midTown
			northOfTown
			southOfTown
		)
		(castleFlag init:)
		(pubFlag init:)
		(abbeyFlag init:)
		(lobbFlag init:)
		(if (== gDay 8)
			(fairFlag init:)
		)
		(HandsOn)
		(gTheIconBar disable: 2 3 6 4)
		(if (<= 5 gDay 6)
			(if
				(and
					(>= global142 1)
					(== gDisguiseNum 5) ; abbey monk
					(not
						(OneOf gPrevRoomNum 450 440 350 390 270 280 290 300 310)
					)
				)
				(gTheIconBar disable: 5)
				(= local4 1)
			)
			(if
				(and
					(>= global142 2)
					(OneOf gPrevRoomNum 450 440 350 390 270 280 290 300 310)
				)
				(gCurRoom newRoom: 150)
			)
		)
		(if
			(and
				(== gDay 10)
				(== global151 global159)
				(!= global156 gBlowCount)
			)
			(gTheIconBar disable: 5)
			(= local4 1)
		)
		(SetIcon 0)
		((gTheIconBar at: 0) message: 11)
	)

	(method (doit)
		(if (== (mod (++ local2) local3) 0)
			(Palette palANIMATE 245 254 -1)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local1)
		((gTheIconBar at: 0) message: 1)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(OneOf gPrevRoomNum 450 440 350 390 270 280 290 300 310)
				(not (OneOf newRoomNumber 450 440 350 390 270 280 290 300 310))
			)
			(if (!= gDay 10)
				(= gBlowCount 0)
			)
			(= global156 gBlowCount)
			(++ global142)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance castle of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 23 76 47 75 66 88 68 103 48 109 26 111 14 96 14 85
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: castleMessage)
			)
			(11 ; iconMap
				(if (== gDisguiseNum 0) ; outlaw
					(Say 1260 4 1) ; "I'd as well put my head in a noose as appear outside the Sheriff's own stronghold in my outlaw garb."
				else
					(gCurRoom newRoom: 390)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pub of Feature
	(properties
		lookStr 5 ; "The oldest pub in England. The innkeeper is well-known for giving ale to noble Crusaders returning from the Holy Land."
	)

	(method (doVerb theVerb)
		(if (== theVerb 11) ; iconMap
			(gCurRoom newRoom: 270)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 52 109 62 106 64 121 51 121
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

(instance shop of Feature
	(properties
		lookStr 6 ; "Lobb the Cobbler lives in this part of town."
	)

	(method (doVerb theVerb)
		(if (== theVerb 11) ; iconMap
			(if (== gDisguiseNum 0) ; outlaw
				(Say 1260 7 1) ; "I dare not set foot inside the town walls dressed as an outlaw."
			else
				(gCurRoom newRoom: 350)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 193 94 235 94 235 109 193 116
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

(instance abbey of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 209 53 227 53 252 77 252 87 235 89
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: abbeyMessage)
			)
			(11 ; iconMap
				(if (== gDisguiseNum 0) ; outlaw
					(Say 1260 13 1) ; "I dare not enter Nottingham as an outlaw."
				else
					(gCurRoom newRoom: 440)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fair of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 76 47 116 47 74 71 60 64
						yourself:
					)
				)
		)
		(if (OneOf gPrevRoomNum 280 290 300 310)
			(= heading gPrevRoomNum)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 8)
					(Say 1260 16 1) ; "The marketplace is filled with the noise and bustle of the Saturday Fair."
				else
					(gCurRoom setScript: fairMessage)
				)
			)
			(11 ; iconMap
				(if (== gDay 8)
					(if (== gDisguiseNum 0) ; outlaw
						(Say 1260 23 1) ; "I dare not set foot here in my outlaw garb."
					else
						(gCurRoom newRoom: 310)
					)
				else
					(Say 1260 17 1) ; "The Fair is not being held now and I feel no need to wander in its empty grounds."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance river of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 0 137 28 153 48 155 86 142 125 144 172 133 201 135 222 131 255 125 273 120 293 114 319 109 319 132 298 135 251 130 218 140 189 139 173 138 130 150 113 150 88 146 50 161 24 160 0 144
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 19 1) ; "The River Leene flows past Nottingham."
			)
			(11 ; iconMap
				(Say 1260 20 1) ; "I've no boat to travel on the river."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance watling of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 298 0 319 65 319 75 307 80 296 77 296 71 310 71 313 65 300 48 276 30 270 0
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 21 1) ; "'Tis Watling Street."
			)
			(11 ; iconMap
				(if (not local4)
					(gCurRoom newRoom: 100)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inField of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 81 44 119 45 108 76 91 77 110 103 122 105 101 118 64 119 61 105 71 100 65 87 46 74
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 25 1) ; "These are grazing commons."
			)
			(11 ; iconMap
				(if (== gDisguiseNum 0) ; outlaw
					(Say 1260 23 1) ; "I dare not set foot here in my outlaw garb."
				else
					(Say 1260 26 1) ; "I would attract too much attention as a stranger wandering through the commons."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inTown of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 82 43 86 34 114 26 228 24 263 46 277 66 284 91 271 104 244 105 224 115 202 121 178 121 159 109 128 110 99 122 48 122 46 72
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 22 1) ; "The two old boroughs of the Normans and Anglo-Saxons have grown together to form the one town of Nottingham."
			)
			(11 ; iconMap
				(if (== gDisguiseNum 0) ; outlaw
					(Say 1260 23 1) ; "I dare not set foot here in my outlaw garb."
				else
					(Say 1260 24 1) ; "I've no need to go to that part of town."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance midTown of Feature
	(properties)

	(method (init)
		(gCurRoom
			addObstacle:
				(= onMeCheck
					((Polygon new:)
						type: PTotalAccess
						init: 0 101 13 89 14 97 26 111 49 110 49 123 101 123 128 110 159 110 178 121 202 121 235 110 244 105 271 104 284 91 281 78 319 75 319 108 253 126 202 136 166 134 126 145 86 143 49 155 28 153 0 137
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

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 28 1) ; "The town sits on the banks of the River Leene."
			)
			(11 ; iconMap
				(if (not local4)
					(gCurRoom newRoom: 100)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance northOfTown of Feature
	(properties
		nsBottom 95
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 27 1) ; "Sherwood Forest has been cut back from the town walls."
			)
			(11 ; iconMap
				(if (not local4)
					(gCurRoom newRoom: 100)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southOfTown of Feature
	(properties
		nsTop 95
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1260 29 1) ; "Near the town, upon the other side of the river, much of Sherwood Forest has been cut back to allow grazing and farming."
			)
			(11 ; iconMap
				(if (not local4)
					(gCurRoom newRoom: 100)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance castleFlag of MapButton
	(properties
		x 38
		y 81
		heading 390
		view 260
	)

	(method (init)
		((aPole new:) x: x y: y init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(castle doVerb: theVerb &rest)
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
				(== gDisguiseNum 0) ; outlaw
			)
			(Say 1260 4 1) ; "I'd as well put my head in a noose as appear outside the Sheriff's own stronghold in my outlaw garb."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance pubFlag of MapButton
	(properties
		x 58
		y 100
		heading 270
		view 260
		loop 1
	)

	(method (init)
		((aPole new:) x: x y: y init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(pub doVerb: theVerb &rest)
	)
)

(instance fairFlag of MapButton
	(properties
		x 81
		y 45
		heading 310
		view 260
		loop 2
	)

	(method (init)
		((aPole new:) x: x y: y init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(fair doVerb: theVerb &rest)
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
				(== gDisguiseNum 0) ; outlaw
			)
			(Say 1260 23 1) ; "I dare not set foot here in my outlaw garb."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance abbeyFlag of MapButton
	(properties
		x 243
		y 62
		heading 440
		view 260
		loop 3
	)

	(method (init)
		((aPole new:) x: x y: y init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(abbey doVerb: theVerb &rest)
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
				(== gDisguiseNum 0) ; outlaw
			)
			(Say 1260 13 1) ; "I dare not enter Nottingham as an outlaw."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance lobbFlag of MapButton
	(properties
		x 199
		y 94
		heading 350
		view 260
		loop 4
	)

	(method (init)
		((aPole new:) x: x y: y init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(shop doVerb: theVerb &rest)
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
				(== gDisguiseNum 0) ; outlaw
			)
			(Say 1260 7 1) ; "I dare not set foot inside the town walls dressed as an outlaw."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance aPole of View
	(properties
		view 260
		loop 5
		signal 1
	)
)

(instance castleMessage of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1260 0 self) ; "The Sheriff of Nottingham lives and rules from this Norman castle upon the sandstone bluff."
			)
			(1
				(if (not (IsFlag 2))
					(SetFlag 2)
					(Say 1260 1 self) ; "It is heavily fortified and filled with his men, as corrupt a band of rogues as I have ever seen."
				else
					(self dispose:)
				)
			)
			(2
				(Say 1260 2 self) ; "The Sheriff's dungeons and gallows put fear into the hearts of outlaws and honest men alike."
			)
			(3
				(Say 1260 3 self) ; "And the sanctimonious Abbot blesses all the Sheriff's evil deeds."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance abbeyMessage of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1260 8 self) ; "The vile and wicked Abbot has grandiose dreams of a great cathedral built in his honour."
			)
			(1
				(if (not (IsFlag 3))
					(Say 1260 9 self) ; "To this end he forces the workers of Nottingham to work for nearly nothing lest he excommunicate them."
				else
					(++ state)
					(self cue:)
				)
			)
			(2
				(Say 1260 10 self) ; "So far, his self-glorification is little more than a facade. And, God willing, so it will remain."
			)
			(3
				(Say 1260 11 self) ; "At the far end of his property, he has built the stone-walled Witches' Court, where he burns those he accuses of being witches."
			)
			(4
				(if (not (IsFlag 3))
					(SetFlag 3)
					(Say 1260 12 self) ; "With the Sheriff as his ally, none dare to stop him."
				else
					(self cue:)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance fairMessage of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1260 14 self) ; "Here the largest fair in the country takes place, with merchants traveling from all parts of the world with their wares."
			)
			(1
				(Say 1260 15 self) ; "And when Saturday Fair is held, there is usually an archery tournament."
			)
			(2
				(self dispose:)
			)
		)
	)
)

