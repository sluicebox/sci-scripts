;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm80 0
	thief 1
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(gTObj tWindow: thiefWindow)
	(gTObj talkCue: self)
	(Talk &rest)
)

(instance thief of Act
	(properties
		yStep 4
		view 345
		signal 16384
		illegalBits 0
		xStep 6
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== (gEgo view:) 46) (== (gEgo cel:) 4))
			(gCurRoom setScript: killThief)
		)
		(if local1
			(switch cel
				(1
					(-= y 5)
				)
				(2
					(-= y 7)
				)
				(3
					(-= y 2)
				)
				(4
					(-= y 1)
				)
				(5
					(-= y 8)
				)
				(6
					(-= y 7)
				)
			)
		)
	)
)

(instance theGrail of Act
	(properties
		y 124
		x 201
		yStep 6
		view 50
		cel 1
		signal 16384
		illegalBits 0
		xStep 5
	)
)

(instance sparkles of Prop
	(properties
		view 99
		signal 16384
	)
)

(instance thiefWindow of SysWindow
	(properties
		back 6
		title {Thief}
		brTop 50
		brLeft 60
		brBottom 70
		brRight 240
	)
)

(instance rope of Prop
	(properties
		y 40
		x 218
		view 374
	)

	(method (doit)
		(super doit:)
		(if local0
			(switch (thief cel:)
				(3
					(= x 219)
				)
				(2
					(= x 215)
				)
				(else
					(= x 216)
				)
			)
		)
	)
)

