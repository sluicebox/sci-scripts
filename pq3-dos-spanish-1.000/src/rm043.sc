;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
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
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 param1)
	(districtAttorney setLoop: 4 cel: 0 x: 139 y: 135)
	(param1 cue:)
)

(procedure (localproc_1 param1)
	(districtAttorney setCycle: SyncWalk setMotion: PolyPath 147 143 param1)
)

(procedure (localproc_2 param1)
	(districtAttorney
		setLoop: 3
		setCycle: SyncWalk
		setMotion: PolyPath 184 126 param1
	)
)

(procedure (localproc_3 param1)
	(districtAttorney
		setLoop: 5
		cel: 0
		x: 184
		y: 126
		setCycle: SyncWalk
		setMotion: PolyPath 147 143 param1
	)
)

(procedure (localproc_4 param1)
	(districtAttorney
		setLoop: 2
		setCycle: SyncWalk
		setMotion: MoveTo 130 133 param1
	)
)

(procedure (localproc_5 param1)
	(districtAttorney
		setLoop: 5
		setCycle: SyncWalk
		setMotion: MoveTo 137 143 param1
	)
)

(procedure (localproc_6 param1)
	(gEgo
		view: 460
		setLoop: 2
		normal: 0
		ignoreActors: 0
		setCycle: Beg param1
	)
	(sSoundEffects number: 914 play: 80)
)

(procedure (localproc_7 param1)
	(gEgo
		view: 460
		setLoop: 2
		cel: 0
		x: 107
		y: 120
		setPri: 10
		normal: 0
		ignoreActors: 1
		setCycle: End param1
	)
	(sSoundEffects number: 914 play: 80)
)

(procedure (localproc_8 param1)
	(gEgo
		view: 6
		loop: 3
		x: 105
		y: 113
		setPri: -1
		setCycle: Walk
		setMotion: MoveTo 97 99 param1
	)
)

(procedure (localproc_9 param1)
	(gEgo
		view: 6
		setLoop: -1
		setCycle: Walk
		setMotion: PolyPath 130 152 param1
	)
)

(procedure (localproc_10 param1)
	(gEgo view: 460 setLoop: 0 setCycle: Beg param1)
)

(procedure (localproc_11 param1)
	(gEgo
		view: 6
		setLoop: -1
		setCycle: Walk
		setMotion: PolyPath 97 99 param1
	)
)

(procedure (localproc_12 param1)
	(gEgo setMotion: MoveTo 103 116 param1)
)

(procedure (localproc_13 param1)
	(bailiff setLoop: 0 setCycle: SyncWalk setMotion: PolyPath 190 122 param1)
)

(procedure (localproc_14 param1)
	(bailiff loop: 2 cel: 0 x: 186 y: 120 setPri: -1 setCycle: CT 4 1 param1)
)

(procedure (localproc_15 param1)
	(bailiff setCycle: CT 8 1 param1)
)

(procedure (localproc_16 param1)
	(bailiff setCycle: End param1)
)

(procedure (localproc_17 param1)
	(bailiff
		x: 185
		y: 123
		setLoop: 1
		setPri: 10
		setCycle: SyncWalk
		setMotion: PolyPath 210 200 param1
	)
)

(procedure (localproc_18)
	(HandsOn)
	(if (== (gEgo view:) 460)
		(gTheIconBar disable: 0)
	)
)

(instance rm043 of PQRoom
	(properties
		picture 43
	)

	(method (init)
		(self setRegions: 143) ; rm143
		(LoadMany rsVIEW 6 25 460 461 462 463 464 465 466 467 468 470 471 472 473)
		(if (== gPrevRoomNum 44)
			(gEgo posn: 232 82)
			(door cel: 3 init:)
		else
			(gEgo loop: 0 posn: 161 108)
			(door init:)
		)
		(gEgo view: 6 setPri: -1 setStep: 3 2 init:)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 80 90 91 105 136 90 176 137 133 146 116 151 59 89 57 90 112 151 87 157 39 95 37 96 81 155 39 172 42 189 247 189 200 137 201 119 185 104 219 94 194 70
					yourself:
				)
		)
		(reporter init:)
		(egoChair init:)
		(attorneyChair init:)
		(reporter view: 473 loop: 4 cel: 0 x: 243 y: 175)
		(districtAttorney init:)
		(calendar init:)
		(gavel init:)
		(boxChair init:)
		(witnessBox init:)
		(SetFlag 29)
		(HandsOff)
		(gCurRoom setScript: egoGoSit)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0800)
				(gCurRoom newRoom: 42)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 143)
		(super dispose:)
	)
)

