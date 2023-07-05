;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use verseScript)
(use Polygon)
(use Feature)
(use User)
(use Actor)
(use System)

(public
	handCode 0
)

(local
	[local0 15]
	local15
	[local16 6]
	[local22 15]
	local37
	local38
	local39
	local40
	local41
	[local42 53] = [{BIRCH} {ROWAN} {ASH} {ALDER} {HOLLY} {HAZEL} {ELDER} {OAK} {WILLOW} {BLACKBERRY} {IVY} {BETH} {LUIS} {NION} {FEARN} {TINNE} {COLL} {RUIS} {DUIR} {SAILLE} {MUIN} {GORT} {WOOD} {TREE} {SNOW} {SNOWFLAKE} {SNOWFLAKES} {FEATHER} {FEATHERS} {BEEHIVE} {BEEHIVES} {HIVE} {HIVES} {FUR} {FURS} {SKIN} {SKINS} {PELT} {PELTS} {LEATHER} {COMB} {COMBS} {CHEESE} {CHEESES} {COIN} {COINS} {PENNY} {PENNIES} {MONEY} {EYE} {EYES} {EYEBALL} {EYEBALLS}]
	[local95 10] = [{LIONS} {SWORD} {CROWN} {HEART} {STEED} {VOYAGE} {TORCH} {RANSOM} {LIEGE} {BLOOD}]
	[local105 28] = [133 112 151 112 152 92 166 92 166 87 180 87 181 89 182 90 195 90 197 88 211 88 200 151 156 151 141 133]
	local133 = { CS BLHFTNDGQPZ  OU EIRMKVJXAWY}
	local134
	local135
	local136
	local137
	local138
	local139
)

(procedure (localproc_0)
	(-- local37)
	(Display 213 0 dsRESTOREPIXELS local39)
	(if (== local37 0)
		(= local37 (= local0 0))
	else
		(StrAt @local0 local37 0)
		(= local39 (Display @local0 dsCOORD 115 35 dsCOLOR global187 dsBACKGROUND global186 dsSAVEPIXELS))
	)
)

(procedure (localproc_1 param1)
	(++ local37)
	(Display 213 0 dsRESTOREPIXELS local39)
	(if (>= local37 13)
		(StrCpy @local22 @local0)
		(= local37 (= local0 0))
	else
		(StrCat @local0 param1)
		(= local39 (Display @local0 dsCOORD 115 35 dsCOLOR global187 dsBACKGROUND global186 dsSAVEPIXELS))
	)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 53) ((++ temp0))
		(if (== (StrCmp @local22 [local42 temp0]) 0)
			(= global124 temp0)
			(= temp1 1)
			(break)
		)
	)
	(if (== (StrCmp @local22 local15) 0)
		(SetFlag 67)
		(= temp1 1)
	)
	(if (== temp1 0)
		(= global124 55)
	)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(= temp1 22)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(if (== global140 temp1)
			(= local15 [local95 temp0])
		)
		(++ temp1)
	)
)

(procedure (localproc_4 param1 param2)
	(gCast eachElementDo: #perform hideMe)
	(= local134 gCast)
	(= local135 gFeatures)
	(= local136 gAddToPics)
	(= local137 gMouseDownHandler)
	(= local139 gKeyDownHandler)
	(= local138 gDirectionHandler)
	(= gMouseDownHandler
		(= gKeyDownHandler (= gDirectionHandler (= gCast (= gFeatures (= gAddToPics 0)))))
	)
	(DrawPic param1 param2)
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	((= gMouseDownHandler newMH) add: gFeatures)
	((= gKeyDownHandler newKH) add: gFeatures)
	((= gDirectionHandler newDH) add: gFeatures)
)

(procedure (localproc_5)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures dispose:)
	(gMouseDownHandler dispose:)
	(gKeyDownHandler dispose:)
	(gDirectionHandler dispose:)
	(DrawPic (gCurRoom picture:) 10)
	(= gCast local134)
	(= gFeatures local135)
	((= gAddToPics local136) doit:)
	(= gMouseDownHandler local137)
	(= gKeyDownHandler local139)
	(= gDirectionHandler local138)
	(gCast eachElementDo: #perform showMe)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMH of EventHandler
	(properties)
)

(instance newKH of EventHandler
	(properties)
)

(instance newDH of EventHandler
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

(instance handCode of Code
	(properties)

	(method (doit)
		(= local41 gTheCursor)
		(ClearFlag 67)
		(HandsOff)
		(gTheIconBar disable: 8)
		(= local40 gUseSortedFeatures)
		(localproc_4 213 10)
		(SetFlag 115)
		(pointHand posn: 180 125 init:)
		(polyLetter points: @local105)
		(AddToFeatures letter clear letterbox behindTheHand)
		(localproc_3)
		(= local0 0)
		(gGame setCursor: 5 1 180 125)
		(User canInput: 1)
	)

	(method (dispose)
		(localproc_5)
		(= gUseSortedFeatures local40)
		(gGame setCursor: local41 1 180 125)
		(gTheIconBar enable: 8)
		(super dispose:)
		(ClearFlag 115)
		(SetFlag 110)
		(DisposeScript 213)
	)
)

(instance pointHand of Actor
	(properties
		x 180
		y 125
		view 182
		loop 1
		priority 15
		signal 26640
		illegalBits 0
	)

	(method (doit)
		(self posn: gMouseX (- gMouseY 10))
		(super doit:)
	)
)

(instance polyLetter of Polygon
	(properties
		size 14
	)
)

(instance behindTheHand of Feature
	(properties
		nsTop 45
		nsLeft 67
		nsBottom 152
		nsRight 249
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
		)
	)
)

(instance letter of Feature
	(properties)

	(method (handleEvent event &tmp temp0 [temp1 2])
		(if
			(and
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(& (= local38 (OnControl CONTROL (event x:) (event y:))) $ffee)
			)
			(event claimed: 1)
			(= temp0 -1)
			(while (and (not (& local38 $0001)) (< temp0 16))
				(++ temp0)
				(>>= local38 $0001)
			)
			(= local38 temp0)
			(if (AvoidPath (event x:) (event y:) polyLetter)
				(+= local38 16)
			)
			(if (== local38 16)
				(= local37 13)
				(localproc_1 0)
				(localproc_2)
				(HandsOn)
				(handCode dispose:)
			else
				(StrAt @temp1 0 (StrAt local133 local38))
				(StrAt @temp1 1 0)
				(localproc_1 @temp1)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance clear of Feature
	(properties
		nsBottom 189
		nsRight 319
		onMeCheck 16
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (InRect 114 35 201 45 event))
				(self onMe: event)
			)
			(event claimed: 1)
			(if (> local0 0)
				(= local37 13)
				(localproc_1 temp0) ; UNINIT
				(HandsOn)
			else
				(= local0 0)
				(HandsOn)
			)
			(handCode dispose:)
		else
			(super handleEvent: event)
		)
	)
)

(instance letterbox of Feature
	(properties
		nsTop 15
		nsLeft 95
		nsBottom 42
		nsRight 225
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(self onMe: event)
			)
			(event claimed: 1)
			(if local37
				(localproc_0)
			)
			(super handleEvent: event)
		)
	)
)

