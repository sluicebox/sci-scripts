;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	Intro 0
)

(local
	local0
	local1
	local2
	[local3 4]
)

(procedure (localproc_0)
	(if local1
		(Graph grRESTORE_BOX local1)
		(Graph grUPDATE_BOX [local3 0] [local3 1] [local3 2] [local3 3] 1)
		(= local1 0)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp [temp0 2] [temp2 200])
	(localproc_0)
	(Format @temp2 101 0 param1 param2) ; "%s"
	(TextSize @[local3 0] @temp2 104 param5)
	(+= [local3 0] (- param4 2))
	(+= [local3 1] param3)
	(+= [local3 2] (+ param4 2))
	(+= [local3 3] param3)
	(= local1 (Graph grSAVE_BOX [local3 0] [local3 1] [local3 2] [local3 3] 1))
	(Display param1 param2 dsFONT 104 dsCOORD param3 param4 dsCOLOR 0 dsWIDTH param5 121) ; p_noshow
	(Display param1 param2 dsFONT 103 dsCOORD param3 param4 dsCOLOR 15 dsWIDTH param5 121) ; p_noshow
	(RedrawCast)
	(Graph grUPDATE_BOX [local3 0] [local3 1] (+ [local3 2] 2) [local3 3] 1)
)

(instance introMusic of Sound
	(properties
		number 2
	)
)

(instance Intro of Rm
	(properties)

	(method (init)
		(Load rsVIEW 601)
		(Load rsVIEW 602)
		(Load rsVIEW 603)
		(Load rsVIEW 604)
		(Load rsVIEW 605)
		(Load rsVIEW 606)
		(Load rsVIEW 607)
		(Load rsVIEW 609)
		(Load rsPIC 100)
		(Load rsPIC 101)
		(Load rsPIC 102)
		(Load rsPIC 103)
		(Load rsPIC 104)
		(Load rsPIC 106)
		(Load rsPIC 108)
		(Load rsPIC 109)
		(Load rsSOUND 2)
		(Load rsSOUND 3)
		(Load rsSOUND 4)
		(Load rsSOUND 204)
		(Load rsSOUND 5)
		(super init:)
		(SetCursor 999 0 320 200)
		(= global109 6)
		(HandsOff)
		(DoSound sndSET_SOUND 1)
		(MenuBar state: 0)
		(= local0 1)
		(= local2
			(switch global103
				(2 2)
				(1 1)
				(0 0)
			)
		)
	)

	(method (dispose)
		(SetCursor gNormalCursor 1 300 172)
		(clr)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(MenuBar state: 1)
		(= gUserFont 1)
		(SysWindow color: 0 back: 15)
	)

	(method (doit &tmp [temp0 30])
		(super doit:)
		(if local0
			(gCast eachElementDo: #dispose)
			(if local1
				(UnLoad 133 local1)
				(= local1 0)
			)
			(switch local0
				(1
					(gCurRoom setScript: camelotGood)
				)
				(2
					(gCurRoom setScript: threesome)
				)
				(3
					(gCurRoom setScript: roundTable)
				)
				(4
					(gCurRoom setScript: merlinCloseUp)
				)
				(5
					(gCurRoom setScript: camelotBad)
				)
				(6
					(gCurRoom setScript: peasants)
				)
				(7
					(gCurRoom setScript: roundTableGrail)
				)
				(8
					(gCurRoom setScript: arthurPonder)
				)
				(9
					(gCurRoom setScript: crystalBall)
				)
			)
			(= local0 0)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evKEYBOARD
				(if (or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
					(event claimed: 1)
					(gCurRoom newRoom: 1)
				)
			)
		)
	)
)

(instance boat of Act
	(properties)
)

(instance butterfly1 of Prop
	(properties)
)

(instance butterfly2 of Prop
	(properties)
)

(instance butterfly3 of Prop
	(properties)
)

(instance leftFlag of Prop
	(properties)
)

(instance middleFlag of Prop
	(properties)
)

(instance rightFlag of Prop
	(properties)
)

(instance water1 of Prop
	(properties)
)

(instance water2 of Prop
	(properties)
)

(instance camelotGood of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic prevSignal:) -1)
			(= seconds 0)
			(if (== (self state:) 1)
				(self changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global61 0)
				(gCurRoom drawPic: 101)
				(boat
					view: 601
					setLoop: 2
					posn: -16 156
					setPri: 7
					init:
					setCycle: Fwd
					cycleSpeed: (if (== global103 2) 2 else 1)
					moveSpeed: (if (== global103 2) 1 else 0)
					setStep: 1 1
					setMotion: MoveTo 139 156
				)
				(water1
					view: 601
					loop: 6
					posn: 137 165
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				(water2
					view: 601
					loop: 5
					posn: 187 181
					cycleSpeed: 1
					setCycle: Fwd
					init:
					setPri: 10
				)
				(butterfly1
					view: 601
					loop: 3
					cel: 0
					posn: 215 176
					priority: 8
					setCycle: Fwd
					cycleSpeed: 3
					init:
				)
				(butterfly2
					view: 601
					loop: 3
					cel: 2
					posn: 244 170
					priority: 8
					setCycle: Fwd
					cycleSpeed: 2
					init:
				)
				(butterfly3
					view: 601
					loop: 3
					cel: 1
					posn: 278 164
					priority: 8
					setCycle: Fwd
					cycleSpeed: 4
					init:
				)
				(leftFlag
					view: 601
					loop: 4
					cel: 1
					posn: 163 27
					setCycle: Fwd
					cycleSpeed: 6
					init:
				)
				(middleFlag
					view: 601
					loop: 4
					cel: 2
					posn: 191 26
					setCycle: Fwd
					cycleSpeed: 5
					init:
				)
				(rightFlag
					view: 601
					loop: 4
					cel: 0
					posn: 207 37
					setCycle: Fwd
					cycleSpeed: 6
					init:
				)
				(proc0_13 32)
				(gAddToPics doit:)
				(localproc_1 101 1 15 15 130) ; "My lord King, look upon your stronghold, Camelot. By strength of spirit, skill of sword and quickness of mind, you have built a kingdom that could live in legends."
				(introMusic play:)
				(= seconds 14)
			)
			(1
				(clr)
				(localproc_1 101 2 15 15 140) ; "Beneath your firm and wise hand, the warring tribes of Celts, Saxons, Jutes, and Angles have been brought under control and foreign marauders driven from the shores."
			)
			(2
				(clr)
				(= local0 2)
			)
		)
	)
)

