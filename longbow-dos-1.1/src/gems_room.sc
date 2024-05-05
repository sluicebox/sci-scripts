;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 621)
(include sci.sh)
(use Main)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use IconBar)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	gems_room 0
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
	local11
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
	[local25 520]
	[local545 4] = [1621 0 1 0]
	[local549 8] = [1621 1 1 0 1621 3 1 0]
	[local557 4] = [1621 4 1 0]
	[local561 4] = [1621 5 1 0]
)

(procedure (localproc_0)
	(gCast eachElementDo: #perform hideMe)
	(= local19 gCast)
	(= local20 gFeatures)
	(= local21 gAddToPics)
	(= local22 gMouseDownHandler)
	(= gMouseDownHandler (= gCast (= gFeatures (= gAddToPics 0))))
	(gCurRoom drawPic: 803 10)
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	((= gMouseDownHandler newMDH) add: gFeatures)
)

(procedure (localproc_1)
	(if (GameIsRestarting)
		(= local16 (Display local17 dsCOORD 50 10 dsWIDTH 200 dsCOLOR 255 dsBACKGROUND 0 dsSAVEPIXELS))
	)
)

(procedure (localproc_2)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(bigGems dispose:)
	(gMouseDownHandler dispose:)
	(gCurRoom drawPic: (gCurRoom picture:) 10)
	(= gCast local19)
	(= gFeatures local20)
	((= gAddToPics local21) doit:)
	(= gMouseDownHandler local22)
	(gCast eachElementDo: #perform showMe)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMDH of EventHandler
	(properties)
)

(instance hideMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance gems_room of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= local18 1)
		(= local23 gTheCursor)
		(gTheIconBar disable: 3 1 4 5 6 0 7)
		(= temp1 (IconBar at: 2))
		(= local1 (temp1 cursor:))
		(temp1 cursor: 5)
		(= temp2 (IconBar at: 8))
		(= local2 (temp2 cursor:))
		(temp2 cursor: 5)
		(= local24 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(localproc_0)
		(AddToFeatures
			agate
			turquoise
			sapphire
			carnelian
			lapisLazuli
			amber
			jet
			opal
			quartz
			everything
		)
		(bigGems init: stopUpd:)
		(army posn: 180 125 init:)
		(gGame setCursor: 5 1 180 125)
		(= local13 (Random 0 13))
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: doTheRiddles)
			)
		)
	)

	(method (dispose)
		(localproc_2)
		(= gUseSortedFeatures local24)
		(gGame setCursor: local23 1)
		((IconBar at: 2) cursor: local1)
		((IconBar at: 8) cursor: local2)
		(gMouseDownHandler delete: self)
		(gTheIconBar enable: 3 6 5 6 0 7 8)
		(gCurRoom setScript: 0)
		(super dispose:)
		(DisposeScript 621)
	)
)

(instance everything of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 0 319 0 319 189 0 189
			yourself:
		)
	)
)