(instance DeputyStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(districtAttorney
					view: 461
					loop: 0
					cel: 12
					setCycle: CT 6 -1 self
				)
				(sSoundEffects number: 914 play: 80)
			)
			(1
				(egoChair show:)
				(= cycles 1)
			)
			(2
				(districtAttorney setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance DeputySit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(districtAttorney
					view: 461
					loop: 0
					cel: 0
					x: 130
					y: 133
					setCycle: CT 6 1 self
				)
			)
			(1
				(egoChair hide:)
				(= cycles 1)
			)
			(2
				(districtAttorney setCycle: End self)
				(sSoundEffects number: 914 play: 80)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance speechScript of rmnScript
	(properties)

	(method (changeState newState &tmp [temp0 200] temp200)
		(switch (= state newState)
			(0
				(reporter stopUpd:)
				(reporter setCycle: 0)
				(gEgo stopUpd:)
				(bailiff stopUpd:)
				(districtAttorney stopUpd:)
				(judge stopUpd:)
				(= cycles 1)
			)
			(1
				(switch local0
					(0
						(iEgo init:)
					)
					(1
						(iDA init:)
					)
					(2
						(iRuiz init:)
					)
					(3
						(idefenseA init:)
					)
					(4
						(ijudge init:)
					)
					(5
						(ireporter init:)
					)
				)
				(= cycles 1)
			)
			(2
				(= save1 1)
				(switch local0
					(0
						(GetFarText 503 (+ register 0) @temp0)
						(Say iEgo 503 (+ register 0))
					)
					(1
						(GetFarText 503 (+ register 9) @temp0)
						(Say iDA 503 (+ register 9))
					)
					(2
						(GetFarText 503 (+ register 23) @temp0)
						(Say iRuiz 503 (+ register 23))
					)
					(3
						(GetFarText 503 (+ register 28) @temp0)
						(Say idefenseA 503 (+ register 28))
					)
					(4
						(GetFarText 503 (+ register 35) @temp0)
						(Say ijudge 503 (+ register 35))
					)
					(5
						(GetFarText 503 (+ register 49) @temp0)
						(Say ireporter 503 (+ register 49))
					)
				)
				(if (not (< (= temp200 (StrLen @temp0)) 12))
					(= seconds (/= temp200 5))
				else
					(= seconds 4)
				)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(switch local0
					(0
						(iEgo dispose:)
					)
					(1
						(iDA dispose:)
					)
					(2
						(iRuiz dispose:)
					)
					(3
						(idefenseA dispose:)
					)
					(4
						(ijudge dispose:)
					)
					(5
						(ireporter dispose:)
					)
				)
				(= cycles 1)
			)
			(4
				(reporter startUpd:)
				(reporter setCycle: RandCycle)
				(gEgo startUpd:)
				(bailiff startUpd:)
				(districtAttorney startUpd:)
				(judge startUpd:)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance egoTalkToDA of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iDA init:)
				(= cycles 1)
			)
			(1
				(switch (Random 0 2)
					(0
						(= save1 1)
						(Say iDA 43 0) ; "Just tell the judge what happened when you get on the stand."
						(= seconds 8)
					)
					(1
						(= save1 1)
						(Say iDA 43 1) ; "Don't worry about it. Just tell the truth."
						(= seconds 6)
					)
					(2
						(= save1 1)
						(Say iDA 43 2) ; "We shouldn't have a problem with this one if you've followed procedure."
						(= seconds 10)
					)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iDA dispose:)
				(= cycles 1)
			)
			(3
				(localproc_18)
				(self dispose:)
			)
		)
	)
)

