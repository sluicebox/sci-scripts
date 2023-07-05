;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Talker)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm750 0
	Coroner 21
)

(local
	local0 = 1
	local1
	local2
	local3
	local4 = 1
	local5 = 1
)

(procedure (localproc_0)
	(= local1
		(Print
			addText: 5 0 0 1 0 0 ; "Pick a Person"
			addButton: 1 4 0 0 1 0 17 ; "Dr. Archibald Carrington III"
			addButton: 2 4 0 0 2 0 34 ; "Yvette Delacroix"
			addButton: 3 4 0 0 3 112 34 ; "Steve Dorian"
			addButton: 4 4 0 0 4 0 51 ; "Wolf Heimlich"
			addButton: 5 4 0 0 5 112 51 ; "Ernie Leach"
			addButton: 6 4 0 0 6 0 68 ; "Watney Little"
			addButton: 7 4 0 0 7 0 85 ; "Dr. Olympia Myklos"
			addButton: 8 4 0 0 8 112 68 ; "Rameses Najeer"
			addButton: 9 4 0 0 9 0 102 ; "Detective Hanrahan O'Riley"
			addButton: 10 4 0 0 10 0 119 ; "Dr. Ptahsheptut Smith"
			addButton: 11 4 0 0 11 0 136 ; "Countess Waldorf-Carlton"
			addButton: 12 4 0 0 12 0 153 ; "Lawrence 'Ziggy' Ziegfeld"
			init:
		)
	)
)

(procedure (localproc_1)
	(= local2
		(Print
			addText: 5 0 0 2 0 0 ; "Match a Motive"
			addButton: 1 6 0 0 1 0 17 ; "Self defense"
			addButton: 2 6 0 0 2 96 17 ; "Fear"
			addButton: 3 6 0 0 3 0 34 ; "Jealousy"
			addButton: 4 6 0 0 4 80 34 ; "Mercy"
			addButton: 5 6 0 0 5 0 51 ; "Thrill"
			addButton: 6 6 0 0 6 80 51 ; "Revenge"
			addButton: 7 6 0 0 7 0 68 ; "Mental deficiency"
			addButton: 8 6 0 0 8 0 85 ; "Professional killer"
			addButton: 9 6 0 0 9 0 102 ; "Financial gain"
			addButton: 10 6 0 0 10 0 119 ; "Cover another crime"
			addButton: 11 6 0 0 11 0 136 ; "To protect a loved one"
			addButton: 12 6 0 0 12 0 153 ; "Accident"
			addButton: 13 6 0 0 13 80 153 ; "Had a bad day"
			init:
		)
	)
)

(instance rm750 of LBRoom
	(properties
		picture 750
		style 10
	)

	(method (init)
		(LoadMany rsPIC 760)
		(LoadMany rsSOUND 760 120)
		(LoadMany rsVIEW 1750 752 753 760)
		(SetFlag 147)
		(super init:)
		(gEgo wearingGown: 0)
		(gTheIconBar disable:)
		(gGameMusic1 number: 120 flags: 1 loop: -1 play:)
		(reporters init:)
		(reporterHeads init:)
		(r_arm init: setCycle: RandCycle cycleSpeed: 48)
		(l_arm init: setCycle: RandCycle cycleSpeed: 48)
		(gCurRoom setScript: sBeforeAsking)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sBeforeAsking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame setCursor: 999)
				(gMessager say: 2 0 0 0 self) ; "Thank you for coming to this Inquest, Miss Bow. As the Coroner on this case, I'm going to informally question you and study the evidence you've collected. If you assist me in developing a case, the perpetrators will be tried in a formal court of law."
			)
			(2
				(= next sFirstFive)
				(self dispose:)
			)
		)
	)
)

(instance sFirstFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 0 local0 self)
			)
			(1
				(localproc_0)
				(if (!= local1 9)
					(= local4 0)
				)
				(localproc_1)
				(cond
					((!= local0 4)
						(if (and (!= local2 9) (!= local2 10))
							(= local4 0)
						)
					)
					((and (!= local2 6) (!= local2 3))
						(= local4 0)
					)
				)
				(if (< (++ local0) 6)
					(self changeState: 0)
				else
					(= cycles 2)
				)
			)
			(2
				(if (IsFlag 147)
					(= next sSixToNine)
				else
					(= local4 0)
					(= next sTenOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance sSixToNine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 6)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(6
						(if (!= local1 1)
							(= local4 0)
							(self changeState: 4)
						else
							(++ local0)
						)
					)
					(9
						(if (!= local1 9)
							(= local4 0)
						)
						(++ local0)
					)
					(else
						(if (!= local1 6)
							(= local4 0)
						)
						(++ local0)
					)
				)
				(if (< local0 10)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(3
				(localproc_1)
				(if (and (!= local2 9) (!= local2 10))
					(= local4 0)
				)
				(= cycles 1)
			)
			(4
				(= next sTenOn)
				(self dispose:)
			)
		)
	)
)

