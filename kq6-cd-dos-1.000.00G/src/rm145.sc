;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 145)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use TimedCue)
(use Motion)
(use Actor)
(use System)

(public
	rm145 0
)

(local
	local0
)

(instance rm145 of KQ6Room
	(properties
		picture 98
		style 9
	)

	(method (init)
		(gTheIconBar disable:)
		(super init: &rest)
		(gCurRoom setScript: seqScr)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(ClearFlag 133)
		(DisposeScript 960)
		(super dispose:)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance eyeCue of TimedCue
	(properties
		register 1
	)

	(method (init param1 param2)
		(super init: param1 0 0)
		(= ticks param2)
	)
)

(class GlintingEye of Prop
	(properties
		view 902
		priority 15
		signal 16400
		caller 0
	)

	(method (cue)
		(if (not argc)
			(self setScript: eyeCue 12)
		else
			(if caller
				(caller cue:)
			)
			(self dispose:)
		)
	)

	(method (init param1)
		(if argc
			(= caller param1)
		)
		(super init: &rest)
		(self setCycle: End self)
	)
)

(instance hiEye1 of GlintingEye
	(properties
		x 188
		y 61
	)
)

(instance lowEye of GlintingEye
	(properties
		x 179
		y 126
	)
)

(instance hiEye2 of GlintingEye
	(properties
		x 180
		y 62
	)
)

(instance seqScr of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 100])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom
					drawPic: 98 (if (or (== gHowFast 0) global169) 9 else 12)
				)
				(if (IsFlag 41)
					(gGlobalSound number: 150)
					(= local0 1)
					(= register 3)
					(ClearFlag 41)
				else
					(gGlobalSound number: 145)
					(if (IsFlag 72)
						(= register 1)
					else
						(= register 2)
					)
					(SetFlag 41)
				)
				(gGlobalSound loop: -1 play:)
				(Message msgGET 145 1 0 4 1 @temp1) ; "Seconds later, in the castle...."
				(Display @temp1 dsCOORD 82 85 dsCOLOR 14 dsFONT 0)
				(= seconds 5)
			)
			(2
				(if local0
					(bottle init:)
				)
				(genie init:)
				(vizier init:)
				(gCurRoom
					drawPic: 145 (if (or (== gHowFast 0) global169) 9 else 11)
				)
				(= cycles 1)
			)
			(3
				(cond
					((== register 3)
						(roomConv
							add: -1 1 0 3 1 ; "(IRRITATED, SURPRISED) I TOLD you not to pop in like that! You can learn to knock like everybody else!"
							add: eyeGlintScr
							add: -1 1 0 3 2 ; "(EVILLY GLEEFUL) Sorry, Master, I couldn't help myself! I have great news!"
							add: eyeGlintScr
							add: -1 1 0 3 3 ; "Well? What is it?"
							add: eyeGlintScr
							add: -1 1 0 3 4 ; "Prince Alexander is dead! He killed himself in despair over losing Cassima. Tee, hee!"
							add: eyeGlintScr
							add: -1 1 0 3 5 ; "What? Are you positive? That young man has proven to be MOST devious."
							add: eyeGlintScr
							add: -1 1 0 3 6 ; "I saw the whole thing myself, Master. He was really and truly quite dead!"
							add: eyeGlintScr
							add: -1 1 0 3 7 ; "Hmmm. If what you say is true, it shall be most convenient. You've spent enough time on that little irritant. We must start thinking about the wedding."
							add: eyeGlintScr
							add: -1 1 0 3 8 ; "Anything, Master! Ooh, I do love weddings!"
							add: eyeGlintScr
							add: -1 1 0 3 9 ; "(SMILING) Well, we do want you to look your 'prettiest,' don't we?"
							add: eyeGlintScr
							add: -1 1 0 3 10 ; "Now, Shamir Shamazel, to the lamp with you! Prepare yourself, as we discussed."
							add: genieBottleScr
							init: self
						)
						(++ state)
					)
					((== register 1)
						(roomConv
							add: -1 1 0 1 1 ; "(DRUNK) Master! <hic> I followed Prince Alexander as you <hic> wished. From the pawn shop owner he just obstained...uh...just reprieved <hic>.... He just got a magic map."
							add: genieFallScr
							add: -1 1 0 1 2 ; "(IMPATIENT) You fool! You've been eating those mints again! I ordered you to stop that!"
							add: genieFallScr
							add: -1 1 0 1 3 ; "(HUMBLE) Yes, <hic> Master."
							add: eyeGlintScr
							add: -1 1 0 1 4 ; "Now what is this about a magic map?"
							add: eyeGlintScr
							add: -1 1 0 1 5 ; "With the map, Prince Alexander can travel anywhere as bickly <hic> uh...quickly as I can."
							add: eyeGlintScr
							add: -1 1 0 1 6 ; "(ANGRY) What? I thought I took care of the only means of travel! By my scimitar, I can't have him stirring things up now!"
							add: eyeGlintScr
							add: -1 1 0 1 7 ; "Get a hold of yourself and listen carefully, Shamir! Go to the other islands and tell them...."
							init: self
						)
						(++ state)
					)
					(else
						(roomConv
							add: -1 1 0 2 1 ; "Master! I was 'obsermving' <hic> in the village as you wished, and I saw a manger...no, a danger...no, a STRANGER there! He says <hic> he's Prince Blamentander of Smaventry."
							add: genieFallScr
							add: -1 1 0 2 2 ; "You fool! You've been eating those mints again! I ordered you to stop that!"
							add: genieFallScr
							add: -1 1 0 2 3 ; "(HUMBLE)Yes, <hic> Master."
							add: eyeGlintScr
							add: -1 1 0 2 4 ; "Now WHO did this stranger say he was?"
							add: eyeGlintScr
							add: -1 1 0 2 5 ; "Prince Salamander of Pagentry, I <hic> think."
							add: eyeGlintScr
							add: -1 1 0 2 6 ; "You idiot! Are you trying to tell me that Prince Alexander of Daventry is here?!"
							add: eyeGlintScr
							init: self
						)
					)
				)
			)
			(4
				(roomConv
					add: -1 1 0 2 7 ; "Confound it! That's the young man Cassima met at Mordack's castle! The timing could not be worse. Tell me, what is he doing?"
					add: eyeGlintScr
					add: -1 1 0 2 8 ; "He was in the pawn shop buying a magic <hic> smap."
					add: eyeGlintScr
					add: -1 1 0 2 9 ; "Magic smap? What is this magic smap?"
					add: eyeGlintScr
					add: -1 1 0 2 10 ; "With the smap he can travel to the other islands, Master."
					add: eyeGlintScr
					add: -1 1 0 2 11 ; "That's a MAP, you dolt! Drat it all, I thought I took care of the only means of travel!"
					add: eyeGlintScr
					add: -1 1 0 2 12 ; "By my scimitar, I can't have him stirring things up! Not now!"
					add: eyeGlintScr
					add: -1 1 0 2 13 ; "Get a hold of yourself and listen carefully, Shamir! Go to the other islands and tell them...."
					init: self
				)
			)
			(5
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(super dispose:)
		(genie dispose:)
		(vizier dispose:)
		(if (gCast contains: bottle)
			(bottle dispose:)
		)
		(gCurRoom drawPic: 98 9)
		(gCurRoom newRoom: 280)
	)
)