(instance egoGoSit of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_11 self)
			)
			(1
				(localproc_12 self)
			)
			(2
				(gEgo view: 460 loop: 2 cel: 0 normal: 0)
				(Print 43 3 #at 15 20) ; "You take the witness chair next to the Deputy District Attorney."
				(= cycles 1)
			)
			(3
				(attorneyChair hide:)
				(= cycles 1)
			)
			(4
				(localproc_7 self)
			)
			(5
				(Print 43 4 #at 15 20) ; "The bailiff says in a loud voice, "All rise for the honorable Judge Mildred Simpson.""
				(= cycles 1)
			)
			(6
				(localproc_6 self)
				(reporter setLoop: 2 cel: 0)
				(self setScript: DeputyStand self)
			)
			(7 0)
			(8
				(sSoundEffects number: 907 play:)
				(door setCycle: End self)
			)
			(9
				(judge init:)
				(= cycles 1)
			)
			(10
				(judge
					setLoop: 1
					setCycle: SyncWalk
					setMotion: MoveTo 206 84 self
				)
			)
			(11
				(door setCycle: Beg self)
			)
			(12
				(sSoundEffects number: 908 play:)
				(judge
					setLoop: 0
					setCycle: SyncWalk
					setMotion: MoveTo 237 123 self
				)
				(door addToPic:)
			)
			(13
				(judge
					loop: 3
					cel: 0
					x: 246
					y: 116
					setPri: 9
					setCycle: End self
				)
			)
			(14
				(Print 43 5 #at 15 20) ; "The bailiff says in a loud voice. Court is now in session. Please be seated."
				(= cycles 1)
			)
			(15
				(localproc_7 self)
				(reporter view: 473 setLoop: 4 cel: 0)
				(self setScript: DeputySit self)
			)
			(16 0)
			(17
				(judge
					view: 473
					setLoop: 0
					cel: 0
					x: 246
					y: 116
					setPri: 9
					setCycle: CT 1 1 self
				)
			)
			(18
				(UnLoad 128 465)
				(calendar hide:)
				(= cycles 1)
			)
			(19
				(judge setCycle: End self)
				(sSoundEffects number: 232 loop: 1 play:)
			)
			(20
				(= seconds 3)
			)
			(21
				(judge setCycle: CT 2 -1 self)
			)
			(22
				(calendar show:)
				(= cycles 1)
			)
			(23
				(judge setCycle: Beg self)
			)
			(24
				(Print 43 6 #at 15 20) ; "Directing her attention to the prosecutor, Judge Simpson says..."
				(= cycles 1)
			)
			(25
				(= local0 4)
				(self setScript: speechScript self 0)
			)
			(26
				(reporter setCycle: RandCycle)
				(= cycles 1)
			)
			(27
				(client setScript: startProsecution)
			)
		)
	)
)

(instance startProsecution of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: DeputyStand self)
			)
			(1
				(= local0 1)
				(self setScript: speechScript self 0)
			)
			(2
				(bailiff init:)
				(= cycles 1)
			)
			(3
				(self setScript: DeputySit self)
			)
			(4
				(localproc_13 self)
			)
			(5
				(localproc_14 self)
				(localproc_6 self)
			)
			(6 0)
			(7
				(gEgo view: 6 setHeading: 0 x: 103 y: 116)
				(= cycles 1)
			)
			(8
				(attorneyChair show:)
				(= cycles 1)
			)
			(9
				(localproc_8 self)
			)
			(10
				(gEgo
					view: 6
					setLoop: -1
					normal: 0
					setCycle: Walk
					setMotion: PolyPath 167 133 self
				)
			)
			(11
				(gEgo loop: 3)
				(localproc_15 self)
			)
			(12
				(= save1 1)
				(Say bailiff 43 7) ; "Officer, please raise your right hand."
				(= seconds 5)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo view: 460 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(14
				(= save1 1)
				(Say bailiff 43 8) ; "Do you swear to tell the truth, the whole truth, and nothing but the truth?"
				(= seconds 12)
			)
			(15
				(= local0 0)
				(self setScript: speechScript self 0)
			)
			(16
				(= save1 1)
				(Say bailiff 43 9) ; "Please state your name and occupation for the court."
				(= seconds 6)
			)
			(17
				(= local0 0)
				(self setScript: speechScript self 1)
			)
			(18
				(localproc_16 self)
				(gEgo setCycle: Beg self)
			)
			(19 0)
			(20
				(= cycles 1)
			)
			(21
				(localproc_17 self)
				(gEgo
					view: 6
					loop: 3
					setCycle: Walk
					setMotion: PolyPath 208 107 self
				)
			)
			(22 0)
			(23
				(gEgo
					view: 460
					setLoop: 0
					cel: 0
					x: 213
					y: 107
					setCycle: End self
				)
				(= local5 1)
			)
			(24
				(bailiff dispose:)
				(UnLoad 128 467)
				(= local1 0)
				(client setScript: question1)
			)
		)
	)
)

(instance question1 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: DeputyStand self)
			)
			(1
				(localproc_0 self)
			)
			(2
				(= cycles 1)
			)
			(3
				(localproc_1 self)
			)
			(4
				(localproc_2 self)
			)
			(5
				(districtAttorney
					loop: 1
					cel: 0
					posn:
						(+ (districtAttorney x:) 1)
						(+ (districtAttorney y:) 2)
				)
				(= cycles 1)
			)
			(6
				(= local0 1)
				(self setScript: speechScript self 1)
			)
			(7
				(localproc_18)
				(client setScript: timer1)
			)
		)
	)
)

(instance timer1 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(= local0 1)
				(self setScript: speechScript self 2)
			)
			(2
				(= seconds 20)
			)
			(3
				(HandsOff)
				(Load rsVIEW 473)
				(client setScript: judgeRappingGavel)
			)
		)
	)
)