(instance LEyes of Prop
	(properties)
)

(instance hand of Prop
	(properties)
)

(instance GEyes of Prop
	(properties)
)

(instance threesome of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic signal:) 20)
			(= seconds 0)
			(if (== (self state:) 5)
				(self changeState: 6)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 102)
				(LEyes view: 602 loop: 0 cel: 0 posn: 66 58 init:)
				(GEyes view: 602 loop: 1 setCel: 0 posn: 249 85 init:)
				(hand view: 602 loop: 2 cel: 0 posn: 225 91 init:)
				(proc0_13 32)
				(gAddToPics doit:)
				(localproc_1 101 3 75 85 130) ; "Your queen is the beautiful Gwenhyver, who loves you and whom you love dearly. Yet you know that her deepest and most passionate love is reserved for your greatest knight, Sir Launcelot."
				(introMusic number: 3 play:)
				(= seconds 12)
			)
			(1
				(hand setCycle: CT 2 1)
				(= seconds 1)
			)
			(2
				(LEyes setCycle: End)
				(= seconds 2)
			)
			(3
				(localproc_1 101 4 75 85 130) ; "And because Launcelot is chivalrous, brave and a true friend, you do nothing to bring harm to him or your queen. Instead, you suffer in silence."
				(= seconds 4)
			)
			(4
				(hand setCycle: End self)
			)
			(5
				(hand setCycle: 0)
				(GEyes setCycle: End)
				(= seconds 16)
			)
			(6
				(self cue:)
			)
			(7
				(clr)
				(= local0 3)
			)
		)
	)
)

(instance knight1 of View
	(properties)
)

(instance knight2 of Prop
	(properties)
)

(instance knight3 of View
	(properties)
)

(instance knight4 of View
	(properties)
)

(instance knight5 of View
	(properties)
)

(instance knight6 of View
	(properties)
)

(instance knight7 of View
	(properties)
)

(instance knight8 of View
	(properties)
)

(instance knight9 of View
	(properties)
)

(instance knight10 of Prop
	(properties)
)

(instance knight11 of View
	(properties)
)

(instance knight12 of View
	(properties)
)

(instance knight13 of View
	(properties)
)

(instance knight14 of View
	(properties)
)

(instance knight15 of Prop
	(properties)
)

