;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm036 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(gEgo z: 500 hide:)
	(gCurRoom picture: 35)
	(gCurRoom drawPic: 35)
	(marieCloseUp init:)
	(mariesEyes init:)
	(marieMouth init:)
	(if
		(and
			(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
			(> ((gInventory at: 36) state:) 0) ; rose
			(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
			(IsFlag 40)
			(IsFlag 41)
		)
		(mariesEyes init: cel: (mariesEyes lastCel:) setScript: blinkEyes)
		(marieMouth init: cel: (- (marieMouth lastCel:) 1))
	)
	(mariesIV init:)
	(nurseButton init:)
	(ekg init:)
	(light init:)
	(soundBlip init: play:)
	(blip init:)
	(if (IsFlag 41)
		(ivNumbers cel: 0)
		(ivdrip cycleSpeed: 7)
	else
		(ivNumbers cel: 1)
		(ivdrip cycleSpeed: 4)
	)
	(ivNumbers init:)
	(ivdrip setCycle: Fwd init:)
	(if (> ((gInventory at: 36) state:) 0) ; rose
		(roseInset init:)
	)
	(if (> ((gInventory at: 5) state:) 0) ; musicBox
		(musicboxInset init:)
	)
	(if (> ((gInventory at: 37) state:) 0) ; locket
		(locketInset init:)
	)
	(doctor hide:)
	(nurse hide:)
	(closeUpView init:)
)

(procedure (localproc_1)
	(marieCloseUp dispose:)
	(mariesIV dispose:)
	(ekg dispose:)
	(light dispose:)
	(nurseButton dispose:)
	(blip dispose:)
	(soundBlip dispose:)
	(ivdrip dispose:)
	(finger dispose:)
	(marieMouth dispose:)
	(mariesEyes setScript: 0 dispose:)
	(ivNumbers dispose:)
	(roseInset dispose:)
	(musicboxInset dispose:)
	(locketInset dispose:)
	(closeUpView dispose:)
)

(procedure (localproc_2)
	(gEgo z: 0 loop: 1 show:)
	(gCurRoom picture: 36)
	(gCurRoom drawPic: 36)
	(marieFar ignoreActors: 1 stopUpd: approachVerbs: 5 2 4 init:) ; Talk, Look, Inventory
	(hospitalWindow init:)
	(bed init:)
	(ekgMonitor init:)
	(metalStand init:)
	(cabinet init:)
	(visitorsChair init:)
	(curtains init:)
	(wall init:)
	(floor init:)
	(ivStand init:)
	(chart init:)
	(if (== gDay 4)
		(chartView stopUpd: init:)
	)
	(doctor show:)
	(nurse show:)
)

(procedure (localproc_3)
	(ivStand dispose:)
	(hospitalWindow dispose:)
	(bed dispose:)
	(ekgMonitor dispose:)
	(metalStand dispose:)
	(cabinet dispose:)
	(chart dispose:)
	(chartView dispose:)
	(visitorsChair dispose:)
	(curtains dispose:)
	(wall dispose:)
	(floor dispose:)
	(marieFar dispose:)
)

(procedure (localproc_4 param1)
	(doctor setLoop: 1 setCycle: SyncWalk setMotion: MoveTo 229 151 param1)
	(Face gEgo doctor)
)

(procedure (localproc_5 param1)
	(doctor setLoop: 2 setCycle: SyncWalk setMotion: MoveTo 275 147 param1)
)

(procedure (localproc_6 param1)
	(nurse setLoop: 3 setCycle: SyncWalk setMotion: MoveTo 229 155 param1)
	(Face gEgo nurse)
)

(procedure (localproc_7 param1)
	(nurse setLoop: 2 setCycle: SyncWalk setMotion: MoveTo 275 151 param1)
)

(procedure (localproc_8 param1 &tmp temp0)
	(cond
		((& (= temp0 (gEgo onControl: 0)) $0400)
			(gEgo setMotion: PolyPath 219 116 param1)
		)
		((& temp0 $1000)
			(gEgo setMotion: PolyPath 125 152 param1)
		)
		(else
			(param1 cycles: 1)
		)
	)
)

(instance rm036 of PQRoom
	(properties
		picture 36
		east 37
		south 37
		west 37
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 138 0 189 318 189 319 126 228 126 244 100 175 76 162 82 177 91 152 98 202 112 159 131 114 113 86 124 92 138
					yourself:
				)
		)
		(LoadMany rsVIEW 4 400 401 402 403 404 407 410 411)
		(Load rsSCRIPT 969)
		(if (== gPrevRoomNum 37)
			(gEgo x: 195 y: 189 setPri: 4)
		else
			(gEgo loop: 1 x: 153 y: 99 setLoop: -1 setPri: -1)
		)
		(gEgo
			setStep: 3 2
			normal: 1
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
			init:
		)
		(if (> gDay 1)
			(gEgo view: 4)
		else
			(gEgo view: 0)
		)
		(doctor init:)
		(nurse init:)
		(if
			(and
				(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
				(> ((gInventory at: 36) state:) 0) ; rose
				(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
				(IsFlag 40)
				(IsFlag 41)
			)
			(= local1 1)
			(mariesEyes setScript: blinkEyes)
		else
			(= local1 0)
		)
		(egoOffScreen init: hide:)
		(localproc_2)
		(super init:)
		(gLongSong number: 350 flags: 1 loop: -1 play:)
		(if (== gDay 1)
			(= local0 1)
		)
		(if (== gPrevRoomNum 37)
			(HandsOff)
			(gCurRoom setScript: enterHospRoom)
		)
		(if (== gPrevRoomNum 30)
			(HandsOff)
			(gCurRoom setScript: enterDoctor)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 969)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((and (gCast contains: mariesEyes) (gEgo mover:))
				(localproc_1)
				(localproc_2)
				(gEgo setMotion: 0)
			)
			((and (& temp0 $0800) (== gDay 1))
				(gLongSong number: 0 fade:)
				(HandsOff)
				(gCurRoom setScript: goBackToMall)
			)
			((& temp0 $0800)
				(gLongSong number: 0 fade:)
				(gCurRoom newRoom: 37)
			)
		)
		(super doit:)
	)
)