(instance talk1A of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(self setScript: speechScript self 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(++ local2)
				(= local0 1)
				(self setScript: speechScript self 3)
			)
			(3
				(Print 43 10 #at 15 20) ; "You point out Mr. Ruiz and say..."
				(= cycles 1)
			)
			(4
				(= local0 0)
				(self setScript: speechScript self 3)
			)
			(5
				(Print 43 11 #at 15 20) ; "Speaking to the court reporter..."
				(= cycles 1)
			)
			(6
				(iDA init:)
				(= cycles 1)
			)
			(7
				(= save1 1)
				(Say iDA 43 12) ; "Let the record reflect that Officer Bonds has identified the defendant, Mr. Juan Ruiz."
				(= seconds 9)
			)
			(8
				(= save1 1)
				(Say iDA 43 13) ; "Officer Bonds, would you please describe the events which led up to your issuing a citation to Mr. Ruiz?"
				(= seconds 10)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iDA dispose:)
				(localproc_18)
				(client setScript: timer2)
			)
		)
	)
)

(instance timer2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(= local0 1)
				(self setScript: speechScript self 4)
			)
			(2
				(= seconds 15)
			)
			(3
				(HandsOff)
				(Load rsVIEW 473)
				(client setScript: judgeRappingGavel)
			)
		)
	)
)

(instance talk2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iEgo init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say iEgo 43 14) ; "Certainly. I had routine traffic duty that day."
				(= seconds 6)
			)
			(2
				(= save1 1)
				(Say iEgo 43 15) ; "I had been on duty for about six hours and was patrolling the highway when I drove up on a line of slow-moving cars in the fast lane."
				(= seconds 12)
			)
			(3
				(= save1 1)
				(Say iEgo 43 16) ; "I pulled around them in the slow lane and when I reached the head of the line I saw Mr. Ruiz in a 1958 Ford Fairlane."
				(= seconds 10)
			)
			(4
				(= save1 1)
				(Say iEgo 43 17) ; "I could see immediately that he was going way under the speed limit, so I clocked him. My speedometer registered 35 mph."
				(= seconds 12)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= cycles 1)
			)
			(6
				(= local0 2)
				(self setScript: speechScript self 0)
			)
			(7
				(judge view: 473 loop: 2 cycleSpeed: 9 setCycle: CT 3 1 self)
			)
			(8
				(gavel hide:)
				(= cycles 1)
			)
			(9
				(judge setCycle: CT 7 1 self)
			)
			(10
				(sSoundEffects number: 432 loop: 1 play:)
				(= cycles 1)
			)
			(11
				(= cycles 4)
			)
			(12
				(judge setCycle: CT 9 1 self)
			)
			(13
				(sSoundEffects number: 432 loop: 1 play:)
				(= cycles 1)
			)
			(14
				(judge setCycle: CT 10 1 self)
			)
			(15
				(gavel show:)
				(= cycles 1)
			)
			(16
				(Print 43 18 #at 15 20) ; "Irritated, Judge Simpson raps her gavel..."
				(= cycles 1)
			)
			(17
				(judge view: 473 loop: 2)
				(= local0 4)
				(self setScript: speechScript self 1)
			)
			(18
				(= cycles 1)
			)
			(19
				(++ local2)
				(= local0 1)
				(self setScript: speechScript self 5)
			)
			(20
				(localproc_18)
				(= local3 1)
				(= local6 1)
				(client setScript: useCalibrationTimer)
			)
		)
	)
)

(instance useCalibrationTimer of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(= local0 1)
				(self setScript: speechScript self 6)
			)
			(2
				(= seconds 10)
			)
			(3
				(HandsOff)
				(= local0 1)
				(self setScript: speechScript self 7)
			)
			(4
				(= local6 0)
				(= local4 0)
				(client setScript: noFurtherQuestions)
			)
		)
	)
)

(instance talk3 of rmnScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 43 19) ; "You'll hear plenty of the attorney's voice soon enough."
				(= cycles 1)
			)
			(1
				(localproc_18)
				(self dispose:)
			)
		)
	)
)

(instance noFurtherQuestions of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local0 1)
				(self setScript: speechScript self 8)
			)
			(2
				(districtAttorney loop: 2 cel: 0)
				(= cycles 1)
			)
			(3
				(localproc_3 self)
			)
			(4
				(localproc_4 self)
			)
			(5
				(self setScript: DeputySit self)
			)
			(6
				(if (and local4 (IsFlag 47))
					(client setScript: guilty)
				else
					(client setScript: notGuilty)
				)
			)
		)
	)
)