(instance roundTable of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic signal:) 30)
			(= seconds 0)
			(self changeState: 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 103)
				(knight1
					view: 603
					loop: 0
					cel: 0
					posn: 229 143
					setPri: 10
					init:
					addToPic:
				)
				(knight2
					view: 603
					loop: 0
					cel: 1
					posn: 202 151
					setPri: 11
					init:
					addToPic:
				)
				(knight3
					view: 603
					loop: 0
					cel: 2
					posn: 164 161
					setPri: 12
					init:
					addToPic:
				)
				(knight4
					view: 603
					loop: 0
					cel: 3
					posn: 120 156
					setPri: 11
					init:
					addToPic:
				)
				(knight5
					view: 603
					loop: 0
					cel: 4
					posn: 90 144
					setPri: 10
					init:
					addToPic:
				)
				(knight6
					view: 603
					loop: 0
					cel: 5
					posn: 68 128
					setPri: 9
					init:
					addToPic:
				)
				(knight7
					view: 603
					loop: 0
					cel: 6
					posn: 60 90
					setPri: 8
					init:
					addToPic:
				)
				(knight8
					view: 603
					loop: 1
					cel: 0
					posn: 67 72
					setPri: 3
					init:
					addToPic:
				)
				(knight9
					view: 603
					loop: 1
					cel: 1
					posn: 89 49
					setPri: 1
					init:
					addToPic:
				)
				(knight10
					view: 603
					loop: 1
					cel: 2
					posn: 120 39
					setPri: 0
					init:
					addToPic:
				)
				(knight11
					view: 603
					loop: 1
					cel: 3
					posn: 159 33
					setPri: 9
					init:
					addToPic:
				)
				(knight12
					view: 603
					loop: 1
					cel: 4
					posn: 195 37
					setPri: 8
					init:
					addToPic:
				)
				(knight13
					view: 603
					loop: 1
					cel: 5
					posn: 228 48
					setPri: 8
					init:
					addToPic:
				)
				(knight14
					view: 603
					loop: 1
					cel: 6
					posn: 257 72
					setPri: 3
					init:
					addToPic:
				)
				(knight15
					view: 603
					loop: 1
					cel: 7
					posn: 259 95
					setPri: 8
					init:
					addToPic:
				)
				(proc0_13 32)
				(gAddToPics doit:)
				(localproc_1 101 5 100 57 130) ; "Sharing the Round Table with you are noble warriors of the realm: Launcelot, Kai, Ector, Gareth, Percival, Gawaine, Galahad and many others."
				(introMusic number: (proc0_20 4) play:)
				(= seconds 24)
			)
			(1
				(self cue:)
			)
			(2
				(clr)
				(= local0 4)
			)
		)
	)
)

(instance mouth of Prop
	(properties)
)

(instance gem of Prop
	(properties)
)

(instance owlEyes of Prop
	(properties
		y 75
		x 22
		view 604
		loop 2
	)

	(method (doit)
		(super doit:)
		(if (and (not cycler) (not (Random 0 30)))
			(self setCycle: owlCycleTo (Random 0 5) (if (Random 0 1) 1 else -1))
		)
	)
)

(instance owlCycleTo of CT
	(properties)
)

(instance merlinCloseUp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic prevSignal:) 40)
			(= seconds 0)
			(self changeState: 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 104)
				(mouth
					view: 604
					loop: 0
					cel: 0
					posn: 119 136
					cycleSpeed: 1
					init:
				)
				(gem
					view: 604
					loop: 1
					cel: 3
					posn: 136 69
					cycleSpeed: 2
					setCycle: Fwd
					init:
				)
				(owlEyes init:)
				(proc0_13 256)
				(gAddToPics doit:)
				(= seconds 3)
			)
			(1
				(localproc_1 101 6 170 30 130) ; "And I? I am Merlin. Advisor, mentor and, as some would have it, wizard, though my true nature remains a secret known only to the ancient gods and me."
				(mouth setCycle: Fwd)
				(= seconds 32)
			)
			(2
				(clr)
				(= local0 5)
			)
		)
	)
)

(instance boatOverturned of View
	(properties)
)

(instance waterHittingBoat of Prop
	(properties)
)

(instance camelotBad of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic prevSignal:) 50)
			(= seconds 0)
			(self changeState: 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global61 3)
				(gCurRoom drawPic: 101)
				(boatOverturned
					view: 605
					loop: 0
					cel: 0
					posn: 37 143
					init:
					addToPic:
				)
				(waterHittingBoat
					view: 605
					loop: 1
					cel: 2
					posn: 43 146
					init:
					cycleSpeed: 2
					setCycle: Fwd
				)
				(proc0_13 32)
				(gAddToPics doit:)
				(= seconds 3)
			)
			(1
				(localproc_1 101 7 15 15 130) ; "I must speak to you now of dark truths: the forbidden love of Gwenhyver and Launcelot has cast a blight upon your soul. And in so doing, has put a curse upon your kingdom."
				(= seconds 24)
			)
			(2
				(clr)
				(= local0 6)
			)
		)
	)
)