(instance ropeBottom of Act
	(properties
		y 104
		x 219
		yStep 7
		view 374
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance bottomBlock of Blk
	(properties
		top 200
		left -10
		bottom 210
		right 330
	)
)

(instance rightBlock of Blk
	(properties
		left 310
		bottom 210
		right 330
	)
)

(instance Rm80 of Rm
	(properties
		picture 80
	)

	(method (init)
		(Load rsVIEW 50)
		(Load rsVIEW 345)
		(Load rsVIEW 374)
		(Load rsVIEW 93)
		(Load rsVIEW 99)
		(Load rsSOUND 25)
		(Load rsSOUND 96)
		(Load rsSOUND 79)
		(Load rsSOUND 120)
		(Load rsSOUND 121)
		(super init:)
		(self setRegions: 184) ; Alley
		(self setRegions: 181) ; Thief
		(= global112 3)
		(gEgo observeBlocks: bottomBlock rightBlock)
		(switch gPrevRoomNum
			(79
				(gEgo posn: 10 170)
			)
			(else
				(gEgo posn: 100 150)
			)
		)
		(if (IsFlag 202)
			(gEgo view: 92 setStep: 6 4)
		)
		(gAddToPics doit:)
		(if (IsFlag 197)
			(HandsOff)
			(thief ignoreActors: 1)
			(gEgo ignoreActors: 1)
			(rope init: setPri: 10)
			(if (== global193 1)
				(= global193 -2)
				(SetFlag 201)
				(ClearFlag 202)
				(rope posn: 221 59 view: 374 loop: 7 cel: 6 stopUpd:)
				(gEgo setLoop: -1 setPri: -1 view: 0 setStep: 3 2)
				(gEgo setScript: screwedUp)
			)
			(if (> global193 1)
				(thief init: setScript: thiefRunsAway)
				(gEgo setScript: confrontThief)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 10)
				(gCurRoom newRoom: 79)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(global193
				(cond
					(
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,(are<where)>')
							(Said 'ask[/merlin]/*>')
						)
						(cond
							((or (Said '/bandit') (Said '//bandit'))
								(Print 80 0) ; "He grovels before you, pleading for mercy. You have two choices--take up the Grail and show him mercy, or draw your sword and strike him down."
							)
							(
								(or
									(Said '/aphrodite,goddess')
									(Said '//aphrodite,goddess')
								)
								(Print 80 1) ; "She is no longer concerned with these affairs. You must decide whether or not to show mercy to this man."
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 80 2) ; "The Thief offers it to you. You must decide whether to slay him, or take it and show him mercy."
							)
							(else
								(Print 80 3) ; "Arthur, this man is begging for mercy. You must deal with him. Nothing else matters."
								(event claimed: 1)
							)
						)
					)
					((Said 'talk[<to]/aphrodite,goddess')
						(Print 80 1) ; "She is no longer concerned with these affairs. You must decide whether or not to show mercy to this man."
					)
					((Said 'capture,stop,prevent/bandit')
						(Print 80 4) ; "Are you blind? He grovels in front of you."
					)
					((Said 'talk[<to]/bandit')
						(thief setScript: babble)
					)
					((Said 'fuck')
						(Print 80 5) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(
						(or
							(Said 'get,get/grail')
							(Said 'search/bandit')
							(Said 'show,give,give/absolution')
							(Said 'be/merciful')
						)
						(gCurRoom setScript: showMercy)
					)
					((Said 'draw/blade')
						(= global124 1)
						(= global136 1)
					)
					((Said 'get,kill,attack,annihilate/bandit')
						(gCurRoom setScript: killThief)
					)
					((Said 'give/*')
						(Print 80 6) ; "He deserves nothing from you except possibly your mercy. Either take the Grail or slay him."
					)
					((Said 'sell,bargain/*')
						(Print 80 7) ; "Do not be absurd. Either take the Grail and show him mercy, or draw your sword and slay him."
					)
					(else
						(Print 80 3) ; "Arthur, this man is begging for mercy. You must deal with him. Nothing else matters."
						(event claimed: 1)
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<!*][/room,alcove,alley]')
							(Said '//room,alcove,alley')
							(Said 'look<around')
						)
						(Print 80 8) ; "The alley ends here, going nowhere. All the other walls around you are featureless."
						(Print 80 9) ; "But to one side there is an alcove in which rests the weathered head of an ancient stone statue. And there is a window at the top of the alcove and another tiny grate at the bottom."
					)
					((Said '//temple')
						(if (IsFlag 207)
							(Print 80 10) ; "Why do you waste time here? Return to the Temple."
						else
							(Print 80 11) ; "Since this is a dead end, you seem to have no choice but to return to the Temple."
						)
					)
					(
						(or
							(Said '/grate,bar,drain,window')
							(Said '//grate,bar,drain,window')
						)
						(Print 80 12) ; "There is a tiny grate or barred opening of some sort at the base of this wall. I believe it may even be the top of a buried window."
						(Print 80 13) ; "And there is a small window high in this alcove, with a single metal bar across it."
					)
					((OnButton event 167 126 200 136)
						(Print 80 12) ; "There is a tiny grate or barred opening of some sort at the base of this wall. I believe it may even be the top of a buried window."
					)
					((OnButton event 197 7 239 46)
						(Print 80 14) ; "There is a small window high in this alcove, with a single metal bar across it."
					)
					((Said '//stair,entrance,exit,threshold')
						(Print 80 15) ; "The stairs and only entrance to the Temple are at the other end of this alley which ends here."
					)
					(
						(or
							(Said '/sculpture,head,face,giant')
							(Said '//sculpture,head,face,giant')
							(OnButton event 80 104 126 140)
						)
						(Print 80 16) ; "It could be the head of a god, a king, a warrior. Who can say? Perhaps the entire statue is buried. We shall never know its strange story."
					)
				)
			)
			((or (Said 'get,get/grail') (Said 'pick[<up]/grail'))
				(Print 80 17) ; "That would be wonderful, if it were here."
			)
			(
				(Said
					'get,roll,tip,move,press,carry,pull/sculpture,head,face,giant'
				)
				(Print 80 18) ; "That is quite impossible for it is partially buried and would weigh far more than you could manage to move."
			)
			((Said 'deface,attack,annihilate/sculpture,head,face,giant')
				(Print 80 19) ; "I hardly think such barbaric behaviour is called for."
			)
			((or (Said 'jump,climb') (Said 'reach,bar,base/window'))
				(Print 80 20) ; "The window is too high to reach."
			)
		)
	)
)