(instance guilty of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(self setScript: speechScript self 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(= local0 3)
				(self setScript: speechScript self 0)
			)
			(3
				(= cycles 1)
			)
			(4
				(= local0 4)
				(self setScript: speechScript self 3)
			)
			(5
				(localproc_10 self)
			)
			(6
				(localproc_11 self)
			)
			(7
				(localproc_12 self)
			)
			(8
				(gEgo loop: 2 cel: 0)
				(= cycles 1)
			)
			(9
				(attorneyChair hide:)
				(= cycles 1)
			)
			(10
				(localproc_7 self)
			)
			(11
				(client setScript: ruizTakesStand)
			)
		)
	)
)

(instance notGuilty of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 43 20 #at 15 20) ; "The judge addresses the defense attorney..."
				(= cycles 1)
			)
			(1
				(= local0 4)
				(self setScript: speechScript self 2)
			)
			(2
				(defenseAttorney init:)
				(= cycles 1)
			)
			(3
				(defenseAttorney
					view: 462
					setLoop: 1
					cel: 0
					setCycle: SyncWalk
					setMotion: PolyPath 166 113 self
				)
			)
			(4
				(defenseAttorney loop: 4 cel: 0 setPri: -1)
				(= cycles 2)
			)
			(5
				(Print 43 21 #at 15 20) ; "The defense attorney cross-examines you."
				(= cycles 1)
			)
			(6
				(cond
					((not (IsFlag 47))
						(client setScript: timeNotRecorded)
					)
					((not local4)
						(client setScript: noChartUsed)
					)
					(else
						(Print 43 22) ; "not Guilty condition we shouldn't have gotten here!!"
					)
				)
			)
		)
	)
)

(instance timeNotRecorded of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 3)
				(self setScript: speechScript self 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(= local0 0)
				(self setScript: speechScript self 4)
			)
			(3
				(= cycles 1)
			)
			(4
				(= local0 3)
				(self setScript: speechScript self 2)
			)
			(5
				(if (not local4)
					(client setScript: noChartUsed)
				else
					(client setScript: egoDownFromBox)
				)
			)
		)
	)
)

(instance noChartUsed of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local0 3)
				(self setScript: speechScript self 3)
			)
			(2
				(= cycles 1)
			)
			(3
				(= local0 0)
				(self setScript: speechScript self 5)
			)
			(4
				(= cycles 1)
			)
			(5
				(= local0 3)
				(self setScript: speechScript self 4)
			)
			(6
				(client setScript: egoDownFromBox)
			)
		)
	)
)

(instance egoDownFromBox of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local0 3)
				(self setScript: speechScript self 5)
			)
			(2
				(defenseAttorney
					view: 462
					setLoop: 0
					setPri: 10
					setCycle: SyncWalk
					setMotion: PolyPath 220 184 self
				)
			)
			(3
				(defenseAttorney dispose:)
				(UnLoad 128 462)
				(UnLoad 128 464)
				(= local0 4)
				(self setScript: speechScript self 3)
			)
			(4
				(localproc_10 self)
			)
			(5
				(localproc_11 self)
			)
			(6
				(localproc_12 self)
			)
			(7
				(gEgo loop: 2 cel: 0)
				(= cycles 1)
			)
			(8
				(attorneyChair hide:)
				(= cycles 1)
			)
			(9
				(localproc_7 self)
			)
			(10
				(client setScript: ruizTakesStand)
			)
		)
	)
)