(instance flies of Prop
	(properties)
)

(instance egoOnHorse of Act
	(properties)
)

(instance head of Act
	(properties)

	(method (doit)
		(super doit:)
		(self posn: (+ (egoOnHorse x:) 37) (- (egoOnHorse y:) 48))
	)
)

(instance peasants of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (introMusic signal:) 60) (< state 4))
			(= seconds 0)
			(self changeState: 4)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global61 0)
				(gCurRoom drawPic: 106)
				(flies
					view: 606
					setLoop: 1
					posn: 194 148
					setPri: 13
					setCycle: Fwd
					init:
				)
				(hand
					view: 606
					setLoop: 2
					posn: 184 79
					init:
					setPri: 15
					addToPic:
				)
				(proc0_13 32)
				(gAddToPics doit:)
				(= seconds 2)
			)
			(1
				(localproc_1 101 8 25 145 210) ; "The fruit has withered on the vine, grain dies of disease, while springs and wells turn foul. Your people cry out to you for a miracle."
				(egoOnHorse
					view: 606
					setLoop: 0
					posn: 350 130
					cycleSpeed: (if (== global103 2) 1 else 0)
					moveSpeed: (if (== global103 2) 1 else 0)
					setCycle: Fwd
					setStep: 4 2
					setMotion: MoveTo 90 130 self
					init:
				)
				(head
					view: 606
					setLoop: 3
					cycleSpeed: (egoOnHorse cycleSpeed:)
					moveSpeed: (egoOnHorse moveSpeed:)
					setCycle: Fwd
					setStep: 4 2
					init:
				)
			)
			(2
				(egoOnHorse setCel: 0 setCycle: 0 setMotion: 0)
				(head setLoop: 4 setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(3
				(egoOnHorse setCel: 0 setCycle: Fwd setMotion: MoveTo -80 130)
				(head
					setLoop: 5
					setCel: 0
					cycleSpeed: (egoOnHorse cycleSpeed:)
					setCycle: Fwd
				)
				(= seconds 16)
			)
			(4
				(= cycles
					(switch global103
						(2 18)
						(1 8)
						(0 1)
					)
				)
			)
			(5
				(clr)
				(= local0 7)
			)
		)
	)
)

(instance gawaine of Prop
	(properties)
)

(instance lancelot of Prop
	(properties)
)

(instance galahad of Prop
	(properties)
)

(instance coveredGrail of Act
	(properties)
)

(instance knightFace of Prop
	(properties)
)

