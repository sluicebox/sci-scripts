;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	regDune 0
	DUNELOOPER 1
	proc501_2 2
	proc501_3 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 12]
)

(procedure (proc501_2 param1 &tmp temp0)
	(if (& (= temp0 (OnControl PRIORITY (gEgo x:) (gEgo y:))) param1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc501_3 param1 &tmp temp0)
	(for ((= temp0 0)) param1 ((++ temp0))
		(>>= param1 $0001)
	)
	(return (- temp0 1))
)

(class AView of View
	(properties)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance footPrint of AView
	(properties)
)

(class dMoveTo of Motion
	(properties)

	(method (init param1 param2 param3 param4 &tmp [temp0 2])
		(= client param1)
		(= x param2)
		(if (!= (gEgo looper:) 0)
			(= y (+ (gEgo y:) (- (gEgo y:) param3)))
		else
			(= y param3)
		)
		(if (== argc 4)
			(= caller param4)
		)
		(= b-moveCnt 0)
		(param1 heading: (GetAngle (param1 x:) (param1 y:) x y))
		(if (== global104 1)
			(cond
				((or (< (gEgo heading:) 45) (> (gEgo heading:) 315))
					(gEgo loop: 2)
				)
				((and (>= (gEgo heading:) 45) (< (gEgo heading:) 135))
					(gEgo loop: 0)
				)
				((and (>= (gEgo heading:) 135) (< (gEgo heading:) 225))
					(gEgo loop: 3)
				)
				(else
					(gEgo loop: 1)
				)
			)
		else
			(DirLoop param1 (param1 heading:))
		)
		(InitBresen self)
	)
)

(instance regDune of Rgn
	(properties)

	(method (notify param1)
		(switch param1
			(1
				(global111 view: 777 setCycle: Walk setScript: tActions)
				(= local0 0)
			)
			(2
				(global111 dispose:)
			)
			(3
				(global111 view: 777 setMotion: 0 setScript: 0 ignoreActors:)
			)
			(4
				(if (== (Random 1 4) 3)
					((= local6 (ScriptID 511 0)) init:) ; bug
				)
			)
		)
	)

	(method (dispose)
		(User mapKeyToDir: 1)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(Load rsVIEW 777)
		(Load rsVIEW 82)
		(Load rsVIEW 0)
		(Load rsVIEW 68)
		(Load rsVIEW 106)
		(Load rsVIEW (LangSwitch 108 322))
		(User mapKeyToDir: 0)
		(super init:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (event claimed:)
			(return 1)
		)
		(if (== (User controls:) 1)
			(= temp0 (event type:))
			(MapKeyToDir event)
			(switch (event type:)
				(evMOUSEBUTTON
					(if (and (gCurRoom controls:) (IsObject gEgo))
						(= global108 (event y:))
						(= global107 (event x:))
						(= global162 (gEgo y:))
						(gEgo setMotion: dMoveTo (event x:) (event y:))
						(User prevDir: 0)
						(event claimed: 1)
					)
				)
				($0040 ; direction
					(if (and (gCurRoom controls:) (IsObject gEgo))
						(= temp5 (event message:))
						(= global107 0)
						(= global108 0)
						(if
							(and
								(== temp0 evKEYBOARD)
								(== global106 temp5)
								(IsObject (gEgo mover:))
							)
							(= temp5 JOY_NULL)
						)
						(= global106 temp5)
						(if (== temp5 JOY_NULL)
							(gEgo setMotion: 0)
							(event claimed: 1)
							(return)
						)
						(if
							(and
								(gEgo mover:)
								(==
									temp5
									(cond
										(
											(or
												(== global104 0)
												(== global104 4)
												(== global104 2)
											)
											(cond
												((== (gEgo heading:) 0) 1)
												((< (gEgo heading:) 90) 2)
												((== (gEgo heading:) 90) 3)
												((< (gEgo heading:) 180) 4)
												((== (gEgo heading:) 180) 5)
												((< (gEgo heading:) 270) 6)
												((== (gEgo heading:) 270) 7)
												(else 8)
											)
										)
										((== (gEgo heading:) 180) 1)
										((< (gEgo heading:) 90) 4)
										((== (gEgo heading:) 90) 3)
										((< (gEgo heading:) 180) 2)
										((== (gEgo heading:) 0) 5)
										((< (gEgo heading:) 270) 8)
										((== (gEgo heading:) 270) 7)
										(else 6)
									)
								)
							)
							(event claimed: 1)
							(return)
						)
						(= temp1 (gEgo x:))
						(= temp2 (gEgo y:))
						(= temp3 (* (gEgo xStep:) 400))
						(= temp4 (* (gEgo yStep:) 400))
						(if
							(and
								(!= global104 0)
								(!= global104 4)
								(!= global104 2)
							)
							(*= temp4 -1)
						)
						(switch temp5
							(JOY_UP
								(-= temp2 temp4)
							)
							(JOY_UPRIGHT
								(+= temp1 temp3)
								(-= temp2 temp4)
							)
							(JOY_RIGHT
								(+= temp1 temp3)
							)
							(JOY_DOWNRIGHT
								(+= temp1 temp3)
								(+= temp2 temp4)
							)
							(JOY_DOWN
								(+= temp2 temp4)
							)
							(JOY_DOWNLEFT
								(-= temp1 temp3)
								(+= temp2 temp4)
							)
							(JOY_LEFT
								(-= temp1 temp3)
							)
							(JOY_UPLEFT
								(-= temp1 temp3)
								(-= temp2 temp4)
							)
						)
						(gEgo setMotion: MoveTo temp1 temp2)
						(event claimed: 1)
					)
				)
				(evSAID
					(cond
						((Said 'look,look>')
							(cond
								((Said '/desert')
									(Print 501 0) ; "It seems like this entire planet is one vast expanse of desert. About all you see is sand and rocks."
								)
								((Said '/dirt,dirt')
									(PrintSplit 501 1) ; "The ground beneath your feet is composed of an unusually colored sand. Other than it's bizzare coloration, you have no other interest in it. However... as you expectorate a mouthful of the wind blown sand you briefly reminisce about your adventure on Kerona (SQ I )."
								)
								((Said '/dune')
									(Print 501 2) ; "There are sand dunes over most of Phleebhut. They hold no particular interest for you, except as an annoying obstacle to your progress."
								)
								((or (Said '/dirt') (Said '<down'))
									(PrintSplit 501 3) ; "The ground beneath your feet is composed of an unusually colored sand. Other than it's bizarre coloration, you have no other interest in it. However... as you expectorate a mouthful of the wind blown sand you briefly reminisce about your adventure on Kerona (SQ I )."
								)
								((Said '/lightning')
									(Print 501 4) ; "You notice flashes of lightning to the north. You hope it doesn't move this way."
								)
								((or (Said '/cloud,air') (Said '<up'))
									(Print 501 5) ; "The sky is alive with electrical activity as large ominous clouds make their way across the darkened sky."
								)
								((Said '/down')
									(Print 501 6) ; "You see your feet."
								)
								((Said '/bug')
									(if (gCast contains: local6)
										(Print 501 7) ; "What a cute little scorpazoid! Perhaps you should pick it up and take it with you."
									else
										(Print 501 8) ; "You don't see one here."
									)
								)
								((Said '/butte,hill')
									(Print 501 9) ; "A range of craggy peaks appear on the horizon far to the north. Occasionally, one is struck by lightning."
								)
								((Said '/footprint')
									(if (gCast contains: global111)
										(Print 501 10) ; "Hmm. The footprints seem to be following you. I wonder who they could belong to."
									else
										(Print 501 11) ; "You don't see any here."
									)
								)
								((Said '/rock')
									(Print 501 12) ; "The worn rocks seem to give evidence of millions of years of fierce sandstorms. Sure hope one of them doesn't come up while you're here."
								)
								((Said '/cloud')
									(Print 501 13) ; "Yes, those are clouds. I wonder if they contain water vapor, or some highly toxic substance such as ..."
								)
								((Said '/butte')
									(Print 501 14) ; "The mountains are closer now."
								)
							)
						)
						((Said 'get,get>')
							(cond
								((Said '/dirt')
									(Print 501 15) ; "You don't see any reason to do that."
								)
								((Said '/rock')
									(Print 501 16) ; "You don't see any reason to do that. Besides, most of them are too big to carry anyway."
								)
								((Said '/bug')
									(if (gCast contains: local6)
										(Print 501 17) ; "You'll have to get close enough first."
									else
										(Print 501 18) ; "You don't see one here."
									)
								)
							)
						)
						((Said 'hide')
							(Print 501 19) ; "You can run, but you can't hide."
						)
						((Said 'dig')
							(Print 501 20) ; "You might chap your delicate hands since you don't have a shovel."
						)
						((or (Said 'kill/bug') (Said 'step,stair/bug'))
							(if (gCast contains: local6)
								(Print 501 21) ; "You need to get close enough."
							)
						)
						((Said 'climb,sit,crawl,lie,lie')
							(Print 501 22) ; "That would serve no purpose."
						)
						((Said 'talk,talk/android')
							(if (gCast contains: global111)
								(Print 501 23) ; "I don't think he's interested in talking."
							else
								(Print 501 24) ; "You don't see anyone here to talk to."
							)
						)
					)
				)
			)
		)
	)
)

(instance DUNELOOPER of Script
	(properties)

	(method (doit)
		(if (or (== global104 1) (== global104 3))
			(gEgo
				loop:
					(cond
						(
							(or
								(< (gEgo heading:) 45)
								(> (gEgo heading:) 315)
							)
							2
						)
						(
							(and
								(>= (gEgo heading:) 45)
								(< (gEgo heading:) 135)
							)
							0
						)
						(
							(and
								(>= (gEgo heading:) 135)
								(< (gEgo heading:) 225)
							)
							3
						)
						(else 1)
					)
			)
		else
			(DirLoop gEgo (gEgo heading:))
		)
	)
)

(instance tActions of Script
	(properties)

	(method (doit)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (!= global104 0) (== local0 1))
			(= local0 (= state 7))
			(global111
				setMotion: MoveTo global112 global113 self
				ignoreControl: 2
			)
		)
		(if (and (== local0 7) (& (global111 onControl:) $0002))
			(global111 view: 777 setMotion: 0)
			(self changeState: 8)
			(= local0 8)
		)
		(if (and (or (== local0 8) (== local0 7)) (== global104 0))
			(global111
				view: 106
				observeControl: 2
				setAvoider: Avoid
				setMotion: Chase gEgo 10 self
			)
			(= seconds 0)
			(= local0 (= state 1))
		)
		(if
			(and
				(!= local0 10)
				(&
					(OnControl
						PRIORITY
						(- (global111 x:) 9)
						(- (global111 y:) 3)
						(+ (global111 x:) 9)
						(global111 y:)
					)
					global591
				)
			)
			(if (== local0 1)
				(global111 posn: local1 (+ local2 3))
				(= seconds 0)
				(= state 1)
				(global111 setAvoider: Avoid setMotion: Chase gEgo 10 self)
			else
				(global111 setMotion: 0 ignoreActors: view: 777)
			)
		)
		(if (!= (OnControl VISUAL (global111 x:) (global111 y:)) 0)
			(= local1 (global111 x:))
			(= local2 (global111 y:))
		)
		(if
			(and
				(or (== local0 1) (== local0 7))
				(or
					(== (global111 cel:) 0)
					(if (< (global111 loop:) 2)
						(== (global111 cel:) 4)
					else
						(== (global111 cel:) 3)
					)
				)
			)
			(= local3 (OnControl PRIORITY (global111 x:) (global111 y:)))
			(if
				(and
					(!= (= local3 (proc501_3 local3)) -1)
					(!= (global111 view:) 777)
				)
				(footPrint
					view: 106
					loop: (global111 loop:)
					cel: (global111 cel:)
					ignoreActors: 1
					posn: (global111 x:) (global111 y:)
					addToPic:
				)
			)
		)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds global114)
			)
			(1
				(if (== global104 0)
					(global111
						view: 106
						setMotion: Chase gEgo 10 self
						setAvoider: Avoid
						ignoreActors:
					)
					(= local0 1)
				else
					(= local0 (= state 7))
					(global111
						view: 106
						setMotion: MoveTo global112 global113 self
						ignoreControl: 2
					)
				)
			)
			(2
				(if (!= gCurRoomNum gNewRoomNum)
					(return)
				)
				(= local0 10)
				(= global116 1)
				(HandsOff)
				(global111
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x:) (gEgo y:)
				)
				(gEgo
					view: 106
					setLoop: 4
					cel: 255
					ignoreHorizon:
					illegalBits: 0
					setCycle: End
					setPri: (gEgo priority:)
					setStep: 4 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 11)
						(- (gEgo y:) 15)
						self
				)
				(RedrawCast)
			)
			(3
				(gEgo setLoop: 5 setCycle: Fwd)
				(global111
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority:)
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(4
				(global111
					view: 106
					setLoop: 7
					setPri: (gEgo priority:)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(5
				(gEgo hide:)
				(= local4 (Sound new:))
				(local4 number: 97 loop: -1 priority: 99 play:)
				(global111 setLoop: 8 setCycle: Fwd)
				(= seconds 6)
			)
			(6
				(local4 stop:)
				(global111 setLoop: 8 setCel: 0)
				(EgoDead 901 0 14 16)
			)
			(8
				(= seconds 12)
				(= local0 8)
			)
			(9
				(if (and (!= global104 1) (!= global104 0))
					(= seconds (= state 8))
				else
					(self changeState: 2)
				)
			)
		)
	)
)

