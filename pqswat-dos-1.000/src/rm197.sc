;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 197)
(include sci.sh)
(use Main)
(use PQRoom)
(use swatInvInit)
(use BulletDrawCel)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm197 0
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
)

(procedure (localproc_0)
	(DoAudio 18 1) ; AudDACCritical
	((Sound new:) number: 50 setLoop: 0 play:)
	(DoAudio 18 0) ; AudDACCritical
)

(class TimedHit of Timer
	(properties
		popperTarg 0
		hitCount 0
	)

	(method (setHit param1)
		(if (!= popperTarg param1)
			(= hitCount 0)
			(= popperTarg param1)
		)
		(++ hitCount)
		(self setTicks: self 45)
		(return hitCount)
	)

	(method (cue)
		(if (-- hitCount)
			(self setTicks: self 45)
		)
	)
)

(class Popper of Actor
	(properties
		priority 300
		fixPriority 1
		cycleSpeed 2
		twoShotLine 0
		threeShotLine 0
		fourShotLine 0
	)

	(method (init &tmp temp0 temp1)
		(= cel (self lastCel:))
		(super init: &rest)
		(= nsBottom 252)
		(= temp1
			(/
				(* (= temp0 (- (CelHigh view loop 0) (Abs (- nsBottom y)))) 25)
				100
			)
		)
		(= twoShotLine (- nsBottom (* temp1 3)))
		(= threeShotLine (- nsBottom (* temp1 2)))
		(= fourShotLine (- nsBottom (* temp1 1)))
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if
			(and
				(= temp0 (super onMe: param1))
				(OneOf (param1 message:) 6 7 8 10)
			)
			(= temp1 (timedHit setHit: self))
			(if
				(or
					(> (param1 y:) nsBottom)
					(and (> (param1 y:) twoShotLine) (< temp1 2))
					(and (> (param1 y:) threeShotLine) (< temp1 3))
					(and (> (param1 y:) fourShotLine) (< temp1 4))
				)
				(= temp0 0)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 7 8 10)
			(if (== theVerb 6)
				(localproc_0)
			)
			(if (and (not cel) (not cycler))
				(++ local0)
				(++ local2)
				(self setCycle: End self)
			)
			(if (!= theVerb 6)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (cue)
		(gFxSound number: 19921 setLoop: 1 play:)
	)
)

(class PresidentePopper of Prop
	(properties
		priority 300
		fixPriority 1
		shotOne 0
		shotTwo 0
		bulletBitmap 0
		haveACycler 0
	)

	(method (init)
		(= cel 26)
		(self setShots:)
		(super init: &rest)
	)

	(method (dispose)
		(self tossBitmap:)
		(super dispose: &rest)
	)

	(method (tossBitmap)
		(if bulletBitmap
			(bulletBitmap dispose:)
			(= bulletBitmap 0)
		)
	)

	(method (doit)
		(if (and cycler bulletBitmap)
			(= haveACycler 1)
			(if (>= (Abs (- gGameTime (cycler cycleCnt:))) cycleSpeed)
				(bulletBitmap
					y: (+ (bulletBitmap y:) 3)
					nsTop: (+ (bulletBitmap nsTop:) 3)
					nsBottom: (+ (bulletBitmap nsBottom:) 3)
				)
				(UpdateScreenItem bulletBitmap)
			)
		)
		(if (and (not cycler) haveACycler)
			(= haveACycler 0)
			(self tossBitmap:)
		)
		(super doit:)
	)

	(method (setupShots))

	(method (setShots param1 param2)
		(= shotOne (= shotTwo 0))
		(if argc
			(= shotOne param1)
			(if (> argc 1)
				(= shotTwo param2)
			)
		)
	)

	(method (checkShot &tmp temp0)
		(if (not (= temp0 (OneOf global135 shotOne shotTwo)))
			(= local5 1)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(OneOf (event message:) JOY_DOWNLEFT JOY_LEFT JOY_UPLEFT $000a)
			)
			(if (== (event message:) JOY_DOWNLEFT)
				(localproc_0)
			)
			(if (not bulletBitmap)
				(= bulletBitmap ((presBitmap new:) init: self yourself:))
			)
			(bulletBitmap drawCel: event)
			(if (not shotOne)
				(self setupShots:)
			)
			(if (and (not local5) (self checkShot:))
				(++ local0)
				(++ local2)
				(if (== local0 6)
					(presPop1 setShots:)
					(presPop2 setShots:)
					(presPop3 setShots:)
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance presBitmap of BulletDrawCel
	(properties)

	(method (init param1)
		(= x (param1 x:))
		(= y (param1 y:))
		(= nsLeft (param1 nsLeft:))
		(= nsTop (param1 nsTop:))
		(= nsRight (param1 nsRight:))
		(= nsBottom (param1 nsBottom:))
		(super init: &rest)
		(self setPri: (+ (param1 priority:) 1))
	)

	(method (drawCel param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (((gSwatInterface curInvItem:) data:) bulletType:))
		(= temp0 1998)
		(= temp1
			(cond
				((!= (gSwatInterface curInvItem:) (proc19_3 4)) 3)
				((== (((gSwatInterface curInvItem:) data:) bulletType:) 3) 4)
				(else 3)
			)
		)
		(= temp2 0)
		(super drawCel: param1 temp0 temp1 0)
		(param1 claimed: (gCurRoom script:))
	)
)

(class CombatPopper of Actor
	(properties
		cycleSpeed 0
		active 0
		bulletList 0
		showBullets 0
	)

	(method (init)
		(|= signal $0800)
		(super init: &rest)
	)

	(method (setupDrill))

	(method (clearDrill))

	(method (dispose)
		(if bulletList
			(if (== gCurRoomNum gNewRoomNum)
				(bulletList dispose:)
			else
				(bulletList release: dispose:)
			)
			(= bulletList 0)
		)
		(super dispose: &rest)
	)

	(method (rotate param1)
		(if (or (not argc) param1)
			(= showBullets (= active 1))
			(if (or (not cycler) (not cel))
				(self setCycle: End self)
			)
		else
			(= showBullets (= active 0))
			(if bulletList
				(bulletList eachElementDo: #dispose release: dispose:)
				(= bulletList 0)
			)
			(if (or (not cycler) cel)
				(self setCycle: Beg)
			)
		)
	)

	(method (cue)
		(popperTimer setTicks: popperTimer 60)
	)

	(method (onMe param1)
		(return (and active (super onMe: param1)))
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(OneOf (event message:) JOY_DOWNLEFT JOY_LEFT JOY_UPLEFT $000a)
			)
			(if (== (event message:) JOY_DOWNLEFT)
				(localproc_0)
			)
			(if showBullets
				(if (not bulletList)
					((= bulletList (Set new:)) add:)
				)
				(bulletList add: (bulletView new: event))
			)
			(++ local0)
			(++ local2)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance bulletView of View
	(properties
		view 1998
		loop 4
	)

	(method (new param1 &tmp temp0 temp1 temp2)
		(if (and (IsFlag 43) local6)
			(= temp1 (+ (local6 priority:) 1))
		else
			(= temp1 301)
		)
		(= temp2
			(cond
				((!= (gSwatInterface curInvItem:) (proc19_3 4)) 3)
				((== (((gSwatInterface curInvItem:) data:) bulletType:) 3) 4)
				(else 3)
			)
		)
		(= temp0 (super new:))
		(temp0
			posn: (param1 x:) (param1 y:)
			setPri: temp1
			setLoop: temp2
			cel: (Random 0 1)
			init:
		)
		(return temp0)
	)
)

(instance rm197 of PQRoom
	(properties
		picture 199
		infoRoomSignal 136
	)

	(method (init)
		(SetFlag 12)
		(SetFlag 15)
		(SetFlag 71)
		(ClearFlag 46)
		(super init: &rest)
		(Load rsAUDIO 50)
		(Load rsAUDIO 19921)
		(popper1 init:)
		(popper2 init:)
		(popper3 init:)
		(popper4 init:)
		(popper5 init:)
		(presPop1 init:)
		(presPop2 init:)
		(presPop3 init:)
		(combatP1 init:)
		(combatP2 init:)
		(combatP3 init:)
		(combatP4 init:)
		(combatP5 init:)
		(combatP6 init:)
		(combatP7 init:)
		(combatP8 init:)
		(combatP9 init:)
		(combatP10 init:)
		(combatP11 init:)
		(drillManager doit:)
		(if (not (IsFlag 19))
			(gMessager say: 1 0 1 0) ; "With .45's... Make Ready and draw to the guard!"
		else
			(gMessager say: 2 0 1 0) ; "With .45's... Make Ready and draw to the guard!"
		)
	)

	(method (doit)
		(super doit:)
		(if (gGame script:)
			(= local9 1)
		)
	)

	(method (newRoom newRoomNumber)
		(= global133 0)
		(= global114 0)
		(ClearFlag 12)
		(if (gFxSound client:)
			(gFxSound client: 0)
		)
		(if (gCast contains: (ScriptID 50 0)) ; PactTimer
			((ScriptID 50 0) dispose:) ; PactTimer
		)
		(if (and (not local9) (!= newRoomNumber 15)) ; mainMenu
			(if (!= newRoomNumber 196)
				(= global125 newRoomNumber)
				(SetFlag 46)
				(ClearFlag 71)
				(SetFlag 68)
				(if (not local7)
					(SetFlag 41)
				)
			)
			(super newRoom: 196)
		else
			(Lock rsAUDIO 19501 0)
			(gBackMusic fade: 0 2 21 1)
			(super newRoom: newRoomNumber)
		)
	)

	(method (dispose &tmp temp0 temp1)
		(= temp0 0)
		(if (and local1 (> (= temp1 (- local2 local4)) 0))
			(= temp0 (/ (* temp1 100) local1))
		)
		(cond
			((>= temp0 90)
				(SetFlag 59)
			)
			((>= temp0 80)
				(SetFlag 60)
			)
			((>= temp0 70)
				(SetFlag 61)
			)
			(else
				(SetFlag 62)
			)
		)
		(timedHit dispose: delete:)
		(popperTimer dispose: delete:)
		(drillTimer dispose: delete:)
		(DoAudio 18 0) ; AudDACCritical
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(localproc_0)
				(if (not script)
					(gCurRoom setScript: followDrills 0 0)
				)
			)
			(7
				(if (not script)
					(gCurRoom setScript: followDrills 0 0)
				else
					(super doVerb: theVerb)
				)
			)
			(10
				(if (not script)
					(gCurRoom setScript: followDrills 0 0)
				else
					(super doVerb: theVerb)
				)
			)
			(8
				(if (not script)
					(gCurRoom setScript: followDrills 0 0)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance combatDrill of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local8 (< gMouseY local8))
			(SetCursor gMouseX local8)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: (ScriptID 50 0)) ; PactTimer
					((ScriptID 50 0) dispose:) ; PactTimer
				)
				(combatP1 setupDrill:)
				(combatP2 setupDrill:)
				(combatP3 setupDrill:)
				(combatP4 setupDrill:)
				(combatP5 setupDrill:)
				(combatP6 setupDrill:)
				(combatP7 setupDrill:)
				(combatP8 setupDrill: self)
				(combatP9 setupDrill:)
				(combatP10 setupDrill:)
				(combatP11 setupDrill:)
			)
			(1
				(gGame handsOn:)
				(= global133 drillCode)
				(= global114 0)
				(= local7 1)
				(if (== (gSwatInterface curInvItem:) (proc19_3 0))
					(= seconds 3)
				else
					(= seconds 6)
				)
			)
			(2
				(if (!= (gSwatInterface curInvItem:) (proc19_3 0))
					(cond
						(
							(OneOf
								(gSwatInterface curInvItem:)
								(proc19_3 3)
								(proc19_3 4)
								(proc19_3 21)
							)
							(if (not (IsFlag 19))
								(gMessager say: 1 0 5 0 self) ; "Officer, you've chosen the incorrect weapon for this drill.  With your .45, please make ready and draw to the guard!"
							else
								(gMessager say: 2 0 5 0 self) ; "This is a handgun drill. With your .45, please make ready and draw to the guard!"
							)
						)
						((not (IsFlag 19))
							(gMessager say: 1 0 6 0 self) ; "Officer, this is a weapons drill. With your .45, please make ready!"
						)
						(else
							(gMessager say: 2 0 6 0 self) ; "This is a weapons drill! With your .45, please make ready!"
						)
					)
					(-= state 2)
				else
					(gGame handsOff:)
					(= global133 0)
					(= local7 0)
					(self cue:)
				)
			)
			(3
				(= global133 drillCode)
				(= local0 (= global135 0))
				(= local8 260)
				(if (not (IsFlag 19))
					(gMessager say: 1 0 4 0 self) ; "This is the Combat Drill! There will be multiple moving targets - all bad guys. Reload as necessary. No par time; This is a reflex drill! On the whistle!"
				else
					(gMessager say: 2 0 4 0 self) ; "Combat Drill is up! There will be multiple moving targets - all bad guys! Reload as necessary. No par time, this is a reflex drill! On the whistle!"
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(gFxSound number: 21002 setLoop: 0 play: self)
			)
			(6
				(gGame handsOn:)
				(popperCode doit:)
				(= local8 0)
				(= seconds 21)
			)
			(7
				(gGame handsOff:)
				(gFxSound number: 21002 setLoop: 0 play: self)
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(if local6
					(local6 rotate: 0)
				)
			)
			(8
				(if (not (IsFlag 19))
					(gMessager say: 1 0 7 0 self) ; "Officers, guns to low-ready! Prepare to commence firing... Make Ready!"
				else
					(gMessager say: 2 0 7 0 self) ; "Guns at low-ready! Prepare to commence firing... Make Ready!"
				)
			)
			(9
				(= global133 0)
				(combatP5 clearDrill:)
				(combatP6 clearDrill:)
				(combatP7 clearDrill:)
				(combatP8 clearDrill: self)
			)
			(10
				(drillTimer setReal: drillTimer 5)
				(= local7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance combatCleanup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(combatP1 setupDrill:)
				(combatP2 setupDrill:)
				(combatP3 setupDrill:)
				(combatP4 setupDrill:)
				(combatP5 clearDrill:)
				(combatP6 clearDrill:)
				(combatP7 clearDrill:)
				(combatP8 clearDrill: self)
				(combatP9 setupDrill:)
				(combatP10 setupDrill:)
				(combatP11 setupDrill:)
			)
			(1
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance presidenteDrill of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local8 (< gMouseY local8))
			(SetCursor gMouseX local8)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 (= local0 (= global135 0)))
				(presPop1 setCycle: Beg self)
				(presPop2 setCycle: Beg)
				(presPop3 setCycle: Beg)
			)
			(1
				(gGame handsOn:)
				(= global133 drillCode)
				(= local7 1)
				(if (== (gSwatInterface curInvItem:) (proc19_3 0))
					(= seconds 3)
				else
					(= seconds 6)
				)
			)
			(2
				(if (!= (gSwatInterface curInvItem:) (proc19_3 0))
					(cond
						(
							(OneOf
								(gSwatInterface curInvItem:)
								(proc19_3 3)
								(proc19_3 4)
							)
							(if (not (IsFlag 19))
								(gMessager say: 1 0 5 0 self) ; "Officer, you've chosen the incorrect weapon for this drill.  With your .45, please make ready and draw to the guard!"
							else
								(gMessager say: 2 0 5 0 self) ; "This is a handgun drill. With your .45, please make ready and draw to the guard!"
							)
						)
						((not (IsFlag 19))
							(gMessager say: 1 0 6 0 self) ; "Officer, this is a weapons drill. With your .45, please make ready!"
						)
						(else
							(gMessager say: 2 0 6 0 self) ; "This is a weapons drill! With your .45, please make ready!"
						)
					)
					(-= state 2)
				else
					(= local7 0)
					(= global133 0)
					(gGame handsOff:)
					(= local8 260)
					(self cue:)
				)
			)
			(3
				(if (not (IsFlag 19))
					(gMessager say: 1 0 3 0 self) ; "The Presidente Drill is up! There are three target and multiple engagements. Starting from either the left or the right, shoot the first target once, second target once, third target twice, second target once and first target once. Speed load, then do it all again! Par time is ten seconds. On the whistle!"
				else
					(gMessager say: 2 0 3 0 self) ; "This is the Presidente Drill! Three targets and multiple engagements. Starting from either the left or the right, shoot the first target once, second target once, third target twice, second target once and first target once. Speed load, then repeat! Par time is ten seconds. On the whistle!"
				)
			)
			(4
				(= global133 drillCode)
				(= global114 okToShoot)
				(if (not (gCast contains: (ScriptID 50 0))) ; PactTimer
					((ScriptID 50 0) ; PactTimer
						view: 1990
						setLoop: 0
						setCel: 0
						posn: 110 91
						setPri: 480
						init:
					)
				)
				((ScriptID 50 0) clearClock: 1) ; PactTimer
				((ScriptID 50 0) shotsAllowed: 12 setPar: 100) ; PactTimer
				(= seconds 2)
			)
			(5
				(= local5 (= local0 (= global135 0)))
				(gFxSound number: 21002 setLoop: 0 play: self)
			)
			(6
				(gGame handsOn:)
				(= local8 0)
				((ScriptID 50 0) start: self) ; PactTimer
			)
			(7
				(gGame handsOff:)
				((ScriptID 50 0) caller: 0) ; PactTimer
				(if (not (IsFlag 19))
					(gMessager say: 1 0 7 0 self) ; "Officers, guns to low-ready! Prepare to commence firing... Make Ready!"
				else
					(gMessager say: 2 0 7 0 self) ; "Guns at low-ready! Prepare to commence firing... Make Ready!"
				)
			)
			(8
				(cond
					((not global135)
						(if (not (IsFlag 19))
							(gMessager say: 1 0 9 0 self) ; "This is a participatory drill, Officer! Cooperation on your part is required!"
						else
							(gMessager say: 2 0 9 0 self) ; "During training details, participation from all officers is mandatory!"
						)
					)
					(local5
						(if (not (IsFlag 19))
							(gMessager say: 1 0 10 0 self) ; "This is training, Officer! You will follow the drills, please!"
						else
							(gMessager say: 2 0 10 0 self) ; "All officers participating in training details are required to follow the assigned drills!"
						)
					)
					((< global135 ((ScriptID 50 0) shotsAllowed:)) ; PactTimer
						(if (not (IsFlag 19))
							(gMessager say: 1 0 11 0 self) ; "Officer, if you're experiencing a weapons malfunction clear it now; see the armorer later!"
						else
							(gMessager say: 2 0 11 0 self) ; "Participation is required of all officers during training details!"
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				(= global133 0)
				(presPop1 setCycle: End self setShots:)
				(presPop2 setCycle: End self setShots:)
				(presPop3 setCycle: End self setShots:)
			)
			(10 0)
			(11 0)
			(12
				((ScriptID 50 0) caller: 0 clearClock: 1) ; PactTimer
				((ScriptID 50 0) startDrillTimer: 5 chooseDrill) ; PactTimer
				(= local7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance presCleanup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(presPop1 setCycle: End self setShots:)
				(presPop2 setCycle: End self setShots:)
				(presPop3 setCycle: End self setShots:)
			)
			(1 0)
			(2 0)
			(3
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance dozierDrill of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local8 (< gMouseY local8))
			(SetCursor gMouseX local8)
		)
		(if (and (>= local0 5) ((ScriptID 50 0) caller:)) ; PactTimer
			((ScriptID 50 0) stop: cueCaller:) ; PactTimer
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(popper1 setCycle: Beg self)
				(popper2 setCycle: Beg)
				(popper3 setCycle: Beg)
				(popper4 setCycle: Beg)
				(popper5 setCycle: Beg)
			)
			(1
				(gGame handsOn:)
				(= global133 drillCode)
				(= local7 1)
				(if (== (gSwatInterface curInvItem:) (proc19_3 0))
					(= seconds 3)
				else
					(= seconds 6)
				)
			)
			(2
				(if (!= (gSwatInterface curInvItem:) (proc19_3 0))
					(cond
						(
							(OneOf
								(gSwatInterface curInvItem:)
								(proc19_3 3)
								(proc19_3 4)
							)
							(if (not (IsFlag 19))
								(gMessager say: 1 0 5 0 self) ; "Officer, you've chosen the incorrect weapon for this drill.  With your .45, please make ready and draw to the guard!"
							else
								(gMessager say: 2 0 5 0 self) ; "This is a handgun drill. With your .45, please make ready and draw to the guard!"
							)
						)
						((not (IsFlag 19))
							(gMessager say: 1 0 6 0 self) ; "Officer, this is a weapons drill. With your .45, please make ready!"
						)
						(else
							(gMessager say: 2 0 6 0 self) ; "This is a weapons drill! With your .45, please make ready!"
						)
					)
					(-= state 2)
				else
					(= local7 0)
					(= global133 0)
					(gGame handsOff:)
					(= local8 260)
					(self cue:)
				)
			)
			(3
				(= global133 drillCode)
				(= local0 (= global135 0))
				(if (popper1 cel:)
					(popper1 setCycle: Beg)
				)
				(if (popper2 cel:)
					(popper2 setCycle: Beg)
				)
				(if (popper3 cel:)
					(popper3 setCycle: Beg)
				)
				(if (popper4 cel:)
					(popper4 setCycle: Beg)
				)
				(if (popper5 cel:)
					(popper5 setCycle: Beg)
				)
				(= cycles 1)
			)
			(4
				(if (not (IsFlag 19))
					(gMessager say: 1 0 2 0 self) ; "This is the Dozier Drill - Engage each of the five Pepper Poppers until they fall. Reload as necessary! Par time five seconds. On the whistle!"
				else
					(gMessager say: 2 0 2 0 self) ; "Dozier Drill! Engage each of the five Pepper Poppers until they fall. Reload as necessary! Par time is five seconds. On the whistle!"
				)
				(= global114 okToShoot)
				(if (not (gCast contains: (ScriptID 50 0))) ; PactTimer
					((ScriptID 50 0) ; PactTimer
						view: 1990
						setLoop: 0
						setCel: 0
						posn: 110 91
						setPri: 480
						init:
					)
				)
				((ScriptID 50 0) clearClock: 1 shotsAllowed: -1 setPar: 50) ; PactTimer
			)
			(5
				(= seconds 2)
			)
			(6
				(gFxSound number: 21002 setLoop: 0 play: self)
			)
			(7
				(gGame handsOn:)
				(= local8 0)
				((ScriptID 50 0) start: self) ; PactTimer
			)
			(8
				(gGame handsOff:)
				((ScriptID 50 0) caller: 0) ; PactTimer
				(if (not (IsFlag 19))
					(gMessager say: 1 0 7 0 self) ; "Officers, guns to low-ready! Prepare to commence firing... Make Ready!"
				else
					(gMessager say: 2 0 7 0 self) ; "Guns at low-ready! Prepare to commence firing... Make Ready!"
				)
			)
			(9
				(cond
					((== global135 0)
						(if (not (IsFlag 19))
							(gMessager say: 1 0 9 0 self) ; "This is a participatory drill, Officer! Cooperation on your part is required!"
						else
							(gMessager say: 2 0 9 0 self) ; "During training details, participation from all officers is mandatory!"
						)
					)
					((< global135 local0)
						(if (not (IsFlag 19))
							(gMessager say: 1 0 11 0 self) ; "Officer, if you're experiencing a weapons malfunction clear it now; see the armorer later!"
						else
							(gMessager say: 2 0 11 0 self) ; "Participation is required of all officers during training details!"
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(10
				(= global133 0)
				(if (not (popper1 cel:))
					(popper1 setCycle: End)
				)
				(if (not (popper2 cel:))
					(popper2 setCycle: End)
				)
				(if (not (popper3 cel:))
					(popper3 setCycle: End)
				)
				(if (not (popper4 cel:))
					(popper4 setCycle: End)
				)
				(if (not (popper5 cel:))
					(popper5 setCycle: End)
				)
				((ScriptID 50 0) caller: 0 clearClock: 1) ; PactTimer
				((ScriptID 50 0) startDrillTimer: 5 chooseDrill) ; PactTimer
				(= local7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dozierCleanup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(popper1 setCycle: End self)
				(popper2 setCycle: End self)
				(popper3 setCycle: End self)
				(popper4 setCycle: End self)
				(popper5 setCycle: End self)
			)
			(1 0)
			(2 0)
			(3 0)
			(4 0)
			(5
				(gCurRoom setScript: register)
			)
		)
	)
)

(instance popper1 of Popper
	(properties
		x 157
		y 282
		view 1991
	)
)

(instance popper2 of Popper
	(properties
		x 242
		y 287
		view 1991
		loop 1
	)
)

(instance popper3 of Popper
	(properties
		x 330
		y 292
		view 1991
		loop 2
	)
)

(instance popper4 of Popper
	(properties
		x 415
		y 284
		view 1991
		loop 3
	)
)

(instance popper5 of Popper
	(properties
		x 504
		y 287
		view 1991
		loop 4
	)
)

(instance presPop1 of PresidentePopper
	(properties
		x 207
		y 175
		view 1992
		cycleSpeed 2
	)

	(method (setupShots)
		(self setShots: global135 (+ global135 5))
		(presPop2 setShots: (+ global135 1) (+ global135 4))
		(presPop3 setShots: (+ global135 2) (+ global135 3))
	)
)

(instance presPop2 of PresidentePopper
	(properties
		x 316
		y 176
		view 1992
		loop 1
		cycleSpeed 2
	)

	(method (setupShots)
		(= local5 1)
		(self setShots: 1 1)
		(presPop2 setShots: 1 1)
		(presPop3 setShots: 1 1)
	)
)

(instance presPop3 of PresidentePopper
	(properties
		x 427
		y 177
		view 1992
		loop 2
		cycleSpeed 3
	)

	(method (setupShots)
		(self setShots: global135 (+ global135 5))
		(presPop2 setShots: (+ global135 1) (+ global135 4))
		(presPop1 setShots: (+ global135 2) (+ global135 3))
	)
)

(instance combatP1 of CombatPopper
	(properties
		x 374
		y 220
		priority 1
		fixPriority 1
		view 1996
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP2 of CombatPopper
	(properties
		x 453
		y 220
		priority 1
		fixPriority 1
		view 1996
		loop 1
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP3 of CombatPopper
	(properties
		x 300
		y 229
		priority 1
		fixPriority 1
		view 1996
		loop 2
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP4 of CombatPopper
	(properties
		x 233
		y 231
		priority 1
		fixPriority 1
		view 1996
		loop 3
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP5 of CombatPopper
	(properties
		x 174
		y 379
		priority 300
		fixPriority 1
		view 1995
		moveSpeed 1
	)

	(method (setupDrill)
		(self setMotion: MoveTo x 267)
	)

	(method (clearDrill)
		(self rotate: 0)
		(self setMotion: MoveTo x 379)
	)
)

(instance combatP6 of CombatPopper
	(properties
		x 273
		y 379
		priority 300
		fixPriority 1
		view 1995
		loop 1
		moveSpeed 1
	)

	(method (setupDrill)
		(self setMotion: MoveTo x 264)
	)

	(method (clearDrill)
		(self rotate: 0)
		(self setMotion: MoveTo x 379)
	)
)

(instance combatP7 of CombatPopper
	(properties
		x 356
		y 379
		priority 300
		fixPriority 1
		view 1995
		loop 2
		moveSpeed 1
	)

	(method (setupDrill)
		(self setMotion: MoveTo x 264)
	)

	(method (clearDrill)
		(self rotate: 0)
		(self setMotion: MoveTo x 379)
	)
)

(instance combatP8 of CombatPopper
	(properties
		x 425
		y 379
		priority 300
		fixPriority 1
		view 1995
		loop 3
		moveSpeed 1
	)

	(method (setupDrill param1)
		(self setMotion: MoveTo x 259 param1)
	)

	(method (clearDrill param1)
		(self rotate: 0)
		(self setMotion: MoveTo x 379 param1)
	)
)

(instance combatP9 of CombatPopper
	(properties
		x 596
		y 111
		priority 1
		fixPriority 1
		view 1998
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP10 of CombatPopper
	(properties
		x 595
		y 212
		priority 1
		fixPriority 1
		view 1998
		loop 1
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance combatP11 of CombatPopper
	(properties
		x 71
		y 213
		priority 1
		fixPriority 1
		view 1998
		loop 2
	)

	(method (setupDrill)
		(self rotate: 0)
	)
)

(instance drillManager of Code
	(properties)

	(method (doit)
		(cond
			((IsFlag 43)
				(gCurRoom setScript: combatDrill)
			)
			((IsFlag 44)
				(gCurRoom setScript: dozierDrill)
			)
			((IsFlag 45)
				(gCurRoom setScript: presidenteDrill)
			)
		)
	)
)

(instance chooseDrill of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		((ScriptID 50 0) caller: 0 clearClock: 1) ; PactTimer
		(if (gTimers contains: drillTimer)
			(drillTimer client: 0 dispose:)
		)
		(if local9
			(return)
		)
		(cond
			((IsFlag 43)
				(= temp0 0)
			)
			((IsFlag 44)
				(= temp0 1)
			)
			(else
				(= temp0 2)
			)
		)
		(ClearFlag 43)
		(ClearFlag 44)
		(ClearFlag 45)
		(while 1
			(if (!= (= temp1 (Random 0 2)) temp0)
				(break)
			)
		)
		(switch temp1
			(0
				(SetFlag 43)
			)
			(1
				(SetFlag 44)
			)
			(2
				(SetFlag 45)
			)
		)
		(++ local3)
		(drillManager doit:)
	)
)

(instance popperCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 local6)
		(if local6
			(local6 rotate: 0)
		)
		(= local6 0)
		(while 1
			(if
				(!=
					(= local6
						(switch (Random 0 3)
							(0
								(switch (Random 0 2)
									(0 combatP1)
									(1 combatP5)
									(2 combatP9)
								)
							)
							(1
								(switch (Random 0 2)
									(0 combatP2)
									(1 combatP6)
									(2 combatP10)
								)
							)
							(2
								(switch (Random 0 1)
									(0 combatP3)
									(1 combatP7)
								)
							)
							(3
								(switch (Random 0 2)
									(0 combatP4)
									(1 combatP8)
									(2 combatP11)
								)
							)
						)
					)
					temp0
				)
				(break)
			)
		)
		(++ local1)
		(local6 rotate: 1)
	)
)

(instance drillCode of Code
	(properties)

	(method (doit)
		(if (gCurRoom script:)
			(if (gCast contains: (ScriptID 50 0)) ; PactTimer
				(((ScriptID 50 0) shotTimes:) ; PactTimer
					at: global135 ((ScriptID 50 0) currentTime:) ; PactTimer
				)
				(if
					(>
						((ScriptID 50 0) currentTime:) ; PactTimer
						((ScriptID 50 0) parTime:) ; PactTimer
					)
					(++ local4)
				)
			)
			(++ global135)
			(++ local1)
			(if
				(or
					(and
						(!= (gSwatInterface curInvItem:) (proc19_3 0))
						(not (followDrills register:))
						(!= (gCurRoom script:) followDrills)
					)
					local7
				)
				(if (gCast contains: (ScriptID 50 0)) ; PactTimer
					((ScriptID 50 0) caller: 0 clearClock: 1) ; PactTimer
				)
				((gCurRoom script:) cycles: 0 seconds: 0)
				(cond
					((IsFlag 43)
						(followDrills register: combatDrill)
					)
					((IsFlag 44)
						(followDrills register: dozierDrill)
					)
					(else
						(followDrills register: presidenteDrill)
					)
				)
				(gCurRoom setScript: followDrills)
			)
			(if
				(and
					(IsFlag 45)
					(== global135 ((ScriptID 50 0) shotsAllowed:)) ; PactTimer
				)
				((ScriptID 50 0) stop: cueCaller:) ; PactTimer
			)
		)
	)
)

(instance followDrills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(if (not (IsFlag 19))
					(gMessager say: 1 0 10 0 self) ; "This is training, Officer! You will follow the drills, please!"
				else
					(gMessager say: 2 0 10 0 self) ; "All officers participating in training details are required to follow the assigned drills!"
				)
			)
			(2
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(= cycles 2)
			)
			(3
				(if (gTimers contains: popperTimer)
					(popperTimer dispose: delete:)
				)
				(switch register
					(combatDrill
						(gCurRoom setScript: combatCleanup 0 register)
					)
					(dozierDrill
						(gCurRoom setScript: dozierCleanup 0 register)
					)
					(presidenteDrill
						(gCurRoom setScript: presCleanup 0 register)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
				(= register 0)
			)
		)
	)
)

(instance okToShoot of Code
	(properties)

	(method (doit param1)
		(if
			(or
				((ScriptID 50 0) onMe: param1) ; PactTimer
				(((ScriptID 50 0) butt1:) onMe: param1) ; PactTimer
				(((ScriptID 50 0) butt2:) onMe: param1) ; PactTimer
				(((ScriptID 50 0) butt3:) onMe: param1) ; PactTimer
				(((ScriptID 50 0) butt4:) onMe: param1) ; PactTimer
			)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance popperTimer of Timer
	(properties)

	(method (cue)
		(popperCode doit:)
	)
)

(instance drillTimer of Timer
	(properties)

	(method (cue)
		(chooseDrill doit:)
	)
)

(instance gunShot of Sound ; UNUSED
	(properties)
)

(instance timedHit of TimedHit
	(properties)
)

