;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 422)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Follow)
(use Motion)
(use System)

(public
	CherriScript 0
)

(instance CherriScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 422)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 10) (> (gEgo x:) 280))
			(self cue:)
		)
		(if
			(and
				(== gShowroomState 2)
				(== (client loop:) 4)
				(== (client x:) 82)
				(== (client y:) 124)
			)
			(switch (Random 0 6)
				(0
					(client setCel: 0)
				)
				(1
					(client setCycle: Fwd)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (!= gShowroomState 2) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'give/woman,cheri,dale,cheri')
					(Said 'give/anyword/woman,cheri,dale,cheri')
				)
				(Print 422 0) ; "Perhaps you should look at her first."
			)
			((Said 'look,look/woman,cheri,dale,cheri')
				(cond
					((!= gShowroomState 2)
						(Print 422 1) ; "Where?"
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= (client xLast:) (client x:))
						(Print 422 2) ; "You're too late. She's leaving."
					)
					((not (& (gEgo onControl:) $0020))
						(Print 422 3) ; "A beautiful woman is here, talking on the telephone. Perhaps you should walk over to her."
					)
					(else
						(self changeState: 1)
					)
				)
			)
			((and (== gShowroomState 2) (Said '/woman,cheri,dale,cheri'))
				(Print 422 4) ; "Perhaps you should establish eye contact first."
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 3 2)
		(switch (= state newState)
			(0
				(if (== gShowroomState 3)
					(self changeState: 3)
				)
				(if (== gShowroomState 1)
					(self changeState: 10)
					(client posn: -20 143 stopUpd:)
				)
			)
			(1
				(Ok) ; "O.K."
				(HandsOff)
				(= gEgoState 14)
				(Printf 422 5 global386 global387) ; ""Hello, beautiful. I loved your dancing," you say to the gorgeous woman in the dressing gown. %s%"
				(client setStep: 0 0 setMotion: Follow gEgo 222)
				(= seconds 3)
			)
			(2
				(if (not (TestFlag 48))
					(SetFlag 48) ; seenCherri
					(gGame changeScore: 5)
				)
				(Print 422 6) ; "Hello yourself, Larry," replies the bathrobed beauty, turning to face you. "I'm Cherri Tart."
				(= gPrevRoomX (gEgo x:))
				(= gPrevRoomY (gEgo y:))
				(= gPrevLoop (gEgo loop:))
				(gCurRoom newRoom: 435)
			)
			(3
				(HandsOff)
				(= seconds 3)
			)
			(4
				(Print 422 7) ; "I've certainly enjoyed our little chat together, Larry, and I'll look forward to hearing from you again soon! Now, if you'll pardon me, I must head backstage. Our stage manager has such a short fuse for a guy with such a sour disposition!"
				(= seconds 3)
			)
			(5
				(Print 422 8) ; "When you get the deed to the land, just knock softly on that door over there. I'll be waiting near the door. Till then."
				(client
					illegalBits: 0
					ignoreActors: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
				(if
					(and
						(> (gEgo y:) (client y:))
						(< (gEgo x:) (+ (client x:) 15))
					)
					(gEgo setCycle: Walk setMotion: MoveTo 97 (gEgo y:))
				)
			)
			(6
				(gSomeObject setCycle: End self)
			)
			(7
				(Print 422 9) ; "Oh, Larry," Cherri cries, "I can just picture my little country place now!"
				(gSomeObject stopUpd:)
				(client setMotion: MoveTo -20 140 self)
			)
			(8
				(gSomeObject setCycle: Beg self)
			)
			(9
				(gSoundFX number: 11 loop: 1 play:)
				(= gShowroomState 4)
				(gSomeObject stopUpd:)
				(NormalEgo)
				(gEgo observeControl: 16384 8192)
				(client dispose:)
			)
			(10
				(= seconds 15)
			)
			(11
				(if (< (gEgo x:) 160)
					(-- state)
					(= cycles 2)
				else
					(HandsOff)
					(gSomeObject setCycle: End self)
					(= seconds 0)
				)
			)
			(12
				(gSomeObject stopUpd:)
				(client
					posn: 13 140
					loop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
			)
			(13
				(gSomeObject setCycle: Beg self)
			)
			(14
				(gSoundFX number: 11 loop: 1 play:)
				(gSomeObject stopUpd:)
				(client setMotion: MoveTo 82 124 self)
			)
			(15
				(client loop: 4)
				(= gShowroomState 2)
				(HandsOn)
				(gEgo observeControl: 16384 8192)
			)
		)
	)
)