(instance ruizTakesStand of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(self setScript: speechScript self 4)
			)
			(1
				(bailiff init:)
				(= cycles 1)
			)
			(2
				(localproc_13 self)
				(ruiz init:)
			)
			(3
				(localproc_14 self)
				(mLowride2Sound play:)
			)
			(4
				(ruiz
					setLoop: 2
					setCycle: SyncWalk
					setMotion: PolyPath 171 135 self
				)
			)
			(5
				(ruiz loop: 0 cel: 0)
				(= cycles 1)
			)
			(6
				(localproc_15 self)
			)
			(7
				(= save1 1)
				(Say bailiff 43 23) ; "Mr. Ruiz, please raise your right hand."
				(= seconds 5)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ruiz setCycle: CT 3 1 self)
			)
			(9
				(= save1 1)
				(Say bailiff 43 8) ; "Do you swear to tell the truth, the whole truth, and nothing but the truth?"
				(= seconds 12)
			)
			(10
				(= local0 2)
				(self setScript: speechScript self 1)
			)
			(11
				(= save1 1)
				(Say bailiff 43 24) ; "Please state your name for the court."
				(= seconds 6)
			)
			(12
				(= local0 2)
				(self setScript: speechScript self 2)
			)
			(13
				(ruiz setPri: -1 setCycle: End self)
				(localproc_16 self)
			)
			(14 0)
			(15
				(localproc_17 self)
				(ruiz
					setLoop: 1
					setCycle: SyncWalk
					setMotion: PolyPath 191 98 self
				)
			)
			(16
				(ruiz setLoop: 6 setPri: 6 setMotion: MoveTo 203 103 self)
			)
			(17
				(mLowride2Sound fade:)
				(ruiz setLoop: 3 setPri: -1 x: 206 setCycle: End self)
			)
			(18 0)
			(19
				(bailiff dispose:)
				(UnLoad 128 467)
				(= local0 4)
				(self setScript: speechScript self 5)
			)
			(20
				(iRuiz init:)
				(= cycles 1)
			)
			(21
				(= save1 1)
				(Say iRuiz 43 25) ; "I was just driving, your Honor! Not doing nothing! I'm a very careful driver!"
				(= seconds 10)
			)
			(22
				(= save1 1)
				(Say iRuiz 43 26) ; "I don't do no showing off or nothing in my ride. I wasn't speeding, I wasn't going slow, I wasn't doing nothing!"
				(= seconds 12)
			)
			(23
				(= save1 1)
				(Say iRuiz 43 27) ; "These cops just don't like Chicanos, man, and that's the truth. He'd of busted me if I was goin' 54!"
				(= seconds 12)
			)
			(24
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iRuiz dispose:)
				(= cycles 1)
			)
			(25
				(= local0 4)
				(self setScript: speechScript self 6)
			)
			(26
				(= cycles 1)
			)
			(27
				(= local0 1)
				(self setScript: speechScript self 9)
			)
			(28
				(= cycles 1)
			)
			(29
				(= local0 4)
				(self setScript: speechScript self 7)
			)
			(30
				(= cycles 1)
			)
			(31
				(= local0 2)
				(self setScript: speechScript self 3)
			)
			(32
				(= cycles 1)
			)
			(33
				(= local0 4)
				(self setScript: speechScript self 8)
			)
			(34
				(= cycles 1)
			)
			(35
				(= local0 1)
				(self setScript: speechScript self 10)
			)
			(36
				(= cycles 1)
			)
			(37
				(= local0 3)
				(self setScript: speechScript self 6)
			)
			(38
				(= cycles 1)
			)
			(39
				(= local0 4)
				(self setScript: speechScript self 9)
			)
			(40
				(mLowride2Sound play:)
				(ruiz setCycle: Beg self)
			)
			(41
				(ruiz
					setLoop: 7
					setCycle: SyncWalk
					setMotion: PolyPath 189 107 self
				)
			)
			(42
				(ruiz
					setLoop: 6
					setPri: 10
					setCycle: SyncWalk
					setMotion: PolyPath 220 200 self
				)
			)
			(43
				(mLowride2Sound fade:)
				(ruiz dispose:)
				(UnLoad 128 470)
				(UnLoad 128 471)
				(if (and local4 (IsFlag 47))
					(client setScript: guiltyVerdict)
				else
					(client setScript: notGuiltyVerdict)
				)
			)
		)
	)
)

(instance guiltyVerdict of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(self setScript: speechScript self 10)
			)
			(1
				(= cycles 1)
			)
			(2
				(= local0 1)
				(self setScript: speechScript self 11)
			)
			(3
				(= cycles 1)
			)
			(4
				(= local0 0)
				(self setScript: speechScript self 6)
			)
			(5
				(localproc_6 self)
			)
			(6
				(gEgo loop: 3 x: 103 y: 116)
				(attorneyChair show:)
				(self setScript: DeputyStand self)
			)
			(7
				(localproc_8 self)
			)
			(8
				(localproc_9 self)
			)
			(9
				(proc0_17 180)
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance notGuiltyVerdict of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 4)
				(self setScript: speechScript self 11)
			)
			(1
				(= cycles 1)
			)
			(2
				(= local0 2)
				(self setScript: speechScript self 4)
			)
			(3
				(= cycles 1)
			)
			(4
				(= local0 1)
				(self setScript: speechScript self 12)
			)
			(5
				(Print 43 28 #at 15 20) ; "You mumble..."
				(= cycles 1)
			)
			(6
				(= local0 0)
				(self setScript: speechScript self 7)
			)
			(7
				(localproc_6 self)
			)
			(8
				(gEgo loop: 3 x: 103 y: 116)
				(attorneyChair show:)
				(self setScript: DeputyStand self)
			)
			(9
				(localproc_8 self)
			)
			(10
				(localproc_9 self)
			)
			(11
				(proc0_17 180)
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance usedChart of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 43 29 #at 15 20) ; "You hand the calibration chart to the Deputy District Attorney."
				(gEgo put: 10 43) ; calibration
				(SetScore 200 3)
				(= cycles 1)
			)
			(1
				(= local0 0)
				(self setScript: speechScript self 8)
			)
			(2
				(= cycles 1)
			)
			(3
				(= local0 1)
				(self setScript: speechScript self 13)
			)
			(4
				(= local4 1)
				(client setScript: noFurtherQuestions)
			)
		)
	)
)

