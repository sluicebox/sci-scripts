;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64007)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use soFlashCyberSniff)
(use Talker)
(use PolyPath)
(use Feature)
(use StopWalk)
(use Grooper)
(use Ego_64988)
(use Motion)
(use Actor)
(use System)

(public
	ego 0
	toLarryTalker 1
	GetActorLoop 2
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6 = 1
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(procedure (GetActorLoop param1)
	(if (or (not argc) (not param1) (not (param1 isKindOf: Actor)))
		(PrintDebug {Bad call of GetActorLoop. L7Ego.sc. djm})
		(return 0)
	)
	(if (< (param1 loop:) 8)
		(return (param1 loop:))
	else
		(return (param1 cel:))
	)
)

(instance toLarryTalker of Talker
	(properties)

	(method (init &tmp temp0 temp1)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= priority (+ (gEgo priority:) 1))
		(if (== (= temp0 (GetActorLoop gEgo)) 3)
			(return)
		)
		(switch temp0
			(0
				(= view 60110)
				(= loop 2)
				(= temp1 0)
			)
			(1
				(= view 60110)
				(= loop 3)
				(= temp1 1)
			)
			(2
				(= view 60111)
				(= loop 1)
				(= temp1 0)
			)
			(4
				(= view 60112)
				(= loop 2)
				(= temp1 0)
			)
			(5
				(= view 60112)
				(= loop 3)
				(= temp1 1)
			)
			(6
				(= view 60113)
				(= loop 2)
				(= temp1 0)
			)
			(7
				(= view 60113)
				(= loop 3)
				(= temp1 1)
			)
		)
		(gEgo hide:)
		(voTalkBody view: (self view:))
		(voTalkBody loop: temp1)
		(voTalkBody init:)
		(super init: &rest)
		(mouth
			scaleSignal: 1
			scaleX: (gEgo scaleX:)
			scaleY: (gEgo scaleY:)
			maxScale: (gEgo maxScale:)
		)
		(UpdateScreenItem mouth)
	)

	(method (dispose)
		(voTalkBody dispose:)
		(gEgo show:)
		(super dispose: &rest)
	)
)

(instance voTalkBody of View
	(properties)

	(method (init)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(self setPri: (gEgo priority:))
		(self
			scaleSignal: 1
			scaleX: (gEgo scaleX:)
			scaleY: (gEgo scaleY:)
			maxScale: (gEgo maxScale:)
		)
		(super init: &rest)
	)
)

(instance poNull of Prop
	(properties)
)

(instance poNull2 of Prop
	(properties)
)

(instance soWalkScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local4
					(= local2 1)
					(gEgo
						setHeading:
							(GetAngle
								(* (gEgo x:) 4)
								(* (gEgo y:) 5)
								(* local0 4)
								(* local1 5)
							)
							self
					)
				else
					(self cue:)
				)
			)
			(1
				(= local2 2)
				(= local3 (GetActorLoop gEgo))
				(if local4
					(gEgo view: 60115 loop: local3 cel: 0 setCycle: End self)
					(UpdateScreenItem gEgo)
				else
					(self cue:)
				)
			)
			(2
				(= local2 3)
				(gEgo view: 60100 loop: local3 cel: 0 setCycle: StopWalk -1)
				(if local6
					(gEgo setMotion: PolyPath local0 local1 self)
				else
					(gEgo setMotion: MoveTo local0 local1 self)
				)
				(UpdateScreenItem gEgo)
			)
			(3
				(= local3 (GetActorLoop gEgo))
				(= local2 4)
				(if local5
					(gEgo view: 60120 loop: local3 cel: 0 setCycle: End self)
					(UpdateScreenItem gEgo)
				else
					(self cue:)
				)
			)
			(4
				((ScriptID 60 0) setReal: (ScriptID 60 0) 60) ; oFidgetTimer, oFidgetTimer
				(= local2 0)
				(gEgo view: 60100 loop: 8 cel: local3 setCycle: StopWalk -1)
				(UpdateScreenItem gEgo)
				(if (and caller (== gNewRoomNum gCurRoomNum))
					(= temp0 caller)
					(= caller 0)
					(self dispose:)
					(temp0 cue: register)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance soWalkAndSay of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo walkTo: local0 local1 self)
			)
			(1
				(= local13 (gUser canControl:))
				(gGame handsOff:)
				(gEgo setHeading: local12 self)
			)
			(2
				(gMessager say: local8 local9 local10 local11 self local7)
			)
			(3
				(if local13
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance soApproachThenDo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(local14 approachX:)
							(local14 approachY:)
						)
						(local14 approachDist:)
					)
					(gEgo
						walkTo: (local14 approachX:) (local14 approachY:) self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo face: local14 self)
			)
			(2
				(local14 doVerb: local9 1)
				(self dispose:)
			)
		)
	)
)

(instance soFaceThenDo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gEgo face: local14 self)
			)
			(1
				(local14 doVerb: local9 1)
				(self dispose:)
			)
		)
	)
)

