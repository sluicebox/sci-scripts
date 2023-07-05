;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 157)
(include sci.sh)
(use Main)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Mari 0
	proc157_1 1
)

(synonyms
	(veil scarf)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (proc157_1)
	(Face gEgo global184)
	(gTObj tWindow: mariWindow actor: 0)
)

(procedure (localproc_0)
	(Face gEgo global184)
	(gTObj tWindow: mariWindow actor: 0)
	(Talk &rest)
)

(instance fallingVeil of Act
	(properties
		view 351
		priority 15
		signal 16400
		illegalBits 0
	)
)

(instance thrownMirror of Act
	(properties
		view 351
		priority 15
		signal 16400
		illegalBits 0
	)
)

(instance mariWindow of SysWindow
	(properties
		color 4
		back 13
		title {Mari}
		brTop 5
		brLeft 145
		brBottom 100
		brRight 315
	)
)

(instance Mari of Act
	(properties
		y 35
		x 127
		view 351
		priority 3
		signal 16400
		illegalBits 0
	)

	(method (init)
		(super init:)
		(= global184 Mari)
		(self stopUpd:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (not (IsFlag 145)) (global184 script:)) 0)
			((not (gEgo inRect: 60 0 210 200))
				(= local0 0)
				(if (gCast contains: fallingVeil)
					(fallingVeil dispose:)
				)
				(global184 setScript: (ScriptID 56 2)) ; closeShutters
			)
			((not local0)
				(= local0 1)
				(cond
					((not (IsFlag 166))
						(SetFlag 166)
						(localproc_0 157 0) ; "Mmmmm, so who are you, with lungs like the hamsin, the all-powerful wind? I see you are a foreigner, but from the look of you, not a very rich one. I only have time for rich men."
					)
					((IsItemAt 11) ; mirror | golden_apple
						(localproc_0 157 1) ; "Oh, it is you again. The mirror is wonderful. Well, what do you want? Speak up, I have a customer arriving soon."
					)
					(else
						(localproc_0 157 2) ; "You grow annoying. What do you want, infidel?"
					)
				)
			)
		)
	)

	(method (handleEvent event)
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
			((not (IsFlag 145))
				(return)
			)
			((Said '*/girl')
				(Print 157 3) ; "I do not think the word "girl" is appropriate for this strumpet."
			)
			(
				(or
					(Said 'look/mari,woman,jewelry')
					(Said 'ask/merlin/mari,woman,jewelry')
					(MouseClaimed self event)
				)
				(Print 157 4) ; "From the layers of paint upon her face, the excessive jewelry, the dyed hair and other signs, I would call this woman more than a trifle vain."
			)
			((or (Said 'look/window') (OnButton event 113 7 141 38))
				(Print 157 5) ; "The woman, Mari, is not shy about displaying her attributes."
			)
			((Said 'smell')
				(Print 157 6) ; "The smell of her cheap ointments overwhelms even the odors of the gutter."
			)
			((global184 script:)
				(if
					(or
						(Said '/mari')
						(Said '//mari')
						(Said 'use,give,sell,buy,talk,ask,bargain')
					)
					(Print 157 7) ; "She pays no attention to you at the moment."
				else
					(return)
				)
			)
			((or (Said 'call,yell[/mari]') (Said 'call,yell//mari'))
				(localproc_0 157 8) ; "Chalas! Enough! I can hear you."
			)
			((Said 'draw/blade')
				(localproc_0 157 9) ; "Ooh, big tough man. I am soooooo frightened. Better put away your sword, stupid infidel. One scream from me and the city guards will come running."
				(= global125 2)
			)
			((Said 'talk[/mari,woman]')
				(cond
					((IsItemAt 11) ; mirror | golden_apple
						(localproc_0 157 10) ; "I cannot stand here talking all day. I have business to do. If you want something, speak up."
					)
					((not local1)
						(= local1 1)
						(localproc_0 157 11 157 12) ; "I am very unhappy right now. I know I am very beautiful, but I have no way to see my own beauty as others see it."
					)
					(else
						(localproc_0 157 2) ; "You grow annoying. What do you want, infidel?"
					)
				)
			)
			((Said 'use,give,show/mirror')
				(cond
					((not (gEgo has: 11)) ; mirror | golden_apple
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((or (not (IsFlag 314)) local4)
						(localproc_0 157 13) ; "My arms are not that long, foolish man, but... mmmm...I would dearly love to have that mirror."
					)
					(else
						(= local4 1)
						(gEgo setScript: tryToGiveMirror)
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(localproc_0 157 14 157 15) ; "If it were only money I wanted, I could have taken money from Ibrahim. But he dared to say I was vain because I wish to see my own beauty and he would have no part of it."
				(proc0_18)
			)
			((Said 'give/ass')
				(localproc_0 157 16) ; "What would I want with a mule, silly man?"
			)
			((Said 'give')
				(localproc_0 157 17) ; "I do not want that. Quit wasting my time."
			)
			((and (IsItemAt 11) (Said 'buy/veil')) ; mirror | golden_apple
				(localproc_0 157 18) ; "Since you gave me the mirror, I will give you the veil as a favor. Wait a moment."
				(gEgo setScript: mariGetsVeil)
			)
			(
				(or
					(Said 'get,beg/veil')
					(Said 'ask[/mari,woman]/veil')
					(Said 'want<me/veil')
				)
				(cond
					((IsItemAt 11) ; mirror | golden_apple
						(localproc_0 157 19) ; "Well.....since you gave me the mirror, I will do you this favor. Wait a moment."
						(gEgo setScript: mariGetsVeil)
					)
					((not local3)
						(SetFlag 314)
						(localproc_0 157 20 157 21) ; "If you are a friend of Ibrahim, you are no friend of mine. He prefers his wife to me, the scoundrel. Let him suffer. He will never get the veil from me."
						(= local3 1)
					)
					(else
						(localproc_0 157 22) ; "I told you, I will exchange it for a way to see for myself how beautiful I am."
					)
				)
			)
			((Said 'buy>')
				(if (Said '/weapon,blade,shield,armor')
					(Print 157 23) ; "Whatever for? Your sword and armour are unequaled in quality."
				else
					(event claimed: 1)
					(localproc_0 157 24) ; "You are more a boy than a man if you think that is what I sell."
				)
			)
			(
				(or
					(Said 'fuck,kiss,hug/mari,woman')
					(Said 'ask[/mari,woman]/coitus,goods')
				)
				(Print 157 25) ; "I shudder to think what you would catch if you were to do so."
			)
			((Said 'open<to<(mari,woman)<ask/door')
				(localproc_0 157 26) ; "Open my door to you? You could not afford me."
			)
			((Said 'ask[/mari,woman]/*>')
				(cond
					((Said '//ibrahim')
						(localproc_0 157 27) ; "I do not want to talk about the scoundrel. I hope he suffers because he will never get the veil from me."
					)
					((Said '//mohammed')
						(localproc_0 157 28) ; "Mmmmm, I would dearly love him as a customer, but he has no time for me."
					)
					((Said '//fat')
						(localproc_0 157 29) ; "He is a fat, prudish pig who will not do business with me."
					)
					((Said '//customer')
						(localproc_0 157 30) ; "I only have time for rich men."
					)
					((Said '//beauty,vanity')
						(localproc_0 157 31) ; "I will only be happy when I can see for myself how beautiful I am."
					)
					((Said '//mirror')
						(localproc_0 157 32) ; "A woman as beautiful as me should have a mirror."
					)
					((Said '//fatima')
						(localproc_0 157 33) ; "Her? Hah! Men think she is so beautiful, but she is nothing compared to me!"
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_0 157 34) ; "Oh, quit wasting my time."
					)
				)
			)
			((Said 'buy/veil')
				(localproc_0 157 35) ; "My, Ibrahim must grow desperate indeed to send you after his precious veil. You may tell him it is not for sale."
			)
			((Said 'throw/*[/mari]>')
				(cond
					((Said '/mirror')
						(if (not (gEgo has: 11)) ; mirror | golden_apple
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						else
							(gEgo setScript: throwMirror)
						)
					)
					(global140
						(event claimed: 1)
						(Print 157 36) ; "This overpainted trollop can do without that."
					)
					(else
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
			((and global140 (Said 'sell,bargain'))
				(localproc_0 157 37) ; "You truly are a pest. Go away."
			)
			((Said 'help/mari')
				(Print 157 38) ; "This damsel is not in distress, Arthur."
			)
			((Said 'climb/window,awning,wall')
				(Print 157 39) ; "Totally impractical with all your gear, not to mention how it might excite the city guards."
			)
		)
	)
)

(instance tryToGiveMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_0 157 40) ; "So, you are smarter than you look."
			)
			(1
				(global184
					setLoop: 2
					setPri: 3
					setCycle: Fwd
					setMotion: MoveTo (+ (global184 x:) 20) (global184 y:) self
				)
			)
			(2
				(global184
					setLoop: 3
					setMotion: MoveTo (- (global184 x:) 20) (global184 y:) self
				)
			)
			(3
				(= local5 1)
				(global184
					setLoop: 5
					cel: 0
					setPri: 11
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(global184 setCycle: Beg)
				(gTObj talkCue: self)
				(localproc_0 157 41) ; "When I have the mirror, you may have the veil."
			)
			(5
				(fallingVeil setLoop: 8 posn: 125 37 init:)
				(global184 setLoop: 1 cycleSpeed: 0 cel: 0)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance throwMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 125 155 self)
			)
			(1
				(gEgo view: 63 loop: 0 cel: 0)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: CT 4 1 self)
			)
			(3
				(PutItem 11) ; mirror | golden_apple
				(SetFlag 149)
				(++ global146)
				(gEgo setCycle: End)
				(thrownMirror
					setLoop: 9
					posn: 145 91
					cycleSpeed: 1
					setCycle: Fwd
					init:
					setStep: 3 6
					setMotion: MoveTo 145 81 self
				)
			)
			(4
				(thrownMirror setStep: 3 5 setMotion: MoveTo 140 60 self)
			)
			(5
				(thrownMirror setStep: 3 4 setMotion: MoveTo 137 20 self)
			)
			(6
				(thrownMirror setMotion: MoveTo 134 44 self)
				(global184 setLoop: 6 setCel: 0 setCycle: CT 1 1)
			)
			(7
				(thrownMirror setCycle: 0 setCel: 1 hide:)
				(global184
					setLoop: 6
					setCel: 2
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(8
				(= cycles 12)
			)
			(9
				(gEgo
					view: 0
					setLoop: -1
					loop: 3
					cycleSpeed: 0
					setCycle: Walk
				)
				(SetScore 0 0 5)
				(client setScript: 0)
				(if (IsFlag 314)
					(client setScript: mariGetsVeil)
				else
					(client setScript: preen)
				)
			)
		)
	)
)