(instance vizier of Prop
	(properties
		x 62
		y 115
		view 1464
		signal 1
	)
)

(instance genie of Prop
	(properties
		x 157
		y 139
		view 1461
		signal 1
	)
)

(instance genieFallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 133)
				(DisposeScript 1013)
				(genie
					view: 1461
					loop: 1
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(1
				(gGlobalSound pause:)
				(gGlobalSound2 number: 147 loop: 1 play:)
				(vizier cycleSpeed: 15 setCycle: End)
				(genie view: 1462 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gGlobalSound2 number: 960 loop: 1 play:)
				(genie hide:)
				(vizier setCycle: Beg)
				(ScriptID 1013) ; Genie
				(= seconds 3)
			)
			(3
				(self dispose:)
			)
			(4
				(genie show: view: 1463 cel: 0 x: 205 y: 137 setCycle: End self)
			)
			(5
				(gGlobalSound pause: 0 setVol: 0 fade: 127 10 15 0)
				(genie stopUpd:)
				(vizier stopUpd:)
				(= cycles 2)
			)
			(6
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= start (+ state 1))
	)
)

(instance genieBottleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound2 number: 943 loop: 1 play:)
				(genie view: 1465 posn: 186 99 loop: 0 cycleSpeed: 8)
				(if register
					(genie cel: 6 setCycle: Beg self)
				else
					(genie cel: 0 setCycle: End self)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance eyeGlintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (Random 0 1) (gCast contains: genie))
					(cond
						((IsFlag 133)
							(lowEye init: self)
						)
						((Random 0 1)
							(hiEye1 init: self)
						)
						(else
							(hiEye2 init: self)
						)
					)
				else
					(self dispose:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance bottle of View
	(properties
		x 218
		y 151
		view 1465
		loop 1
	)
)