(instance oWalkFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsTop (= nsLeft 0))
		(= nsRight (plane getWidth:))
		(= nsBottom (plane getHeight:))
		(self myPriority: -1)
	)

	(method (dispose)
		(super dispose: &rest)
		(= plane 0)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser canControl:)
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				gEgo
				(gEgo plane:)
				(gEgo isNotHidden:)
				((gEgo plane:) isEnabled:)
			)
			(event localize: (gEgo plane:))
			(event type: $5000) ; evVERB | evMOVE
			(gEgo setScript: 0)
			(proc64896_12 gEgo)
			(if (== gCurRoomNum 363) ; ro363
				((ScriptID 64017 0) set: 205) ; oFlags
				(gCurRoom notify:)
			else
				(gEgo handleEvent: event)
			)
			(event claimed: 0)
		)
		(return 0)
	)
)

(class LarryEgo of Ego
	(properties
		oMyVerbHandlers 0
		oCantBeHereHandler 0
	)

	(method (addVerbHandler param1)
		(if (not oMyVerbHandlers)
			(= oMyVerbHandlers (Set new:))
		)
		(oMyVerbHandlers addToFront: param1)
	)

	(method (deleteVerbHandler param1)
		(if oMyVerbHandlers
			(oMyVerbHandlers delete: param1)
		)
	)

	(method (cantBeHere)
		(if oCantBeHereHandler
			(oCantBeHereHandler doit:)
		else
			(super cantBeHere:)
		)
	)

	(method (dispose)
		(if oMyVerbHandlers
			(oMyVerbHandlers dispose:)
			(= oMyVerbHandlers 0)
		)
		(if oCantBeHereHandler
			(oCantBeHereHandler dispose:)
			(= oCantBeHereHandler 0)
		)
		(super dispose: &rest)
	)

	(method (checkVerbHandlers &tmp temp0 temp1)
		(if oMyVerbHandlers
			(for
				((= temp0 (oMyVerbHandlers first:)))
				temp0
				((= temp0 (oMyVerbHandlers next: temp0)))
				
				(if (and (= temp1 (KList 8 temp0)) (temp1 doVerb: &rest)) ; NodeValue
					(return 1)
				)
			)
		)
		(return 0)
	)
)

(class VerbHandler of Obj
	(properties)

	(method (doVerb))
)