(instance judgeRappingGavel of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(judge view: 473 loop: 2 cycleSpeed: 9 setCycle: CT 3 1 self)
			)
			(1
				(gavel hide:)
				(= cycles 1)
			)
			(2
				(judge setCycle: CT 7 1 self)
			)
			(3
				(sSoundEffects number: 432 loop: 1 play:)
				(= cycles 1)
			)
			(4
				(= cycles 4)
			)
			(5
				(judge setCycle: CT 9 1 self)
			)
			(6
				(sSoundEffects number: 432 loop: 1 play:)
				(= cycles 1)
			)
			(7
				(judge setCycle: CT 10 1 self)
			)
			(8
				(gavel show:)
				(= cycles 1)
			)
			(9
				(judge view: 473 loop: 2)
				(= local0 4)
				(self setScript: speechScript self 12)
			)
			(10
				(localproc_10 self)
				(reporter setCycle: End)
			)
			(11
				(localproc_5 self)
				(gEgo
					view: 6
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 137 143 self
				)
			)
			(12
				(proc0_17 60)
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance noTalkDA of rmnScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 43 30) ; "The District Attorney isn't interested in excuses. He just wants the calibration chart."
				(= cycles 1)
			)
			(1
				(localproc_18)
				(self dispose:)
			)
		)
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

(instance ruiz of Actor
	(properties
		x 220
		y 200
		lookStr {Ruiz refuses to meet your eyes.}
		view 470
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 43 31) ; "Ruiz isn't any more interested in talking to you than you are in talking to him."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(ruiz
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
			setPri: 10
		)
		(super init:)
	)
)