(instance sTenOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 10)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 0 local0 self)
			)
			(2
				(localproc_0)
				(switch local0
					(10
						(if (!= local1 6)
							(= local5 0)
							(+= local0 2)
						else
							(++ local0)
						)
						(= cycles 1)
					)
					(11
						(if (!= local1 9)
							(= local5 0)
						)
						(++ local0)
						(= cycles 1)
					)
					(12
						(if (!= local1 11)
							(= local0 15)
							(gMessager say: 8 0 6 0 self) ; "Based on our own investigation, your conclusion is incorrect, Miss Bow. Two of the men who were murdered were involved with one of the female victims in a plan to steal the paintings. We have a report on that woman, telling us she appeared at an appointment in the Medieval Armor exhibit some time after the party."
						else
							(++ local0)
							(gMessager say: 8 0 5 0 self) ; "Based on what we now know, your assumption is correct, Miss Bow. Good work!"
						)
					)
					(13
						(if (!= local1 6)
							(= local0 15)
							(gMessager say: 8 0 6 0 self) ; "Based on our own investigation, your conclusion is incorrect, Miss Bow. Two of the men who were murdered were involved with one of the female victims in a plan to steal the paintings. We have a report on that woman, telling us she appeared at an appointment in the Medieval Armor exhibit some time after the party."
						else
							(++ local0)
							(gMessager say: 8 0 5 0 self) ; "Based on what we now know, your assumption is correct, Miss Bow. Good work!"
						)
					)
					(14
						(if (!= local1 12)
							(gMessager say: 8 0 6 0 self) ; "Based on our own investigation, your conclusion is incorrect, Miss Bow. Two of the men who were murdered were involved with one of the female victims in a plan to steal the paintings. We have a report on that woman, telling us she appeared at an appointment in the Medieval Armor exhibit some time after the party."
						else
							(gMessager say: 8 0 5 0 self) ; "Based on what we now know, your assumption is correct, Miss Bow. Good work!"
						)
						(++ local0)
					)
					(15
						(if (!= local1 8)
							(gMessager say: 9 0 0 0 self) ; "That accusation is false, Miss Bow. However, the High Priest's identity is a carefully guarded secret, so your failure to identify him is nothing to be ashamed about. He was present at the museum party, but was rarely seen afterwards. One witness said he was spotted briefly in the office of Yvette Delacroix."
						else
							(gMessager say: 9 0 7 0 self) ; "That's correct, Miss Bow. You're very observant."
						)
						(++ local0)
					)
					(16
						(if (!= local1 5)
							(gMessager say: 10 0 0 0 self) ; "Incorrect, Miss Bow. If I were you, I would have looked through the garbage in people's offices. Trash cans are often a good source of clues."
						else
							(gMessager say: 10 0 8 0 self) ; "That assumption is correct. Mr. Leach was moonlighting with his own business as a fence installer. In fact, he put up a very nice fence around my house."
						)
						(++ local0)
					)
				)
			)
			(3
				(if (> local0 16)
					(= cycles 1)
				else
					(self changeState: 1)
				)
			)
			(4
				(= next sAfterQuestions)
				(self dispose:)
			)
		)
	)
)