(instance ego of LarryEgo
	(properties
		noun 1
		modNum 60
		view 60100
		yStep 5
		xStep 11
	)

	(method (init)
		(super init: &rest)
		(oWalkFeature init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 83)
		(if global215
			(self addHotspotVerb: 11)
		)
		((ScriptID 60 0) setReal: (ScriptID 60 0) 60) ; oFidgetTimer, oFidgetTimer
	)

	(method (dispose)
		(if (oWalkFeature plane:)
			(oWalkFeature dispose:)
		)
		(if (poNull script:)
			(poNull setScript: 0)
		)
		(if (poNull2 script:)
			(poNull2 setScript: 0)
		)
		(proc64896_12 gEgo)
		(super dispose: &rest)
	)

	(method (getName)
		(MakeMessageText noun 68 0 1 modNum)
	)

	(method (doVerb theVerb)
		(if (not (self checkVerbHandlers: theVerb))
			(switch theVerb
				(76 ; Burp
					(gMessager say: noun theVerb (Random 2 3) 0 0 modNum)
				)
				(11 ; Fart
					(cond
						(
							(or
								(not (gCast contains: gEgo))
								(!= (gEgo view:) 60100)
							)
							(gGame setScript: soMotionlessFart)
						)
						(
							(and
								(not ((ScriptID 64017 0) test: 87)) ; oFlags
								global215
								(== gCurRoomNum 370) ; ro370
								(> (gEgo y:) 200)
							)
							(gCurRoom cue:)
						)
						(else
							(gGame setScript: soFart)
						)
					)
				)
				(1 ; Look
					(gMessager say: noun theVerb 0 0 0 modNum) ; "Wow. Do I look hot or what?!"
				)
				(93 ; Shit
					(gMessager say: noun theVerb (Random 2 4) 0 0 modNum)
				)
				(208 ; Sneeze
					(gMessager say: noun theVerb (Random 2 4) 0 0 modNum)
				)
				(83 ; Undress
					(cond
						((and (== gCurRoomNum 550) ((ScriptID 64017 0) test: 186)) ; ro550, oFlags
							(gMessager say: noun theVerb 25 0 0 modNum) ; "Figure out some way to get Drew out of that shower and you just might do that!"
						)
						((== gCurRoomNum 550) ; ro550
							(gMessager say: noun theVerb 24 0 0 modNum) ; "This may be your room, but you don't need a shower right now."
						)
						(else
							(gMessager say: noun theVerb (Random 2 3) 0 0 modNum)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (walkTo param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (< argc 3)
			(= temp0 0)
		else
			(= temp0 param3)
		)
		(if (< argc 4)
			(= local4 1)
		else
			(= local4 param4)
		)
		(if (< argc 5)
			(= local5 1)
		else
			(= local5 param5)
		)
		(if (< argc 6)
			(= local6 1)
		else
			(= local6 param6)
		)
		(= local0 param1)
		(= local1 param2)
		(gEgo setMotion: 0)
		(if (and (== local0 (gEgo x:)) (== local1 (gEgo y:)))
			(if temp0
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: temp0 yourself:))
			)
			(return)
		)
		(gEgo normalize: (GetActorLoop gEgo) 1)
		(proc64896_12 soWalkScript)
		(soWalkScript caller: 0)
		(soWalkScript client: 0)
		(poNull setScript: soWalkScript temp0)
	)

	(method (walkAndSay param1 param2 param3 param4 param5 param6 param7 param8)
		(if (< argc 5)
			(PrintDebug {Illegal call of walkAndSay})
			(return)
		)
		(= local0 param1)
		(= local1 param2)
		(= local12 param3)
		(= local8 param4)
		(= local9 param5)
		(= local10 (if (> argc 5) param6 else 0))
		(= local11 (if (> argc 6) param6 else 0))
		(= local7 (if (> argc 7) param8 else gCurRoomNum))
		(poNull2 setScript: soWalkAndSay)
	)

	(method (approachThenDo param1 param2)
		(= local14 param1)
		(= local9 param2)
		(poNull2 setScript: soApproachThenDo)
	)

	(method (faceThenDo param1 param2)
		(= local14 param1)
		(= local9 param2)
		(poNull2 setScript: soFaceThenDo)
	)

	(method (normalize param1 param2 param3)
		(if argc
			(self loop: param1)
		else
			(self loop: 2)
		)
		(= heading
			(switch loop
				(0 90)
				(1 270)
				(2 180)
				(3 0)
				(4 135)
				(5 225)
				(6 45)
				(7 315)
			)
		)
		(if (not (and (> argc 1) param2))
			(self
				oldScaleX: 128
				scaleX: 128
				scaleY: 128
				setScale: 0
				setScaler: 0
				setStep: 11 5
			)
		)
		(self
			view: (if (> argc 2) param3 else 60100)
			z: 0
			setMotion: 0
			setLooper: Grooper
			setLoop: -1
			setPri: -1
			illegalBits: 0
			setCycle: StopWalk -1
			setSpeed: (gGame nGameSpeed:)
			state: (|= state $0002)
			edgeHit: EDGE_NONE
			ignoreActors: 1
		)
	)
)

(instance soFart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo moveSpeed:))
				(gEgo setSpeed: 7)
				(if global215
					((ScriptID 64017 0) set: 16) ; oFlags
				)
				(if (< global215 3)
					(gEgo setHeading: 135 self)
				else
					(gEgo setHeading: 180 self)
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(switch global215
					(0
						(gEgo view: 6000 loop: 0 cel: 0 setCycle: End self)
						(oFartSFX playSound: 37401 self)
					)
					(1
						(gEgo view: 6000 loop: 0 cel: 0 setCycle: End self)
						(oFartSFX playSound: 37403 self)
					)
					(2
						(gEgo view: 6011 loop: 0 cel: 0 setCycle: End self)
						(oFartSFX playSound: 37404 self)
					)
					(else
						(gEgo view: 6012 loop: 0 cel: 0 setCycle: End self)
						(oFartSFX playSound: 37405 self)
					)
				)
			)
			(3 0)
			(4
				(if (< global215 3)
					(gEgo normalize: 4 1)
				else
					(gEgo normalize: 2 1)
				)
				((ScriptID 64017 0) clear: 68) ; oFlags
				(switch global215
					(3
						(proc64896_15 5 0)
						(gMessager say: 1 11 6 0 self 60) ; "Mayday! Mayday! Mayday!! Man overboard."
					)
					(2
						(proc64896_15 5 0)
						(gMessager say: 1 11 5 0 self 60) ; "Whew! That could clean your hull of barnacles!"
					)
					(1
						(proc64896_15 5 0)
						(gMessager say: 1 11 1 0 self 60) ; "Wow! That bean dip is really effective!"
					)
					(else
						(gMessager say: 1 11 (Random 2 3) 0 self 60)
					)
				)
				(gEgo deleteHotspotVerb: 11 setSpeed: register)
				(= global215 0)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMotionlessFart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if global215
					((ScriptID 64017 0) set: 16) ; oFlags
				)
				(switch global215
					(0
						(oFartSFX playSound: 37401 self)
					)
					(1
						(oFartSFX playSound: 37403 self)
					)
					(2
						(oFartSFX playSound: 37404 self)
					)
					(else
						(oFartSFX playSound: 37405 self)
					)
				)
			)
			(1
				((ScriptID 64017 0) clear: 68) ; oFlags
				(switch global215
					(3
						(proc64896_15 5 0)
					)
					(2
						(proc64896_15 5 0)
					)
					(1
						(proc64896_15 5 0)
					)
				)
				(if (gCast contains: gEgo)
					(gEgo deleteHotspotVerb: 11)
				)
				(= global215 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oFartSFX of TPSound
	(properties)
)