(instance enterDoctor of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
				(= global105 4)
				(= global106 12)
			)
			(1
				(ShowClock 1)
				(= seconds 4)
			)
			(2
				(Face gEgo doctor)
				(= cycles 3)
			)
			(3
				(localproc_4 self)
			)
			(4
				(doctor setMotion: PolyPath 194 108 self)
			)
			(5
				(ShowClock 0)
				(doctor setLoop: 0 cel: 0)
				(= save1 1)
				(insetDoctor init:)
				(Say insetDoctor 36 0) ; "Officer Bonds, I'm Dr. Wagner, the resident neurosurgeon."
				(= seconds 7)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 1) ; "I'm sorry to say that your wife's condition is still quite serious. She's suffering from internal injuries sustained from the multiple stab wounds."
				(= seconds 12)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 2) ; "How long she will remain in a coma is anyone's guess."
				(= seconds 8)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 3) ; "In my experience, the presence of a loved one urging the patient back from that void is an incalculable asset."
				(= seconds 11)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 4) ; "We're doing all we can for her physically, but you might be the only one who can reach her now."
				(= seconds 10)
			)
			(10
				(if (not (gEgo has: 29)) ; necklace
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(= save1 1)
					(Say insetDoctor 36 5) ; "The nurse found this chain clutched in your wife's hand."
					(gEgo get: 29) ; necklace
					(= seconds 8)
				else
					(= cycles 1)
				)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 6) ; "Sergeant Bonds, you look beat. You really should go home and try to get some rest. There's nothing to be done for your wife right now."
				(= seconds 12)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 7) ; "We can all feel good about the fact that Marie is alive."
				(= seconds 7)
			)
			(13
				(insetDoctor dispose:)
				(= cycles 1)
			)
			(14
				(doctor setLoop: 2 setMotion: PolyPath 275 147 self)
			)
			(15
				(gEgo setHeading: 270)
				(localproc_5 self)
			)
			(16
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mushyTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say egoOffScreen 36 8) ; "Marie! Please come back, Baby. I can't go on without you."
				(= seconds 6)
			)
			(2
				(= save1 1)
				(Print 36 9 #at 40 115) ; "You fight to pull yourself together."
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say egoOffScreen 36 10) ; "I...I've gotta go now, Babe. You need your rest. It's been a rough night."
				(= seconds 7)
			)
			(4
				(egoOffScreen hide:)
				(= local0 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goBackToMall of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 0 self)
				(nurse setScript: 0)
			)
			(2
				(= save1 1)
				(iEgo init:)
				(Say iEgo 36 11) ; "I'll get the bastard who did this, Babe. I SWEAR IT!"
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= seconds 2)
			)
			(4
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98 6)
				(gLongSong fade:)
				(= cycles 5)
			)
			(5
				(= save1 1)
				(Display 36 12 dsRESTOREPIXELS local2)
				(= local2
					(Display 36 13 dsCOORD 60 80 dsCOLOR global125 dsWIDTH 200 dsFONT 1 dsSAVEPIXELS) ; "As a fellow officer drives you back to your car at the mall, you fight to focus your rage, grief, and sense of violation into something you can live with."
				)
				(= seconds 14)
			)
			(6
				(= save1 1)
				(Display 36 12 dsRESTOREPIXELS local2)
				(= local2
					(Display 36 14 dsCOORD 60 80 dsCOLOR global125 dsWIDTH 200 dsFONT 1 dsSAVEPIXELS) ; "What you end up with is a burning desire to find and crucify the slime that hurt your wife."
				)
				(= seconds 10)
			)
			(7
				(= save1 1)
				(Display 36 12 dsRESTOREPIXELS local2)
				(= local2
					(Display 36 15 dsCOORD 60 80 dsCOLOR global125 dsWIDTH 200 dsFONT 1 dsSAVEPIXELS) ; "Somebody out there picked the wrong man to mess with."
				)
				(= seconds 8)
			)
			(8
				(HandsOn)
				(gLongSong number: 0)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance egoPickupChart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 184 136 self)
			)
			(1
				(gEgo
					view: 400
					loop: 0
					cel: 0
					normal: 0
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(2
				(chartView hide:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(Print 36 16 #at 40 115) ; "The chart shows that Marie's IV dosage is supposed to be set at 0.005"
				(= cycles 1)
			)
			(5
				(gEgo setCycle: CT 2 -1 self)
			)
			(6
				(chartView show:)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(chartView show:)
				(SetFlag 42)
				(NormalEgo 4 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveKiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 164 103 self)
			)
			(1
				(gEgo
					setLoop: 1
					cycleSpeed: (+ (gGame egoMoveSpeed:) 3)
					moveSpeed: (+ (gGame egoMoveSpeed:) 3)
					setMotion: MoveTo 154 104 self
				)
			)
			(2
				(gEgo
					view: 401
					loop: 0
					cel: 0
					x: 143
					y: 105
					setPri: 8
					normal: 0
					setCycle: End self
				)
			)
			(3
				(cond
					((>= (mariesEyes cel:) 1)
						(Print 36 17 #at 40 115) ; "You gently kiss Marie's lips."
					)
					((== gDay 1)
						(Print 36 18) ; "Sweet dreams!"
					)
					(else
						(Print 36 19 #at 40 115) ; "You softly kiss your wife. Her eyelids flicker in response."
					)
				)
				(= cycles 1)
			)
			(4
				(gEgo
					view: 4
					setLoop: 1
					x: 154
					y: 104
					setPri: -1
					cycleSpeed: (gGame egoMoveSpeed:)
					moveSpeed: (gGame egoMoveSpeed:)
					setCycle: Rev
					setMotion: MoveTo 156 99 self
				)
			)
			(5
				(SetFlag 40)
				(SetScore 137 10)
				(NormalEgo 4 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doctorInSecondTime of rmnScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gCast contains: mariesEyes)
					(localproc_1)
					(localproc_2)
				)
				(= cycles 1)
			)
			(1
				(localproc_8 self)
			)
			(2
				(localproc_4 self)
			)
			(3
				(doctor setLoop: 0 cel: 0)
				(= cycles 1)
			)
			(4
				(Print 36 20 #at 40 115) ; "Doctor Wagner's face is grave as he says..."
				(= cycles 1)
			)
			(5
				(insetDoctor init:)
				(Face gEgo doctor)
				(= cycles 1)
			)
			(6
				(= save1 1)
				(Say insetDoctor 36 21) ; "I'm afraid I don't have any good news, Sonny.  Marie's condition is unchanged."
				(= seconds 10)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 22) ; "There's nothing more we can do but wait... and hope."
				(= seconds 14)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Say insetDoctor 36 23) ; "Again, I'm sorry, Officer. Now if you'll excuse me, I have other patients to attend to."
				(= seconds 10)
			)
			(9
				(insetDoctor dispose:)
				(localproc_5 self)
			)
			(10
				(SetFlag 210)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance alreadyDoneIV of rmnScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			((= save1 1)
				(Say nurse 36 24) ; "She seems to be resting quietly now."
				(= seconds 6)
			)
			((and gModelessDialog (gModelessDialog dispose:))
				(= seconds 3)
			)
			((localproc_7 self))
			((HandsOn)
				(= cycles 1)
			)
			((self dispose:)
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance notDiscoveredIV of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(switch (Random 0 2)
					(0
						(Say nurse 36 25) ; "Hello, Sergeant Bonds. I'm afraid there's no change."
					)
					(1
						(Say nurse 36 26) ; "Nothing new to report, I'm afraid."
					)
					(2
						(Say nurse 36 27) ; "We haven't noticed any changes, but I think she appreciates you being here, just the same."
					)
				)
				(= seconds 8)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_7 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance discoveredIV of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 36 28) ; "In an anxious voice, you tell the nurse you're concerned about the IV dosage."
				(SetScore 160 15)
				(SetFlag 158)
				(SetFlag 159)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say nurse 36 29) ; "I'll get the doctor to check on that right away, Officer."
				(= seconds 8)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_7 self)
			)
			(3
				(client setScript: nurseGetsDoctor)
			)
		)
	)
)