(instance mariGetsVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: thrownMirror)
					(thrownMirror show: posn: 135 35)
				)
				(if local4
					(self changeState: 2)
				else
					(global184
						setLoop: 2
						setPri: 3
						setCycle: Fwd
						setMotion:
							MoveTo
							(+ (global184 x:) 45)
							(global184 y:)
							self
					)
				)
			)
			(1
				(global184
					setLoop: 3
					setMotion: MoveTo (- (global184 x:) 45) (global184 y:) self
				)
			)
			(2
				(fallingVeil dispose:)
				(global184 setLoop: 4 setPri: 11 setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(= local5 1)
				(global184 setLoop: 1 setCycle: 0)
				(fallingVeil setLoop: 8 posn: 128 40 init:)
				(= seconds 2)
			)
			(4
				(client setScript: 0 setScript: tossVeilDown)
			)
		)
	)
)

(instance tossVeilDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global184 setLoop: 1 setCycle: 0)
				(SetScore 0 0 5)
				(fallingVeil
					setLoop: 8
					posn: 128 40
					init:
					setStep: 3 1
					setCycle: Fwd
					setMotion: MoveTo 110 60 self
				)
			)
			(1
				(fallingVeil setStep: 3 2 setMotion: MoveTo 115 80 self)
			)
			(2
				(fallingVeil setStep: 3 2 setMotion: MoveTo 105 94 self)
				(gEgo loop: 1)
			)
			(3
				(fallingVeil setStep: 3 3 setMotion: MoveTo 108 96)
				(gEgo
					view: 68
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(4
				(fallingVeil dispose:)
				(gEgo get: 13) ; veil
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: Walk
				)
				(client setScript: 0)
				(if (IsFlag 315)
					(thrownMirror hide:)
					(global184 setScript: (ScriptID 56 2)) ; closeShutters
					(HandsOn)
				else
					(client setScript: preen)
				)
			)
		)
	)
)

(instance preen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thrownMirror hide:)
				(RedrawCast)
				(global184 setLoop: 7 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 10)
			)
			(1
				(gTObj talkCue: self)
				(localproc_0 157 42) ; "It is true! I am as beautiful as they say! Even more so!"
			)
			(2
				(Print 157 43) ; "Hmmph. And they say mirrors cannot lie. Hah!"
				(= cycles 2)
			)
			(3
				(global184 setScript: (ScriptID 56 2)) ; closeShutters
				(if (IsItemAt 13) ; veil
					(= local0 0)
				)
				(SetFlag 315)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