(instance thiefRunsAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global109 6)
				(thief setCycle: Fwd)
				(cond
					((> global193 50)
						(thief posn: (+ 133 (/ (- 50 global193) 2)) 172)
						(self changeState: 2)
					)
					((> global193 1)
						(self changeState: 3)
					)
					(else
						(self changeState: 11)
					)
				)
			)
			(1
				(thief setLoop: 2 setMotion: MoveTo 133 172 self)
			)
			(2
				(thief setLoop: 2 setMotion: MoveTo 173 144 self)
			)
			(3
				(thief
					posn: 173 144
					view: 374
					setLoop: 3
					cel: 0
					setCycle: CT 2 1
					setStep: 7 7
					setPri: 11
					setMotion: MoveTo 200 116 self
				)
			)
			(4
				(rope cel: 1)
				(thief posn: 224 116 cel: 2 setCycle: CT 4 1 self)
			)
			(5
				(SetFlag 201)
				(if (< global193 50)
					(= global193 -2)
					(self cue:)
				else
					(SetFlag 200)
					(= global193 1)
					(self changeState: 12)
				)
			)
			(6
				(rope loop: 1 cel: 0 cycleSpeed: 1 setCycle: End)
				(ropeBottom init: cycleSpeed: 1 setCycle: End)
				(= local1 1)
				(thief
					posn: 221 116
					loop: 4
					yStep: 0
					setCycle: Fwd
					setMotion: MoveTo 221 71 self
				)
			)
			(7
				(= local1 0)
				(thief posn: 221 59 loop: 5 cel: 0 setCycle: End self)
			)
			(8
				(ropeBottom dispose:)
				(thief cel: 0 loop: 6 setCycle: Fwd)
				(= local0 1)
				(rope cel: 0 x: 219 setCycle: End self)
			)
			(9
				(= local0 0)
				(rope posn: 221 59 view: 374 loop: 7 cel: 6 stopUpd:)
				(ClearFlag 202)
				(gEgo view: 0)
				(gEgo setLoop: -1 setPri: -1 setStep: 3 2)
				(thief loop: 7 setCycle: End self)
			)
			(10
				(gEgo setScript: screwedUp)
				(thief dispose:)
				(gRegMusic stop:)
				(SetFlag 316)
				(self dispose:)
			)
			(11
				(self dispose:)
			)
			(12
				(rope loop: 1 cel: 3)
				(ropeBottom
					init:
					y: (- (ropeBottom y:) 4)
					view: 374
					setLoop: 9
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo 215 143
				)
				(thief
					view: 374
					loop: 8
					posn: 224 100
					cel: 0
					setCycle: CT 3 1
					yStep: 8
					setMotion: MoveTo 218 123 self
				)
			)
			(13
				(Print 80 21 #at 50 20) ; "Nay, your god smiles upon you! His rope has broken!"
				(thief setMotion: MoveTo 204 144 self)
			)
			(14
				(gRegMusic stop:)
				(gSFX number: 25 loop: 1 play:)
				(ClearFlag 202)
				(gEgo
					view: 0
					ignoreActors: 1
					setStep: 3 2
					setLoop: -1
					setPri: -1
				)
				(thief setCycle: CT 6 1 self)
			)
			(15
				(thief view: 345 setPri: -1)
				(ropeBottom setPri: -1 stopUpd:)
				(rope stopUpd:)
				(confrontThief cue:)
				(gSFX number: 96 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance screwedUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 63)
					(gEgo setMotion: MoveTo 63 173 self)
				else
					(self cue:)
				)
			)
			(1
				(Print 80 22 #at 60 15) ; "By all that is holy, you have dallied shamelessly and the Thief has escaped. There is no hope for you, Arthur. You may as well fall upon your sword."
				(gEgo setMotion: MoveTo 157 155 self)
			)
			(2
				(= global195 1)
				(SetFlag 316)
				(self dispose:)
			)
		)
	)
)