(instance judge of Actor
	(properties
		x 226
		y 80
		lookStr {The judge looks serious and competent.}
		view 465
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if local5
					(Print 43 34) ; "Please answer the question, sir."
				else
					(Print 43 35) ; "When the judge wants your opinion, she'll ask for it."
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(judge
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
		(super init:)
	)
)

(instance bailiff of Actor
	(properties
		x 223
		y 200
		lookStr {The bailiff doesn't look like the sort to tolerate any nonsense in his courtroom.}
		view 467
		loop 2
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 36) ; "The bailiff doesn't look like the sort to tolerate any nonsense in his courtroom."
			)
			(5 ; Talk
				(Print 43 37) ; "The bailiff doesn't want to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(bailiff
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
		(super init:)
	)
)

(instance defenseAttorney of Actor
	(properties
		x 220
		y 200
		lookStr {The defense attorney is an aggressive lawyer. He would clearly like to make you look bad.}
		view 462
	)

	(method (init)
		(defenseAttorney
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
			setPri: 10
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance districtAttorney of Actor
	(properties
		x 130
		y 133
		lookStr {The Deputy District Attorney looks as though he's seen it all during his career. He doesn't miss a trick.}
		view 461
		cel 12
		priority 10
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					(local1
						(HandsOff)
						(gCurRoom setScript: egoTalkToDA)
					)
					(local6
						(Print 43 38) ; "Just hand him the calibration chart."
					)
					(else
						(switch local2
							(1
								(HandsOff)
								(gCurRoom setScript: talk1A)
							)
							(2
								(HandsOff)
								(gCurRoom setScript: talk2)
							)
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(10 ; calibration
						(cond
							(local4
								(Print 43 39) ; "The D.A. has already seen that."
							)
							(local3
								(HandsOff)
								(gCurRoom setScript: usedChart)
							)
							(else
								(Print 43 40) ; "When the D.A. wants the calibration chart, he'll ask for it."
							)
						)
					)
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(districtAttorney
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
		(super init:)
	)
)

(instance reporter of Prop
	(properties
		x 226
		y 109
		description {the court reporter}
		lookStr {The court reporter makes a record of all court proceedings.}
		view 468
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 43 41) ; "The court reporter is too busy to talk to you now."
			)
			(3 ; Do
				(Print 43 42) ; "The court reporter is busy."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 43 32) ; "What? In a court of law?"
					)
					(2 ; handcuff
						(Print 43 32) ; "What? In a court of law?"
					)
					(16 ; nightStick
						(Print 43 32) ; "What? In a court of law?"
					)
					(else
						(Print 43 33) ; "This is a court proceeding, not a swap meet!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(reporter cycleSpeed: (gGame egoMoveSpeed:))
		(super init:)
	)
)

(instance egoChair of View
	(properties
		x 128
		y 133
		view 461
		loop 6
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 460)
					(Print 43 43) ; "You're happy with the seat you're in."
				else
					(Print 43 44) ; "You'll need to sit up front at the prosecutor's table."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance attorneyChair of View
	(properties
		x 106
		y 120
		view 461
		loop 6
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 460)
					(Print 43 43) ; "You're happy with the seat you're in."
				else
					(Print 43 44) ; "You'll need to sit up front at the prosecutor's table."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxChair of Actor
	(properties
		x 227
		y 93
		view 472
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 460)
					(Print 43 43) ; "You're happy with the seat you're in."
				else
					(Print 43 44) ; "You'll need to sit up front at the prosecutor's table."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 209
		y 31
		description {the door}
		lookStr {That door must lead to the judge's chambers.}
		view 472
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 43 45) ; "You can't go in there while court is in session."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance calendar of View
	(properties
		x 233
		y 115
		lookStr {The judge's court calendar is on her desk.}
		view 473
		loop 1
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 43 46) ; "You don't need the calendar."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gavel of View
	(properties
		x 229
		y 108
		lookStr {Don't even think of messing with the Judge's gavel.}
		view 473
		loop 3
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 43 47) ; "If you want a nice gavel like that, you'll just have to go to law school."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ireporter of View
	(properties
		x 252
		y 101
		view 469
		loop 1
		priority 15
		signal 16
	)

	(method (init)
		(repMouth
			x: (ireporter x:)
			y: (+ (ireporter y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(repMouth dispose:)
		(super dispose:)
	)
)

(instance repMouth of Prop
	(properties
		view 469
		priority 15
		signal 16
		cycleSpeed 8
	)
)

(instance iDA of View
	(properties
		x 55
		y 108
		view 463
		priority 15
		signal 16
	)

	(method (init)
		(iDAMouth
			x: (iDA x:)
			y: (+ (iDA y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(iDAEyes
			x: (iDA x:)
			y: (+ (iDA y:) 10)
			z: 10
			cycleSpeed: 9
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(iDAMouth dispose:)
		(iDAEyes dispose:)
		(super dispose:)
	)
)

(instance iDAMouth of Prop
	(properties
		view 463
		loop 1
		priority 15
		signal 16400
	)
)

(instance iDAEyes of Prop
	(properties
		view 463
		loop 2
		priority 15
		signal 16400
	)
)

(instance idefenseA of View
	(properties
		x 265
		y 126
		view 464
		priority 15
		signal 16
	)

	(method (init)
		(idefenseMouth
			x: (idefenseA x:)
			y: (+ (idefenseA y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(idefenseMouth dispose:)
		(UnLoad 128 464)
		(super dispose:)
	)
)

(instance idefenseMouth of Prop
	(properties
		view 464
		loop 1
		priority 15
		signal 16400
	)
)

(instance ijudge of View
	(properties
		x 158
		y 146
		view 466
		priority 15
		signal 16
	)

	(method (init)
		(ijudgeMouth
			x: (ijudge x:)
			y: (+ (ijudge y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(ijudgeMouth dispose:)
		(super dispose:)
	)
)

(instance ijudgeMouth of Prop
	(properties
		view 466
		loop 1
		priority 15
		signal 16400
	)
)

(instance iRuiz of View
	(properties
		x 264
		y 120
		view 471
		priority 15
		signal 16
	)

	(method (init)
		(iRuizMouth
			x: (iRuiz x:)
			y: (+ (iRuiz y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(UnLoad 128 471)
		(iRuizMouth dispose:)
		(super dispose:)
	)
)

(instance iRuizMouth of Prop
	(properties
		view 471
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgo of View
	(properties
		x 56
		y 116
		view 25
		priority 15
		signal 16
	)

	(method (init)
		(iEgoMouth
			x: (iEgo x:)
			y: (+ (iEgo y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		(iEgoEyes
			x: (iEgo x:)
			y: (+ (iEgo y:) 10)
			z: 10
			init:
			setScript: egoEyesBlink
		)
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
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 16
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

(instance witnessBox of Feature
	(properties
		x 201
		y 92
		description {the witness box}
		onMeCheck 2
		lookStr {The witness box is located next to the judge's bench.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local5
					(Print 43 48) ; "You're already in the witness box."
				else
					(Print 43 49) ; "The court will call you when your testimony is needed."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mLowride2Sound of Sound
	(properties
		number 289
		loop -1
	)
)

(instance sSoundEffects of Sound
	(properties)
)