(instance roundTableGrail of Script
	(properties)

	(method (doit &tmp [temp0 30])
		(switch (introMusic prevSignal:)
			(62
				(if (== state 0)
					(= seconds 0)
					(self changeState: 1)
				)
			)
			(64
				(if (== state 1)
					(= seconds 0)
					(self changeState: 2)
				)
			)
			(66
				(if (== state 2)
					(= seconds 0)
					(self changeState: 3)
				)
			)
			(68
				(if (== state 3)
					(= seconds 0)
					(self changeState: 4)
				)
			)
			(70
				(if (== state 4)
					(= seconds 0)
					(self changeState: 5)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 103)
				(knight1
					view: 603
					loop: 0
					cel: 0
					posn: 229 143
					setPri: 10
					init:
					addToPic:
				)
				(lancelot
					view: 603
					loop: 0
					cel: 1
					posn: 202 151
					setPri: 11
					init:
				)
				(knight3
					view: 603
					loop: 0
					cel: 2
					posn: 164 161
					setPri: 12
					init:
					addToPic:
				)
				(knight4
					view: 603
					loop: 0
					cel: 3
					posn: 120 156
					setPri: 11
					init:
					addToPic:
				)
				(knight5
					view: 603
					loop: 0
					cel: 4
					posn: 90 144
					setPri: 10
					init:
					addToPic:
				)
				(knight6
					view: 603
					loop: 0
					cel: 5
					posn: 68 128
					setPri: 9
					init:
					addToPic:
				)
				(knight7
					view: 603
					loop: 0
					cel: 6
					posn: 60 90
					setPri: 8
					init:
					addToPic:
				)
				(knight8
					view: 603
					loop: 1
					cel: 0
					posn: 67 72
					setPri: 3
					init:
					addToPic:
				)
				(galahad view: 603 loop: 1 cel: 1 posn: 89 49 setPri: 1 init:)
				(knight10
					view: 603
					loop: 1
					cel: 2
					posn: 120 39
					setPri: 0
					init:
					addToPic:
				)
				(knight11
					view: 603
					loop: 1
					cel: 3
					posn: 159 33
					setPri: 9
					init:
					addToPic:
				)
				(knight12
					view: 603
					loop: 1
					cel: 4
					posn: 195 37
					setPri: 8
					init:
					addToPic:
				)
				(knight13
					view: 603
					loop: 1
					cel: 5
					posn: 228 48
					setPri: 8
					init:
					addToPic:
				)
				(knight14
					view: 603
					loop: 1
					cel: 6
					posn: 257 72
					setPri: 3
					init:
					addToPic:
				)
				(gawaine view: 603 loop: 1 cel: 7 posn: 259 95 setPri: 8 init:)
				(coveredGrail
					view: 607
					loop: 0
					cel: 5
					posn: 159 6
					ignoreActors:
					illegalBits: 0
					setPri: 14
					setCycle: Fwd
					cycleSpeed: local2
					moveSpeed: local2
					setMotion: MoveTo 159 92 self
					init:
				)
				(proc0_13 32)
				(gAddToPics doit:)
			)
			(1
				(localproc_1 101 9 95 60 125) ; "A vision of the Holy Grail covered in a white cloth appeared to you in your time of need. Three of your greatest knights went forth to seek it..."
				(coveredGrail setMotion: 0 dispose:)
				(= seconds 17)
			)
			(2
				(clr)
				(knightFace view: 603 setLoop: 2 posn: 285 107 init:)
				(localproc_1 101 10 95 82 125) ; "...Sir Gawaine..."
				(gawaine posn: 100 1000)
				(RedrawCast)
				(= seconds 8)
			)
			(3
				(clr)
				(knightFace view: 603 setLoop: 3 posn: 230 178)
				(localproc_1 101 11 95 82 125) ; "...Sir Launcelot..."
				(lancelot posn: 100 1000)
				(RedrawCast)
				(= seconds 8)
			)
			(4
				(clr)
				(knightFace view: 603 setLoop: 4 posn: 64 52)
				(localproc_1 101 12 95 82 125) ; "...and Sir Galahad."
				(galahad posn: 100 1000)
				(RedrawCast)
				(= seconds 8)
			)
			(5
				(= seconds 0)
				(knightFace posn: 1000 1000)
				(clr)
				(= local0 8)
			)
		)
	)
)

(instance arthurPonder of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic prevSignal:) 80)
			(= seconds 0)
			(if (== (self state:) 2)
				(self changeState: 3)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 108)
				(proc0_13 32)
				(gAddToPics doit:)
				(= seconds 2)
			)
			(1
				(localproc_1 101 13 160 80 140) ; "Gawaine, Launcelot and Galahad have not returned. The search must now fall to you and during this search you will be sorely tested in physical, moral and spiritual strength."
				(= seconds 16)
			)
			(2
				(clr)
				(localproc_1 101 14 160 80 140) ; "If you are found wanting in any of these virtues, the Grail will be denied to you and your kingdom will turn to ashes and dust."
				(= seconds 20)
			)
			(3
				(clr)
				(= local0 9)
			)
		)
	)
)

(instance merlinMouth of Prop
	(properties)

	(method (cue)
		(self cycleSpeed: 1 setLoop: (Random 0 2) cel: 0 setCycle: End self)
	)
)

(instance crystalBall of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (introMusic prevSignal:) -1)
			(= seconds 0)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 109)
				(proc0_13 256)
				(gAddToPics doit:)
				(introMusic number: 5 play:)
				(= seconds 3)
			)
			(1
				(merlinMouth
					view: 609
					loop: 0
					cel: 0
					posn: 160 127
					cycleSpeed: 2
					init:
					cue:
				)
				(localproc_1 101 15 15 30 100) ; "I will watch over you and speak to you, though I will be with you only in spirit, not body."
			)
			(2
				(clr)
				(localproc_1 101 16 15 30 100) ; "Prepare well, Arthur, for once you begin, you dare not turn back. Seek the Holy Grail! Search with all speed and dedication. Time is running out."
			)
			(3
				(clr)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