(instance agate of Feature
	(properties
		y 90
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 158 78 158 82 152 90 146 88 144 86 144 82 146 80 150 77
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (not local4) (OneOf local13 0 3 6 7 8 10 11 14))
				(= local4 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance turquoise of Feature
	(properties
		y 105
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 133 99 138 94 147 93 149 95 150 101 146 104 135 105 132 102
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local5 0) (OneOf local13 8 12 14))
				(= local5 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sapphire of Feature
	(properties
		y 103
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 156 101 154 98 154 94 160 91 165 91 167 95 167 101 161 103 157 103 155 101
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local6 0) (OneOf local13 5 7 8 9 12 13))
				(= local6 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance carnelian of Feature
	(properties
		y 103
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 180 90 188 89 194 91 195 99 192 102 186 103 181 100 177 97 177 93
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local7 0) (OneOf local13 1 2 3 5 6 10 15))
				(= local7 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lapisLazuli of Feature
	(properties
		y 118
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 121 115 121 112 125 109 133 108 135 111 135 114 129 118 123 117
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local8 0) (OneOf local13 0 5 7 9 11 13))
				(= local8 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance amber of Feature
	(properties
		y 119
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 145 115 145 111 150 107 156 107 158 109 159 115 155 119 148 119
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local9 0) (OneOf local13 3 4 9 14 15))
				(= local9 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance jet of Feature
	(properties
		y 113
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 166 111 166 106 169 104 174 104 177 108 177 111 171 113
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local10 0) (OneOf local13 0 1 2 9 11 12 13 15))
				(= local10 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance opal of Feature
	(properties
		y 128
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 140 117 144 118 146 123 141 128 135 127 132 125 132 120
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local11 0) (OneOf local13 1 2 4 6))
				(= local11 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance quartz of Feature
	(properties
		y 128
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 187 116 187 123 183 127 177 128 174 126 171 120 179 112
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(++ local14)
			(if (and (== local12 0) (OneOf local13 0 4 5 10 13))
				(= local12 1)
				(gCurRoom setScript: rightAns)
			else
				(gCurRoom setScript: wrongAns)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bigGems of View
	(properties
		x 153
		y 72
		view 771
		loop 4
		cel 1
	)
)

(instance army of Actor
	(properties
		x 180
		y 125
		view 182
		loop 1
		priority 14
		signal 26640
		illegalBits 0
	)

	(method (doit)
		(= x gMouseX)
		(= y (- gMouseY 10))
		(if (!= gTheCursor 5)
			(gGame setCursor: 5 1)
		)
		(super doit:)
	)
)

(instance doTheRiddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(= local5 0)
				(= local6 0)
				(= local7 0)
				(= local8 0)
				(= local9 0)
				(= local10 0)
				(= local11 0)
				(= local12 0)
				(switch local13
					(0
						(= local17 (GetFarText 1621 6 @local25)) ; "I will seek out the devil where he lies and I will cross many seas to do so. Then I shall blast him with fire from heaven."
					)
					(1
						(= local17 (GetFarText 1621 7 @local25)) ; "Demons dance to my call. I am a thief none can catch. No sharp blade worries me. What do I have?"
					)
					(2
						(= local17 (GetFarText 1621 8 @local25)) ; "I would comfort a friend who is ill and fears that death will come upon him without warning. But if death should come, let my gifts guide him beyond demon's reach and to new life. What should I give him?"
					)
					(3
						(= local17 (GetFarText 1621 9 @local25)) ; "I have a fever which has driven me to madness. My teeth loosen and I taste blood in my mouth."
					)
					(4
						(= local17 (GetFarText 1621 10 @local25)) ; "I am old and my hearing fails me, I am ill and wonder when death will come for me, my mouth is dry. What would you give me?"
					)
					(5
						(= local17 (GetFarText 1621 11 @local25)) ; "I must go into battle where I may well be wounded. Then I will know great thirst and my eyes will burn."
					)
					(6
						(= local17 (GetFarText 1621 12 @local25)) ; "Sadness weighs upon my soul. My heart aches to be filled. Would that I could steal into my love's chamber unseen."
					)
					(7
						(= local17 (GetFarText 1621 13 @local25)) ; "I have three fears: I fear travelling by ship; I fear my wife will be unfaithful: I fear the lies of men. What should I take with me?"
					)
					(8
						(= local17 (GetFarText 1621 14 @local25)) ; "I'll build a ship to carry me skyward. If it falls, I'll not be harmed. But I will never tell how it is done. What do I have?"
					)
					(9
						(= local17 (GetFarText 1621 15 @local25)) ; "A piece of sky fell to my feet and I picked it up. Where it touched me, it raised boils. I fear it poisons me. What would you give me?"
					)
					(10
						(= local17 (GetFarText 1621 16 @local25)) ; "My trees are heavy with fruit, my heart is full of all desires, and my wife gives birth to a holy child. What do I have?"
					)
					(11
						(= local17 (GetFarText 1621 17 @local25)) ; "The drought lengthens, the corn withers in my field, and a witch curses me with a glance. What would you give me?"
					)
					(12
						(= local17 (GetFarText 1621 18 @local25)) ; "I must ride upon a fiery horse, through valleys filled with adders and seek the fate that awaits me. What should I take with me?"
					)
					(13
						(= local17 (GetFarText 1621 19 @local25)) ; "In summer, my ice does not melt. The red eye becomes clear. Demons run when I raise my hand. What do I have?"
					)
					(14
						(= local17 (GetFarText 1621 20 @local25)) ; "Alas, sadness clothes me like a leaden cloak. A wicked woman lies to me, but I fear danger will come upon me by surprise. What would you give me?"
					)
					(15
						(= local17 (GetFarText 1621 21 @local25)) ; "I lie dying, cut deeply by the sword, my flesh burns, spirits of Hades hover to take my soul. What would you give me?"
					)
				)
				(= cycles 2)
			)
			(1
				(= local16
					(Display local17 dsCOORD 50 10 dsWIDTH 200 dsCOLOR 255 dsBACKGROUND 0 dsSAVEPIXELS)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(localproc_1)
	)
)

(instance wrongAns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gDeathNum 21)
				(= local17
					{_____________________________________________________________________________________________________}
				)
				(Display 621 0 dsRESTOREPIXELS local16)
				(SetFlag 149)
				(self changeState: 1)
			)
			(1
				(self dispose:)
				(gems_room dispose:)
			)
		)
	)
)

(instance rightAns of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(localproc_1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local14
					(1
						(gTheIconBar disable: 8)
						(Converse 1 @local557 11 2) ; "Your first choice is correct, Brother. Choose you now two more."
					)
					(2
						(Converse 1 @local561 11 2) ; "Aye, the second stone is correct. Choose your last stone for this riddle."
					)
					(3
						(gTheIconBar enable: 8)
						(switch local15
							(0
								(gCurRoom setScript: oneRiddle)
							)
							(1
								(gCurRoom setScript: twoRiddle)
							)
							(2
								(gCurRoom setScript: threeRiddle)
							)
						)
					)
				)
			)
		)
	)
)

(instance oneRiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 0)
				(= local17
					{_____________________________________________________________________________________________________}
				)
				(Display 621 0 dsRESTOREPIXELS local16)
				(Converse 1 @local545 11 2) ; "Good. Here is the second riddle."
				(++ local13)
				(++ local15)
				(self changeState: 1)
			)
			(1
				(gCurRoom setScript: doTheRiddles)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(localproc_1)
	)
)

(instance twoRiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 0)
				(= local17
					{_____________________________________________________________________________________________________}
				)
				(Display 621 0 dsRESTOREPIXELS local16)
				(Converse 1 @local549 11 2) ; "Well done, Brother. Here is the final riddle."
				(++ local13)
				(++ local15)
				(self changeState: 1)
			)
			(1
				(gCurRoom setScript: doTheRiddles)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(localproc_1)
	)
)

(instance threeRiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local17
					{_____________________________________________________________________________________________________}
				)
				(Display 621 0 dsRESTOREPIXELS local16)
				(Monastery backFromJewels: 1)
				(SetScore 100)
				(self changeState: 1)
			)
			(1
				(gems_room dispose:)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(localproc_1)
	)
)

