;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Conversation)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm770 0
)

(local
	local0
)

(procedure (localproc_0)
	(if
		(and
			((ScriptID 80 0) tstFlag: #rFlag2 4096) ; rgCastle
			((ScriptID 80 0) tstFlag: #rFlag2 8192) ; rgCastle
			((ScriptID 80 0) tstFlag: #rFlag2 16384) ; rgCastle
			((ScriptID 80 0) tstFlag: #rFlag2 32768) ; rgCastle
			(not ((ScriptID 80 0) tstFlag: #rFlag2 16)) ; rgCastle
		)
		((ScriptID 80 0) setFlag: #rFlag2 16) ; rgCastle
		(return 1)
	else
		(return 0)
	)
)

(class StolenItem of Feature
	(properties
		look1stSeq 0
		handLookedMsg 0
		flagNum 0
	)

	(method (onMe param1)
		(= x (param1 x:))
		(return (super onMe: param1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(roomConv
					add:
						-1
						noun
						theVerb
						(+ look1stSeq ((ScriptID 80 0) tstFlag: #rFlag2 flagNum)) ; rgCastle
				)
				((ScriptID 80 0) setFlag: #rFlag2 flagNum) ; rgCastle
				(if (localproc_0)
					(gGame givePoints: 2)
					(roomConv add: -1 1 0 1) ; "As Alexander looks at the objects on the table, he realizes the depth of the vizier's cunning. It must have been the vizier (or an accomplice) who stole that one thing most precious to each island, and then leaked rumors that one of the other islands was responsible!"
				)
				(roomConv init:)
			)
			(5 ; Do
				(gMessager
					say:
						noun
						theVerb
						(+
							handLookedMsg
							(not ((ScriptID 80 0) tstFlag: #rFlag2 flagNum)) ; rgCastle
						)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm770 of CastleRoom
	(properties
		noun 3
		picture 770
		style 10
		south 710
		vanishingX 110
		vanishingY 98
		minScaleSize 55
		maxScaleSize 107
		minScaleY 126
		maxScaleY 154
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 771 770)
		((ScriptID 81 0) clrFlag: #rFlag1 1 2) ; RgBasement
		(if (gCast contains: (ScriptID 80 5)) ; guard1
			((ScriptID 80 5) dispose:) ; guard1
		)
		(if (gCast contains: (ScriptID 80 6)) ; guard2
			((ScriptID 80 6) dispose:) ; guard2
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 15 179 6 189 0 189 0 -10 319 -10 319 189 307 189 285 179 263 179 213 151 225 151 202 141 187 141 163 128 82 128 71 139 55 139 48 148 66 148 37 179
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 172 144 160 150 132 153 106 151 90 143 106 137 155 137
					yourself:
				)
		)
		(gFeatures
			add:
				coatOfArms
				goldenFleece
				oakTree
				singingStone
				table
				roomFeatures
				skyLight
			eachElementDo: #init
		)
		(if ((ScriptID 80 0) tstFlag: #rFlag3 512) ; rgCastle
			((ScriptID 80 0) weddingRemind: 0) ; rgCastle
		)
		(if (not ((ScriptID 80 0) tstFlag: #rFlag1 8)) ; rgCastle
			(drape cel: 0 posn: 136 145 14 init: stopUpd:)
		else
			(drape cel: 1 posn: 95 141 0 init: stopUpd:)
		)
		(gEgo
			init:
			posn: 148 184
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		((gEgo scaler:) doit:)
		(if (not (SetFlag 85))
			(gGame givePoints: 2)
		)
		(gGlobalSound fadeTo: 770 -1)
		(self setScript: entryScript)
	)

	(method (dispose)
		(if ((ScriptID 80 0) tstFlag: #rFlag3 512) ; rgCastle
			((ScriptID 80 0) weddingRemind: 1) ; rgCastle
		)
		(super dispose:)
	)
)

(instance removeDrape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 1024)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag2 1024) ; rgCastle
					(gMessager say: 4 5 6 0 self) ; "Alexander pulls the drapery aside, curious as to what might lie underneath."
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					normal: 0
					setScale: 0
					view: 771
					loop: 0
					cel: 0
					cycleSpeed: 10
					posn: 105 148
					setCycle: End self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(drape hide:)
				(gEgo loop: 1 cel: 0 posn: 104 148 setCycle: End self)
			)
			(4
				(drape posn: 95 141 0 cel: 1 show: stopUpd:)
				(gEgo loop: 2 cel: 0 posn: 92 150 setCycle: End self)
			)
			(5
				(= seconds 2)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo posn: (drape approachX:) (drape approachY:) reset: 6)
				((ScriptID 80 0) setFlag: #rFlag1 8) ; rgCastle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance replaceDrape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) clrFlag: #rFlag1 8) ; rgCastle
				(drape hide: posn: 136 145 14 cel: 0)
				(gEgo
					normal: 0
					view: 771
					setScale: 0
					loop: 3
					cel: 0
					cycleSpeed: 8
					posn: 104 148
					setCycle: End self
				)
			)
			(1
				(drape show: stopUpd:)
				(gEgo posn: (drape approachX:) (drape approachY:) reset: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drape of Prop
	(properties
		x 136
		y 145
		z 14
		noun 4
		approachX 95
		approachY 148
		view 770
		priority 11
		signal 4112
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 ignoreActors: 1) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 8)) ; rgCastle
					(roomConv add: -1 noun theVerb 2) ; "A small table graces the middle of the room. The table is covered by a velvet drapery."
				else
					(roomConv add: -1 noun theVerb 3) ; "The velvet drapery has been pulled back, exposing the table's items."
				)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 256)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag1 256) ; rgCastle
					(roomConv add: -1 noun theVerb 4) ; "A.A.? That must stand for Abdul Alhazred!"
				)
				(roomConv init:)
			)
			(5 ; Do
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 8)) ; rgCastle
					(gCurRoom setScript: removeDrape)
				else
					(gCurRoom setScript: replaceDrape)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coatOfArms of StolenItem
	(properties
		y 144
		noun 8
		onMeCheck 2
		look1stSeq 19
		handLookedMsg 21
		flagNum 4096
	)
)

(instance goldenFleece of StolenItem
	(properties
		y 144
		noun 6
		onMeCheck 4
		look1stSeq 11
		handLookedMsg 13
		flagNum 8192
	)
)

(instance oakTree of StolenItem
	(properties
		y 144
		noun 5
		onMeCheck 8
		look1stSeq 7
		handLookedMsg 9
		flagNum 16384
	)
)

(instance singingStone of StolenItem
	(properties
		y 144
		noun 7
		onMeCheck 16
		look1stSeq 15
		handLookedMsg 17
		flagNum -32768
	)
)

(instance table of Feature
	(properties
		y 144
		noun 9
		onMeCheck 32
	)

	(method (onMe param1)
		(= x (param1 x:))
		(return (super onMe: param1))
	)
)

(instance skyLight of Feature
	(properties
		x 160
		y 144
		noun 14
		onMeCheck 1024
	)
)

(instance roomFeatures of Feature
	(properties)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(= x (param1 x:))
		(return
			(or
				(and (& temp0 $0200) (= noun 11) (= y 161))
				(and (& temp0 $0100) (= noun 13) (= y 177))
				(and
					(& temp0 $0080)
					(= noun 10)
					(or (and (> x 190) (= y 145)) (= y 125))
				)
				(and (& temp0 $0040) (= noun 12) (= y 138))
				0
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance entryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