(instance sAfterQuestions of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(cond
					(
						(and
							(gEgo has: 31) ; grapes
							(gEgo has: 26) ; bifocals
							(gEgo has: 27) ; redHair
							(gEgo has: 10) ; wireCutters
							local4
							local5
							(gEgo has: 11) ; daggerOfRa
						)
						(= local3 2)
					)
					(
						(and
							(gEgo has: 31) ; grapes
							(gEgo has: 26) ; bifocals
							(gEgo has: 27) ; redHair
							(gEgo has: 10) ; wireCutters
							local4
						)
						(= local3 1)
					)
					(local5
						(= local3 4)
					)
					((gEgo has: 11) ; daggerOfRa
						(= local3 10)
					)
					(else
						(= local3 3)
					)
				)
				(cond
					(
						(and
							(gEgo has: 31) ; grapes
							(gEgo has: 26) ; bifocals
							(gEgo has: 27) ; redHair
							(gEgo has: 10) ; wireCutters
							local4
							local5
							(gEgo has: 11) ; daggerOfRa
						)
						(= global126 1)
					)
					(
						(and
							(gEgo has: 31) ; grapes
							(gEgo has: 26) ; bifocals
							(gEgo has: 27) ; redHair
							(gEgo has: 10) ; wireCutters
							local4
						)
						(= global126 4)
					)
					(local5
						(= global126 2)
					)
					(else
						(= global126 3)
					)
				)
				(if (or (== local3 1) (== local3 2))
					(tut init:)
					(gMessager say: 7 0 0 0 self) ; "I have one final piece of evidence to present, Mr. Coroner. I have an eyewitness who would only feel safe to come forth if I established my case against Mr. O'Riley. Now that I've done so, let me introduce Dr. Ptahsheptut Smith of the Cairo Museum..."
				else
					(self changeState: 3)
				)
			)
			(1
				(tut setMotion: MoveTo -10 113 self)
			)
			(2
				(gMessager say: 7 0 9 0 self) ; "Mr. Smith's testimony is safe with us."
			)
			(3
				(gMessager say: 3 0 local3 0 self)
			)
			(4
				(cond
					((== global126 1)
						(gGameMusic2 number: 750 flags: 5 loop: 1 play:)
						(reporterHeads setCycle: End self)
					)
					((or (== global126 2) (== global126 4))
						(gGameMusic2 number: 751 flags: 5 loop: 1 play:)
						(reporterHeads setCycle: End self)
					)
					(else
						(gGameMusic2 number: 752 flags: 5 loop: 1 play:)
						(= seconds 4)
					)
				)
			)
			(5
				(if (== global126 3)
					(self changeState: 8)
				else
					(reporterHeads setLoop: 2 setCel: 0 setCycle: End self)
				)
			)
			(6
				(reporterHeads setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(reporterHeads setCel: 0 setLoop: 4 setCycle: Fwd)
				(= seconds 4)
			)
			(8
				(paper init: hide:)
				(headline
					init:
					loop: (if (OneOf global126 2 4) 2 else global126)
					hide:
				)
				(gCurRoom drawPic: 780)
				(gCast eachElementDo: #hide)
				(= cycles 2)
				(gGameMusic1 fade: 0 12 30 1)
			)
			(9
				(gGameMusic1 number: 760 flags: 1 loop: 1 play:)
				(paper show:)
				(paper setCycle: End self)
			)
			(10
				(gCurRoom drawPic: 760 100)
				(paper hide:)
				(= cycles 1)
			)
			(11
				(headline show:)
				(= seconds 4)
			)
			(12
				(gCurRoom
					newRoom:
						(switch global126
							(1 770)
							(2 775)
							(3 785)
							(4 770)
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance tut of Actor
	(properties
		x -60
		y 113
		view 753
	)
)

(instance reporterHeads of Prop
	(properties
		x 61
		y 73
		view 752
		loop 1
		signal 16384
	)
)

(instance paper of Prop
	(properties
		x 154
		y 96
		view 760
	)
)

(instance r_arm of Prop
	(properties
		x 255
		y 91
		view 752
		loop 5
	)
)

(instance l_arm of Prop
	(properties
		x 280
		y 90
		view 752
		loop 6
	)
)

(instance reporters of View
	(properties
		x 62
		y 72
		view 752
	)
)

(instance headline of View
	(properties
		x 33
		y 59
		view 760
	)
)

(instance Coroner of Talker
	(properties
		x 0
		y 0
		view 1750
		loop 3
		talkWidth 150
		back 15
		textX 10
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(super init: coronerBust coronerEyes coronerMouth &rest)
	)
)

(instance coronerBust of Prop
	(properties
		view 1750
		loop 1
	)
)

(instance coronerEyes of Prop
	(properties
		nsTop 77
		nsLeft 263
		view 1750
		loop 2
	)
)

(instance coronerMouth of Prop
	(properties
		nsTop 80
		nsLeft 264
		view 1750
	)
)