(instance nurseGetsDoctor of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (gEgo script:) (gCurRoom script:))
					(self state: (-- state))
				)
				(= cycles 1)
			)
			(1
				(localproc_8 self)
			)
			(2
				(Face gEgo doctor)
				(localproc_4 self)
			)
			(3
				(doctor setLoop: 0 cel: 0)
				(Print 36 30) ; "Torn between feeling foolish and genuinely alarmed, you explain to the doctor that there seems to be a discrepancy between the IV dosage on the chart and that on the IV meter."
				(= cycles 1)
			)
			(4
				(doctor setLoop: 1 setMotion: PolyPath 194 140 self)
			)
			(5
				(Print 36 31 #at 40 115) ; "The doctor looks doubtful as he checks the chart..."
				(= cycles 1)
			)
			(6
				(doctor loop: 3 cel: 0 x: 186 y: 140 setCycle: CT 3 1 self)
			)
			(7
				(chartView hide:)
				(= cycles 1)
			)
			(8
				(doctor setCycle: CT (doctor lastCel:) 1 self)
			)
			(9
				(= seconds 3)
			)
			(10
				(doctor setCycle: CT 3 -1 self)
			)
			(11
				(chartView show:)
				(= cycles 1)
			)
			(12
				(doctor setCycle: CT 0 -1 self)
			)
			(13
				(doctor
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 125 125 self
				)
			)
			(14
				(doctor loop: 0 cel: 0 x: 126 y: 124 setCycle: CT 6 1 self)
				(Print 36 32 #at 40 115) ; "...Then the IV."
			)
			(15
				(= seconds 3)
			)
			(16
				(doctor setCycle: End self)
			)
			(17
				(doctor setLoop: 2)
				(insetDoctor init:)
				(= cycles 1)
			)
			(18
				(Print 36 33 #at 40 115) ; "With a red face, the doctor says..."
				(= cycles 1)
			)
			(19
				(= save1 1)
				(Say insetDoctor 36 34) ; "Why...You're correct, Sergeant Bonds.  This dosage is obviously incorrect."
				(= seconds 10)
			)
			(20
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Say insetDoctor 36 35) ; "I don't understand this at all. I can't believe our staff could make such a serious error!  I have readjusted the IV. Perhaps Marie will feel better now."
				(SetFlag 41)
				(= seconds 12)
			)
			(21
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetDoctor dispose:)
				(= cycles 1)
			)
			(22
				(localproc_5 self)
			)
			(23
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterHospRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 195 149 self)
			)
			(1
				(gEgo setPri: -1)
				(if (and (== gDay 4) (not (IsFlag 210)))
					(gCurRoom setScript: doctorInSecondTime self)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveMusicBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundMB init: play:)
				(musicboxInset init:)
				(gEgo put: 5 gCurRoomNum) ; musicBox
				((gInventory at: 5) state: 1) ; musicBox
				(= cycles 1)
			)
			(1
				(if
					(and
						(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
						(> ((gInventory at: 36) state:) 0) ; rose
						(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
						(IsFlag 40)
						(IsFlag 41)
					)
					(client setScript: marieWakes)
				else
					(= cycles 1)
				)
			)
			(2
				(= seconds 6)
			)
			(3
				(Print 36 36 #at 40 115 #dispose) ; "Marie's eyelids flutter, almost as though she could hear her music box."
				(= cycles 1)
			)
			(4
				(mariesEyes setCycle: CT 2 1 self)
			)
			(5
				(mariesEyes setCycle: CT 0 -1 self)
			)
			(6
				(mariesEyes setCycle: CT 2 1 self)
			)
			(7
				(mariesEyes setCycle: CT 0 -1 self)
			)
			(8
				(= seconds 3)
			)
			(9
				(soundMB fade:)
				(= seconds 1)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetScore 135 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveRose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roseInset init:)
				(finger init:)
				(= seconds 3)
			)
			(1
				(finger cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(2
				(finger setCycle: Beg self)
			)
			(3
				(= seconds 2)
			)
			(4
				(Print 36 37 #at 40 115 #dispose) ; "You could swear that you just saw Marie's finger move!"
				(= seconds 7)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo put: 36 gCurRoomNum) ; rose
				((gInventory at: 36) state: 1) ; rose
				(finger dispose:)
				(if
					(and
						(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
						(> ((gInventory at: 36) state:) 0) ; rose
						(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
						(IsFlag 40)
						(IsFlag 41)
					)
					(client setScript: marieWakes)
				)
				(HandsOn)
				(SetScore 136 5)
				(self dispose:)
			)
		)
	)
)

(instance giveLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(locketInset init:)
				(= cycles 1)
			)
			(1
				(gEgo put: 37 gCurRoomNum) ; locket
				((gInventory at: 37) state: 1) ; locket
				(if
					(and
						(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
						(> ((gInventory at: 36) state:) 0) ; rose
						(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
						(IsFlag 40)
						(IsFlag 41)
					)
					(client setScript: marieWakes)
				else
					(= cycles 1)
				)
			)
			(2
				(marieMouth cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(3
				(Print 36 38 #at 40 115 #dispose) ; "Marie's mouth moves slightly."
				(= seconds 5)
			)
			(4
				(marieMouth setCycle: Beg self)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(SetScore 178 10)
				(self dispose:)
			)
		)
	)
)

(instance marieWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade:)
				(soundMarieOK play:)
				(mariesEyes setCycle: CT 2 1 self)
			)
			(1
				(mariesEyes cel: 2 setCycle: CT 0 -1 self)
			)
			(2
				(mariesEyes cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(mariesEyes setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(marieMouth cel: 0 cycleSpeed: 8 setCycle: CT 2 1 self)
			)
			(6
				(Print 36 39 #at 40 115 #dispose) ; "Marie's eyes finally open. The warmth of her smile gives you hope for the first time since her attack.  You're a lucky man, Sonny Bonds. Marie is alive and whole."
				(= seconds 13)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(soundMarieOK fade: dispose:)
				(gLongSong init: play:)
				(mariesEyes setScript: blinkEyes)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pushButton of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nurseButton setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(nurseButton setCycle: Beg self)
			)
			(3
				(= seconds 20)
			)
			(4
				(if (or (gEgo script:) (gCurRoom script:))
					(self state: (-- state))
				)
				(= cycles 1)
			)
			(5
				(HandsOff)
				(if (gCast contains: mariesEyes)
					(localproc_1)
					(localproc_2)
				)
				(= cycles 1)
			)
			(6
				(localproc_8 self)
			)
			(7
				(localproc_6 self)
			)
			(8
				(nurse loop: 4 cel: 0 ignoreActors: 0)
				(= cycles 1)
			)
			(9
				(= save1 1)
				(Say nurse 36 40) ; "Do you need something, Sergeant Bonds?"
				(= seconds 3)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(nurse setScript: waitForTalk)
			)
		)
	)
)

(instance waitForTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(HandsOff)
				(if (gCast contains: mariesEyes)
					(localproc_1)
					(localproc_2)
				)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(Say nurse 36 41) ; "If there is nothing else, I have to get back to work."
				(= seconds 8)
			)
			(3
				(nurse ignoreActors: 1)
				(= cycles 1)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_7 self)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance blinkEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mariesEyes cel: 3)
				(= seconds 5)
			)
			(1
				(mariesEyes setCycle: Beg self)
			)
			(2
				(mariesEyes setCycle: End self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance rTalkEyes of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= save1 1)
				(switch (Random 0 4)
					(0
						(Say egoOffScreen 36 42) ; "I never lost hope! I just knew that somehow, someway, you would come back to me."
					)
					(1
						(Say egoOffScreen 36 43) ; "It was your strength and your will to live that brought you back."
					)
					(2
						(Say egoOffScreen 36 44) ; "You're going to be fine now sweetness. You'll be up and around in no time."
					)
					(3
						(Say egoOffScreen 36 45) ; "There's no doubt in my mind, somebody up there is looking out for you."
					)
					(4
						(Say egoOffScreen 36 46) ; "We're real close to nailing the animals that caused this."
					)
				)
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance seeIV of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 164 103 self)
			)
			(1
				(localproc_3)
				(localproc_0)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(Print 36 47 #at 40 115) ; "The digital readout indicates Marie's IV dosage."
				(SetFlag 43)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doctor of Actor
	(properties
		x 275
		y 147
		lookStr {The doctor looks tired but sympathetic.}
		view 402
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 36 48 #at 40 115) ; "One moment, Sir."
			)
			(3 ; Do
				(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(Print 36 50) ; "You've already introduced yourself to the hospital staff."
					)
					(1 ; gun
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(16 ; nightStick
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(2 ; handcuff
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nurse of Actor
	(properties
		x 275
		y 151
		lookStr {The nurse looks competent and sturdy.}
		view 407
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if (and (IsFlag 42) (IsFlag 43))
					(HandsOff)
					(nurse setScript: discoveredIV)
				else
					(HandsOff)
					(nurse setScript: notDiscoveredIV)
				)
			)
			(3 ; Do
				(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(Print 36 50) ; "You've already introduced yourself to the hospital staff."
					)
					(1 ; gun
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(16 ; nightStick
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(2 ; handcuff
						(Print 36 49) ; "That won't help Marie come back. They're doing all they can."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marieFar of View
	(properties
		x 133
		y 94
		approachX 153
		approachY 99
		view 404
		priority 8
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (> gDay 1)
					(HandsOff)
					(gCurRoom setScript: giveKiss)
				else
					(Print 36 51) ; "Marie is resting gently. You don't want to disturb her."
				)
			)
			(5 ; Talk
				(localproc_3)
				(localproc_0)
				(marieCloseUp doVerb: 5)
			)
			(2 ; Look
				(localproc_3)
				(localproc_0)
				(marieCloseUp doVerb: 2)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; musicBox
						(HandsOff)
						(localproc_3)
						(localproc_0)
						(gCurRoom setScript: giveMusicBox)
					)
					(36 ; rose
						(if (not (> ((gInventory at: 36) state:) 0)) ; rose
							(HandsOff)
							(localproc_3)
							(localproc_0)
							(gCurRoom setScript: giveRose)
						else
							(Print 36 52) ; "You gently place a fresh rose in Marie's hand.  However, there is no response. Nice try Sonny."
							(gEgo put: 36) ; rose
						)
					)
					(37 ; locket
						(localproc_3)
						(localproc_0)
						(HandsOff)
						(gCurRoom setScript: giveLocket)
					)
					(1 ; gun
						(Print 36 53) ; "Marie's condition might yet be reversible. Don't give up without a fight."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			((nurse script:)
				(return)
			)
			(
				(and
					(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
					(> ((gInventory at: 36) state:) 0) ; rose
					(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
					(IsFlag 40)
					(IsFlag 41)
					(not (gCast contains: mariesEyes))
					(not (>= (mariesEyes cel:) 1))
					(not local1)
				)
				(localproc_3)
				(localproc_0)
				(HandsOff)
				(gCurRoom setScript: marieWakes)
			)
		)
		(super doit:)
	)
)

(instance chart of Feature
	(properties
		x 175
		y 114
		description {the chart}
		onMeCheck 16384
		lookStr {That's where the doctor hangs the patient's chart.}
	)
)

(instance chartView of View
	(properties
		x 175
		y 114
		description {the chart}
		lookStr {It's Marie's hospital chart.}
		view 402
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: egoPickupChart)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ivStand of Feature
	(properties
		description {the stand}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 54) ; "You can't change the medication by yourself."
			)
			(2 ; Look
				(HandsOff)
				(gCurRoom setScript: seeIV)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance insetDoctor of Prop
	(properties
		x 250
		y 116
		view 403
		priority 14
		signal 16
	)

	(method (init)
		(doctorMouth
			x: (self x:)
			y: (self y:)
			cycleSpeed: 1
			setCycle: RandCycle
			init:
		)
		(doctorEyes x: (self x:) y: (self y:) init: setScript: doctorBlinks)
		(super init:)
	)

	(method (dispose)
		(doctorMouth dispose:)
		(doctorEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance doctorMouth of Prop
	(properties
		view 403
		loop 2
		priority 15
		signal 16400
	)
)

(instance doctorEyes of Prop
	(properties
		view 403
		loop 3
		priority 15
		signal 16400
	)
)

(instance doctorBlinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(doctorEyes cel: 1)
				(= cycles 2)
			)
			(2
				(doctorEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance hospitalWindow of Feature
	(properties
		description {the window}
		onMeCheck 8
		lookStr {The window overlooks the hospital parking lot.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 55) ; "The room temperature is monitored carefully by the staff.  You don't need to open the window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bed of Feature
	(properties
		description {the bed}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (>= (mariesEyes cel:) 1)
					(Print 36 56 #at 40 115) ; "Marie lies awake in the bed."
				else
					(Print 36 57 #at 40 115) ; "Marie lies motionless on the hospital bed."
				)
			)
			(3 ; Do
				(Print 36 58) ; "The hospital bed does not need adjustment."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ekgMonitor of Feature
	(properties
		description {the monitor}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (>= (mariesEyes cel:) 1)
					(Print 36 59) ; "Words cannot discribe the joy you feel seeing Marie awake from her coma."
				else
					(Print 36 60 #at 40 115) ; "The EKG monitor registers your wife's vital signs.  Its steady beep in response to her pulse gives you some small comfort."
				)
			)
			(3 ; Do
				(if (>= (mariesEyes cel:) 1)
					(Print 36 61) ; "The Monitor's beep reminds you that although Marie is awake, she is not out of the woods yet."
				else
					(Print 36 62) ; "Leave the monitor alone. It will alert the staff if Marie goes into distress."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance metalStand of Feature
	(properties
		description {the stand}
		onMeCheck 4
		lookStr {The rolling metal stand provides a moving table for the nurses or your wife - if she were conscious to use it.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 63) ; "You do not need the metal stand."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		description {the cabinet}
		onMeCheck 64
		lookStr {The cabinet contains general hospital issue plastics and a few personal items belonging to your wife.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 64) ; "There's nothing in the cabinets that would be of use to you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance visitorsChair of Feature
	(properties
		description {the chair}
		onMeCheck 8192
		lookStr {That chair is provided for the patient's visitors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if
					(not
						(and
							(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
							(> ((gInventory at: 36) state:) 0) ; rose
							(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
							(IsFlag 40)
							(IsFlag 41)
						)
					)
					(Print 36 65) ; "You're too upset by the sight of Marie to even think about sitting down."
				else
					(Print 36 66) ; "You don't feel like sitting right now."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance curtains of Feature
	(properties
		description {the curtains}
		sightAngle 360
		onMeCheck 256
		lookStr {The curtains are there to provide privacy for Marie during examinations and medical procedures.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 67) ; "There's no reason to draw the curtains right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		description {the wall}
		onMeCheck 512
		lookStr {The walls in here are depressingly bare.}
	)
)

(instance floor of Feature
	(properties
		description {the floor}
		onMeCheck 5248
		lookStr {The linoleum is shiny and clean.}
	)
)

(instance marieCloseUp of Feature
	(properties
		description {the woman}
		onMeCheck 88
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (> gDay 1)
					(localproc_1)
					(localproc_2)
					(HandsOff)
					(gCurRoom setScript: giveKiss)
				else
					(Print 36 51) ; "Marie is resting gently. You don't want to disturb her."
					(localproc_1)
					(localproc_2)
				)
			)
			(5 ; Talk
				(cond
					(local0
						(HandsOff)
						(gCurRoom setScript: mushyTalk)
					)
					((>= (mariesEyes cel:) 1)
						(HandsOff)
						(gCurRoom setScript: rTalkEyes)
					)
					(else
						(Print 36 68 #at 40 115) ; "You talk gently to your wife, hoping that some part of her hears you."
					)
				)
			)
			(2 ; Look
				(if (>= (mariesEyes cel:) 1)
					(Print 36 69 #at 40 115) ; "You are overjoyed to see your wife recovered."
				else
					(Print 36 70 #at 40 115) ; "Your beloved wife lies motionless in a coma. You wish there was some way to know what she's thinking... if she's thinking."
				)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; musicBox
						(HandsOff)
						(gCurRoom setScript: giveMusicBox)
					)
					(36 ; rose
						(if (not (> ((gInventory at: 36) state:) 0)) ; rose
							(HandsOff)
							(gCurRoom setScript: giveRose)
						else
							(Print 36 71 #at 40 115) ; "You gently place a fresh rose in Marie's hand.  However, there is no response."
							(gEgo put: 36) ; rose
						)
					)
					(37 ; locket
						(HandsOff)
						(gCurRoom setScript: giveLocket)
					)
					(19 ; wallet
						(Print 36 72 #at 40 115) ; "Marie's proud of your career as a police officer, but she's not interested in your badge right now."
					)
					(1 ; gun
						(Print 36 73 #at 40 115) ; "Marie's condition might yet be reversable. Don't give up without a fight."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
				(> ((gInventory at: 36) state:) 0) ; rose
				(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
				(IsFlag 40)
				(IsFlag 41)
				(not (>= (mariesEyes cel:) 1))
			)
			(HandsOff)
			(gCurRoom setScript: marieWakes)
		)
		(super doit:)
	)
)

(instance mariesIV of Feature
	(properties
		description {the IV}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 36 47 #at 40 115) ; "The digital readout indicates Marie's IV dosage."
				(SetFlag 43)
			)
			(3 ; Do
				(Print 36 54) ; "You can't change the medication by yourself."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ekg of Feature
	(properties
		description {monitor}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (>= (mariesEyes cel:) 1)
					(Print 36 59 #at 40 115) ; "Words cannot discribe the joy you feel seeing Marie awake from her coma."
				else
					(Print 36 60 #at 40 115) ; "The EKG monitor registers your wife's vital signs.  Its steady beep in response to her pulse gives you some small comfort."
				)
			)
			(3 ; Do
				(if (>= (mariesEyes cel:) 1)
					(Print 36 74) ; "You shouldn't mess with things you know nothing about."
				else
					(Print 36 62) ; "Leave the monitor alone. It will alert the staff if Marie goes into distress."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		description {the light}
		onMeCheck 16384
		lookStr {The light casts a clinical glare over Marie's face.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 75) ; "There's no reason to turn off the light."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nurseButton of Prop
	(properties
		x 166
		y 33
		description {the button}
		lookStr {It's a call button.}
		view 411
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 41)
					(Print 36 76) ; "You don't need the nurse now."
				else
					(Print 36 77 #at 40 115) ; "You press the call button and hope that the nurse is on the way."
					(nurse setScript: pushButton)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roseInset of View
	(properties
		x 69
		y 148
		onMeCheck 8
		lookStr {The rose is still fresh and beautiful.}
		view 411
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 78) ; "Let Marie keep her rose."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self ignoreActors: 1 stopUpd:)
		(super init:)
	)
)

(instance musicboxInset of View
	(properties
		x 213
		y 168
		lookStr {Marie's music box lies next to her on the bed.}
		view 411
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 79) ; "Let Marie keep her music box."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self ignoreActors: 1 stopUpd:)
		(super init:)
	)
)

(instance locketInset of View
	(properties
		x 137
		y 114
		onMeCheck 64
		lookStr {It's Marie's lovely locket.}
		view 411
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 36 80) ; "Let Marie keep her locket."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self ignoreActors: 1 stopUpd:)
		(super init:)
	)
)

(instance blip of Prop
	(properties
		x 269
		y 124
		view 410
	)

	(method (doVerb theVerb invItem)
		(ekg doVerb: theVerb invItem)
	)

	(method (doit)
		(if (< (soundBlip prevSignal:) 20)
			(blip cel: 0 setCycle: End)
		)
		(super doit:)
	)
)

(instance ivdrip of Prop
	(properties
		x 71
		y 38
		view 410
		loop 1
	)

	(method (doVerb theVerb invItem)
		(mariesIV doVerb: theVerb invItem)
	)
)

(instance mariesEyes of Prop
	(properties
		x 175
		y 76
		view 410
		loop 2
	)

	(method (doVerb theVerb invItem)
		(marieCloseUp doVerb: theVerb invItem)
	)

	(method (init)
		(if
			(and
				(== ((gInventory at: 37) owner:) gCurRoomNum) ; locket
				(> ((gInventory at: 36) state:) 0) ; rose
				(== ((gInventory at: 5) owner:) gCurRoomNum) ; musicBox
				(IsFlag 40)
				(IsFlag 41)
			)
			(mariesEyes cel: 7)
		)
		(super init:)
	)
)

(instance finger of Prop
	(properties
		x 89
		y 108
		view 410
		loop 4
		priority 12
		signal 16
		cycleSpeed 3
	)

	(method (doVerb theVerb invItem)
		(marieCloseUp doVerb: theVerb invItem)
	)
)

(instance marieMouth of Prop
	(properties
		x 173
		y 79
		view 410
		loop 3
	)

	(method (doVerb theVerb invItem)
		(marieCloseUp doVerb: theVerb invItem)
	)
)

(instance ivNumbers of View
	(properties
		x 51
		y 71
		view 410
		loop 5
	)

	(method (doVerb theVerb invItem)
		(mariesIV doVerb: theVerb invItem)
	)
)

(instance iEgo of View
	(properties
		x 207
		y 126
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(self stopUpd:)
		(iEgoMouth x: (iEgo x:) y: (iEgo y:) setCycle: RandCycle init:)
		(if (> gDay 1)
			(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoClothes dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 17
	)
)

(instance iEgoEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance egoOffScreen of View
	(properties
		x 10
		y 180
		view 25
		loop 2
	)
)

(instance closeUpView of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(localproc_1)
				(localproc_2)
			)
		)
	)
)

(instance soundBlip of Sound
	(properties
		number 353
		loop -1
	)
)

(instance soundMB of Sound
	(properties
		number 351
		loop -1
	)
)

(instance soundMarieOK of Sound
	(properties
		number 352
		priority 14
		loop -1
	)
)