(instance confrontThief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 80 23) ; "By all the gods, he will escape!"
				(gEgo setMotion: MoveTo 62 173 self)
			)
			(1
				(gEgo setMotion: MoveTo 158 145 self)
			)
			(2
				(if (not (gEgo mover:))
					(gEgo view: 0 x: 170 cel: 1)
				)
			)
			(3
				(gEgo view: 0 x: 170 cel: 1)
				(thief setLoop: 6 cel: 0 setCycle: CT 9 1 self)
			)
			(4
				(localproc_0 80 24) ; "Mercy, master, mercy! I am only a poor, miserable wretch! Have mercy!"
			)
			(5
				(thief cel: 10)
				(localproc_0 80 25) ; "Here is your treasure, untouched! Take it and let me live, I beg you! Have mercy!"
			)
			(6
				(Print 80 26) ; "He is a pathetic creature. You must choose, Arthur. Either take up the Grail now in an act of mercy....or draw your sword and slay him."
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance showMercy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 0 2 5)
				(gEgo setMotion: MoveTo 187 146 self)
			)
			(1
				(gEgo view: 93 cel: 0)
				(= cycles 2)
			)
			(2
				(gEgo get: 6 view: 0 cel: 0) ; iron_key | broom | grail
				(thief setLoop: 7 cel: 0)
				(= seconds 2)
			)
			(3
				(gEgo setMotion: MoveTo 121 176)
				(thief setCycle: CT 3 1 self)
			)
			(4
				(gSFX number: 121 loop: 1 play:)
				(thief
					setCycle: End
					setStep: 9 9
					setMotion: MoveTo 180 156 self
				)
			)
			(5
				(thief cel: 4 setCycle: CT 0 -1 self)
			)
			(6
				(gEgo setMotion: 0 loop: 0)
				(= cycles 2)
			)
			(7
				(Print 80 27) ; "By the gods, he dared to stab you in the back! If not for your mail tunic, you would be dead at the hands of this foul dog."
				(Print 80 28) ; "It is time to let the Grail decide his fate."
				(= seconds 2)
			)
			(8
				(gSFX number: 120 loop: 1 play: self)
				(gEgo view: 99 setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(sparkles
					init:
					posn: (+ (gEgo x:) 19) (- (gEgo y:) 42)
					setLoop: 1
					setCycle: Fwd
				)
			)
			(10
				(thief view: 99 setLoop: 2 setCycle: End self)
			)
			(11
				(= seconds 1)
			)
			(12
				(sparkles dispose:)
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo view: 0)
				(= cycles 2)
			)
			(14
				(Print 80 29) ; "And so, he comes to the end he deserves."
				(Print 80 30) ; "Now you must move quickly to find Galahad and return to Camelot."
				(gEgo setScript: takeOffHoser)
				(self dispose:)
			)
		)
	)
)

(instance killThief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo view:) 46)
					(self changeState: 2)
				else
					(gEgo view: 4 setCycle: End self)
				)
			)
			(1
				(gEgo view: 46 cel: 0 setCycle: End)
				(gSFX number: 79 loop: 1 play:)
			)
			(2
				(theGrail init: setLoop: 5 setPri: 11 setMotion: MoveTo 192 148)
				(thief
					setLoop: 8
					cel: 0
					posn: (+ (thief x:) 6) (+ (thief y:) 3)
					setCycle: End self
				)
			)
			(3
				(if (not global124)
					(gEgo view: 4 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(4
				(if (and global124 (== (gEgo view:) 6))
					(= global125 2)
				)
				(= cycles 1)
			)
			(5
				(if (gEgo cel:)
					(self changeState: 4)
				else
					(self cue:)
				)
			)
			(6
				(Print 80 31) ; "I do not blame you for slaying him after all the grief he has caused you. The merchants of Jerusalem would no doubt thank you."
				(HandsOff)
				(gEgo view: 0)
				(gEgo setMotion: MoveTo 172 150 self)
			)
			(7
				(gEgo view: 93 cel: 0 setCycle: CT 2 1 self)
			)
			(8
				(theGrail dispose:)
				(gEgo get: 6 setCycle: End self) ; iron_key | broom | grail
			)
			(9
				(Print 80 32) ; "At least the Grail is unharmed. Now you must move quickly to find Galahad and return to Camelot."
				(gEgo setScript: takeOffHoser)
				(self dispose:)
			)
		)
	)
)

(instance takeOffHoser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Walk
					setLoop: -1
					setPri: -1
					view: 0
					setMotion: MoveTo 84 172 self
				)
			)
			(1
				(gEgo setMotion: MoveTo -9 172 self)
			)
			(2
				(Load rsPIC 78)
				(gCurRoom newRoom: 92) ; endGame
			)
		)
	)
)

(instance babble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 80 33) ; "Mercy, I beg you, show mercy!"
			)
			(1
				(self dispose:)
			)
		)
	)
)

